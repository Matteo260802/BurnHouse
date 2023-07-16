package control;



import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.IndirizzoDAO;
import model.IndirizzoBean;

/**
 * Servlet implementation class IndirizziServlet
 */
@WebServlet("/IndirizziServlet")
public class IndirizziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndirizziServlet() {
        super();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String utente=(String) request.getSession().getAttribute("email");
		

		
		if(action.equals("insert")) {
			IndirizzoDAO richiesto=new IndirizzoDAO();
			
			try {
				IndirizzoBean ind=new IndirizzoBean();
				ind.SetVia(request.getParameter("via"));
				ind.SetCap(request.getParameter("cap"));
				ind.SetCitta(request.getParameter("citta"));
				
				ArrayList<IndirizzoBean> indirizzi=richiesto.DoRetrieveByUser(utente);
				
				int i=0;
				while(i<indirizzi.size()) {
					if(ind.GetVia().equals(indirizzi.get(i).GetVia())&&(ind.GetCap().equals(indirizzi.get(i).GetCap()))&&(ind.GetCitta().equals(indirizzi.get(i).GetCitta()))) {
						RequestDispatcher disp=getServletContext().getRequestDispatcher("/AlreadyIndPresent.jsp");
						disp.forward(request, response);
					}
					i++;
				}
				richiesto.DoSave(ind.GetVia(),ind.GetCap(),ind.GetCitta(),utente);
		
			} catch (Exception e) {
				response.sendRedirect("GeneralError.jsp");
				e.printStackTrace();
			}
		}else if(action.equals("show")) {
			IndirizzoDAO richiesto=new IndirizzoDAO();
			try {
				ArrayList<IndirizzoBean> indirizzi=richiesto.DoRetrieveByUser(utente);
				request.getSession().setAttribute("spedizioni", indirizzi);
				RequestDispatcher disp=getServletContext().getRequestDispatcher("/ShowIndirizzo.jsp");
				disp.forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("GeneralError.jsp");
			}
			
		}else if(action.equals("delete")) {
			IndirizzoDAO richiesto=new IndirizzoDAO();
			
			try {
				IndirizzoBean ind=new IndirizzoBean();
				ind.SetVia(request.getParameter("via"));
				ind.SetCap(request.getParameter("cap"));
				ind.SetCitta(request.getParameter("citta"));
				
				richiesto.DoDelete(ind.GetVia(),ind.GetCap(),ind.GetCitta(),utente);
			} catch (Exception e) {
				response.sendRedirect("GeneralError");
			}
		}
		
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/Account.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
