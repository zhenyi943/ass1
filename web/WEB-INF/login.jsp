<%-- 
    Document   : login
    Created on : Oct 6, 2019, 7:58:36 PM
    Author     : 797494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Home Inventory</h1>
        <br>
        <h1>Login</h1>
        <br>
        <form action="login" method="post">
        <label>Username: </label>&nbsp;<input type="text" size="20" name="username" >
        <br>
        <label>Password: </label>&nbsp;<input type="text" size="20" name="password" >
        <br>
        <input type="submit" value="Submit">
        <br>
        <label></label>&nbsp;&nbsp;<span>${message}</span>
        </form>
    </body>
</html>
