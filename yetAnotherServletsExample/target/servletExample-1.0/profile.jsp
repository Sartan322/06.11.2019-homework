<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 04.12.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<form method="get">
    <h1>${name} ${surname}</h1>
    <p>${bday}</p>
    <p>${city}</p>
    <br>
    <img src="${avatar_url}" width="150" height="150">
    <br>
    <p>${information}</p>
</form>
<form method="post">
    <input type="submit" name="button" value="Delete">
    <input type="submit" name="button" value="Edit">
</form>
</body>
</html>
