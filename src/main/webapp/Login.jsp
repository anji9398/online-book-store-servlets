<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="test.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 </style>
 <link rel="stylesheet" href="button1.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body style="margin-top:20%; margin-left:15%; background:#9999ff;">

<%
   AdminBean ab = (AdminBean)session.getAttribute("abean");
   out.print("<h2>Welcome Admin : "+ab.getUname()+"</h2>");
   
%>
<br>

<button><span><a href="AddBook.html" >AddBook</a></span></button>
<button><span><a href="ViewAllBooks" >ViewAllBooks</a></span></button>
<button><span><a href="ViewAllCustomers" >ViewAllCustomers</a></span></button>
<button><span><a href="Logout" >Logout</a></span></button>

</body>
</html>