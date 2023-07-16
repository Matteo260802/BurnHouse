package model;




public class Pagamento {
	private String num_carta="";
	private String utente="";
	private String nome="";
	private String scadenza="";
	
	public void SetNum(String carta) {
		this.num_carta=carta;
	}
	
	public String GetNum() {
		return this.num_carta;
	}
	
	public void SetUtente(String user) {
		this.utente=user;
	}
	
	public String GetUtente() {
		return this.utente;
	}
	
	public void SetTitolare(String nome) {
		this.nome=nome;
	}
	
	public String GetTitolare() {
		return this.nome;
	}
	
	public void SetScadenza(String data){
		this.scadenza=data;
	}
	
	public String GetScadenza() {
		return this.scadenza;
	}
	
	
}
