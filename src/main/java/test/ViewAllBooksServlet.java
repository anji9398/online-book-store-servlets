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
@WebServlet("/ViewAllBooks")
public class ViewAllBooksServlet extends HttpServlet
{
	@Override
   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   ArrayList<BookBean> al = new ViewBooksDAO().retrieve();
	   HttpSession hs = req.getSession();
	   hs.setAttribute("al", al);
	   
	    
	   RequestDispatcher r = req.getRequestDispatcher("viewBookDetails.jsp");
	   r.forward(req, res);
   }
}
