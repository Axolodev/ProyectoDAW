<%-- 
    Document   : nuevoEmpleado
    Created on : 26-oct-2015, 20:09:20
    Author     : Adriana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<html>

    <form name="nuevoEmpleado" action="Controller?operacion=nuevoEmpleado" method="post">
        <div>
            <h1>NUEVO EMPLEADO</h1>
            <fieldset>
                <legend>Datos Personales</legend>
                <div class="inputs">
                    <input class="form-control" type="text" name="id" placeholder="ID Candidato"/>
                    <br/>
                    <input class="form-control" type="text" name="salario" placeholder="salario"/>
                    <br/>
                    <input class="form-control" type="text" name="vacaciones" placeholder="Dias Vacaciones"/>
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
