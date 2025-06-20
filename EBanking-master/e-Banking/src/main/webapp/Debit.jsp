<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: orange;
}
input{
padding: 10px;
margin: 5px;
width: 400px;
border-radius: 50px;
align-items: center;
text-align: center;
border: 2px solid royalblue;

}

</style>
</head>
<body>
<center>
<form action="debit" method="post" id= "verify">
<input placeholder="Enter Your AccountNumber" name = "accountnumber">
<br>
<input type="submit">
</form>
</center>

<%
String status = (String) session.getAttribute("msg");

if(status!=null)
{	
	if(status.equals("yes"))
	{
	%>
	<center>
<form action="DebitAmount" method="post">
<input placeholder="Enter Your Amount" name = "amount">
<br>
<input type="submit">
</form>
</center>
<%}
}
%>

</body>
</html>