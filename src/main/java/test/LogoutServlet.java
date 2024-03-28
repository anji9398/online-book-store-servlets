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
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	 HttpSession hs = req.getSession();
    	 if(hs==null)
    	 {
    		 req.setAttribute("msg", "Session Expired...<br>");
    	 }else {
    	      hs.removeAttribute("abean");
    	      hs.invalidate();
    	      req.setAttribute("msg", "User Logged out Successfully..<br>");
    	      RequestDispatcher r = req.getRequestDispatcher("msg.jsp");
    		   r.forward(req, res);
    	 }  
    }
}
