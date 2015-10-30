<%-- 
    Document   : Login
    Created on : 26-oct-2015, 22:31:10
    Author     : Adriana, Mayra, Roberto
--%>
<!doctype html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
        <meta charset="UTF-8" />
    </head>
    <body>
        <div id="topbar">
            LOGO
        </div>
        <br/><br/><br/><br/><br/>
        <br/><br/><br/><br/><br/>
        <form name="login" action="Home.jsp" method="get">
            <div class="move" style="Width: 70%">
                <h1>Inicia Sesión</h1>
                <table>
                    <tr>
                        <td>
                            <i class="fa fa-user" style="font-size:36px; color:#4C4C4C"></i>
                        </td>
                        <td>
                            <input type="text" name="email" style="width:200px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <i class="fa fa-lock" style="font-size:36px; color:#4C4C4C"></i>
                        </td>
                        <td>
                            <input type="password" name="pass" style="width:200px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &nbsp;
                        </td>
                    </tr>
                </table>
                <input type="submit" id="sub" value="Acceder" />
                <br/><br/>									
            </div>
        </form>
    </body>
</html>