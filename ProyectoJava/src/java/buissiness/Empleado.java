/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buissiness;

/**
 *
 * @author Adriana
 */
import buissiness.Candidato;
public class Empleado {
    private String nombreEmpleado;
    private String puestoEmpleado;
    private double salario;
    private int diasVacaciones;
    
    public Empleado()
    {
        nombreEmpleado = "";
        puestoEmpleado = "";
        salario = 0;
        diasVacaciones = 0;
    }
    public Empleado(String nom, String puesto, double sal, int vac)
    {
        nombreEmpleado = nom;
        puestoEmpleado = puesto;
        salario = sal;
        diasVacaciones = vac;
    }
    public void setNombreEmpleado(String nom)
    {
        nombreEmpleado = nom;
    }
    public void setPuestoEmpleado(String puesto)
    {
        puestoEmpleado = puesto;
    }
    public void setSalario(double sal)
    {
        salario = sal;
    }
    public void setDiasVacaciones(int vac)
    {
        diasVacaciones = vac;
    }
    public String getNombreEmpleado()
    {
        return nombreEmpleado;
    }
    public String getPuestoEmpleado()
    {
        return puestoEmpleado;
    }
    public double getSalario()
    {
        return salario;
    }
    public int getDiasVacaciones()
    {
        return diasVacaciones;
    }
    
}
