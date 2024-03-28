package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteBook extends HttpServlet
{
  protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
  {
	   
	  HttpSession hs = req.getSession(false);
	   ArrayList<BookBean>  al = (ArrayList<BookBean>) hs.getAttribute("al");
	   
	   if(al== null)
	   {
		   req.setAttribute("msg", "Books Are Not Available...");
		   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
		   r.forward(req, res);
	   }else {
		   
		 int k = new DeleteBookDAO().delete(req);
		 if(k>0)
		 {
			req.setAttribute("msg", "Book Deleted...");
			RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
			 r.forward(req, res);
		 }
		   
		   
	   }	   
	  
  }
}
/*
int i=0;
for(Book b : ar1)
{
	

	if(b.code != String.valueOf("A"))
	{
		ar1.set(i++, b);
	}
}
ar1.remove(ar1.size()-1);
System.out.println(ar1);
*/