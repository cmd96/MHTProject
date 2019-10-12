<%--suppress ALL --%>
<%@ page import="rifo.*,java.util.*"%>
<%@ page import="Utilerias.*"%>
<%@page import="Creat_Projects.Create_Project" %>
<%@page import="Project.db.handling.ProjectDBHandling" %>
<%--<%@ page import="Project.db.handling.ProjectDBHandling" %>--%>
<%@ page import="javax.swing.text.Document" %>
<%--
  Created by IntelliJ IDEA.
  User: mhtuser
  Date: 04/02/2019
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>

<%--<jsp:useBean id="project" class="Creat_Projects.Create_Project" scope="request" />--%>
<%--<jsp:useBean id="project" class="Project.db.handling.ProjectDBHandling" scope="request" />--%>
<%--<jsp:useBean id="addBtn" class="com.test.AddButtons" scope="request" />--%>



<jsp:useBean id="user" class="com.test.User" scope="request" />
<jsp:useBean id="project" class="com.test.Products" scope="request" />
<head>
    <link rel="stylesheet" type="text/css" href="products.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <title><%=Products.getCurrentProjectName()%> project</title>
</head>
<script>

    function selectOnChnageFunction()
    {
        var basic_flow_html ="<div>\n" +
            "                        <label>מתווה</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>טיוטה</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>CR</label>\n" +
            "                        <input type=\"date\">\n" +
            "                    </div>";
        var full_flow_html="<div>\n" +
            "                        <label>מתווה</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>טיוטה 1</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>טיוטה 2</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>CR</label>\n" +
            "                        <input type=\"date\">\n" +
            "                    </div>\n";
        var course_flow_html=" <div>\n" +
            "                        <label>סילבוס</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>הצגה</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>מבחן</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>קורס</label>\n" +
            "                        <input type=\"date\">\n" +
            "                        <label>תיקון מצגת</label>\n" +
            "                        <input type=\"date\">\n" +
            "                    </div>";
        var e = document.getElementById("selectFlowID");
        var strUser = e.options[e.selectedIndex].value;

        alert(strUser);
    }
    function getProjectName() {

        var queryString = decodeURIComponent(window.location.search);
        queryString = queryString.substring(1);
        var queries = queryString.split("=");
        for (var i = 0; i < queries.length; i++)
        {
            return queries[i];
        }
    }
    function setUpProducts()
    {
        var parent = document.getElementById('dynamicData');
        <%
        List<userProject> userProjectList = user.getUserProjectList();
        //get(0) prefera to specific project ...
        int i =0;
        for (userProject currentProject : userProjectList) {
            if(currentProject.getProjectMame().equals(Products.getCurrentProjectName()))
                {
                    System.out.println(i);
                    break;
                }
                i++;
        }
        List<ProjectProduct> ProductList = userProjectList.get(i).getProductList();
        String htmlDynamicCode = "";
        if(ProductList!= null)
        {
            for (ProjectProduct user_project : ProductList ) {
                System.out.println(user_project.getHtmlCode());
                htmlDynamicCode += user_project.getHtmlCode();
            }
        }
        %>
        var userProjectListJS='<%=htmlDynamicCode%>';
        parent.insertAdjacentHTML('beforeend', userProjectListJS);
        projectName();
    }

    function AddProducts() {
        var parent = document.getElementById('dynamicData');
        var newChild = '<div class="productsID"><div class="productsDataID"><div class="product"><div class="productName">כנף</div><div class="productComment">שם תוצר</div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">מתווה</div><div class="milestonestatus"><i class="far fa-check-circle"></i></div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">טיוטה</div><div class="milestonestatus"><i class="far fa-check-circle"></i></div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">CR</div><div class="milestonestatus"><i class="fas fa-sync-alt"></i></div></div><div class="milestoneEnd"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">ת.ה. סופי</div><div class="milestonestatus"><i class="fas fa-sync-alt"></i></div></div></div ><button class="productEditBtn"><i class="far" id="editproductBtnID">&#xf044;</i></button></div > ';
        parent.insertAdjacentHTML('beforeend', newChild);
    }

    function projectName() {

        var queryString = decodeURIComponent(window.location.search);
        queryString = queryString.substring(1);
        var queries = queryString.split("=");
        for (var i = 0; i < queries.length; i++)
        {
            document.getElementById("projectID").innerText = queries[i];
        }
    }

</script>

<body onload="setUpProducts()">
<div>
    <div id="outlineID">
        <div id="userDetailsID">
            <%--<img src="student.png" style="float: right; margin: 25px">--%>
            <div style="font-family: 'Font Awesome 5 Free'; font-size: 25px; color: #2093B4; float: right; margin: 25px"></div>
            <div id="userDetID"><%= user.getUserName() %></div>
        </div>
        <button id="projectBtnID" class="outlineBtn">פרויקטים</button>
        <button id="projectBtnID" class="outlineBtn">היסטוריה</button>
        <button id="projectBtnID" class="outlineBtn">הגדרות</button>
        <button id="projectBtnID" class="outlineBtn">דוחות</button>
    </div>
    <div id="projectDataID">
        <div id="projectOutlineID">
            <span id="projectName" ><%=Products.getCurrentProjectName()%></span>
            <div id="projectID"></div>
            <a id="addProductBtn" href="#addProduct"><button onclick="AddProjects()">+</button></a>
            <%--<button class="productBtn" onclick="AddProducts()"><i class="material-icons" id="addProductBtnID">&#xe03b;</i></button>--%>
        </div>
            <div id="dynamicData">
            </div>
    </div>

</div>

<div class="s-layout">
    <main class="s-layout__content">
        <form id="addProduct" class="overlay" action="addBtnServlet" method="post">
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2>הוסף תוצר</h2>

                <div class="content">
                    <label ><b>שם תוצר</b></label>
                    <input type="text" placeholder="שם תוצר" name="productName" required>
                    <label ><b>שם כתב אחראי</b></label>
                    <input type="text" placeholder="שם כתב אחראי" name="responsibleWriterName" required>
                    <select name="select" onchange="selectOnChnageFunction()" id="selectFlowID">
                        <option>Short Folw</option>
                        <option>Full Flow</option>
                        <option>Course</option>
                    </select>
                    <div id="productMilstonesDataID">

                    </div>
                    <div>
                        <label>מתווה</label>
                        <input type="date">
                        <label>טיוטה</label>
                        <input type="date">
                        <label>CR</label>
                        <input type="date">
                    </div>
                    <div>
                        <label>מתווה</label>
                        <input type="date">
                        <label>טיוטה 1</label>
                        <input type="date">
                        <label>טיוטה 2</label>
                        <input type="date">
                        <label>CR</label>
                        <input type="date">
                    </div>

                    <div>
                        <label>סילבוס</label>
                        <input type="date">
                        <label>הצגה</label>
                        <input type="date">
                        <label>מבחן</label>
                        <input type="date">
                        <label>קורס</label>
                        <input type="date">
                        <label>תיקון מצגת</label>
                        <input type="date">
                    </div>

                </div>
                <button type="submit" value="Login" name="addProductButton" >אישור</button>
            </div>
        </form>

    </main>
</div>
</body>
</html>




















<%--<html>--%>
<%--<head>--%>
    <%--<script>--%>
        <%--function loadImage() {--%>
            <%--alert("ss "+data);--%>
    <%--//--%>
    <%--// var con= new SQLConnection.getCon();--%>
    <%--//         alert(con);--%>
    <%--// var stmt = con.createStatement();--%>
    <%--//         alert(stmt);--%>
    <%--// var SQL = "SELECT * FROM Projects";--%>
    <%--// var rs = stmt.executeQuery(SQL);--%>
    <%--// while (rs.next()) {--%>
    <%--//     alert(rs.getString("Name"));--%>
        <%--//var option = document.createElement("option");--%>
        <%--//option.text = rs.getString("Name");--%>
        <%--//x.add(option);--%>
            <%--//}--%>
        <%--}--%>
    <%--</script>--%>

    <%--&lt;%&ndash;<script src="jquery-3.4.1.js"></script>&ndash;%&gt;--%>
    <%--<link rel="stylesheet" type="text/css" href="products.css">--%>
    <%--<meta charset="ISO-8859-1">--%>
    <%--<title>Products</title>--%>
    <%--&lt;%&ndash;suppress CssInvalidPropertyValue &ndash;%&gt;--%>
    <%--<style>--%>

    <%--</style>--%>
<%--</head>--%>

<%--<body onload="loadImage()">--%>
<%--<div id="aside">--%>
    <%--<div id="user">--%>
        <%--<img id="userImg" src="">--%>
        <%--<span id="userName">שלום</span>--%>
        <%--<br/>--%>
        <%--<span type="text"><%= userNmae %></span>--%>
    <%--</div>--%>
    <%--<div id="history">--%>
        <%--<span id="header">היסטוריה</span>--%>
        <%--<div id="content">--%>
            <%--<div id="historyItem"></div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div id="main">--%>
    <%--<div id="top">--%>
        <%--<div id="project">--%>
            <%--<label id="header">בחר פרויקט</label>--%>
            <%--<select id="selectProject" name="selectProject">--%>
                <%--&lt;%&ndash;fillProjectsOptionList()&ndash;%&gt;--%>
                <%--<option id="projectItem" selected></option>--%>
            <%--</select>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="projects">--%>
        <%--<div id="projectItem">--%>
            <%--<div id="products" >--%>
                <%--<div id="productItem">--%>
                    <%--<div id="productName"><span>שם תוצר</span></div>--%>
                    <%--<div id="productResponsibleWriter"><span>שם כתב אחראי</span></div>--%>
                    <%--<div id="milestons">--%>
                        <%--<div id="milestonItem">--%>
                            <%--<div id="milestonName"><span>שם אבן דרך</span></div>--%>
                            <%--<div id="milestonToDoDate"><date>תאריך</date></div>--%>
                            <%--<div id="milestonButtons">--%>
                                <%--<button id="confirmMilestonBtn"></button>--%>
                                <%--<button id="editMilestonBtn"></button>--%>
                                <%--<button id="detailsMilestonBtn"></button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<a id="addMilestonBtn" href="#popup3">+</a>--%>
                    <%--</div>--%>
                    <%--<div id="prodectButtons">--%>
                        <%--<button id="confirmProductBtn"></button>--%>
                        <%--<button id="editProductBtn"></button>--%>
                        <%--<button id="detailsProductBtn"></button>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<a  id="addProductBtn" href="#popup2" >+</a>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<a   id="addProjectBtn" href="#popup1">+</a>--%>
    <%--</div>--%>
<%--</div>--%>

<%--<div class="s-layout">--%>
    <%--<main class="s-layout__content">--%>
        <%--<form id="popup1" class="overlay" action="addBtnServlet" method="post">--%>
            <%--<div class="popup">--%>
                <%--<a class="close" href="#">&times;</a>--%>
                <%--<h2>הוסף פרויקט</h2>--%>

                <%--<div class="content">--%>
                    <%--<label for="projName"><b>שם פרויקט</b></label>--%>
                    <%--<input type="text" placeholder="שם פרויקט" name="projName" required>--%>
                    <%--<label for="projName"><b>שם לקוח</b></label>--%>
                    <%--<input type="text" placeholder="שם לקוח" name="customerName" required>--%>
                <%--</div>--%>
                <%--<button type="submit" value="Login" name="addProjectButton" >אישור</button>--%>
            <%--</div>--%>
        <%--</form>--%>

        <%--<form id="popup2" class="overlay" action="addBtnServlet" method="post">--%>
            <%--<div class="popup">--%>
                <%--<a class="close" href="#">&times;</a>--%>
                <%--<h2>הוסף תוצר</h2>--%>

                <%--<div class="content">--%>
                    <%--<label for="productName"><b>שם תוצר</b></label>--%>
                    <%--<input type="text" placeholder="שם תוצר" name="productName" required>--%>
                    <%--<label for="productName"><b>שם כתב אחראי</b></label>--%>
                    <%--<input type="text" placeholder="שם כתב אחראי" name="responsiblewriterName" required>--%>
                <%--</div>--%>
                <%--<button type="submit" value="Login" name="addProductButton">אישור</button>--%>

            <%--</div>--%>
        <%--</form>--%>

        <%--<form id="popup3" class="overlay" action="addBtnServlet" method="post">--%>
            <%--<div class="popup">--%>
                <%--<a class="close" href="#">&times;</a>--%>
                <%--<h2>הוסף אבן דרך</h2>--%>

                <%--<div class="content">--%>
                    <%--<label for="mailstonName"><b>שם אבן דרך</b></label>--%>
                    <%--<input type="text" placeholder="שם אבן דרך" name="mailstonName" required>--%>

                    <%--<label for="description"><b>תיאור</b></label>--%>
                    <%--<input type="text" placeholder="תיאור" name="description" required>--%>
                <%--</div>--%>
                <%--<button type="submit" value="Login" name="addMilestonButton">אישור</button>--%>

            <%--</div>--%>
        <%--</form>--%>
        <%--<form id="popup4" class="overlay"  >--%>
            <%--<div class="popup">--%>
                <%--<a class="close" href="#">&times;</a>--%>
                <%--<h2> פרויקט</h2>--%>

                <%--<div class="content">--%>
                    <%--<label for="projName"><b>שם פרויקט</b></label>--%>
                    <%--&lt;%&ndash;<input type="text" value="<%= project.getProjectsNames() %>">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<%= request.getParameter("getProjectsNames") %>&ndash;%&gt;--%>
                <%--</div>--%>
                <%--<button type="submit" value="Login" >אישור</button>--%>
            <%--</div>--%>
        <%--</form>--%>
    <%--</main>--%>
<%--</div>--%>









<%--&lt;%&ndash;<div class="s-layout">&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- Sidebar -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="s-layout__sidebar">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="s-sidebar__trigger" href="#0">&ndash;%&gt;--%>
<%--&lt;%&ndash;<i class="fa fa-bars"></i>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>

<%--&lt;%&ndash;<nav class="s-sidebar__nav">&ndash;%&gt;--%>
<%--&lt;%&ndash;<ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li style="background-color: #fefefe">&ndash;%&gt;--%>
<%--&lt;%&ndash;<img src="https://image.flaticon.com/icons/svg/1000/1000946.svg" alt="Avatar" class="avatar">&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="s-sidebar__nav-link" href="#0">&ndash;%&gt;--%>
<%--&lt;%&ndash;<i class="fa fa-home"></i><em>Home</em>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="s-sidebar__nav-link" href="#0">&ndash;%&gt;--%>
<%--&lt;%&ndash;<i class="fa fa-user"></i><em>My Profile</em>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<li>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="s-sidebar__nav-link" href="#0">&ndash;%&gt;--%>
<%--&lt;%&ndash;<i class="fa fa-camera" ></i><em>History</em>&ndash;%&gt;--%>
<%--&lt;%&ndash;</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</li>&ndash;%&gt;--%>
<%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
<%--&lt;%&ndash;</nav>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- Content -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<main class="s-layout__content">&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="AddBtn">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="button" href="#popup1">הוסף פרויקט</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="AddBtn">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="button" href="#popup2">הוסף תוצר</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="AddBtn">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="button" href="#popup3">הוסף אבן דרך</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<div class="AddBtn">&ndash;%&gt;--%>
<%--&lt;%&ndash;<a class="button" href="#popup4">הצג פרויקטים</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>


<%--&lt;%&ndash;</main>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>
