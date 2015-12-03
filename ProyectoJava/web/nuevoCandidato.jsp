<%-- 
    Document   : nuevoCandidato
    Created on : 26-oct-2015, 20:04:12
    Author     : Adriana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<html>
    <form name="nuevoCandidato" action="Controller?operacion=nuevoCandidato" method="post">
        <div>
            <h1>NUEVO CANDIDATO </h1>
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
            <br/><br/>
            <input class="btn btn-default" type="submit" name="enviar" id="envia" value="Guardar"/>
            <br/>
            <br/>
            <br/>
        </div>
    </form>



</body>
</html>
