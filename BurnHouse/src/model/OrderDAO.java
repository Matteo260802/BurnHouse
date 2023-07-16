package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDAO {
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
	private static String table_name="ordine";
	private static String table2_name="inclusione";
	
	
	public synchronized Orderbean DoRetrieveByKey(int codice) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		Orderbean order=new Orderbean();
		String quer="SELECT * FROM "+table_name+" WHERE codice=?";
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			query.setInt(1, codice);
			ResultSet res=query.executeQuery();
			if(res.next()) {
				order.SetCode(res.getInt("codice"));
				order.SetPrice(res.getDouble("prezzo"));
				order.SetInd(res.getString("ind_spedizione"));
				order.SetUser(res.getString("utente"));
				order.SetIVA(res.getInt("aliquota_IVA"));
				order.SetDate(res.getDate("data_effettuazione"));
				order.SetCarta(res.getString("num_carta"));
			}
			
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return order;
	}
	
	public synchronized Collection<Orderbean> DoRetrieveByAll(String order) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList<Orderbean> ordini=new LinkedList<Orderbean>();
		String quer="SELECT * FROM "+table_name+" ORDER BY ?";
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(order!=null && !order.equals("")) {
				query.setString(1, order);
				
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Orderbean ordine=new Orderbean();
					ordine.SetCode(res.getInt("codice"));
					ordine.SetPrice(res.getDouble("prezzo"));
					ordine.SetInd(res.getString("ind_spedizione"));
					ordine.SetUser(res.getString("utente"));
					ordine.SetIVA(res.getInt("aliquota_IVA"));
					ordine.SetDate(res.getDate("data_effettuazione"));
					ordine.SetCarta(res.getString("num_carta"));
					ordini.add(ordine);
				}
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return ordini;
	}
	
	public synchronized Collection<Orderbean> DoRetrieveByUser(String utente)throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList<Orderbean> ordini=new LinkedList<Orderbean>();
		String quer="Select * from "+table_name+" where utente=?";
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(utente!=null && !utente.equals("")) {
				query.setString(1, utente);
				
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Orderbean ordine=new Orderbean();
					ordine.SetCode(res.getInt("codice"));
					ordine.SetPrice(res.getDouble("prezzo"));
					ordine.SetInd(res.getString("ind_spedizione"));
					ordine.SetUser(res.getString("utente"));
					ordine.SetIVA(res.getInt("aliquota_IVA"));
					ordine.SetDate(res.getDate("data_effettuazione"));
					ordine.SetCarta(res.getString("num_carta"));
					ordini.add(ordine);
				}
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return ordini;
	}
	
	public synchronized Collection<Orderbean> DoRetrieveByDate(Date dataInizio, Date dataFine)throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList<Orderbean> ordini=new LinkedList<Orderbean>();
		String quer="Select * from "+table_name+" where data_effettuazione between ? and ?";
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(dataInizio!=null && dataFine!=null) {
				query.setDate(1, dataInizio);
				query.setDate(2, dataFine);
				
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Orderbean ordine=new Orderbean();
					ordine.SetCode(res.getInt("codice"));
					ordine.SetPrice(res.getDouble("prezzo"));
					ordine.SetInd(res.getString("ind_spedizione"));
					ordine.SetUser(res.getString("utente"));
					ordine.SetIVA(res.getInt("aliquota_IVA"));
					ordine.SetDate(res.getDate("data_effettuazione"));
					ordine.SetCarta(res.getString("num_carta"));
					ordini.add(ordine);
				}
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return ordini;
	}
	
	public synchronized Collection<Orderbean> DoRetrieveByDateAndUser(String utente, Date inizio, Date fine)throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList<Orderbean> ordini=new LinkedList<Orderbean>();
		String quer="Select * from "+table_name+" where data_effettuazione between ? and ? and utente = ?";
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(inizio!=null && fine!=null && utente!=null && !utente.equals("")) {
				query.setDate(1, inizio);
				query.setDate(2, fine);
				query.setString(3, utente);
				
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Orderbean ordine=new Orderbean();
					ordine.SetCode(res.getInt("codice"));
					ordine.SetPrice(res.getDouble("prezzo"));
					ordine.SetInd(res.getString("ind_spedizione"));
					ordine.SetUser(res.getString("utente"));
					ordine.SetIVA(res.getInt("aliquota_IVA"));
					ordine.SetDate(res.getDate("data_effettuazione"));
					ordine.SetCarta(res.getString("num_carta"));
					ordini.add(ordine);
				}
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return ordini;
	}
	
	public synchronized Collection <CartProduct>DoRetrieveByOrder(int order) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList <CartProduct> prod=new LinkedList<CartProduct>();
		ProductModelDS prodotto=new ProductModelDS();
		String quer="SELECT * FROM "+table2_name+" WHERE num_ordine=?";
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			query.setInt(1, order);
			ResultSet res=query.executeQuery();
			
			while(res.next()) {
				ProductBean ordine=prodotto.doRetrieveByKey(res.getInt("prodotto"));
				CartProduct cart=new CartProduct();
				cart.SetCode(ordine.getCode());
				cart.setCapacity(ordine.getCapacity());
				cart.SetNome(ordine.getName());
				cart.SetPrezzo(ordine.getPrice());
				cart.SetImage(ordine.getImg());
				cart.SetQuantita(res.getInt("quantita"));
				prod.add(cart);
			}
		}finally {
			try {
			if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
			}
		return prod;
	}
	
	public synchronized void DoDelete(int order) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		PreparedStatement query2=null;
		String quer1="DELETE FROM "+table_name+" WHERE codice=?";
		String quer2="Delete from "+table2_name+" where num_ordine=?";
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer1);
			query2=con.prepareStatement(quer2);
			
			query2.executeUpdate();
			query.executeUpdate();
			
		}finally{
			try {
				if(query2!=null)query2.close();
				
			}finally {
				try {
				if(query2!=null)query2.close();
				}finally{
					if(con!=null)con.close();
				}
				}
		}
	}
	
	public synchronized void DoSave(Carrello cart,String utente, String indirizzo, String carta,String date) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		PreparedStatement query2=null;
		//Orderbean order=new Orderbean();
		String quer1="INSERT INTO "+table_name+" (prezzo,ind_spedizione,aliquota_IVA,utente,data_effettuazione,num_carta) VALUES(?,?,?,?,?,?)";
		String quer2="INSERT INTO "+table2_name+" (num_ordine,prodotto,quantita) VALUES(?,?,?)";
		Double tasse=(cart.TotalAmount()*22)/100;
		LocalDate localDate=LocalDate.parse(date);
		Date effettuazione=java.sql.Date.valueOf(localDate);
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer1);
			query2=con.prepareStatement(quer2);
			
			if(cart!=null &&(utente!=null && !utente.equals("") && (indirizzo!=null && !indirizzo.equals("") && (carta!=null && !carta.equals(""))))) {
				
				query.setDouble(1,cart.TotalAmount()+tasse);
				query.setString(2, indirizzo);
				query.setInt(3,22);
				query.setString(4, utente);
				query.setDate(5, effettuazione);
				query.setString(6,carta);
				
				query.executeUpdate();
				int code=this.SearchCodeMax();
				
				for(CartProduct c: cart.GetCart()) {
					query2.setInt(1, code);
					query2.setInt(2, c.GetCode());
					query2.setInt(3, c.GetQuantita());
					query2.executeUpdate();
				}
				
			}
		}finally {
			try {
				if(query!=null) query.close();
				
			}finally {
				try{
					if(query2!=null)query2.close();
				}finally {
					if(con!=null)con.close();
				}
			}
		}
	}
	
	public synchronized int SearchCodeMax() throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		int code=0;
		String quer="Select MAX(codice)as maxcode From "+table_name;
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			ResultSet res=query.executeQuery();
			
			if(res.next()) {
				code=res.getInt("maxcode");
			}
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return code;
	}
	
	//Deve restituire tutti gli ordini nel database
	public synchronized Collection<Orderbean> DoRetrieveAll() throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		LinkedList<Orderbean> ordini=new LinkedList<Orderbean>();
		String quer="SELECT * FROM "+table_name;
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);

				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					Orderbean ordine=new Orderbean();
					ordine.SetCode(res.getInt("codice"));
					ordine.SetPrice(res.getDouble("prezzo"));
					ordine.SetInd(res.getString("ind_spedizione"));
					ordine.SetUser(res.getString("utente"));
					ordine.SetIVA(res.getInt("aliquota_IVA"));
					ordine.SetDate(res.getDate("data_effettuazione"));
					ordine.SetCarta(res.getString("num_carta"));
					ordini.add(ordine);
				}
			
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return ordini;
	}
	
}





