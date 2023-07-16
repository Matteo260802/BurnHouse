package model;

public class Recensione {

	int id;
	String valutazione;
	String utente;
	int prodotto;
	
	public Recensione() {
		valutazione="";
		utente="";
		prodotto=0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getValutazione() {
		return valutazione;
	}
	
	public void setValutazione(String valutazione) {
		this.valutazione=valutazione;
	}
	
	public String getUtente() {
		return utente;
	}
	
	public void setUtente(String utente) {
		this.utente=utente;
	}
	
	public int getProdotto() {
		return prodotto;
	}
	
	public void setProdotto(int prodotto) {
		this.prodotto=prodotto;
	}
}
