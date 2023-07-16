<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	Boolean isAdmin = (Boolean)session.getAttribute("adminFilter");
	Boolean isUser = (Boolean) session.getAttribute("userFilter"); 

%>
	
<!DOCTYPE html>
<html>

<%@ include file="Header.jsp" %>
<%@ page import="java.util.*, model.Carrello,model.CartProduct" %>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Carrello</title>
		<link rel="stylesheet" type="text/css" href="./CSS/CarrelloStile.css">
		<script type="text/javascript" src="./script/jquery-3.5.1.js"></script>
		<script type="text/javascript">
		$(document).ready(function(){
		$(".Cart-Container").hover(function(){$(this).css("overflow-y","scroll");},function(){$(this).css("overflow-y","hidden");});
		
		});
		</script>
	</head>
	<body>
		<%Carrello cart=(Carrello)request.getSession().getAttribute("cart"); %>
		<%if(cart==null || cart.GetCart().size()==0) {%>
		<div class="empty-cart">
  <img id="emptyCartImage" src="${pageContext.request.contextPath}/Immagini/emptycart.jpg" alt="immagine non disponibile">
  <p>Attualmente il carrello è vuoto</p><br>
  <div class="button-container">
    <a href="ProductView.jsp" class="button">Aggiungi qualcosa</a>
  </div>
</div>		
		<%}else{ %>
		<br>
		<div class="CartUser">
		<div class="Cart-Container">
		<div class="Header">
			 <h3 class="Heading">Carrello</h3>
 			 <h5 class="Action"><a href="CartController?action=resetCart" class="cart">Svuota carrello</a></h5>
 		</div>
 	
			<% int i=0;
			while(i<cart.GetCart().size()){
				CartProduct order=cart.GetCart().get(i);%>
			<div class="Cart-Items">
				<div class="image-box">
				<a href="Dettagli.jsp?id=<%=order.GetCode()%>" target="_blank" rel="noopener">
				<img src="${pageContext.request.contextPath}/Immagini/<%=order.GetImage()%>" alt="<%=order.GetNome() %>" class="cart-img">
				</a>
				</div>
				<div class="about">
				<h2 class="title"><a href ="Dettagli.jsp?id=<%=order.GetCode()%>" target="_blank" rel="noopener"><%=order.GetNome()%></a></h2>
				<br><h3 class="subtitle"><%=order.getCapacity()%>cl</h3>
				</div>
				<div class="counter">
				<div class="btn"><a href="CartController?action=Increment&index=<%=i%>">+</a></div>
				<div class="count"><%=order.GetQuantita()%></div>
				<div class="btn"><a href="CartController?action=Decrement&index=<%=i%>">-</a></div>
				</div>
				<div class="prices">
				<div class="amount" >€<%=String.format("%.2f", order.GetPrezzo()) %></div>
				<div class="remove"><a href="CartController?action=removeCart&id=<%=order.GetCode()%>" class="cart">Rimuovi</a></div>
				</div>
				<%i++; %>	
			</div>
			<%} %>
			<hr class="Cart-Line"> 
 				<div class="checkout">
 				<div class="total">
 				<div>
 				<div class="Subtotal">Totale articoli</div>
 				<div class="items"><%=cart.TotalQuantity()%></div>
 				</div>
 				<div class="total-amount">€<%=String.format("%.2f", cart.TotalAmount()) %></div>
 				</div>
 				<br>
 				<%if((isUser!=null && isUser.booleanValue())||(isAdmin!=null && isAdmin.booleanValue())){ %>
 				<div class="button-container">
 				<a href="Checkout.jsp" class="checkout-btn">Checkout</a>
 				<%}else{ %>
 				<div class="button-container">
 				<a href="Access.jsp" class="checkout-btn">Checkout</a>
 				<%} %>
 				</div>
 				</div>
			</div>
		</div>
		<%}%>
		<footer class="footer">
		<jsp:include page="Footer.jsp" />
		</footer>
		
	</body>
</html>