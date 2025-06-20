package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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
@WebServlet("/DebitAmount")
public class DebitAmount extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Double amount = Double.parseDouble(request.getParameter("amount"));
		
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		Double useramount=(Double)session.getAttribute("ammount");
		String accountnumber = (String) session.getAttribute("AccNo");
		Integer userid1 = (Integer) session.getAttribute("userid");
		int userid = userid1;
		if(amount>=0) {
			if(amount<=useramount) {
				double balanceamount = useramount-amount;
				BankStatement bankStatement = new BankStatement();
				bankStatement.setDateoftransaction(Date.valueOf(LocalDate.now()));
				bankStatement.setTimeoftransaction(Time.valueOf(LocalTime.now()));
				bankStatement.setTransactionamount(amount+"Dr");
				bankStatement.setBalance(balanceamount);
				bankStatement.setBankaccountnumber(accountnumber);
				bankStatement.setTransactiontype("Debit");
				bankStatement.setUserid(userid);
				
				UserDao userDao = new UserDaoImpl();
				boolean update =   userDao.debitamount(bankStatement);
				
				if(update)
				{
					RequestDispatcher rd = request.getRequestDispatcher("Source.jsp");
					rd.include(request, response);
					writer.println("<center><h1>WithDraw Sucessfully...!!!</h1></center>");
			
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("Source.jsp");
					rd.include(request, response);
					writer.println("<center><h1>WithDraw Not Sucessfully...!!!</h1></center>");
			
				}
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("Debit.jsp");
				rd.include(request, response);
				writer.println("<center><h1>Insufficient Balance</h1></center>");
			}
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("Debit.jsp");
			rd.include(request, response);
			writer.println("<center><h1>Invalid Amount</h1></center>");
		}
		
		
		
	}
}
