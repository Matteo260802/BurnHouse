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
<link rel="stylesheet" type="text/css" href="./CSS/Showcliente.css">
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
<script>
  $(document).ready(function(){
	  $("#menu").hide(); // Nasconde il menu all'avvio
    $(".nav-container").click(function(){
      $("#menu").slideToggle();
    }); 
  });


</script>

<style>
/*questo appare solo quando il filtro di ricerca resta vuoto e si tenta una ricerca*/
.messaggio h3 {
  color: black;
  text-align: center;
  font-size:25px;
  font-family:'Montserrat', sans-serif;
  font-weight: bold;
}
</style>

</head>

<body>
<%@include file="Header.jsp" %>


<div class="page-container">
<div class="contenitor">




<div class="totole">
 <div class="nav-container">
            <input class="checkbox" type="checkbox" name="" id="" />
            <div class="hamburger-lines">
              <span class="line line1"></span>
              <span class="line line2"></span>
              <span class="line line3"></span>
            </div>  
        </div>



  <div id="menu">
    <div class="prova">
      <form method="post" action="CheckoutServlet">
        <input type="hidden" name="action" value="filter">
        
        <label for="utente">Email cliente:</label>
        <input type="text" name="utente">
        
        <label for="datainizio">Data inizio:</label>
        <input type="date" name="datainizio">
        
        <label for="datafine">Data fine:</label>
        <input type="date" name="datafine">
        
        <button type="submit">Cerca</button>	  	
      </form>
    </div>
  </div>


  <br><br><br>
  
  <div class="messaggio">
    <h3>Non puoi lasciare il filtro vuoto, riprova</h3>
  </div>


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
</div>
<footer>
<%@include file="Footer.jsp" %>
</footer>

</div>
</body>
</html>