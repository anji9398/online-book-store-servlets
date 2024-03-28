package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteCustomerDAO 
{
	public int deleteCustomer(HttpServletRequest req)
	   {
			int k=0;
		   try 
		   {
			   Connection con = DBConnection.getConnection();
			  PreparedStatement delete = con.prepareStatement("delete from  customer56 where uname=?");
		      delete.setString(1, req.getParameter("code3"));
		      k = delete.executeUpdate();
		      
		    } catch (Exception e) {e.printStackTrace();}
		   return k;
		   
	   }
	    
}
