/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import vistas.login;
import Modelo.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author samuel, Jd
 */
public class Controlador implements ActionListener {
    
    //variables de modelos y vistas
    private login vistaLogin;
    private controladorIndex objControladorIndex = new controladorIndex();

    //Constructor que hereda el modelo User y la vista Login
    public Controlador(login vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.btnEntrar.addActionListener(this);
    }
    vistas.index x = new vistas.index();

    public Controlador() {
        //COnstructor para poder crear herencias de la funcion obtenerRol()
    }

    //Funcion para mostrar la vista login
    public void iniciar() {
        vistaLogin.runLogin();
    }

    @Override
    //Funcion para poder iniciar sesion
    public void actionPerformed(ActionEvent e) {
        //validar casillas vacias
        if (vistaLogin.txtEmail.getText().equals("") || vistaLogin.contraseniaUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todas las casilla.");

            return;

        }
        
        String email = vistaLogin.txtEmail.getText();
        String password = vistaLogin.contraseniaUser.getText();

        String consulta = "SELECT us.id AS 'user_id', us.nombre, us.apellido, us.email as 'user_email', us.fecha_nacimiento, us.password, us.celular, mrole.role_id, r.name AS 'role_name'\n"
                + "FROM users us\n"
                + "JOIN model_has_roles mrole ON us.id = mrole.model_id\n"
                + "JOIN roles r ON mrole.role_id = r.id \n"
                + "WHERE us.email = '" + email + "'";

        try ( Conexion conex = new Conexion();) {
            ResultSet rc = conex.consulta(consulta);
            if (rc != null && rc.next()) {
                int userId = rc.getInt("user_id");
                String passwordOld = rc.getString("password");
                String userName = rc.getString("nombre");
                String lastname = rc.getString("apellido");
                Date birthday = rc.getDate("fecha_nacimiento");
                String userEmail = rc.getString("user_email");
                String phone = rc.getString("celular");
                
                int roleId = rc.getInt("role_id");
                String roleName = rc.getString("role_name");


                String passwordNew = passwordOld.substring(0, 2) + "a" + passwordOld.substring(3, passwordOld.length());
                
                if (BCrypt.checkpw(password, passwordNew)) {
                    if(!roleName.equalsIgnoreCase("Usuario")){
                        Users modeloLogin = new Users(userId, userName, lastname, birthday, userEmail, phone, roleId, roleName);
                        this.vistaLogin.setVisible(false);
                        x.setUserName(modeloLogin.getNombre());
                        x.runView(modeloLogin);
                    }else{
                        
                        JOptionPane.showMessageDialog(null, "El usuario ingresado no tiene los permisos suficientes para iniciar sesión", "Error en iniciar sesión", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos.", "Error al iniciar sesión", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
