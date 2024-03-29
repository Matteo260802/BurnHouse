<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Orderbean, model.CartProduct"%>
    
<% 
	Boolean AD = (Boolean)session.getAttribute("adminFilter");
	Boolean US = (Boolean) session.getAttribute("userFilter");
%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Ordini effettuati</title>
<link rel="stylesheet" type="text/css" href="./CSS/Showorder.css">
<script src="./script/jquery-3.5.1.js" type="text/javascript">
</script>
<script>

</script>
</head>

<body>
<%@include file="Header.jsp" %>



<div class="page-container">
	<div class="contenitor">

<% HashMap<?,?> tutto=(HashMap<?,?>)request.getSession().getAttribute("prodorder");
  Collection<?> ordini=(Collection<?>)request.getSession().getAttribute("ordini");
  
  if((ordini==null || ordini.isEmpty())||(tutto==null || tutto.isEmpty())){%>
  <div class="container">
	<div class="water"></div>
  </div>
  <h1 id="riempi">Attualmente non risultano ordini effettuati<br>
  	Esplora il catalogo e scopri i nostri fantastici prodotti
  </h1>
  
  
       <a href="ProductView.jsp" class="cart-btn">Esplora</a>	

  <%}else{%>
	<div id="riepilogoordini">
	<% Iterator it=ordini.iterator();
		while(it.hasNext()){
		Orderbean order=(Orderbean)it.next();%>
		<div class="headorder"><span class="acq">Acquirente: <%=order.GetUser() %>
			</span><div class="number">Ordine n.<%=order.GetCode() %>
			<br>
			<div class="fattura">
			<a href="Fattura.jsp?code=<%=order.GetCode() %>&data=<%=order.GetDate()%>&nome=<%=request.getSession().getAttribute("nome")%>&cognome=<%=request.getSession().getAttribute("cognome")%>&nOrdine=<%=order.GetCode() %>">Fattura</a>
			</div>
			</div>
			<span class="date">Data effettuazione:<br><%=order.GetDate() %></span>
		</div>
		<%Collection<CartProduct> prodorder=(Collection<CartProduct>)tutto.get(order.GetCode()); 
			Iterator<CartProduct> i=prodorder.iterator();
			while(i.hasNext()){
				CartProduct prod=i.next();%>
				<div class="ordercont">
				
				
							
					<a href ="Dettagli.jsp?id=<%=prod.GetCode()%>" target="_blank" rel="noopener">
						<img src="${pageContext.request.contextPath}/Immagini/<%=prod.GetImage()%>" alt="Immagine non disponibile" class="orderimg">
					</a>
				
					
					<h3 class="about">
						<a href ="Dettagli.jsp?id=<%=prod.GetCode()%>" target="_blank" rel="noopener"><%=prod.GetNome()%></a>
						<br>
						<%=prod.getCapacity() %>cl
					</h3>
					
					<div class="price">
						Prezzo
						<br>
						€<%=String.format("%.2f", prod.GetPrezzo())%>
					</div>
				</div>
		  <%}%>
		  
		<div class="order-total">
			Totale ordine<br>
			€<%=String.format("%.2f", order.GetPrice()) %>
		
		</div>
		<%} 
		
  }%>
	</div>
			</div>
	<%@include file="Footer.jsp" %>
</div>

</body>
</html>