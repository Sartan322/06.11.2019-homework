<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 30.11.2019
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainPage</title>
</head>
<body>
<form method="get">

</form>
<form method="post">
    <label>Войти</label>
    <br>
    <input type="email" placeholder="User@gmail.com" name="email" />
    <br>
    <input type="password" name="password" min="6" max="30" placeholder="password"/>
    <br>
    <input type="submit" name="button" value="Login">
    <input type="submit" name="button" value="Registration">
    <br>
    <br>
    <h1>${error}</h1>
</form>

</body>
</html>