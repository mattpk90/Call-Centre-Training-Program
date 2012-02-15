/**
 * @(#)ComplaintGUI.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ComplaintGUI
{	
	//page objects
	View v;
	ProductsGUI pgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	CustValidationGUI cvgui;
	
	static NavigationListener navigationListener;	
	static FetchCustHistListener fetchCustHistListener;
	static AddComplaintListener addComplaintListener;
	static ComplaintFocusListener complaintFocusListener;
	static JFrame frame;
	static JMenuBar menuBar;
	static JTextArea readOnlyTextArea, complaintTextArea;
	static JTextField custIdTxt;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    public ComplaintGUI()
    { 	   	
		//navigation inner class listener
    	navigationListener = new NavigationListener();  
    	fetchCustHistListener = new FetchCustHistListener();
    	addComplaintListener = new AddComplaintListener();	
    	complaintFocusListener = new ComplaintFocusListener();
    }
    
    
    public static void addComponentsToPane(Container pane)
    {      	  	  	
    	/*if (RIGHT_TO_LEFT)
    	{
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }*/
 
		
		//scroll pane
		JScrollPane complaintScrollPane;
		JScrollPane readOnlyScrollPane;
		
		//menus
		JMenu fileMenu = new JMenu("File");
		JMenu pageNav = new JMenu("Navigation");
		JMenu fileHelpMenu = new JMenu("Help");
		
		//menu items
		JMenuItem fileClose = new JMenuItem("Close");
		
		JMenuItem navHome = new JMenuItem("Home");
		JMenuItem navValidation = new JMenuItem("Customer Validation");
		JMenuItem navProducts = new JMenuItem("Products");
		JMenuItem navJoining = new JMenuItem("Joining");
		JMenuItem navProblems = new JMenuItem("Common Problems");
		JMenuItem navCustDetails = new JMenuItem("Customer Details");
		
		JMenuItem helpFAQ = new JMenuItem("FAQ");
		JMenuItem helpGuide = new JMenuItem("System guide");
		JMenuItem helpSearch = new JMenuItem("Search");

	    pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    if (shouldFill)
	    {	//maximum height, maximum width
	    	c.fill = GridBagConstraints.VERTICAL;		    
		    c.fill = GridBagConstraints.HORIZONTAL;
	    }
	    	    
	    
		//menu bar
		menuBar = new JMenuBar();
		pane.add(menuBar);
		//pane.setJMenuBar(menuBar);
    	menuBar.add(fileMenu);
    	menuBar.add(pageNav);
    	menuBar.add(fileHelpMenu);
		
		//file menu
    	fileMenu.add(fileClose);
    	
    	//nav menu
    	pageNav.add(navHome);
    	pageNav.add(navValidation);
    	pageNav.add(navProducts);
    	pageNav.add(navJoining);
    	pageNav.add(navProblems);
    	pageNav.add(navCustDetails);
    	
    	fileClose.addActionListener(navigationListener);
    	navHome.addActionListener(navigationListener);
    	navValidation.addActionListener(navigationListener);
    	navProducts.addActionListener(navigationListener);
    	navJoining.addActionListener(navigationListener);
    	navProblems.addActionListener(navigationListener);
    	navCustDetails.addActionListener(navigationListener);
    	
    	//help menu
    	fileHelpMenu.add(helpFAQ);
    	fileHelpMenu.add(helpGuide);
    	fileHelpMenu.add(helpSearch); 
    	
    	
    	//add menu
    	c.ipady = 15;
	    c.weightx = 0.5;
    	c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 0;
		c.gridheight = 1;
    	pane.add(menuBar, c);
    	//c.insets = new Insets(0,0,0,0);
    	//menuBar.addActionListener(navigationListener); 
    	
	 	//add buttons
    	JButton homeComplButton = new JButton("Home");
	    c.ipady = 20;
	    c.weightx = 0.0;
    	c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.insets = new Insets(0,0,0,0);
    	pane.add(homeComplButton, c);   
    	homeComplButton.addActionListener(navigationListener); 	
    	

		JLabel custIdLbl = new JLabel("Customer ID:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
    	pane.add(custIdLbl, c);
		//newComplButton.addActionListener(navigationListener);
		
		custIdTxt = new JTextField(10);
		custIdTxt.setFont(new Font("Serif", Font.ITALIC, 16));
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		//c.fill = GridBagConstraints.HORIZONTAL;
    	pane.add(custIdTxt, c);
		//newComplButton.addActionListener(navigationListener);

		
		JButton fetchCustHistButton = new JButton("Fetch Complaint History");
		//c.ipady = 20;
		c.weightx = 0.0;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
    	pane.add(fetchCustHistButton, c);
		fetchCustHistButton.addActionListener(fetchCustHistListener);
		
		
	    
	    //add text area
	    readOnlyTextArea = new JTextArea("Previous Complaints History", 10, 40);
	    readOnlyTextArea.setEditable(false);
		readOnlyTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		readOnlyTextArea.setLineWrap(true);
		readOnlyTextArea.setWrapStyleWord(true);
		
		readOnlyScrollPane = new JScrollPane(readOnlyTextArea);
		readOnlyScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//complaintScrollPane.setPreferredSize(new Dimension(400, 200));
		//c.fill = GridBagConstraints.VERTICAL;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		//c.ipady = 200;
		//c.ipadx = 200;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.insets = new Insets(0,0,10,0);
		pane.add(readOnlyScrollPane, c);
		//textArea.getDocument().addDocumentListener(this);
	    
	    
	    
	    
	    //add text area
	    complaintTextArea = new JTextArea("Add comments here.", 10, 40);
		complaintTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		complaintTextArea.setLineWrap(true);
		complaintTextArea.setWrapStyleWord(true);
		complaintTextArea.addFocusListener(complaintFocusListener);
		
		complaintScrollPane = new JScrollPane(complaintTextArea);
		complaintScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//complaintScrollPane.setPreferredSize(new Dimension(400, 200));
		//c.fill = GridBagConstraints.VERTICAL;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		//c.ipady = 200;
		//c.ipadx = 200;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
		pane.add(complaintScrollPane, c);
		//textArea.getDocument().addDocumentListener(this);
		
		
		JButton newComplButton = new JButton("Add Complaint");
		//c.ipady = 20;
		//c.weightx = 1;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
    	pane.add(newComplButton, c);
		newComplButton.addActionListener(addComplaintListener);

		
    }
    
    
    public static void createAndShowGUI() {
        //Create and set up the window. Set instantiation parameters.
        frame = new JFrame("Complaints");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
    	frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);			
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        //fetchCustHistButton.addActionListener(fetchCustHistListener);	
    }
    
    
    //event listeners
     class NavigationListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if (e.getActionCommand().equals("Home")) {                     
                    v = new View();	
			    	v.pack();
					v.setSize(300,300);
			    	
                    frame.dispose();
    			}
                if (e.getActionCommand().equals("Products")) {
                    pgui = new ProductsGUI();
			    	pgui.createAndShowGUI();
			    	
                    frame.dispose();
                }
                if (e.getActionCommand().equals("Joining")) {
                    jgui = new JoiningGUI();
			    	jgui.createAndShowGUI();
			    	
                    frame.dispose();
                }
                if (e.getActionCommand().equals("Common Problems")) {
                    pbgui = new ProblemsGUI();
			    	pbgui.pack();

                    frame.dispose();
                }
                if (e.getActionCommand().equals("Customer Details")) {
                    cdgui = new CustDetailsGUI();
			    	cdgui.createAndShowGUI();

                    frame.dispose();
                }
                if (e.getActionCommand().equals("Customer Validation")) 
            	{
                	cvgui = new CustValidationGUI();
					cvgui.createAndShowGUI();

                	frame.dispose();
            	}
                if (e.getActionCommand().equals("Close")) {
                    System.exit(0);
                }
    		}
    	}
    	
   
	class FetchCustHistListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
		
			String custId = custIdTxt.getText();
			Connection connection = View.getConnection();
			Statement st = null;
			ResultSet rs = null;
			
			String previousHistory = "";
			try
			{
				st = connection.createStatement();
				rs = st.executeQuery("SELECT DATE_FORMAT(dateTime, '%W %D %M %Y %H:%i') AS dateTime, complaint FROM complaints WHERE cust_id =" + custId + ";");

				boolean found = rs.next();
				
				if (!found)
				{
					readOnlyTextArea.setText("No Existing Complaint");
				}
				else
				{
					int recordCount = 0;
					while(rs.next())
					{
						recordCount++;
					}
					rs.first();
					for(int i = 0;i < (recordCount +1); i++)
					{
						previousHistory += rs.getString(1) + "\n" + rs.getString(2) + "\n\n";
						rs.next();
					}
					readOnlyTextArea.setText(previousHistory);
				}
			}
			catch(SQLException ex)
			{
				readOnlyTextArea.setText("Please Enter Customer ID.");
				ex.printStackTrace();
			}
		
		}
	}

	class AddComplaintListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			String complaintIn = complaintTextArea.getText();
			String previousComplaint = readOnlyTextArea.getText();
			String custId = custIdTxt.getText();
	    	//System.out.println("Cust ID:" + custId);
	    	
	    	
		    	//Database insert
		    	Connection connection = View.getConnection();
				Statement st = null;
				ResultSet rs = null;
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				Date date = new Date();
				String dateNow = dateFormat.format(date);
				try
				{
					st = connection.createStatement();
					String complaintSql = "INSERT INTO complaints (cust_id, dateTime, complaint) VALUES (" + custId + ",'" + dateNow + "','" + complaintIn + "')"; 
					st.executeUpdate(complaintSql);
					JOptionPane.showMessageDialog(null,"Complaint added!");
				}
				catch(SQLException ex)
				{
					readOnlyTextArea.setText("Please Enter Customer ID.");
					ex.printStackTrace();
				}
	    	
		}
		
	
	}
	
	  class ComplaintFocusListener implements FocusListener
     {
     	public void focusGained(FocusEvent e)
     	{
			complaintTextArea.setText("");
     	}
        public void focusLost(FocusEvent e) 
        {
       		 
    	}
     	
     	
     }
				
}
	     
     
