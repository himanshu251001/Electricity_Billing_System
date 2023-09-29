package electricity.billing.system;

import java.sql.*;
public class connect {
  Connection c;
  Statement s; //statement Interface
	connect()
	{
           try {
	  Class.forName("com.mysql.cj.jdbc.Driver");	                                                  // 1.register the driver class
	  c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","harharmahadev");  // 2.Creating the connection
           s=c.createStatement();                                                                                 // 3.Creating Connection Statement
                                                                           //executing mysql Queries 
           } 
            catch(Exception e)
            {
                e.printStackTrace();
            }
                
        }
            
}

