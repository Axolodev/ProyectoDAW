<%-- 
    Document   : editaEmpleado
    Created on : 26-oct-2015, 22:26:32
    Author     : Adriana
--%>

<!DOCTYPE html>

<html>

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
        
        #empleados {
            background: #bbb;
            border-top-left-radius: 5px;
            border-top-right-radius: 5px;
            table-layout: fixed;
            margin-left: auto;
            margin-right: auto;
        }
        
        #empleados td:first-child {
            max-width: 50px;
            width: 50px;
        }
        
        #empleados td:nth-child(2) {
            max-width: 200px;
            width: 200px;
        }
        
        #empleados td:nth-child(3) {
            max-width: 200px;
            width: 200px;
        }
        
        #empleados td:nth-child(4) {
            max-width: 130px;
            width: 130px;
        }
        
        td {
            overflow: hidden;
            white-space: nowrap;
            text-align: center;
        }
        
        .clear {
            clear: both;
        }
        
        #informacion_personal {
            width: 48%;
            float: left;
            min-height: 10px;
            border-right: 1px solid;
            border-color: darkslategrey;
        }
        
        #informacion_profesional {
            width: 47.9%;
            min-height: 10px;
            float: left;
        }
        
        #informacion_empleado div {
            text-align: left;
            padding: 1%;
            line-height: 1.7em;
        }
        
        #informacion_empleado textarea {
            width: 400px;
            max-width: 95%;
            max-height: 50px;
            height: 50px;
        }
        
        #informacion_empresa{
            width:100%;
        }
    </style>


    <script>
        // Aqui se obtienen los datos.
        // Generados manualmente para pruebas
        var empleados = new Array();
        empleados[0] = new Array("Mayra Ruiz", "mey_ruiz@indi.mx", "818 081 2918",
            "Direccion de Mayra", "B.S. Computer Science",
            "Certificados", "Trabajos", "Dinero", "Jefa", "$100, 000", "Siempre");
        empleados[1] = new Array("Adrian Valenzuela", "Adriana@val.mx",
            "818 119 5331", "Direccion de Adriana", "B.S. Computer Science",
            "Certificado en Office", "Trabaja", "Poco dinero", "Gerente", 
                                 "$1, 000", "Nunca");
        empleados[2] = new Array("Tatiana Martinez", "tati_mtz@men.te",
            "818 081 3738", "Direccion de Tatiana", "B.S. Business and Techn.",
            "Certificado en mercados", "MenTe", "Dinero", "Consultora", 
                                 "$20, 000", "Mayo a Julio");

        // Variables que se utilizaran
        var empleados_length = empleados.length;
        var pencilIcon = "http://findicons.com/files/icons/1588/farm_fresh_web/16/pencil.png";
        var deleteIcon = "https://portal.monitorhub.com/images/Icon_RedCross.png";

        function deshabilitaForma() {
            var form = document.getElementById("informacion_empleado");
            var elements = form.elements;
            for (var i = 0; i < elements.length; i++) {
                elements[i].readOnly = true;
            }
        }

        function llenaTabla() {
            var tabla_empleados = document.getElementById("empleados");
            // Poner la informacion en la tabla. 
            for (var i = 0; i < empleados_length; i++) {
                var tr = document.createElement("tr");
                var td = document.createElement("td");
                td.appendChild(document.createTextNode(i));
                tr.appendChild(td);

                // Solo se ponen tres datos en la tabla
                for (var j = 0; j < 3; j++) {
                    td = document.createElement("td");
                    td.appendChild(document.createTextNode(empleados[i][j]));
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
                    }
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
                    }
                })();

                tabla_empleados.appendChild(tr);
            }
        }

        function editaDatos(indice) {
            var form = document.getElementById("informacion_empleado");
            var elements = form.elements;
            for (var i = 0; i < elements.length; i++) {
                elements[i].readOnly = false;
                elements[i].value = empleados[indice][i];
            }
        }
    </script>
</head>

<body onload="llenaTabla(); deshabilitaForma()">
    <div id="barra1">
        <div id="barra1-2">
            <button class="btn"><i class="fa fa-home"></i></button>
            <button class="btn"><i class="fa fa-cog"></i></button>
            <button class="btn"><i class="fa fa-sign-out"></i></button>
        </div>
    </div>
    <div id="barra2">
        <ul>
            <li>
                Candidatos
                <ul>
                    <li>Agregar nuevo</li>
                    <li>Modificar/Eliminar</li>
                </ul>
            </li>
            <li>Entrevista
                <ul>
                    <li>Agendar</li>
                    <li>Modificar existente</li>
                </ul>
            </li>
            <li>Empleados
                <ul>
                    <li>Agregar</li>
                    <li>Modificar/Eliminar</li>
                </ul>
            </li>
            <li>Reportes
                <ul>
                    <li>Generar</li>
                </ul>
            </li>
        </ul>
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    <h1 style="margin-left:25%;">Edita o Elimina Empleado</h1>
    <div id="main_container">
        <table id="empleados">
            <tr>
                <th></th>
                <th>Nombre</th>
                <th>Correo electr&oacute;nico</th>
                <th>Tel&eacute;fono</th>
                <th>Editar</th>
                <th>Borrar</th>
            </tr>
        </table>
        <br />
        <br />
        <form id="informacion_empleado">

            <div id="informacion_personal">
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre">
                <br/>
                <label for="correo">Email:</label>
                <input type="email" name="correo">
                <br/>
                <label for="telefono">Telefono:</label>
                <input type="text" name="telefono">
                <br />
                <label for="direccion">Direccion:</label>
                <br />
                <textarea name="direccion"></textarea>
            </div>
            <div id="informacion_profesional">
                <label for="carrera">Carrera:</label>
                <input type="text" name="carrera">
                <br/>
                <label for="certificados">Certificados:</label>
                <input type="text" name="certificados">
                <br/>
                <label for="empresa">Empresa:</label>
                <input type="text" name="empresa">
                <br />
                <label for="economico">Necesidad economica:</label>
                <input type="text" name="economico">
                <br />
            </div>
            <span class="clear"></span>

            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <div id="informacion_empresa">
                <label for="puesto">Puesto:</label>
                <input type="text" name="puesto"><br/>
                <label for="salario">Salario:</label>
                <input type="text" name="salario"><br/>
                <label for="vacaciones">Vacaciones:</label>
                <input type="text" name="vacaciones"><br/>
            </div>
            <br />
            <button type="reset" onclick="deshabilitaForma()">Reset</button>
            <button type="reset" onclick="deshabilitaForma()">Guardar</button>
        </form>
    </div>
</body>

</html>