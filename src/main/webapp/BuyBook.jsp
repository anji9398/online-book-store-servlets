<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Book</title>
<link rel="stylesheet" href="BookManagemanet.css">
<link rel="stylesheet" href="Abutton.css">
<style>
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
ArrayList<BookBean> bb = (ArrayList<BookBean>)session.getAttribute("al");
Iterator<BookBean> i = bb.iterator();
while(i.hasNext())
{ 
	String s = request.getParameter("code");
	
	BookBean b = i.next(); 
	if(s.equals(b.getCode()))
	{
%>
<header>
  <h1>Welcome Customer,<%out.print("  "+cb.getuName());%> </h1>
  <h4 id="current" style="color:red"></h4>
  <script>
     let time = document.getElementById("current");
     setInterval(() =>{
	 let d = new Date();
	 time.innerHTML = d.toLocaleTimeString();
	 },1000)
  </script>
</header>

 <form action="buy1" method="post">
 
<div>
 
   <input type="hidden" name="code" value=<%=b.getCode() %>>
   <h3>Book Name is,<%out.print("  "+b.getName());%> </h3>
   <b> Enter how many Books do you want</b> 
   <input type="text" name="qty" placeholder="Enter Buy Books" required="required"><br>
   <button type="submit" >Bill</button>
   <div class="button-container" style="margin-left: 35%;">
    <a href="CustomerComeToBuy.jsp" >Back</a>
    <a href="ViewBookDetailsToBuy">ViewAllBooks</a>
   </div>
<%}}%>

</div>
</form>
</body>
</html>