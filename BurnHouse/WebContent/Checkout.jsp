<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" type="text/css" href="./CSS/CheckoutStile.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="./script/jquery-3.5.1.js"></script>
<script src="./script/check.js">
</script>
</head>
<body>
<%@include file="Header.jsp" %>
 <div class="title-container">
            <h1 class="title">CHECKOUT</h1>
            <div class="line"></div>
</div>


<div id="Checkout">

<div id="Cart">
<h2 class="riepilogo">Riepilogo Carrello</h2>
<% Carrello cart=(Carrello)request.getSession().getAttribute("cart");
for(CartProduct c: cart.GetCart()){
%>


<div class='line-check'></div>
<div class="Cart-Items">
                
				<div class="image-box">
				<img src="${pageContext.request.contextPath}/Immagini/<%=c.GetImage()%>" alt="<%=c.GetNome() %>" class="cart-img">
				</div>
				
				<div class="about">
				<h2 class="title"><%=c.GetNome()%></h2>
				<br><h3 class="subtitle"><%=c.getCapacity()%>cl</h3>
				</div>
				
				<div class="counter">
				<h2 class= "quantita">Quantità</h2>
				<div class="count"><%=c.GetQuantita()%></div>	
				</div>
				
				<div class="provaprices">
				<h2 class= "prezzo">Prezzo</h2>
				<div class="amount" >€<%=String.format("%.2f", c.GetPrezzo()*c.GetQuantita()) %></div>
				</div>
				
			</div>
			
			<%} %>
			<hr class="Cart-Line"> 
 				<div class="checkout">
 				<div class="total">
 				<div>
 				<div class="Subtotal">Totale articoli</div>
 				<div class="items">IVA inclusa</div>
 				</div>
 				<div class="total-amount">€<%=String.format("%.2f", cart.TotalAmount()+(cart.TotalAmount()*22)/100) %></div>
 				</div>
 				</div>
</div>

<div class="parte-inferiore">
<form action="CheckoutServlet" method="POST" id="checkmate">
<input type="hidden" name="action" value="insert">

<div class="indirizzi">
<% IndirizzoDAO richiesta=new IndirizzoDAO();
	Collection<?> spedizione=richiesta.DoRetrieveByUser((String)request.getSession().getAttribute("email"));
	if(spedizione==null || spedizione.isEmpty()){%>
	<div class="primo">
	<button class="ins"><a href="InsIndirizzo.jsp" class="vai">Inserisci indirizzo di spedizione</a></button>
	</div>
	<%}else{ 
	%><div class="IHead">Indirizzi di spedizione</div> <% 	
	Iterator it=spedizione.iterator();
	while(it.hasNext()){
	IndirizzoBean ind=(IndirizzoBean)it.next();%>
	<div class="indirizzo" onclick="checkedind('<%=ind.GetVia()%>')">
	<div class="rettangolo-carta">
	   
	   	<input type="radio" name="via" value="<%=ind.GetVia() %>" required class="ind"><label for="via" id="rue">
	   	<div class="cornice">
	   	   <h2><%=ind.GetVia() %></h2>
	   	</div>
	   	
	   	<div class="cornice1">
	   	   <h2><%=ind.GetCitta() %></h2>
	   	</div>
	   	</label>
	   	
	   
	</div>
	</div>
	<%}} %>
</div>


<div class="Metodi">
<% PagamentoDAO richiesto=new PagamentoDAO(); 
	Collection<Pagamento> metodi=richiesto.DoRetrieveByUser((String)request.getSession().getAttribute("email"));
	if(metodi==null || metodi.isEmpty()){%>
	<div class="secondo">
	<button class="ins"><a href="InsMetodoPag.jsp" class="vai">Inserisci metodo di pagamento</a></button>
	</div>
	<%}else{
	%><div class=MHead>Metodi di pagamento</div> <% 
	Iterator i=metodi.iterator();
	while(i.hasNext()){
	Pagamento carta=(Pagamento)i.next();%>
	<div class="metodo" onclick="checkedind('<%=carta.GetNum()%>')">
	   <div class="rettangolo-carta">
	      
	         	   <input type="radio" name="carta" value="<%=carta.GetNum() %>" required class="pag"><label for="carta">
        <div class="cornice">
        <h2><%=carta.GetNum() %></h2>
       </div>
       
       <div class="cornice1">
        <h2><%=carta.GetTitolare() %></h2>
       </div>
       </label>
	</div>
	</div>
<%}} %>
</div>
<input type="submit" value="Concludi" id="concludi">
</form>
</div>
</div>

<%@include file="Footer.jsp" %>
</body>
</html>