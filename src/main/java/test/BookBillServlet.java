package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy1")
public class BookBillServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		HttpSession hs = req.getSession(false);
		if (hs == null) 
		{
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher r = req.getRequestDispatcher("msg.jsp");
			r.forward(req, res);

		} else {

			ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("al");
			
			String code = req.getParameter("code");
			int books = Integer.parseInt(req.getParameter("qty"));
		 
			  
			  for(BookBean bb : al)
			  {
				  if(code.equals(bb.getCode()))
				  {
				      bb.setQty(bb.getQty()-books);
					  int k = new BuyBookDAO().updateQty(bb);  
					  if(k>0) 
					  {
						  req.setAttribute("books", books);
						  req.setAttribute("Buy", bb);
					     RequestDispatcher r = req.getRequestDispatcher("BookBill.jsp");
					     r.forward(req, res);
					  }
				      break;
				  }
			  }
		}
	}
}