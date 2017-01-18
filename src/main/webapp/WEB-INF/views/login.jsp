<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="/resources/stylesheets/dark-theme.css">
</head>
<body>
<div id="login-page" class="container">
    <div class="row">
        <div class="col-xs-12 col-md-6 col-md-offset-3 account-wall clearfix">

            <h1 class="text-center login-title">Login</h1>

            <form action="login" method="POST" class="form-signin">
                <a href="newUserRegisterHere"><b>New User? Register Here</b></a>
                <br/><br/>

                <a href="lostPassword"><b>Lost Password?</b></a>
                <br/><br/>

                <div class="form-group">
                   <label for="Email">Email Address:</label>
                   <input id="email" name="email" class="form-control" placeholder="example@mail.com"
                       <%--pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$"--%>
                          title="Must have the pattern similar to 'example@mail.com' pattern."
                          data-error="Must have the pattern similar to 'example@mail.com' pattern."
                       autofocus required>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <div class="form-group has-feedback">
                   <label for="pwd">Password:</label>
                   <input type="password" id="pwd" name="password" class="form-control" placeholder="Password"
                          <%--pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" data-minlength="5" maxlength="30"--%>
                          title="Password must be at least 5 characters, maximum of 30 characters, and must have at least one number, one uppercase and one lowercase letter"
                          data-error="Password must be at least 5 characters, maximum of 30 characters, and must have at least one number, one uppercase and one lowercase letter" required>
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <div class="checkbox">
                   <label for="rememberMe" id="labelRememberMe">
                   <input type="checkbox" id="rememberMe" name="remember-me"><b>Remember Me</b>
                   </label>
                </div>
                <br/>

                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                <button class="btn btn-lg btn-primary btn-block float-xs-right" type="submit" placeholder="RememberMe">
                    Sign In
                </button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
