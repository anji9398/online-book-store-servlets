package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet
{
	@Override
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     {
		ServletContext sct = req.getServletContext();
		 int k =  new BookDAO().inserBook(req) ;
		 if(k>0)
		 {
			 sct.setAttribute("msg", " Book is added...");
			 RequestDispatcher r =  req.getRequestDispatcher("addedBook.jsp");
			 r.forward(req, res);
		 }else {
			 sct.setAttribute("msg", "Not added book... ");
			 RequestDispatcher r =  req.getRequestDispatcher("addedBook.jsp");
			 r.forward(req, res);
		 }
     }
}
