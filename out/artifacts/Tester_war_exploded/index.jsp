
<%@ page import="com.test.SQLConnection" %>
<%@ page import="com.test.LoginController" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="com.test.User" %>
<%--
  Created by IntelliJ IDEA.
  User: mhtuser
  Date: 04/02/2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <link rel="stylesheet" type="text/css" href="index.css">
  <meta charset="ISO-8859-1">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
  <title>Login</title>
</head>

<body>

<form class="mainForm" action="loginServlet" method="post">
  <%--<div class="imgcontainer">--%>
    <%--<img src="https://image.flaticon.com/icons/svg/1000/1000946.svg" alt="Avatar" class="avatar">--%>
  <%--</div>--%>
  <div class="container">
      <label class="title">היכנס</label>
    <input type="text" placeholder="הכנס שם משתמש" name="username" required>
      <label>שם משתמש</label>

    <input type="password" placeholder="הכנס סיסמה" name="password" required>
      <label>סיסמה</label>
    <button type="submit" value="Login">></button>

  </div>
</form>
</body>

</html>
