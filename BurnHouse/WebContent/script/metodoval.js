function checknum(carta){
	let pattern=/^\d{4}([-\s]\d{4}){3}$/
	
	if(carta.value.match(pattern)){
		
		return true;
	}
	return false;
}

function checktitol(titolare){
	let pattern=/^[A-Za-z]+([\s'-]?[A-Za-z])*$/;
	if(titolare.value.match(pattern)){
		return true;
	}
	return false;
}

function checkdate(date){
	let pattern1=/^0[1-9]{1}\/\d{2}$/;
	let pattern2=/^1[012]{1}\/\d{2}$/;
	if(date.value.match(pattern1)||date.value.match(pattern2)){
		return true;
	}
	return false;
}

function validate(obj){
	const carta=obj.num_carta;
	const titolare=obj.titolare;
	const data=obj.scadenza;
	let valid=true;
	$("#val1").html("");
	$("#val2").html("");
	$("#val3").html("");
	
	if(!checknum(carta)){
		valid=false;
		$("#val1").html("Carta non valida, 4 gruppi di 4 cifre separati da spazio");
	}
	
	if(!checktitol(titolare)){
		valid=false;
		$("#val2").html("Titolare non valido, ammessi caratteri spazi - ed '");
	}
	
	if(!checkdate(data)){
		valid=false;
		$("#val3").html("Data non valida, formato MM/YY");
	}
	
	if(valid){
		obj.submit();
	}
	else{
		obj.reset();
	}
	
}