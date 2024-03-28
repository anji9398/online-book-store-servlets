<%@page import="test.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="test.AdminBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
<link rel="stylesheet" href="button1.css">
<style type="text/css">
 

        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin: 0;
        }

        p {
            margin: 5px 0 0;
            font-style: italic;
        }
        
        .container {
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 8px;
            text-align: center;
        }
        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        
        
        body{
        background-image: url('books.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;  
        background-size: cover;
        }
</style>
</head>
<body style="">
<header>
<%AdminBean ab = (AdminBean) session.getAttribute("abean"); %>
        <h1>Welcome Admin,<%out.print("  "+ab.getUname());%> </h1>
         <h3 id="current" style="color:red"></h3>
         <script>
     let time = document.getElementById("current");
     setInterval(() =>{
	 let d = new Date();
	 time.innerHTML = d.toLocaleTimeString();
	 },1000)
  </script>
</header>
<%
    
    ArrayList<BookBean> bb = (ArrayList<BookBean>)session.getAttribute("al");
     Iterator<BookBean> i = bb.iterator();
     while(i.hasNext())
     {
    	 
    	String s = request.getParameter("code");
    	
    	BookBean b = i.next(); 
    	if(s.equals(b.getCode()))
    	{
    		
	     
	        
	        %>
	        <div class="container" style="background-color:#0099ff; color:white;">
		        <form action = "update" action="post">
		          <input type="hidden" name="code" value=<%=b.getCode() %>>
		          BookPrice:<input type="text" name="price" value=<%=b.getPrice()%> required="required"><br>
		          BookQty : <input type="text" name="qty" value=<%=b.getQty() %> required="required"><br><br>
		         <button type="submit" >UpdateBookDetails</button>
		        </form>
                <button><a href=ViewAllBooks>viewAllBook</a></button>
		        <button><a href="Logout">Logout</a></button>
		        </div>
           <%      
    	}
     } 
 %>

</body>
</html>