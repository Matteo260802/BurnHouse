<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Operazione completata</title>
<link rel="stylesheet" type="text/css" href="./CSS/Errore.css">
</head>
<body>
<div class="container">
  <img src="Immagini/brindisi.png" alt="Immagine non disponibile">
    <h2>CONGRATULAZIONI ORDINE EFFETTUATO, VUOI VEDERE ALTRO?</h2>
    <%request.getSession().setAttribute("cart",null); %>
    <a href="Home.jsp" class="home styled-link">Torna alla home</a>
  </div>
</body>
</html>