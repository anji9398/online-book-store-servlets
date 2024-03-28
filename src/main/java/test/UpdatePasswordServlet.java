package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/updatepass")
public class UpdatePasswordServlet extends HttpServlet
{
   protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
   {
	   int k = new UpdatePasswordDAO().updatePass(req);
	   if(k>0)
	   {
		   req.setAttribute("msg","Updated Successfully....");
		   req.getRequestDispatcher("msg2.jsp").forward(req, res);;
	   }else {
		   req.setAttribute("msg","Invalid User Name....");
		   req.getRequestDispatcher("msg2.jsp").forward(req, res);;
	   }
	   
   }
}
