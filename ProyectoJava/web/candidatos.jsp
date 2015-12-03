<%@page contentType="text/html; charset=UTF-8"%><% 
if (session.getAttribute("user") != null) {
    String a= request.getParameter("operacion");
    if (a.equals("editar")){
        out.print("Editar");
    } else {
        out.print("Borrar");
    }
} %>