package model;
import java.util.ArrayList;

public class Carrello {
 private ArrayList<CartProduct> cart;


public Carrello()
{
	cart=new ArrayList<CartProduct>();
}
	
	public void AddtoCart(ProductBean prod)
	{
		for(int i=0;i<cart.size();i++) {
			if(prod.getCode()==cart.get(i).GetCode()) {
				cart.get(i).IncrQuantita();
				return;
			}
		}
		
		
		
		CartProduct order=new CartProduct();
		order.SetCode(prod.getCode());
		order.SetNome(prod.getName());
		order.SetPrezzo(prod.getPrice());
		order.SetQuantita(1);
		order.SetImage(prod.getImg());
		order.setCapacity(prod.getCapacity());
		cart.add(order);
	}
	
	public void RemovetoCart(int id)
	{
		for(CartProduct c: cart)
		{
			if(c.GetCode()==id) 
			{
			cart.remove(c);
			break; 
			}
		}
	}
	public ArrayList<CartProduct> GetCart()
	{
		return this.cart;
	}
	
	public double TotalAmount()
	{
		double sum=0;
		for(CartProduct order:cart)
		{
			sum=sum+(order.GetPrezzo()*order.GetQuantita());
		}
		return sum;
	}
	
	public int TotalQuantity()
	{
		int count=0;
		for(CartProduct order: cart)
		{
			count=count+order.GetQuantita();
		}
		return count;
	}
	
}