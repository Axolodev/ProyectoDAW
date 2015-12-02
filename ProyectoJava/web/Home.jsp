<%-- 
    Document   : Home
    Created on : 26-oct-2015, 22:29:41
    Author     : Adriana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<html>

    <%
        if (session.getAttribute("user") == null) {
            response.sendRedirect("/Mensajeria/login.jsp");
        }
    %>

    <body onload="HoraActual()">
        <div id="msj">
            <h1>BIENVENIDO AL SISTEMA DE CAPITAL HUMANO</h1>
            <h2 id="Fecha"></h2>
        </div>

    <!--    <a href="Controlador?operacion=editaCandidato">
            editar candidato
        </a><br/><br/>
        <a href="Controlador?operacion=editaEmpleado">
            editar empleado
        </a><br/><br/>
        <a href="Controlador?operacion=nuevaEntrevista">
            nueva entrevista
        </a><br/><br/>
        <a href="Controlador?operacion=nuevoCandidato">
            nuevo candidato
        </a><br/><br/>
        <a href="Controlador?operacion=nuevoEmpleado">
            nuevo empleado
        </a><br/><br/>

        <a href="Controlador?operacion=logout">
            logout
        </a> -->
    </body>

    <script>
        function HoraActual() {
            var currentdate = new Date();
            var day = currentdate.getDate();
            var month;
            switch (currentdate.getMonth() + 1) {
                case 1:
                    month = 'Enero';
                    break;
                case 2:
                    month = 'Febrero';
                    break;
                case 3:
                    month = 'Marzo';
                    break;
                case 4:
                    month = 'Abril';
                    break;
                case 5:
                    month = 'Mayo';
                    break;
                case 6:
                    month = 'Junio';
                    break;
                case 7:
                    month = 'Julio';
                    break;
                case 8:
                    month = 'Agosto';
                    break;
                case 9:
                    month = 'Septiembre';
                    break;
                case 10:
                    month = 'Octubre';
                    break;
                case 11:
                    month = 'November';
                    break;
                case 12:
                    month = 'December';
                    break;
            }
            var year = currentdate.getFullYear()
            var h = currentdate.getHours();
            var m = currentdate.getMinutes();
            var s = currentdate.getSeconds();
            m = checkTime(m);
            s = checkTime(s);
            var datetime = day + "-" + month + "-" + year + " "
                    + h + ":" + m + ":" + s;
            document.getElementById("Fecha").innerHTML = datetime;
            var t = setTimeout(HoraActual, 500);
        }

        function checkTime(i) {
            if (i < 10) {
                i = "0" + i
            }
            ;  // add zero in front of numbers < 10
            return i;
        }



    </script>
</html>
