<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 08/11/2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="sumTable.css">
    <title>טבלת סכומים</title>
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
        <button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">היסטוריה</button>
        <button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">הגדרות</button>
        <a href="reportsList.jsp"><button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">דוחות</button></a>
    </div>
    <div class="data">

        <h2>טבלת סכומים</h2>
        <p>פה יהיה כתוב מה זה מציג בדיוק :)</p>

        <table>
            <tr>
                <th>תיאור</th>
                <th>סכום</th>
                <th>Points</th>
            </tr>
            <tr>
                <td>Peter</td>
                <td>Griffin</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>Lois</td>
                <td>Griffin</td>
                <td>$150</td>
            </tr>
            <tr>
                <td>Joe</td>
                <td>Swanson</td>
                <td>$300</td>
            </tr>
            <tr>
                <td>Cleveland</td>
                <td>Brown</td>
                <td>$250</td>
            </tr>
        </table>

    </div>
</div>
</body>
</html>
