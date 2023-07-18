function ajax(find){
	
	let xmlhttp=new XMLHttpRequest();
	$("#suggest>li").remove();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			const sugg=JSON.parse(xmlhttp.responseText);
			for( let i=0;i<sugg.length;i++){
				
				let li="<li onclick='launch(this.innerHTML)'>"+sugg[i]+"</li>";
				$("#suggest").append(li);
			}
			
		}
	}
	xmlhttp.open("POST", "product", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.setRequestHeader("connection","close");

	let data = "action=ajax&find=" + encodeURIComponent(find);
	xmlhttp.send(data);
}


function launch(sug){
	$("#search-box-input").val(sug);
	$("#search-box-input").focus();
}

