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
@WebServlet("/viewCust")
public class DeleteCustomerServlet extends HttpServlet
{ 
	 @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
     {
		 HttpSession hs = req.getSession();
		String s = (String) req.getParameter("code3");
		ArrayList<CustomerBean>  cal = (ArrayList<CustomerBean>) hs.getAttribute("cal");
		if(cal == null)
		{
			   req.setAttribute("msg", "Customer is Not Not Available...");
			   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
			   r.forward(req, res);
		}else {
					for(CustomerBean cb : cal)
					 {
			    	    if(s.equals(cb.getuName()))
			    	    {
						    int k = new DeleteCustomerDAO().deleteCustomer(req);
						    if(k>0) {
								    req.setAttribute("msg", "Customer Deleted Successfully...");
									RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
									r.forward(req, res);
							   }else {
								   req.setAttribute("msg", "Customer is Not Not Available...");
								   RequestDispatcher r = req.getRequestDispatcher("msg3.jsp");
								   r.forward(req, res);
								   
								   
							   }
			    	    }
			    	
			           }
					}
	}
}
