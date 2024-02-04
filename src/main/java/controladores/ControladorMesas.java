/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Mesas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jd
 */
public class ControladorMesas {
    
    public Mesas getMesa(int mesaId){
        
        String consulta = "select * from mesas where id = "+mesaId;
        
        try (Conexion objConexion = new Conexion();) {
            ResultSet rc = objConexion.consulta(consulta);
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
    
    public List<Mesas> getListaMesas() {
        List<Mesas> lista = new ArrayList<>();

        try ( Conexion con = new Conexion()) {
            String consulta = "select * from mesas";

            ResultSet rc = con.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                int numeroMesa = rc.getInt("numero_mesa");
                int estado = rc.getInt("estado");
                
                lista.add(new Mesas(id, numeroMesa,estado));
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
}
