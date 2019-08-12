<%@ page import="rifo.*,java.util.*"%>
<%@ page import="Utilerias.*"%>
<%@page import="Creat_Projects.Create_Project" %>
<%@page import="Project.db.handling.ProjectDBHandling" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<jsp:useBean id="project" class="com.test.Hello" scope="request" />
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 06/08/2019
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="Projects.css">
    <title></title>
</head>
<script>
    function AddProjects() {
        // var parent = document.getElementById('dynamicData');
        // // var newChild = '<div class="productsID"><div class="productsDataID"><div class="product"><div class="productName">כנף</div><div class="productComment">שם תוצר</div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">מתווה</div><div class="milestonestatus"><i class="far fa-check-circle"></i></div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">טיוטה</div><div class="milestonestatus"><i class="far fa-check-circle"></i></div></div><div class="milestone"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">CR</div><div class="milestonestatus"><i class="fas fa-sync-alt"></i></div></div><div class="milestoneEnd"><div class="milestoneDateDiv">6/8/19</div><div class="milestoneComment">ת.ה. סופי</div><div class="milestonestatus"><i class="fas fa-sync-alt"></i></div></div></div ><button class="productBtn"><i class="far" id="editproductBtnID">&#xf044;</i></button></div > ';
        // var newChild = ''
        // parent.insertAdjacentHTML('beforeend', newChild);
    }
    function loadProjects() {
        <%
        int j=0;
        int h=0;
        List<userProject> userProjectList=user.getUserProjectList();
        String projectsNames="";
        String projectsIDs="";
        for (int i=0;i<userProjectList.size();i++){
            projectsNames+=userProjectList.get(i).getProjectMame()+" ";
            projectsIDs+=userProjectList.get(i).getProjectID()+" ";
        }
        %>
        var projectNamesList='<%=projectsNames%>';
        var projectIDsList='<%=projectsIDs%>';
        var projectNamesArray=projectNamesList.split(" ");
        var projectIDsArray=projectIDsList.split(" ");
        var parent = document.getElementById('dynamicData');
        var i;
        for (i = 0; i < projectNamesArray.length-1; i++) {
            var newChild='<div class="project"><div onclick= "goToProject(document.getElementById(\'project'+i+'\').innerHTML)" id="project'+i+'" class="projectName">'+projectNamesArray[i]+'</div><div class="editProject" style="font-family: \'Font Awesome 5 Free\';"></div></div>'
            parent.insertAdjacentHTML('beforeend', newChild);
        }
    }
    function goToProject(name) {
        var queryString = "?para1=" + name;
        window.location.href = "hello.jsp" + queryString;
        // window.location= "hello.jsp";

    }
</script>
<body onload="loadProjects()">
<div>
    <div id="outlineID">
        <div id="userDetailsID">
            <%--<img id="userimgID" src="Picture1.gif">--%>
            <div style="font-family: 'Font Awesome 5 Free'; font-size: 25px; color: #2093B4; float: right; margin: 25px"></div>
            <div id="userDetID"><%= user.getUserName() %></div>
        </div>
        <button id="projectBtnID" class="outlineBtn" style="font-family: Rubik">פרויקטים</button>
        <button id="projectBtnID" class="outlineBtn">היסטוריה</button>
        <button id="projectBtnID" class="outlineBtn">הגדרות</button>
        <button id="projectBtnID" class="outlineBtn">דוחות</button>
    </div>
    <div id="projectDataID">
        <div id="projectOutlineID">
            <span id="GFG_Span"></span>
            <%--<span><%=user.getUserProjects()%></span>--%>
            <div id="projectNameID">פרויקטים</div>
            <button class="projecBtn" onclick="AddProjects()">+</button>
        </div>
        <div id="dynamicData">
            <%--<div onclick= "goToProject(document.getElementById('project'+i).innerHTML)" id="project1" class="projectName">split[i]</div>--%>
        </div>
    </div>
</div>
</body>
</html>
