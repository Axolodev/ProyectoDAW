<%-- 
    Document   : nuevaEntrevista
    Created on : 26-oct-2015, 20:10:40
    Author     : Adriana
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
    <form name="nuevaEntrevista" action="" method="get">
      <div>
        <h1>PROGRAMAR ENTREVISTA</h1>
        <fieldset>
          <legend>Datos de entrevista</legend>
          <table>
            <tr>
              <td>
                Nombre del Candidato:
              </td>
              <td>
                 <input type="text" name="nombre"/>
              </td>
              <td>
                Entrevistador
              </td>
              <td>
                <input type="text" name="entrevistador" />
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
                  Fecha
                </td>
                <td>
                  <input type="date" name="fecha"/>
                </td>
            </tr>
            <tr>
              <td>
                Plataforma
              </td>
              <td>
                <input type="text" name="plataforma" />
              </td>
              <td>
                Feedback:
              </td>
              <td>
                <textarea></textarea>
              </td>
             </tr>
            </table>
        </fieldset>
        <br/><br/>
        <input type="submit" name="enviar" id="envia" valor="Guardar"/>
        <br/>
        <br/>
        <br/>
      </div>
    </form>



  </body>
</html>