/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author samue
 */
public class Conexion  implements AutoCloseable{

    Connection conect;

    public Conexion() {
        String host = "localhost";
        String puerto = "3306";
        String nameBD = "frutosdelcastillo";

        String usuario = "root";
        String pass = "";

        String driver = "com.mysql.cj.jdbc.Driver";

        String dbURL = "jdbc:mysql://" + host + ":" + puerto + "/" + nameBD + "?userSSL = false";

        try {
            
            Class.forName(driver);
            conect = DriverManager.getConnection(dbURL, usuario, pass);
           
        } catch (Exception e) {

            System.out.println("Desconectado");

        }
    }

    public Connection getConectarDB() {
        
        System.out.print("Conectado");
        return conect;

    }
    public void close() {
        try {
            // Cerrar la conexión correctamente
            if (conect != null && !conect.isClosed()) {
                conect.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            // Manejo de excepciones al cerrar la conexión
            e.printStackTrace();
        }
    }

    public boolean ejecutar(String sql) {
        boolean val;
        try {
            Statement sentencia;
            sentencia = getConectarDB().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if (sentencia.executeUpdate(sql) == 0) {
                val = false;
            } else {
                val = true;
            }
        } catch (SQLException error) {
            System.out.println("error en la ejecución de conexion" + error);
            val = false;
        }
        return val;
    }

    public ResultSet consulta(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia;
            sentencia = getConectarDB().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException error) {
            System.out.println("error en la consulta" + error);
            resultado = null;
        }
        return resultado;
    }

    public PreparedStatement prepareStatement(String consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
