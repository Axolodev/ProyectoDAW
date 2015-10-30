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
import java.util.Date;
public class Entrevista {
    private String nombreCandidato;
    private String nombreEntrevistador;
    private String puestoCandidato;
    private Date fechaEntrevista;
    private String plataforma;
    private String feedback;
    
    public Entrevista()
    {
        nombreCandidato = "";
        nombreEntrevistador = "";
        puestoCandidato = "";
        fechaEntrevista = null;
        plataforma = "";
        feedback = "";
    }
    public Entrevista(String nC, String nE,String pC,Date fE, String p, String f)
    {
        nombreCandidato = nC;
        nombreEntrevistador = nE;
        puestoCandidato = pC;
        fechaEntrevista = fE;
        plataforma = p;
        feedback = f;
    }
    public void setNombreCandidato(String nC)
    {
        nombreCandidato = nC;
    }
    public void setNombreEntrevistador(String nE)
    {
        nombreEntrevistador = nE;
    }
    public void setPuestoCandidato(String pC)
    {
        puestoCandidato = pC;
    }
    public void setFechaEntrevista(Date fE)
    {
        fechaEntrevista = fE;
    }
    public void setPlataforma(String p)
    {
        plataforma = p;
    }
    public void setFeedback(String f)
    {
        feedback = f;
    }
    public String getNombreCandidato()
    {
        return nombreCandidato;
    }
    public String getNombreEntrevistador()
    {
        return nombreEntrevistador;
    }
    public String getPuestoCandidato()
    {
        return puestoCandidato;
    }
    public Date getFechaEntrevista()
    {
        return fechaEntrevista;
    }
    public String getPlataforma()
    {
        return plataforma;
    }
    public String getFeedback()
    {
        return feedback;
    }
}
