package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankUserDetails;
@WebServlet("/registration")
public class UserRegistration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		String emailid =request.getParameter("useremailid");
		String password =request.getParameter("password");
		String mobilenumber =request.getParameter("mobilenumber");
		String address =request.getParameter("address");
		
		BankUserDetails bankUserDetails = new BankUserDetails();
		bankUserDetails.setUsername(username);
		bankUserDetails.setUseremailid(emailid);
		bankUserDetails.setUserpassword(password);
		bankUserDetails.setUsermobilenumber(mobilenumber);
		bankUserDetails.setAddress(address);

		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		UserDao dao = new UserDaoImpl();
		boolean registration = dao.userRegistration(bankUserDetails);
		if(registration)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Please Provide Valid Information</h1></center>");
			
		}
		
	}
}
