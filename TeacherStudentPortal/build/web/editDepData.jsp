<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Department Data</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="pure/pure-min.css">

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
            <li><a href="admin.jsp">Home</a></li>
            <li><a href="login.jsp">Logout</a></li>   
        </ul>
    </div>
         <hr>
        <h2>
            Update your Details Here
        </h2>
<hr>
        <form action="updateDepData" method="post">
        <table class="pure-table pure-table-horizontal">
            <% Iterator stu;%>
            <%List studentData = (List) request.getAttribute("EditDData");
                for (stu = studentData.iterator(); stu.hasNext();) {
            %>
            <tr>
                <% String s = (String) stu.next();%>
            <tr>
                <td>Department ID:</td>
                <td><input type="text" name="id" readonly="readonly" value="<%=s%>"</td>
            </tr>
            <tr>
            <td>Department Name:</td>
            <td><input type="text" name="fname" value="<%=stu.next()%>"</td>
            </tr>
             <td></td>
             <td><input type ="submit" value="Update" class="pure-button pure-button-primary" name="update" onclick="alertfunction();"></td>
            <%}%>
        </table>
            
    </body>
</html>
