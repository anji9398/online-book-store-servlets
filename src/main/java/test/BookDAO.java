package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class BookDAO 
{
    int k=0;
    
    public int inserBook(HttpServletRequest req)
    {
    	try 
    	{
			Connection con = DBConnection.getConnection();
			PreparedStatement select = con.prepareStatement("select * from bookDetails56 where code=?");
			PreparedStatement insert = con.prepareStatement("insert into bookDetails56 values(?,?,?,?,?)");
			select.setString(1, req.getParameter("code"));
    		ResultSet s = select.executeQuery();
    	    if(s.next())
    	    	return 0; 
			insert.setString(1, req.getParameter("code"));
			insert.setString(2, req.getParameter("name"));
			insert.setString(3, req.getParameter("author"));
			insert.setDouble(4, Double.parseDouble(req.getParameter("price")));
			insert.setInt(5, Integer.parseInt(req.getParameter("qty")));
    	    k = insert.executeUpdate();
    	    
		} catch (Exception e) {e.printStackTrace();}
    	return k;
    }
}
