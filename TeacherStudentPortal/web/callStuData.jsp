<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Data</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link href="pure/pure-min.css" rel="stylesheet" type="text/css">
        
    </head>
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
            Update your Details Here
        </h2>
<hr>

        <form action="studentUpdate" method="post">
        <table class="pure-table pure-table-horizontal">
            <% Iterator stu;%>
            <%List studentData = (List) request.getAttribute("callStuData");
                for (stu = studentData.iterator(); stu.hasNext();) {
            %>
            <tr>

                <% String s = (String) stu.next();%>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" readonly="readonly" value="<%=s%>"</td>
            </tr>
            <tr>
            <td>FIRST_NAME</td>
            <td><input type="text" name="fname" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>LAST_NAME</td>
                <td><input type="text" name="lname" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>DOB</td>
                <td><input type="text" name="dob" value="<%=stu.next()%>"</td>
            </tr>         
            <tr>
                <td>SEX</td>
                <td><input type="text" name="sex" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>ADDRESS</td>
                <td><input type="text" name="address" value="<%=stu.next()%>"</td>

            </tr>
            <tr>
                <td>EMAIL</td>
                <td><input type="text" name="email" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value="<%=stu.next()%>"</td>
            </tr>
             <tr>
                <td>Password </td>
                <td><input type="text" name="password"  value="<%=stu.next()%>"</td>
            </tr>
             <tr>
                <td>Instructor Id</td>
                <td><input type="text" name="insid" readonly="readonly" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>Department Id</td>
                <td><input type="text" name="depid" readonly="readonly" value="<%=stu.next()%>"</td>
            </tr>
           
            <%}%>   
    </table>
    <input type ="submit" value="Update" name="update" class="pure-button pure-button-primary" onclick="alertfunction();" class="btn"></td>
</form>
</body>
</html>
