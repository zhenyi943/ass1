<%-- 
    Document   : admin
    Created on : Oct 6, 2019, 8:10:22 PM
    Author     : 797494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <form action="admin" method="get">
            <h1>Home Inventory Admin</h1>
            <br>
            <h1>Admin Summary</h1>
            <br>
            <label>Total value for all users: </label>&nbsp;&nbsp;<span>${AdminMessage}</span>
            <label>Most expensive item is </label>&nbsp;<span>${who}</span>
            <br>
        </form>
            <a href="login?logout">Log out</a>
    </body>
</html>
