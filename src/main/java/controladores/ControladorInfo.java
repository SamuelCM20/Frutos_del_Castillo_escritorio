/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author Jd
 */
import Modelo.Conexion;
import Modelo.Users;
import Modelo.Productos;
import Modelo.Compra;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorInfo {

    

    public int contar_num_usuarios() {
        int nUsuarios = 0;
        
        // almaceno resultado de consulta en ResultSet
        try(Conexion conex = new Conexion()) {
            Connection con = conex.getConectarDB();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM users JOIN model_has_roles ON users.id = model_has_roles.model_id JOIN roles ON model_has_roles.role_id = roles.id WHERE roles.name != 'usuario'");

            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                nUsuarios = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(e);
        }
        return nUsuarios;
    }

    public int contar_num_productos(){
        int nProductos = 0;
        
        // almaceno resultado de consulta en ResultSet
        try (Conexion conex = new Conexion()) {
            Connection con = conex.getConectarDB();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM productos");
            // chequeo que el result set no sea vacío, moviendo el cursor a la 
            // primer fila. (El cursor inicia antes de la primer fila)
            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                nProductos = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(e);
        }

        return nProductos;
    }

    public int contar_num_pedidos() {
        int nPedidos = 0;
        

        try (Conexion conex = new Conexion()){
            
            Connection con = conex.getConectarDB();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM compras WHERE estado = 1");
            // chequeo que el result set no sea vacío, moviendo el cursor a la 
            // primer fila. (El cursor inicia antes de la primer fila)
            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                nPedidos = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return nPedidos;
    }
    
     public int contar_num_mesas() {
        int nMesas = 0;
        

        try (Conexion conex = new Conexion()){
            
            Connection con = conex.getConectarDB();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM mesas");
            
            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                nMesas = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return nMesas;
    }
}
