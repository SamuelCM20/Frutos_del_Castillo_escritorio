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
import Modelo.Users;
import Modelo.Productos;
import Modelo.Mesas;
import Modelo.Compra;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorInfo {

    Conexion conex = new Conexion();

    public int contar_num_usuarios() throws SQLException {
        int nUsuarios = 0;
        Connection con = conex.getConectarDB();
        Statement stm = con.createStatement();
        // almaceno resultado de consulta en ResultSet
        try {
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM users");

            if (rs.next()) {
                //Si hay resultados obtengo el valor. 
                nUsuarios = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(e);
        }
        return nUsuarios;
    }

    public int contar_num_productos() throws SQLException {
        int nProductos = 0;
        Connection con = conex.getConectarDB();
        Statement stm = con.createStatement();
        // almaceno resultado de consulta en ResultSet
        try {
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

    public int contar_num_pedidos() throws SQLException {
        int nPedidos = 0;
        Connection con = conex.getConectarDB();
        Statement stm = con.createStatement();

        try {
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM compras");
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

    public int contar_num_mesas() throws SQLException {
        int nMesas = 0;
        Connection con = conex.getConectarDB();
        Statement stm = con.createStatement();

        try {
            ResultSet rs = stm.executeQuery("SELECT count(*) FROM mesas ");
            // chequeo que el result set no sea vacío, moviendo el cursor a la 
            // primer fila. (El cursor inicia antes de la primer fila)
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
