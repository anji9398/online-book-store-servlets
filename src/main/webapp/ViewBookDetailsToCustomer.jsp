<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="test.CustomerBean"%>
         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewBookDetailsToCustomer</title>
<style>
    button {
  display: inline-block;
  border-radius: 4px;
  background-color: rgb(0, 128, 0);
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 15px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
 
  
}

button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: 10px;
  transition: 0.5s;
}

button:hover span {
  padding-right: 25px;
}

button:hover span:after {
  opacity: 1;
  right: 0;
}
a{
	color: white;
}

button:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
button:hover {
  background-color: #3e8e41;
}
div{
 background-color: #3366ff;
 margin: 10%;
 text-align: center;
}
</style>
</head>
<body style="padding: 2%; background:##00cc00;">
<%CustomerBean cb = (CustomerBean) session.getAttribute("cbean");%>
     <h3 id="current" style="color:red"></h3>
<div>
<header>
        
         <script>
     let time = document.getElementById("current");
     setInterval(() =>{
	 let d = new Date();
	 time.innerHTML = d.toLocaleTimeString();
	 },1000)
  </script>
  <h1>Welcome Customer,<%out.print("  "+cb.getuName());%> </h1>
</header>

<button><span><a href="ViewBookDetailsToBuy">ViewAllBooks</a></span></button>
<button><span><a href="CartBooks">Cart Books</a></span></button>
<button><span><a href="CLogout">Logout</a></span></button>
</div>
</body>
</html>