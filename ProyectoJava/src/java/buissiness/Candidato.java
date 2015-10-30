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
public class Candidato {
    private int id;
    private String nomCandidato;
    private String email;
    private String puestoCandidato;
    private double telefono;
    private String direccion;
    private String titulo;
    private String universidad;
    private String certificados[];
    private String trabajoAnterior;
    private double expectativaSalario;
    private String puestoAnterior;
    
    public Candidato()
    {
        nomCandidato = "";
        email = "";
        puestoCandidato = "";
        telefono = 0;
        direccion = "";
        titulo = "";
        universidad = "";
        for (int i = 0; i< certificados.length; i++)
        {
            certificados[i] = "";
        }
        trabajoAnterior = "";
        expectativaSalario = 0;
        puestoAnterior = "";
    }
     public Candidato(String nom,String correo,String puesto, double tel,String dir, String tit, String uni, String cert[],String traAnt, double sal, String puestAnt)
    {
        nomCandidato = nom;
        email = correo ;
        puestoCandidato = puesto;
        telefono = tel;
        direccion = dir;
        titulo = tit;
        universidad = uni;
        for (int i = 0; i< cert.length; i++)
        {
            certificados[i] = cert[i];
        }
        trabajoAnterior = traAnt;
        expectativaSalario = sal;
        puestoAnterior = puestAnt;
    }
     public void setNomCandidato(String nom)
     {
         nomCandidato = nom;
     }
     public void setEmail(String correo)
     {
         email = correo;
     }
     public void setPuestoCandidato(String puesto)
     {
         puestoCandidato = puesto;
     }
     public void setTelefono(double tel)
     {
         telefono = tel;
     }
     public void setDireccion(String dir)
     {
         direccion = dir;
     }
     public void setTitulo(String tit)
     {
         titulo = tit;
     }
     public void setUniversidad(String uni)
     {
         universidad = uni;
     }
     public void setCertificados(String cert[])
     {
         for(int i = 0; i < cert.length; i++)
         {
             certificados[i] = cert[i];
         }
     }
     public void setTrabajoAnterior(String traAnt)
     {
         trabajoAnterior = traAnt;
     }
     public void setExpectativaSalario(double sal)
     {
         expectativaSalario = sal;
     }
     public void setPuestoAnterior(String puestAnt)
     {
         puestoAnterior = puestAnt;
     }
     public String getNomCandidato()
     {
         return nomCandidato;
     }
     public String getEmail()
     {
         return email;
     }
     public String getPuestoCandidato()
     {
         return puestoCandidato;
    
}
     public double getTelefono()
     {
         return telefono;
     }
     public String getDireccion()
     {
         return direccion;
     }
     public String getTitulo()
     {
         return titulo;
     }
     public String getUniversidad()
     {
         return universidad;
     }
     public String[] getCertificados()
     {
        return certificados;
     }
     public String getTrabajoAnterior()
     {
         return trabajoAnterior;
     }
     public double getExpectativaSalario()
     {
         return expectativaSalario;
     }
     public String getPuestoAnterior()
     {
         return puestoAnterior;
     }
}
     
