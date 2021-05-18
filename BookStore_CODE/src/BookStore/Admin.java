package BookStore;

import java.util.*;

import DateTime.TestDate;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Admin 
{
	
	int admin_id;
	String Name;
	
	
	ArrayList<Book>books = new ArrayList<Book>();
	 
	//List<String>mylang = new ArrayList<String>();
	
	Scanner scan = new Scanner(System.in);
	 LinkedList<User> useR = new LinkedList<User>();
	
	Map<Integer,String> map1 = new HashMap<Integer,String>();
	Map<Integer,String> map2 = new HashMap<Integer,String>();
	public int bkid;
	public String bookName;
	public String author;
	public int price;
	public String lang;
	public int qty;
	
	// updated names 
	
	
    
	  
    
	
	
	
	
	
	
	
	
	
	
	
	 
		Admin()
	{
		
	}
	   
	  /* Admin()
	   {
		   this.Name    = "Pooja";
		   this.admin_id = 33;
	   }*/
		
 // Login function works 
		
	   public void adminLogin() throws CloneNotSupportedException  
		{
		    map1.put(33, "Pooja");
		    
			System.out.println("Enter Your  Admin_id  :");
			int  id = scan.nextInt();
			System.out.println("Enter Your User Name  :");
			String name = scan.next();
			map2.put(id, name);		
	      
			boolean be = map1.equals(map2);
			 if(be==true)
			 {
				 System.out.println("___Admin Login Successfully_______!!");
			 }
			 else
			 {
				 System.out.println("___Unauthorized Access ____!!");
				 System.out.println("<<< WARNING DATA MAY LOSS >>> ");
				 System.exit(1);
			 }
			
   
		}
	// Show function works
	public void showBooks() 
	{
		System.out.println("Book Id| "+"Book Name|" + "   Author Name|" + "   Price |"  +" Book Language (By Default) |  "+ "    Copies_Count|  " );
		//System.out.println("Number of languages avilable for this book :");
		
		
		System.out.println("_________________________________ __________________________________________________________________________________");
		for(int i=0;i<books.size();i++)
		{
		System.out.println(books.get(i).getId()+"           "+books.get(i).getBookName() + "       " + books.get(i).getAuthorName() + "          " + books.get(i).getBookPrice()+"        "+books.get(i).getLang() + "             "+books.get(i).getQty());
		
		System.out.println("_________________________________ _______________________________________________________________________________________");
		
		/*for(String ed : mylang)
		{
			System.out.println(ed);
		}*/
		
		
	}
	
		
		
	}//fn end
	
	
	
	
	
	//for adding single book
	public void addBook() throws IOException {
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the Book Id:");
		 bkid = scan.nextInt();
		
		System.out.println("Enter the Book Name : ");
			 bookName = buff.readLine();
			int check = inStock(bookName);
			/*if(check!=0)*/
			if(check>0)
			{
				System.out.println("This Book is Already Present");
				/*System.out.println("How many more books you want to add");
				int qty = scan.nextInt();
				books.get(check).addQty(qty);
				System.out.println("Book added successfully");*/
				
			}
			else {	
				System.out.println("Enter the Author Name :");
				 author = buff.readLine();
				System.out.println("Enter  Price of the  book");
				 price = scan.nextInt();
				
			
				 
			    int count=1;
				System.out.println("Enter the Language  :");
				 lang = buff.readLine();
			
				//mylang.add(lang);
				
			/* String langName;
			    
				 do
				 {
					 System.out.println("You can add only 3 languages ------English/Hindi/Marathi");
					 System.out.println("1 . Add More Languages ");
					 System.out.println("2 . Exit ");
					 System .out.println("Enter Your choice : ");
					 op= scp.nextInt();
	    	
	    	 switch(op)
	    	 {
	    	 case 1 : 
	    	    System.out.println("Enter the Language  :");
				langName = buff.readLine();
				//mylang.add(langName);
				count++;
				if(count>3) {  break; }
				break;
	    	 case 2: break;
	    	 
	    	 default: System.out.println("Invalid Option ");
	    	 }
	    
	      }while(op!=2); */

	
				System.out.println("Enter Number of copies  your Uploading:");
				 qty = scan.nextInt();
			
			//	System.out.println("Number of languages are " +count);
				
				
					
						 books.add(new Book(books.size(),bookName,author,price,lang,qty));

			 
						 System.out.println();
					 
				System.out.println("Books Added successfully");
			}
		
	}
	
	public int inStock(String title) {
		for(Book i:books) 
		{
			if(title.equals(i.getBookName()))
			{
				System.out.println(i);
				
				return 1;
				//return books.indexOf(i);
			}
		}
		return 0;
	}
	
	// For adding multiple books 
	/* public void addBooks() throws IOException
	 {
		 Scanner sc = new Scanner(System.in);
		 int option;
		 System.out.println("Add book to the System");
		 this.addBook();
		 do
		 {
			 System.out.println("1 . Add More Books ");
			 System.out.println("2 . Exit ");
	    	 System .out.println("Enter Your choice : ");
	    	 option = sc.nextInt();
	    	
	    	 switch(option)
	    	 {
	    	 case 1 : this.addBook();break;
	    	 case 2: break;
	    	 
	    	 default: System.out.println("Invalid Option ");
	    	 }
	    
	      }while(option!=2);
		 
     }*/
	 
	 
	
	 
	 // Delete Book 
	 
	/* public void delete()
	 {
		 Scanner de = new Scanner(System.in);
		  System.out.println
			System.out.println("Enter the Book Id of book you want to delete from currently added System");
			int book_id = de.nextInt();
			books.remove(book_id);
	        System.out.println(".........Book Removed Successfully......");
	        //de.close();
	} */
	
	// Update Book
	 
	/* public void updateBook() throws IOException
	 {
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
				case 1:{
					System.out.println("Enter the New Name");
					 bkname = bu.readLine();
					//books.get(book_id).setName(bkname);
					System.out.println();
					System.out.println("..........Book Name Updated successfully.............");
				break;
				}
				case 2:{
					System.out.println("Enter the new Author name");
					 Auname = bu.readLine();
					//books.get(book_id).setAutName(Auname);
					System.out.println();
					System.out.println("............Author Name Updated successfully.......");
				break;
				}
				case 3:{
					System.out.println("Enter the new price");
					 Bprice = scan.nextInt();
					//books.get(book_id).setPrice(Bprice);
					System.out.println();
					System.out.println("......Book Price Updated successfully..............");
				break;
				}
				
				case 5:break;
				
				default:System.out.println("Invalid choice");
			}
	}while(ch!=5);
		
	 
	 }*/
	 
	 
	 
	 public void searchBook(int index)throws IOException
     {
			int flag=0;
			
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the Name of Book you want to Search  : ");
			String title = buff.readLine();
		     
			for(Book i:books)
			{
				 if(title.equals(i.getBookName())) 
				 {
				 
					System.out.println(i);
					System.out.println("Book is Avilable");
					flag=1;
					
					//System.out.println("Available Languages :");
					//System.out.println(mylang);
					
					
					System.out.println();
					
					System.out.println("Enter the copies _count of book :  ");
					int qty = Integer.parseInt(buff.readLine());
					
					int store = i.getQty();
					int test;
					if(store>=qty) 
					{
						test = i.decQty(qty);
						System.out.println("Book Downloaded");
						//total += i.getBookPrice()*qty;
						//System.out.println("Total = : "+total);
						 summary(i,qty);
						
						break;
					}
					
					else
					{
						System.out.println("Sorry!!!Stock not available.You can buy "+ i.getQty() +" book");
					}
					
				}
			
	}
			
			
			if(flag==0)
			{
				System.out.println("Book Is not Available in your Saved history");
			}
			
			
			
			
     }
	 
	 
	 public void bookHistory()
     {
		System.out.println("Id |"+"Title | "+"Author Name |"+"Price |"+"Copies_Count ");
		System.out.println("___________________________________________________________________________________________________________________");
		for(int i=0;i<books.size();i++) 
		{
		System.out.println(books.get(i).getBookName() + "       " + books.get(i).getAuthorName() + "        " + books.get(i).getBookPrice()+"      "+books.get(i).getQty());
		System.out.println("___________________________________________________________________________________________________________________");
		
		}
		System.out.println();
		
		
     }
	 
	 
	 
	 
	 
	//Bill Generation 
		
	    public void summary(Book b,int qty)
	    {
			System.out.println("\n_____________________________ ---Recipt --  _____________________________________________________________\n");
			
			System.out.println("Book_Id|"+"Book Title|"+"Book Price|"+" Book Language|" + "Book Downloaded| "+"Total Amount");
			System.out.println("_______________________________________________________________________________________________________________");
			
			System.out.println(b.getId()+"              " +b.getBookName()+"                 "+b.getBookPrice()+"                   "+ b.getLang()+"           "+qty+"                     "+b.getBookPrice()*qty);
			books.add(new Book(b.getId(),b.getBookName(),b.getAuthorName(),b.getBookPrice(),b.getLang(),qty));
			
			System.out.println();
			
			
			TestDate dow = new TestDate();
	
			 dow.dateTime();
			
		}
	    
	    
	    
	     public void adminChat()
	    {
	    	 try
	         {
	    		 System.out.println("Connecting with Admin ......");
	        	 ServerSocket ss = new ServerSocket(1234);
	        	 Socket so = ss.accept();
	        	 
	        	 //Scanner scan = new Scanner (so.getInputStream());
	        	 
	        	 
	        	DataInputStream din = new DataInputStream(so.getInputStream());       // getting input from client
	        	DataOutputStream dout = new DataOutputStream(so.getOutputStream());  // sending output to client
	        	
	        	BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	        	
	        	String msgin = " ";
	        	String msgout = " ";
	        	
	        	
	        	while(!msgin.equals("end"))
	        	{
	        		
	        		msgin = din.readUTF();
	        		System.out.println(msgin);
	        		msgout = buff.readLine();
	        		dout.writeUTF(msgout);
	        		dout.flush();
	        	}
	        	
	         so.close();
	        	 
	         }
			catch(Exception e) {
				System.out.println("Handle Exception");
			}
			
	    } 
	    
	    
	    
	    
	    
	    
	    

			
   }
	 
	 
	 
	 
	 // My Method
		/*
		 * 
		 * 
		 * for(Book i:books)
		{
			boolean bts = title.equalsIgnoreCase(i.getBookName());
			
			if(bts==true)
			{  
				System.out.println(i);
				flag=1;
				break;	
			}		
				
		}
		
		if(flag==1)
		{
			System.out.println("Book Found");
		}
		else
		{
			System.out.println("Book Not Found");
		}
		 * 
		 * 
		 */
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	

