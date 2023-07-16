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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action"); 
		Carrello cart=(Carrello)request.getSession().getAttribute("cart");
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
			cart.GetCart().get(Integer.parseInt(request.getParameter("index"))).IncrQuantita();
		}else if(action.equals("Decrement")){
			
			if(cart.GetCart().get(Integer.parseInt(request.getParameter("index"))).GetQuantita()==1) {
				request.getSession().setAttribute("cart", cart);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/Carrello.jsp");
				disp.forward(request, response);
				
			}else {
				cart.GetCart().get(Integer.parseInt(request.getParameter("index"))).DecrQuantita();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}