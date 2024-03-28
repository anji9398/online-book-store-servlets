package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateBookDetailsDAO 
{
   int k=0;
   public int update(BookBean bb)
   {
	    try 
	    {
	    	  Class.forName(DBInfo.DRIVER);
		      Connection con = DriverManager.getConnection(DBInfo.URL,DBInfo.USERNAME,DBInfo.PASSWORD);
		      PreparedStatement update = con.prepareStatement("update BookDetails56 set price=?,qty=? where code=?");
		      update.setDouble(1, bb.getPrice());     
		      update.setInt(2, bb.getQty());
		      update.setString(3, bb.getCode());
		      k = update.executeUpdate();
		      
	    } catch (Exception e) {e.printStackTrace();}
	   return k;
   }
}
