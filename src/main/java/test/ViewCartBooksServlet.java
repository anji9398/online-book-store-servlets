package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CartBooks")
public class ViewCartBooksServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
    	HttpSession hs = req.getSession(false);
    	CustomerBean cb =(CustomerBean)  hs.getAttribute("cbean");
    	req.setAttribute("name", cb.getuName());
    	
    	ArrayList<BookBean> cartal = (ArrayList<BookBean>)new ViewBooksCartDAO().viewBooks(req);
    	
    	if(cartal == null)
    	{
    		req.setAttribute("msg", "Books Are Empty...");
    	   req.getRequestDispatcher("msg3.jsp").forward(req, res);
    	}else {
    		hs.setAttribute("cartal", cartal);
    		req.getRequestDispatcher("ViewCartBooks.jsp").forward(req, res);
    	}
    	
    	
    }
}
