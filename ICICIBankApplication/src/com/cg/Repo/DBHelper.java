package com.cg.Repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cg.Bean.Account;
import com.cg.Utilities.Connect;

public class DBHelper {
	
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	 public boolean searchRecord(int accNo)   // by existing acc
	{
		try {
			con=Connect.ConnectDB();
			stmt = con.createStatement();
			String sql = "SELECT * FROM account WHERE account_no = '" + accNo +"'";
            rs=stmt.executeQuery(sql);
			return rs.next();
		} catch (Exception e) {
			return false;
		}
	}
	 
	 
	 public boolean insertRecord(Account a)     //call via add new acc
	{
		try {
			con=Connect.ConnectDB();
			stmt = con.createStatement();
			String sql = "INSERT INTO account(account_no,amount) "+ "VALUES('"+a.getAccountNum()+"','"+a.getBalance()+"')";
			int row_affected=stmt.executeUpdate(sql);
            if(row_affected>0)
            	return true;
            else
            	return false;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	 public Account fetchRecord(int accNo)  //existing record to display balance
	{
		try {
			con=Connect.ConnectDB();
			stmt = con.createStatement();
			String sql = "SELECT * FROM account WHERE account_no = '" + accNo +"'";
            rs=stmt.executeQuery(sql);
            rs.next();
            Account ac =new Account();
            ac.setAccountNum(rs.getInt("account_no"));
            ac.setBalance(rs.getInt("amount"));
			return ac;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public boolean updateRecord(Account a)  //by deposit,withdraw & transfer
	{
		try {
			con=Connect.ConnectDB();
			stmt = con.createStatement();
			String sql = "UPDATE account SET amount ='"+a.getBalance()+"' WHERE account_no= "+a.getAccountNum();
			int row_affected=stmt.executeUpdate(sql);
            if(row_affected>0)
            	return true;
            else
            	return false;
			
		} catch (Exception e) {
			return false;
		}
	}

}
