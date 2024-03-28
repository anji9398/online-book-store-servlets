package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookDetailsServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    
    	HttpSession hs = req.getSession(false);
    	if(hs==null)
    	{
    		req.setAttribute("msg", "Session Expired...<br>");
    		RequestDispatcher r = req.getRequestDispatcher("msg.jsp");
    		r.forward(req, res);
    	}else {
    		RequestDispatcher rd = req.getRequestDispatcher("EditBook.jsp");
  		    rd.forward(req, res);

    	}
    	
    }
}
