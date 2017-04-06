function showAndHide(idli, iddiv) {
	document.getElementsByClassName('active')[0].setAttribute('class','tabs');
	document.getElementById(idli).setAttribute('class', 'tabs active');
	
	for (var i=0;i<document.getElementsByClassName("tab_content").length;i++) {
		document.getElementsByClassName("tab_content")[i].style.display = "none";
	}
	
	document.getElementById(iddiv).style.display = 'block';
}

function checkPass() {
	//Store the password field objects into variables ...
	var pass1 = document.getElementById('password');
	var pass2 = document.getElementById('reenterpassword');
	//Store the Confimation Message Object ...
	var message = document.getElementById('confirmMessage');
	//Set the colors we will be using ...
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	//Compare the values in the password field 
	//and the confirmation field
	if(pass1.value == pass2.value){
		//The passwords match. 
		//Set the color to the good color and inform
		//the user that they have entered the correct password 
		pass2.style.backgroundColor = goodColor;
		message.style.color = goodColor;
		message.innerHTML = "Passwords Match!"
	}else{
		//The passwords do not match.
		//Set the color to the bad color and
		//notify the user.
		pass2.style.backgroundColor = badColor;
		message.style.color = badColor;
		message.innerHTML = "Passwords Do Not Match!"
	}
}

function refresh() {
	$('.table').load(window.location.href +  ' .table', console.log("OK"));
}