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


public class CallLogView extends JFrame
{
	
	long start, now;
	
	public CallLogView()
	{
		 this.setResizable(false);
		 this.setLocation(50,50);
		 this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		 this.setVisible(true);
	     this.setLayout(new GridLayout(2,2));
		
		CallLogListener callLogListener = new CallLogListener();
		
	    JButton startButton = new JButton("Start call");
		this.add(startButton);
		startButton.addActionListener(callLogListener);
		
		JButton endButton = new JButton("End call");
		this.add(endButton);
		endButton.addActionListener(callLogListener);
		
	}
	class CallLogListener implements ActionListener
     {
	     public void actionPerformed(ActionEvent e)
	     {
	     	if (e.getActionCommand().equals("Start call")) 
     		{
				System.out.println("Calling startTimer()");
				startTimer();
 			}
            if (e.getActionCommand().equals("End call")) 
            {
				System.out.println(elapsedTime());
            }
	     }
     }
    public void startTimer()
    {   
   		start = System.currentTimeMillis();
    }
    
    public long elapsedTime()
    {
       now = System.currentTimeMillis();
       return (now - start) / 1000;
    }
}