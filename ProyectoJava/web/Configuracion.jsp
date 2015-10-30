<%-- 
    Document   : Configuracion
    Created on : 26-oct-2015, 22:28:20
    Author     : Adriana, Mayra y Roberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
 <form name="nuevoCandidato" action="servidor.html" method="get">
      <div>
        <h1>MODIFICAR DATOS </h1>
          <table style="margin-left:15%">
            <tr>
              <td>
                Nombre:
              </td>
              <td>
                 <input type="text" name="nombre"/>
              </td>
              </tr>
                          <tr>
              <td>
                Correo electrónico:
                </td>
                <td>
                  <input type="email" name="correo" />
                </td>
                </tr>
              <tr>
              <td>
                Contraseña Actual:
              </td>
              <td>
                <input type="text" name="passActual" />
              </td>
            </tr>
                <tr>
                <td>
                  Contraseña nueva:
                </td>
                <td>
                  <textarea name="direccion"></textarea>
                </td>
            </tr> 
            <tr>
            	<td>&nbsp;
            	</td>
            </tr>  
            <tr>
            <td>        <input type="submit" name="enviar" id="envia" valor="Guardar"/></td>
            </tr>        
          </table>
        <br/><br/>
        <br/>
        <br/>
        <br/>
      </div>
    </form>



  </body>
</html>
