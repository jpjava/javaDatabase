package models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//import com.sun.javafx.collections.MappingChange.Map;

  

public class DaoModel 

{
    //Declare DB objects 
  static  DBConnect conn;
    static Statement stmt;
    //static ResultSet rs = null;
    static int j= 1; 
    // constructor
      
	 final String FILE = "meta.ser"; 
	// constructor
	 public DaoModel() 
    { 
	//create db object instance
	conn = new DBConnect();
	
    }
	 
 
    // CREATE TABLE METHOD
    public void createTable() 
    {
	try 
	    {
		//conn = DBConnect.connect();
		// Open a connection
		System.out.println("Connecting to a selected database to create Table...");
		System.out.println("Connected database successfully...");

		// Execute create query
		System.out.println("Creating table in given database...");

		stmt = conn.connect().createStatement();
		String sql = "CREATE TABLE cashflows " +
				 "(ID INTEGER  AUTO_INCREMENT, " + 
				"payee TEXT ," +
				"payment FLOAT , " +
				"Date TEXT , " +
				"PRIMARY KEY ( ID ) )";
		stmt.executeUpdate(sql);
		System.out.println("Created table in given database...");
		conn.connect().close(); //close db connection 
	    }
	catch (SQLException se) 
	    {
		// Handle errors for JDBC
		se.printStackTrace();
	    }
	
    }
	 
    // INSERT INTO METHOD
    
    public static void insertRecords(float f, String p, String d)
    {
	try 
	    {
		//conn = DBConnect.connect(); 
		// Execute a query
		System.out.println("Inserting records into the table...");
		stmt = conn.connect().createStatement();
		
		// Include all object data to the database table
		
		 
			// finish string assignment to insert all object data 
			// (pid, id, income, pep) into your database table
		  	//ask papdemas if the "cashflow should be deleted
			String sql = "INSERT INTO cashflows (payee, payment, Date) "
			    + "VALUES('"+p+"','"+f+ 
			   "','"+d+"')";
		    
			stmt.executeUpdate(sql);
	    
			conn.connect().close();
    }
		catch(SQLException se)
	    {    
		se.printStackTrace();
	    }
	    }
	
	

    public static ResultSet retrieveRecords()    throws SQLException 
    {
							 
    	ResultSet rs = null;
    	stmt = conn.connect().createStatement();
	String sql = "SELECT * FROM cashflows; ";
	
	rs = stmt.executeQuery(sql);
	//conn.connect().close();
	return rs;
		
    }
    

		
}
