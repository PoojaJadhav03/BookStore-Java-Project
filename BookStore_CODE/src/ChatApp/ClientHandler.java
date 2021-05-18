package ChatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable
{
	
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	
	public ClientHandler(Socket clientSocket ) throws IOException
	{
		this.client=clientSocket;
		in= new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(),true);
		
		
	}
	
  
	  public void run()
	  {
		  
		  try {	
				while(true)
				{	
				String request = in.readLine();	
				if(request.contains("name"))
				{
					out.println(DateServer.getRandomName());
					
				}
				
				else
				{
					out.println("Type 'Tell me a name ' to get a random name");
				}
				
				}
			}
		  
		  catch(IOException e)
		  {
			  System.err.println("IO Exception in client Handler ");
			  System.err.println(e.getStackTrace());
			  
		  }
				
				finally
				{
				out.close();
                try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				}
		  
		  
	  }



	
	
}
