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
@WebServlet("/alogin")
public class AdminLoginServlet extends HttpServlet
{
	@Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   AdminBean ab = new AdminLoginDAO().login(req);
	   if(ab==null)
	   {
		   req.setAttribute("msg", "Invalid Login Process");
		   RequestDispatcher r = req.getRequestDispatcher("msg.jsp");
		   r.forward(req, res);
	   }else {
		   
		   HttpSession hs = req.getSession();
		   hs.setAttribute("abean", ab);
		   RequestDispatcher r = req.getRequestDispatcher("Login.jsp");
		   r.forward(req, res);
	   }
		  
   }
}
