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
@WebServlet("/buy3")
public class AddCartServlet extends HttpServlet
{
	ArrayList<BookBean>  bb = new ArrayList<BookBean>();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		HttpSession hs = req.getSession(false);
		String s = req.getParameter("code");
		CustomerBean cb = (CustomerBean)hs.getAttribute("cbean");
		   String name = cb.getuName();
		ArrayList<BookBean> cal = (ArrayList<BookBean>)hs.getAttribute("al");
	   
	    for(BookBean b : cal)
	    {
	    	if(s.equals(b.getCode()))
	    	{
	    		BookBean bb1 = new BookBean();
	    		bb1.setCode(b.getCode());
	    		bb1.setName(b.getName());
	    		bb1.setAuthor(b.getAuthor());
	    		bb1.setPrice(b.getPrice());
	    		bb1.setQty(b.getQty());
	    		bb.add(bb1);
	    		int k = new AddCartDAO().addCart(bb1, name);
	    		if(k>0) {
	    		   RequestDispatcher r = req.getRequestDispatcher("ViewCartList.jsp");
	    		   r.forward(req, res);
	    		}
	    		break;
	    	}
	    	
	    }
	    
	   
	}
}
