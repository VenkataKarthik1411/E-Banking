<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: RoyalBlue;
}
input{
padding: 10px;
margin: 5px;
width: 400px;
display: flex;
border-radius: 50px;
align-items: center;
text-align: center;
justify-content: center;
flex-direction: column;
border: 2px solid royalblue;

}
</style>
</head>
<body>
	<center>
<form action="CreditAmount" method="post">
<input placeholder="Enter Your Amount" name = "amount">
<br>
<input type="submit">
</form>
</center>
</body>
</html>