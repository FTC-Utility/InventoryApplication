<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
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

            <h1 class="text-center login-title">Login</h1>

            <form action="signIn" method="post" class="form-signin">
                <a href="newUserRegisterHere"><b>New User? Register Here</b></a>
                <br/><br/>

                <a href="lostPassword"><b>Lost Password?</b></a>
                <br/><br/>

                <label for="Email">Email Address:</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="Email" autofocus required>
                <br/>

                <label for="pwd">Password:</label>
                <input type="password" minlength="5" maxlength="30" id="pwd" name="pwd" class="form-control" placeholder="Password">
                <br/>

                <div class="checkbox">
                   <label for="rememberMe" id="labelRememberMe">
                   <input type="checkbox" id="rememberMe" name="rememberMe"><b>Remember Me</b>
                   </label>
                </div>
                <br/>

                <button class="btn btn-lg btn-primary btn-block float-xs-right" type="submit" placeholder="RememberMe">
                    Sign In
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
