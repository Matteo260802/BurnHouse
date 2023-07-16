package model;

import java.io.Serializable;

public class ProductBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int codice;
	String nome;
	double prezzo;
	String descrizione;
	float gradazione;
	String tipo;
	String img;
	int capienza;
	
	public ProductBean() {
		codice= -1;
		nome= "";
		prezzo= -1;
		descrizione="";
		gradazione= -1;
		tipo= "";
		//String img=null;
		capienza=-1;
	}
	
	
	public int getCode() {
		return codice;
	}

	public void setCode(int codice) {
		this.codice = codice;
	}
	
	public String getName() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}
	
	public double getPrice() {
		return prezzo;
	}

	public void setPrice(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getDescription() {
		return descrizione;
	}

	public void setDescription(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public float getDegree() {
		return gradazione;
	}

	public void setDegree(float gradazione) {
		this.gradazione = gradazione;
	}
	
	public String getType() {
		return tipo;
	}

	public void setType(String tipo) {
		this.tipo = tipo;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img=img;
	}
	
	public int getCapacity() {
		return capienza;
	}

	public void setCapacity(int capienza) {
		this.capienza = capienza;
	}
	
	@Override
	public String toString() {
		return nome + " (" + codice + "), " + prezzo + " " + tipo + " "+ gradazione + ". " + descrizione;
	}
}






















