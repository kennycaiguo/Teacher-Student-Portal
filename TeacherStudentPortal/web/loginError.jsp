<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="pure/pure-min.css">
        <style>
            .button-error {
            background: rgb(202, 60, 60);
            .button-success {
            background: rgb(28, 184, 65);
        }
            </style>
            
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
            
        </ul>
    </div>
         <hr>
        <h2 style="center">
            <button class="button-success pure-button"><a href="login.jsp">Login Here</a></button>
            <br>
            <br>
            <button class="button-error pure-button">
                
                Opps Error !!! RETRY !!!
            </button>
        </h2>
    </body>
</html>
