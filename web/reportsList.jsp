<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 07/11/2019
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="reportsList.css">
    <title>דוחות</title>
</head>
<body>
<div>
    <div id="outlineID">
        <div id="userDetailsID">
            <%--<img src="student.png" style="float: right; margin: 25px">--%>
            <div style="font-family: 'Font Awesome 5 Free'; font-size: 25px; color: #2093B4; float: right; margin: 25px"></div>
            <div id="userDetID"><%= user.getUserName() %></div>
        </div>
        <a href="projects.jsp"><button id="projectBtnID" class="outlineBtn"  style="font-family: Rubik">פרויקטים  </button></a>
        <a href="history.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">היסטוריה</button></a>
        <a href="settings.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">הגדרות</button></a>
        <a href="reportsList.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">דוחות</button></a>
    </div>
    <div class="reportsButtons">
        <a href="reportYearTable.jsp"><button id="projectBtnID" class="reportBtn">לוח תאריכים שנתי</button></a>
        <a href="sumTable.jsp"><button id="projectBtnID" class="reportBtn">טבלת סכומים</button></a>
        <a href="sumTable.jsp"><button id="projectBtnID" class="reportBtn">מעקב עובדים</button></a>
        <a href="sumTable.jsp"><button id="projectBtnID" class="reportBtn">תעקב תוצרים</button></a>
    </div>
</div>
</body>
</html>
