package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
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

	private static final String TABLE_NAME = "utente";   

    public RegistrationServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String data_nascitaStr=request.getParameter("data_nascita");
		LocalDate dataNascita = LocalDate.parse(data_nascitaStr);
		java.sql.Date dataNascitaSQL = java.sql.Date.valueOf(dataNascita);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String redirectedPage = "/AlreadyRegistered.jsp";
		String redirectedPage2 = "/Home.jsp";
		
		int count=0;
		
		String checkSQL = "SELECT COUNT(*) FROM " + RegistrationServlet.TABLE_NAME + " WHERE email=?";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(checkSQL);
			preparedStatement.setString(1, email);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				count =rs.getInt(1);
			}
			
			if(count>=1)	
				response.sendRedirect(request.getContextPath() + redirectedPage);
			else {
				String selectSQL = "INSERT INTO "+ RegistrationServlet.TABLE_NAME + " VALUES (?,?,?,?,?,?)";
				
				try {
					
					connection = ds.getConnection();
					preparedStatement = connection.prepareStatement(selectSQL);
					preparedStatement.setString(1, email);
					preparedStatement.setString(2, password);
					preparedStatement.setString(3, nome);
					preparedStatement.setString(4, cognome);
					preparedStatement.setDate(5, dataNascitaSQL);
					preparedStatement.setString(6, "user");
					preparedStatement.executeUpdate();
					
					
					
					response.sendRedirect(request.getContextPath() + redirectedPage2);	
					
				}
				catch(SQLException e) {
					response.sendRedirect("GeneralError.jsp");
				}
			}
				
				
			
		}
		catch(SQLException e) {
			response.sendRedirect("GeneralError.jsp");
		}
		
		
		

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
