<%@page import="test.CustomerBean"%>
<%@page import="test.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="table.css">
<style>
  header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        
 button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 0 5%;
  border: none;
  cursor: pointer;

}

button:hover {
  opacity: 0.8;
}
</style>
<title>Book Bill</title>
</head>
<body>
<% 
  CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
%>
<header>
<h1>Welcome Customer,<%out.print("  "+cb.getuName());%> </h1>
</header>
    <h1>Your Book Bill </h1>
    <table border="1" style="text-align: center;">
       <tr>
          <th>Book Name</th>
          <th>Book Price</th>
          <th>Total Books</th>
          <th>Total Bill</th>
       </tr>
    
    <%
       
      int books = (int)request.getAttribute("books");
      BookBean b = (BookBean) request.getAttribute("Buy");
      double price = b.getPrice()*books;
    %>
    <tr>
       <td><%out.print(b.getName());%></td>
       <td><%out.print(b.getPrice());%></td>
       <td><%out.print(books);%></td>
       <td><%out.print(price);%></td>
    </tr>
    </table>
    <div style="margin-left: 30%">
    <button><span><a href="ViewBookDetailsToBuy">Back</a></span></button>
    <button><span><a href="ViewBookDetailsToBuy">ViewAllBooks</a></span></button>
    <button><span><a href="CLogout">Logout</a></span></button>
   </div>
</body>
</html>