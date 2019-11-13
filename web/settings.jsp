<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 12/11/2019
  Time: 00:53
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<jsp:useBean id="project" class="com.test.Products" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="settings.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <title>הגדרות</title>
</head>
<body>
<div>
    <div id="outlineID">
        <div id="userDetailsID">
            <%--<img src="student.png" style="float: right; margin: 25px">--%>
            <div style="font-family: 'Font Awesome 5 Free'; font-size: 25px; color: #2093B4; float: right; margin: 25px"></div>
            <div id="userDetID"><%= user.getUserName() %></div>
        </div>
        <a href="projects.jsp"><button id="projectBtnID" class="outlineBtn"  style="font-family: Rubik">פרויקטים</button></a>
        <a href="history.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">היסטוריה</button></a>
        <a href="settings.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">הגדרות</button></a>
        <a href="reportsList.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">דוחות</button></a>
    </div>
    <div>
        <div class="settingsButtons">
            <a href="reportYearTable.jsp"><button id="projectBtnID" class="settingBtn">הכנס משתמש חדש</button></a>
            <a href="sumTable.jsp"><button id="projectBtnID" class="settingBtn">ערוך משתמש קיים</button></a>
        </div>
    </div>
</div>

</body>
</html>
