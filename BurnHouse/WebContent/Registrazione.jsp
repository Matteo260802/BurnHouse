<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">

<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>
    <link rel="stylesheet" type="text/css" href="./CSS/RegistrazioneStile.css">
    <script type="text/javascript" src="./script/jquery-3.5.1.js"></script>
    <script src="./script/regvalidation.js" type="text/javascript"></script>
</head>
<body>

	<div id="regis">
	<div class="regcontainer">
		<form action="RegistrationServlet" method="POST" class="registration" onsubmit="return validate(this)">
			<h1>Inserisci i tuoi dati</h1>
			<div class="overlay">
		        	<input type="text" id="nome" name="nome" required placeholder="Nome" class="reg"><div id="val1"></div>
		        	<input type="text" id="cognome" name="cognome" required placeholder="Cognome" class="reg"><div id="val2"></div>
		        	<input type="email" id="email" name="email" required placeholder="Email" class="reg"><div id="val3"></div>
		        	<input type="password" id="password" name="password" required placeholder="Password" class="reg">
					<label class="data">Data di nascita: </label> 		        
		        	<input type="date" id="data_nascita" name="data_nascita" required><div id="val4"></div>
					<br>
					<br>
					<button  class="submitreg">Registrati</button>
			</div>
		</form>
	</div>
</div>


</body>
</html>