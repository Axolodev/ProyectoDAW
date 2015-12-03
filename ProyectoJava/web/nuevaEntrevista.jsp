<%-- 
    Document   : nuevaEntrevista
    Created on : 26-oct-2015, 20:10:40
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
    <form name="nuevaEntrevista" action="Controller?operacion=nuevsEntrevista" method="get">
        <div>
            <h1>PROGRAMAR ENTREVISTA</h1>
            <fieldset>
                <legend>Datos de entrevista</legend>
                <div class="inputs">
                    <input class="form-control" type="text" name="idCandidato" placeholder="ID Candidato"/>
                    <br/>
                    <input class="form-control" type="text" name="idUsuario" placeholder="ID Entrevistador"/>
                    <br/>
                    <input class="form-control" type="date" name="fechaEntrevista" placeholder=" Fecha Entrevista"/>
                    <br/>
                    <input class="form-control" type="text" name="plataforma" placeholder="Plataforma"/>
                    <br/>
                    <textarea class="form-control" name="feedback" placeholder="feedback"></textarea>
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