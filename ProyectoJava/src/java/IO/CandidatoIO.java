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
import buissiness.Candidato;
public class CandidatoIO {
    public static void add(Candidato candidato, String filepath) throws IOException
    {
        File file = new File(filepath);
        PrintWriter out = new PrintWriter(new FileWriter(file,true));
        out.println(candidato.getNomCandidato()+"|"+candidato.getEmail()+
                "|"+candidato.getTelefono()+"|" 
                + candidato.getPuestoCandidato()+"|"+ candidato.getDireccion()+"|"+
                candidato.getTitulo()+"|"+candidato.getUniversidad()+"|"+
                candidato.getCertificados()+"|"+candidato.getTrabajoAnterior()+
                "|"+ candidato.getPuestoAnterior()+"|"+candidato.getExpectativaSalario());
        out.close();
    }

}
