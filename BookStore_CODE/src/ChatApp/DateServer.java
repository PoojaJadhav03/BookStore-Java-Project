package ChatApp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;



public class DateServer
{
	
	private static String names[]= {"UserName : Pooja",   "UserName :Elec","UserName :Greta",  "UserName :Shreya"};
	private static String adjs[] = {" --Response from Server --",  "--Response from Server --"," --Response from Server -- ", " --Response from Server --" };
	private static final int PORT = 9090;

	private static  ArrayList<ClientHandler> clients= new ArrayList<>();
	private static ExecutorService pool = Executors.newFixedThreadPool(4);
	
    
	public static void main(String[] args) throws IOException
	{
		ServerSocket listener = new  ServerSocket(PORT);
		
		while(true)
		{		
		System.out.println("[Server] waiting for client connection ... ");
		Socket client = listener .accept();
		System.out.println("[Server] Connected to client ! ");
		
		ClientHandler clientThread = new ClientHandler(client);
		clients.add(clientThread);
		
		pool.execute(clientThread);
		
		
		/*try {
	 	 
    	DataInputStream din = new DataInputStream(client.getInputStream());       // getting input from client
    	DataOutputStream dout = new DataOutputStream(client.getOutputStream());  // sending output to client
    	
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
    	
     client.close();
    	 
     }
	catch(Exception e) {
		System.out.println("Handle Exception");
	}*/
	

	}
	
	}
	
	
 	public static String getRandomName()
	{
 		
		String name = names[(int) (Math.random() * names.length ) ];
		String adj = adjs[(int) (Math.random() * adjs.length ) ];
	
		
		return name + " " +adj;
		
	}
	
	

}
