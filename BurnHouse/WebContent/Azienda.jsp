<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>


<html>
<head>
    <title>About Us</title>
    
    
    
  <link rel="stylesheet" type="text/css" href="./CSS/Azienda.css">
  
   
</head>
<body>
<jsp:include page="Header.jsp" />




    <div class="title-container">
            <h1 class="title">L'AZIENDA</h1>
            <div class="line"></div>
    </div>
    
    <div id = "abpage-body">

 <section class="abhero">
    
    <div class="abcontainer">
       <div class="abhero-content">
          <h2>La nostra storia</h2>
          <p>
             Quella dell'azienda dei Fratelli Leone è una storia e una tradizione familiare cominciata nel 1926; da allora tre 
             generazioni si sono succedute alla guida, dando vita a un'azienda moderna leader nel settore della rivendita di vini, 
             liquori e distillati. Grazie alla centenaria esperienza maturata nel settore del beverage, oggi continuiamo a veicolare 
             online gli stessi valori di sempre: massima attenzione alle esigenze del cliente, scelta accurata di ogni singola 
             etichetta proposta, rapporti duraturi con i nostri fornitori e clienti.
          </p>
         <!-- <button class="abcta-button">Learn More</button>-->
       </div>
       <div class="abhero-image">
           <img class="abimg" src="${pageContext.request.contextPath}/Immagini/fondatore.jpg" alt="whisky">
       </div>
    </div>
 </section>


 
 
 
  <section class="abhero">
    
    
    <div class="abcontainer">
    
    <div class="abhero-image">
        <img class="abimg" src="${pageContext.request.contextPath}/Immagini/produzione.jpg" alt="whisky">
    </div>
       <div class="abhero-content">
          <h2>Ingredienti speciali</h2>
          <p>
             Ciò che rende speciale la nostra azienda, è senza dubbio l’amore per il lavoro che si fa. In ogni cosa va messa la 
             giusta dose d’amore, in particolare nel lavoro in un’azienda come BurnHouse, che dal 1926 si impegna a fornire prodotti 
             di alta qualità.
             Un amore che traspare anche dallo sguardo del nostro Marco, qui mentre ha in braccio una bottiglia di Gin Genesi, la 
             nostra linea speciale di alta gamma.
          </p>
          <!-- <button class="abcta-button">Learn More</button> -->
       </div>
       
    </div>
 </section>
 
 
 <section class="abhero">
    
    
    <div class="abcontainer">
       <div class="abhero-content">
          <h2>La mission</h2>
          <p>
             Una bottiglia non è solo una bottiglia, è molto di più.È convivialità, gioia, divertimento, riflessione, 
             spensieratezza, risate, amore e condivisione. Vogliamo accompagnarvi in questi attimi di vita e rendervi parte 
             integrante dei "racconti di vite"; mettere a disposizione la nostra sapienza per aiutarvi a trovare l’etichetta più 
             adatta all’occasione; proporre sempre e solo prodotti di qualità che vi portino ad apprezzare fino in fondo la bellezza
              di una degustazione; tramandarvi la nostra filosofia del bere responsabilmente.
          </p>
          <!--  <button class="abcta-button">Learn More</button>-->
       </div>
       <div class="abhero-image">
          <img class="abimg" src="${pageContext.request.contextPath}/Immagini/famiglia.jpeg" alt="whisky">
       </div>
    </div>
 </section>
</div>
<jsp:include page="Footer.jsp" />


	
	
</body>
</html>