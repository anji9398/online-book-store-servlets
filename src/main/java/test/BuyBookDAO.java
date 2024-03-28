package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BuyBookDAO 
{
	int k;
  public int updateQty(BookBean bb)
  {
	  try 
	  {
		     Connection con = DBConnection.getConnection();
		     PreparedStatement update = con.prepareStatement("update BookDetails56 set qty=? where code=?");
		     update.setDouble(1, bb.getQty());
		     update.setString(2, bb.getCode());
		     k = update.executeUpdate();
	  } catch (Exception e) {e.printStackTrace();}
	  return k;
  }
}
