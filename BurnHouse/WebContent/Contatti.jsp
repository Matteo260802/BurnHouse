<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Burn House</title>
      
      <link rel="stylesheet" type="text/css" href="./CSS/Contatti.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
      
    </head>

   <body>
   <jsp:include page = "Header.jsp"/>
   <div class="title-container">
            <h1 class="title">CONTATTI</h1>
            <div class="line"></div>
    </div>

      <div class="contenitore">
   
      <section>
      <div class="contact-container">
         <div class="form-content">
            <h3>Contattaci</h3>
            
            <div class="left-side">
            <div class ="commentiamo">
            <p>Per informazioni sulle spedizioni, sui pagamenti e sul funzionamento di BurnHouse, vai alle pagine <a href="Comeordinare.jsp">Come Ordinare</a>, <a href="SpedizionePagamenti.jsp">Spedizione e pagamenti</a>, <a href="CondizioniVendita.jsp">Condizioni di vendita</a> .</p>
            </div>
            
            
            <div class="address">
            <div class ="icona">
               <i class="fas fa-map-marker-alt"></i>
            </div>
            
            <div class="topic">Address</div>
            <div class="text-one">sdfsdfsdfsdfsdf</div>
            </div>
            
            <div class="phone">
            <div class ="icona">
            <i class="fas fa-phone-alt"></i>
            </div>
            <div class="topic">Phone</div>
            <div class="text-one">23423423423</div>
            </div>
            
            <div class="email">
            <div class ="icona">
            <i class="fas fa-envelope"></i>
            </div>
            <div class="topic">Email</div>
            <div class="text-one">sdfsdfsdfsdfsdf</div>
            </div>
         </div>
         </div>

         <!--Map-->
         <div class="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.2636889537293!2d14.685748276434184!3d40.75622473490646!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc73de72ba9f1%3A0x149a6903fe2a0f02!2sVia%20Crocevia%2C%2019%2C%2084086%20Roccapiemonte%20SA!5e0!3m2!1sit!2sit!4v1687786458395!5m2!1sit!2sit" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
         </div>
      </div>
   </section>
   </div>
  

   <jsp:include page = "Footer.jsp"/>
   </body>
</html>


