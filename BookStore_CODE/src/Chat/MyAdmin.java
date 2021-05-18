package Chat;

import java.io.*;
import java .util.*;
import java.net.*;


public class MyAdmin {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
         try
         {
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
