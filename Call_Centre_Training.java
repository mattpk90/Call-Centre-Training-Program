/**
* @(#)Call_Centre_Training.java
*
* Call Centre Training Application
*
* @authors: Robbie Aftab, Ash Ellis, Steve Glasspool, Matt Kennedy
*/

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.sql.*;


public class Call_Centre_Training 
{
	static boolean inUniversity = true;
	static boolean initDone = false;
	
    public static void main(String[] args) throws Exception
    {
        // Set System L&F
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	
    	//View v = new View();	
		//v.createAndShowGUI();
		String fileLocation = "logo.jpg";
	    ImageIcon img = new ImageIcon(View.class.getResource("logo.jpg"));
	    JOptionPane.showMessageDialog(null, "Welcome to the British Gas call centre training program \nPress Ok to continue \n\nDeveloped by Robbie Aftab (Q08264228), Ashley Ellis (Q09047930)\nSteve Glasspool (Q09014438) & Matt Kennedy (Q08049351)  ","British Gas call centre training program",1, img);

		CallLogView c = new CallLogView();
		c.createAndShowGUI();
    }
    
     //This is the class which is called for every database connection
     public static Connection getConnection() 
     {
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://edward.solent.ac.uk:3306/ssd1?user=iaftab&password=rUg9ne4P");

		}
		catch(SQLException ex)
		{
			//This means we aren't in the university network.
			ex.printStackTrace();
			inUniversity = false;
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		
		if(!inUniversity)
		{
			try
			{
			conn = DriverManager.getConnection("jdbc:mysql://instance10055.db.xeround.com:6860/bgTraining?user=bgAdmin&password=superuser");
			}catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		return conn;
	}
}