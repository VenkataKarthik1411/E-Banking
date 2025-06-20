package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Credit")
public class Credit extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String accountNum= request.getParameter("accountnumber");
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String acc1 =   (String) session.getAttribute("AccNo");
		
		if (accountNum.equals(acc1)) {
			
			RequestDispatcher rd = request.getRequestDispatcher("CreditAmount.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Credit.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invaild AccountNo</h1></center>");
			
			
		}
		
	}
}
