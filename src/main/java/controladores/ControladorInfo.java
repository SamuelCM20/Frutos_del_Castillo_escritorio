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
import Modelo.Productos;
import Modelo.Mesas;
import Modelo.Reservas;
import Modelo.Compra;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorInfo {
    Conexion conex = new Conexion();
    
    
    
    public int contar_num_usuarios() throws SQLException{ 
     int nUsuarios= 0;
     Connection con = conex.getConectarDB();
     Statement stm = con.createStatement();
     // almaceno resultado de consulta en ResultSet
     ResultSet rs  = stm.executeQuery("SELECT count(*) FROM users");
     // chequeo que el result set no sea vacío, moviendo el cursor a la 
     // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        nUsuarios= rs.getInt(1);
     }
     // libero recursos
     stm.close();
     con.close();
     return nUsuarios;
}
    
    public int contar_num_productos() throws SQLException{ 
     int nProductos= 0;
     Connection con = conex.getConectarDB();
     Statement stm = con.createStatement();
     // almaceno resultado de consulta en ResultSet
     ResultSet rs  = stm.executeQuery("SELECT count(*) FROM productos");
     // chequeo que el result set no sea vacío, moviendo el cursor a la 
     // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        nProductos= rs.getInt(1);
     }
     // libero recursos
     stm.close();
     con.close();
     return nProductos;
}
    
    public int contar_num_reservas() throws SQLException{ 
     int nReservas= 0;
     Connection con = conex.getConectarDB();
     Statement stm = con.createStatement();
     // almaceno resultado de consulta en ResultSet
     ResultSet rs  = stm.executeQuery("SELECT count(*) FROM reservas");
     // chequeo que el result set no sea vacío, moviendo el cursor a la 
     // primer fila. (El cursor inicia antes de la primer fila)
     if(rs.next()) {
       //Si hay resultados obtengo el valor. 
        nReservas= rs.getInt(1);
     }
     // libero recursos
     stm.close();
     con.close();
     return nReservas;
}
    
}
