function checkcap(cap){
	
	let pattern=/^\d{5}$/;
	if(cap.value.match(pattern)){
		return true;
	}
	return false;
}


function checkcitta(citta){
	let pattern=/^[A-Za-z]+([-'\s]\w+)*$/;
	if(citta.value.match(pattern)){
		return true;
	}
	return false;
} 

function checkvia(via){
	let pattern = /^[A-Za-z]+([-'\s]?\w+)*\s[1-9]\d{0,2}$/;
	if(via.value.match(pattern)){
		return true;
	}
	return false;
}

function validate(obj){
	$("#val1").html("");
	$("#val2").html("");
	$("#val3").html("");

	const via=obj.via;
	const citta=obj.citta;
	const cap=obj.cap;
	let valid=true;
	
	if(!checkvia(via)){
		valid=false;
		$("#val1").html("Via non valida, numero civico finale");
	}
	
	if(!checkcap(cap)){
		
		valid=false;
		$("#val2").html("CAP non valido, 5 cifre");
	}
	
	if(!checkcitta(citta)){
		valid=false;
		$("#val3").html("Città non valida, solo caratteri separati da spazio e -");
	}
	
	if(valid){ 
		obj.submit();
	
	}else{
		obj.reset();
	}
}