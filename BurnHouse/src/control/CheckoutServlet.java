package control;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Carrello;
import model.CartProduct;
import model.OrderDAO;
import model.Orderbean;



@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckoutServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String utente=(String)request.getSession().getAttribute("email");
		OrderDAO richiesta=new OrderDAO();
		
		if(action.equals("insert")) {
			try {
				 
				Carrello cart=(Carrello)request.getSession().getAttribute("cart");
				String ind=request.getParameter("via");
				
				String carta=request.getParameter("carta");
				
				Date eff=new Date();
				SimpleDateFormat effettuazione=new SimpleDateFormat("YYYY-MM-dd");
				String date=effettuazione.format(eff);
				
				richiesta.DoSave(cart, utente, ind, carta,date);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/Checkcompleto.jsp");
				disp.forward(request, response);
				
			}catch(Exception e) {
				response.sendRedirect("GeneralError.jsp");
			
			}
		}else if(action.equals("show")) {
			try {
				Collection<Orderbean> ordini=richiesta.DoRetrieveByUser(utente);
				request.getSession().setAttribute("ordini", ordini);
				HashMap<Integer,Collection<CartProduct>> tutto= new HashMap<Integer,Collection<CartProduct>>();
				Iterator<Orderbean> it=ordini.iterator();
				while(it.hasNext()) {
					int i=it.next().GetCode();
					Collection<CartProduct> prod=richiesta.DoRetrieveByOrder(i);
					tutto.put(i,prod);
				}
				request.getSession().setAttribute("prodorder", tutto);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/ShowOrdini.jsp");
				disp.forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("GeneralError.jsp");
				
			}
		}else if(action.equals("all")) {
			try {
				Collection<Orderbean> ordini=richiesta.DoRetrieveAll();
				request.getSession().setAttribute("ordini", ordini);
				HashMap<Integer,Collection<CartProduct>> tutto= new HashMap<Integer,Collection<CartProduct>>();
				Iterator<Orderbean> it=ordini.iterator();
				while(it.hasNext()) {
					int i=it.next().GetCode();
					Collection<CartProduct> prod=richiesta.DoRetrieveByOrder(i);
					tutto.put(i,prod);
				}
				request.getSession().setAttribute("prodorder", tutto);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/OrdiniClienti.jsp");
				disp.forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("GeneralError.jsp");
				
			}
		}else if(action.equals("filter")) {
			try {
				utente=request.getParameter("utente");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				String dataInizioStringa = request.getParameter("datainizio");
				
				String dataFineStringa = request.getParameter("datafine");
				

				
	
				
				
				
				
				//Solo utente
				if ((utente != null && !utente.isEmpty()) && (dataInizioStringa == null || dataInizioStringa.isEmpty()) && (dataFineStringa == null || dataFineStringa.isEmpty())) {
					Collection<Orderbean> ordini=richiesta.DoRetrieveByUser(utente);
					request.getSession().setAttribute("ordini", ordini);
					HashMap<Integer,Collection<CartProduct>> tutto= new HashMap<Integer,Collection<CartProduct>>();
					Iterator<Orderbean> it=ordini.iterator();
					while(it.hasNext()) {
						int i=it.next().GetCode();
						Collection<CartProduct> prod=richiesta.DoRetrieveByOrder(i);
						tutto.put(i,prod);
					}
					request.getSession().setAttribute("prodorder", tutto);
					RequestDispatcher disp=getServletContext().getRequestDispatcher("/OrdiniUtente.jsp");
					disp.forward(request, response);
				}  
				
				
				
				//Solo date
				else if ((utente == null || utente.isEmpty()) && (dataInizioStringa != null && !dataInizioStringa.isEmpty()) && (dataFineStringa != null && !dataFineStringa.isEmpty())) {
					
					LocalDate dataInizioLocalDate = LocalDate.parse(dataInizioStringa, formatter);
					java.sql.Date dataInizioSql = java.sql.Date.valueOf(dataInizioLocalDate);
					LocalDate dataFineLocalDate = LocalDate.parse(dataFineStringa, formatter);
					java.sql.Date dataFineSql = java.sql.Date.valueOf(dataFineLocalDate);
					
					Collection<Orderbean> ordini = richiesta.DoRetrieveByDate(dataInizioSql, dataFineSql);
					
					
					
					request.getSession().setAttribute("ordini", ordini);
					HashMap<Integer,Collection<CartProduct>> tutto= new HashMap<Integer,Collection<CartProduct>>();
					Iterator<Orderbean> it=ordini.iterator();
					while(it.hasNext()) {
						int i=it.next().GetCode();
						Collection<CartProduct> prod=richiesta.DoRetrieveByOrder(i);
						tutto.put(i,prod);
					}
					request.getSession().setAttribute("prodorder", tutto);
					RequestDispatcher disp=getServletContext().getRequestDispatcher("/OrdiniUtente.jsp");
					disp.forward(request, response);
				}
				
				
				//Sia utente che date
				else if ((utente != null && !utente.isEmpty()) && (dataInizioStringa != null && !dataInizioStringa.isEmpty()) && (dataFineStringa != null && !dataFineStringa.isEmpty())) {
					
					LocalDate dataInizioLocalDate = LocalDate.parse(dataInizioStringa, formatter);
					java.sql.Date dataInizioSql = java.sql.Date.valueOf(dataInizioLocalDate);
					LocalDate dataFineLocalDate = LocalDate.parse(dataFineStringa, formatter);
					java.sql.Date dataFineSql = java.sql.Date.valueOf(dataFineLocalDate);
					
					
					
					Collection<Orderbean> ordini = richiesta.DoRetrieveByDateAndUser(utente, dataInizioSql, dataFineSql);
					
					request.getSession().setAttribute("ordini", ordini);
					HashMap<Integer,Collection<CartProduct>> tutto= new HashMap<Integer,Collection<CartProduct>>();
					Iterator<Orderbean> it=ordini.iterator();
					while(it.hasNext()) {
						int i=it.next().GetCode();
						Collection<CartProduct> prod=richiesta.DoRetrieveByOrder(i);
						tutto.put(i,prod);
					}
					request.getSession().setAttribute("prodorder", tutto);
					RequestDispatcher disp=getServletContext().getRequestDispatcher("/OrdiniUtente.jsp");
					disp.forward(request, response);
				}
				
				else {
					response.sendRedirect("RiprovaFiltro.jsp");
				}

				
				
			} catch (Exception e) {
				//response.sendRedirect("GeneralError.jsp");
				System.out.println(e);
				
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}











