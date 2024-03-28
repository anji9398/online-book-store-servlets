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
@WebServlet("/DeleteAll")
public class DeleteAllBooks extends HttpServlet
{
   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   {
	   HttpSession hs = req.getSession(false);
	   if(hs == null)
	   {
		   
		   req.setAttribute("msg", "Books Are Not Available...");
		   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
		   r.forward(req, res);
		   
	   }else {
		   
		  int k= new DeleteBookDAO().deleteAllBooks();
		   if(k>0)
		   {
			   req.setAttribute("msg", "All Books Deleted...");
			   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
			   r.forward(req, res);
		   }
	   }
   }
}
