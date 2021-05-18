package BookStore;

import java.util.*;

import DateTime.TestDate;
import java .io.*;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;



public class User
{
	 public  int user_id;
	  public String name ;
	   public String uname;
	public    String mail_id;
	   public int phone_no;
	  public String password;
	  public int age;
	 public   String cpassword;
	 public String uname1;
	 public String password1;
	   
	   
	   
	   LinkedList<User> userlist = new LinkedList<User>();//  for adding user in linked list DS
	   ArrayList<Book> booklist = new ArrayList<Book>();
	   Scanner scan = new Scanner(System.in);
	   
		public String toString()
		{
	           return "Name :   " + name + "\nMailId  :   "+mail_id+"\nPhone :	 " + phone_no +"\nUname : 	" +uname+ "\nPassword : 	 "+password+ "\nAge :	"+age ;
		}
		
		User()
		{
			
		}
		
		User(String name,String mail_id,int phone_no,String uname,String password,int age)
		{
			this.name = name;
			this.mail_id = mail_id;
			this.phone_no =phone_no;
			this.uname = uname;
			this.password = password;
			this.age=age;
		}
		
		public String getName() {
			return name;
		}
		public String getmailId() {
			return mail_id;
		}
		public int getPhone(){
			return phone_no;
		}
		public String getUname() {
			return uname;
		}
		public String getPwd() {
			return password;
		}
		public int getAge()
		{
			return age;
		}
		
		
		
		// User Registration :
		void register()
		   {
			   System.out.println("Welcome to E-Book Store     ");
			   System.out.println("Kindly...Register Yourself!!");
			   
			   System.out.println("*******************************************************************************************************************"); 
			   
			   
			   Scanner sc = new Scanner(System.in);

				System.out.println("Enter Name              :-");
				name= sc.nextLine();
				
				System.out.println("Enter User Name         :-");
				uname= sc.nextLine();
				
				System.out.println("Enter Mail Id           :-");
				mail_id= sc.next();
				
				/*String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				
				boolean validate = mail_id.matches(regex);
			      if(validate == true )
			      {
			    	  
			      }
			      else
			      {
			    	  System.out.println("Invalid Mail-Id");
			      }*/
				
				System.out.println("Enter Mob No              :-");
				phone_no = sc.nextInt();
				System.out.println("Enter Age                 :-");
				age = sc .nextInt();
				
				boolean valid;
				
				System.out.println("Create password           :-");
				password = sc.next(); 
		       
							
			/*	 //Checks to see if password is at least 8 characters. 
	            if (password.length()<8) 
	                {
	                    
	                    System.out.println("::Weak Password :: => Password Must have At Least 8 characters");
	                }

	            //Checks each character to see if it is acceptable.
	            for (int i = 0; i < password.length(); i++){
	                        char c = password.charAt(i);

	                        if (       ('a' <= c && c <= 'z') // Checks if it is a lower case letter
	                                || ('A' <= c && c <= 'Z') //Checks if it is an upper case letter
	                                || ('0' <= c && c <= '9') //Checks to see if it is a digit
	             
	                        ) 
	                        {

	                            valid = true;
	                        } 

	                        else 
	                        {
	                            // tells the user that only letters & digits are allowed
	                            System.out.println("Try Again !!  Only letter & digits are acceptable.");
	                            valid = false;
	                            break;
	                        }

	            }*/
	           
	 
	            System.out.println("Confirm Password :-");
	            cpassword=sc.next();
	         /*   boolean check= password.equals(cpassword);
	            
	            if(check==true)
	            {
	               System.out.println("Password Match");	
	               //return " Password Match";
	               
	            }
	            else
	            {
	             System.out.println("Password do not  Match");
	             System.out.println("Please Enter Correct Password :");
	               cpassword=sc.next();
                   
	               
	               boolean check1= password.equals(cpassword);
		            
		            if(check1==true)
		            {
		               System.out.println("Password Match");	
		               //return " Password Match";
		               
		            }
		            else
		            {
		             System.out.println("Error while typing password ");
		             System.out.println("<<< Try to Refresh and Try Again >>>");
		             System.exit(1);
  
		              // return "Password Do not Match";
		            }
	         
	            }*/
	            
	        userlist.add(new User( name, mail_id, phone_no,uname, password, age));   
	            
	        System.out.println("*******************************************************************************************************************"); 
	        System.out.println("You are registered successfully !!");
	            
	    }
		

		public int login() 
		{
		    Scanner scan = new Scanner(System.in);	
			System.out.println("Enter your user name");
			uname1 = scan.nextLine();
			System.out.println("Enter your Password");
			password1 = scan.nextLine();
			for(User i:userlist) {
		
				if(uname1.equals(i.getUname()) && password1.equals(i.getPwd())) 
				{
					System.out.println("*************************************************************************************************");
					System.out.println();
					System.out.println("========Welcome Back  "+i.getName()+" to E-Book Store =============");
					return userlist.indexOf(i);
				}
			}
			return -1; 
		} 
	   
	  
	   
	    public void showUserProf(int ind) {
			System.out.println(userlist.get(ind));
		}
	   
         
	 // User list
		 
		 public void getUserList() {
				System.out.println("User Name          " + "  MailId       " + "Phone        "  + "User Id   "+"     Password" );
				System.out.println("___________________________________________________________________________________________________________________");
				for(int i=0;i<userlist.size();i++) {
					System.out.println(userlist.get(i).getName() + "        " + userlist.get(i).getmailId() + "            " + userlist.get(i).getPhone()+"           "+userlist.get(i).getUname()+"           "+userlist.get(i).getPwd());
				
					System.out.println("__________________________________________________________________________________________________________________");
				}
				
				System.out.println();
			}
		 
	    /*public void userChat()
	    {
	    	 try 
		     {
		    Socket so = new Socket("127.0.0.1",1234);
		    DataInputStream din = new DataInputStream(so.getInputStream());
		    DataOutputStream dout = new DataOutputStream(so.getOutputStream());
		    

	    	BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	    	
	    	String msgin = " ";
	    	String msgout = " ";
		    

	    	while(!msgin.equals("end"))
	    	{
	    		
	    		msgout = buff.readLine();
	    		dout.writeUTF(msgout);
	    		msgin = din.readUTF();
	    		System.out.println(msgin); // print server message
	    		dout.flush();
	    	}
	    	
	     so.close();
	    	
	    	
	    	
		    	 
		     }
		     catch(Exception e)
		     {
		    	 System.out.println("Client side exception gets handle");
		     }

	    }*/
	    
	    
	    
	        
	        
	       /* public boolean inData(String title) {
	    		for(Book i:booklist) 
	    		{
	    			if(title.contains(i.getBookName()))
	    			{
	    				System.out.println(i);
	    				
	    				return true;
	    				//return books.indexOf(i);
	    			}
	 
	    		} return false;
	    		
	    	}*/
			
				
	       
	 
}
	   
	   
	