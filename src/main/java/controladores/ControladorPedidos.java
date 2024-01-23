/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Compra;
import Modelo.Mesas;
import Modelo.Factura;
import Modelo.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jdelg
 */
public class ControladorPedidos {
    
    public boolean actualizarPedido(int compraId){
        Conexion objConexion = new Conexion();
    
        String consulta = "update compras set estado = 0 where id = "+compraId;
        
        boolean res = objConexion.ejecutar(consulta);
        
        if(res){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Compra> getPedidos(){
        List<Compra> lista = new ArrayList<>();
        
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from compras where estado = 1";
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            while (rc != null && rc.next()) {
                
                int id = rc.getInt("id");
                Date fechaHora = rc.getDate("fecha_hora");
                float iva = rc.getFloat("iva");
                double costoTotal = rc.getDouble("costo_total");
                String comentario = rc.getString("comentario");
                String direccion = rc.getString("direccion");
                int estado = rc.getInt("estado");
                int userId = rc.getInt("user_id");
                int mesaId = rc.getInt("mesa_id");
                
                
                lista.add(new Compra(id, fechaHora, iva, costoTotal, comentario, direccion, estado, userId, mesaId));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }
    
    public List<Compra> getPedidosHistorial(){
        List<Compra> lista = new ArrayList<>();
        
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from compras where estado = 0";
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            while (rc != null && rc.next()) {
                
                int id = rc.getInt("id");
                Date fechaHora = rc.getDate("fecha_hora");
                float iva = rc.getFloat("iva");
                double costoTotal = rc.getDouble("costo_total");
                String comentario = rc.getString("comentario");
                String direccion = rc.getString("direccion");
                int estado = rc.getInt("estado");
                int userId = rc.getInt("user_id");
                int mesaId = rc.getInt("mesa_id");
                
                
                lista.add(new Compra(id, fechaHora, iva, costoTotal, comentario, direccion, estado, userId, mesaId));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }
    
    
    public Users getUsuario(int usuarioId){
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from users where id = "+usuarioId;
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            while (rc != null && rc.next()) {
                
                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                String apellido = rc.getString("apellido");
                String fechaNacimiento = rc.getString("fecha_nacimiento");
                String email = rc.getString("email");
                String celular = rc.getString("celular");
                int estado = rc.getInt("estado");
                
                return new Users(id, nombre, apellido, fechaNacimiento, email, celular);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return new Users();
    }
    
}
