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
@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet
{
   protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   CustomerBean cb = new CustomerLoginDAO().login(req);
	   if(cb==null)
	   {
		   req.setAttribute("msg", "Invalid Customer Login Details...");
		   RequestDispatcher r = req.getRequestDispatcher("msg2.jsp");
		   r.forward(req, res);
	   }else {
		   HttpSession hs = req.getSession();
		   hs.setAttribute("cbean", cb);
		   RequestDispatcher r = req.getRequestDispatcher("ViewBookDetailsToCustomer.jsp");
		   r.forward(req, res);
		   
	   }
   }
}
