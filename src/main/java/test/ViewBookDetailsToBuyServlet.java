package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ViewBookDetailsToBuy")
public class ViewBookDetailsToBuyServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	  ArrayList<BookBean> al = new ViewBookDetailsToBuyDAO().retrieve();
	  if(al==null)
	  {
		  req.setAttribute("msg", "Books Are Not Available....");
	  }else {
		  HttpSession hs = req.getSession(false);
		  hs.setAttribute("al", al);
		  RequestDispatcher r = req.getRequestDispatcher("CustomerComeToBuy.jsp");
		  r.forward(req, res);
	  }
  }
}
