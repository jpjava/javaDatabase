package models;


import java.sql.*;

import application.Expense;

 
public class DBConnect

{

	    // Papdemas code database URL
	    static final String DB_URL = "jdbc:mysql://www.papademas.net:3306/fp510?autoReconnect=true&useSSL=false";
	    // Papdemas Database credentials
	    static final String USER = "fpuser", PASS = "510";
	    
	        
 	    public static Connection connect() throws SQLException 
	    {
		
 	    	return DriverManager.getConnection(DB_URL, USER, PASS);
	 
	    }
}
