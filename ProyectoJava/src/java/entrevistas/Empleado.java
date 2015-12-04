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
import entrevistas.Candidato;
public class Empleado {             
       
    private int idEmpleado;
    private int idCandidato;
    private String nombre;
    private String correo;
    private int telefono;
    private String direccion;
    private String puesto;
    private String titulo;
    private String universidad;
    private String estudios;
    private String certificados;
    private double salario;
    private int diasVacaciones;

    public Empleado(int idEmpleado, int idCandidato, String nombre, String correo, int telefono, String direccion, String puesto, String titulo, String universidad, String estudios, String certificados, double salario, int diasVacaciones) {
        this.idEmpleado = idEmpleado;
        this.idCandidato = idCandidato;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.puesto = puesto;
        this.titulo = titulo;
        this.universidad = universidad;
        this.estudios = estudios;
        this.certificados = certificados;
        this.salario = salario;
        this.diasVacaciones = diasVacaciones;
    }

    public Empleado(int idCandidato, double salario, int diasVacaciones) {
        this.idCandidato = idCandidato;
        this.salario = salario;
        this.diasVacaciones = diasVacaciones;
    }
    
    
    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

     public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getCertificados() {
        return certificados;
    }

    public void setCertificados(String certificados) {
        this.certificados = certificados;
    }

    
}
