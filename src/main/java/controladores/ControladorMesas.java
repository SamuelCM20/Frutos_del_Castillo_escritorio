/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Mesas;
import controladores.ControladorUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author jd
 */
public class ControladorMesas {
    
    ControladorUtils ctrlu = new ControladorUtils();

    public Mesas getMesa(int mesaId) {

        String consulta = "select id, numero_mesa, estado from mesas where id = " + mesaId + ";";
        try ( Conexion objConexion = new Conexion();) {

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
        return null;
    }

    public List<Mesas> getListaMesas() {
        List<Mesas> lista = new ArrayList<>();

        try ( Conexion con = new Conexion()) {
            String consulta = "select id, numero_mesa, estado from mesas WHERE estado != 2;";

            ResultSet rc = con.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                int numeroMesa = rc.getInt("numero_mesa");
                int estado = rc.getInt("estado");

                lista.add(new Mesas(id, numeroMesa, estado));
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public boolean validarCampos(String number, JComboBox state) {

        boolean validacionCampos = validarOpcionDisponibilidad(state);

        return !(number.equals("") || !validacionCampos);

    }

    public boolean validarOpcionDisponibilidad(JComboBox item) {
        String opcion = (String) item.getSelectedItem();

        return opcion.equalsIgnoreCase("disponible") || opcion.equalsIgnoreCase("ocupada");
    }
    
    public boolean validarNumMesa(int num) {
        String consulta = "SELECT COUNT(*)AS numero FROM mesas WHERE numero_mesa = " + num + ";";
        try ( Conexion objConexion = new Conexion()) {
            ResultSet res = objConexion.consulta(consulta);
            if (res.next()) {
                int numeroMesa = res.getInt("numero");
                
                if (numeroMesa > 0){
                    return false;
                }else{
                    
                    return true;

                }
            }

        } catch (Exception e) {
        }
        return false;

    }

    public int getValorDisponibilidad(JComboBox dispo) {
        String opcion = (String) dispo.getSelectedItem();
        if (opcion.equalsIgnoreCase("Disponible")) {
            return 1;
        } else {
            return 0;
        }
    }

    //Funcion para crear una mesa
    public void agregarMesa(int numero, int estado) {

        Timestamp timestamp = ctrlu.crearTimestamp();
        String consulta = "INSERT INTO mesas(numero_mesa,estado,created_at,updated_at) VALUES (" + numero + "," + estado + ",'"+timestamp+"','"+timestamp+"');";

        try ( Conexion objConexion = new Conexion()) {
            boolean res = objConexion.ejecutar(consulta);
            
            if (res) {
                System.out.println("Mesa agreagado");
            } else {
                System.out.println("Error al agregar mesa");
            }

        } catch (Exception e) {
        }
    }
    
    //Funcion para editar el estado y numero de la mesa
    public void EditarMesa(int id,int numero, int estado) {
        
        String consulta = "UPDATE mesas set numero_mesa =  " + numero + ",estado =" + estado + ",updated_at = '"+ctrlu.crearTimestamp()+"' WHERE id = " + id + ";";

        try ( Conexion objConexion = new Conexion()) {
            boolean res = objConexion.ejecutar(consulta);

            if (res) {
                System.out.println("Mesa editada exitosamente");
            } else {
                System.out.println("Error al editar mesa");
            }

        } catch (Exception e) {
        }
    }
    public void eliminarMesa(int id){
        
        String consulta = "UPDATE mesas SET estado = 2 WHERE id = "+id+";";
        try ( Conexion objConexion = new Conexion()) {
            boolean res = objConexion.ejecutar(consulta);

            if (res) {
                System.out.println("Mesa eliminada exitosamente");
            } else {
                System.out.println("Error al eliminar mesa");
            }

        } catch (Exception e) {
        }
    }
    public boolean maximoMesas(){
        String consulta = "SELECT COUNT(*) as cantidad FROM mesas WHERE estado = 1";
        try ( Conexion con = new Conexion()) {

                try {
                    ResultSet rs = con.consulta(consulta);
                    if (rs.next()) {
                        int cantidad = rs.getInt("cantidad");

                        return cantidad <= 50;
                    }
                } catch (SQLException e) {
                }
            

        } catch (Exception e) {
        }
        return false;
    }
}
