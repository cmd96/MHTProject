<%@ page import="rifo.*,java.util.*"%>
<%@ page import="Utilerias.*"%>
<%@page import="Creat_Projects.Create_Project" %>
<%@page import="Project.db.handling.ProjectDBHandling" %>
<%@ page import="javax.swing.text.Document" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>
<%@ page import="com.test.ProjectListController" %>

<jsp:useBean id="user" class="com.test.User" scope="request" />
<jsp:useBean id="project" class="com.test.Products" scope="request" />
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
    <link rel="stylesheet" type="text/css" href="projects.css">
    <script src="https://kit.fontawesome.com/6c7c7be256.js"></script>
    <title>Projects</title>
</head>
<script>

    function insterdDataJS() {
        var myModal = document.getElementById('myModal');
        myModal.style.display = "none";
        loadProjects();
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
        var btnID;
        for (i = 0; i < projectNamesArray.length-1; i++) {
            btnID = "setProjectBtn"+projectIDsArray[i];

            var newChild='<div class="project"><input type="submit" id="projectList" name="inputProjectName" readonly="readonly" value="'+projectNamesArray[i]+'"\ onclick="submit_projectName()"><a id="setProjectBtn" href="#popupEditProject"><div class="editProject" id="'+btnID+'" onclick="setValue(this.id)"><i class="far" id="editproductBtnID">&#xf044;</i></div></a></div>'
            parent.insertAdjacentHTML('beforeend', newChild);
        }
    }

    function goToProject(name) {
        var queryString = "?para1=" + name;
        document.getElementById("frm1").submit();
    }

   // var PROJECT_NAME;
    function getSelectedProject(){
        alert(BLAL)
        return BLABLA;
    }

    function myFunc()
    {
        var myModal = document.getElementById('editDataWrapperID');
        myModal.style.display = "block";
        var active = myModal;//element.querySelector('#editDataWrapperID');
        var prev = active.previousElementSibling.id;
        document.getElementById(prev).value = '############################';

        alert(prev);

    }

</script>
<script>
    function myFunction() {
        var r = confirm("Are you sure about that ?");
        if (r == true) {
            return 1;
        } else {
            return 2;
        }
    }
    function submit_projectName() {
        document.getElementById("formWrapper").submit();
    };
</script>
<body onload="loadProjects()">

<script>

    function  setValue(idProject) {
        var divAdapper = document.getElementById(idProject);
        document.getElementById("projectNameInputID").value = divAdapper.parentElement.previousElementSibling.value;

    }
</script>
<div>
    <div id="outlineID">
        <div id="userDetailsID">
            <div style="font-family: 'Font Awesome 5 Free'; font-size: 25px; color: #2093B4; float: right; margin: 25px"></div>
            <div id="userDetID"><%= user.getUserName() %></div>
        </div>
        <a href="projects.jsp"><button id="projectBtnID" class="outlineBtn"  style="font-family: Rubik">פרויקטים  </button></a>
        <button id="projectBtnID" class="outlineBtn"  style="font-family: Rubik">היסטוריה</button>
        <button id="projectBtnID" class="outlineBtn"  style="font-family: Rubik">הגדרות</button>
        <a href="reports.jsp"><button id="projectBtnID" class="outlineBtn">דוחות</button></a>
    </div>
    <div id="projectDataID">
        <div id="projectOutlineID">
            <span id="GFG_Span"></span>
            <div id="projectNameID" onclick="moveToProjects()">פרויקטים</div>
            <button class="projectBtn" onclick="AddProjects()"><a id="addProjectBtn" href="#popup1">+</a></button>
        </div>
        <form action="projectListServlet"  id="formWrapper" method="post">
            <div id="dynamicData"></div>
        </form>



        <div id="myBtn" onclick="myFunc()">Open Modal</div>
        <input  id="projectList2" name="inputProjectName" readonly="readonly" value="TEST project ******">
        <div id="editDataWrapperID" style="display: none">
                <form action="addBtnServlet" method="post">
                    <div class="popup">
                        <a class="close" href="#">&times;</a>
                        <h2>הוסף פרויקט</h2>

                        <div class="content">
                            <label ><b>שם פרויקט</b></label>
                            <input type="text" placeholder="שם פרויקט" name="projName" required>
                            <label ><b>שם לקוח</b></label>
                            <input type="text" placeholder="שם לקוח" name="customerName" required>
                        </div>
                        <button type="submit" value="Login"  onclick="insterdDataJS()" name="addProjectButton" id="submitDataID" >אישור</button>
                    </div>

                </form>
           </div>

        <%--test --%>
        <div class="project">
            <input type="submit" id="projectList" name="inputProjectName" readonly="readonly" value="dd" onclick="submit_projectName()">
            <a id="setProjectBtn55" href="#popupEditProject" >
                <div onclick="setValue(this.id)" class="editProject" id="setProjectBtn555">
                    <i class="far" id="editproductBtnID" aria-hidden="true"></i>
            </div>
            </a>
        </div>


<div class="s-layout">
<main class="s-layout__content">
<form id="popup1" class="overlay" action="addBtnServlet" method="post">
    <div class="popup">
        <a class="close" href="#">&times;</a>
        <h2>הוסף פרויקט</h2>

        <div class="content">
            <label ><b>שם פרויקט</b></label>
            <input type="text" placeholder="שם פרויקט" name="projName" required>
            <label ><b>שם לקוח</b></label>
            <input type="text" placeholder="שם לקוח" name="customerName" required>
        </div>
        <button type="submit" value="Login"  onclick="insterdDataJS()" name="addProjectButton" id="submitID" >אישור</button>
    </div>

</form>

</main>
</div>
<div class="s-layout">
    <main class="s-layout__content" onload="getProjectSelected()">
        <form id="popupEditProject" class="overlay" action="addBtnServlet" method="post">
            <div class="popup">
                <a class="close" href="#">&times;</a>
                <h2>עריכת פרויקט</h2>

                <div class="content">
                    <label><b>שם פרויקט</b></label>
                    <input type="text" value=getProjectSelected()  id="projectNameInputID" name="projName" >
                    <label ><b>שם לקוח</b></label>
                    <input type="text" value="שם לקוח" name="customerName" required>
                </div>
                <button type="submit" value="Login"  onclick="updateDataJS()" name="setProjectButton" id="setProjectBtnID" >אישור</button>
            </div>
        </form>
    </main>
</div>


</body>
</html>
