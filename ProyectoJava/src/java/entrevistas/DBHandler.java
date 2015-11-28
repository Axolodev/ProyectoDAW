/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

import entrevistas.Candidato;
import entrevistas.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/**
 *
 * @author ProgAva
 */
public class DBHandler {

    public static Connection con = null;

    private static void createConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/JavaDB";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //<editor-fold desc="Candidatos">
    /**
     * editaCanadiato(Candidato cand) Funcion que realiza un update a la tabla
     * candidatos recibe de paramtero un candidato que se recibe de la interfaz
     */
    public static void editaCandidato(Candidato cand) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {

            Statement st = con.createStatement();
            String sql;
            sql = "update candidato set "; // Where id is x ?
            sql += "nombre=" + cand.getNombreCandidato() + ",";
            sql += "email=" + cand.getEmailCandidato() + ",";
            sql += "telefono=" + cand.getTelefono() + ",";
            sql += "direccion=" + cand.getDireccion() + ",";
            sql += "puesto=" + cand.getPuesto() + ",";
            sql += "estudios=" + cand.getEstudios() + ",";
            sql += "universidad=" + cand.getUniversidad() + ",";
            sql += "titulo=" + cand.getTitulo() + ",";
            sql += "certificados=" + cand.getCertificados() + ",";
            sql += "experiencia=" + cand.getTimeExpereince() + ",";
            sql += "puestoAnterior=" + cand.getPuestoAnterior() + ",";
            sql += "expectativaSalario=" + cand.getExpectativaSalario() + ",";
            sql += "where id = " + cand.getIdCandidato();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * nuevoCandidato(Candidato cand) funcion que inserta un candidato a la
     * tabla candidato
     *
     * @param cand
     */
    public static void nuevoCandidato(Candidato cand) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            int id = getMaxIdCandidato();
            sql = "insert into candidato values(";
            sql += "id = " + id;
            sql += "nombre=" + cand.getNombreCandidato() + ",";
            sql += "email=" + cand.getEmailCandidato() + ",";
            sql += "telefono=" + cand.getTelefono() + ",";
            sql += "direccion=" + cand.getDireccion() + ",";
            sql += "puesto=" + cand.getPuesto() + ",";
            sql += "estudios=" + cand.getEstudios() + ",";
            sql += "universidad=" + cand.getUniversidad() + ",";
            sql += "titulo=" + cand.getTitulo() + ",";
            sql += "certificados=" + cand.getCertificados() + ",";
            sql += "experiencia=" + cand.getTimeExpereince() + ",";
            sql += "puestoAnterior=" + cand.getPuestoAnterior() + ",";
            sql += "expectativaSalario=" + cand.getExpectativaSalario() + ")";
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * getMaxIdCandidato() calcula el id máximo exixstente en la tabla le suma
     * uno, y regresa el id que debe ser insertado
     *
     * @return int
     */
    public static int getMaxIdCandidato() {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int id = 0;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select count(*) from candidato";
            ResultSet results = st.executeQuery(sql);
            id = results.getInt(1) + 1;
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Dado un id, regresa el resto de los datos del candidato y los almacena en
     * una variable de tipo Candidato
     *
     * @param id
     * @return Candidato
     */
    public static Candidato verCandidato(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Candidato cand = null;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select * from candidato where id = " + id;
            ResultSet results = st.executeQuery(sql);
            int idCandidato = results.getInt(1);
            String nombre = results.getString(2);
            String email = results.getString(3);
            int telefono = results.getInt(4);
            String direccion = results.getString(5);
            String puesto = results.getString(6);
            String estudios = results.getString(7);
            String universidad = results.getString(8);
            String titulo = results.getString(9);
            String certificados = results.getString(10);
            int experiencia = results.getInt(11);
            String puestoAnterior = results.getString(12);
            int expectativaSalario = results.getInt(13);

            cand = new Candidato(idCandidato, nombre, email,
                    telefono, direccion, puesto, estudios, universidad, titulo,
                    certificados, experiencia, puestoAnterior, expectativaSalario);

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cand;
    }

    /**
     * borraCandidatos(id) funcion qie borra un candidato dado un id
     *
     * @param id
     */
    public static void borraCandidato(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "delete from candidato where id = " + id;
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//</editor-fold>

    //<editor-fold desc="Empleados">
    public static void editaEmpleado(Empleado emp) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        actualizaTablaCandidato(emp);
        actualizaTablaEmpleado(emp);
    }

    public static void actualizaTablaCandidato(Empleado emp) {
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "update candidato set ";
            sql += "nombre=" + emp.getNombreCandidato() + ",";
            sql += "email=" + emp.getEmailCandidato() + ",";
            sql += "telefono=" + emp.getTelefono() + ",";
            sql += "direccion=" + emp.getDireccion() + ",";
            sql += "puesto=" + emp.getPuesto() + ",";
            sql += "estudios=" + emp.getEstudios() + ",";
            sql += "universidad=" + emp.getUniversidad() + ",";
            sql += "titulo=" + emp.getTitulo() + ",";
            sql += "certificados=" + emp.getCertificados() + ",";
            sql += "experiencia=" + emp.getTimeExpereince() + ",";
            sql += "puestoAnterior=" + emp.getPuestoAnterior() + ",";
            sql += "expectativaSalario=" + emp.getExpectativaSalario() + ",";
            sql += "where id = " + emp.getIdCandidato();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void actualizaTablaEmpleado(Empleado emp) {
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "update empleado set ";
            sql += "id=" + emp.getIdEmpleado() + ",";
            sql += "salario=" + emp.getSalario() + ",";
            sql += "diasVacaciones=" + emp.getDiasVacaciones() + ",";
            sql += "where id = " + emp.getIdEmpleado();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void nuevoEmpleado(Empleado emp) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            int id = getMaxIdEmpleado();
            sql = "update empleado set ";
            sql += "id=" + id + ",";
            sql += "idCandidato = " + emp.getIdCandidato();
            sql += "salario=" + emp.getSalario() + ",";
            sql += "diasVacaciones=" + emp.getDiasVacaciones() + ",";
            sql += "where id = " + emp.getIdEmpleado();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getMaxIdEmpleado() {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int id = 0;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select count(*) from empleado";
            ResultSet results = st.executeQuery(sql);
            id = results.getInt(1) + 1;
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static Empleado verEmpleado(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Empleado emp = null;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select a.nombre,a.email,a.telefono,a.direccion,"
                    + "a.puesto,a.estudios,a.universidad,a.titulo,a.certificados,"
                    + "a.experiencia,b.salario,b.diasVacaciones from candidato"
                    + " as a,empleado as b where id = " + id
                    + "a.id = b.idCandidato";
            ResultSet results = st.executeQuery(sql);
            String nombre = results.getString(1);
            String email = results.getString(2);
            int telefono = results.getInt(3);
            String direccion = results.getString(4);
            String titulo = results.getString(5);
            String universidad = results.getString(6);
            String certificados = results.getString(7);
            String puesto = results.getString(8);
            int salario = results.getInt(9);
            int diasVacaciones = results.getInt(10);

            emp.setNombreCandidato(nombre);
            emp.setEmailCandidato(email);
            emp.setTelefono(telefono);
            emp.setDireccion(direccion);
            emp.setTitulo(titulo);
            emp.setUniversidad(universidad);
            emp.setCertificados(certificados);
            emp.setPuesto(puesto);
            emp.setSalario(salario);
            emp.setDiasVacaciones(diasVacaciones);

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }

    public static void borraEmpleado(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "delete from empleado where id = " + id;
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //</editor-fold>
    
    //<editor-fold desc="Entrevistas">
    /**
     * editaCanadiato(Candidato cand) Funcion que realiza un update a la tabla
     * candidatos recibe de paramtero un candidato que se recibe de la interfaz
     */
    public static void editaEntrevista(Entrevista ent) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {

            Statement st = con.createStatement();
            String sql;
            sql = "update candidato set "; // Where id is x ?
            sql += "idCandidato=" + ent.getIdCandidato() + ",";
            sql += "idUsuario=" + ent.getIdUsuario()+ ",";
            sql += "plataforma=" + ent.getPlataforma() + ",";
            sql += "fecha=" + ent.getFecha() + ",";
            sql += "feedback=" + ent.getFeedback() + ",";
            sql += "where id = " + ent.getIdEntrevista();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * nuevoCandidato(Candidato cand) funcion que inserta un candidato a la
     * tabla candidato
     *
     * @param cand
     */
    public static void nuevaEntrevista(Entrevista ent) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            int id = getMaxIdEntrevista();
            sql = "insert into entrevista values(";
            sql += "id = " + id;
            sql += "idCandidato=" + ent.getIdCandidato() + ",";
            sql += "idUsuario=" + ent.getIdUsuario() + ",";
            sql += "fecha=" + ent.getFecha() + ",";
            sql += "plataforma=" + ent.getPlataforma() + ",";
            sql += "feedback=" + ent.getFeedback();
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * getMaxIdCandidato() calcula el id máximo exixstente en la tabla le suma
     * uno, y regresa el id que debe ser insertado
     *
     * @return int
     */
    public static int getMaxIdEntrevista() {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int id = 0;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select count(*) from entrevista";
            ResultSet results = st.executeQuery(sql);
            id = results.getInt(1) + 1;
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * Dado un id, regresa el resto de los datos del candidato y los almacena en
     * una variable de tipo Candidato
     *
     * @param id
     * @return Candidato
     */
    public static Entrevista verEntrevista(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Entrevista ent = null;
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "Select a.id,a.nombre,b.id,b.nombre,c.fecha,c.plataforma,c.feedback,c.id"
                    + "from candidato as a,usuario as b,entrevista as c"
                    + " where id = " + id + "and c.idCandidato = a.id and c.idUsuario = b.id";
            ResultSet results = st.executeQuery(sql);
            int idCand = results.getInt(1);
            String nombreCand = results.getString(2);
            int idEnt = results.getInt(3);
            String nombreEnt = results.getString(4);
            Date fecha = results.getDate(5);
            String plataforma = results.getString(6);
            String feedback = results.getString(7);
            int idEntrevista = results.getInt(8);
            
            ent = new Entrevista(idEntrevista,idCand,idEnt,nombreCand,nombreEnt,fecha,plataforma,feedback);
          

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ent;
    }

    /**
     * borraCandidatos(id) funcion qie borra un candidato dado un id
     *
     * @param id
     */
    public static void borraEntrevista(int id) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "delete from entrevista where id = " + id;
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>
    
    public static boolean getUser(String user, String pass) {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM usuario "
                    + "WHERE email = '" + user + "' AND password = '"+ pass + "'");
            if(results.next()){
                return true;
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
