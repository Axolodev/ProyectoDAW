<%-- 
    Document   : GeneraReporte
    Created on : 03-dic-2015, 22:44:35
    Author     : robil_000
--%>

<%@page import="entrevistas.Empleado"%>
<%@page import="entrevistas.Candidato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entrevistas.Entrevista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>


    <head>
        <title>Generar Reporte.</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">

        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.js"></script>
        <style >

            #main_container{
                margin: 0 auto;
                width: 99%;
                display: block;
                text-align: center;
                font-family: arial;
                font-size: 16px;
            }
            table {
                font-size:14px;
                text-align:center;
                font-weight: normal;
                padding: 0;
            }
            th {
                text-align:center;
            }
            
        </style>
    </head>
    <div id="main_container">
        <table id="entrevistas">
            <thead>
                <tr>
                    <th>id</th>
                    <th>idCandidato</th>
                    <th>idUsuario</th>
                    <th>fecha</th>
                </tr>
            </thead>
            <tbody>
                <%                    ArrayList<Entrevista> al = (ArrayList) request.getAttribute("listaEntrevistas");

                    int alLen = al.size();
                    for (int i = 0; i < alLen; i++) {

                        Entrevista en = al.get(i);


                %>

            <td><%=en.getIdEntrevista()%></td>    
            <td><%=en.getIdCandidato()%></td>    
            <td><%=en.getIdUsuario()%></td>    
            <td><%=en.getFecha().toString()%></td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
            <br /><br /><br />
        <table id="candidatos">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Puesto</th>
                    <th>Estudios</th>
                    <th>Universidad</th>
                    <th>Titulo</th>
                    <th>Certificados</th>
                    <th>Experiencia</th>
                    <th>PuestoAnterior</th>
                    <th>ExpectativaSalario</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Candidato> alCan = (ArrayList) request.getAttribute("listaCandidatos");

                    int alEnLen = alCan.size();
                    for (int i = 0; i < alEnLen; i++) {

                        Candidato can = alCan.get(i);
                %>

            <td><%=can.getIdCandidato()%></td>    
            <td><%=can.getNombreCandidato()%></td>    
            <td><%=can.getEmailCandidato()%></td>
            <td><%=can.getTelefono()%></td>
            <td><%=can.getDireccion()%></td>
            <td><%=can.getPuesto()%></td>
            <td><%=can.getEstudios()%></td>
            <td><%=can.getUniversidad()%></td>
            <td><%=can.getTitulo()%></td>
            <td><%=can.getCertificados()%></td>
            <td><%=can.getTimeExpereince()%></td>
            <td><%=can.getPuestoAnterior()%></td>
            <td><%=can.getExpectativaSalario()%></td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
            <br /><br /><br />
        <table id="empleados">
            <thead>
                <tr>
                    <th>id</th>
                    <th>idCandidato</th>
                    <th>Salario</th>
                    <th>diasVacaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Empleado> alEm = (ArrayList) request.getAttribute("listaEmpleados");

                    int alEmLen = alEm.size();
                    for (int i = 0; i < alEmLen; i++) {

                        Empleado ca = alEm.get(i);
                %>

            <td><%=ca.getIdEmpleado()%></td>    
            <td><%=ca.getIdCandidato()%></td>    
            <td><%=ca.getSalario()%></td>    
            <td><%=ca.getDiasVacaciones()%></td>
            <%
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>

    <script>

        $(document).ready(function () {
            $('#entrevistas').DataTable();
            $('#empleados').DataTable();
            $('#candidatos').DataTable();
        });
    </script>
</html>
