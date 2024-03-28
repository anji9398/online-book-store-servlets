<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.*,test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer come to buy</title>

<link rel="stylesheet" href="button1.css">
<link rel="stylesheet" href="table.css">
<link rel="stylesheet" href="Abutton.css">

<style type="text/css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
           
            
        } 
 
        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<%
   CustomerBean cb = (CustomerBean)session.getAttribute("cbean");
   
   ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("al");
%>
<header>
        <h3 id="current"></h3>
         <script>
     let time = document.getElementById("current");
     setInterval(() =>{
	 let d = new Date();
	 time.innerHTML = d.toLocaleTimeString();
	 },1000)
  </script>
  <h1>Welcome Customer,<%out.print("  "+cb.getuName());%> </h1>

</header>
<table border="1">
  <tr>
      <th>Book Code</th>
      <th>Book Name</th>
      <th>Book Author</th>
      <th>Book Price</th>
      <th>Book Qty</th>
      <th>Add To Your Store </th>
      <th>You want Buy </th>
  </tr>
<% 
   for(BookBean bb : al)
   {
	   out.print("<tr><td>"+bb.getCode()+"</td><td>"+bb.getName()+"</td><td>"+bb.getAuthor()+"</td><td>"+bb.getPrice()+"</td><td>"+bb.getQty()+"</td><td><div class='button-container'><a href='buy3?code="+bb.getCode()+"'>Add Cart</a></div></td><td><button><span><a href='buy?code="+bb.getCode()+"'>Buy</a></span></button></td></tr>");
   }
%>

</table>
<div style="margin-left: 22%; margin-right: 22%; background-color: #b7bdac;">

<button><span><a href="ViewBookDetailsToCustomer.jsp" >Back</a></span></button>
<button><span><a href="CartBooks" >See Cart Books</a></span></button>
<button ><span><a href="CLogout" style="color: white;">Logout</a></span></button>
</div>
</body>
</html>