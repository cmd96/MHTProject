<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 27/10/2019
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" errorPage=""%>
<%@ page import="com.test.*" %>
<%@ page import="com.test.User" %>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<html>
<head>
    <link rel="stylesheet" type="text/css" href="reportYearTable.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <title>Reports</title>
</head>
<script>
    function createChart(e) {
        const days = document.querySelectorAll(".chart-values li");
        const tasks = document.querySelectorAll(".chart-bars li");
        const daysArray = [...days];

        tasks.forEach(el => {
            const duration = el.dataset.duration.split("-");
            const startDay = duration[0];
            const endDay = duration[1];
            let left = 0,
                width = 0;

            if (startDay.endsWith("½")) {
                const filteredArray = daysArray.filter(day => day.textContent == startDay.slice(0, -1));
                left = filteredArray[0].offsetLeft + filteredArray[0].offsetWidth / 2;
            } else {
                const filteredArray = daysArray.filter(day => day.textContent == startDay);
                left = filteredArray[0].offsetLeft;
            }

            if (endDay.endsWith("½")) {
                const filteredArray = daysArray.filter(day => day.textContent == endDay.slice(0, -1));
                width = filteredArray[0].offsetLeft + filteredArray[0].offsetWidth / 2 - left;
            } else {
                const filteredArray = daysArray.filter(day => day.textContent == endDay);
                width = filteredArray[0].offsetLeft + filteredArray[0].offsetWidth - left;
            }

            // apply css
            el.style.left = `${left}px`;
            el.style.width = `${width}px`;
            if (e.type == "load") {
                el.style.backgroundColor = el.dataset.color;
                el.style.opacity = 1;
            }
        });
    }

    window.addEventListener("load", createChart);
    window.addEventListener("resize", createChart);
</script>
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
    <div >
        <div class="chart-wrapper">
            <ul class="chart-values">
                <li>sun</li>
                <li>mon</li>
                <li>tue</li>
                <li>wed</li>
                <li>thu</li>
                <li>fri</li>
                <li>sat</li>
            </ul>
            <ul class="chart-bars">
                <li data-duration="tue½-wed" data-color="#b03532">Task</li>
                <li data-duration="wed-sat" data-color="#33a8a5">Task</li>
                <li data-duration="sun-tue" data-color="#30997a">Task</li>
                <li data-duration="tue½-thu" data-color="#6a478f">Task</li>
                <li data-duration="mon-tue½" data-color="#da6f2b">Task</li>
                <li data-duration="wed-wed" data-color="#3d8bb1">Task</li>
                <li data-duration="thu-fri½" data-color="#e03f3f">Task</li>
                <li data-duration="mon½-wed½" data-color="#59a627">Task</li>
                <li data-duration="fri-sat" data-color="#4464a1">Task</li>
            </ul>
        </div>
    </div>

</div>
</body>
</html>
