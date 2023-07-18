<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.IndirizzoBean"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Indirizzi Utente</title>
<link rel="stylesheet" type="text/css" href="./CSS/showindirizzi.css">
</head>
<body>
<%@include file="Header.jsp" %>

<h1 class="title">Di seguito troverai la lista con gli indirizzi di spedizione che hai salvato sul sito</h1>
<% 
	Collection<?> indirizzi=(Collection<?>)request.getSession().getAttribute("spedizioni"); 
	
	if(indirizzi.isEmpty()||indirizzi.equals(null)){
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/InsIndirizzo.jsp");
		disp.forward(request, response);
	}%>
<div id="indcontainer">


<% Iterator it=indirizzi.iterator();
while(it.hasNext()){ 
IndirizzoBean ind=(IndirizzoBean)it.next();%>
<div class="carta">
<div class="table">
<div class="linea-carta">
   <h2><%=request.getSession().getAttribute("nome") %> <%=request.getSession().getAttribute("cognome") %></h2>
</div>


<div class="cellind">
   <h2>Via:</h2>
   <div class="riga-via">
   <h2><%=ind.GetVia() %></h2>
   </div>
</div>


<div class="cellind">
   <h2>Cap:</h2>
   <div class="riga-cap">
   <h2><%=ind.GetCap() %></h2>
   </div>
</div>


<div class="cellind">
   <h2>Città:</h2>
   <div class="riga-citta">
   <h2><%=ind.GetCitta() %></h2>
   </div>
</div>


<div class="cellind"><a href="IndirizziServlet?action=delete&via=<%=ind.GetVia() %>&cap=<%=ind.GetCap() %>&citta=<%=ind.GetCitta()%>" class="indlink">Rimuovi</a>


</div>
</div>
</div>
<%} %>

</div>

<div class="footer">
	<%@ include file="Footer.jsp" %>
</div>


</body>

</html>