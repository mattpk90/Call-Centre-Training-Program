/**
 * @(#)ProductsGUI.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductsGUI extends JFrame
{
	JMenu fileMenu = new JMenu("File");
	JMenu pageNav = new JMenu("Navigation");
	JMenu fileHelpMenu = new JMenu("Help");
	
	
	JMenuItem fileClose = new JMenuItem("Close");
	
	JMenuItem navHome = new JMenuItem("Home");
	JMenuItem navComplaints = new JMenuItem("Complaints");
	JMenuItem navJoining = new JMenuItem("Joining");
	JMenuItem navProblems = new JMenuItem("Common Problems");
	JMenuItem navCustDetails = new JMenuItem("Customer Details");
	
	JMenuItem helpFAQ = new JMenuItem("FAQ");
	JMenuItem helpGuide = new JMenuItem("System guide");
	JMenuItem helpSearch = new JMenuItem("Search");
	
	View v;
	ComplaintGUI cgui;
	JoiningGUI jgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;

	
	public ProductsGUI()
    { 		
    	this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);		
		this.setVisible(true);  	
    	this.setLayout(new GridLayout(2,1));
    	
    	NavigationListener navigationListener = new NavigationListener(); 
    	
    	
    	JButton homeButton = new JButton("Home");
		this.add(homeButton);
		homeButton.addActionListener(navigationListener);
		
		JButton newProdButton = new JButton("New Product");
		this.add(newProdButton);
		//newProdButton.addActionListener(navigationListener);
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
    	menuBar.add(fileMenu);
    	menuBar.add(pageNav);
    	menuBar.add(fileHelpMenu);
		
		//file menu
    	fileMenu.add(fileClose);
    	
    	//nav menu
    	pageNav.add(navHome);
    	pageNav.add(navComplaints);
    	pageNav.add(navJoining);
    	pageNav.add(navProblems);
    	pageNav.add(navCustDetails);
    	
    	navHome.addActionListener(navigationListener);
    	navComplaints.addActionListener(navigationListener);
    	navJoining.addActionListener(navigationListener);
    	navProblems.addActionListener(navigationListener);
    	navCustDetails.addActionListener(navigationListener);
    	
    	//help menu
    	fileHelpMenu.add(helpFAQ);
    	fileHelpMenu.add(helpGuide);
    	fileHelpMenu.add(helpSearch); 
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
			    	
                    dispose();
    			}
                if (e.getActionCommand().equals("Complaints")) {
                    cgui = new ComplaintGUI();
			    	cgui.createAndShowGUI();
                    
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
