/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

/**
 *
 * @author Adriana
 */
import java.io.*;
import buissiness.Entrevista;
public class EntrevistaIO {
        public static void add(Entrevista entrevista, String filepath) throws IOException
    {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file,true));
        out.println(entrevista.getNombreCandidato()+"|"+entrevista.getNombreEntrevistador()
        +"|"+entrevista.getPuestoCandidato()+"|"+entrevista.getFechaEntrevista()+"|"+
                entrevista.getPlataforma()+"|"+entrevista.getFeedback());
        out.close();
    }
}
