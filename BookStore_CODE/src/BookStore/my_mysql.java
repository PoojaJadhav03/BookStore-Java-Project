package BookStore;

import java.sql.*;
public class my_mysql {

public  String[][] my_db_select() {
////////////
String[][] data = new String[20][8]; // [rows][columns]
	
try{  
	 
	
	
	     Class.forName("com.mysql.jdbc.Driver");  
	    
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin","root","Tina");
		
		System.out.println("Connection Established");
	
		Statement st=con.createStatement();  
	
  ResultSet rs=st.executeQuery("SELECT * FROM finalbook"); 
// Looping to store result in returning array data // 
	int i=0;
	while(rs.next())  {
	 for(int j=0;j<8;j++) {
	 //System.out.print(rs.getString(j+1));
	 data[i][j]=rs.getString(j+1);
	 }
	 //System.out.println();
	 i=i+1;
	}
// Below lines to check data before returning. // 	
/*		
 for (int x=0;x<data.length;x++) {
	 for (int y=0;(data[x]!= null && y <data[x].length);y++) {
		 System.out.print(data[x][y] + " ");
	 }
	 System.out.println();
 }
*/
con.close();  
}catch(Exception e){ System.out.println(e);} 
//////////////////////////////

return data;
	}
}