package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AddCartDAO 
{

		public int addCart(BookBean bb1,  String name) 
		{
			int k=0;
			try 
		    {
			   Connection con = DBConnection.getConnection();
			   PreparedStatement insert = con.prepareStatement("insert into cart56 values(?,?,?,?,?,?)");
			   insert.setString(1, name);
			   insert.setString(2, bb1.getCode());
			   insert.setString(3, bb1.getName());
			   insert.setString(4, bb1.getAuthor());
			   insert.setDouble(5, bb1.getPrice());
			   insert.setInt(6, bb1.getQty());
			   k = insert.executeUpdate();
			   
		    } catch (Exception e) {e.printStackTrace();}
	       return k;
         }
}
