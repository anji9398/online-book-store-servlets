package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllCustomersDAO 
{
    public ArrayList<CustomerBean> retrieve() 
    {
        ArrayList<CustomerBean> cal = new ArrayList<CustomerBean>();
    	try 
    	{
			Connection con = DBConnection.getConnection();
			PreparedStatement select = con.prepareStatement("select * from customer56");
			ResultSet rs =  select.executeQuery();
			while(rs.next())
			{
			CustomerBean cb = new CustomerBean();
			cb.setuName(rs.getString(1));
			cb.setPass(rs.getString(2));
			cb.setfName(rs.getString(3));
			cb.setlName(rs.getString(4));
			cb.setAddress(rs.getString(5));
			cb.setMailId(rs.getString(6));
			cb.setPhno(rs.getLong(7));
			cal.add(cb);
			}
			
			
		} catch (Exception e) {e.printStackTrace();}
    	
    	return cal;
    }
}
