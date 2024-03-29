package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class IndirizzoDAO {
	private static DataSource ds;
	private static final String table1_name="indirizzo";
	private static  final String table2_name="spedizione";
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/burn_house");

		} catch (NamingException e) {
			System.err.println("Error:" + e.getMessage());
		}
	}

	
	public synchronized IndirizzoBean DoRetrieveByKey(String via, String cap, String citta) throws SQLException {
	    Connection con = null;
	    PreparedStatement query = null;
	    String quer = "SELECT * FROM " + IndirizzoDAO.table1_name + " WHERE via=? AND cap=? AND citta=?";
	    IndirizzoBean ind = new IndirizzoBean();

	    try {
	        con = ds.getConnection();
	        query = con.prepareStatement(quer);
	        if ((via != null && !via.equals("")) && (cap != null && !cap.equals("")) && (citta != null && !citta.equals(""))) {
	            query.setString(1, via);
	            query.setString(2, cap);
	            query.setString(3, citta);

	            ResultSet res = query.executeQuery();
	            if (res.next()) {
	                ind.SetVia(res.getString("via"));
	                ind.SetCap(res.getString("cap"));
	                ind.SetCitta(res.getString("citta"));
	            }
	            res.close();
	        }
	    } finally {
	        try {
	            if (query != null)
	                query.close();
	        } finally {
	            if (con != null)
	                con.close();
	        }
	    }
	    return ind;
	}
	
	public synchronized ArrayList<IndirizzoBean> DoRetrieveAll(String order) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		
		IndirizzoBean ind=new IndirizzoBean();
		ArrayList<IndirizzoBean> indirizzi=new ArrayList<IndirizzoBean>();
		String quer="Select * From "+IndirizzoDAO.table1_name+" Order by ?";
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			if(order!=null && !order.equals("")) {
				query.setString(1, order);
				
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
				ind.SetVia(res.getString("via"));
				ind.SetCap(res.getString("cap"));
				ind.SetCitta(res.getString("citta"));
				indirizzi.add(ind);
				}
			}
		}finally {
			try {
				if (query != null)
					query.close();
			} finally {
				if (con != null)
					con.close();
			}
		}
		return indirizzi;	
}
	
	public synchronized void DoSave(String via, String cap, String citta, String utente) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		PreparedStatement query2=null;
		String quer1="INSERT INTO "+IndirizzoDAO.table1_name+" Values(?,?,?)";
		String quer2="INSERT INTO "+IndirizzoDAO.table2_name+" VALUES(?,?,?,?)";
		IndirizzoBean ind=new IndirizzoBean();
		ind=this.DoRetrieveByKey(via, cap, citta);
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer1);
			query2=con.prepareStatement(quer2);
			
			
			if((via!=null && !via.equals(""))&&(cap!=null && !cap.equals(""))&&(citta!=null && !citta.equals(""))&&(utente!=null && !utente.equals(""))) {
				if(!ind.GetVia().equals(via)||!ind.GetCap().equals(cap)||!ind.GetCitta().equals(citta)) {
				query.setString(1, via);
				query.setString(2, cap);
				query.setString(3, citta);
				query.executeUpdate();
				}
				
				query2.setString(1,utente);
				query2.setString(2, via);
				query2.setString(3, cap);
				query2.setString(4, citta);
				
				
				query2.executeUpdate();
				
				
			}
			
		}finally {
			try {
				if(query!=null) {
					query.close();
				
				}
			}finally {
				try {
				if(query2!=null)query2.close();	
				
				}finally {
				if(con!=null)con.close();
				}
				}
		}
	}
	
	public synchronized void DoDelete(String via, String cap, String citta,String utente) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		
		String quer="DELETE FROM "+IndirizzoDAO.table2_name+" WHERE utente=? AND via=? AND cap=? AND citta=?";
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			
			if((via!=null && !via.equals(""))&&(cap!=null && !cap.equals(""))&&(citta!=null && !citta.equals(""))&&(utente!=null && !utente.equals(""))) {
				query.setString(1,utente);
				query.setString(2, via);
				query.setString(3, cap);
				query.setString(4, citta);
				
				query.executeUpdate();
				ArrayList<IndirizzoBean> prova=this.DoRetrieveByFKey(via, cap, citta);
				if(prova.isEmpty()) {
					this.DoDeleteDef(via, cap, citta);
				}
				
			}
		}finally {
			try {
				if(query!=null) {
					query.close();
				}
					
				}finally {
				if(con!=null)con.close();
				}
				}
			
		}
	
	
	
	public synchronized ArrayList<IndirizzoBean> DoRetrieveByUser(String user) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		String quer="Select via,cap,citta from "+IndirizzoDAO.table2_name+" Where utente=?";
		ArrayList<IndirizzoBean> indirizzi=new ArrayList<IndirizzoBean>();
		
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			if(user!=null && (!user.equals("")))
			{
				query.setString(1,user);
				ResultSet res=query.executeQuery();
				
				while(res.next()) {
					IndirizzoBean ind=new IndirizzoBean();
					ind.SetVia(res.getString("via"));
					ind.SetCap(res.getString("cap"));
					ind.SetCitta(res.getString("citta"));
					indirizzi.add(ind);
				}
				
			}
			
		}finally {
			try {
				if(query!=null)query.close();
			}finally {
				if(con!=null)con.close();
			}
		}
		return indirizzi;
	}
	
	public synchronized ArrayList<IndirizzoBean> DoRetrieveByFKey(String via, String cap, String citta) throws SQLException {
	    Connection con = null;
	    PreparedStatement query = null;
	    String quer = "SELECT * FROM " + IndirizzoDAO.table2_name + " WHERE via=? AND cap=? AND citta=?";
	    ArrayList<IndirizzoBean> indi = new ArrayList<IndirizzoBean>();

	    try {
	        con = ds.getConnection();
	        query = con.prepareStatement(quer);
	        if ((via != null && !via.equals("")) && (cap != null && !cap.equals("")) && (citta != null && !citta.equals(""))) {
	            query.setString(1, via);
	            query.setString(2, cap);
	            query.setString(3, citta);

	            ResultSet res = query.executeQuery();
	            if (res.next()) {
	            	IndirizzoBean ind=new IndirizzoBean();
	                ind.SetVia(res.getString("via"));
	                ind.SetCap(res.getString("cap"));
	                ind.SetCitta(res.getString("citta"));
	                indi.add(ind);
	            }
	            res.close();
	        }
	    } finally {
	        try {
	            if (query != null)
	                query.close();
	        } finally {
	            if (con != null)
	                con.close();
	        }
	    }
	    return indi;
	}
	
	public synchronized void DoDeleteDef(String via, String cap, String citta) throws SQLException{
		Connection con=null;
		PreparedStatement query=null;
		
		String quer="DELETE FROM "+IndirizzoDAO.table1_name+" WHERE via=? AND cap=? AND citta=?";
		try {
			con=ds.getConnection();
			query=con.prepareStatement(quer);
			
			
			if((via!=null && !via.equals(""))&&(cap!=null && !cap.equals(""))&&(citta!=null && !citta.equals(""))) {
				query.setString(1, via);
				query.setString(2, cap);
				query.setString(3, citta);
				
				query.executeUpdate();
								
				
				
			}
		}finally {
			try {
				if(query!=null) {
					query.close();
				}
					
				}finally {
				if(con!=null)con.close();
				}
				}
			
		}
	
	
}
