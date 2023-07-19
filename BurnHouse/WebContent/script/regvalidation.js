





function checkemail(email){
	
	let pattern=/^\w+([.-]{1}\w+)*@\w+([.-]{1}\w+)*(\.\w{2,3})+$/;
	if(email.value.match(pattern)){
		return true;
	}
	return false;
}

function checkname(nome){
	
	let pattern=/^[A-Za-z]+([\s'-]{1}[A-Za-z]+)*$/;
	if(nome.value.match(pattern)){
		return true;
	}
	return false;
}

function checksurname(cognome){
	
	let pattern=/^[A-Za-z]+([\s'-]{1}[A-Za-z]+)*$/;
	if(cognome.value.match(pattern)){
		return true;
	}
	return false;
}



function validate(obj){
	
	const email=obj.email;
	const nome=obj.nome;
	const cognome=obj.cognome;
	
	let valid=true;
	$("#val1").html("");
	$("#val2").html("");
	$("#val3").html("");
	$("#val4").html("");
	if(!checkname(nome)){
		valid=false;
		$("#val1").html("Nome non valido, solo caratteri");
	}
	
	if(!checksurname(cognome)){
	
		valid=false;
		$("#val2").html("Cognome non valido, solo caratteri");
	}
	
	if(!checkemail(email)){
		
		valid=false;
		$("#val3").html("Email non valida");
	}
	

	
	return valid;
}


