<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher Student Portal</title>
        <link href="CSS.css" rel="stylesheet" type="text/css"/>
        <link href="pure/pure-min.css" rel="stylesheet">

        <script type="text/javascript">
            function validateform()
            {
                var name = document.loginform.user_name.value;
                var password = document.loginform.user_pass.value;

                if (name === = null || "") {
                    alert("Username cannot be left Blank");
                    form.document.focus;
                    return false;
                } else if (password === null || "") {
                    alert("Please Enter Password");
                    return false;
                }
            }
        </script>     


    </head>
    <body>
        <div class="top"> 
            <h1>Welcome to Teacher Student Portal</h1>    
        </div>
        <div id="login">
            <div id="error">

                <h2>Teacher Student Portal</h2>
                <hr>
            </div>
            <form name="loginform" id="login-form" action="loginController" method="post">
                <p>
                    <label>Select Role :
                        <select name="role">
                            <option value="ADMINISTRATOR">Administrator</option>
                            <option value="instructor">Instructor</option>
                            <option value="student">Student</option>
                        </select>
                </p>

                <p>
                    <label>User Email:
                        <input type="email" size="25" style="height:20px" id="user_name" class="input" name="email"/></label>
                </p>
                <p>
                    <label>Password :
                        <input type="password" name="password" id="user_pass" class="input" value="" size="25" style="height: 20px;" /></label>
                </p>
                <p>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="reset" value="Reset" class="pure-button pure-button-primary"/> 
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="Login" onclick="validateform();"class="pure-button pure-button-primary"/>

                </p>

            </form>
        </div>
        <hr>
        <p align="center">&COPY; &nbsp;Teacher Student Portal 2019</p>
    </body>
</html>
