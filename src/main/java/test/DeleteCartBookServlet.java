package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete4")
public class DeleteCartBookServlet extends HttpServlet
{
   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
   {
	   HttpSession hs = req.getSession(false);
	   
	  ArrayList<BookBean> cartal = (ArrayList<BookBean>) hs.getAttribute("cartal");
	  if(cartal == null) {
		   req.setAttribute("msg", " not Books are Available deleted....");
		   req.getRequestDispatcher("msg3.jsp").forward(req, res);
	  } else {
		  int i=0;
		  for(BookBean bb : cartal)
		  {
			  
			  if(bb.getCode().equals(req.getParameter("code1")))
			  {
				  cartal.remove(i);
				  break;
			  }
			  i++;
		  }
	  
			   int k = new DeleteCartBookDAO().deleteCartBook(req);
			   if(k>0)
			   {
				   req.setAttribute("msg", "deleted....");
				   req.getRequestDispatcher("msg4.jsp").forward(req, res);
			   }
			   
			   req.setAttribute("msg", "Not deleted....");
			   req.getRequestDispatcher("msg4.jsp").forward(req, res);
	  } 
   }
}
