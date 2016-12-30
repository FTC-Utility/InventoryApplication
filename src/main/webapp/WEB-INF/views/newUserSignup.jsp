<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>New User Signup</title>
</head>
<body>
<center style="margin-top: 150px">
    <!-- The "action" value below will have to change once Create functionality is implemented.
         For now, the Create button will simply go back to the "New User Signup" page.
      -->
    <form action="newUserSignup" method="post">
        <table>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" /> </td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" /> </td>
            </tr>
            <tr>
                <td>Confirm Password: </td>
                <td><input type="password" name="confirmPassword" /> </td>
            </tr>
        </table>
        <input value="Create" type="submit"/>
    </form>
</center>
</body>
</html>
