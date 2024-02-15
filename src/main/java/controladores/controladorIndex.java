/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import vistas.Perfil;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SENA
 */
public class controladorIndex {

    public controladorIndex() {
    }
    
    
    public void mostrarDatos(Perfil p, int userId) {

        p.txtNombre.setEditable(false);
        p.txtApellido.setEditable(false);
        p.txtCorreo.setEditable(false);

        try ( Conexion con = new Conexion()) {

            String consulta = "SELECT * FROM users WHERE id = " + userId;

            ResultSet rc = con.consulta(consulta);
            if (rc != null && rc.next()) {

                p.txtNombre.setText(rc.getString("nombre"));
                p.txtApellido.setText(rc.getString("apellido"));
                p.txtCorreo.setText(rc.getString("email"));
                p.labelFecha.setText(rc.getString("fecha_nacimiento"));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date fecha = sdf.parse(rc.getString("fecha_nacimiento"));
                p.dateChooser.setDate(fecha);
                p.labelRol.setText(obtenerRol(rc.getInt("id")));
            }

        } catch (Exception e) {
            
            System.out.println(e);
        }

    }

    public boolean verEstado(int state) {

        return state == 1;

    }

    public String obtenerRol(int id) {

        int idUsuario = id;

        String consulta = "SELECT roles.name AS role_name FROM users JOIN model_has_roles ON users.id = model_has_roles.model_id"
                + " JOIN roles ON model_has_roles.role_id = roles.id WHERE users.id = " + idUsuario + ";";

        try ( Conexion conex = new Conexion();) {
            ResultSet rc = conex.consulta(consulta);
            if (rc != null && rc.next()) {

                String nombreRol = rc.getString("role_name");

                return nombreRol;
            } else {
                System.out.println("error al obtener rol");
            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return null;
    }
    
}
