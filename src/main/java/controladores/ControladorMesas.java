/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Mesas;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jdelg
 */
public class ControladorMesas {
    
    public Mesas getMesa(int mesaId){
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from mesas where id = "+mesaId;
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            while (rc != null && rc.next()) {
                
                int id = rc.getInt("id");
                int numeroMesa = rc.getInt("numero_mesa");
                int estado = rc.getInt("estado");
                
                return new Mesas(id, numeroMesa, estado);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return new Mesas();
    }
    
}
