<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.*" %>
<%@ page import="java.util.*" %>

<html lang="en" dir="ltr">
<head>
	<meta charset="UTF-8">
	<title>BurnHouse</title>
	<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/4.2.0/normalize.css">-->
	<link rel="stylesheet" type="text/css" href="./CSS/HomeStile.css">

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

    <jsp:include page="Header.jsp" />
	<div class="hero">
    <div class="hero__content reveal">
      <p class="intro-text">Distilleria artigianale</p>
      <h1 class="big-text">Burn House</h1>
      <a href="Azienda.jsp" class="button">Maggiori informazioni</a>
    </div>
    
    <video autoplay muted loop id="video-back">
      <source src="${pageContext.request.contextPath}/Immagini/video.mp4" type="video/mp4">
    </video>    
  </div>

	
	<!-- Cards -->
	
	<div class="grid">
  <div class="grid__item">
    <div class="card"><img class="card__img" src="${pageContext.request.contextPath}/Immagini/banner_vini.jpg" alt="vini">
      <div class="card__content">
        <h1 class="card__header">Vini</h1>
        <p class="card__text">Vini rossi e bianchi, mossi e fermi. Tutto sul nettare di Bacco!</p>
        <a href="Vini.jsp">
        <button class="card__btn">Esplora <span>&rarr;</span></button>
        </a>
      </div>
    </div>
  </div>
  <div class="grid__item">
        <div class="card"><img class="card__img" src="${pageContext.request.contextPath}/Immagini/banner_liquori.jpg" alt="whisky">
    
      <div class="card__content">
        <h1 class="card__header">Liquori</h1>
        <p class="card__text">Come fine pasto amaro o liquore non possono mancare.</p>
        <a href="Liquori.jsp">
        <button class="card__btn">Esplora <span>&rarr;</span></button>
        </a>
      </div>
    </div>
  </div>
  <div class="grid__item">
               <div class="card"><img class="card__img" src="${pageContext.request.contextPath}/Immagini/banner_distillati.jpg" alt="spumanti">
      <div class="card__content">
        <h1 class="card__header">Distillati</h1>
        <p class="card__text">Di distilleria in distilleria, potrai scegliere tra mille gusti!</p>
        <a href="Distillati.jsp">
        <button class="card__btn">Esplora <span>&rarr;</span></button>
        </a>
      </div>
    </div>
  </div>
</div>

	
	
	
	


	<section class="banner clearfix" >
		<div class="banner__image" >
		<img class="card__image"src="${pageContext.request.contextPath}/Immagini/vini.jpg" style="width:100%;" alt="Nature">
		</div>
		<div class="banner__copy">
			<div class="banner_copy_text">
			</div>
		</div>
	</section>

	

	
	
  	<%
    ProductModelDS model = new ProductModelDS();
  	
  	//Questo viene usato per la pagina dettagli, va a settare i prodotti in modo che quando si clicca sui dettagli non gli passi come argomento null
  	Collection<ProductBean> all = model.doRetrieve();
  	session.setAttribute("products", all);
  	
  	
  	
    Collection<ProductBean> products = model.doRetrieveByVinoBest();
    
	%>
	
	<!-- linea 1 -->
	<section class="product1"> 
	<div class="title-container">
            <h1 class="title">VINI</h1>
            <div class="line"></div>
    </div>

	  <button class="pre-btn1"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
	  <button class="nxt-btn1"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
	  <script src="prova.js"></script>
  
  
	
	  <div class="product-container1">
	     <% for (ProductBean bean : products) { %>
	    <div class="product-card1">
	      <div class="product-image1">
	      <a href="Dettagli.jsp?id=<%=bean.getCode()%>" target="_blank" rel="noopener">
	        <img src="Immagini/<%=bean.getImg()%>" class="product-thumb1" alt="">
	        </a>
	         <a href="CartController?action=addCart&id=<%=bean.getCode()%>" class="buy">
	        <button class="card-btn1">AGGIUNGI AL CARRELLO</button>
	        </a>
	      </div>
	      <div class="product-info1">
	        <h2 class="product-brand1"><%=bean.getName() %></h2>
	        <span class="price1"><%=String.format("%.2f", bean.getPrice()) %> €</span>
	      </div>
	    </div>
	    
	
	    <% } %>
	  </div>
	  
	</section>

    
   
    
    <section class="banner clearfix">
		<div class="banner__image">
		<img class="card__image"src="${pageContext.request.contextPath}/Immagini/liquori.png" style="width:100%;" alt="Nature">
		</div>
		<div class="banner__copy">
			<div class="banner_copy_text">
				<!--  <h3>Liquori italiani</h3>-->
			</div>
		</div>
	</section>
    
    
    
    <%
    Collection<ProductBean> products2 = model.doRetrieveByLiquoreBest();
	%>
    
    <!-- linea 2 -->
    <section class="product2"> 
    <div class="title-container">
            <h1 class="title">LIQUORI</h1>
            <div class="line"></div>
    </div>
          
          
          
  <button class="pre-btn2"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
  <button class="nxt-btn2"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
  <script src="prova.js"></script>
  
   
  <div class="product-container2">
  <% for (ProductBean bean2 : products2) { %>
    <div class="product-card2">
      <div class="product-image2">
      <a href="Dettagli.jsp?id=<%=bean2.getCode()%>" target="_blank" rel="noopener">
       <img src="Immagini/<%=bean2.getImg()%>" class="product-thumb2" alt="">
       </a>
       <a href="CartController?action=addCart&id=<%=bean2.getCode()%>" class="buy">
        <button class="card-btn2">AGGIUNGI AL CARRELLO</button>
        </a>
      </div>
      <div class="product-info2">
        <h2 class="product-brand2"><%=bean2.getName() %></h2>
      
        <span class="price2"><%=String.format("%.2f", bean2.getPrice()) %> €</span>
      </div>
    </div>
<% } %>
  </div>

</section>
    

    
    
	

	
	<section class="banner clearfix">
		<div class="banner__image">
		<img class="card__image"src="${pageContext.request.contextPath}/Immagini/distillati.jpg" style="width:100%;" alt="Nature">
		</div>
		<div class="banner__copy">
			<div class="banner_copy_text">
				<!--  <h3>Distillati italiani</h3>-->
			</div>
		</div>
	</section>
	
	
	    <%
    Collection<ProductBean> products3 = model.doRetrieveByDistillatoBest();
	%>
	
	<!-- linea 3 -->
	<section class="product3"> 
	<div class="title-container">
            <h1 class="title">DISTILLATI</h1>
            <div class="line"></div>
          </div>
  <button class="pre-btn3"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
  <button class="nxt-btn3"><img src="${pageContext.request.contextPath}/Immagini/arrow.png" alt=""></button>
  <script src="prova.js"></script>
  
   
  <div class="product-container3">
    <% for (ProductBean bean3 : products3) { %>
    <div class="product-card3">
      <div class="product-image3">
      <a href="Dettagli.jsp?id=<%=bean3.getCode()%>" target="_blank" rel="noopener">
        <img src="Immagini/<%=bean3.getImg()%>" class="product-thumb3" alt="">
        </a>
        <a href="CartController?action=addCart&id=<%=bean3.getCode()%>" class="buy">
        <button class="card-btn3">AGGIUNGI AL CARRELLO</button>
        </a>
      </div>
      <div class="product-info3">
        <h2 class="product-brand3"><%=bean3.getName() %></h2>
        <span class="price3"><%=String.format("%.2f", bean3.getPrice()) %> €</span>
      </div>
    </div>
<% } %>
  </div>

</section>

	


<!-- swiper prova -->
<div class="slider">
	<div class="slide-track">

		<div class="slide">
			<img src="Immagini/marchio1.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio2.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio3.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio4.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio5.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio6.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio7.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio8.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio9.jpg">
		</div>


		<!--le stesse foto duplicate-->

		<div class="slide">
			<img src="Immagini/marchio1.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio2.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio3.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio4.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio5.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio6.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio7.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio8.jpg">
		</div>

		<div class="slide">
			<img src="Immagini/marchio9.jpg">
		</div>


	</div>
</div>



    

	
	
	
	
	
	
    
    
    


    
    <jsp:include page="Footer.jsp" />
    
    <script>

  //parallax
  let hero_imgs = document.querySelectorAll('.banner__image');

  window.addEventListener('scroll' , function(){

      let win_pos = window.pageYOffset;
      hero_imgs.forEach((hero_img) => {

        let element_rect = hero_img.getBoundingClientRect();

        // console.log("el " + element_rect.top);
        // console.log("win " + win_pos);

        if(win_pos > element_rect.top ){        
          hero_img.style.transform = "translateY(" +  element_rect.top  * - 1  * .13 + "px)";
        }
 
      });
    
  });
   
   </script>  
   
   
<script>
document.addEventListener("DOMContentLoaded", function() {
	  new Swiper('.swipper-container', {
	    slidesPerView: 1,
	    spaceBetween: 10,
	    loop: true,
	    autoplay: {
	      delay: 3000, // Tempo in millisecondi tra ogni slide
	    },
	  });
	});


</script>
   
   
  
  
     
</body>
</html>