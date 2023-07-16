package model;

public class IndirizzoBean {
	private String via="";
	private String cap="";
	private String citta="";
	
	
	public void SetVia(String rue) {
		this.via=rue;
	}
	
	public String GetVia() {
		return this.via;
	}
	
	public void SetCap(String c)
	{
		this.cap=c;
	}
	
	public String GetCap() {
		return this.cap;
	}
	
	public void SetCitta(String city) {
		this.citta=city;
	}
	
	public String GetCitta()
	{
		return this.citta;
	}
}
