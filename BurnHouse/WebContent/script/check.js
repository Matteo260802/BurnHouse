
function checkedind(radvalue){
	
$("input[type='radio'][value='"+radvalue+"']").prop("checked",true);

}


function checkouterrato(obj){
	$("#errato").html("");
	
	const via=obj.via
	const carta=obj.carta;
	
	if(via!=undefined && carta!=undefined){
		return true;
	}else{
	$("#errato").html("Inserire indirizzo e metodo");
	return false;
	}
}
