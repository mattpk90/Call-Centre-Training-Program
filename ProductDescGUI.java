import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class ProductDescGUI
{
	static JFrame frame;
	static JButton testButton;
	
	public ProductDescGUI()
	{		
		
	}	

	 
	 public static void addComponentsToPane(Container pane)
    {  
    	frame.setLocation(50,100);
    	
    	pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
    	    	  	  	
		testButton = new JButton("Hi");
		c.ipady = 20;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0,0,0,0);
		pane.add(testButton, c);
    }
    
    
    public static void createAndShowGUI() {
        //Create and set up the window. Set instantiation parameters.
        frame = new JFrame("Product Descriptions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,500);
        //frame.setLocation(50,50);
        	
    	frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);			
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}