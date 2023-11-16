/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;

/**
 *
 * @author samue
 */
public class Login {
    
    Conexion conex = new Conexion();
    Connection con = conex.getConectarDB();

   
    private int idUsuario;
    private String contrasenia;
    

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getContrasenia() {
        return contrasenia;
    }
            
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    

   

   
}

    
