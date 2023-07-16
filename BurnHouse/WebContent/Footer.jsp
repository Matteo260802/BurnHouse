<!-- footer.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Boolean adm = (Boolean)session.getAttribute("adminFilter"); 
	Boolean use = (Boolean)session.getAttribute("userFilter");	
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Burn House</title>
    <link rel="stylesheet" type="text/css" href="./CSS/Footer.css">
  </head> 

  <body>
    <footer id="sopra">
        <div id="zonaleftfooter">
          <h1>Contatti</h1>
          <ul>
            <li class= "selected">+39 079 261905</li>
            <li>Lun - Ven 10:00 - 19:00</li>
            <li>info@rau.it</li>
            <li>(07100) Sassari</li>
            <li>Z.I. Predda Niedda Sud strada 15</li>
          </ul>
        </div>
  
        <div id="zonaleftcenterfooter">
          <h1>Informazioni</h1>
          <ul>
            <li class= "selected"><a href="Comeordinare.jsp">Come ordinare</a></li>
            <li><a href="SpedizionePagamenti.jsp">Spedizione e pagamenti</a></li>
            <li><a href="PrivacyeCookie.jsp">Privacy e cookie</a></li>

            <li><a href="CondizioniVendita.jsp">Condizioni di vendita</a></li>


            <li><a href="Azienda.jsp">L'Azienda</a></li>
          </ul>
        </div>


        <div id="zonarightcenterfooter">
          <h1>Servizio Clienti</h1>
          <ul>
          <%if((adm==null || adm==false) && (use==null || use==false)){ %>
          	<li class= "selected"><a href="Access.jsp">Profilo</a></li>
          <%}else{ %>
            <li class= "selected"><a href="Account.jsp">Profilo</a></li>
           <%} %>
           <%if((adm==null || adm==false) && (use==null || use==false)){ %>
          	<li class= "selected"><a href="Access.jsp">I miei ordini</a></li>
          <%}else{ %>
            <li><a href="CheckoutServlet?action=show">I miei ordini</a></li>
            <%} %>
            <li><a href="CondizioniReso.jsp">Condizioni di reso</a></li>
            <li><a href="Contatti.jsp">Contatti</a></li>
            <li><a href="Contatti.jsp">Dove siamo</a></li>
          </ul> 
        </div>
       
      </footer>
      
      <div id = "foot">
      <hr>
      </div>
     
      <footer id="sotto">
      
      
        Design by Avella/Casaburi/Palumbo - Copyright © 2023 Burn House.
        Tutti i diritti riservati - P. IVA: 01465470902
      </footer>
  </body>
</html>

