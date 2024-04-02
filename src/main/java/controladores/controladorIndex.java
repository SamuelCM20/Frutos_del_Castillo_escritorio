/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Users;
import vistas.Perfil;
import java.sql.ResultSet;
import vistas.login;

/**
 *
 * @author SENA
 */
public class controladorIndex {

    public controladorIndex() {
    }

    public void mostrarDatos(Perfil p, Users user) {

        p.txtNombre.setEditable(false);
        p.txtApellido.setEditable(false);
        p.txtCorreo.setEditable(false);

        p.txtNombre.setText(user.getNombre());
        p.txtApellido.setText(user.getApellido());
        p.txtCorreo.setText(user.getEmail());
        p.dateChooser.setDate(user.getFecha_nacimiento());
        p.labelRol.setText(user.getNombre_rol());

    }

    public boolean verEstado(int state) {

        return state == 1;

    }

    public void iniciarLogin() {
        Users modLogin = new Users();
        login visLogin = new login();
        
        Controlador ctrl = new Controlador(visLogin, modLogin);
        ctrl.iniciar();
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
