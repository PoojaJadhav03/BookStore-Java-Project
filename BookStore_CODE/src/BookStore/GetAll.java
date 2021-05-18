package BookStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java .util.*;
import java.util.Date;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class GetAll extends JFrame 
{
	// frame 
  
	Map<Integer,String> map1 = new HashMap<Integer,String>();
	Map<Integer,String> map2 = new HashMap<Integer,String>();
	
    // label to display text 
    static JLabel label1; 

	    
	
       public GetAll() throws IOException, ClassNotFoundException, SQLException
        {	
    	   
    	// Database connectivity

  	    Class.forName("com.mysql.jdbc.Driver");  
  	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Tina");
  		System.out.println("Connection Established");
    	
    	  
    	   
         JFrame  mainframe = new JFrame("E Book Store");
         mainframe.getContentPane().setBackground(Color.BLACK);
         
      
        JFrame user2frame = new JFrame("BookStore Activity");
        JFrame  registrframe = new JFrame("Register Activity");
        JPanel	contentPanebook = new JPanel();
        JPanel	regrPane = new JPanel();
        // Label 1 for headline 
         JLabel jUserName = new JLabel("Welcome  To  BookStore " , JLabel.CENTER);
         jUserName.setVerticalAlignment(JLabel.TOP);
         jUserName.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
         jUserName.setForeground(Color.BLUE);
        
        // Admin Button 
        JButton admin = new JButton("Admin"); 
 		admin.setFont(new Font("Arial", Font.BOLD, 30)); 
 	   // admin.setVerticalAlignment(admin.LEFT);
 		admin.setBackground(Color.WHITE);
 		admin.setForeground(Color.BLACK);
 		admin.setSize(200, 50); 
 		admin.setLocation(100, 200); 
 		mainframe.add(admin); 
 		
 		// User button 
 		
 		JButton user = new JButton("User"); 
		user.setFont(new Font("Arial", Font.BOLD, 30)); 
		user.setBackground(Color.WHITE);
 		user.setForeground(Color.BLACK);
		user.setSize(200, 50); 
		user.setLocation(100, 300); 
		mainframe.add(user); 
		
		
		user.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		
				   
		         JFrame  mainframe2 = new JFrame("User-Acitivity");
		         mainframe2.getContentPane().setBackground(Color.BLACK);
		         
		        // Label 1 for headline 
		         JLabel jUserName = new JLabel("User Authorization " , JLabel.CENTER);
		         jUserName.setVerticalAlignment(JLabel.TOP);
		         jUserName.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
		         jUserName.setForeground(Color.BLUE);
		        
		        // login Button 
		        JButton login = new JButton("Login"); 
		 		login.setFont(new Font("Arial", Font.BOLD, 30)); 
		 	   // admin.setVerticalAlignment(admin.LEFT);
		 		login.setBackground(Color.WHITE);
		 		login.setForeground(Color.BLACK);
		 		login.setSize(200, 50); 
		 		login.setLocation(100, 200); 
		 		mainframe2.add(login); 
		 		
		 		
		 		login.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JFrame  loginframe = new JFrame("Login Activity");
						setBounds(450, 190, 1014, 597);
						setResizable(false);
						JPanel	loginPane = new JPanel();
						loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						setContentPane(loginPane);
						loginPane.setBackground(Color.BLACK);
						loginPane.setLayout(null);
						
						
						JLabel lblNewUserlogin = new JLabel("User Login ");
						lblNewUserlogin.setFont(new Font("Times New Roman", Font.BOLD, 42));
						lblNewUserlogin.setForeground(Color.BLUE);
						lblNewUserlogin.setBounds(362, 52, 400, 50);
						loginPane.add(lblNewUserlogin);
						
				
						// User Id 
         
						JLabel lbluserid = new JLabel("Enter User ID :  ");
						lbluserid .setFont(new Font("Tahoma", Font.PLAIN, 20));
						lbluserid .setBounds(58, 152, 200, 43);
						//99,43
						lbluserid .setForeground(Color.WHITE);
						loginPane.add(lbluserid );

						// User Name
      
						JLabel lblusername = new JLabel("Enter User Name : ");
						 lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
						 lblusername.setBounds(58, 243, 400, 43);
						 lblusername.setForeground(Color.WHITE);
						 loginPane.add(lblusername);
						
						// Password
			
						JLabel lblpassword = new JLabel("Password : ");
						lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblpassword.setBounds(58, 324, 300, 43);
						lblpassword.setForeground(Color.WHITE);
						loginPane.add(lblpassword);
						
						
						// Text-field
						
						JTextField useridfield = new JTextField();                 // user id
						useridfield .setFont(new Font("Tahoma", Font.PLAIN, 32));
						useridfield .setBounds(250, 151, 250, 50);
						loginPane.add(useridfield );
						useridfield .setColumns(10);
						
						JTextField	usernamefield = new JTextField();                    // user name
						usernamefield.setFont(new Font("Tahoma", Font.PLAIN, 32));
						usernamefield.setBounds(250, 235, 250, 50);
						loginPane.add(usernamefield);
						usernamefield.setColumns(10);
						
						
						 JTextField passwordfield = new JTextField();                            // password 
						 passwordfield.setFont(new Font("Tahoma", Font.PLAIN, 32));
						 passwordfield.setBounds(250, 320, 250, 50);
						 loginPane.add( passwordfield);
						 passwordfield.setColumns(10);
						
						 
						 

						 JButton loginButton = new JButton("Login");    
						 loginButton.setFont(new Font("Tahoma", Font.BOLD, 26));
						 loginButton.setBounds(802, 447, 259, 74);
						 loginButton.setForeground(Color.BLACK);
						 loginButton.setBackground(Color.WHITE);
						 loginPane.add(loginButton);
						 
						 
						 loginButton.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									
						
									
					   try
					   {

					String userid   = useridfield.getText();  //1
					String username = usernamefield.getText(); //2
				  	String password = passwordfield.getText(); //3
					
					   						   
					      Statement stmtlogin  = con.createStatement(); 
					     String  loginquery  = "select  UserId, UserName from registr WHERE UserId = '" +  userid +  
			                                    "' AND UserName = '" + username + "' AND  Password = '"+password  + "'"; 
			            ResultSet rs = stmtlogin.executeQuery(loginquery); 
			            
			            
			            if (rs.next()) {
	                  
						
	                        JOptionPane.showMessageDialog(  loginButton, "You have successfully logged in");
	                         
	                         
	                    } else
	                    {
	                        JOptionPane.showMessageDialog( loginButton, "Wrong Username & Password");
	                    }
			         
			        	user2frame.setVisible(true);
	                    
			            
			        } 
			        catch(Exception exception1) 
			        { 
			        	  JOptionPane.showMessageDialog( loginButton, "Error while Login");
			           
			        } 
									
								}
							});
						 
						 
					      JButton resetButton = new JButton("RESET");    
					      resetButton.setFont(new Font("Tahoma", Font.BOLD, 26));
					      resetButton.setBounds(802, 200, 259, 74);
					      resetButton.setForeground(Color.BLACK);
					      resetButton.setBackground(Color.WHITE);
					      loginPane.add(resetButton);
					      resetButton.addActionListener(this);
					      
					     
					    /*  JButton regme = new JButton("Register Here!");    
					      regme.setFont(new Font("Tahoma", Font.BOLD, 26));
					      regme.setBounds(802, 700, 259, 74);
					      regme.setForeground(Color.BLACK);
					      regme.setBackground(Color.WHITE);
					      loginPane.add(regme);
					      regme.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									registrframe.setVisible(true);
								//	registrframe.getContentPane().add(registrframe);
									  
;
								}
							});
						*/
						
					      loginframe.add(loginPane);
                          loginframe.setSize(1000, 1000);   // setting width and height for frame
                          loginframe.setVisible(true);
					
					}
		 		
				});
		 		
		 		
		 		
		 		
		 		
		 		// User button 
		 		
		 		JButton regr = new JButton("Register"); 
		 		regr.setFont(new Font("Arial", Font.BOLD, 30)); 
		 		regr.setBackground(Color.WHITE);
		 		regr.setForeground(Color.BLACK);
		 		regr.setSize(200, 50); 
		 		regr.setLocation(100, 300); 
				mainframe2.add(regr); 
				
				regr.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
				
								JFrame  registrframe = new JFrame("Register Activity");
								registrframe .setBounds(450, 190, 1014, 597);
								registrframe .setResizable(false);
								
								regrPane.setBorder(new EmptyBorder(5, 5, 5, 5));
							    setContentPane(regrPane);
							    regrPane.setBackground(Color.BLACK);
							    regrPane.setLayout(null);
		     
		
								JLabel lblNewUserRegister = new JLabel("User Registration ");
								lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
								lblNewUserRegister.setForeground(Color.BLUE);
								lblNewUserRegister.setBounds(362, 52, 400, 50);
								// registrframe.add(lblNewUserRegister);
								regrPane.add(lblNewUserRegister);


								// User Id 
                 
								JLabel lbluserid = new JLabel("Enter User ID :  ");
								lbluserid .setFont(new Font("Tahoma", Font.PLAIN, 20));
								lbluserid .setBounds(58, 152, 200, 43);
								//99,43
								lbluserid .setForeground(Color.WHITE);
								// registrframe.add(lbluserid);
								regrPane.add(lbluserid );

								// User Name
              
								JLabel lblusername = new JLabel("Enter User Name : ");
								 lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
								 lblusername.setBounds(58, 243, 400, 43);
								 lblusername.setForeground(Color.WHITE);
								 //registrframe.add(lblusername);
								 regrPane.add(lblusername);
								
								// Password
					
								JLabel lblpassword = new JLabel("Create Password : ");
								lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
								lblpassword.setBounds(58, 324, 300, 43);
								lblpassword.setForeground(Color.WHITE);
								// registrframe.add(lblpassword);
								regrPane.add(lblpassword);
								
								// Full Name
								 JLabel lblfullname = new JLabel(" Enter Full Name : ");
								 lblfullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
								 lblfullname.setBounds(58,400,300,43);
								// lblfullname.setBounds(542, 159, 110, 29);
								 lblfullname.setForeground(Color.WHITE);
								 //registrframe.add(lblfullname);
								 regrPane.add(lblfullname);
								 
								 
								 // mail id
								    JLabel lbmailid = new JLabel("Enter Mail Id :");
								    lbmailid.setFont(new Font("Tahoma", Font.PLAIN, 20));
								    lbmailid.setBounds(58, 500, 300, 43);
								    lbmailid.setForeground(Color.WHITE);
								    //registrframe.add(lbmailid);
								    regrPane.add(lbmailid); 
					
					
					              // 
					                JLabel lblMobileNumber = new JLabel("Enter Mobile No :");
					                lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
					                lblMobileNumber.setBounds(58, 570,300, 43);
					                lblMobileNumber.setForeground(Color.WHITE);
					                //registrframe.add(lblMobileNumber);
					                regrPane.add(lblMobileNumber);
					             
					                 JLabel lblage = new JLabel("Enter Age  :");
					                 lblage.setFont(new Font("Tahoma", Font.PLAIN, 20));
					                 lblage.setBounds(58, 650,300, 43);
					                 lblage.setForeground(Color.WHITE);
					                // registrframe.add(lblage);
					                 regrPane.add(lblage);
					           
			 
										  // Text Field for all
										              
										JTextField useridfield = new JTextField();                 // user id
										useridfield .setFont(new Font("Tahoma", Font.PLAIN, 32));
										useridfield .setBounds(250, 151, 250, 50);
										regrPane.add(useridfield );
										useridfield .setColumns(10);
										//  registrframe.add(useridfield);
										
										JTextField	usernamefield = new JTextField();                    // user name
										usernamefield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										usernamefield.setBounds(250, 235, 250, 50);
										regrPane.add(usernamefield);
										usernamefield.setColumns(10);
										 // registrframe.add(usernamefield);
										
										
										JTextField passwordfield = new JTextField();                            // password 
										 passwordfield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										 passwordfield.setBounds(250, 320, 250, 50);
										 regrPane.add( passwordfield);
										 passwordfield.setColumns(10);
										//  registrframe.add(passwordfield);

										JTextField	fullnamefield = new JTextField();                      // full name
										fullnamefield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										fullnamefield.setBounds(250, 400, 250, 50);
										//username.setBounds(707, 151, 228, 50);
										regrPane.add(fullnamefield);
										fullnamefield.setColumns(10);
										// registrframe.add(fullnamefield);
										
										 JTextField  mailidfield = new JTextField();                                 // mail id 
										 mailidfield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										 mailidfield.setBounds(250, 480, 250, 50);
										 regrPane.add( mailidfield);
										 mailidfield.setColumns(10);
										// registrframe.add( mailidfield);
										 
										 
										 JTextField  mobnumberfield = new JTextField();                                 // moblie Number
										 mobnumberfield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										 mobnumberfield.setBounds(250, 570, 250, 50);
										 regrPane.add(mobnumberfield );
										 mobnumberfield.setColumns(10);
										 //registrframe.add( mobnumberfield);
										
										
										 JTextField  agefield = new JTextField();                                 // age
										 agefield.setFont(new Font("Tahoma", Font.PLAIN, 32));
										 agefield.setBounds(250, 650, 250, 50);
										 regrPane.add(agefield );
										 agefield.setColumns(10);
										// registrframe.add(  agefield);
									
										 JButton registerButton = new JButton("Register");    
										 registerButton.setFont(new Font("Tahoma", Font.BOLD, 26));
										 registerButton.setBounds(802, 447, 259, 74);
										 registerButton.setForeground(Color.BLACK);
										 registerButton.setBackground(Color.WHITE);
										 regrPane.add(registerButton);
										// registrframe.add(registerButton);
								   
								      
								      
								      
								      registerButton.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
								      
												String userid   = useridfield.getText();  //1
												String username = usernamefield.getText(); //2
										        String password = passwordfield.getText(); //3
											    String fullname = fullnamefield.getText(); //4
											    String mail  = mailidfield.getText();  //5
											    String mob    =  mobnumberfield.getText(); //6
											    String age =  agefield.getText();  //7
												
									
											    try {
									                   
								                      //String query = "insert into book values(?,?,?,?,?,?)";
								                      //PreparedStatement p2=con.prepareStatement(query);
								                    	  
								                    
								                  Statement stamentregr = con.createStatement();
								                  String queryregr = "INSERT INTO registr values('" +userid   + "','" + username + "','" + password + "','" +
								                		  fullname+ "','" + mail + "','"+mob+"' , '"+age+" ')" ;
								                           
								                  int x = stamentregr.executeUpdate(queryregr);
								          
								                    if (x == 0) {
								                        JOptionPane.showMessageDialog( registerButton, "This User is alredy exist ...Please Login");
								                    } 
								                 else {
								                       // JOptionPane.showMessageDialog( registerButton,
								                          //   " Your  Sucessfully Register ");
								                        
                                               // Book Store start
								                        
												      
													    user2frame.setBounds(450, 190, 1014, 597);
												   	    user2frame.setResizable(false);
														
												    	 contentPanebook.setBorder(new EmptyBorder(5, 5, 5, 5));
														setContentPane(contentPanebook);
														contentPanebook.setBackground(Color.BLACK);
														contentPanebook.setLayout(null);
								     
								
														JLabel lblNewUserRegister = new JLabel("Welcome To BookStore ");
														lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
														lblNewUserRegister.setForeground(Color.BLUE);
														lblNewUserRegister.setBounds(362, 52, 600, 50);
														contentPanebook.add(lblNewUserRegister);
														
														JButton userprofile = new JButton("1. Read Book ");                 // user profile
														userprofile.setFont(new Font("Tahoma", Font.PLAIN, 32));
														userprofile .setBounds(250, 151, 250, 50);
														userprofile.setForeground(Color.BLACK);
														userprofile.setBackground(Color.WHITE);
														contentPanebook.add(userprofile );
													
														
														
														// read a book 
														
														
														
														userprofile.addActionListener(new ActionListener()   
			  	                                          {
			  	                                       	  
			  	                       						public void actionPerformed(ActionEvent e) 
			  	                       						{
			  	                       							

			  	              								JFrame  readbookframe = new JFrame("Read Book");
			  	              								readbookframe .setBounds(450, 190, 1014, 597);
			  	              						    	readbookframe. setResizable(false);
			  	              								JPanel	contentPane = new JPanel();
			  	              								contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			  	              								setContentPane(contentPane);
			  	              								contentPane.setBackground(Color.BLACK);
			  	              								contentPane.setLayout(null);
			  	              		     
			  	              		
			  	              								JLabel lbl1 = new JLabel("Read Book ");
			  	              								lbl1.setFont(new Font("Times New Roman", Font.BOLD, 42));
			  	              								lbl1.setForeground(Color.BLUE);
			  	              								lbl1.setBounds(362, 52, 400, 50);
			  	              								contentPane.add(lbl1);


			  	              								// User Id 
			  	                               
			  	              								  JLabel  lblbookname= new JLabel("Enter Book Name :  ");
			  	              						       	 lblbookname .setFont(new Font("Tahoma", Font.PLAIN, 20));
			  	              						          lblbookname .setBounds(58, 152, 200, 43);
			  	              								//99,43
			  	              					             lblbookname .setForeground(Color.WHITE);
			  	              								contentPane.add( lblbookname);

			  	              								// User Name
			  	                            
			  	              								JLabel lblusername = new JLabel("Enter Author Name : ");
			  	              								 lblusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
			  	              								 lblusername.setBounds(58, 243, 400, 43);
			  	              								 lblusername.setForeground(Color.WHITE);
			  	              								 contentPane.add(lblusername);
			  	              								 
			  	              								JTextField  booknamefield = new JTextField();                 // user id
			  	              							    booknamefield .setFont(new Font("Tahoma", Font.PLAIN, 32));
			  	              						        booknamefield .setBounds(250, 151, 250, 50);
			  	              						         contentPane.add(booknamefield);
			  	              				                booknamefield  .setColumns(10);
			  	  										
			  	  									    	JTextField	authornamefield = new JTextField();                    // user name
			  	  									        authornamefield.setFont(new Font("Tahoma", Font.PLAIN, 32));
			  	  									        authornamefield.setBounds(250, 235, 250, 50);
			  	  									    	contentPane.add( authornamefield);
			  	  									        authornamefield.setColumns(10);
			  	                       							
			  	                       							
			  	  									        JButton readbutton = new JButton("Generate Bill ");    
			  	  									        readbutton.setFont(new Font("Tahoma", Font.BOLD, 26));
			  	  							    	        readbutton.setBounds(802, 447, 259, 74);
			  	  							                readbutton.setForeground(Color.BLACK);
			  	  						                     readbutton.setBackground(Color.WHITE);
			  											    contentPane.add(readbutton);
			  										
			  										   	readbutton.addActionListener(new ActionListener()
			  												{
			  													public void actionPerformed(ActionEvent e)
			  													{
			  										
			  										        try
			  										        {
			  									         	String bookname = booknamefield .getText(); //1
			  									        	String authorname =  authornamefield.getText(); //2
			  													   
			  										        Statement stmtlogin  = con.createStatement(); 
			  										        String  readquery  = "Select  BookName, AuthorName from finalbook WHERE BookName = '" +  bookname +  
			  								                                    "' AND AuthorName = '" + authorname + "'"; 
			  								                ResultSet rs = stmtlogin.executeQuery(readquery); 
			  								             
			  								              if (rs.next())
			  								              {
			  						                        JOptionPane.showMessageDialog( readbutton  , "You Can Read Book");
			  						                        
			  						                         JFrame billframe = new JFrame("Bill Activity");
			  						                         // billframe.getContentPane().setBackground(Color.BLACK);
			  						                          billframe.setResizable(false);
			  						                          billframe.setSize(500,500);
			  						                          
			  						                        JLabel billheadline = new JLabel(" Bill for Selected Book  " , JLabel.CENTER);
		  										            billheadline.setVerticalAlignment(JLabel.TOP);
		  										         	billheadline.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
		  										         	billheadline.setForeground(Color.BLUE);
		  										            billframe.add(billheadline);
			  						                          
			  						                    
			  						                          JButton billButton = new JButton("Generate Bill");
			  						                          billButton.setFont(new Font("Arial", Font.BOLD, 28));
				  											  billButton.setBackground(Color.WHITE);
				  										 	  billButton.setForeground(Color.BLACK);
				  											  billButton.setSize(200, 50); 
				  											  billButton.setLocation(120, 450); 
				  											  billframe.add(billButton);
			  						                          
			  						                          
			  						                          billButton.addActionListener(new ActionListener()
															{
																public void actionPerformed(ActionEvent e)
																{
																	try
																	{
																		
																	 Statement billstat  = con.createStatement(); 
	                        String billquery = "Select BookId , BookName, AuthorName ,Price ,English_Lang, Hindi_Lang, Marathi_Lang, Count  from finalbook"
	  		                               + " WHERE BookName = '" +  bookname +  "' AND AuthorName = '" + authorname + "'";   
						   	 				  								                                   
																	 ResultSet rsbill = billstat.executeQuery(billquery); 
																	// ResultSetMetaData meta = rsbill.getMetaData();
																	 
																	         rsbill.next();      
																	 
																		         String bookidbill      =  rsbill.getString("BookId");
																		         String   bknamebill    =  rsbill.getString("BookName");
																	             String   aunamebill    =  rsbill.getString("AuthorName");
																	            
																		         String  pricebill     =   rsbill.getString("Price");
																		         String   engbill      =      rsbill.getString("English_Lang");
																		         String   hindibill      =    rsbill.getString("Hindi_Lang");
																		         String   marathibill  =  rsbill.getString("Marathi_Lang");
																		         String   countbill  =  rsbill.getString("Count");
																		 
																		         
																		         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
									  										     LocalDateTime now = LocalDateTime.now();  
									  										      //System.out.println(dtf.format(now));
																		         
																		 
																		        int myprice = Integer.parseInt(pricebill);
																		        int mycount = Integer.parseInt(countbill);
																		        
																		        int total = myprice * mycount;
																		        System.out.println("Total Bill :" +total);
																		        
					 JOptionPane.showMessageDialog( billButton ,"\n\nBook Id:"+bookidbill+"\n\n Book Name : " + bknamebill + "\n\nAuthor Name : "+aunamebill+ 
			"\n\nBook Price :"+pricebill+"\n\nEnglish Language :"+engbill+"\n\nHindi Language :"+hindibill+"\n\nMarathi Language :" +marathibill+ "\n\nTotal Amount : "+total+"\n\n\nBook Reading DateTime :"+dtf.format(now));
																		    		
																	
																	}
																	catch(Exception billexecption)
																	{
																		 System.out.println(billexecption);
																		 JOptionPane.showMessageDialog( billButton , "Stock is not Available");
																		   
																	}
																	
																	
																}
															});
			  						                        
			  						                    
			  						                        billframe.setVisible(true);
			  						                  
			  						                      
			  						                      }
			  								              else
			  						                       {
			  						                        JOptionPane.showMessageDialog( readbutton , "Book Not Found");
			  						                       }
			  								        
			  								               } 
			  								        catch(Exception exception1) 
			  								        { 
			  								        	  JOptionPane.showMessageDialog( readbutton ,"Error while reading book");
			  								           
			  								        } 
			  													}
			  												});
			  											 
			  										
			  										      JButton resetButton = new JButton("RESET");    
			  										      resetButton.setFont(new Font("Tahoma", Font.BOLD, 26));
			  										      resetButton.setBounds(802, 200, 259, 74);
			  										      resetButton.setForeground(Color.BLACK);
			  										      resetButton.setBackground(Color.WHITE);
			  										      contentPane.add(resetButton);
			  										      resetButton.addActionListener(this);		
			  	                       					
			  										      
			  										    readbookframe .add(contentPane);
			  										    readbookframe .setVisible(true);
			  										    readbookframe .setSize(900,900);
			  										    readbookframe .setResizable(false);
			  						             							
			  	                       						}
			  	                                          });
														
														
										
														
														JButton	searchbook = new JButton("2. Search Book");                    // serach book
														searchbook.setFont(new Font("Tahoma", Font.PLAIN, 32));
														searchbook.setBounds(250, 235, 250, 50);
														searchbook.setForeground(Color.BLACK);
														searchbook.setBackground(Color.WHITE);
														contentPanebook.add(searchbook);
														
														// searchbook start here 
														
												
														searchbook. addActionListener(new ActionListener()
															{
																public void actionPerformed(ActionEvent e)
																{
																	
																	
																 JFrame  searchbook= new JFrame("Search Book Acivity");
																 searchbook   .getContentPane().setBackground(Color.BLACK);
						               						         
						               						         // Main  Label1
						               						           JLabel searchheadline = new JLabel("Search Book  " , JLabel.CENTER);
						               						           searchheadline .setVerticalAlignment(JLabel.TOP);
						               						           searchheadline .setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
						               						           searchheadline .setForeground(Color.BLUE);
						               						            
						               						            
						               						        JLabel bookname = new JLabel("Enter Book Name: "); 
						               						        bookname .setFont(new Font("Consolas", Font.PLAIN, 30)); 
						               						        bookname .setSize(300, 50); 
						               						        bookname .setLocation(100, 100); 
						               						      // debook .setBackground(Color.WHITE);
						     									    bookname .setForeground(Color.WHITE);
						     									    searchbook .add(bookname ); 
						               					          
						               								JTextField namefield1 = new JTextField(); 
						               								namefield1.setFont(new Font("Consolas", Font.BOLD, 18)); 
						               								namefield1.setSize(300, 50); 
						               								namefield1.setLocation(500, 100); 
						               							    searchbook.add(namefield1); 
						               					           
						               								
						               								 JButton searchbutton = new JButton("Search"); 
						               							     searchbutton .setFont(new Font("Consolas", Font.BOLD, 18)); 
						               						    	 searchbutton .setSize(300, 50); 
						               							     searchbutton .setLocation(100, 450); 
						               						    	
						               						    	 searchbutton .setBackground(Color.WHITE);
						               						      	 searchbutton .setForeground(Color.BLACK);
						               						    	 searchbook.add(searchbutton );
						               						    	 
						               						    	
						               						    	searchbutton.addActionListener(new ActionListener()   
						  	                                          {
						  	                                       	  
						  	                       						public void actionPerformed(ActionEvent e) 
						  	                       						{
						  	                       							String bookname = namefield1.getText();
						  	                       						
						  	                       							
						  	                       						try {
						  	                       						 Statement stmt = con.createStatement(); 
						  	                       						 // SELECT query 
						  	                       			            String q1 = "select BookName from finalbook WHERE BookName = '" + bookname +   "'"; 
						  	                       			            ResultSet rs = stmt.executeQuery(q1); 
						  	                       			            if (rs.next()) 
						  	                       			            { 
						  	                       			                 JOptionPane.showMessageDialog(searchbutton ,
				    	                       		                             "Book Found");
						  	                       			                 
						  	                       			            } 
						  	                       			            else
						  	                       			            { 
						  	                       			                System.out.println("No such book exists"); 
						  	                       			            } 
						  	                       							
						  	                       							
						  	                       					
				    	                       							}
				    	                       						 catch(Exception bname) 
				    	                       					        { 
				    	                       							 JOptionPane.showMessageDialog(searchbutton ,
				    	                       		                             "Book Not exist");
				    	                       							 System.out.println(bname);
				    	                       					        } 
						  	                       							
						  	                       			
						  	                       						}
						  	                                          });
						               						    	 
						               						    	 
						               						    	 
						               						       
							               								JButton resetup1 = new JButton("Reset"); 
							               								resetup1.setFont(new Font("Consolas", Font.BOLD, 18)); 
							               								resetup1.setSize(300, 50); 
							               							    resetup1.setLocation(500, 450); 
							               							    resetup1.setBackground(Color.WHITE);
								               						    resetup1 .setForeground(Color.BLACK);
								               					    	 searchbook.add(resetup1);   
								               							
								               							resetup1.addActionListener(this);
						  	                                         
						  	                                  
						               						    	 
						               						       searchbook.add(searchheadline);
						               					    	   searchbook   .setVisible(true);
						               					     	   searchbook.setSize(800,800);  
													 	
														
																	
																}
															});
														
													
														JButton chat = new JButton("3. Chat with Admin");               // chat
														chat .setFont(new Font("Tahoma", Font.PLAIN, 32));
														chat .setBounds(250, 320, 350, 50);
														chat.setForeground(Color.BLACK);
														chat.setBackground(Color.WHITE);
														contentPanebook.add(chat);
														

														chat.addActionListener(new ActionListener()
			  												{
			  													public void actionPerformed(ActionEvent e)
			  													{
			  														try
			  														{
			  													    new Server();
			  													    new Client();
			  														}
			  														catch(Exception am)
			  														{
			  															System.out.println(am);
			  														}
			  													
			  													}
			  												});
														
													
														JButton	back = new JButton("4. Logout" );                      //go back
														back.setFont(new Font("Tahoma", Font.PLAIN, 32));
														back.setBounds(250, 400, 250, 50);
														back.setForeground(Color.BLACK);
														back.setBackground(Color.WHITE);
														//username.setBounds(707, 151, 228, 50);
														contentPanebook.add(back);
														
														
														back .addActionListener(new ActionListener()
															{
																public void actionPerformed(ActionEvent e)
																{
																	mainframe2.setVisible(true);
																}
															});
														
													

														 user2frame.add(contentPanebook);
														 user2frame.setSize(1000, 1000);   // setting width and height for frame
														 user2frame.setVisible(true);
								                        
								                        
								                        
								                  
								                        // bookstore end 
								                  
								                        
								                    }
								               
			  	                                          }
								                catch (Exception exception) {
								                   // exception.printStackTrace();
								                	JOptionPane.showMessageDialog( registerButton, "Fix The Error");
								                	

								                }
											
											}
											
										});
												
								
								      JButton resetButton = new JButton("RESET");    
								      resetButton.setFont(new Font("Tahoma", Font.BOLD, 26));
								      resetButton.setBounds(802, 200, 259, 74);
								      resetButton.setForeground(Color.BLACK);
								      resetButton.setBackground(Color.WHITE);
								      regrPane.add(resetButton);  
								     // registrframe .add( resetButton);
								      resetButton.addActionListener(this);   
								      
								     
								      JButton gobackbutton33 = new JButton("GO BACK");    
								      gobackbutton33.setFont(new Font("Tahoma", Font.BOLD, 26));
								      gobackbutton33.setBounds(802, 700, 259, 74);
								      gobackbutton33.setForeground(Color.BLACK);
								      gobackbutton33.setBackground(Color.WHITE);
								      //registrframe .add( gobackbutton33);
								      regrPane.add(gobackbutton33);  
								      gobackbutton33 .addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												mainframe2.setVisible(true);
											}
										});
								      
							
								      registrframe .add(regrPane);
								    //  registrframe .revalidate();
								      //registrframe .repaint();
								      registrframe .setSize(1000, 1000);   // setting width and height for frame
								      registrframe .setVisible(true);
				
				
				
					}
				});
				
			
				
				// exit button 
				
				  JButton	exitbtn = new JButton("Go Back"); 
					exitbtn.setFont(new Font("Arial", Font.BOLD, 30)); 
					exitbtn.setBackground(Color.WHITE);
			 		exitbtn.setForeground(Color.BLACK);
					exitbtn.setSize(200, 50); 
					exitbtn .setLocation(100, 400); 
					mainframe2.add(exitbtn); 
				

				    exitbtn.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent e)
								{
									mainframe.setVisible(true);
								}
							});
					
					
					    mainframe2.add(jUserName);
			            mainframe2.setSize(700, 700);   // setting width and height for frame
			            mainframe2.setVisible(true);
			        //	mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			
		
			}
		});
		
		
		// exit button 
		
	  JButton	exit = new JButton("Exit"); 
		exit.setFont(new Font("Arial", Font.BOLD, 30)); 
		exit.setBackground(Color.WHITE);
 		exit.setForeground(Color.BLACK);
		exit.setSize(200, 50); 
		exit.setLocation(100, 400); 
		mainframe.add(exit); 
		
		
		

		exit .addActionListener(new ActionListener()   // ADD button action start
                {
             	  
						public void actionPerformed(ActionEvent e) 
						{
					       System.exit(1);
							
		
		
						}
                });
		
		
		
		
		// Add action to Admin button
		
		
		admin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		         JFrame  adminframe = new JFrame("Admin Activity");
		         adminframe.getContentPane().setBackground(Color.BLACK);
		         
		         // admin Label1
		         JLabel adminheadline = new JLabel("  Admin  Authorization  " , JLabel.CENTER);
		         adminheadline.setVerticalAlignment(JLabel.TOP);
		         adminheadline.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
		         adminheadline.setForeground(Color.BLUE);
		         
		        
		         
		        
		        
		         
		         //Admin Id 
		         
		        JLabel username = new JLabel("Admin ID:  "); 
		 		username.setFont(new Font("Arial", Font.BOLD, 25)); 
		 		username.setForeground(Color.WHITE);
		 		username.setSize(200, 40); 
		 		username.setLocation(100, 100); 

		 		

		 		JTextField tname = new JTextField(); 
		 		tname.setFont(new Font("Arial", Font.BOLD, 18)); 
		 		tname.setSize(200, 40); 
		 		tname.setLocation(300, 100); 
		 		
		 		
		         //admin username
		 		
		 			 		
		 	    JLabel name = new JLabel("Admin Name : "); 
				name.setFont(new Font("Arial", Font.BOLD, 25)); 
				name.setForeground(Color.WHITE);
				name.setSize(200, 40); 
				name.setLocation(100, 250); 
				
				 JTextField tmno = new JTextField(); 
				tmno.setFont(new Font("Arial", Font.BOLD, 18)); 
				tmno.setSize(200, 40); 
				tmno.setLocation(300, 250); 
				
				
				
				// Submit and reset button
				JButton sub = new JButton("Submit"); 
				sub.setFont(new Font("Arial", Font.BOLD, 18));
				sub.setBackground(Color.WHITE);
		 		sub.setForeground(Color.BLACK);
				sub.setSize(200, 50); 
				sub.setLocation(120, 450); 
				//sub.addActionListener(this); 
				
				
			   JButton	reset = new JButton("Reset"); 
				reset.setFont(new Font("Arial", Font.BOLD, 18)); 
				reset.setBackground(Color.WHITE);
		 		reset.setForeground(Color.BLACK);
				reset.setSize(200, 50); 
				reset.setLocation(400, 450);
				reset.addActionListener(this);
				
				
			
				// getting input  for admin id
				 /* int myid = 33;
				  String myuser = "Pooja";
				 map1.put(myid, myuser);
		 		 map2.put(adminid, adminame);		
		 		boolean be = map1.equals(map2);*/
		 		 //if(be==true)
				 //{
					 //System.out.println("___Admin Login Successfully_______!!");
		 			 
		 			// Add Action To submit Button
				
						sub.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent e)
							{
								String adminame = tmno.getText();
								int adminid = Integer.parseInt(tname.getText());
								
								if(adminid == 33 && adminame.trim().equals("Pooja"))
								{		
								
								JFrame  adminframe = new JFrame("Admin Activity");
						         adminframe.getContentPane().setBackground(Color.BLACK);
						         
						         // admin Label1
						         JLabel adminheadline = new JLabel("  Admin Tasks  " , JLabel.CENTER);
						         adminheadline.setVerticalAlignment(JLabel.TOP);
						         adminheadline.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
						         adminheadline.setForeground(Color.BLUE);
					
						
						       
						       
						         // 1.AddBooks\n" +"2.Show Books\n"+"3.Update Book\n"+"4.Delete book\n"+"5.Get User List\n"+"6.Exit
						         
						         // 1st Button for Addbooks 
						         
									JButton addbook = new JButton("1. ADD BOOKS "); 
									addbook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
									addbook.setBackground(Color.WHITE);
							 		addbook.setForeground(Color.BLACK);
									addbook.setSize(230, 50); 
									addbook.setLocation(50, 150); 
									
									
									
									// Add action to addbooks
									
									addbook.addActionListener(new ActionListener()                     // start add book
									{
										public void actionPerformed(ActionEvent e)
										{
											
									
											 JFrame  addbookframe = new JFrame("Admin- Addbooks");
									      	 setBounds(450, 190, 1014, 597);
        									 setResizable(false);
        									 JPanel	contentPane = new JPanel();
        									 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        									 setContentPane(contentPane);
        									 contentPane.setBackground(Color.BLACK);
        								     contentPane.setLayout(null);
									     
									
										JLabel lblNewUserRegister = new JLabel("ADD NEW BOOKS ");
        								lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 42));
        								lblNewUserRegister.setForeground(Color.BLUE);
        							    lblNewUserRegister.setBounds(362, 52, 400, 50);
        							    contentPane.add(lblNewUserRegister);


                                           // Book Id 
                                             
        								JLabel lblName = new JLabel("Book Id ");
        								lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        								lblName.setBounds(58, 152, 99, 43);
        								lblName.setForeground(Color.WHITE);
        								contentPane.add(lblName);

                                         // Book Name
                                          
        								JLabel lblNewLabel = new JLabel("Book Name  ");
        								lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        								lblNewLabel.setBounds(58, 243, 130, 29);
        								lblNewLabel.setForeground(Color.WHITE);
        								contentPane.add(lblNewLabel);
        								
        								//  Author Name 

        								JLabel lblEmailAddress = new JLabel("Author Name ");
        								lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        								lblEmailAddress.setBounds(58, 324, 124, 36);
        								lblEmailAddress.setForeground(Color.WHITE);
        								contentPane.add(lblEmailAddress);
        								
        								// book prize
        								 JLabel lblUsername = new JLabel(" Book Price ");
        								 lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        							     lblUsername.setBounds(542, 159, 110, 29);
        							     lblUsername.setForeground(Color.WHITE);
        								 contentPane.add(lblUsername);
        								 
        								 
        								 // book language
        								    JLabel lblPassword = new JLabel("Book Language");
        									lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        									lblPassword.setBounds(542, 245, 150, 24);
        									lblPassword.setForeground(Color.WHITE);
                                            contentPane.add(lblPassword); 
        				
        				
        				                  // PDF count 
        				                  JLabel lblMobileNumber = new JLabel("Book Copies");
                                         lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
                                         lblMobileNumber.setBounds(542, 329, 150, 26);
                                         lblMobileNumber.setForeground(Color.WHITE);
                                         contentPane.add(lblMobileNumber);
        								 
        								
        								

                                         // Text Field for all
                                          
        					JTextField firstname = new JTextField();                 // book id
        					firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        					firstname.setBounds(214, 151, 228, 50);
        					contentPane.add(firstname);
        					firstname.setColumns(10);

        					JTextField	lastname = new JTextField();                    // book name
        					lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        					lastname.setBounds(214, 235, 228, 50);
        					contentPane.add(lastname);
        					lastname.setColumns(10);

        
        					JTextField email = new JTextField();                            // author name
        					email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        					email.setBounds(214, 320, 228, 50);
        					contentPane.add(email);
        					email.setColumns(10);

        			   		JTextField	username = new JTextField();                      // book price
        					username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        					username.setBounds(707, 151, 228, 50);
        					contentPane.add(username);
        					username.setColumns(10);
                           
                        
        					
        					JCheckBox english = new JCheckBox("English");
        				    english.setFont(new Font("Tahoma", Font.PLAIN, 32));
        			    	english.setBounds(707, 235, 228, 50);
        					contentPane.add(english); 
        				
        					JCheckBox hindi = new JCheckBox("Hindi");
        				    hindi.setFont(new Font("Tahoma", Font.PLAIN, 32));
        			        hindi.setBounds(950, 235, 400, 50);
        					contentPane.add(hindi); 
        					 
        					
        					JCheckBox marathi = new JCheckBox("Marathi");
        				    marathi.setFont(new Font("Tahoma", Font.PLAIN, 32));
        				    marathi.setBounds(1400, 235, 628, 50);
        			        contentPane.add(marathi); 
        					
        					
        					
       
                            JTextField  mob = new JTextField();                                 // copy count
        					mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        					
        					mob.setBounds(707, 320, 228, 50);
        				    contentPane.add(mob);
        				    mob.setColumns(10);

       
                                 JButton btnNewButton = new JButton("ADD");    
                                  btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 26));
                                  btnNewButton.setBounds(99, 447, 259, 74);
                                  btnNewButton.setForeground(Color.BLACK);
                                  btnNewButton.setBackground(Color.WHITE);
                                  contentPane.add(btnNewButton);
                               
                                  JButton btnNewButton1 = new JButton("RESET");    
                                  btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 26));
                                  btnNewButton1.setBounds(499, 447, 259, 74);
                                  btnNewButton1.setForeground(Color.BLACK);
                                  btnNewButton1.setBackground(Color.WHITE);
                                  contentPane.add(btnNewButton1);
                                  btnNewButton1.addActionListener(this);
                                  
                                  
                                  
                                  
                                  JButton btnNewButton2 = new JButton("GO BACK");    
                                  btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 26));
                                  btnNewButton2.setBounds(899, 447, 259, 74);
                                  btnNewButton2.setForeground(Color.BLACK);
                                  btnNewButton2.setBackground(Color.WHITE);
                                  contentPane.add(btnNewButton2);
                                
                                  btnNewButton2.addActionListener(new ActionListener()   // ADD button action start // step start
                                          {
                                       	  
                       						public void actionPerformed(ActionEvent e) 
                       						{
                       							adminframe.setVisible(true);
                       							
                       						}
                                          });
                                  
                            
                                  
                                  
                     			// adding action to Add button of addbooks
                               btnNewButton.addActionListener(new ActionListener()   // ADD button action start
                               {
                            	  
            						public void actionPerformed(ActionEvent e) 
            						{
            							
            						String idbook = firstname.getText();
            					       	                         // book id 
                					String lastName = lastname.getText();             					 	// book name
                					String emailId = email.getText();                                       // author name
                					String bkprize = username.getText();
                					//int prizeName = Integer.parseInt(bkprize);              	             // book prize
                					String mobileNumber = mob.getText();               						// book count
                					String lang1 = english.getText();
                					String lang2 = hindi.getText();
                					String lang3 = marathi.getText();
                					//int countbk = Integer.parseInt(bkcount);         	                      // book lang
            	
                					
                				lang1 = "No";
                				lang2 = "No";
                				lang3 = "No";
                					
                					
                				if(english.isSelected())
                				{
                					lang1="English";
                				}
                				if(hindi.isSelected())
                				{
                					lang2="Hindi";
                				}
                				if(marathi.isSelected())
                				{
                					lang3="Marathi";
                				}	
                					
                
                      try {
                   
                      //String query = "insert into book values(?,?,?,?,?,?)";
                      //PreparedStatement p2=con.prepareStatement(query);
                    	  
                    
                              Statement sta = con.createStatement();
                              String query = "INSERT INTO finalbook values('" + idbook + "','" + lastName + "','" + emailId + "','" +
                              bkprize + "','" + lang1 + "','"+lang2+"' , '"+lang3+" ' , '" + mobileNumber + "')";
                              int x = sta.executeUpdate(query);
                        
                    
				  // 	p2.executeUpdate(query);
				    	
                      /* //	int bookid = Integer.parseInt(idbook);  
                       * 
                       *  
                       *  
                       */
                      
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This book is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                             "Book Added Sucessfully");
                    }
                    con.close();
                } catch (Exception exception) {
                   // exception.printStackTrace();
                	JOptionPane.showMessageDialog(btnNewButton, "This book Id is alredy exist");
                	

                }
                      
                
                      System.out.println("Add book Data inserted ");
            }
        });     // ADD button action close 
                            //   addbookframe.getContentPane().setBackground(Color.BLACK);
                               addbookframe.add(contentPane);
                               addbookframe.setSize(800, 800);   // setting width and height for frame
                               addbookframe.setVisible(true);
                        //   	addbookframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                               
                               
    
										}
										});    // Add Book close 
									
									
									//  2 . Show Books 
									
									JButton	showbook = new JButton("2. SHOW BOOKS "); 
									showbook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18)); 
									showbook.setBackground(Color.WHITE);
							 		showbook.setForeground(Color.BLACK);
									showbook.setSize(230, 50); 
									showbook.setLocation(300, 150);
									
									
									
									// Add action to show books 
									
									
									 showbook.addActionListener(new ActionListener()   // ADD button action start
				                               {

				            						public void actionPerformed(ActionEvent e) 
				            						{
				            							

										                   JFrame  showframe = new JFrame("Admin-ShowBooks");
								      	                   setBounds(450, 190, 1014, 597);
 									                       setResizable(false);
				                            	  
				            					            JPanel contentPane;
				            							    JTable jt1;
				            							 
				            						    	contentPane = new JPanel();
				            							    contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
				            						    	setContentPane(contentPane);
				            							    contentPane.setLayout(null);
				            								
				            							
				            							// show boook Label1
												         JLabel showheadline = new JLabel("All Books"  , JLabel.CENTER);
												         showheadline.setVerticalAlignment(JLabel.TOP);
												         showheadline.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 10));
												         showheadline.setForeground(Color.BLUE);
												       // contentPane.add(showheadline);
												       
				            							JScrollPane scrollPane = new JScrollPane();
				            							scrollPane.setBounds(200, 100, 850, 650);
				            							scrollPane.setForeground(Color.WHITE);
				            							contentPane.add(scrollPane);
				            							//My_test obj=new My_test();// with test data
				            							my_mysql obj=new my_mysql();
				            								
				            		String[] column= {"BookId","BookName","AuthorName","Price","English_Lang","Hindi_Lang","Marathi_Lang" ,"Count"};
				            							
				            						//jt1=new javax.swing.JTable(obj.my_test_select(),column);//test data
				            							jt1 = new JTable(obj.my_db_select(),column);
				            							scrollPane.setViewportView(jt1);
				            							jt1.setRowHeight(60);
				            						
				            							 JTableHeader tableHeader = jt1.getTableHeader();
				            						      tableHeader.setBackground(Color.black);
				            						      tableHeader.setForeground(Color.white);
				            						      Font headerFont = new Font("Verdana", Font.BOLD, 18);
				            						      tableHeader.setFont(headerFont);
				            						      
				            						      tableHeader.setPreferredSize(new Dimension(100, 100));
				            						      
				            							jt1.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 18)); 
				    									jt1.setBackground(Color.WHITE);
				    							 		jt1.setForeground(Color.BLACK);
				    							 		
				    							 		
				    							 		 
				    	                                  JButton btnNewButton2 = new JButton("GO BACK");    
				    	                                  btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 26));
				    	                                  btnNewButton2.setBounds(550,800 ,250 , 99);
				    	                                  btnNewButton2.setForeground(Color.BLACK);
				    	                                  btnNewButton2.setBackground(Color.WHITE);
				    	                                  contentPane.add(btnNewButton2);
				    	                                
				    	                                  btnNewButton2.addActionListener(new ActionListener()   // ADD button action start
				    	                                          {
				    	                                       	  
				    	                       						public void actionPerformed(ActionEvent e) 
				    	                       						{
				    	                       							adminframe.setVisible(true);
				    	                       							
				    	                       						}
				    	                                          });
				            							
				    	                                  showframe.add(showheadline);
				            						    
				            							 showframe.add(contentPane);
				            							 
									        
				                                         showframe.setSize(1000, 1000);   // setting width and height for frame
				                                         showframe.setVisible(true);
				                                         contentPane.setBackground(Color.BLACK);
				                                     //	showframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				            							
				            							
				            							
				            						}
				            						
				                               });
									
									
			// 3 .update books 
									
			JButton upbook = new JButton("3. UPDATE BOOKS "); 
			upbook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
			upbook.setBackground(Color.WHITE);
			upbook.setForeground(Color.BLACK);
			upbook.setSize(230,50); 
			upbook.setLocation(50, 300); 
								
									
			// add action Listener to update button 
									
									
									upbook.addActionListener(new ActionListener()   // update button action start
	                                          {
	                                       	  
	                       						public void actionPerformed(ActionEvent e) 
	                       						{
	                       							
	                       							JFrame  updateframe = new JFrame("Admin Activity");
	               						            updateframe.getContentPane().setBackground(Color.BLACK);
	               						         
	               						         // admin Label1
	               						             JLabel updateheadline = new JLabel("What do you want to update ?   " , JLabel.CENTER);
	               						             updateheadline.setVerticalAlignment(JLabel.TOP);
	               						             updateheadline.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
	               						             updateheadline.setForeground(Color.BLUE);
	               						             
	         // 1. BooK Name:
	          
	              							         
		     JButton upname = new JButton("1. BooK Name "); 
		     upname.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
		     upname.setBackground(Color.WHITE);
		     upname.setForeground(Color.BLACK);
		     upname.setSize(230, 50); 
		     upname.setLocation(50, 150);
		     updateframe.add(upname);
		         
	             									// Add Action for updating book name
	             								
	             									upname.addActionListener(new ActionListener()   // ADD button action start
	                                                 {
	                                       	  
	                       						      public void actionPerformed(ActionEvent e) 
	                       						      {
	             									
	                       			    	    	 JFrame  upbknameframe = new JFrame("Book Name Acivity");
	               						            upbknameframe.getContentPane().setBackground(Color.BLACK);
	               						         
	               						         // Main  Label1
	               						           JLabel upbknameheadline = new JLabel("Update Book Name " , JLabel.CENTER);
	               						           upbknameheadline .setVerticalAlignment(JLabel.TOP);
	               						           upbknameheadline .setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
	               						           upbknameheadline  .setForeground(Color.BLUE);
	               						            
	               						        JLabel bookid1 = new JLabel("Enter Book Id : "); 
	               						        bookid1 .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						        bookid1 .setSize(300, 50); 
	               						        bookid1 .setLocation(100, 100); 
	               						      // debook .setBackground(Color.WHITE);
	     									    bookid1 .setForeground(Color.WHITE);
	     									    upbknameframe .add(bookid1 ); 
	               					          
	               								JTextField idfield1 = new JTextField(); 
	               								idfield1.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								idfield1.setSize(300, 50); 
	               								idfield1.setLocation(500, 100); 
	               								upbknameframe.add(idfield1); 
	               					           
	               					           
	               					           
	               								
	               							   JLabel bkname = new JLabel("Enter Book Name : "); 
	               						       bkname .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						       bkname.setSize(400,50);
	               						       bkname.setLocation(100,250);  
	               							   bkname .setForeground(Color.WHITE);
	               							   upbknameframe.add(bkname);
	               							
	               								JTextField namefield1 = new JTextField(); 
	               								namefield1.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    namefield1.setSize(300,50);
	               							    namefield1.setLocation(500,250);
	               							    upbknameframe.add(namefield1);
	               								
	               								
	               								
	               								JButton upbkbutton = new JButton("Update "); 
	               							    upbkbutton  .setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    upbkbutton  .setSize(300, 50); 
	               							    upbkbutton  .setLocation(100, 450); 
	               							 //  debutton .addActionListener(this); 
	               							    upbkbutton .setBackground(Color.WHITE);
	               							    upbkbutton .setForeground(Color.BLACK);
	               						        upbknameframe.add(upbkbutton );
               								
	               							
	               							   
	               							upbkbutton .addActionListener(new ActionListener()   // upadte button action start
	    	                                          {
	    	                                       	  
	    	                       						public void actionPerformed(ActionEvent e) 
	    	                       						{
	    	                       						//	String myidbkname   =  idfield1.getText();
	    	                       					//		String mynamebkname =  namefield1.getText();
	    	                       								    	                       							
	    			    	                       			/*				
	    			    	                       				
	    											          String updatename ="UPDATE finalbook SET BookName=? WHERE BookId=?";
	    										           	  PreparedStatement pbkname=con.prepareStatement(updatename);
	    										    	      pbkname.setString(1,mynamebkname);
	    										    	      pbkname.setString(2, myidbkname);
	    										    	      pbkname.executeUpdate();
	    										    	      JOptionPane.showMessageDialog(upbkbutton ,
	    	                  		                             "One Book Successfully updated"); 
	    			    	                       							
	    			    	                       				*/			
	    			    	                       							
	    			    	                       							
	    			    	                       							
	    			    	                       							
	    			    	                       						/* Statement stmtbkname = con.createStatement(); 
	    			    	                       	       
	    			    	              // update name of book query         			                      
	    			    	      String updatebooknamequery = "UPDATE finalbook (set BookName = '" +mynamebkname+  "' WHERE BookId = '" +myidbkname+ "')"; 
	    			    	                       			                      
	    			    	                       			                      
	    			    	                       			            int x1 = stmtbkname.executeUpdate(updatebooknamequery); 
	    			    	                       			              
	    			    	                       			            if (x1 > 0)             
	    			    	                       			             
	    			    	                       							 JOptionPane.showMessageDialog(upbkbutton ,
	    			    	                       		                             "One Book Successfully updated");          
	    			    	                       			            else
	    			    	                       			             
	    			    	                       							 JOptionPane.showMessageDialog(upbkbutton ,
	    			    	                       		                             "Opps ! Error ");
	    			    	                       			         
	    			    	                       			            */
	    	                       							
	    	                       							
	    	                       							try {
	    	                       								
	    	                       								
	    	                       							
	    	                       								
	    	                       								String sqlname = "UPDATE finalbook SET BookName=? WHERE BookId=?";
		    	                       							 
	    	                       								PreparedStatement statement1 = con.prepareStatement(sqlname);
	    	                       								statement1.setString(1,namefield1.getText() );
	    	                       								statement1.setString(2, idfield1.getText());
	    	                       								
	    	                       								 
	    	                       								int rowsUpdated = statement1.executeUpdate();
	    	                       								if (rowsUpdated > 0) {
	    	                       									JOptionPane.showMessageDialog(upbkbutton ,
			    	                       		                             "One Book Successfully updated");
	    	                       								}
	    	                       								
	    	                       			
		    	                       					
		    	                       						
	    	                       							}
	    	                       						 catch(Exception bname) 
	    	                       					        { 
	    	                       							 JOptionPane.showMessageDialog(upbkbutton ,
	    	                       		                             "Book Not exist");
	    	                       							 System.out.println(bname);
	    	                       					        } 
	    	                       						
	    	                       						}
	    	                                          });  // update book name button close
	               						 

	               								JButton resetup1 = new JButton("Go back"); 
	               								resetup1.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								resetup1.setSize(300, 50); 
	               							    resetup1.setLocation(500, 450); 
	               							    resetup1.setBackground(Color.WHITE);
		               						    resetup1 .setForeground(Color.BLACK);
		               							upbknameframe.add(resetup1);   
		               							
		               							resetup1.addActionListener(new ActionListener()   
  	                                          {
  	                                       	  
  	                       						public void actionPerformed(ActionEvent e) 
  	                       						{
  	                       							updateframe.setVisible(true);
  	                       							
  	                       						}
  	                                          });
		               							
	               							  
	               							
	               					    	 upbknameframe.add(upbknameheadline);
	               					    	 upbknameframe.setVisible(true);
	               						     upbknameframe.setSize(800,800);
	                       							
	                       							
	                       					
	                       							
	                       						}
	                       						});
	             									// end book name action 
	             								
	               						             
	             									// 2. Author Name
	             									

	            									JButton	upauname = new JButton("2. Author Name "); 
	            									upauname.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18)); 
	            									upauname.setBackground(Color.WHITE);
	            									upauname.setForeground(Color.BLACK);
	            									upauname.setSize(230, 50); 
	            									upauname.setLocation(300, 150);
	            									updateframe.add(upauname);
	            									
	            									
	            									// Add Action for updating author name
		             								
	             									upauname.addActionListener(new ActionListener()   // ADD button action start
	                                                 {
	                                       	  
	                       						      public void actionPerformed(ActionEvent e) 
	                       						      {
	             									
	             									
	             									
	                       							 JFrame  upaunameframe = new JFrame("Author Name Acivity");
	               						             upaunameframe.getContentPane().setBackground(Color.BLACK);
	               						         
	               						             // Main  Label1
	               						           JLabel upaunameheadline = new JLabel("Update Author Name " , JLabel.CENTER);
	               						           upaunameheadline .setVerticalAlignment(JLabel.TOP);
	               						           upaunameheadline .setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
	               						           upaunameheadline  .setForeground(Color.BLUE);
	               						            
	               						        JLabel bookid2 = new JLabel("Enter Book Id : "); 
	               						        bookid2 .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						        bookid2 .setSize(300, 50); 
	               						        bookid2 .setLocation(100, 100); 
	     									    bookid2 .setForeground(Color.WHITE);
	     									    upaunameframe .add(bookid2); 
	               					          
	               								JTextField idfield2 = new JTextField(); 
	               								idfield2.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								idfield2.setSize(300, 50); 
	               								idfield2.setLocation(500, 100); 
	               								upaunameframe.add(idfield2 ); 
	               					           
	               					           
	               					           
	               								
	               							  JLabel auname = new JLabel("Enter Author Name : "); 
	               						       auname .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						       auname.setSize(400,50);
	               						        auname.setLocation(100,250);  
	               							   auname .setForeground(Color.WHITE);
	               							  upaunameframe.add(auname);
	               							
	               								JTextField namefield2 = new JTextField(); 
	               								namefield2.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							 namefield2.setSize(300,50);
	               							 namefield2.setLocation(500,250);
	               							   upaunameframe.add(namefield2);
	               								
	               								
	               								
	               								JButton upaubutton = new JButton("Update "); 
	               							    upaubutton .setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    upaubutton .setSize(300, 50); 
	               							    upaubutton .setLocation(100, 450); 
	               							 //  debutton .addActionListener(this); 
	               							    upaubutton .setBackground(Color.WHITE);
	               							    upaubutton .setForeground(Color.BLACK);
	               						        upaunameframe.add(upaubutton );
               								
	               							
	               							   
	               							upaubutton .addActionListener(new ActionListener()   // upadte button action start
	    	                                          {
	    	                                       	  
	    	                       						public void actionPerformed(ActionEvent e) 
	    	                       						{
	    	                       							
	    	                       							//String myidauthor = idfield2.getText();
	    	                       							//String mynameauthor = namefield2.getText();
	    	                       							
	    	                       							
	    	                       							try {
	    	                       								
	    	                       								
	    	                       								String sql = "UPDATE finalbook SET AuthorName=? WHERE BookId=?";
	    	                       							 
	    	                       								PreparedStatement statement = con.prepareStatement(sql);
	    	                       								statement.setString(1, namefield2.getText());
	    	                       								statement.setString(2, idfield2.getText());
	    	                       								
	    	                       								 
	    	                       								int rowsUpdated = statement.executeUpdate();
	    	                       								if (rowsUpdated > 0) {
	    	                       									JOptionPane.showMessageDialog(upaubutton ,
			    	                       		                             "One Book Successfully updated");
	    	                       								}
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       							
		    	       										  /* String strau="UPDATE finalbook SET AuthorName=? WHERE BookId=?";
		    	       									    	PreparedStatement pauname=con.prepareStatement(strau);
		    	       									    	pauname.setString(1,mynameauthor);
		    	       									    	pauname.setString(2,myidauthor);
		    	       									    	pauname.executeUpdate();
		    	                       							
		    	                       							
		    	       									    	JOptionPane.showMessageDialog(upaubutton ,
		    	                       		                             "One Book Successfully updated");  */  
		    	                       							
		    	                       							
		    	                       /* Statement stmtauthor = con.createStatement(); 
		    	                       	                   
		    	                       			        
		    	                          / / update name of book query         			                      
		    	                        String authorquery =  "UPDATE finalbook (set AuthorName = '" +mynameauthor+  "' WHERE BookId = '" +myidauthor+ "')"; 
		    	                       			                      
		    	                       			                      
		    	                       			            int xauthor = stmtauthor.executeUpdate(authorquery); 
		    	                       			              
		    	                       			            if (xauthor > 0)             
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(upaubutton ,
		    	                       		                             "One Book Successfully updated");          
		    	                       			            else
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(upaubutton ,
		    	                       		                          "Opps ! Error ");*/
		    	                       		             
	    	                       							}
	    	                       						 catch(Exception bname2) 
	    	                       					        { 
	    	                       							 JOptionPane.showMessageDialog(upaubutton ,
	    	                       		                             "Book Not exist");
	    	                       							 System.out.println(bname2);
	    	                       					        } 
	    	                       						
	    	                       						}
	    	                                          });
	               						 

	               								JButton resetup2 = new JButton("Go back"); 
	               								resetup2.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								resetup2.setSize(300, 50); 
	               							    resetup2.setLocation(500, 450); 
	               							    resetup2.setBackground(Color.WHITE);
		               						    resetup2 .setForeground(Color.BLACK);
		               							upaunameframe.add(resetup2);   
		               							
		               							resetup2.addActionListener(new ActionListener()   
  	                                          {
  	                                       	  
  	                       						public void actionPerformed(ActionEvent e) 
  	                       						{
  	                       							updateframe.setVisible(true);
  	                       							
  	                       						}
  	                                          });
		               							
	               							  
	               							
	               					    	 upaunameframe.add(upaunameheadline);
	               					    	 upaunameframe.setVisible(true);
	               						     upaunameframe.setSize(800,800);
	                       							
	                       							
	                       					
	                       							
	                       						}
	                       						});
	             									
	             								// Author name update action end
	            									
	            									
	            								
	            									
	            									// 3.Price 
	               						             
	            									JButton upprice = new JButton("3. BooK Price "); 
	            									upprice .setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
	            									upprice .setBackground(Color.WHITE);
	            									upprice .setForeground(Color.BLACK);
	            									upprice .setSize(230,50); 
	            									upprice .setLocation(50, 300); 
	            									updateframe.add(upprice );
                                                     // Add Action for updating price
		             								
	             									upprice.addActionListener(new ActionListener()   // ADD button action start
	                                                 {
	                                       	  
	                       						      public void actionPerformed(ActionEvent e) 
	                       						      {
	             									
	             									
	             									
	                       							 JFrame  priceframe = new JFrame("Book Price  Acivity");
	               						             priceframe.getContentPane().setBackground(Color.BLACK);
	               						         
	               						             // Main  Label1
	               						           JLabel pricenameheadline = new JLabel("Update Book Price " , JLabel.CENTER);
	               						           pricenameheadline .setVerticalAlignment(JLabel.TOP);
	               						           pricenameheadline .setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
	               						           pricenameheadline  .setForeground(Color.BLUE);
	               						            
	               						        JLabel bookid3 = new JLabel("Enter Book Id : "); 
	               						        bookid3 .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						        bookid3 .setSize(300, 50); 
	               						        bookid3 .setLocation(100, 100); 
	               						      // debook .setBackground(Color.WHITE);
	     									    bookid3 .setForeground(Color.WHITE);
	     									    priceframe .add(bookid3 ); 
	               					          
	               								JTextField idfield3 = new JTextField(); 
	               								idfield3.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								idfield3.setSize(300, 50); 
	               								idfield3.setLocation(500, 100); 
	               								priceframe.add(idfield3 ); 
	               					           
	               					           
	               					           
	               								
	               							    JLabel bkprice = new JLabel("Enter Book Price : "); 
	               							    bkprice .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						    	bkprice.setSize(400,50);
	               							    bkprice.setLocation(100,250);  
	               						    	bkprice .setForeground(Color.WHITE);
	               							     priceframe.add(bkprice);
	               							
	               								JTextField namefield3 = new JTextField(); 
	               								namefield3.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    namefield3.setSize(300,50);
	               							    namefield3.setLocation(500,250);
	               							   priceframe.add(namefield3);
	               								
	               								
	               								
	               							JButton pricebutton = new JButton("Update "); 
	               							 pricebutton  .setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							 pricebutton .setSize(300, 50); 
	               							 pricebutton.setLocation(100, 450); 
	               							 //  debutton .addActionListener(this); 
	               							 pricebutton.setBackground(Color.WHITE);
	               							 pricebutton .setForeground(Color.BLACK);
	               						        priceframe.add( pricebutton );
               								
	               							
	               							   
	               						     pricebutton.addActionListener(new ActionListener()   // upadte button action start
	    	                                          {
	    	                                       	  
	    	                       						public void actionPerformed(ActionEvent e) 
	    	                       						{

    	                       						//		String myidprice = idfield3.getText();
	    	                       						//	String mynameprice = namefield3.getText();
	    	                       							
	    	                       							try {
	    	                       						
	    	                       								String sqlprice = "UPDATE finalbook SET Price=? WHERE BookId=?";
		    	                       							 
	    	                       								PreparedStatement statementp = con.prepareStatement(sqlprice);
	    	                       								statementp.setString(1,namefield3.getText());
	    	                       								statementp.setString(2, idfield3.getText());
	    	                       								
	    	                       								 
	    	                       								int rowsUpdated = statementp.executeUpdate();
	    	                       								if (rowsUpdated > 0) {
	    	                       									JOptionPane.showMessageDialog(pricebutton,
			    	                       		                             "One Book Successfully updated");
	    	                       								
	    	                       								}
	    	                       								
	    	                       								
	    	                       						
		    	                       							
		    	                       						/*	
		    	                       							
		    	                       						 String strprice="UPDATE finalbook SET Price=? WHERE BookId=?";
		    	 									     	 PreparedStatement  prprice=con.prepareStatement(strprice);
		    	 									    	 prprice.setString(1,mynameprice);
		    	 									    	 prprice.setString(2,myidprice);
		    	 									    	 prprice.executeUpdate();
		    	                       							

	    	                       							 JOptionPane.showMessageDialog(pricebutton,
	    	                       		                             "One Book Successfully updated");          
		    	                       							*/
		    	                       							
		    	                       						/* Statement stmtprice = con.createStatement(); 
		    	                       	                   
		    	                       			        
		    	              // update name of book query         			                      
		    	                String pricequery =   "UPDATE finalbook set Price = '" + mynameprice+  "' WHERE BookId = '" +myidprice+ "'"; 
		    	                       			                      
		    	                       			                      
		    	                       			            int xprice = stmtprice.executeUpdate(pricequery); 
		    	                       			              
		    	                       			            if (xprice > 0)             
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(pricebutton,
		    	                       		                             "One Book Successfully updated");          
		    	                       			            else
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(pricebutton,
		    	                       		                             "Opps ! Error ");*/
	    	                       							
		    	                       			         
		    	                       						
		    	                       						
	    	                       							}
	    	                       						 catch(Exception bname3) 
	    	                       					        { 
	    	                       							 JOptionPane.showMessageDialog(pricebutton ,
	    	                       		                             "Book Not exist");
	    	                       					        } 
	    	                       						
	    	                       						}
	    	                                          });
	               						 

	               								JButton resetup3 = new JButton("Go back"); 
	               								resetup3.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								resetup3.setSize(300, 50); 
	               							    resetup3.setLocation(500, 450); 
	               							   resetup3.setBackground(Color.WHITE);
		               						    resetup3 .setForeground(Color.BLACK);
		               							priceframe.add(resetup3);   
		               							
		               							resetup3.addActionListener(new ActionListener()   
  	                                          {
  	                                       	  
  	                       						public void actionPerformed(ActionEvent e) 
  	                       						{
  	                       							updateframe.setVisible(true);
  	                       							
  	                       						}
  	                                          });
		               							
	               							  
	               							
	               					    	 priceframe.add(pricenameheadline);
	               					    	  priceframe.setVisible(true);
	               						     priceframe.setSize(800,800);
	                       							
	                       							
	                       					
	                       							
	                       						}
	                       						});
	             									
	             								// price update action end
	            									
	            								
	            									
	            									
	            									// 4. Go Back 
	            									
	            							
	            									JButton	gobook = new JButton("4. Go Back "); 
	            								    gobook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18)); 
	            									gobook .setBackground(Color.WHITE);
	            									gobook .setForeground(Color.BLACK);
	            									gobook.setSize(230, 50); 
	            									gobook .setLocation(300, 300);
	            									updateframe.add(gobook);
	               						             
	            									// Add action to go back button
	            									
	            									
	    	               							gobook.addActionListener(new ActionListener()   
	    	    	                                          {
	    	    	                                       	  
	    	    	                       						public void actionPerformed(ActionEvent e) 
	    	    	                       						{
	    	    	                       							adminframe.setVisible(true);
	    	    	                       							
	    	    	                       						}
	    	    	                                          });
	    	               						            
	    	               						   
	               						          updateframe.add(updateheadline);
	               						          updateframe.setVisible(true);
	               						          updateframe.setSize(800,800);
	                       						}
	                       						
	                                          });
									
									
									
									
									//  4. delete books 
									
									JButton	debook = new JButton("4. DELETE BOOKS "); 
									debook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18)); 
									debook .setBackground(Color.WHITE);
									debook .setForeground(Color.BLACK);
									debook.setSize(230, 50); 
									debook .setLocation(300, 300);
									
									
									
									
									// delete action 
									
									debook.addActionListener(new ActionListener()   // ADD button action start
	                                          {
	                                       	  
	                       						public void actionPerformed(ActionEvent e) 
	                       						{
	                       							
	                       							JFrame  deleteframe = new JFrame("Delete Acivity");
	               						            deleteframe.getContentPane().setBackground(Color.BLACK);
	               						         
	               						         // admin Label1
	               						             JLabel deleteheadline = new JLabel("Delete Book " , JLabel.CENTER);
	               						            deleteheadline.setVerticalAlignment(JLabel.TOP);
	               						            deleteheadline.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 40));
	               						            deleteheadline  .setForeground(Color.BLUE);
	               						            
	               						        JLabel bookiddd = new JLabel("Enter Book Id : "); 
	               						        bookiddd .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						        bookiddd .setSize(300, 50); 
	               						        bookiddd .setLocation(100, 100); 
	               						      // debook .setBackground(Color.WHITE);
	     									   bookiddd .setForeground(Color.WHITE);
	     									   deleteframe.add(bookiddd ); 
	               					          
	               								JTextField idfielddd = new JTextField(); 
	               								idfielddd.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								idfielddd.setSize(300, 50); 
	               								idfielddd.setLocation(500, 100); 
	               								deleteframe.add(idfielddd ); 
	               					           
	               					           
	               					           
	               								
	               							  JLabel bknamed = new JLabel("Enter Book Name : "); 
	               						       bknamed .setFont(new Font("Consolas", Font.PLAIN, 30)); 
	               						       bknamed.setSize(400,50);
	               						        bknamed.setLocation(100,250);  
	               						      
	               							   bknamed .setForeground(Color.WHITE);
	               							  deleteframe.add(bknamed);
	               							
	               								JTextField namefielddd = new JTextField(); 
	               								namefielddd.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    namefielddd.setSize(300,50);
	               							    namefielddd.setLocation(500,250);
	               							    deleteframe.add(namefielddd);
	               								
	               								
	               								
	               								JButton debutton = new JButton("DELETE "); 
	               							    debutton .setFont(new Font("Consolas", Font.BOLD, 18)); 
	               							    debutton .setSize(300, 50); 
	               							   debutton .setLocation(100, 450); 
	               							 //  debutton .addActionListener(this); 
	               							   debutton.setBackground(Color.WHITE);
	               							debutton.setForeground(Color.BLACK);
	               							deleteframe.add(debutton);
               								
	               							
	               							   
	               							debutton.addActionListener(new ActionListener()   // ADD button action start
	    	                                          {
	    	                                       	  
	    	                       						public void actionPerformed(ActionEvent e) 
	    	                       						{

			    	                                   //    String myidde = idfielddd.getText();
 	                       							     //  String mynameme = namefielddd.getText();
			    	                                           
	    	                       							
	    	                       							try {
	    	                       								
	    	                       								
	    	                       								String sqlde = "DELETE FROM finalbook WHERE BookId=? AND BookName=?";
	    	                    
	    	                       								PreparedStatement statementde = con.prepareStatement(sqlde);
	    	                       								statementde.setString(1, idfielddd.getText());
	    	                       								statementde.setString(2, namefielddd.getText());
	    	                       								
	    	                       								int rowsDeleted = statementde.executeUpdate();
	    	                       								if (rowsDeleted > 0)
	    	                       								{
	    	                       								JOptionPane.showMessageDialog(debutton,
		    	                       		                             "One Book Successfully deleted");
	    	                       								}
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       								
	    	                       							//	String myidde = idfielddd.getText();
		    	                       					//		String mynameme = namefielddd.getText();
		    	                       							
		    	                       							
		    	                       							
		    	                       							/*
		    	                       							  
		    	                       							   String  deletequery="delete from finalbook where BookId=? AND BookName=?";
		    	                       							  
					    	                                           PreparedStatement pdelete=con.prepareStatement(deletequery);
					                                                 	pdelete.setString(1, myidde);
					                                                 	pdelete.setString(2, mynameme);
					                                                	pdelete.executeUpdate();
					    	
					                                                	 JOptionPane.showMessageDialog(debutton,
				    	                       		                             "One Book Successfully deleted"); 
		    	                       							 
		    	                       							*/
		    	                       							
		    	                       							
		    	                       							
		    	                       					
		    	                       						 Statement stmtdelete = con.createStatement(); 
		    	                       	                   
		    	                       			            // Deleting from database 
		    	                       			           /* String deletequery = "DELETE from finalbook WHERE BookId = '" +myidde+  
		    	                       			                    "' AND BookName = '" +mynameme+ "'"; 
		    	                       			                      
		    	                       			            int xdelete = stmtdelete.executeUpdate( deletequery); 
		    	                       			              
		    	                       			            if (xdelete > 0)             
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(debutton,
		    	                       		                             "One Book Successfully deleted");          
		    	                       			            else
		    	                       			             
		    	                       							 JOptionPane.showMessageDialog(debutton,
		    	                       		                             "Opps ! Error ");
		    	                       			           
		    	                       			          
		    	                       				*/
	    	                       								
	    	                       							}
	    	                       						 catch(Exception bhde) 
	    	                       					        { 
	    	                       							 JOptionPane.showMessageDialog(debutton,
	    	                       		                             "Book Not exist");
	    	                       							 System.out.println(bhde);
	    	                       					        } 
	    	                       						
	    	                       							
	    	                       						}
	    	                                          });
	               						 

	               								JButton gb = new JButton("GO Back"); 
	               								gb.setFont(new Font("Consolas", Font.BOLD, 18)); 
	               								gb.setSize(300, 50); 
	               								gb.setLocation(500, 450); 
	               							    gb.setBackground(Color.WHITE);
		               							gb .setForeground(Color.BLACK);
		               							   
	               							  deleteframe.add(gb);
	               							  
	               							  
	               							
	               							
	               								
	               							gb.addActionListener(new ActionListener()   
	    	                                          {
	    	                                       	  
	    	                       						public void actionPerformed(ActionEvent e) 
	    	                       						{
	    	                       							adminframe.setVisible(true);
	    	                       							
	    	                       						}
	    	                                          });
	               					
	               						         
	               					    	   deleteframe.add(deleteheadline);
	               					    	   deleteframe.setVisible(true);
	               						      deleteframe.setSize(800,800);
	                       					
	                       						}
									
	             
	                                          });
									
									
									
		                             // 5. Get user list
									
									JButton userbook = new JButton("5. USER LIST"); 
									userbook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18));
									userbook.setBackground(Color.WHITE);
									userbook.setForeground(Color.BLACK);
									userbook.setSize(230,50); 
									userbook.setLocation(50, 450); 
									
									
									
									// Add action to show books 
									
									
									userbook.addActionListener(new ActionListener()   // ADD button action start
				                               {

				            						public void actionPerformed(ActionEvent e) 
				            						{
				            							

										                   JFrame  showframe = new JFrame("Admin-Get user list");
								      	                   setBounds(450, 190, 1014, 597);
									                       setResizable(false);
				                            	  
				            					            JPanel contentPane;
				            							    JTable jt1;
				            							 
				            						    	contentPane = new JPanel();
				            							    contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
				            						    	setContentPane(contentPane);
				            							    contentPane.setLayout(null);
				            								
				            							
				            							// show boook Label1
												         JLabel showheadline = new JLabel("All Users"  , JLabel.CENTER);
												         showheadline.setVerticalAlignment(JLabel.TOP);
												         showheadline.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 10));
												         showheadline.setForeground(Color.BLUE);
												       // contentPane.add(showheadline);
												       
				            							JScrollPane scrollPane = new JScrollPane();
				            							scrollPane.setBounds(200, 100, 850, 650);
				            							scrollPane.setForeground(Color.WHITE);
				            							contentPane.add(scrollPane);
				            							//My_test obj=new My_test();// with test data
				            							my_mysql2 obj=new my_mysql2();
				            								
				            		String[] column= {"UserId","UserName","Password","Full Name","Mail Id","MobNo","Age"};
				            							
				            						//jt1=new javax.swing.JTable(obj.my_test_select(),column);//test data
				            							jt1 = new JTable(obj.my_db_select(),column);
				            							scrollPane.setViewportView(jt1);
				            							jt1.setRowHeight(60);
				            						
				            							 JTableHeader tableHeader = jt1.getTableHeader();
				            						      tableHeader.setBackground(Color.black);
				            						      tableHeader.setForeground(Color.white);
				            						      Font headerFont = new Font("Verdana", Font.BOLD, 18);
				            						      tableHeader.setFont(headerFont);
				            						      
				            						      tableHeader.setPreferredSize(new Dimension(100, 100));
				            						      
				            							jt1.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 18)); 
				    									jt1.setBackground(Color.WHITE);
				    							 		jt1.setForeground(Color.BLACK);
				    							 		
				    							 		
				    							 		 
				    	                                  JButton btnNewButton2 = new JButton("GO BACK");    
				    	                                  btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 26));
				    	                                  btnNewButton2.setBounds(550,800 ,250 , 99);
				    	                                  btnNewButton2.setForeground(Color.BLACK);
				    	                                  btnNewButton2.setBackground(Color.WHITE);
				    	                                  contentPane.add(btnNewButton2);
				    	                                
				    	                                  btnNewButton2.addActionListener(new ActionListener()   // ADD button action start
				    	                                          {
				    	                                       	  
				    	                       						public void actionPerformed(ActionEvent e) 
				    	                       						{
				    	                       							adminframe.setVisible(true);
				    	                       							
				    	                       						}
				    	                                          });
				            							
				    	                                  showframe.add(showheadline);
				            						    
				            							 showframe.add(contentPane);
				            							 
									        
				                                         showframe.setSize(1000, 1000);   // setting width and height for frame
				                                         showframe.setVisible(true);
				                                         contentPane.setBackground(Color.BLACK);
				                                     //	showframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				            							
				            							
				            							
				            						}
				            						
				                               });
									
									
							
									
									//  4. delete books 
									
									JButton	bbook = new JButton("6. Home Page "); 
									bbook.setFont(new Font("Bahnschrift SemiBold", Font.BOLD, 18)); 
									bbook .setBackground(Color.WHITE);
									bbook .setForeground(Color.BLACK);
									bbook .setSize(230, 50); 
									bbook .setLocation(300, 450);

									bbook.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent e)
												{
													mainframe.setVisible(true);
												}
											});
									
									
									
			
							         adminframe.add(addbook);
							         adminframe.add(showbook);
							         adminframe.add(upbook);
							         adminframe.add(debook);
							         adminframe.add(userbook);
							         adminframe.add(bbook);
							         adminframe.add(adminheadline);
							         adminframe.setSize(700, 700);   // setting width and height for frame
							         adminframe.setVisible(true);
							     	//adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						         
								}// if close
								
								else {
									   JOptionPane.showMessageDialog(adminframe, "Unauthorized Access");
								}
						
							}
						});
						
			
			     adminframe.add(username); 
				 adminframe.add(tname);   
				 adminframe.add(name); 
				 adminframe.add(tmno);
				 adminframe.add(sub); 
				 adminframe.add(reset);
				 adminframe.add(adminheadline);
		         adminframe.setSize(700, 700);   // setting width and height for frame
		         adminframe.setVisible(true);
		     //	 adminframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 
				   
				
			}
		});
		
 		    mainframe.add(jUserName);
            mainframe.setSize(700, 700);   // setting width and height for frame
            mainframe.setVisible(true);
        	mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        

		public static void main(String[] args) throws CloneNotSupportedException, IOException,InputMismatchException,IndexOutOfBoundsException, ClassNotFoundException, SQLException,NumberFormatException
	{
 		
			JFrame runFrame = new JFrame();
			EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	//GetAll frame = new GetAll();
	                /*	JFrame chatFrame = new JFrame("Chat Acivity");
	                	JButton chatMe = new JButton ("Start Chat server");
	                	chatFrame.add(chatMe);
	                	

	                	chatMe .addActionListener(new ActionListener()   // ADD button action start
	                               {

	            						public void actionPerformed(ActionEvent e) 
	            						{
	            							new Server();
	            							
	            						}
	                               });
	                	chatFrame.setSize(400,400);
	                	chatFrame.setVisible(true);*/
	                	
	                	GetAll frame = new GetAll();
	                	
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    JOptionPane.showMessageDialog(runFrame, "Unauthorized Access");
	                    runFrame.setVisible(true);
	                    runFrame.setSize(100,100);
	                    
	                }
	            }
	        });
			
	
		
		/*Book store =  new Book(); 
    	Admin admin = new Admin();
    	User us = new User();
    	
 
    	Scanner scan = new Scanner(System.in);
    	System.out.println();
		System.out.println("====================================================================================================================================");
		System.out.println("Welcome to E- Book Store");
		System.out.println("=====================================================================================================================================");
		int choice;
		
		// Database connectivity

	    Class.forName("com.mysql.jdbc.Driver");  
	    
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Tina");
		
		System.out.println("Connection Established");
		

		
//try {		
		do {
			
		    
			System.out.println();
			System.out.print("1.Admin\n" +"2.User\n" + "3.Exit\n");
			
			System.out.println("Enter your Choice := ");
			choice= scan.nextInt();
			System.out.println();		
		      boolean 	be ;
		   
			switch(choice) {
			case 1:{
				
				         admin.adminLogin();
				         System.out.println("=====Admin Side=== ");
					      //admin.adminChat();
				
				do {
					System.out.println();
					System.out.print("1.AddBooks\n" +"2.Show Books\n"+"3.Update Book\n"+"4.Delete book\n"+"5.Get User List\n"+"6.Exit\n");
					System.out.println("Enter your Choice");
						choice= scan.nextInt();
						System.out.println();
					switch(choice) {
					case 1:
					{
						
						  
						
						   String mybook="
					    	PreparedStatement p2=con.prepareStatement(mybook);
					    	
					    	admin.addBook();
					    	p2.setInt(1, admin.bkid);
					    	p2.setString(2, admin.bookName);
					    	p2.setString(3, admin.author);
					    	p2.setInt(4, admin.price);
					    	p2.setString(5, admin.lang);
					    	p2.setInt(6, admin.qty);
					    	 
					    	
					    	p2.executeUpdate();
					    	System.out.println("Data inserted");
					  
					break;
					}
					case 2 :
					{
						System.out.println("-------Current Added Book --------- ");
						admin.showBooks();
						
						System.out.println();
						System.out.println();
						System.out.println("-----Books Present in Database -------");
						System.out.println();
						
						  String show="select *from books";
					    	Statement stmt = con.createStatement();
					    	ResultSet result =stmt.executeQuery(show);
					    	while(result.next())
					    	{
					    		System.out.println("Book Id:"+result.getInt(1)+"    Book Name:"+result.getString(2)+"     Author Name:"+result.getString(3)+"     Book Price:"+result.getInt(4)+"    Language : "+result.getString(5)+"    Copies Count :"+result.getInt(6));
					    		System.out.println();
					    	}
						
						
						
					break;
					}
					case 3:
					{
						int book_id , Bprice ;
					    String bkname , Auname;
						
						 BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
						 Scanner up = new Scanner(System.in);
						
							System.out.println(" Enter the Book id you want to Update");
							 book_id = up.nextInt();
							 
							 
								int ch;
								
								do {
									System.out.println("What do you want to Update");
									System.out.println("1.Book Name\n2.Author Name\n3.Price\n4.Copies_Count\n5.Exit");
									System.out.println("Enter your choice:");
									ch = up.nextInt();
									switch(ch) {
									case 1:
									{
										System.out.println("Enter the New Name");
										 bkname = bu.readLine();
										 
										 
										 
										    String str1="update books set BookName=? where BookId=?";
									    	PreparedStatement p3=con.prepareStatement(str1);
									    	p3.setString(1,bkname);
									    	p3.setInt(2,book_id);
									    	p3.executeUpdate();
										 
										 
										 
										System.out.println();
										System.out.println("..........Book Name Updated successfully.............");
									break;
									}
									case 2:{
										System.out.println("Enter the new Author name");
										 Auname = bu.readLine();
										
										 
										 String str2="update books set AuthorName=? where BookId=?";
									    	PreparedStatement p4=con.prepareStatement(str2);
									    	p4.setString(1,Auname);
									    	p4.setInt(2,book_id);
									    	p4.executeUpdate();
										 
										 
										 
										System.out.println();
										System.out.println("............Author Name Updated successfully.......");
									break;
									}
									case 3:{
										System.out.println("Enter the new price");
										 Bprice = scan.nextInt();
										
										 
										 String str2="update books set Price=? where BookId=?";
									    	PreparedStatement p4=con.prepareStatement(str2);
									    	p4.setInt(1,Bprice);
									    	p4.setInt(2,book_id);
									    	p4.executeUpdate();
										 
										System.out.println();
										System.out.println("......Book Price Updated successfully..............");
									break;
									}
									
									case 5:break;
									
									default:System.out.println("Invalid choice");
								}
						}while(ch!=5);
		
					    	
					    	System.out.println("Updated Books");
					    
						
						break;
					}
					case 4:{
						
						  String str5="delete from books where BookId=?";
					    	int id1=0;
					    	System.out.println("Enter the id of the Book");
					    	id1=scan.nextInt();
					    	PreparedStatement p5=con.prepareStatement(str5);
					    	p5.setInt(1,id1);
					    	p5.executeUpdate();
					    	
					    	System.out.println("Record deleted");
						 
						
						break;
					}
					case 5:
					{
						 us.getUserList();
						 
						 
						 System.out.println();
						 System.out.println();
						 
						 
						 
						 String str4="select * from UserRegr";
					    	Statement stmt=con.createStatement();
					    	ResultSet rs4=stmt.executeQuery(str4);
					    	while(rs4.next())
					    	{
       System.out.println("   Name:"+rs4.getString(1)+"   User name:"+rs4.getString(2)+"   Mail-Id:"+rs4.getString(3)+"   Phone No:"+rs4.getInt(4)+
 	"   Age :"+rs4.getInt(5)+" Passsword:  "+rs4.getString(6)+"  Password :"+rs4.getString(7) );
					    	}
						 
						 
						 
						 
						 
						 
						 
						 
						 break;
					}
					case 6 :
					 
						break;
					
				}
		
			}while(choice!=6);
					
		      
			} break;
			case 2:
			   {
				do {
					System.out.println();
					System.out.print("1.Register\n" +"2.Login\n" +"3.Exit\n");
					
					System.out.println("Enter your Choice");
					Scanner sc = new Scanner(System.in);
					choice= sc.nextInt();
					
					
					System.out.println();
					switch(choice)
			        {
					case 1:
					{
						
					
						String myuser="insert into UserRegr values(?,?,?,?,?,?,?)";
					    	PreparedStatement pu1=con.prepareStatement(myuser);
					    	
					    	us.register();
							    
					    	pu1.setString(1, us.name);
					    	pu1.setString(2, us.uname);
					
					    	pu1.setString(3, us.mail_id);
					    	pu1.setInt(4, us.phone_no);
					    	pu1.setInt(5, us.age);
					    	pu1.setString(6, us.password);
					    	pu1.setString(7, us.cpassword);
					    	 
					    	
					    	pu1.executeUpdate();
					    	
					    	System.out.println("Data inserted");
					
						break;
					}
					case 2 :
				    {
				    	Timestamp timestamp = new Timestamp(new Date().getTime());
				    	
				    	String myuser="insert into login values(?,?,?)";
				    	PreparedStatement pu1=con.prepareStatement(myuser);
				    	
				
				    	 int ind = us.login();
				           
				    	pu1.setString(1, us.uname1);
				    	pu1.setString(2, us.password1);
				        pu1.setTimestamp(3, timestamp);
				    
				    	pu1.executeUpdate();
			
				    	
				    	// check if the same record present in userRegr
				    	
       String checkit = "SELECT UserName, Password2  FROM login WHERE (UserName, Password2) NOT IN (SELECT UserName, Password2 FROM UserRegr WHERE UserRegr.Password2 = login.Password2)";
				    	
       Statement checking=con.createStatement();
       ResultSet rslo=checking.executeQuery(checkit);
       
          if((checkit!= null && !checkit.isEmpty()) ||(ind>=0))
          {
        	  
        	  System.out.println("Your Entry Present in DataBase\n");
        	  
        	  
        	  			
							System.out.println(" .....Login Successfully.. \n");
						do 
						{
							System.out.println();
							System.out.println("1.Show User Profile\n"+"2.Search Book\n"+"3.Search History\n"+"4.Check User count\n"+"5.Exit");
							System.out.println("Enter your Choice");
								choice = sc.nextInt();
								System.out.println();
							switch(choice) 
							{
							case 1: 
							{	
								if((ind>=0))
								{		
								
							 	   System.out.println("------Shows Current Register User Profile -----");
								    us.showUserProf(ind);
								    System.out.println("");
								    System.out.println("");
							     }
								else
								{		
								  
								    System.out.println("As you are regular user .. Your Profile is present in database ");
								    System.out.println("");
								    System.out.println("");
								   
								   String str4="select * from UserRegr";
							    	Statement stmt=con.createStatement();
							    	ResultSet rs4=stmt.executeQuery(str4);
							    while(rs4.next())
							    	{
  System.out.println("       Name:"+rs4.getString(1)+"         User name:"+rs4.getString(2)+"           Mail-Id:"+rs4.getString(3)+"     Phone No:"+rs4.getInt(4)+	"         Age :"+rs4.getInt(5)+"        Passsword:  "+rs4.getString(6)+"           Password :"+rs4.getString(7) );
                      
                 System.out.println(); 
                 
                  
							    	}
							    	
							    
							}  // close else
							    
							    break;
							}
								    
									
							case 2:
							{  
								System.out.println("Search Book ");
								System.out .println("1. Search Book in your Saved History");
								System.out .println("2. Search Book in Database");
								int choice1 = scan .nextInt();
								
							switch(choice1)	
							{			
							
							case 1 : 
								admin.searchBook(ind);
								System.out.println();
			                  break;
							case 2 :
							{
							
							 String searching="select * from books where BookId=?";
						    	int id=0;
						    	System.out.println("Enter the id of the Book");
						    	id=sc.nextInt();
						    	PreparedStatement p1=con.prepareStatement(searching);
						    	p1.setInt(1,id);
						    	ResultSet result=p1.executeQuery();
						    	
						    	while(result.next())
						    	{
					
			
						    	
					System.out.println("Book Id:"+result.getInt(1)+"    Book Name:"+result.getString(2)+"     Author Name:"+result.getString(3)+"     Book Price:"+result.getInt(4)+"    Language : "+result.getString(5)+"    Copies Count :"+result.getInt(6));				    	
						    	
					  System.out.println();
	                  	    	
					
						    	}
							 break;
							}
						
							}
							break;
							}		
							case 3:
							{
							System.out.println("It shows your Today's serach book history ");
								if((ind>=0))
								{		
								
								admin.bookHistory();
								}
								else
								{
									System.out.println("");
									System.out.println("");
									
									System.out.println("Your Today's book history is empty");
								}
							    break;
							}
						
							
							case 4 : 
							{
								System.out.println("Check how many times you are login into system");
								System.out.println("");
								System.out.println("Enter You UserName :");
								int count=0;
								Scanner sm = new Scanner(System.in);
								String login_name = sm.nextLine();
								
								   final String queryCheck = "SELECT count(*) from login WHERE UserName = ?";
									final PreparedStatement ps = con.prepareStatement(queryCheck);
								    ps.setString(1,login_name);
								    final ResultSet resultSet = ps.executeQuery();
									if(resultSet.next()) {
		    					    count = resultSet.getInt(1);
									}
									
									System.out.println("Your ("+login_name+ " )  login count = " +count);
									
								break;
							}
							
							case 5 : break;
							default : System.out.println("Invalid Choice !!");
							
							}//switch
						}while(choice!=5);	// do close		
			
						
          }		//if close		
						else
						{
							System.out.println("Credentials are wrong!!Please try again");
						}//else close
			break;		
			}
			case 13: 
			{ 
				break;	
				
			}//case 13 close
			
			default: System.out.println("Invalid Choice");
			
			}//switch close
	   }while(choice!=13); // do close
		
				
  } break;// Main case 2 close
  
	case 3:
	{
		break;	
	} 
			
			default: System.out.println("Invalid chooice");
			
		}//main switch case
		}while(choice!=3);

//}
//catch(Exception e)
//{
  // System.out.println("Exception occurs...Try Again!!");	
//} */

    
    	
    
  
	
	}// main close
		
}  // class close
	