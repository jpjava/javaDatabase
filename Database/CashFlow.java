package application;

import java.sql.SQLException;

public interface CashFlow  
{
  abstract void amountSize();//fomrs a tally of the top 5 largest expenses
  abstract void topDate() throws SQLException; //forms a tally of the top 5 most used categories
  abstract void topPayee(); //forms a tally of the top 5 Payees

}
