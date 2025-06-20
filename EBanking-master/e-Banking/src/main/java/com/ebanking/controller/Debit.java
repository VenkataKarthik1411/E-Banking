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
@WebServlet("/debit")

public class Debit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String accountNum= request.getParameter("accountnumber");
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session1 = request.getSession();
		String acc1 =   (String) session1.getAttribute("AccNo");
		
		if (accountNum.equals(acc1)) {
			session1.setAttribute("msg","yes");
			session1.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
			rd.forward(request, response);
		} else {
			session1.setAttribute("msg","no");
			session1.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invaild AccountNo</h1></center>");
			
			
		}
		
	}
}
