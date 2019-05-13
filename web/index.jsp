<%@ page import="com.microsoft.ConnectionSQL" %>
<%--<%@ page import="com.microsoft.LoginController" %>--%>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="com.microsoft.User" %>
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
  <link rel="stylesheet" type="text/css" href="indexStylesheet.css">
  <meta charset="ISO-8859-1">
  <title>Login</title>
</head>
<body>

<%--<%=SQLConnection.getConnetion()%>--%>

<form class="modal-content animate" action="com.microsoft.LoginController" method="post">
  <div class="imgcontainer">
    <img src="https://image.flaticon.com/icons/svg/1000/1000946.svg" alt="Avatar" class="avatar">
  </div>
  <div class="container">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit" value="Login">Login</button>
  </div>
</form>

</body>
</html>



