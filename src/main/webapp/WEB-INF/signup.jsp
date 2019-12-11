<!DOCTYPE html>
<html>
<head>
<title>${name}</title>
<script type="text/javascript" src="/resources/js/login.js"></script>
<link rel="stylesheet" href="/resources/css/page.css">
</head>
<body>
	<div class="userId">
		<label class="signup">User Id</label> 
		<input id="userid" placeholder="User Id" type="text" />
	</div>
	<div class="userName">
		<label class="signup">User Name</label> 
		<input id="username" type="text" />
	</div>
	<div class="emailId">
		<label class="signup">Email Id</label> 
		<input id="emailid" type="text" />
	</div>
	<div class="phone">
		<label class="signup">Phone Number</label> 
		<input id="phoneno" type="text" onkeypress="validateNumber(event)" />
	</div>
	<div class="password">
		<label class="signup">Password</label> 
		<input id="password" type="password" />
	</div>
	<button onclick="insertNewUser()">Submit</button>
</body>
</html>