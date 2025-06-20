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

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankUserDetails;
@WebServlet("/Login")
public class UserLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		System.out.println(emailid);
		System.out.println(password);
		
		UserDao dao =new UserDaoImpl();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		BankUserDetails userLogin = dao.userLogin(emailid, password);
		
		
		if(userLogin!= null)
		{
			session.setAttribute("name", userLogin.getUsername());
			session.setAttribute("AccNo", userLogin.getAccountnumber());
			session.setAttribute("ammount", userLogin.getAmount());
			session.setAttribute("userid", userLogin.getUserid());
			session.setAttribute("email", userLogin.getUseremailid());
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			writer.println("<center><h2>Invaild Details...!!</h2></center>");
		}
		
	}
}
