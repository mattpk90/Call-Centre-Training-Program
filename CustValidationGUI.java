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

public class CustValidationGUI
{
	View v;
	ComplaintGUI cgui;
	ProductsGUI pgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	
	static JFrame frame;
	static JMenuBar menuBar;
	
	static NavigationListener navigationListener;

	
	public CustValidationGUI()
    { 		 	
    	navigationListener = new NavigationListener(); 
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
    }
    
    
    public static void createAndShowGUI() {
        //Create and set up the window. Set instantiation parameters.
        frame = new JFrame("Customer Validation");
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
                if (e.getActionCommand().equals("Complaints")) {
                    cgui = new ComplaintGUI();
			    	cgui.createAndShowGUI();
                    
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
                if (e.getActionCommand().equals("Products")) {
                    pgui = new ProductsGUI();
			    	pgui.createAndShowGUI();

                    frame.dispose();
                }
                if (e.getActionCommand().equals("Customer Details")) {
                    cdgui = new CustDetailsGUI();
			    	cdgui.createAndShowGUI();

                    frame.dispose();
                }
                if (e.getActionCommand().equals("Close")) {
                System.exit(0);
            	}
    		}
    	}
	
}