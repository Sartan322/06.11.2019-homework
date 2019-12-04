<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 18.11.2019
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post">
    <p>
        <label>Email: </label>
        <input type="email" placeholder="User@gmail.com" name="email" required="required"/>
    <p>
        <label>Password: </label>
        <input type="password" name="password" min="6" max="30" required="required" placeholder="password"/>
    <p>
        <label>First name </label>
        <input type="text" name="name" placeholder="Enter your name" required="required">
    <p>
        <label>Surname</label>
        <input type="text" name="selfName" placeholder="Enter your name" required="required">
    <p>
        <label>Information about you</label>
    <br>
        <style>
            textarea {
                width: 500px;
                height: 200px;
                resize: none;
            }
        </style>
        <textarea name="information" placeholder="(write something about yourself)" maxlength="200"
                  required="required"></textarea>
    <p>
        <label>Выберите аватарку</label>
    <div><input name="avatar" type="radio" value="Rik">Rik
        <input name="avatar" type="radio" value="Morty">Morty
        <input name="avatar" type="radio" value="Sammer">Sammer
        <input name="avatar" type="radio" value="Bet">Bet
        <input name="avatar" type="radio" value="Jerry">Jerry
        <input name="avatar" type="radio" value="Joposranchik">Joposranchik
    </div>
    <p>
        <img src="https://www.parazitakusok.ru/images/item/3702/bez_imeni-1.jpg" width="150" height="150">
        <img src="https://avatanplus.com/files/resources/original/583a1b3013283158a2fa33ce.png" width="150" height="150">
        <img src="http://pm1.narvii.com/6557/b7c31a607e416212338ec0bbd70cb19f061c267a_00.jpg" width="150" height="150">
        <img src="https://sun9-60.userapi.com/c824503/v824503218/5985/xxFrVRWStL8.jpg?ava=1" width="150" height="150">
        <img src="https://citaty.info/files/characters/154020.jpg" width="150" height="150">
        <img src="https://i.pinimg.com/736x/60/e4/e5/60e4e50339345f4fb8144a1d0902883b.jpg" width="150" height="150">
    <p>
        <label>Выберите город</label>
    <div>
        <input name="city" type="radio" value="1">Kazan
        <input name="city" type="radio" value="2">Naberezhnye Chelny
        <input name="city" type="radio" value="3">Almet'evsk</div>
    </div>
    <p>
        <input type="date" name="bday">
    <p>
        <input type="submit" name="button" value="pressed">

<%--
    <h2>Hello, ${username}</h2>--%>
</form>
</body>
</html>
