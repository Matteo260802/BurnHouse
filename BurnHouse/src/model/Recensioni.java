package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/Recensioni")
public class Recensioni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static DataSource ds;
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/burn_house");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "recensione";   

    public Recensioni() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valutazione=request.getParameter("valutazione");
		String utente=request.getParameter("email");
		String prodottoStr=request.getParameter("prodotto");
		int prodotto= Integer.parseInt(prodottoStr);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String redirectedPage = "/Home.jsp";
		
		
		
				String selectSQL = "INSERT INTO "+ Recensioni.TABLE_NAME + "(valutazione,utente,prodotto) VALUES (?,?,?)";
				
				try {
					
					connection = ds.getConnection();
					preparedStatement = connection.prepareStatement(selectSQL);
					preparedStatement.setString(1, valutazione);
					preparedStatement.setString(2, utente);
					preparedStatement.setInt(3, prodotto);
					preparedStatement.executeUpdate();
					
					response.sendRedirect(request.getContextPath() + redirectedPage);
					
				}
				catch(SQLException e) {
					response.sendRedirect("GeneralError.jsp");
				}
			
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
      
}