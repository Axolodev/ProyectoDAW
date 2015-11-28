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
public class Empleado extends Candidato{
    private int idEmpleado;
    private double salario;
    private int diasVacaciones;

    public Empleado(int idCandidato, String nombreCandidato, String emailCandidato, int telefono, String direccion, String puesto, String estudios, String universidad, String titulo, String certificados, int timeExpereince, String puestoAnterior, int expectativaSalario) {
        super(idCandidato, nombreCandidato, emailCandidato, telefono, direccion, puesto, estudios, universidad, titulo, certificados, timeExpereince, puestoAnterior, expectativaSalario);
    }
    
    public Empleado(int idEmpleado, double salario, int diasVacaciones) {
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.diasVacaciones = diasVacaciones;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
    
    
    
}
