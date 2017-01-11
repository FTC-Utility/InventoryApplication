
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lost Password Reset</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.8/validator.min.js"></script>

    <link rel="stylesheet" href="resources/stylesheets/dark-theme.css">
</head>
<body>
<div id="lost-password" class="container">
    <div class="row">
        <div class="col-xs-12 col-md-6 col-md-offset-3 account-wall clearfix">

            <h1 class="text-center login-title">Lost Password Reset</h1>

            <form action="sendNow" id="sendNow" method="post" class="form-signin">

                <div class="form-group">
                    <label for="Email">Email Address:</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="example@mail.com"
                           pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                           title="Must have the pattern similar to 'example@mail.com' pattern."
                           data-error="Must have the pattern similar to 'example@mail.com' pattern."
                           autofocus required>
                    <div class="help-block with-errors"></div>
                </div>
                <br/>

                <button class="btn btn-lg btn-primary btn-block float-xs-right" type="submit" placeholder="SendNow">
                    Send Now
                </button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $('#sendNow').validator();
</script>
</html>