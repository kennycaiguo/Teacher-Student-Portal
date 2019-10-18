<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="pure/pure-min.css">
<link href="CSS.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
              <div class="top">
        <h1>Teacher Student Portal</h1>
    </div>
    <div style="float: right">
        <%= new java.util.Date()%>
        </div>
        <div class="pure-menu pure-menu-open pure-menu-horizontal">
        <ul>
            <li><a href="instructor.jsp">Home</a></li>
            <li><a href="login.jsp">Logout</a></li>   
        </ul>
    </div>
         <hr>
        <h2>
            Update your Details Here
        </h2>
<hr>
        <form action="InsUpdateData" method="post">
        <table class="pure-table pure-table-horizontal" style="font-size: 12px">
            <% Iterator stu;%>
            <%List studentData = (List) request.getAttribute("callInsData");
                for (stu = studentData.iterator(); stu.hasNext();) {
            %>
            <tr>

                <% String s = (String) stu.next();%>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" readonly="readonly" value="<%=s%>"</td>
            </tr>
            <tr>
            <td>FIRST NAME</td>
            <td><input type="text" name="fname" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>LAST NAME</td>
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
                <td>Password</td>
                <td><input type="text" name="password" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value="<%=stu.next()%>"</td>
            </tr>
            <tr>
                <td>Department Id</td>
                <td><input type="text" name="depid" readonly="readonly" value="<%=stu.next()%>"</td>
            </tr>
             <tr>
             <td></td>
             <td><input type ="submit" value="Update" name="update" class="pure-button pure-button-primary"></td>
            </tr>
            <%}%>

        </tr>    
    </table>
</form>
</html>
