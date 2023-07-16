function ajax(find){
	
	let xmlhttp=new XMLHttpRequest();
	$("#suggest>li").remove();
	xmlhttp.onreadystatechange=function(){
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			const sugg=JSON.parse(xmlhttp.responseText);
			for(i=0;i<sugg.length;i++){
				let li="<li>"+sugg[i]+"</li>";
				$("#suggest").wrapInner(li);
			}
			
		}
	}
	xmlhttp.open("POST", "product", true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	

	let data = "action=ajax&find=" + encodeURIComponent(find);
	xmlhttp.send(data);
}


