/**
 * @(#)View.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class View extends JFrame
{
	//add menu and menu items
	JMenu fileMenu = new JMenu("File");
	JMenu pageNav = new JMenu("Navigation");
	JMenu fileHelpMenu = new JMenu("Help");
	
	
	JMenuItem fileClose = new JMenuItem("Close");
	
	JMenuItem navComplaints = new JMenuItem("Complaints");
	JMenuItem navProducts = new JMenuItem("Products");
	JMenuItem navJoining = new JMenuItem("Joining");
	JMenuItem navProblems = new JMenuItem("Common Problems");
	JMenuItem navCustDetails = new JMenuItem("Customer Details");
	
	JMenuItem helpFAQ = new JMenuItem("FAQ");
	JMenuItem helpGuide = new JMenuItem("System guide");
	JMenuItem helpSearch = new JMenuItem("Search");
	
	
	ComplaintGUI cgui;
	ProductsGUI pgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	
    public View()
    {  	
    	this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);  	
    	this.setLayout(new GridLayout(5,5));
    	
    	//listener object
    	NavigationListener navigationListener = new NavigationListener();
	
    	//menu bar
    	JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
    	menuBar.add(fileMenu);
    	menuBar.add(pageNav);
    	menuBar.add(fileHelpMenu);
    	
    	//file menu
    	fileMenu.add(fileClose);
    	
    	//nav menu
    	pageNav.add(navComplaints);
    	pageNav.add(navProducts);
    	pageNav.add(navJoining);
    	pageNav.add(navProblems);
    	pageNav.add(navCustDetails);
    	
    	//add listeners to menu items
    	navComplaints.addActionListener(navigationListener);
    	navProducts.addActionListener(navigationListener);
    	navJoining.addActionListener(navigationListener);
    	navProblems.addActionListener(navigationListener);
    	navCustDetails.addActionListener(navigationListener);
    	
    	//help menu
    	fileHelpMenu.add(helpFAQ);
    	fileHelpMenu.add(helpGuide);
    	fileHelpMenu.add(helpSearch); 
    	  
    		
    	
    	JButton complaintsButton = new JButton("Complaints");
		this.add(complaintsButton);	
		complaintsButton.addActionListener(navigationListener);
		
		JButton prodButton = new JButton("Products");
		this.add(prodButton);
		prodButton.addActionListener(navigationListener);
		
		JButton joinButton = new JButton("Joining");
		this.add(joinButton);
		joinButton.addActionListener(navigationListener);
		
		JButton commonButton = new JButton("Common Problems");
		this.add(commonButton);
		commonButton.addActionListener(navigationListener);
		
		JButton custDetailsButton = new JButton("Customer Details");
		this.add(custDetailsButton);
		custDetailsButton.addActionListener(navigationListener);
		
	}
    
    
    //event listeners
    class NavigationListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			if (e.getActionCommand().equals("Complaints")) {                     
                    cgui = new ComplaintGUI();
                    cgui.createAndShowGUI();	    	
			    	
                    dispose();
    			}
                if (e.getActionCommand().equals("Products")) {
                    pgui = new ProductsGUI();
			    	pgui.pack();

                    dispose();
                }
                if (e.getActionCommand().equals("Joining")) {
                    jgui = new JoiningGUI();
			    	jgui.pack();

                    dispose();
                }
                if (e.getActionCommand().equals("Common Problems")) {
                    pbgui = new ProblemsGUI();
			    	pbgui.pack();

                    dispose();
                }
                if (e.getActionCommand().equals("Customer Details")) {
                    cdgui = new CustDetailsGUI();
			    	cdgui.pack();

                    dispose();
                }
    		}
    	}
    	
}