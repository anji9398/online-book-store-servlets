package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class CustomerLoginDAO 
{
   public CustomerBean login(HttpServletRequest req)
   {
	   CustomerBean cb =null;
	   try {
		      Connection con = DBConnection.getConnection();
		      PreparedStatement select = con.prepareStatement("select * from customer56 where uname=? and pass=?");
		      select.setString(1, req.getParameter("uname"));
		      select.setString(2, req.getParameter("pass"));
		      ResultSet rs =select.executeQuery();
		      if(rs.next())
		      {
		    	  cb = new CustomerBean();
		    	  cb.setuName(rs.getString(1));
		    	  cb.setPass(rs.getString(2));
		    	  cb.setfName(rs.getString(3));
		    	  cb.setlName(rs.getString(4));
		    	  cb.setAddress(rs.getString(4));
		    	  cb.setMailId(rs.getString(6));
		    	  cb.setPhno(rs.getLong(7));
		    	  
		      }
	       } catch (Exception e) {e.printStackTrace();	}
       return cb;
   }
}
