// $('#addProjectBtn').click(function () {
//     $.post('Hello.java/getProjectsNames',function (data) {
//         $.each(data,function (i,item) {
//             $('<div id="1">'+item.aba+'</div>').appendTo($('#idp'))
//
//         })
//     })
// })
// function fillProjectsOptionList() {
//     var x = document.getElementById("selectProject");
//     var option = document.createElement("option");
//     option.text = "Kiwi";
//     var con=new SQLConnection.getCon();
//     var stmt = con.createStatement();
//
//     var SQL = "SELECT * FROM Projects";
//     var rs = stmt.executeQuery(SQL);
//     while (rs.next()) {
//         var option = document.createElement("option");
//         option.text = rs.getString("Name");
//         x.add(option);
//     }
// }