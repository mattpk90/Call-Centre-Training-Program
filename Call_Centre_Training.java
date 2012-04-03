/**
* @(#)Call_Centre_Training.java
*
* Call Centre Training Application
*
* @authors: Robbie Aftab, Ash Ellis, Steve Glasspool, Matt Kennedy
*/

import javax.swing.*;
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

public class Call_Centre_Training 
{
    public static void main(String[] args) throws Exception
    {
        // Set System L&F
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	
    	//View v = new View();	
		//v.createAndShowGUI();
		
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
			conn = DriverManager.getConnection("jdbc:mysql://instance10055.db.xeround.com:6860/bgTraining?user=bgAdmin&password=superuser");
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