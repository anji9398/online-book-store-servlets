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
@WebServlet("/update")
public class UpdateBookDetailsServlet extends HttpServlet
{
   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   HttpSession hs = req.getSession(false);
	   if(hs==null)
	   {
		   req.setAttribute("msg", "Invalid session...");
		   RequestDispatcher r = req.getRequestDispatcher("msg.jsp"); 
		   r.forward(req, res);
		   
	   }else {
		   
	   ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("al");
	   String code = req.getParameter("code");
	   int k=0;
	   
	   for(BookBean bb : al)
	   {
		   if(code.equals(bb.getCode()))
		   {
			   bb.setPrice(Double.parseDouble(req.getParameter("price")));
			   bb.setQty(Integer.parseInt(req.getParameter("qty")));
			    k = new UpdateBookDetailsDAO().update(bb);
			   break;
		   }
	   }
	  
	   if(k>0)
	   { 
		   req.setAttribute("msg", "Updated Successfully...");
		   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp"); 
		   r.forward(req, res);
 	   }
	   
	   }
   }
}
/* HttpSession hs = req.getSession(false);
	       //Accessing existing session
	 if(hs==null) {
		 req.setAttribute("msg","Session Expired...<br>");
		 RequestDispatcher rd=
				 req.getRequestDispatcher("Msg.jsp");
		 rd.forward(req, res);
	 }else {
		 ArrayList<BookBean> al = 
				 (ArrayList<BookBean>)hs.getAttribute("al");
		 String bCode = req.getParameter("bcode");
		 float price = Float.parseFloat(req.getParameter("price"));
		 int qty = Integer.parseInt(req.getParameter("qty"));
		 Iterator<BookBean> it = al.iterator();
		 BookBean bb=null;
		 while(it.hasNext()) {
			 bb = (BookBean)it.next();
			 if(bCode.equals(bb.getCode())) {
				bb.setPrice(price); 
				bb.setQty(qty);
				break;
			 }
		 }//end of loop
		 int k = new UpdateBookDetailsDAO().update(bb);
		 if(k>0) {
			 RequestDispatcher rd = 
					 req.getRequestDispatcher("UpdateBook.jsp");
			 rd.forward(req, res);
		 }
	 }//end of else
*/
