<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 05.12.2019
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<form method="get">
    <label>Старое имя: ${name}</label>
    <br>
    <label>Старая фамилия: ${surname}</label>
    <br>
    <label>Старая информация: ${information}</label>
</form>
<br>
    <form method="post">
        <label>Новое имя:</label>
        <input type="text" name="newname" required="required">
        <br>
        <label>Новая фамилия:</label>
        <input type="text" name="newsurname" required="required">
        <br>
        <label>Новая информация:</label>
        <input type="text" name="newinform" required="required" style="width: 500px; height: 300px; resize: none">
        <input type="submit" name="button" value="Save">
    </form>
</body>
</html>
