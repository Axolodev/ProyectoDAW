<%-- 
    Document   : nuevoCandidato
    Created on : 26-oct-2015, 20:04:12
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

    <form name="nuevoCandidato" action="" method="get">
        <div>
            <h1>NUEVO CANDIDATO </h1>
            <fieldset>
                <legend>Datos Personales</legend>
                <table>
                    <tr>
                        <td>
                            Nombre:
                        </td>
                        <td>
                            <input type="text" name="nombre"/>
                        </td>
                        <td>
                            Telefono:
                        </td>
                        <td>
                            <input type="number" name="telefono" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Correo electrónico:
                        </td>
                        <td>
                            <input type="email" name="correo" />
                        </td>
                        <td>
                            Dirección
                        </td>
                        <td>
                            <textarea name="direccion"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Puesto
                        </td>
                        <td>
                            <input type="text" name="puestoAct" />
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            <fieldset>
                <legend>Estudios</legend>
                <table>
                    <tr>
                        <td>
                            Título Universitario:
                        </td>
                        <td>
                            <input type="text" name="titulo"/>
                        </td>
                        <td>
                            Universidad:
                        </td>
                        <td>
                            <input type="text" name="universidad" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Certificados
                        </td>
                        <td>
                            <textarea name="cert"></textarea>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br/>
            <fieldset>
                <legend>Experiencia y Expectativas</legend>
                <table>
                    <tr>
                        <td>
                            Trabajo anterior:
                        </td>
                        <td>
                            <input type="text" name="trabajoAnt" />
                        </td>
                        <td>
                            Puesto:
                        </td>
                        <td>
                            <input type="text" name="puesto"  />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Expectativa de Salario
                        </td>
                        <td>
                            <input type="number" name="salario"  />
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
