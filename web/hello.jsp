<%--suppress ALL --%>
<%@ page import="rifo.*,java.util.*"%>
<%@ page import="Utilerias.*"%>
<%@ page import="com.test.LoginController" %>
<%@page import="Creat_Projects.Create_Project" %>
<%@page import="Project.db.handling.ProjectDBHandling" %>
<%--<%@ page import="Project.db.handling.ProjectDBHandling" %>--%>
<%@ page import="com.test.AddProject" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page import="com.test.User" %>

<%--
  Created by IntelliJ IDEA.
  User: mhtuser
  Date: 04/02/2019
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%--<jsp:useBean id="project" class="Creat_Projects.Create_Project" scope="request" />--%>
<%--<jsp:useBean id="project" class="Project.db.handling.ProjectDBHandling" scope="request" />--%>
<jsp:useBean id="project" class="com.test.Hello" scope="request" />
<html>
<head>
    <script src="hello.js"></script>
    <%--<script src="jquery-3.4.1.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="hello.css">
    <meta charset="ISO-8859-1">
    <title>Hello</title>
    <%--suppress CssInvalidPropertyValue --%>
    <style>

    </style>
</head>

<body>
<div id="aside">
    <div id="user">
        <img id="userImg" src="">
        <span id="userName">שם משתמש</span>
    </div>
    <div id="history">
        <span id="header">היסטוריה</span>
        <div id="content">
            <div id="historyItem"></div>
        </div>
    </div>
</div>
<div id="main">
    <div id="top">
        <div id="project">
            <label id="header">בחר פרויקט</label>
            <select id="selectProject" name="selectProject">
                <option id="projectItem" selected></option>
            </select>
        </div>
    </div>
    <div id="projects">
        <div id="projectItem">
            <div id="products">
                <div id="productItem">
                    <span id="productName">שם תוצר</span>
                    <span id="productResponsibleWriter">שם כתב אחראי</span>
                    <div id="milestons">
                        <div id="milestonItem">
                            <span id="milestonName"></span>
                            <span id="milestonToDoDate"></span>
                            <div id="milestonButtons">
                                <button id="confirmMilestonBtn"></button>
                                <button id="editMilestonBtn"></button>
                                <button id="detailsMilestonBtn"></button>
                            </div>
                        </div>
                        <a href="#popup3">
                        <button id="addMilestonBtn"></button>
                        </a>
                    </div>
                    <div id="prodectButtons">
                        <button id="confirmProductBtn"></button>
                        <button id="editProductBtn"></button>
                        <button id="detailsProductBtn"></button>
                    </div>
                </div>
                <a href="#popup2" >
                    <button id="addProductBtn" ></button>
                </a>
            </div>
        </div>
        <a  href="#popup1">
            <button id="addProjectBtn"></button>
        </a>
    </div>
</div>

<div class="s-layout">
    <main class="s-layout__content">
        <form id="popup1" class="overlay" action="User" >
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2>הוסף פרויקט</h2>

                <div class="content">
                    <label for="projName"><b>שם פרויקט</b></label>
                    <input type="text" placeholder="שם פרויקט" name="projName" required>
                </div>
                <button type="submit" value="Login" >אישור</button>
            </div>
        </form>

        <form id="popup2" class="overlay">
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2>הוסף תוצר</h2>

                <div class="content">
                    <label for="projName"><b>שם פרויקט</b></label>
                    <input type="text" placeholder="שם פרויקט" name="projectName" required>

                    <label for="productName"><b>שם תוצר</b></label>
                    <input type="text" placeholder="שם תוצר" name="productName" required>
                </div>
                <button type="submit" value="Login">אישור</button>

            </div>
        </form>

        <form id="popup3" class="overlay">
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2>הוסף אבן דרך</h2>

                <div class="content">
                    <label for="projName"><b>שם פרויקט</b></label>
                    <input type="text" placeholder="שם פרויקט" name="projectName" required>

                    <label for="productName"><b>שם תוצר</b></label>
                    <input type="text" placeholder="שם תוצר" name="productName" required>

                    <label for="mailstonName"><b>שם אבן דרך</b></label>
                    <input type="text" placeholder="שם אבן דרך" name="mailstonName" required>

                    <label for="description"><b>תיאור</b></label>
                    <input type="text" placeholder="תיאור" name="description" required>
                </div>
                <button type="submit" value="Login">אישור</button>

            </div>
        </form>
        <form id="popup4" class="overlay"  >
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2> פרויקט</h2>

                <div class="content">
                    <label for="projName"><b>שם פרויקט</b></label>
                    <input type="text" value="<%= project.getProjectsNames() %>">
                    <%--<%= request.getParameter("getProjectsNames") %>--%>
                </div>
                <button type="submit" value="Login" >אישור</button>
            </div>
        </form>
    </main>
</div>









<%--<div class="s-layout">--%>
<%--<!-- Sidebar -->--%>
<%--<div class="s-layout__sidebar">--%>
<%--<a class="s-sidebar__trigger" href="#0">--%>
<%--<i class="fa fa-bars"></i>--%>
<%--</a>--%>

<%--<nav class="s-sidebar__nav">--%>
<%--<ul>--%>
<%--<li style="background-color: #fefefe">--%>
<%--<img src="https://image.flaticon.com/icons/svg/1000/1000946.svg" alt="Avatar" class="avatar">--%>
<%--</li>--%>
<%--<li>--%>
<%--<a class="s-sidebar__nav-link" href="#0">--%>
<%--<i class="fa fa-home"></i><em>Home</em>--%>
<%--</a>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a class="s-sidebar__nav-link" href="#0">--%>
<%--<i class="fa fa-user"></i><em>My Profile</em>--%>
<%--</a>--%>
<%--</li>--%>
<%--<li>--%>
<%--<a class="s-sidebar__nav-link" href="#0">--%>
<%--<i class="fa fa-camera" ></i><em>History</em>--%>
<%--</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</nav>--%>
<%--</div>--%>

<%--<!-- Content -->--%>
<%--<main class="s-layout__content">--%>

<%--<div class="AddBtn">--%>
<%--<a class="button" href="#popup1">הוסף פרויקט</a>--%>
<%--</div>--%>
<%--<div class="AddBtn">--%>
<%--<a class="button" href="#popup2">הוסף תוצר</a>--%>
<%--</div>--%>
<%--<div class="AddBtn">--%>
<%--<a class="button" href="#popup3">הוסף אבן דרך</a>--%>
<%--</div>--%>

<%--<div class="AddBtn">--%>
<%--<a class="button" href="#popup4">הצג פרויקטים</a>--%>
<%--</div>--%>


<%--</main>--%>
<%--</div>--%>
</body>
</html>
