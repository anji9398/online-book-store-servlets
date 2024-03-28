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
@WebServlet("/ViewAllCustomers")
public class ViewAllCustomersServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
    {
    	ArrayList<CustomerBean> cal = new ViewAllCustomersDAO().retrieve();
    	if( cal == null)
    	{
    		req.setAttribute("msg", "Customers are Not Available....");
    		req.getRequestDispatcher("msg3.jsp").forward(req, res);
    	}else {
    		HttpSession hs = req.getSession(false);
    		hs.setAttribute("cal", cal);
    		req.getRequestDispatcher("ViewAllCustomers.jsp").forward(req, res);;
    	}
    }
}
