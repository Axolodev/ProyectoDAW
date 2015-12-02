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

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        // Hacer login. Done.
        String op = request.getParameter("operacion");
        HttpSession session = request.getSession();
        String url = "/Login.jsp";
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
            } else if (op.equals("editaCandidato")) {
                String nombre = (String) session.getAttribute("nombre");
                String correo = request.getParameter("correo");
                String telefono = request.getParameter("telefono");
                String dir = request.getParameter("direccion");
                String carrera = request.getParameter("carrera");
                String cert = request.getParameter("certificados");
                String empresa = request.getParameter("empresa");
                String necEconom = request.getParameter("economico");

                // TODO: meter toda la info, creo que falta. 
                // Creo que tambien falta en el editaCandidato.jsp
                // no se como lo vayamos a manejar yet
                Candidato c = new Candidato();

                DBHandler.editaCandidato(c);

                url = "/Home.jsp";
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

                String nombre = (String) session.getAttribute("nombre");
                int idCandidato = Integer.valueOf(request.getParameter("idCandidato"));
                int idEntrevistador = Integer.valueOf(request.getParameter("idEntrevistador"));
                String fecha = request.getParameter("fecha");
                String plataforma = request.getParameter("plataforma");
                String feedback = request.getParameter("feedback");
                Date date = format.parse(fecha);
                Entrevista e = new Entrevista(idCandidato, idEntrevistador, date, plataforma, feedback);
                DBHandler.nuevaEntrevista(e);
                url = "/Home.jsp";

            } 
            
            else if (op.equals("nuevoCandidato")) {
                String nombre = (String) session.getAttribute("nombre");
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
                boolean inserta = DBHandler.nuevoCandidato(c);
                if(inserta){
                url = "/Home.jsp";
                }
                else{
                    url = "/nuevoCandidato.jsp";
                }
            } else if (op.equals("nuevoEmpleado")) {
                int idCand = (int) session.getAttribute("id");
                int salario = Integer.valueOf(request.getParameter("salario"));
                int vacaciones = Integer.valueOf(request.getParameter("vacaciones"));

                Empleado e = new Empleado(idCand, salario, vacaciones);
                DBHandler.nuevoEmpleado(e);
                url = "/Home.jsp";
            } else if (op.equals("logout")) {
                session.setAttribute("user", null);
            }
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
