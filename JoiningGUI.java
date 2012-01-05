/**
 * @(#)JoiningGUI.java
 *
 *
 * @author 
 * @version 1.00 2011/11/17
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class JoiningGUI extends JFrame
{
	JMenu fileMenu = new JMenu("File");
	JMenu pageNav = new JMenu("Navigation");
	JMenu fileHelpMenu = new JMenu("Help");
	

	JMenuItem fileClose = new JMenuItem("Close");
	
	JMenuItem navHome = new JMenuItem("Home");
	JMenuItem navProducts = new JMenuItem("Products");
	JMenuItem navComplaints = new JMenuItem("Complaints");
	JMenuItem navProblems = new JMenuItem("Common Problems");
	JMenuItem navCustDetails = new JMenuItem("Customer Details");
	
	JMenuItem helpFAQ = new JMenuItem("FAQ");
	JMenuItem helpGuide = new JMenuItem("System guide");
	JMenuItem helpSearch = new JMenuItem("Search");
	
	
	JTextField fNameText, sNameText, houseNumberText, streetNameText, cityText, 
		countyText, postcodeText, phoneText, emailText, secAnsText;
	JLabel emptyLbl, fNameLbl, sNameLbl, houseNumberLbl, streetNameLbl, cityLbl, 
		countyLbl, postcodeLbl, phoneLbl, emailLbl, secQuestionLbl, secAnsLbl;
	
	//dropdown box
	String[] secQuestionString = {"First pet's name?", "Mother's maiden name?", "Favourite actor?"};
	JComboBox secQuestionCombo;
	
	//buttons
	JButton homeButton = new JButton("Home");
	JButton addCustButton = new JButton("Add Customer");
	JButton resetButton = new JButton("Reset");
	
	
	View v;
	ComplaintGUI cgui;
	ProductsGUI pgui;
	ProblemsGUI pbgui;
	CustDetailsGUI cdgui;
	
	public JoiningGUI()
    { 	
    	
    	this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);		
		this.setVisible(true);  	
    	this.setLayout(new GridLayout(13,2));
    	
    	//navigation inner class listener
    	NavigationListener navigationListener = new NavigationListener();   
    	AddCustomerListener addCustomerListener = new AddCustomerListener();
    	ResetListener resetListener = new ResetListener();
    	
    	
    	//button listeners
		homeButton.addActionListener(navigationListener);	
		addCustButton.addActionListener(addCustomerListener);	
		resetButton.addActionListener(resetListener);
		
		
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
    	pageNav.add(navProducts);
    	pageNav.add(navProblems);
    	pageNav.add(navCustDetails);
    	
    	navHome.addActionListener(navigationListener);
    	navComplaints.addActionListener(navigationListener);
    	navProducts.addActionListener(navigationListener);
    	navProblems.addActionListener(navigationListener);
    	navCustDetails.addActionListener(navigationListener);
    	
    	//help menu
    	fileHelpMenu.add(helpFAQ);
    	fileHelpMenu.add(helpGuide);
    	fileHelpMenu.add(helpSearch); 
    	
    	//labels and text fields 
    	emptyLbl = new JLabel("");
    		   	
    	fNameLbl = new JLabel("First Name:");
    	fNameText = new JTextField(20);
    	
    	sNameLbl = new JLabel("Surname:");
    	sNameText = new JTextField(20);
    	
    	houseNumberLbl = new JLabel("House Number:");
    	houseNumberText = new JTextField(20);
    	
    	streetNameLbl = new JLabel("Street Name:");
    	streetNameText = new JTextField(20);
    	
    	cityLbl = new JLabel("City:");
    	cityText = new JTextField(20);
    	
    	countyLbl = new JLabel("County:");
    	countyText = new JTextField(20);
    	
    	postcodeLbl = new JLabel("Postcode:");
    	postcodeText = new JTextField(20);
    	
    	phoneLbl = new JLabel("Phone Number:");
    	phoneText = new JTextField(20);
    	
    	emailLbl = new JLabel("E-mail:");
    	emailText = new JTextField(20);
    	
    	secQuestionLbl = new JLabel("Select Security Question:");
    	secQuestionCombo = new JComboBox(secQuestionString);
    	secQuestionCombo.setSelectedIndex(0);
    	
    	secAnsLbl = new JLabel("Security Answer:");
    	secAnsText = new JTextField(20);


    	this.add(homeButton);
    	this.add(emptyLbl);
    	
    	this.add(fNameLbl);
        this.add(fNameText);
        
        this.add(sNameLbl);
        this.add(sNameText);
        
        this.add(houseNumberLbl);
        this.add(houseNumberText);
        
        this.add(streetNameLbl);
        this.add(streetNameText);
        
        this.add(cityLbl);
        this.add(cityText);
        
        this.add(countyLbl);
        this.add(countyText);
        
        this.add(postcodeLbl);
        this.add(postcodeText);
        
        this.add(phoneLbl);
        this.add(phoneText);
        
        this.add(emailLbl);
        this.add(emailText);
        
      	this.add(secQuestionLbl); 
        this.add(secQuestionCombo);
        
        this.add(secAnsLbl);
        this.add(secAnsText);
        
    	this.add(addCustButton);
    	this.add(resetButton);
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
                /*if (e.getActionCommand().equals("Complaints")) {
                    cgui = new ComplaintGUI();
			    	cgui.pack();
                    
                    dispose();
                }*/
                if (e.getActionCommand().equals("Products")) {
                    pgui = new ProductsGUI();
			    	pgui.pack();

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
    	
    class AddCustomerListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ev)
    		{
    			String fNameIn = fNameText.getText();
		    	String sNameIn = sNameText.getText();
		    	String houseNumIn = houseNumberText.getText();
		    	String streetNameIn = streetNameText.getText();
		    	String cityIn = cityText.getText();
		    	String countyIn = countyText.getText();
		    	String postcodeIn = postcodeText.getText();
		    	String phoneIn = phoneText.getText();
		    	String emailIn = emailText.getText();
		    	String secAnswerIn = secAnsText.getText();
		    	
		        System.out.println("Customer added. Name: " + fNameIn + "  " + sNameIn + 
		        						" Address: " + houseNumIn + " " + streetNameIn + ", " +
		            				   cityIn + ", " + countyIn + ", " + postcodeIn + 
		            				   	" Contact Details: " + emailIn + ", " + phoneIn +
		            				   		" Security Answer: " + secAnswerIn);
		        //System.exit(0);
		        
				fNameText.setText("");
		    	sNameText.setText("");
		    	houseNumberText.setText("");
		    	streetNameText.setText("");
		    	cityText.setText("");
		    	countyText.setText("");
		    	postcodeText.setText("");
		    	phoneText.setText("");
		    	emailText.setText("");
		    	secAnsText.setText("");
    		}
    	}
    	
    	class ResetListener implements ActionListener
    	{
    		public void actionPerformed(ActionEvent ev)
    		{
				fNameText.setText("");
		    	sNameText.setText("");
		    	houseNumberText.setText("");
		    	streetNameText.setText("");
		    	cityText.setText("");
		    	countyText.setText("");
		    	postcodeText.setText("");
		    	phoneText.setText("");
		    	emailText.setText("");
		    	secAnsText.setText("");
    		}
    	}
	
}
