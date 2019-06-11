function loadTable(id){
	$('.seats').load("enroll?id="+id,function(responseValue, statusValue, xhr){
//		if(statusValue == 'success')
//		console.log(responseValue);
//	else
//		console.log("SOmething wrong...");
	});

}