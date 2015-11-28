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
public class Usuario {
    private String username;
    private String password;
    
    public Usuario()
    {
        username = "";
        password = "";
    }
    public Usuario(String u, String p)
    {
        username = u;
        password = p;
    }
    public void setUsername(String u)
    {
        username = u;
    }
    public void setPassword(String p)
    {
        password = p;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    
}
