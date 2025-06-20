<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
*
{
padding: 0px;
margin:  0px;
overflow: hidden;
}
body{
height:100vh;
width : 100vw;
background-color: pink;
}
#container{
height : 80vh;
width : 100vw;
display: flex;
align-items: center;
justify-content: center;
flex-direction: column;
}
#account{
display: none;
}
#name:hover+#account{
display: block;
}
#c{
height: 15vh;
width: 90vw;
display: flex;
align-items: flex-end;
justify-content: center;
flex-direction: column;
}
div{
margin: 3px;
}
button{
height : 60px;
width : 250px;
background-color: white;
font-style : italic;
font-size : 1.3rem;
text-align: center;
border-radius: 10px;

}

</style>
</head>
<body>

<div id = "c">
<% String username = (String) session.getAttribute("name");
   String userAccNo = (String) session.getAttribute("AccNo");
   
   if(username!=null)
   {
	   String account ="";
	   for(int i=0;i<userAccNo.length();i++)
	   {
		   if(i<2 || i>userAccNo.length()-4)
		   {
			   account+=userAccNo.charAt(i);
		   }
		   else{
			   account += '*';
		   }
		   
	   }
	   
	   %>
 <p id="name"> <span>Welcome :-</span><%= username  %> </p>
 <p id ="account"> AccountNo :-<%= account  %> </p>

 <%
   }
%>
</div>
<div id = "container">
<div>
<a href = "Debit.jsp"><button>WithDraw Amount</button></a>
<a href = "Credit.jsp"><button>Credit Amount</button></a>
</div>
<div>
<a href = "Statement.jsp"><button>Check Statement</button></a>
<a href = "ChangePassword.jsp"><button>Change Password</button></a>
</div>
</div>
</body>
</html>