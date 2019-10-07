<%-- 
    Document   : inventory
    Created on : Oct 6, 2019, 8:10:47 PM
    Author     : 797494
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <form action="inventory" method="post">
        <h1><h1>Home Inventory for ${userinv}</h1></h1>
        <br>
            <h1>Add Item</h1>
            <br>
            <label>Category: </label>
            <select name="Category">
                    <option value="bedroom">bedroom</option>
                    <option value="garage">garage</option>
                    <option value="kitchen">kitchen</option>
                    <option value="living">living</option>
            </select>
            <br>
            <label>Item Name: </label>&nbsp;<input type="text" size="20" name="item">
            <br>
            <label>Price: </label>&nbsp;<input type="text" size="20" name="price">
            <br>
            <input type="submit" value="Add">
            <br>
            <span>${message}</span>
            <br>
            <label>Total value in inventory: </label>&nbsp;&nbsp;<span>${total}</span>
            <br>
        </form>
            <a href="login?logout">Logout</a>
    </body>
</html>
