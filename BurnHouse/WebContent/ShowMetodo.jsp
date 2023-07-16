<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Pagamento"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagamenti</title>
<link rel="stylesheet" type="text/css" href="./CSS/ShowMetodopagamento.css">
</head>
<body>

<%@include file="Header.jsp" %>

<h1 class="title">Di seguito troverai la lista con i metodi di pagamento che hai salvato sul sito</h1>
<% 
	Collection<?> metodi=(Collection<?>)request.getSession().getAttribute("metodi"); 
	
	if(metodi.isEmpty()||metodi.equals(null)){
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/InsMetodoPag.jsp");
		disp.forward(request, response);
	}%>
<div id="indcontainer">


<% Iterator it=metodi.iterator();
while(it.hasNext()){ 
Pagamento ind=(Pagamento)it.next();%>
<div class="carta">
<div class="table">
<div class="linea-carta">
   <h2><%=request.getSession().getAttribute("nome") %> <%=request.getSession().getAttribute("cognome") %></h2>

</div>

<div class="cellind">
   <h2>Numero carta:</h2>
   <div class="riga-numero">
   <h2><%=ind.GetNum() %></h2>
   </div>
</div>


<div class="cellind"> 
   <h2>Titolare Conto:</h2>
   <div class="riga-titolare">
   <h2><%=ind.GetTitolare() %></h2>
   </div>
</div>


<div class="cellind"> 
<h2>Scadenza carta:</h2>
   <div class="riga-carta">
   <h2><%=ind.GetScadenza() %></h2>
   </div>
</div>

<div class="cellind"><a href="PagamentoControl?action=delete&num_carta=<%=ind.GetNum() %>" class="indlink">Rimuovi</a>




</div>
</div>
</div>

<%} %>
</div>
<footer id="footer">
<%@include file="Footer.jsp"%>
</footer>

</body>

</html>