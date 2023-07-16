<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./CSS/AccessStile.css">
<script type="text/javascript" src="./script/jquery-3.5.1.js"></script>
<script>
function validation(obj){
	var pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

	if(obj.email.value.match(pattern)){
		
		obj.form.submit();
	}
	else{
		$("#val").html("Email non valida");
		obj.reset();
		obj.email.focus();
		
	}
}
</script>

</head>
<body>

<h3>Email o password errati, per favore riprova</h3>

<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action=LoginServlet method=post>
			<h1>Accedi</h1>
			<input type="email" name=email placeholder="Email" required/>
			<div id="val"></div>
			<input type="password" name=password placeholder="Password" required/>
			
			<br>
			<button onclick="validation(this.form)">Accedi</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-right">
				<h1>Registrati</h1>
				<p>Se sei nuovo registrati sul nostro sito e scopri i fantastici prodotti di BurnHouse</p>
				<a href="Registrazione.jsp"><button class="ghost" id="signUp">Registrati</button></a>
			</div>
		</div>
	</div>
</div>
</body>
</html>