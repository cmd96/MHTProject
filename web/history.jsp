<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/11/2019
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="user" class="com.test.User" scope="request" />
<jsp:useBean id="project" class="com.test.Products" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="history.css">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
          crossorigin='anonymous'>
    <title>היסטוריה</title>
</head>
<script>
    function myFunction() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
<body>
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
<div class="data">

    <h2>היסטוריה</h2>

    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="חפש תאריך" title="Type in a date">

    <table id="myTable">
        <tr class="header">
            <th style="width:10%;">תאריך</th>
            <th style="width:15%;">מבצע</th>
            <th style="width:15%;">שם פרויקט</th>
            <th style="width:15%;">שם תוצר</th>
            <th style="width:45%;">תיאור</th>
        </tr>
        <tr>
            <td>18/02/2019</td>
            <td>rb</td>
            <td>AAA</td>
            <td>jj</td>
            <td>שינוי שם תוצר מ AA ל AAA</td>
        </tr>
    </table>
</div>

</body>
</html>
