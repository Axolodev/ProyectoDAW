<%-- 
    Document   : editaCandidato
    Created on : 26-oct-2015, 22:18:44
    Author     : Adriana, Mayra y Roberto
--%>
<%@page import="entrevistas.Entrevista"%>
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<html>

    <%@include file="header.jsp"%>

    <head>
        <title>modificar clientes</title>
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
                    <th>idCandidato</th>
                    <th>idUsuario</th>
                    <th>fecha</th>
                    <th>editar</th>
                    <th>borrar</th>
                </tr>
                <%                    
                    ArrayList<Entrevista> al = (ArrayList) request.getAttribute("lista");
                    String st = request.getParameter("idEntrevista");
                    Entrevista e = null;
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
                        Entrevista en = al.get(i);
                        if (idR == en.getIdEntrevista()) {
                            e = en;
                        }
                %>
                <td><%=en.getIdEntrevista()%></td>    
                <td><%=en.getIdCandidato()%></td>    
                <td><%=en.getIdUsuario()%></td>    
                <td><%=en.getFecha().toString()%></td>
                <td><input type="image" alt="submit" src="http://findicons.com/files/icons/1588/farm_fresh_web/16/pencil.png" id="<%=en.getIdEntrevista()%>" onclick="editMe(<%=en.getIdEntrevista()%>)"/></td>
                <td><input type="image" alt="submit" src="https://portal.monitorhub.com/images/Icon_RedCross.png" id="<%=en.getIdEntrevista()%>" onclick="deleteMe(<%=en.getIdEntrevista()%>)"/></td>
                    <%
                            out.print("</tr>");
                        }
                    %>
            </table>
            <br />
            <br />

            <%if (e != null) {%>
            <form action="Controller?operacion=edicionEntrevista&id=<%=e.getIdEntrevista()%>" type="post">

                <legend>Datos de entrevista</legend>
                <div class="inputs">
                    <input class="form-control" type="text" name="idCandidato" value="<%=e.getIdCandidato()%>"/>
                    <br/>
                    <input class="form-control" type="text" name="idUsuario" value="<%=e.getIdUsuario() %>"/>
                    <br/>
                    <input class="form-control" type="date" name="fecha"/>
                    <br/>
                    <input class="form-control" type="text" name="plataforma" value="<%=e.getPlataforma() %>" placeholder="Plataforma"/>
                    <br/>
                    <input class="form-control" type="text" name="feedback" value="<%=e.getFeedback() %>" placeholder="Feedback"/>
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
                        window.location.replace("Controller?operacion=editarEntrevista&idEntrevista=" + val);
                    }

                    function deleteMe(val) {
                        window.location.replace("Controller?operacion=borraEntrevista&idEntrevista=" + val);
                    }
    </script>

</html>