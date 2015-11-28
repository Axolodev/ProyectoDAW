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
public class Candidato {
    private int idCandidato;
    private String nombreCandidato;
    private String emailCandidato;
    private int telefono;
    private String direccion;
    private String puesto;
    private String estudios;
    private String universidad;
    private String titulo;
    private String certificados;
    private int timeExpereince;
    private String puestoAnterior;
    private int expectativaSalario;

    public Candidato(int idCandidato, String nombreCandidato, String emailCandidato, int telefono, String direccion, String puesto, String estudios, String universidad, String titulo, String certificados, int timeExpereince, String puestoAnterior, int expectativaSalario) {
        this.idCandidato = idCandidato;
        this.nombreCandidato = nombreCandidato;
        this.emailCandidato = emailCandidato;
        this.telefono = telefono;
        this.direccion = direccion;
        this.puesto = puesto;
        this.estudios = estudios;
        this.universidad = universidad;
        this.titulo = titulo;
        this.certificados = certificados;
        this.timeExpereince = timeExpereince;
        this.puestoAnterior = puestoAnterior;
        this.expectativaSalario = expectativaSalario;
    }

    public Candidato() {
    }
    

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    public int getTimeExpereince() {
        return timeExpereince;
    }

    public void setTimeExpereince(int timeExpereince) {
        this.timeExpereince = timeExpereince;
    }

    public String getPuestoAnterior() {
        return puestoAnterior;
    }

    public void setPuestoAnterior(String puestoAnterior) {
        this.puestoAnterior = puestoAnterior;
    }

    public int getExpectativaSalario() {
        return expectativaSalario;
    }

    public void setExpectativaSalario(int expectativaSalario) {
        this.expectativaSalario = expectativaSalario;
    }
    
    
    
    
}
