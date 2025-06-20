
package com.ebanking.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;

import com.ebanking.model.BankStatement;
import com.ebanking.model.BankUserDetails;

public class UserDaoImpl implements UserDao{

	
	Connection connection;
	
	private final String userregistration=
	"insert into bankuserdetails(User_Name, User_EmailId, User_MobileNumber, User_Password,"
	+ " User_AccountNumber, User_IFSCCode, Address, Amount)values(?,?,?,?,?,?,?,?)";
	
	private final String userlogin=
		"Select * from bankuserdetails where (User_EmailId=? or User_MobileNumber=?) and User_Password=?";
	
	private final String url ="jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=12345";
	
	private final String updateAmount = "update bankuserdetails set amount =? where User_AccountNumber=?";
	
	private final String insertStatement = "insert into statements(DateOfTransaction, TransactionType, TransactionAmount, Balance, TimeOfTransaction, BankAccountNumber, User_Id) values(?,?,?,?,?,?,?)";
	
	private final String updatePassword="update bankuserdetails set User_Password=? where User_EmailId=?";
	
	private final String statement = "select * from Statements where BankAccountNumber=? ";
	
	public boolean userRegistration (BankUserDetails bankUserDetails) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			
			PreparedStatement ps = connection.prepareStatement(userregistration);
			
			ps.setString(1, bankUserDetails.getUsername());
			ps.setString(2, bankUserDetails.getUseremailid());
			ps.setString(4, bankUserDetails.getUserpassword());
			ps.setString(3, bankUserDetails.getUsermobilenumber());
			
			Random r = new Random();
			int accountnumber = r.nextInt(10000000);
			if (accountnumber<1000000) {
				accountnumber+=1000000;
			}
			ps.setString(5, accountnumber+"");
			ps.setString(6, "TECA540007");
			ps.setString(7, bankUserDetails.getAddress());
			ps.setDouble(8, bankUserDetails.getAmount());
			
			int res = ps.executeUpdate();
			if(res!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public BankUserDetails userLogin(String emailid,String password)
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			
			PreparedStatement ps =connection.prepareStatement(userlogin);
			 
			ps.setString(1, emailid);
			ps.setString(2, emailid);
			ps.setString(3, password);
			
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				BankUserDetails bankUserDetails = new BankUserDetails();
				bankUserDetails.setUsername(set.getString("User_Name"));
				bankUserDetails.setUseremailid(set.getString("User_EmailId"));
				bankUserDetails.setUserpassword(set.getString("User_Password"));
				bankUserDetails.setUsermobilenumber(set.getString("User_MobileNumber"));
				bankUserDetails.setAccountnumber(set.getString("User_AccountNumber"));
				bankUserDetails.setAmount(set.getDouble("Amount"));
				bankUserDetails.setUserid(set.getInt("User_Id"));
				bankUserDetails.setAddress(set.getString("Address"));
				return bankUserDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean debitamount(BankStatement statementDr) {
		
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(updateAmount);
			ps.setDouble(1, statementDr.getBalance());
			ps.setString(2, statementDr.getBankaccountnumber());
			int result = ps.executeUpdate();
			if(result!=0)
			{
				/*
				 * private final String insertStatement = 
				 * "insert into statements(DateOfTransaction, 
				 * TransactionType, TransactionAmount, 
				 * Balance, TimeOfTransaction,
				 *  BankAccountNumber, User_Id) values(?,?,?,?,?,?,?)";
	
				 */
				
				System.out.println("Amount Debited");
				PreparedStatement ps1 = connection.prepareStatement(insertStatement);
				ps1.setDate(1, statementDr.getDateoftransaction());
				ps1.setString(2, statementDr.getTransactiontype());
				ps1.setString(3,statementDr.getTransactionamount());
				ps1.setDouble(4, statementDr.getBalance());
				ps1.setTime(5, statementDr.getTimeoftransaction());
				ps1.setString(6, statementDr.getBankaccountnumber());
				ps1.setInt(7, statementDr.getUserid());
				
				int result1 = ps1.executeUpdate();
				if(result1!=0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}

	public boolean creditamount(BankStatement statementCr) {
		// TODO Auto-generated method stub
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(updateAmount);
			ps.setDouble(1, statementCr.getBalance());
			ps.setString(2, statementCr.getBankaccountnumber());
			int result = ps.executeUpdate();
			if(result!=0)
			{
				/*
				 * private final String insertStatement = 
				 * "insert into statements(DateOfTransaction, 
				 * TransactionType, TransactionAmount, 
				 * Balance, TimeOfTransaction,
				 *  BankAccountNumber, User_Id) values(?,?,?,?,?,?,?)";
	
				 */
				
				System.out.println("Amount Credited");
				PreparedStatement ps1 = connection.prepareStatement(insertStatement);
				ps1.setDate(1, statementCr.getDateoftransaction());
				ps1.setString(2, statementCr.getTransactiontype());
				ps1.setString(3,statementCr.getTransactionamount());
				ps1.setDouble(4, statementCr.getBalance());
				ps1.setTime(5, statementCr.getTimeoftransaction());
				ps1.setString(6, statementCr.getBankaccountnumber());
				ps1.setInt(7, statementCr.getUserid());
				
				int result1 = ps1.executeUpdate();
				if(result1!=0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean forgetPassword(String emailid, String newPassword) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(updatePassword);
			ps.setString(1,newPassword);
			ps.setString(2,emailid);
			int result=ps.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

}
