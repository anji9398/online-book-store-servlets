package test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteBookDAO 
{
	public int delete(HttpServletRequest req)
   {
		int k=0;
	   try 
	   {
		   Connection con = DBConnection.getConnection();
		  PreparedStatement delete = con.prepareStatement("delete from BookDetails56 where code=?");
	      delete.setString(1, req.getParameter("code1"));
	      k = delete.executeUpdate();
	      
	    } catch (Exception e) {e.printStackTrace();}
	   return k;
	   
   }
     
	
	public int deleteAllBooks()
	   {
		int k=0;
		   try 
		   {
			   Connection con = DBConnection.getConnection();
			  PreparedStatement delete = con.prepareStatement("delete from BookDetails56");
		      k = delete.executeUpdate();  
		    } catch (Exception e) {e.printStackTrace();}
		   return k;
		   
	   }

}
