/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrevistas;

/**
 *
 * @author Juan Nolazco
 */
public class Reporte {
    String nombreCandidato;
    String titulo;
    String universidad;
    String certificados;
    String nombreEntrevistador;
    String puesto;
    String estatus;

    public Reporte(String nombreCandidato, String titulo, String universidad, String certificados, String nombreEntrevistador, String puesto, String estatus) {
        this.nombreCandidato = nombreCandidato;
        this.titulo = titulo;
        this.universidad = universidad;
        this.certificados = certificados;
        this.nombreEntrevistador = nombreEntrevistador;
        this.puesto = puesto;
        this.estatus = estatus;
    }
    
    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    public String getNombreEntrevistador() {
        return nombreEntrevistador;
    }

    public void setNombreEntrevistador(String nombreEntrevistador) {
        this.nombreEntrevistador = nombreEntrevistador;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
