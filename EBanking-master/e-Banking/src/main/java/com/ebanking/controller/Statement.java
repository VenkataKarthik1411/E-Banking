package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankStatement;
@WebServlet("/Statement")
public class Statement extends HttpServlet{
	String select = "select * from statements where BankAccountNumber = ?";
	
	String url ="jdbc:mysql://localhost:3306/bankmanagementsystem?user=root&password=12345";
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		HttpSession session = request.getSession();
		String accountno = (String)    session.getAttribute("AccNo");
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
	Connection connection;
	try {
		connection = DriverManager.getConnection(url);
	
		PreparedStatement ps = connection.prepareStatement(select);
		ps.setString(1, accountno);
		ResultSet set = ps.executeQuery();
		
		if(set.isBeforeFirst())
		{
			RequestDispatcher rd = request.getRequestDispatcher("Statement.jsp");
			rd.include(request, response);
			writer.println("<table>"
							+ "<tr>		<th> Transaction_Id </th> "
									 + "<th> DateOfTransaction </th>"
									 + "<th> TimeOfTransaction </th>"
									 + "<th> TransactionAmount </th>"
									 + "<th> Balance </th>"
									 + "<th> AccountNumber </th>"
									 + "<th> TransactionType </th>"
									 + "<th> UserId </th>"
							+ "</tr>");
			while(set.next())
			{
				writer.println("<tr>"
						 + "<td>"+set.getInt("Transaction_Id")+" </td> "
						 + "<td>"+set.getDate("DateOfTransaction")+" </td>"
						 + "<td>"+set.getTime("TimeOfTransaction")+" </td>"
						 + "<td>"+set.getString("TransactionAmount")+" </td>"
						 + "<td>"+set.getDouble("Balance")+" </td>"
						 + "<td>"+set.getString("BankAccountNumber")+" </td>"
						 + "<td>"+set.getString("TransactionType")+" </td>"
						 + "<td>"+set.getInt("User_Id")+" </td>"
				     + "</tr>");

			
			}
			writer.println("</table>");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Statement.jsp");
			rd.include(request, response);
			writer.println("<h1> No Transactions Found </h1>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
		
		
	}
	

