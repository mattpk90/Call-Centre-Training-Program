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
    	// Get the default toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Get the current screen size
		Dimension scrnsize = toolkit.getScreenSize();
		double width = (scrnsize.getWidth() / 2) - 150;
		double height = (scrnsize.getHeight() / 2) - 150;
		System.out.println(width);
		System.out.println(height);

    	
     this.setResizable(false);
     this.setLocation((int)width,(int)height);
	 //this.setLocationRelativeTo(null);
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
     fileClose.addActionListener(navigationListener);
     
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
					pgui.createAndShowGUI();

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
					cdgui.createAndShowGUI();

                    dispose();
                }
                if (e.getActionCommand().equals("Close")) {
                    System.exit(0);
                }
     }
     }
     //This is the class which is called for every database connection
     public static Connection getConnection() {
Connection conn = null;
try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bgtraining","root","");
}
catch(SQLException ex)
{
ex.printStackTrace();
}
catch(ClassNotFoundException ex)
{
ex.printStackTrace();
}
return conn;
}
    
}