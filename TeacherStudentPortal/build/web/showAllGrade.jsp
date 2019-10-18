<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Grade</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>        
        <link rel="stylesheet" href="http:pure/pure-min.css">
        
    </head>
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
        <h1>
            Table Represent Grade Details
        </h1>
<hr>

    <body>
        <form action="InsUpdateData" method="post">
       <table id='instable' class="pure-table pure-table-horizontal">
            <thead>
            <td>Grade</td>
            <td>Student Id</td>
            <td>Class ID</td>
            
            
        </thead>
            
        <% Iterator ins;%>
        <%List insData = (List) request.getAttribute("showgrade");
        for(ins = insData.iterator(); ins.hasNext();){
        %>
        <tr>
        
            <% String s=(String) ins.next();%>

            
            <td><%=s%></td>
            <td><%=ins.next()%></td>
            <td><%=ins.next()%></td>
            <%}%>
       
        </tr>
    </table>
            
            
    </body>
</html>
