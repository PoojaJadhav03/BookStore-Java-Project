
package Chat;

import java.net.*;
import java .io.*;



public class MyUser {

	public static void main(String[] args)
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

	}

}
