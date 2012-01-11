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

public class ComplaintGUI
{	
	//page objects
	View v;
	ProductsGUI pgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	
	static NavigationListener navigationListener;	
	static JFrame frame;
	static JMenuBar menuBar;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
	
    public ComplaintGUI()
    { 	   	
		//navigation inner class listener
    	navigationListener = new NavigationListener();  	
    }
    
    
    public static void addComponentsToPane(Container pane)
    {      	  	  	
    	if (RIGHT_TO_LEFT)
    	{
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
 
        //text area
		JTextArea complaintTextArea;
		
		//scroll pane
		JScrollPane complaintScrollPane;
		
		//menus
		JMenu fileMenu = new JMenu("File");
		JMenu pageNav = new JMenu("Navigation");
		JMenu fileHelpMenu = new JMenu("Help");
		
		//menu items
		JMenuItem fileClose = new JMenuItem("Close");
		
		JMenuItem navHome = new JMenuItem("Home");
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
    	pageNav.add(navProducts);
    	pageNav.add(navJoining);
    	pageNav.add(navProblems);
    	pageNav.add(navCustDetails);
    	
    	navHome.addActionListener(navigationListener);
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
    	c.insets = new Insets(0,0,0,0);
    	//menuBar.addActionListener(navigationListener); 
    	
	 	//add buttons
    	JButton homeComplButton = new JButton("Home");
	    c.ipady = 20;
	    //c.weightx = 1;
    	c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
    	pane.add(homeComplButton, c);   
    	homeComplButton.addActionListener(navigationListener); 	
    	

		JLabel custIdLbl = new JLabel("Customer ID:");
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
    	pane.add(custIdLbl, c);
		//newComplButton.addActionListener(navigationListener);
		
		JTextField custIdTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,-205,0,287);
		//c.fill = GridBagConstraints.HORIZONTAL;
    	pane.add(custIdTxt, c);
		//newComplButton.addActionListener(navigationListener);
		
		
		JButton custIdGoButton = new JButton("Fetch Complaint History");
		//c.ipady = 20;
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,-205,0,287);
    	pane.add(custIdGoButton, c);
		//newComplButton.addActionListener(navigationListener);
		
		
	    
	    //add text area
	    complaintTextArea = new JTextArea("Add comments here.", 10, 30);
		complaintTextArea.setFont(new Font("Serif", Font.ITALIC, 16));
		complaintTextArea.setLineWrap(true);
		complaintTextArea.setWrapStyleWord(true);
		
		complaintScrollPane = new JScrollPane(complaintTextArea);
		complaintScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//complaintScrollPane.setPreferredSize(new Dimension(400, 200));
		//c.fill = GridBagConstraints.VERTICAL;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		//c.ipady = 200;
		c.ipadx = 200;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.gridheight = 0;
		c.insets = new Insets(0,0,0,0);
		pane.add(complaintScrollPane, c);
		//textArea.getDocument().addDocumentListener(this);
		
		JButton newComplButton = new JButton("Add Complaint");
		//c.ipady = 20;
		//c.weightx = 1;
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(290,-600,0,500);
    	pane.add(newComplButton, c);
		newComplButton.addActionListener(navigationListener);
		
 
	

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
			    	pgui.pack();
			    	
                    frame.dispose();
                }
                if (e.getActionCommand().equals("Joining")) {
                    jgui = new JoiningGUI();
			    	jgui.pack();
			    	
                    frame.dispose();
                }
                if (e.getActionCommand().equals("Common Problems")) {
                    pbgui = new ProblemsGUI();
			    	pbgui.pack();

                    frame.dispose();
                }
                if (e.getActionCommand().equals("Customer Details")) {
                    cdgui = new CustDetailsGUI();
			    	cdgui.pack();

                    frame.dispose();
                }
    		}
    	}
}