<%@page import=" static org.teacherstudentportal.controller.loginController.checklogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http:pure/pure-min.css">

    </head>
    <body>
        <script type="text/javascript">
            function editIRecord(id) {
                url = "insCallRecord";
                window.location.href = "http://localhost:8080/TeacherStudentPortal/" + url + "?id=" + id;

            }
            function showGrade(id) {
                url = "showAllGrade";
                window.location.href = "http://localhost:8080/TeacherStudentPortal/" + url + "?id=" + id;

            }
        </script>
        <div class="top">
            <h1>Teacher Student Portal</h1>
        </div>
        

        <h2 align="center">Hello <%=checklogin.getUser()%></h2>
        <div style="float: right">
            <%= new java.util.Date()%>
        </div>

        <div class="pure-menu pure-menu-open pure-menu-horizontal">
            <ul>
                <li><a name="edit" onclick="editIRecord(<%=checklogin.getInsid()%>);">Update Profile</a></li>
                <li><a name="edit" onclick="showGrade(null);">View Grade</a></li>

                <li><a href="login.jsp">Logout</a></li>
            </ul>
        </div>

        <hr>
        <h2>
            Update your Profile<br>
            Update Student Grade

        </h2>
        <hr>
        <br>
        <h2 style="padding-left:40px">INSERT GRADE</h2>
        <br>
        <div style="position: relative;margin:auto;padding-left:40px">
            <form action="insertGradeData" method="post">
                <table>
                    <tr>
                        <td><label>Grade :</label></td>
                        <td><input name="grade" type="text" size="25" style="height:20px;" id="user_name" class="input"/></td>
                    </tr>
                    <tr>
                        <td><label>Student ID :</label> </td>          
                        <td><input name="sid" type="text"  id="user_pass" class="input" value="" size="25" style="height:20px;" /></td>
                    </tr>
                    <tr>
                        <td><label>Class ID :</label> </td>          
                        <td><input name="cid" type="text"  id="user_pass" class="input" value="" size="25" style="height:20px;" /></td>
                    </tr>

                    <tr>
                        <td><input type="reset" value="Reset"  class="pure-button pure-button-primary"></td>
                        <td><input type="submit" value="Submit"  class="pure-button pure-button-primary" onclick="validateform()"></td>
                    </tr>
                </table>
            </form>
        </div>
        <br>
    </body>
</html>
