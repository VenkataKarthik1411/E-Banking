package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String emailId=request.getParameter("emailId");
		String npassword=request.getParameter("npassword");
		String cpassword=request.getParameter("cpassword");
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		
		if(npassword.equals(cpassword))
		{
			UserDao dao = new UserDaoImpl();
			
		boolean status =	dao.forgetPassword(emailId, cpassword);
			if(status)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Source.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Password Updated Sucessfully...!!!</h1></center>");
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Source.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Password Not Updated...!!!</h1></center>");
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.include(request, response);
			
			writer.println("<center><h1>Invaild Confirm Password</h1></center>");
		}
		
	}
}
