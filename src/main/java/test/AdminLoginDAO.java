package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginDAO 
{
    public AdminBean ab = null;
    
    public AdminBean login(HttpServletRequest req)
    {
    	try 
    	{
			Connection con =  DBConnection.getConnection();
			PreparedStatement select = con.prepareStatement("select * from admin56 where uname=? and pass=?");
			select.setString(1, req.getParameter("uname"));
			select.setString(2, req.getParameter("pass"));
			ResultSet rs = select.executeQuery();
			if(rs.next())
			{
				ab= new AdminBean();
				ab.setUname(rs.getString(1));
				ab.setPassword(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddress(rs.getString(5));
				ab.setMailid(rs.getString(6));
				ab.setPhno(rs.getLong(7));
			}
			
		} catch (Exception e) {e.printStackTrace();	}
    	
    	
    	return ab;
    }
}
