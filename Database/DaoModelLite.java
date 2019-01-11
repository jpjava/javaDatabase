package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DaoModelLite 
{
	 
	static Connection c = null;
	  
	    static float payment; 
	    static String payee; 
	    static float payments; 
	    static String payees; 
	    static String df;

  
   //static DaoModel D = new DaoModel(); 
    public static void connect()  throws SQLException 
    {
//    	Connection c = null;        
        String url = "jdbc:sqlite:skrooge_sqlite.db";
    	
        try 
        {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection(url);
           c.setAutoCommit(false);
        } 
        catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
         }
        System.out.println("Opened database successfully1");
     
    }
    
    public void Selecting(String qy) throws SQLException 
	{
    	 
    	
    	Statement stmt = null;
      	    	try
		  { 
		  
		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery(qy);
		
		        while ( rs.next() ) 
		        {
		        
		         payment = rs.getFloat("f_balance");
		      payee  = rs.getString("t_name");
		  
		      df = rs.getString("d_date");
		         
		         
		         System.out.println( "AMOUNT = " + payment);
		        System.out.println( "payee = " + payee );
		         System.out.println( "Date = " + df );
		         
		       
		         //DaoModel.insertRecords(payment, payee );

		         DaoModel.insertRecords(payment, payee, df);
		     
		      }
		      
		      rs.close(); 
		      stmt.close();
		      c.close(); 
		   } 
	catch ( Exception e )
			{
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		   System.out.println("Operation done successfully3");
		   
		  }
  
		
}
