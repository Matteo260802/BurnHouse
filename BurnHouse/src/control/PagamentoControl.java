package control;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagamento;
import model.PagamentoDAO;

/**
 * Servlet implementation class PagamentoControl
 */
@WebServlet("/PagamentoControl")
public class PagamentoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagamentoControl() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String user=(String)request.getSession().getAttribute("email");
		String num=request.getParameter("num_carta");
		
		PagamentoDAO pago=new PagamentoDAO();
		if(action.equals("insert")) {
			
			try {
			
			if(!pago.DoSave(num, user, request.getParameter("titolare"), request.getParameter("scadenza"))) {
				RequestDispatcher disp =getServletContext().getRequestDispatcher("/MetodoPresent.jsp");
				disp.forward(request, response);
			}
	
			}catch(Exception e) {
				RequestDispatcher disp =getServletContext().getRequestDispatcher("/GeneralError.jsp");
				disp.forward(request, response);
			
			}
			}else if(action.equals("delete")) {
				try{
					pago.DoDelete(num, user);
					}catch(Exception e) {
						response.sendRedirect("GeneralError.jsp");
					}
			}else if(action.equals("show")) {
				try{
					Collection<Pagamento> metodi=pago.DoRetrieveByUser(user);
					request.getSession().setAttribute("metodi", metodi);
					RequestDispatcher disp =getServletContext().getRequestDispatcher("/ShowMetodo.jsp");
					disp.forward(request, response);
					return;
				}catch(Exception e) {
					response.sendRedirect("GeneralError.jsp");
				}
			}
		RequestDispatcher disp =getServletContext().getRequestDispatcher("/Account.jsp");
		disp.forward(request, response);
		
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
