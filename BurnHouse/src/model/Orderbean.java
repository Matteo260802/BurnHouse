package model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Orderbean {

private int codice;
private double prezzo;
private String indirizzo="";
private int IVA;
private String utente="";
private String carta="";
private GregorianCalendar date;

public Orderbean() {
	this.date=new GregorianCalendar();
}

public void SetCode(int code) {
	this.codice=code;
}

public int GetCode() {
	return this.codice;
}

public void SetPrice(double prezzo) {
	this.prezzo=prezzo;
}

public double GetPrice() {
	return this.prezzo;
}


public void SetInd(String ind) {
	this.indirizzo=ind;
}

public String GetInd() {
	return this.indirizzo;
}

public void SetIVA(int iva) {
	this.IVA=iva;
}

public int GetIVA() {
	return this.IVA;
}

public void SetUser(String user) {
	this.utente=user;
}

public String GetUser() {
	return this.utente;
}

public void SetDate(Date date) {
	this.date.setTime(date);
}

public String GetDate() {
	SimpleDateFormat pattern=new SimpleDateFormat("dd/MM/yyyy");
	String date=pattern.format(this.date.getTime());
	return date;
}

public void SetCarta(String cart) {
	this.carta=cart;
}

public String GetCarta() {
	return this.carta;
}

}

