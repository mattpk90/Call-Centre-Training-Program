/**
 * @(#)CustDetailsGUI.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustDetailsGUI
{		
	static JFrame frame;
	static JMenuBar menuBar;
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    static NavigationListener navigationListener;
    
    static String[] secQuestionString = {"First pets name?", "Mothers maiden name?", "Favourite actor?"};
	
	View v;
	ComplaintGUI cgui;
	ProductsGUI pgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	
	public CustDetailsGUI()
    { 	   	
    	navigationListener = new NavigationListener();
    }
    
    
    public static void addComponentsToPane(Container pane)
    {      	  	  	
    	if (RIGHT_TO_LEFT)
    	{
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

		//menus
		JMenu fileMenu = new JMenu("File");
		JMenu pageNav = new JMenu("Navigation");
		JMenu fileHelpMenu = new JMenu("Help");
		
		//menu items
		JMenuItem fileClose = new JMenuItem("Close");
		
		JMenuItem navHome = new JMenuItem("Home");
		JMenuItem navProducts = new JMenuItem("Products");
		JMenuItem navComplaints = new JMenuItem("Complaints");
		JMenuItem navJoining = new JMenuItem("Joining");
		JMenuItem navProblems = new JMenuItem("Common Problems");
		
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
    	pageNav.add(navComplaints);
    	
    	fileClose.addActionListener(navigationListener);
    	navHome.addActionListener(navigationListener);
    	navProducts.addActionListener(navigationListener);
    	navJoining.addActionListener(navigationListener);
    	navProblems.addActionListener(navigationListener);
    	navComplaints.addActionListener(navigationListener);
    	
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
		c.gridwidth = 3;
		c.gridheight = 1;
		c.insets = new Insets(0,0,10,0);
    	pane.add(homeComplButton, c);   
    	homeComplButton.addActionListener(navigationListener);
    	
    	
    	JLabel custIdLbl = new JLabel("Customer ID:");
		//c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,15,0);
    	pane.add(custIdLbl, c);
		
		
		JTextField custIdTxt = new JTextField("");
		//c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,15,40);
    	pane.add(custIdTxt, c);
		
		
		JButton fetchCustDetailsButton = new JButton("Fetch Customer Details");
		//c.ipady = 20;
		c.weightx = 0.0;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,-35,15,0);
    	pane.add(fetchCustDetailsButton, c);
		//fetchCustHistButton.addActionListener(fetchCustHistListener);
		
		
		
		
		///////////////customer details fields/////////////////
		//First Name
		JLabel fNameLbl = new JLabel("First Name:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
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
		
		
		//Surname
		JLabel sNameLbl = new JLabel("Surname:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(sNameLbl, c);
		
		JTextField sNameTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(sNameTxt, c);
		
		
		//House Number
		JLabel houseNumLbl = new JLabel("House Number:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(houseNumLbl, c);
		
		JTextField houseNumTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(houseNumTxt, c);
		
		
		//Street Name
		JLabel streetNameLbl = new JLabel("Street Name:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(streetNameLbl, c);
		
		JTextField streetNameTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(streetNameTxt, c);
		
		
		//City
		JLabel cityLbl = new JLabel("City:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(cityLbl, c);
		
		JTextField cityTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(cityTxt, c);
		
		
		//County
		JLabel countyLbl = new JLabel("County:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(countyLbl, c);
		
		JTextField countyTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(countyTxt, c);
		
		
		//Post Code
		JLabel postCodeLbl = new JLabel("Post Code:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(postCodeLbl, c);
		
		JTextField postCodeTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(postCodeTxt, c);
		
		
		//Telephone No.
		JLabel phoneNumLbl = new JLabel("Telephone Number: ");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(phoneNumLbl, c);
		
		JTextField phoneNumTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(phoneNumTxt, c);
		
		
		//Email Address
		JLabel emailLbl = new JLabel("Email Address:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 11;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(emailLbl, c);
		
		JTextField emailTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(emailTxt, c);
		
		
		//Security Question
		JLabel secQuestionLbl = new JLabel("Security Question:");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 12;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(secQuestionLbl, c);
		
		JComboBox secQuestionCombo = new JComboBox(secQuestionString);
		//c.ipadx = 100;
		c.weightx = 0.0;
		c.gridx = 1;
		c.gridy = 12;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,100,0,0);
    	pane.add(secQuestionCombo, c);
		
		
		//Security Answer
		JLabel secAnswerLbl = new JLabel("Security Answer:");
		c.ipady = 20;
		c.weightx = 0.1;
		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(secAnswerLbl, c);
		
		JTextField secAnswerTxt = new JTextField("");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 13;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.insets = new Insets(0,0,0,0);
    	pane.add(secAnswerTxt, c);
    	
    	//button
    	JButton updateDetailsButton = new JButton("Update");
	    c.ipady = 20;
	    c.weightx = 0.0;
    	c.gridx = 0;
		c.gridy = 14;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.insets = new Insets(10,0,0,0);
    	pane.add(updateDetailsButton, c);   
    	//homeComplButton.addActionListener(navigationListener);
    }
    
    
    public static void createAndShowGUI() {
        //Create and set up the window. Set instantiation parameters.
        frame = new JFrame("Customer Details");
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
                if (e.getActionCommand().equals("Close")) {
                    System.exit(0);
                }
    		}
    	}
	
	
	
	
	
	
}