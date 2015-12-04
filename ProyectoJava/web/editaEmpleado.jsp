<%-- 
    Document   : editaCandidato
    Created on : 26-oct-2015, 22:18:44
    Author     : Adriana, Mayra y Roberto
--%>
<%@page import="entrevistas.Empleado"%>
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<html>

    <%@include file="header.jsp"%>

    <head>
        <title>modificar empleados</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="menu.css">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
        <style>
            #main_container {
                margin: 0 auto;
                width: 90%;
                display: block;
                text-align: center;
                font-family: arial;
                font-size: 16px;
            }

            #clientes {
                background: #bbb;
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
                table-layout: fixed;
                margin-left: auto;
                margin-right: auto;
            }

            #clientes td:first-child {
                max-width: 50px;
                width: 50px;
            }

            #clientes td:nth-child(2) {
                max-width: 200px;
                width: 200px;
            }

            #clientes td:nth-child(3) {
                max-width: 130px;
                width: 130px;
            }
            #clientes td:nth-child(4) {
                max-width: 200px;
                width: 200px;
            }


            td {
                overflow: hidden;
                white-space: nowrap;
                text-align: center;
            }
        </style>
    </head>

    <body>
        <h1 style="margin-left:25%;">Edita o Elimina Candidato</h1>
        <div id="main_container">
            <table id="clientes">
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>correo</th>
                    <th>telefono</th>
                    <th>puesto</th>
                    <th>salario</th>
                    <th>diasVacaciones</th>
                </tr>
                <%                    ArrayList<Empleado> al = (ArrayList) request.getAttribute("lista");
                    String st = request.getParameter("idEmpleado");
                    Empleado e = null;
                    int idR = 0;
                    int alLen = al.size();
                    if (st != null) {
                        idR = Integer.valueOf(st);
                    }
                    if (alLen > 0) {
                        e = al.get(0);
                    }
                    for (int i = 0; i < alLen; i++) {
                        out.print("<tr>");
                        Empleado en = al.get(i);
                        if (idR == en.getIdEmpleado()) {
                            e = en;
                        }
                %>
                <td><%=en.getIdEmpleado()%></td>    
                <td><%=en.getNombre()%></td>    
                <td><%=en.getCorreo()%></td>    
                <td><%=en.getTelefono()%></td>
                <td><%=en.getPuesto()%></td>    
                <td><%=en.getSalario()%></td> 
                <td><%=en.getDiasVacaciones()%></td>    
                <td><input type="image" alt="submit" src="http://findicons.com/files/icons/1588/farm_fresh_web/16/pencil.png" id="<%=en.getIdEmpleado()%>" onclick="editMe(<%=en.getIdEmpleado()%>)"/></td>
                <td><input type="image" alt="submit" src="https://portal.monitorhub.com/images/Icon_RedCross.png" id="<%=en.getIdEmpleado()%>" onclick="deleteMe(<%=en.getIdEmpleado()%>)"/></td>
                    <%
                            out.print("</tr>");
                        }
                    %>
            </table>
            <br />
            <br />

            <%if (e != null) {%>
            <form action="Controller?operacion=edicionEmpleado&id=<%=e.getIdEmpleado()%>" type="post">

                <legend>Datos de entrevista</legend>
                <div class="inputs">
                    <input class="form-control" type="text" name="nombreEmpleado" value="<%=e.getNombre()%>"/>
                    <br/>
                    <input class="form-control" type="text" name="correo" value="<%=e.getCorreo()%>"/>
                    <br/>
                    <input class="form-control" type="text" name="telefono" value="<%=e.getTelefono()%>"/>
                    <br/>
                    <input class="form-control" type="text" name="puesto" value="<%=e.getPuesto()%>"/>
                    <br/>
                    <input class="form-control" type="text" name="salario" value="<%=e.getSalario()%>"/>
                    <br/>  
                    <input class="form-control" type="text" name="diasVacaciones" value="<%=e.getDiasVacaciones()%>"/>
                    <br/>  
                </div>
                </fieldset>
                <br/>
                <br/>

                <button type="submit" >Guardar</button>
            </form>
            <%}%>
        </div>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
                    function editMe(val) {
                        window.location.replace("Controller?operacion=editarEmpleado&idEmpleado=" + val);
                    }

                    function deleteMe(val) {
                        window.location.replace("Controller?operacion=borraEmpleado&idEmpleado=" + val);
                    }
    </script>

</html>