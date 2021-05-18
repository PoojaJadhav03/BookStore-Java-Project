package ChatApp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client
{
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;

	public static void main(String[] args) throws IOException ,ConnectException 
	{
		Socket socket = new Socket(SERVER_IP , SERVER_PORT);
	    BufferedReader	input= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		
		
		while(true) 
		{
	
		
		System.out.println(">");
		String command = keyboard.readLine();
		
		if(command.equals("quit")) break;
		
		out.println(command);
		
	  String  serverResponse = input.readLine();
	  System.out.println(" SERVER SAYS  : " +serverResponse);
		
		
		//JOptionPane.showMessageDialog(null, serverResponse);
		
		}
		
		
		
		/*try {
		
		  DataInputStream din = new DataInputStream(socket.getInputStream());
		    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		    

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
	    	
	     socket.close();
	    	
	    	
	    	
		    	 
		     }
		     catch(Exception e)
		     {
		    	 System.out.println("Client side exception gets handle");
		     }
		*/
	
  socket.close();
	  System.exit(0);
		
	}

}
