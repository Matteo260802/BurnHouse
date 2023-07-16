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

public class PagamentoDAO {
	private static DataSource ds;
	private static String table_name="pagamento";
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/burn_house");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
		
		public synchronized Pagamento DoRetrieveByKey(String carta, String utente) throws SQLException {
			Connection con=null;
			PreparedStatement query=null;
			Pagamento pago=new Pagamento();
			String quer="Select * from "+table_name+" Where num_carta=? AND utente=?";
			try {
				con=ds.getConnection();
				query=con.prepareStatement(quer);
				
				if((carta!=null && !carta.equals("")&&(utente!=null && !utente.equals("")))) {
					query.setString(1, carta);
					query.setString(2, utente);
					
					ResultSet res=query.executeQuery();
					
					while(res.next()) {
					pago.SetNum(res.getString("num_carta"));
					pago.SetUtente(res.getString("utente"));
					pago.SetTitolare(res.getString("titolare"));
					pago.SetScadenza(res.getString("scadenza"));
					}
				}
			}finally {
				try {
					if(query!=null)query.close();
				}finally {
					if(con!=null)con.close();
				}
			}
			return pago;
		}
		
		public synchronized Collection<Pagamento> DoRetrieveAll(String order) throws SQLException{
			Connection con=null;
			PreparedStatement query=null;
			LinkedList<Pagamento> metodi=new LinkedList<Pagamento>();
			String quer="Select * from "+table_name+" Order by ?";
			
			try {
				con=ds.getConnection();
				query=con.prepareStatement(quer);
				
				if(order!=null && !order.equals("")) {
					query.setString(1, order);
					
					ResultSet res=query.executeQuery();
					while(res.next()) {
					Pagamento carta=new Pagamento();
					carta.SetNum(res.getString("num_carta"));
					carta.SetUtente(res.getString("utente"));
					carta.SetTitolare(res.getString("titolare"));
					carta.SetScadenza(res.getString("scadenza"));
					metodi.add(carta);
					
				}
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
			return metodi;
	}
		
		public synchronized Collection<Pagamento> DoRetrieveByUser(String user) throws SQLException{
			Connection con=null;
			PreparedStatement query=null;
			LinkedList<Pagamento> metodi=new LinkedList<Pagamento>();
			String quer="Select * from "+table_name+" Where utente=?";
			try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(user!=null && !user.equals("")) {
				query.setString(1, user);
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Pagamento pago=new Pagamento();
					pago.SetNum(res.getString("num_carta"));
					pago.SetUtente(res.getString("utente"));
					pago.SetTitolare(res.getString("titolare"));
					pago.SetScadenza(res.getString("scadenza"));
					metodi.add(pago);
				}
			}
			}finally {
				try {
					if(query!=null)query.close();
				}finally {
					if(con!=null)con.close();
				}
			}
			return metodi;
			}
		
		
		public synchronized boolean DoSave(String num, String user, String titolare, String date) throws SQLException{
			Connection con=null;
			PreparedStatement query=null;
			Pagamento pago=this.DoRetrieveByKey(num,user);
			String quer="INSERT INTO "+table_name+" VALUES(?,?,?,?)";
			
			if(pago.GetNum().equals(num) && pago.GetUtente().equals(user)) {System.out.println("sono"); return false;}
			
			try {
				con=ds.getConnection();
				query=con.prepareStatement(quer);
				
				if((num!=null && !num.equals(""))&&(user!=null && !user.equals(""))&&(titolare!=null && !titolare.equals(""))&&(date!=null && !date.equals(""))) {
					query.setString(1, num);
					query.setString(2, user);
					query.setString(3, titolare);
					query.setString(4, date);
					
					query.executeUpdate();
				}
			}finally {
				try {
					if(query!=null)query.close();
				}finally {
					if(con!=null)con.close();
				}
			}
			return true;
		}
		
		public synchronized void DoDelete(String num, String user) throws SQLException{
			Connection con=null;
			PreparedStatement query=null;
			String quer="DELETE FROM "+table_name+" WHERE num_carta=? AND utente=?";
			try {
				con=ds.getConnection();
				query=con.prepareStatement(quer);
				
				if((num!=null && !num.equals(""))&&(user!=null && !user.equals(""))){
					query.setString(1, num);
					query.setString(2, user);
					
					query.executeUpdate();
				}
			}finally {
				try {
					if(query!=null)query.close();
				}finally {
					if(con!=null)con.close();
				}
			}
		}
		}



