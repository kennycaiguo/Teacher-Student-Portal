<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="static org.teacherstudentportal.controller.loginController.checklogin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="pure/pure-min.css">
        
    </head>
    <script type="text/javascript">
            function editSRecord(id){
                url="stuCallRecord";
                window.location.href="http://localhost:8080/TeacherStudentPortal/"+url+"?id="+id;
                
            }
             function showGrade(id){
                url="stuShowGrade";
                window.location.href="http://localhost:8080/TeacherStudentPortal/"+url+"?id="+id;
                
            }
            
    </script>
    <body>
        
 <div class="top">
        <h1>Teacher Student Portal</h1>
    </div>
        <div style="float: right">
        <%= new java.util.Date()%>
        </div>
        <div class="pure-menu pure-menu-open pure-menu-horizontal">
        <ul>
            <li><a href="student.jsp">Home</a></li>
            <li><a href="login.jsp">Logout</a></li> 
            
            
        </ul>
    </div>
         <hr>
        <h2>
            View your Details Here
        </h2>
<hr>
        <h2>Hello <%=checklogin.getUser()%></h2>
        
        <%String s= checklogin.getStuid();%>
        
         <input type ="submit" value="Update your Profile" name="edit" onclick="editSRecord(<%=s%>);" class="pure-button pure-button-primary">
         <br><br>
         <input type ="submit" value="View ur grade" name="grade" onclick="showGrade(<%=s%>);"class="pure-button pure-button-primary">
          
         
         <h2>
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <%=checklogin.getGrade()%>
         </h2>    
         
         
    </body>
</html>

