<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please provide your account information</h1>
        <form action="ShoppingServlet" method="post">
            <p>Name: <input type="text" name="name"></p>
            <p>VISA Card Number: <input type="text" name="card"></p>
            <p>Address: <input type="text" name="address"></p>
            <p><input type="submit"></p>
        </form>
    </body>
</html>