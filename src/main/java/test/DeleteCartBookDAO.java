package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteCartBookDAO 
{
    public int deleteCartBook(HttpServletRequest req)
    {
    	int k=0;
    	   try 
    	   { 
			Connection con = DBConnection.getConnection();
			PreparedStatement delete =  con.prepareStatement("delete from cart56 where code=?");
			delete.setString(1,req.getParameter("code1"));
			k = delete.executeUpdate();
			
		   } catch (Exception e) {e.printStackTrace();}
    	   return k;
    }
}
