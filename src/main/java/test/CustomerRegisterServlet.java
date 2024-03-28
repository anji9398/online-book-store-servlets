package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cReg")
public class CustomerRegisterServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
    	int k = new CustomerRegDAO().insert(req);
    	if(k>0)
    	{
    		req.setAttribute("msg", "Registered Successfully...");
    		RequestDispatcher r = req.getRequestDispatcher("msg2.jsp");
    		r.forward(req, res);
    	}
    }
}
