<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="test.BookBean,java.util.*,test.AdminBean"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="button1.css">
<link rel="stylesheet" href="table.css">

<head>
<meta charset="UTF-8">
<title>View All Books</title>


</head>
<body style="background-color: #d3bed6">
<%
   AdminBean b = (AdminBean)session.getAttribute("abean");
   ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("al");
%>
<header>
        <h1>Welcome Admin,<%out.print("  "+b.getUname());%> </h1>
         <h3 id="current" style="color:red"></h3>
         <script>
     let time = document.getElementById("current");
     setInterval(() =>{
	 let d = new Date();
	 time.innerHTML = d.toLocaleTimeString();
	 },1000)
  </script>
</header>
<table border="1">
    <tr>
        <th	>Code</th> 
        <th>Name</th>
        <th>Author</th>
        <th>Price</th>
        <th>Qty</th>
        <th>Update</th>
        <th>Delete Book</th>
    </tr>
<%  
   for(BookBean bb : al)
   {
	   out.print("<tr><td>"+bb.getCode()+"</td><td>"+bb.getName()+"</td><td>"+bb.getAuthor()+"</td><td> "+bb.getPrice()+" </td><td>"+bb.getQty()+"</td><td><button><span><a href='edit?code="+bb.getCode()+"'>EditBook</a></span></button></td><td><button><span><a href='delete?code1="+bb.getCode()+"'>Delete Book</a></span></button></td></tr>");
   }  
%>
<tr style="background-color:#a278af;">
    <td colspan="3"><button><span><a href="AddBook.html">AddBook</a></span></button></td>
    <td colspan="3"><button><span><a href="Logout"> Logout</a></span></button></td>
    <td><button><span><a href="DeleteAll"> DeleteAllBooks</a></span></button></td>
</tr>
</table>
<button><span><a href="Login.jsp" >Back</a></span></button>
</div>
</body>
</html>