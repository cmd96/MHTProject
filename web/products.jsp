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
        var outlineHtmlCode ="<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">מתווה</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"outlineMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"outlineMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"outlineMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"outlineMilestoneDescriptionName\" >\n" +
            "</fieldset>";
        var draftHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">טיוטה</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"draftMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"draftMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"draftMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"draftMilestoneDescriptionName\" >\n" +
            "</fieldset>";
        var CRHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">CR</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"CRMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"CRMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"CRMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"CRMilestoneDescriptionName\" >\n" +
            "</fieldset>";
        var draft_1HtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">טיוטה 1</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"draft_1_MilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"draft_1_MilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"draft_1_MilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"draft_1_MilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var draft_2HtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">טיוטה 2</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"draft_2_MilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"draft_2_MilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"draft_2_MilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"draft_2_MilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var sylabusHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">סילבוס</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"sylabusMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"sylabusMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"sylabusMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"sylabusMilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var presentationHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">הצגה</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"presentationMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"presentationMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"presentationMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"presentationMilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var testHtmlCode = " <fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">מבחן</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"testMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"testMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"testMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"testMilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var courseHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">קורס</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"courseMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"courseMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"courseMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"courseMilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var fixPresentationHtmlCode = "<fieldset class=\"milestoneWrapper\">\n" +
            "    <legend style=\"margin-left: 1em; padding: 0.2em 0.8em \">תיקון מצגת</legend>\n" +
            "    <label>תאריך התחלה</label>\n" +
            "    <input type=\"date\" name=\"fixPresentationMilestoneStartDate\">\n" +
            "    <label>תאריך סיום</label>\n" +
            "    <input type=\"date\" name=\"fixPresentationMilestoneDueDate\">\n" +
            "    <label>כותב אחראי</label>\n" +
            "    <input type=\"text\" placeholder=\"שם כתב אחראי\" name=\"fixPresentationMilestoneResponsibleWriterName\" required>\n" +
            "    <label>תאור</label>\n" +
            "    <input type=\"text\" placeholder=\"תאור\" name=\"fixPresentationMilestoneDescriptionName\" >\n" +
            "</fieldset> ";
        var basic_flow_html = outlineHtmlCode+draftHtmlCode+CRHtmlCode;
        var full_flow_html = outlineHtmlCode + draft_1HtmlCode+draft_2HtmlCode+CRHtmlCode;
        var course_flow_html = sylabusHtmlCode+presentationHtmlCode+ testHtmlCode+courseHtmlCode+fixPresentationHtmlCode;

        var e = document.getElementById("selectFlowID");
        var strUser = e.options[e.selectedIndex].value;
        var dynamicCodeParent = document.getElementById('productMilstonesDataID');
        var dynamicCode="";
        //basic flow is a defoult
        if(strUser == "Course")
        {
            dynamicCode=course_flow_html;
        }
        else
            if(strUser == "Full Flow")
            {
                dynamicCode=full_flow_html;
            }
            else
            {
                dynamicCode=basic_flow_html;
            }
        dynamicCodeParent.innerHTML = dynamicCode;
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
            <button onclick="AddProjects()"><a id="addProductBtn" href="#addProduct">+</a></button>
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
                        <option>Short Flow</option>
                        <option>Full Flow</option>
                        <option>Course</option>
                    </select>
                    <div id="productMilstonesDataID">

                        <fieldset class="milestoneWrapper">
                            <legend style="margin-left: 1em; padding: 0.2em 0.8em ">מתווה</legend>
                            <label>תאריך התחלה</label>
                            <input type="date" name="outlineMilestoneStartDate">
                            <label>תאריך סיום</label>
                            <input type="date" name="outlineMilestoneDueDate">
                            <label>כותב אחראי</label>
                            <input type="text" placeholder="שם כתב אחראי" name="outlineMilestoneResponsibleWriterName" required>
                            <label>תאור</label>
                            <input type="text" placeholder="תאור" name="outlineMilestoneDescriptionName" >
                        </fieldset>

                        <fieldset class="milestoneWrapper">
                            <legend style="margin-left: 1em; padding: 0.2em 0.8em ">טיוטה</legend>
                            <label>תאריך התחלה</label>
                            <input type="date" name="draftMilestoneStartDate">
                            <label>תאריך סיום</label>
                            <input type="date" name="draftMilestoneDueDate">
                            <label>כותב אחראי</label>
                            <input type="text" placeholder="שם כתב אחראי" name="draftMilestoneResponsibleWriterName" required>
                            <label>תאור</label>
                            <input type="text" placeholder="תאור" name="draftMilestoneDescriptionName" >
                        </fieldset>

                        <fieldset class="milestoneWrapper">
                            <legend style="margin-left: 1em; padding: 0.2em 0.8em ">CR</legend>
                            <label>תאריך התחלה</label>
                            <input type="date" name="CRMilestoneStartDate">
                            <label>תאריך סיום</label>
                            <input type="date" name="CRMilestoneDueDate">
                            <label>כותב אחראי</label>
                            <input type="text" placeholder="שם כתב אחראי" name="CRMilestoneResponsibleWriterName" required>
                            <label>תאור</label>
                            <input type="text" placeholder="תאור" name="CRMilestoneDescriptionName" >
                        </fieldset>


                    </div>
                </div>
                <button type="submit" value="Login" name="addProductButton" id="submitID">אישור</button>
            </div>
        </form>

    </main>
</div>
</body>
</html>
