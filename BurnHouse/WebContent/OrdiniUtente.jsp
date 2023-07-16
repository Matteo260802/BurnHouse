<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Orderbean, model.CartProduct"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordini effettuati</title>
<link rel="stylesheet" type="text/css" href="./CSS/Showorder.css">
<script src="./script/jquery-3.5.1.js" type="text/javascript">


</script>
<script>
$(document).ready(function(){
	$(".ordercont").hide();
	$(".headorder").click(function(){
		$(this).nextAll(".ordercont").slideToggle();
	});
	
});
</script>
</head>

<body>

<%@include file="Header.jsp" %>

<div class="contenitor">

   <!--  di prova da qui-->


















<% HashMap<?,?> tutto=(HashMap<?,?>)request.getSession().getAttribute("prodorder");
  Collection<?> ordini=(Collection<?>)request.getSession().getAttribute("ordini");
  
  if((ordini==null || ordini.isEmpty())||(tutto==null || tutto.isEmpty())){%>
      <div class="container">
		<div class="water"></div>
      </div>
	  <h1 id="riempi">La tua botte è vuota</h1>
	  <button id="compra"><a href="ProductView.jsp">Riempila</a></button>	  
  <%}
  
  else{ %>
  
	<div id="riepilogoordini">
	<% Iterator it=ordini.iterator();
		while(it.hasNext()){
		Orderbean order=(Orderbean)it.next();%>
		<div class="headorder"><span class="acq">Acquirente: <%=order.GetUser() %>
			</span><h3 class="number">Ordine n.<%=order.GetCode() %>
			</h3>
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
		<%}} %>
	</div>
	
</div>

<footer>
<%@include file="Footer.jsp" %>
</footer>



</body>
</html>