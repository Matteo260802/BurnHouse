<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="UTF-8">
<title>Aggiungi prodotto</title>
<link rel="stylesheet" type="text/css" href="./CSS/Modifica.css">
</head>
<body>
<jsp:include page="Header.jsp" />
<div class="corpo">
	<div class="insert">
	
		<form action="product" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="action" value="insert"> 
		
		<label for="codice">Codice:</label><br> 
		<input name="codice" type="number" min="0" required><br>
		
		<label for="nome">Nome:</label><br> 
		<input name="nome" type="text" maxlength="20" required ><br> 
		
		<label for="prezzo">Prezzo:</label><br> 
		<input name="prezzo" type="number" step="0.01" min="0" required><br>
		
		<label for="descrizione">Descrizione:</label><br>
		<textarea name="descrizione" maxlength="100" rows="3" required ></textarea><br>
		
		<label for="gradazione">Gradazione:</label><br> 
		<input name="gradazione" type="number" step="0.01" min="0" max="100" required><br>
		
		<label for="capienza">Capienza:</label><br> 
		<input name="capienza" type="number" max="150" required placeholder="cl"><br> 
		
		<label for="tipo">Tipo:</label><br> 
		<input name="tipo" type="text" maxlength="20" required placeholder="vino, distillato, liquore"><br> 
		
		
		
		
		
		<label for="myfile" class="custom-file-upload">
 		 <span>Carica una foto</span>
		</label>
		<input type="file" id="myfile" name="img" class="file-input" required/>
		
		
		<input type="submit" value="Aggiungi" class="pul aggiungi">
		<input type="reset" value="Reset" class="pul reset">
		</form>
	
	</div>
</div>
		
		<jsp:include page="Footer.jsp" />
</body>
</html>