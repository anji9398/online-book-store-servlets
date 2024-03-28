package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class UpdatePasswordDAO 
{
   public int updatePass(HttpServletRequest req)
   {
	   int k=0;
	   try 
	   {
		Connection con = DBConnection.getConnection();
		PreparedStatement select = con.prepareStatement("select * from customer56 where uname=?");
		PreparedStatement update = con.prepareStatement("update customer56 set pass=? where uname=?" );
		
		select.setString(1, req.getParameter("name"));
		ResultSet rs =   select.executeQuery();
		if(rs.next())
		{
		   update.setString(1, req.getParameter("pass"));
		   update.setString(2, req.getParameter("name"));
		   k = update.executeUpdate();
		}
		   
		   
	   } catch (Exception e) {e.printStackTrace();	}
	   
	   return k;
   }
}
