package model;

public class Utente {
	
	String email;
	String password;
	String nome;
	String cognome;
	String BDate;
	String tipo;
	
	public Utente() {
		email="";
		password="";
		nome="";
		cognome="";
		BDate="";
		tipo="";
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPwd() {
		return password;
	}
	
	public void setPwd(String password) {
		this.password=password;
	}
	
	public String getName() {
		return nome;
	}
	
	public void setName(String nome) {
		this.nome=nome;
	}
	
	public String getSurname() {
		return cognome;
	}
	
	public void setSurname(String cognome) {
		this.cognome=cognome;
	}
	
	public String getBDate() {
		return BDate;
	}
	
	public void setBDate(String BDate) {
		this.BDate=BDate;
	}
	
	public String getType() {
		return tipo;
	}
	
	public void setType(String tipo) {
		this.tipo=tipo;
	}
	
	
}
