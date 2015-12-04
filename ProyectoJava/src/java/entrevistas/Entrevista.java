/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

/**
 *
 * @author Adriana
 */
import java.util.Date;

public class Entrevista {

    private int idEntrevista;
    private int idCandidato;
    private int idUsuario;
    private String nombreCandidato;
    private String nombreEntrevistador;
    private Date fecha;
    private String plataforma;
    private String feedback;

    public Entrevista(int idEntrevista, String nombreCandidato, String nombreEntrevistador, Date fecha, String plataforma, String feedback) {
        this.idEntrevista = idEntrevista;
        this.nombreCandidato = nombreCandidato;
        this.nombreEntrevistador = nombreEntrevistador;
        this.fecha = fecha;
        this.plataforma = plataforma;
        this.feedback = feedback;
    }

    public Entrevista(int idCandidato, int idUsuario, Date fecha, String plataforma, String feedback) {
        this.idCandidato = idCandidato;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.plataforma = plataforma;
        this.feedback = feedback;
    }
    
    public Entrevista(int idEntrevista, int idCandidato, int idUsuario, String nombreCandidato, String nombreEntrevistador, Date fecha, String plataforma, String feedback) {
        this.idEntrevista = idEntrevista;
        this.idCandidato = idCandidato;
        this.idUsuario = idUsuario;
        this.nombreCandidato = nombreCandidato;
        this.nombreEntrevistador = nombreEntrevistador;
        this.fecha = fecha;
        this.plataforma = plataforma;
        this.feedback = feedback;
    }

    
    public int getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(int idEntrevista) {
        this.idEntrevista = idEntrevista;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getNombreEntrevistador() {
        return nombreEntrevistador;
    }

    public void setNombreEntrevistador(String nombreEntrevistador) {
        this.nombreEntrevistador = nombreEntrevistador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    
}
