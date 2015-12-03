/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProgAva
 */
public class DBHandler {

    public static Connection con = null;

    private static void createConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/javadb";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //<editor-fold desc="Candidatos">
    /**
     * editaCanadiato(Candidato cand) Funcion que realiza un update a la tabla
     * candidatos recibe de paramtero un candidato que se recibe de la interfaz
     * 
     * @param cand
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
            sql = "update candidato set "; 
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
     * @return 
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
            try (Statement st = con.createStatement()) {
                String sql;
                sql = "insert into candidato(nombre, email, telefono, direccion, "
                        + "puesto, estudios, universidad, "
                        + "titulo, certificados, experiencia, "
                        + "puestoAnterior, expectativaSalario)"  + " values(";
                sql += " '" + cand.getNombreCandidato() + "',";
                sql += " '" + cand.getEmailCandidato() + "',";
                sql += " '" + cand.getTelefono() + "',";
                sql += " '" + cand.getDireccion() + "',";
                sql += " '" + cand.getPuesto() + "',";
                sql += " '" + cand.getEstudios() + "',";
                sql += " '" + cand.getUniversidad() + "',";
                sql += " '" + cand.getTitulo() + "',";
                sql += " '" + cand.getCertificados() + "',";
                sql += " '" + cand.getTimeExpereince() + "',";
                sql += " '" + cand.getPuestoAnterior() + "',";
                sql += " '" + cand.getExpectativaSalario() + "')";
                st.execute(sql);
            }          

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            String telefono = results.getString(4);
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
    /**
     * manda llamar a las funciones actualizaTablaCandidato y actualizaTablaEmpleado
     * @param emp  recibe un objeto empleado
     */
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
    /**
     * actualizaTablaCandidato actualiza los datos de un empleado que se encuentren en la tabvla de candidato dado un id de empleado
     * @param emp 
     */
    public static void actualizaTablaCandidato(Empleado emp) {
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "update candidato set ";
            sql += "nombre=" + emp.getNombre() + ",";
            sql += "email=" + emp.getCorreo() + ",";
            sql += "telefono=" + emp.getTelefono() + ",";
            sql += "direccion=" + emp.getDireccion() + ",";
            sql += "puesto=" + emp.getPuesto() + ",";
            sql += "estudios=" + emp.getEstudios() + ",";
            sql += "universidad=" + emp.getUniversidad() + ",";
            sql += "titulo=" + emp.getTitulo() + ",";
            sql += "certificados=" + emp.getCertificados() + ",";
            sql += "where id = " + emp.getIdCandidato();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * actualiza los datos de un empleado dado un id de empleado
     * @param emp 
     */
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
    /**
     * nuevoempleado(emp)
     * agrega un nuevo empleado a la base de datos
     * realiza un link con la tabla de candidatos para no tener datos duplicados
     * @param emp 
     */
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
            sql = "insert into empleado (idCandidato,salario,diasVacaciones) values(";
            sql += emp.getIdCandidato() +",";
            sql += emp.getSalario() + ",";
            sql += emp.getDiasVacaciones() + ")";
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * despliega los datos de un empleado dado de parametro un id
     * @param id
     * @return 
     */
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

            emp.setNombre(nombre);
            emp.setCorreo(email);
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
    /**
     * borra un empleado de la base de datos dado su id
     * @param id 
     */
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
     * editaEntrevista(Entrevista ent) Funcion que realiza un update a la tabla
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
            sql = "update entrevista set "; 
            sql += "idCandidato=" + ent.getIdCandidato() + ",";
            sql += "idUsuario=" + ent.getIdUsuario() + ",";
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
     * nuevaEntrevista(Entrevista ent) funcion que inserta una entrevisat a la
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
            sql = "insert into entrevista(idCandidato,idEmpleado,fecha,plataforma,feedback) values(";
            sql += ent.getIdCandidato() + ",";
            sql += ent.getIdUsuario() + ",";
            sql += ent.getFecha() + ",";
            sql += "'" + ent.getPlataforma() + "',";
            sql += "'" + ent.getFeedback() + "')";
            st.executeUpdate(sql);
            st.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    /**
     * Dado un id, regresa el resto de los datos de la entrevista y los almacena en
     * una variable de tipo Entrevista
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

            ent = new Entrevista(idEntrevista, idCand, idEnt, nombreCand, nombreEnt, fecha, plataforma, feedback);

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ent;
    }
    /**
     * borraEntrevista(id) funcion qie borra un entrevista dado un id
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
    
    //<editor-fold desc="Reportes">
    public static Reporte reporte(String titulo,String universidad,String certificados,String nombreUsuario,String puesto) {
        Reporte rep = null;
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
            sql = "select a.nombre,a.titulo,a.universidad,a.certificados,"
                    + "c.nombre,a.puesto,(case when a.id in (select"
                    + " b.idCandidato from empleado) then 'empleado else candidato end)"
                    + " from candidato as a,empleado as b, usuario as c,entrevista as d"
                    + "where a.id=b.idCandidato and c.id=d.idUsuario";
            ResultSet results = st.executeQuery(sql);
            String nombre = results.getString(1);
            String tit = results.getString(2);
            String uni = results.getString(3);
            String cert = results.getString(4);
            String nombreEntrevistador = results.getString(5);
            String p = results.getString(6);
            String estatus = results.getString(7);
            
            rep = new Reporte(nombre,tit,uni,cert,nombreEntrevistador,p,estatus);

            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rep;
    }
    //</editor-fold>

    //<editor-fold desc="Usuario">
    /**
     * Funcion que realiza login
     * @param user
     * @param pass
     * @return 
     */
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
                    + "WHERE email = '" + user + "' AND password = '" + pass + "'");
            if (results.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    /**
     * actualiza password de usuario
     * @param email
     * @param password 
     */
    public static void changePassword(String email,String password)
    {
        if (con == null) {
            try {
                createConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            try (Statement statement = con.createStatement()) {
                String sql;
                sql = "update usuario set ";
                sql += "password ='" + password;
                sql += "' where email = '" + email + "'";
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }
    //</editor-fold>
}
