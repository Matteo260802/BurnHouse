<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/RegistrazioneStile.css" type="text/css">
<title>Inserimento Metodi</title>
<script src="./script/jquery-3.5.1.js"></script>
<script src="./script/metodoval.js"></script>
</head>
<body>
<%@include file="Header.jsp" %>
<div id="regis">
<h1>Metodo di pagamento già registrato</h1>
<div class="regcontainer">
		<form action="PagamentoControl" method="POST" class="registration">
			<h1 class="new">Inserisci i tuoi dati</h1>
			<br>
			<div class="overlay">
				<input type="hidden" name="action" value="insert">
		        	<h1>Numero carta</h1><input type="text" id="num_carta" name="num_carta" required placeholder="5246..." maxlength="20" size="20" class="reg">
		        	<div id="val1"></div><br><br>
		        	<h1>Nome titolare</h1><input type="text" id="titolare" name="titolare" required placeholder="Giovanni Casaburi" size="50" maxlength="50" class="reg">
		        	<div id="val2"></div><br><br>
		        	<h1>Scadenza</h1><input type="text" id="scadenza" name="scadenza" required placeholder="01/22" maxlength="10" class="reg">
					<div id="val3"></div>
					<br>
					<button class="submitreg" onclick="validate(this.form)">Salva Metodo</button>
			</div>
		</form>
	</div>
</div>
<%@ include file="Footer.jsp" %>

</body>
</html>