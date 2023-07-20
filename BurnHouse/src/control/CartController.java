package control;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrello;
import model.ProductModelDS;
/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action"); 
		Carrello cart=(Carrello)request.getSession().getAttribute("cart");
		String ind=request.getParameter("index");
		int index=0;
		if(ind!=null && !ind.equals("")) {
			index=Integer.parseInt(ind);
		}
		if(cart==null)
		{
			 cart = new Carrello();
		}
		try {
		if(action.equals("addCart")) {
			ProductModelDS prod=new ProductModelDS();
		cart.AddtoCart(prod.doRetrieveByKey(Integer.parseInt(request.getParameter("id"))));
		}else if(action.equals("removeCart"))
		{
		cart.RemovetoCart(Integer.parseInt(request.getParameter("id")));	
		}
		else if(action.equals("Increment")){
			cart.GetCart().get(index).IncrQuantita();
		}else if(action.equals("Decrement")){
			
			if(cart.GetCart().get(index).GetQuantita()==1) {
				request.getSession().setAttribute("cart", cart);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/Carrello.jsp");
				disp.forward(request, response);
				
			}else {
				cart.GetCart().get(index).DecrQuantita();
			}
			
		}else if(action.equals("resetCart")) {
			cart.GetCart().clear();
		}
		request.getSession().setAttribute("cart", cart);
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/Carrello.jsp");
		disp.forward(request, response);
		}catch(SQLException e) {
			System.exit(-1);
			
		}
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}