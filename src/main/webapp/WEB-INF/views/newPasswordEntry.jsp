<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>New Password Entry</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4 col-md-offset-4 account-wall clearfix">

            <h1 class="text-center login-title">New Password Entry</h1>

            <form action="setPassword" method="post" class="form-signin">

                <label for="pin">PIN:</label>
                <input type="number" minlength="4" maxlength="10" id="pin" name="pin" class="form-control" placeholder="PIN">
                <br/>

                <label for="pwd">Password:</label>
                <input type="password" minlength="5" maxlength="30" id="pwd" name="pwd" class="form-control" placeholder="Password">
                <br/>

                <label for="pwd">Confirm Password:</label>
                <input type="password" minlength="5" maxlength="30" id="confirmPwd" name="confirmPwd" class="form-control" placeholder="ConfirmPassword">
                <br/>

                <button class="btn btn-lg btn-primary btn-block float-xs-right" type="submit" placeholder="SetPassword">
                    Set Password
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
