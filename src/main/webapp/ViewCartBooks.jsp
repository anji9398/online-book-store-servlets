<%@page import="test.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Books</title>
<link rel="stylesheet" href="table.css">
<link rel="stylesheet" href="Abutton.css">
<style>
    input{
    width : 20%;
}
</style>
</head>
<body>
<table>
  <tr>
        <th	>Code</th> 
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Delete Book</th>
    </tr>
    
<%
    ArrayList<BookBean> cartal = (ArrayList<BookBean>)session.getAttribute("cartal");
   
   int price=0;
   for(BookBean bb : cartal)
   {
	   out.print("<tr><td>"+bb.getCode()+"</td><td>"+bb.getName()+"</td><td>"+bb.getAuthor()+"</td><td> "+bb.getPrice()+"</td><td><div class='button-container'><a href='delete4?code1="+bb.getCode()+"' >Delete Book</a><div></td></tr>");
      price+=bb.getPrice();
   }
   
%>
  <tr><td colspan="6"><h4>Bill is : <%out.print(price); %></h4></td>	</tr>


<tr class="button-container">
    <td colspan="2"><a href="ViewBookDetailsToBuy">AddBook</a></td>
    <td colspan="2"><a href="">Buy Books</a></td>
    <td colspan="3"><a href="Logout"> Logout</a></td>
    
</tr>
</table>
</body>
</html>