/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ProgAva
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-17", Locale.ENGLISH);

        // Hacer login. Done.
        String op = request.getParameter("operacion");
        HttpSession session = request.getSession();
        String url = "/Login.jsp";
        System.out.println(op);
        if (op.equals("login")) {
            String usuario = request.getParameter("email");
            String pass = request.getParameter("pass");
            if (usuario != null && pass != null) {
                boolean b = DBHandler.getUser(usuario, pass);
                if (b) {
                    url = "/Home.jsp";
                    session.setAttribute("user", usuario);
                }
            }
        } else if (session.getAttribute("user") != null) {
            if (op.equals("home")) {
                url = "/Home.jsp";

                // TODO: editar de acuerdo a la tabla.
            } else if (op.equals("editaEmpleado")) {

                int idEmpleado = Integer.valueOf(request.getParameter("idEmpleado"));
                int idCandidato = Integer.valueOf(request.getParameter("idCandidato"));
                String nombre = (String) session.getAttribute("nombre");
                String correo = request.getParameter("correo");
                int telefono = Integer.valueOf(request.getParameter("telefono"));
                String dir = request.getParameter("direccion");
                String puesto = request.getParameter("puesto");
                String estudios = request.getParameter("estudios");
                String universidad = request.getParameter("universidad");
                String titulo = request.getParameter("titulo");
                String cert = request.getParameter("certificados");
                double salario = Integer.valueOf(request.getParameter("salario"));
                int diasVacaciones = Integer.valueOf(request.getParameter("diasVacaciones"));

                // TODO: meter toda la info, creo que falta
                Empleado e = new Empleado(idEmpleado, idCandidato, nombre, correo, telefono, dir, puesto, titulo, universidad, estudios, cert, salario, diasVacaciones);

                DBHandler.editaEmpleado(e);

                url = "/Home.jsp";
            } else if (op.equals("nuevaEntrevista")) {
                int idCandidato = Integer.valueOf(request.getParameter("idCandidato"));
                int idEntrevistador = Integer.valueOf(request.getParameter("idEntrevistador"));
                String fecha = request.getParameter("fechaEntrevista");
                String plataforma = request.getParameter("plataforma");
                String feedback = request.getParameter("feedback");
                System.out.println(fecha);
                Date date = format.parse(fecha);
                Entrevista e = new Entrevista(idCandidato, idEntrevistador, date, plataforma, feedback);
                DBHandler.nuevaEntrevista(e);
                url = "/Home.jsp";

            } else if (op.equals("nuevoCandidato")) {

                String nombreC = request.getParameter("nombre");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("email");
                String dir = request.getParameter("direccion");
                String puesto = request.getParameter("puestoAct");
                String estudios = request.getParameter("estudios");
                String titulo = request.getParameter("titulo");
                String uni = request.getParameter("universidad");
                String cert = request.getParameter("cert");
                int exp = Integer.parseInt(request.getParameter("experiencia"));
                String trabAnt = request.getParameter("trabajoAnt");
                int salario = Integer.parseInt(request.getParameter("salario"));
                Candidato c = new Candidato(nombreC, correo, telefono, dir, puesto, estudios, uni, titulo, cert, exp, trabAnt, salario);
                DBHandler.nuevoCandidato(c);
                url = "/Home.jsp";
            } else if (op.equals("nuevoEmpleado")) {
                int idCand = Integer.valueOf(request.getParameter("id"));
                int salario = Integer.valueOf(request.getParameter("salario"));
                int vacaciones = Integer.valueOf(request.getParameter("vacaciones"));

                Empleado e = new Empleado(idCand, salario, vacaciones);
                DBHandler.nuevoEmpleado(e);
                url = "/Home.jsp";
            } else if (op.equals("logout")) {
                session.setAttribute("user", null);
                url = "/Login.jsp";
            } else if (op.equals("configuracion")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                DBHandler.changePassword(email, password);
                url = "/Home.jsp";
            } else if (op.equals("dameCandidatos")) {
                ArrayList<Candidato> al = DBHandler.dameCandidatos();
                request.setAttribute("lista", al);
                url = "/editaCandidato.jsp";
            }
        }
        if (op.equals("editaCandidato")) {
            int idCandidato = Integer.valueOf(request.getParameter("idCandidato"));
            
            String nombreC = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("email");
            String dir = request.getParameter("direccion");
            String puesto = request.getParameter("puestoAct");
            String estudios = request.getParameter("estudios");
            String titulo = request.getParameter("titulo");
            String uni = request.getParameter("universidad");
            String cert = request.getParameter("cert");
            int exp = Integer.valueOf(request.getParameter("experiencia"));
            String trabAnt = request.getParameter("trabajoAnt");
            int salario = Integer.valueOf(request.getParameter("salario"));
            Candidato c = new Candidato(idCandidato, nombreC, correo, telefono, dir, puesto, estudios, uni, titulo, cert, exp, trabAnt, salario);

            DBHandler.editaCandidato(c);

            url = "/candidatos.jsp?operacion=editar";
        } else if(op.equals("borrarCandidato")){
            int id = Integer.valueOf(request.getParameter("idCandidato"));
            DBHandler.borraCandidato(id);
            url = "/candidatos.jsp?operacion=borrar";
        }
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
