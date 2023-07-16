package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ShowRecensioni{
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
      




	public synchronized Collection<Recensione> mostraRecensioni(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Recensione> recensioni = new LinkedList<Recensione>();
		
		
		String selectSQL = "SELECT * FROM " + ShowRecensioni.TABLE_NAME + " WHERE prodotto = ?";
		
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Recensione review = new Recensione();

				review.setProdotto(rs.getInt("prodotto"));
				review.setUtente(rs.getString("utente"));
				review.setValutazione(rs.getString("valutazione"));
				review.setId(rs.getInt("id"));
				recensioni.add(review);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

		return recensioni;
		
	}


}

