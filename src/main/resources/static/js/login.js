function validate(){
	var userName = document.getElementById('username');
	var password = document.getElementById('password');
	if(!(username && username.value)){
		alert('Enter user name');
	} else if(!(password && password.value)){
		alert('Enter password');
	} else {
		
		fetch('http://localhost:8080/checkUser', {
		    method : "POST",
		    headers: {
		        "Content-Type": "application/json"
		      },

		     body : JSON.stringify({
		         username : userName.value,
		         password : password.value
		     })
		}).then( 
			response => response.text() 
		).then(function(response){
			if(response === 'success'){
				window.open("http://localhost:8080/homePage","_self")
			} else if(response === 'wrong') {
				alert('Invalid userid or password');
			} else {
				alert('User id does not exist');
			}
		});
		
	}
}

function insertNewUser() {
	var userId = document.getElementById('userid').value;
	var username = document.getElementById('username').value;
	var emailid = document.getElementById('emailid').value;
	var phoneno = document.getElementById('phoneno').value;
	var password = document.getElementById('password').value;
	if(userId && username && emailid && phoneno && password){
		fetch('http://localhost:8080/insertUser', {
		    method : "POST",
		    headers: {
		        "Content-Type": "application/json"
		      },

		     body : JSON.stringify({
		    	 userId: userId,
		         userName : username,
		         emailId: emailid,
		         mobileNo: phoneno,
		         password : password
		     })
		}).then( 
			response => response.text() 
		).then(function(response){
			if(response === 'Success'){
				window.open("http://localhost:8080/login","_self")
			} else {
				alert("user Id already exist");
			}
		});
	} else {
		alert('Enter all details');
	}
	
}

function moveSignUp() {
	window.open("http://localhost:8080/signUp","_self")
}
function validateNumber(event){
	console.log(event);
	var value = document.getElementById('phoneno').value;
	if(!parseInt(value)){
//		document.getElementById('phoneno').value='';
		event.preventDefault();
	} else {
		var value = document.getElementById('phoneno').value;
		if(value.length >= 10){
			event.preventDefault();
		}
	}
}
