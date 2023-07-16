<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./CSS/AccessStile.css">

</head>
<body>

<h3>Per poter inserire una recensione riguardo un prodotto devi prima effettuare l'accesso</h3>

<div class="container" id="container">
	<div class="form-container sign-in-container">
		<form action=LoginServlet method=post>
			<h1>Accedi</h1>
			<input type="email" name=email placeholder="Email" required/>
			<input type="password" name=password placeholder="Password" required/>
			<br>
			<button>Accedi</button>
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