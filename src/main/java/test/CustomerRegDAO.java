package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class CustomerRegDAO 
{
   int k;
   public int insert(HttpServletRequest req)
   {
	   
	   try 
	   {
		   Connection con = DBConnection.getConnection();
	       PreparedStatement insert = con.prepareStatement("insert into customer56 values(?,?,?,?,?,?,?)");
	       insert.setString(1, req.getParameter("name"));
	       insert.setString(2, req.getParameter("pass"));
	       insert.setString(3, req.getParameter("fname"));
	       insert.setString(4, req.getParameter("lname"));
	       insert.setString(5, req.getParameter("adds"));
	       insert.setString(6, req.getParameter("mail"));
	       insert.setLong(7, Long.parseLong(req.getParameter("phno")));
	       k = insert.executeUpdate();
	      
	   } catch (Exception e) {e.printStackTrace();	}
	   return k; 
    }
}
