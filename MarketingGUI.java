/**
 * @(#)ProblemsGUI.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MarketingGUI
{
	static JFrame frame;
	static JMenuBar menuBar;
	
	static NavigationListener navigationListener;
	
	View v;
	ComplaintGUI cgui;
	ProductsGUI pgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	JoiningGUI jgui;
	CustValidationGUI cvgui;
	
	public MarketingGUI()
    { 	
    	//navigation inner class listener
    	navigationListener = new NavigationListener();
    }
    
    
    public static void addComponentsToPane(Container pane)
    {      	  	  			
		//menus
		JMenu fileMenu = new JMenu("File");
		JMenu pageNav = new JMenu("Navigation");
		JMenu fileHelpMenu = new JMenu("Help");
		
		//menu items
		JMenuItem fileClose = new JMenuItem("Close");
		
		JMenuItem navHome = new JMenuItem("Home");
		JMenuItem navValidation = new JMenuItem("Customer Validation");
		JMenuItem navProducts = new JMenuItem("Products");
		JMenuItem navComplaints = new JMenuItem("Complaints");
		JMenuItem navJoining = new JMenuItem("Joining");
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
    	pageNav.add(navComplaints);
    	pageNav.add(navJoining);
    	pageNav.add(navCustDetails);
    	
    	fileClose.addActionListener(navigationListener);
    	navHome.addActionListener(navigationListener);
    	navValidation.addActionListener(navigationListener);
    	navProducts.addActionListener(navigationListener);
    	navComplaints.addActionListener(navigationListener);
    	navJoining.addActionListener(navigationListener);
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
		c.fill = GridBagConstraints.HORIZONTAL;
    	pane.add(menuBar, c);
    	//c.insets = new Insets(0,0,0,0);
    	//menuBar.addActionListener(navigationListener); 
    	
	 	
    	JButton homeComplButton = new JButton("Home");
	    c.ipady = 20;
	    c.weightx = 0.0;
    	c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 0;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.insets = new Insets(0,0,0,0);
    	pane.add(homeComplButton, c);   
    	homeComplButton.addActionListener(navigationListener); 	
    	

		///////////////customer details fields/////////////////
		//First Name
		JLabel fNameLbl = new JLabel("First Name:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,10,0,10);
    	pane.add(fNameLbl, c);
		
		JTextField fNameTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(fNameTxt, c);
		
    }
    
    
    public static void createAndShowGUI() {
        //Create and set up the window. Set instantiation parameters.
        frame = new JFrame("Marketing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
    	frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);			
 
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
			    	v.createAndShowGUI();
			    	
                    frame.dispose();
    			}
    			if (e.getActionCommand().equals("Customer Validation")) 
            	{
                	cvgui = new CustValidationGUI();
					cvgui.createAndShowGUI();

                	frame.dispose();
            	}
                if (e.getActionCommand().equals("Complaints")) {
                    cgui = new ComplaintGUI();
			    	cgui.createAndShowGUI();
                    
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
                if (e.getActionCommand().equals("Customer Details")) {
                    cdgui = new CustDetailsGUI();
			    	cdgui.createAndShowGUI();

                    frame.dispose();
                }
    		}
    	}
	
	
	
	
	
	
}
