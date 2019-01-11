package application;
 
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import java.sql.*;
import models.DaoModelLite;

/**
 * <h1>Expense any negative income comes through here</h1>
 * @author Justin Pappano 
 * @lab Final Project
 * @class ITMD510
 */

public class Expense implements CashFlow
{

	static ArrayList<List<String>> array = new ArrayList<>(); 
	 static InputStreamReader ir = new InputStreamReader(System.in);
		 static float amt=0;
	
//	static String qy  = "SELECT f_balance, payee.t_name,  operation.d_date FROM operationbalance, operation, payee, "
//			+ "suboperation  WHERE f_balance = f_balance_entered AND f_balance <0  "
//			+ "AND operation.r_payee_id = payee.id AND operation.d_date=suboperation.d_date "
//			+ "AND suboperation.r_category_id = payee.r_category_id ORDER BY f_balance ASC;";
//	
	static int i = 0; 
    static Connection c = null; 
    
    Statement stmt;


	 
	 	DaoModelLite conn;
	 String qy; 
	
	/**
	 * This constructor selects every record in the database that is considered to be an expense
	 * So, every amount that is negative
	 * @throws SQLException 
	 */
	public Expense() throws SQLException
	{

		conn= new DaoModelLite();

		conn.connect();
 
		amountSize();
		
		}
		   
	
	@Override
	//this will count the top largest transactions 
	public void amountSize() 
	{
	
			qy  = " SELECT f_balance, payee.t_name,  operation.d_date FROM operationbalance, operation, "
					+ "payee, suboperation  WHERE f_balance = f_balance_entered AND f_balance <0 AND "
					+ "operation.r_payee_id = payee.id AND operation.d_date=suboperation.d_date AND "
					+ "suboperation.r_category_id = payee.r_category_id LIMIT 5; ";

		try
		{
			conn.Selecting(qy);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		 
    }	
//these are the top 5 dates where transactions have occured 
	public void topDate() 
		{
			
		 
		qy  = "SELECT f_balance, t_name, operation.d_date, count(operation.d_date) AS OCCURANCE "
					+ "FROM operationbalance, operation, payee, suboperation  WHERE f_balance = f_balance_entered "
					+ "AND f_balance <0  AND operation.r_payee_id = payee.id AND operation.d_date=suboperation.d_date "
					+ "AND suboperation.r_category_id = payee.r_category_id GROUP BY operation.d_date ORDER "
					+ "BY OCCURANCE DESC limit 5;";

		try {
			
			conn.Selecting(qy);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		topPayee(); 
		 
	}
	//rank the top 5 payees in order from largest transaction 
	public void topPayee()
	{
		
			qy  = "SELECT f_balance, t_name, COunt(t_name) AS OCCURANCE, operation.d_date FROM operationbalance, operation, "
					+ "payee, suboperation  WHERE f_balance = f_balance_entered AND f_balance <0  AND operation.r_payee_id = payee.id "
					+ "AND operation.d_date=suboperation.d_date AND suboperation.r_category_id = payee.r_category_id ORDER BY payee.t_name "
					+ " DESC limit 5";

		try 
		{
			conn.Selecting(qy);
		} 
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		

	}*/


	 	
}
}
