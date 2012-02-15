/**
 * @(#)Call_Centre_Training.java
 *
 * Call_Centre_Training application
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.io.*;

public class Call_Centre_Training 
{
    public static void main(String[] args) throws Exception
    {
    	View v = new View();	
		v.pack();
		v.setSize(300,300);
		
		CallLogView c = new CallLogView();
		c.createAndShowGUI();
		//c.setSize(300,500);
    }
}