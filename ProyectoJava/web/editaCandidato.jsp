<%-- 
    Document   : editaCandidato
    Created on : 26-oct-2015, 22:18:44
    Author     : Adriana, Mayra y Roberto
--%>
<%@page import="entrevistas.Candidato"%>
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
        <script>
            var clientes = new Array();
            <%
                ArrayList<Candidato> al = (ArrayList) request.getAttribute("lista");
                int alLen = al.size();
                for (int i = 0 ; i < alLen ; i++){
                    out.print("clientes[" + i + "] = new Array(");
                    out.print(al.get(i).getIdCandidato() + ",\"");
                    out.print(al.get(i).getNombreCandidato()+ "\",\"");
                    out.print(al.get(i).getTelefono()+ "\",\"");
                    out.print(al.get(i).getEmailCandidato()+ "\",\"");
                    out.print(al.get(i).getDireccion().replaceAll("\\s+", " ")+ "\",\"");
                    out.print(al.get(i).getPuesto()+ "\",\"");
                    out.print(al.get(i).getEstudios()+ "\",\"");
                    out.print(al.get(i).getTitulo()+ "\",\"");
                    out.print(al.get(i).getUniversidad()+ "\",\"");
                    out.print(al.get(i).getCertificados()+ "\",");
                    out.print(al.get(i).getTimeExpereince()+ ",\"");
                    out.print(al.get(i).getPuestoAnterior()+ "\",");
                    out.print(al.get(i).getExpectativaSalario());
                    out.print(");\n");
            }%> 

            // Variables que se utilizaran
            var clientes_length = clientes.length;
            var pencilIcon = "http://findicons.com/files/icons/1588/farm_fresh_web/16/pencil.png";
            var deleteIcon = "https://portal.monitorhub.com/images/Icon_RedCross.png";

            function llenaTabla() {
                var tabla_clientes = document.getElementById("clientes");
                // Poner la informacion en la tabla. 
                for (var i = 0; i < clientes_length; i++) {
                    var tr = document.createElement("tr");
                    // Solo se ponen tres datos en la tabla
                    for (var j = 0; j < 4; j++) {
                        td = document.createElement("td");
                        td.appendChild(document.createTextNode(clientes[i][j]));
                        tr.appendChild(td);
                    }

                    // Crear boton para editar elemento
                    td = document.createElement("td");
                    var botonEditar = document.createElement("input");
                    botonEditar.setAttribute("type", "image");
                    botonEditar.setAttribute("src", pencilIcon);
                    botonEditar.setAttribute("alt", "submit");
                    td.appendChild(botonEditar);
                    tr.appendChild(td);

                    // Agregar accion de onclick
                    botonEditar.onclick = (function () {
                        var currentI = i;
                        return function () {
                            editaDatos(currentI);
                        };
                    })();


                    // Crear boton para borrar elemento
                    td = document.createElement("td");
                    var botonBorrar = document.createElement("input");
                    botonBorrar.setAttribute("type", "image");
                    botonBorrar.setAttribute("src", deleteIcon);
                    botonBorrar.setAttribute("alt", "submit");
                    td.appendChild(botonBorrar);
                    tr.appendChild(td);

                    // Agregar accion de onclick al botonBorrar
                    botonBorrar.onclick = (function () {
                        var currentI = i;
                        return function () {
                            // funcion temporal para simular borrado de elemento
                            console.log("elemento " + currentI + "borrado");
                        };
                    })();

                    tabla_clientes.appendChild(tr);
                }
            }

            function editaDatos(indice) {
                var form = document.getElementById("informacion_cliente");
                
                var elements = form.elements;
                for (var i = 0, j = 0; i < elements.length; i++, j++) {
                    elements[i].readOnly = false;
                    elements[i].value = clientes[indice][j];
                    if(i === 6 || i === 11) {
                        j --;
                    }
                }
            }
            
            function deshabilitaForma() {
                var form = document.getElementById("informacion_cliente");
                
                var elements = form.elements;
                for (var i = 0; i < elements.length; i++) {
                    elements[i].readOnly = true;
                }
            }

        </script>
    </head>

    <body onload="deshabilitaForma(); llenaTabla();">
        <h1 style="margin-left:25%;">Edita o Elimina Candidato</h1>
        <div id="main_container">
            <table id="clientes">
                <tr>
                    <th>id</th>
                    <th>Nombre</th>
                    <th>Tel&eacute;fono</th>
                    <th>Correo electr&oacute;nico</th>
                    <th>Editar</th>
                    <th>Borrar</th>
                </tr>
                
            </table>
            <br />
            <br />
            <form id="informacion_cliente">
                <fieldset>
                    <legend>Datos Personales</legend>
                    <div class="inputs">
                        <input class="form-control" type="text" name="nombre" placeholder="Nombre"/>
                        <br/>
                        <input class="form-control" type="text" name="telefono" placeholder="Telefono"/>
                        <br/>
                        <input class="form-control" type="email" name="email" placeholder="Correo"/>
                        <br/>
                        <textarea class="form-control" name="direccion" placeholder="Direccion"></textarea>
                        <br/>
                        <input class="form-control" type="text" name="puestoAct" placeholder="Puesto a Aplicar"/>
                        <br/>
                    </div>
                </fieldset>
                <br/>
                <fieldset>
                    <legend>Estudios</legend>
                    <div class="inputs">
                        <input class="form-control" type="text" name="estudios" placeholder="Estudios"/>
                        <br/>
                        <input class="form-control" type="text" name="titulo" placeholder="Título"/>
                        <br/>
                        <input class="form-control" type="text" name="universidad" placeholder="Universidad"/>
                        <br/>
                        <input class="form-control" type="text" name="cert" placeholder="Certificados"/>
                        <br/>                    
                    </div>
                </fieldset>
                <br/>
                <fieldset>
                    <legend>Experiencia y Expectativas</legend>
                    <div class="inputs">
                        <input class="form-control" type="number" name="experiencia" placeholder="Años Experiencia"/>
                        <br/>
                        <input class="form-control" type="text" name="trabajoAnt" placeholder="Puesto Anterior"/>
                        <br/>
                        <input class="form-control" type="text" name="salario" placeholder="Expectativa Salario"/>
                        <br/>
                    </div>
                </fieldset>
                <br/>
                <br/>

                <button type="reset" onclick="deshabilitaForma()">Reset</button>
                <button type="submit" >Guardar</button>
            </form>
        </div>

    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>

        $(document).ready(function () {
            $("#informacion_cliente").submit(function (event) {
                event.preventDefault();
                console.log(1);
                $.ajax({
                    type: "POST",
                    url: "candidatos.jsp?operacion=editar",
                    data: $(this).serialize(),
                    success: function (data) {
                        console.log(data);
                        if(data === "Editar"){
                            deshabilitaForma();
                        }
                    }
                });

            });
        });

    </script>

</html>