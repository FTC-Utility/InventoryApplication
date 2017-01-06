<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>New Password Entry</title>
    <meta charset="utf-8">
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
        <div class="col-xs-12 col-md-4 col-md-offset-4 account-wall clearfix">

            <h1 class="text-center login-title">New Password Entry</h1>

            <form action="setPassword" id="setPassword" method="post" class="form-signin">

                <div class="form-group has-feedback">
                   <label for="pin">PIN:</label>
                   <input type="text" id="pin" name="pin" class="form-control" placeholder="PIN"
                          pattern="^[0-9]*$" data-minlength="6" minlength="6" maxlength="6"
                          title="PIN must be only numbers and be exactly 6 numbers."
                          data-error="PIN must be only numbers be exactly 6 numbers.">
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <div class="form-group has-feedback">
                   <label for="pwd">Password:</label>
                   <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password"
                          pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" data-minlength="5" maxlength="30"
                          title="Password must be at least 5 characters, maximum of 30 characters, and must have at least one number, one uppercase and one lowercase letter"
                          data-error="Password must be at least 5 characters, maximum of 30 characters, and must have at least one number, one uppercase and one lowercase letter" required>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <div class="form-group has-feedback">
                   <label for="pwd">Confirm Password:</label>
                   <input type="password" id="confirmPwd" name="confirmPwd" data-match="#pwd" class="form-control"
                          placeholder="Confirm Password" data-match-error="Password must match" required>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <input type="hidden" name="token" value="${tokenValue}">

                <button class="btn btn-lg btn-primary btn-block float-xs-right" type="submit" placeholder="SetPassword">
                    Set Password
                </button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $('#setPassword').validator();
</script>
</html>
