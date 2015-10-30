/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author Adriana,Mayra y Roberto
 */

import java.io.*;
import buissiness.Empleado;
public class EmpleadoIO {
    public static void add(Empleado empleado, String filepath) throws IOException
    {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file,true));
        out.println(empleado.getNombreEmpleado() + "|" + empleado.getPuestoEmpleado()
        +"|" + empleado.getSalario() + "|" + empleado.getDiasVacaciones());
        out.close();
    }

}
