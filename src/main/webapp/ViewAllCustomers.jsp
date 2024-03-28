<%@ page language="java" 
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="test.CustomerBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewAllCustomers</title>
<link rel="stylesheet" href="table.css">
<link rel="stylesheet" href="Abutton.css">
</head>
<body>
<table border="1">
   <tr>
      <th>User Name </th>
      <th> First Name </th>
      <th> Last Name </th>
      <th> Address </th>
      <th> Mail Id </th>
      <th> Phone Number </th>
      <th> Delete</th>
      
   </tr>
<%
 ArrayList<CustomerBean> cal = (ArrayList<CustomerBean>)session.getAttribute("cal"); 
 for(CustomerBean cb : cal)
 {
	 out.print("<tr><td>"+cb.getuName()+"</td><td>"+cb.getfName()+"</td><td>"+cb.getlName()+"</td><td>"+cb.getAddress()+"</td><td>"+cb.getMailId()+"</td><td>"+cb.getPhno()+"<td><div class='button-container'><a href='viewCust?code3="+cb.getuName()+"'>Delete</a></div></td></tr>");
 }
 
%>
 </table>
</body>
</html>