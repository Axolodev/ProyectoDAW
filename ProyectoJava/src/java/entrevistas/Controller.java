/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
            throws ServletException, IOException, SQLException {
        
        String op = request.getParameter("operacion");
        HttpSession session = request.getSession();
        String url = "/login.jsp";        
        if (op.equals("login")) {
            String usuario = request.getParameter("email");
            String pass = request.getParameter("password");
            if(usuario != null && pass != null){
                boolean b = DBHandler.getUser(usuario, pass);
                if (b) {
                    url = "/home.jsp";
                    session.setAttribute("user", usuario);
                }
            }
        } else if(session.getAttribute("user") != null){
            if (op.equals("compose")) {
                url = "/envio.jsp";
            } else if (op.equals("read")) {
                String para = (String) session.getAttribute("user");
                ArrayList lista = DBHandler.getMessages(para);
                if (lista.isEmpty()) {
                    url = "/nomensajes.jsp";
                } else {
                    request.setAttribute("lista", lista);
                    url = "/ver.jsp";
                }
            } else if (op.equals("enviar")) {
                String de = (String) session.getAttribute("user");
                String para = request.getParameter("para");
                String contenido = request.getParameter("contenido");
                Mensaje m = new Mensaje(de, para, contenido);
                DBHandler.storeMessage(m);
                url = "/inicio.jsp";
            }else if (op.equals("logout")) {
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
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
