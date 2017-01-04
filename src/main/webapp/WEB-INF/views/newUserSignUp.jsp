<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>New User Sign Up</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.8/validator.min.js"></script>

	<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="container">
	<div class="row">
		<div class="col-xs-12 col-md-4 col-md-offset-4 account-wall">
			<h1 class="text-center login-title">New User Sign Up</h1>
			<form id="signup" action="create" method="post" class="form-signin">
				<div class="form-group">
					<label for="Email">Email Address:</label>
					<input type="email" id="Email" class="form-control " placeholder="example@mail.com"
						   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
						   title="Must have the pattern similar to 'example@mail.com' pattern."
						   data-error="Must have the pattern similar to 'example@mail.com' pattern."
						   autofocus required>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="firstname">First Name:</label>
					<input type="text" id="firstname" class="form-control " placeholder="First Name" data-minlength="2"
						   data-error="Please enter at least 2 characters" pattern="[A-Za-z]+" title="Letters only"
						   required>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="lastname">Last Name:</label>
					<input type="text" id="lastname" class="form-control " placeholder="Last Name" data-minlength="2"
						   data-error="Please enter at least 2 characters" pattern="[A-Za-z]+" title="Letters only"
						   required>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="cmpnyAbbrev">Select Company:</label>
					<select class="form-control " id="cmpnyAbbrev" data-error="Please select a company" required>
						<option value="" disabled selected>Select Company</option>
						<option>ASG</option>
						<option>FTC</option>
						<option>HRS</option>
						<option>PRIV</option>
					</select>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group">
					<label for="position">Select Position:</label>
					<select class="form-control" id="position" data-error="Please select a position" required>
						<option value="" disabled selected>Select Position</option>
						<option>Developer</option>
						<option>Tester</option>
						<option>Analyst</option>
						<option>Admin</option>
					</select>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group has-feedback">
					<label for="pwd">Password:</label>
					<input type="password" id="pwd" class="form-control" placeholder="Password"
						   pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" data-minlength="5" maxlength="30"
						   title="Password must be at least 5 characters, a maximum of 30 characters, and must have at least one number, one uppercase and one lowercase letter"
						   data-error="Password must be at least 5 characters, a maximum of 30 charcters, and must have at least one number, one uppercase and one lowercase letter"
						   required>
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
					<div class="help-block with-errors"></div>
				</div>

				<div class="form-group has-feedback">
					<label for="confirm_pwd">Confirm Password:</label>
					<input type="password" id="confirm_pwd" data-match="#pwd" class="form-control "
						   placeholder="Confirm Password"  data-match-error="Password must match" required>
					<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
					<div class="help-block with-errors"></div>
				</div>

				<button class="btn btn-lg btn-primary btn-block up" type="submit">
					Create
				</button>


			</form>
		</div>


	</div>
</div>

</body>
<script>
    $('#signup').validator();
</script>
</html>