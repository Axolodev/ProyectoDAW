/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buissiness;


import buissiness.Candidato;
import buissiness.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/**
 *
 * @author ProgAva
 */
public class DBHandler {
    static Connection con=null;

    public DBHandler() {
        try {
            String url ="jdbc:mysql://localhost/JavaDB";
            con=DriverManager.getConnection(url, "root","");
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void editaCandidato(Candidato cand) {
        try {
            
            Statement st = con.createStatement();
            String sql;
            sql = "update candidato set "; // Where id is x ?
            sql += "nombre=" + cand.getNomCandidato() + ",";
            sql += "email=" + cand.getEmail() + ",";
            sql += "telefono=" + cand.getTelefono()+ ",";
            sql += "direccion=" + cand.getDireccion() + ",";
            sql += "puesto=" + cand.getPuestoCandidato() + ",";
            sql += "estudios=" + cand.getEstudios() + ",";
            sql += "universidad=" + cand.getUniversidad() + ",";
            sql += "titulo=" + cand.getTitulo() + ",";
            sql += "certificados=" + cand.getCertificados() + ",";
            sql += "experiencia=" + cand.getExperiencia() + ",";
            sql += "puestoAnterior=" + cand.getPuestoAnterior() + ",";
            sql += "expectativaSalario=" + cand.getExpectativaSalario() + ",";
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void editaEmpleado (Empleado emp) {
        try {
            
            Statement st = con.createStatement();
            String sql;
            sql = "update empleado set "; // Where id is x ?
            //sql += "nombre=" + cand.nomCandidato + ","; falta nombre?
            sql += "salario=" + emp.getSalario() + ",";
            sql += "diasVacaciones=" + emp.getDiasVacaciones() + ",";
            st.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertar(String de, String para, String contenido){
        try {
            Statement st=con.createStatement();
            String sql;
            sql="insert into mensajes (de, para, contenido) values('";
            sql+=de+"', '"+para+"', '"+contenido+"')";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void nuevaEntrevista (Empleado emp) {
        try {
            
            Statement st = con.createStatement();
            String sql;
            sql = "insert into entrevista "; // Where id is x ?
            //sql += "nombre=" + cand.nomCandidato + ","; falta nombre?
            sql += "salario=" + emp.getSalario() + ",";
            sql += "diasVacaciones=" + emp.getDiasVacaciones() + ",";
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
