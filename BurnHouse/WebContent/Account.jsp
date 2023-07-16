<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
	<%@ include file="Header.jsp" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="./CSS/AccountStile.css">

</head>
<body>
<br>
<div class="corpo">

<div class="title-container">
            <h1 class="title">DETTAGLI ACCOUNT</h1>
            <div class="line"></div>
</div>
 
 
<div class="allin">


     <div class="opzioni">
     
     <div class="collegamenti">
           
            <div class="pagamento">
                 <div class ="icona">
                      <i class="fas fa-credit-card"></i>
                 </div>
                 <a href="InsMetodoPag.jsp" class="info">Inserisci metodo di pagamento</a>
            </div>
           
             
             
             <div class="pagamento">
                 <div class ="icona">
                      <i class="fas fa-shipping-fast"></i>
                 </div>
                 <a href="InsIndirizzo.jsp" class="info">Inserisci indirizzo di spedizione</a>
            </div>
            
            
            <div class="pagamento">
                 <div class ="icona">
                       <i class="fab fa-cc-visa"></i> 
                 </div>
                 <a href="PagamentoControl?action=show" class="info">Visualizza Metodi di Pagamento</a>
            </div>
             
             
             <div class="pagamento">
                 <div class ="icona">
                       <i class="fas fa-map-marker-alt"></i> 
                 </div>
                 <a href="IndirizziServlet?action=show" class="info">Visualizza Indirizzi di spedizione</a>
            </div>
            
        
            
		  
    	</div>
     
     </div>
     
     
     
     
    <div class="account-details">
    <br>
    
    <div class="sinistra">
    	<div class="foto">
    	    <img src="${pageContext.request.contextPath}/Immagini/profilo.png" height="180px">
    	</div>
    	<div class="dettagli">
    	    <div class="nome">
    	         <h2>Nome</h2>
    	         <div class="rectangle">
    	              <div class="contenutorect">
    	                   <h3><%= session.getAttribute("nome") %></h3>
    	              </div>
    	         </div>
           </div>
           
           
           <div class="cognome">
    	         <h2>Cognome</h2>
    	         <div class="rectangle">
    	              <div class="contenutorect">
    	                   <h3><%= session.getAttribute("cognome") %></h3>
    	              </div>
    	         </div>
           </div>
           
           
           <div class="email">
    	         <h2>Email</h2>
    	         <div class="rectangle">
    	              <div class="contenutorect">
    	                   <h3><%= session.getAttribute("email") %></h3>
    	              </div>
    	         </div>
           </div>
           
           
           <div class="datanascita">
    	         <h2>Data di nascita</h2>
    	         <div class="rectangle">
    	              <div class="contenutorect">
    	                   <h3><%= session.getAttribute("dataNascita") %></h3>
    	              </div>
    	         </div>
           </div>
           
           
      </div>   
    </div>
    
    
    <div class="destra">
    	<div class="ordini">
    		<a href="CheckoutServlet?action=show">RIEPILOGO ORDINI</a>
    	</div>
	  	<div class="exit-button">
  			<a href="LogoutServlet">ESCI</a>
  		</div>
  	</div>
</div>
  
</div>
  
</div>

<br>
	<%@ include file="Footer.jsp" %>
</body>
</html>