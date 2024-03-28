package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ViewBooksCartDAO 
{
	
	ArrayList<BookBean>  cartal = new ArrayList<BookBean>();
   public ArrayList<BookBean>	 viewBooks(HttpServletRequest req)
   {
		   try 
		   {
		      Connection con = DBConnection.getConnection();
		      PreparedStatement select = con.prepareStatement("select * from cart56 where uname=?");
		      select.setString(1, (String)req.getAttribute("name") );
		      ResultSet rs =   select.executeQuery();
		      while(rs.next())
		      {
		    	  BookBean bb =new BookBean();
		    	  bb.setCode(rs.getString(2));
		    	  bb.setName(rs.getString(3));
		    	  bb.setAuthor(rs.getString(4));
		    	  bb.setPrice(rs.getDouble(5));
		    	  bb.setQty(rs.getInt(6));
		    	  cartal.add(bb);
		    	  
		    	  
		      }
		      
	   		} catch (Exception e) {e.printStackTrace();	}
		   
		   return cartal;
   }
}
