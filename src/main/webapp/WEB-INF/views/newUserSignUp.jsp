<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>New User Sign Up</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="style.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4 account-wall">


			<h1 class="text-center login-title">New User Sign Up</h1>
			<form action="" method="post" class="form-signin">
				<label for="Email">Email address</label>
				<input type="email" id="Email" class="form-control" placeholder="Email" autofocus required>
				<label for="firstname">First Name</label>
				<input type="text" id="firstname" class="form-control" placeholder="First Name" >
				<label for="lastname">Email address</label>
				<input type="text" id="lastname" class="form-control" placeholder="Last Name" >
				<br>
				<label for="cmpnyAbbrev">Select Company</label>
				<select class="form-control" id="cmpnyAbbrev">
					<option value="" disabled selected>Select Company</option>
					<option>ASG</option>
					<option>FTC</option>
					<option>HRS</option>
					<option>PRIV</option>

				</select>
				<label for="position">Select Position</label>
				<select class="form-control" id="position">
					<option value="" disabled selected>Select Position</option>
					<option>Developer</option>
					<option>Tester</option>
					<option>Analyst</option>
					<option>Admin</option>

				</select>

				<label for="pwd">Password</label>
				<input type="password" id="pwd" class="form-control" placeholder="Password">
				<label for="confirm_pwd">Confirm Password</label>
				<input type="password" id="confirm_pwd" class="form-control bttm" placeholder="Confirm Password">
				<button class="btn btn-lg btn-primary btn-block " type="submit">
					Create
				</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>