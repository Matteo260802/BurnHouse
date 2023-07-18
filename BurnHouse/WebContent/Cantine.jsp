<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>


<html lang="it">
<head>
    <title>Cantine</title>
    
    
    
  <link rel="stylesheet" type="text/css" href="./CSS/Cantine.css">
  
   
</head>
<body>
<jsp:include page="Header.jsp" />


    <div class="title-container">
            <h1 class="title">LE CANTINE</h1>
            <div class="line"></div>
    </div>
    
 
 
	<section class="banner clearfix" >
		<div class="banner__image" >
		<img class="card__image"src="${pageContext.request.contextPath}/Immagini/cantine.PNG" style="width:100%;" alt="Nature">
		</div>
		<div class="banner__copy">
			<div class="banner_copy_text">
			</div>
		</div>
	</section>
    
    <!-- swiper prova -->
<div class="grid-container">
  <div class="grid-item">
  <img src="Immagini/marchio1.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio2.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio3.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio4.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio5.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio6.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio7.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio8.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio9.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio10.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio11.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio12.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio13.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio14.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio15.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio16.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio17.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio18.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio19.jpg" alt="">
  </div>
  <div class="grid-item">
  <img src="Immagini/marchio20.jpg" alt="">
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


        if(win_pos > element_rect.top ){        
          hero_img.style.transform = "translateY(" +  element_rect.top  * - 1  * .13 + "px)";
        }
 
      });
    
  });
   
   </script> 
	 


	
</body>
</html>