package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewBookDetailsToBuyDAO 
{
	ArrayList<BookBean> al = new ArrayList<BookBean>();
   public ArrayList<BookBean> retrieve()
   {
	   try 
	   {
		   Connection con = DBConnection.getConnection();
		   PreparedStatement select = con.prepareStatement("select * from BookDetails56");
	       ResultSet rs = select.executeQuery();
	       while(rs.next())
	       {  
	    	  BookBean bb = new BookBean();
	    	  bb.setCode(rs.getString(1));
	    	  bb.setName(rs.getString(2));
	    	  bb.setAuthor(rs.getString(3));
	    	  bb.setPrice(rs.getDouble(4));
	    	  bb.setQty(rs.getInt(5));
	    	  al.add(bb);
	       }
	   } catch (Exception e) {e.printStackTrace();	}
	   return al;
   }
}
