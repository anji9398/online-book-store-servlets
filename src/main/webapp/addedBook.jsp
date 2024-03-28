<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String  msg = (String)application.getAttribute("msg");
 out.print(msg);
%>
<jsp:include page="AddBook.html"/>

</body>
</html>