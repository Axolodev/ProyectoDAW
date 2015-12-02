<%-- 
    Document   : nuevoEmpleado
    Created on : 26-oct-2015, 20:09:20
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

    <form name="nuevoEmpleado" action="" method="get">
        <div>
            <h1>NUEVO EMPLEADO</h1>
            <fieldset>
                <legend>Datos Personales</legend>
                <table>
                    <tr>
                        <td>
                            Número de Candidato:
                        </td>
                        <td>
                            <input type="number" name="id"/>
                        </td>
                        <td>
                            Nombre:
                        </td>
                        <td>
                            <input type="text" name="nombre" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Puesto:
                        </td>
                        <td>
                            <input type="text" name="puesto" />
                        </td>
                        <td>
                            Salario
                        </td>
                        <td>
                            <input type="text" name="salario" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Dias de vacaciones
                        </td>
                        <td>
                            <input type="number" name="vacaciones" />
                        </td>
                    </tr>
                </table>
            </fieldset>        
            <br/><br/>
            <input type="submit" name="enviar" id="envia" value="Guardar"/>
            <br/>
            <br/>
            <br/>
        </div>
    </form>



</body>
</html>
