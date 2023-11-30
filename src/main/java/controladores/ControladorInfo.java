/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author SENA
 */

import Modelo.Conexion;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorInfo {
    Conexion conex = new Conexion();
    
    
    
    public int contar_num_usuarios() throws SQLException{ 
     int n= 0;
     Connection con = conex.getConectarDB();
     Statement stm = con.createStatement();
     // almaceno resultado de consulta en ResultSet
     ResultSet rs  = stm.executeQuery("SELECT count(*) FROM users");
     // chequeo que el result set no sea vacío, moviendo el cursor a la 
     // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        n= rs.getInt(1);
     }
     // libero recursos
     stm.close();
     con.close();
     return n;
}
    
}
