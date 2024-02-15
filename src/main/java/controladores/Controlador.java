/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import vistas.login;
import vistas.Perfil;
import Modelo.Users;
import controladores.controladorIndex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import org.mindrot.jbcrypt.BCrypt;
import sun.awt.www.content.audio.x_aiff;

/**
 *
 * @author samuel, Jd
 */
public class Controlador implements ActionListener {

    private login vistaLogin;
    private Users modeloLogin;
    private controladorIndex objControladorIndex = new controladorIndex();
    

    public Controlador(login vistaLogin, Users modeloLogin) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = modeloLogin;
        this.vistaLogin.btnEntrar.addActionListener(this);
    }
    vistas.index x = new vistas.index();
    
    public Controlador() {
        //Poder crear herencias de la funcion obtenerRol()
    }

    public void iniciar() {
        vistaLogin.runLogin();
    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (vistaLogin.txtEmail.getText().equals("") || vistaLogin.contraseniaUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todas las casilla.");

            return;

        }

        try {
            modeloLogin.setEmail(vistaLogin.txtEmail.getText());
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "error");
            return;
        }

        modeloLogin.setPassword(vistaLogin.contraseniaUser.getText());

        String consulta = "select * from users where email = '" + modeloLogin.getEmail() + "'";

        try ( Conexion conex = new Conexion();) {
            ResultSet rc = conex.consulta(consulta);
            if (rc != null && rc.next()) {
                String passwordOld = rc.getString("password");
                int state = rc.getInt("estado");
                String UserName = rc.getString("nombre");
                String Lastname = rc.getString("apellido");
                int UserId = rc.getInt("id");
                String Birthday = rc.getString("fecha_nacimiento");
                String Useremail = rc.getString("email");
                String phone = rc.getString("nombre");

                modeloLogin.setIdUsuario(UserId);
                modeloLogin.setNombre(UserName);
                modeloLogin.setApellido(Lastname);
                modeloLogin.setFecha_nacimiento(Birthday);
                modeloLogin.setEmail(Useremail);
                modeloLogin.setCelular(phone);
                modeloLogin.setEstado(state);

                String passwordNew = passwordOld.substring(0, 2) + "a" + passwordOld.substring(3, passwordOld.length());

                if (BCrypt.checkpw(modeloLogin.getPassword(), passwordNew)) {

                    if (objControladorIndex.verEstado(state)) {
                        this.vistaLogin.setVisible(false);
                        x.setUserName(modeloLogin.getNombre());
                        x.runView(objControladorIndex.obtenerRol(modeloLogin.getIdUsuario()), modeloLogin);
                    } else {

                        JOptionPane.showMessageDialog(null, "El usuario ingresado esta inactivo");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existe.");
            }

        } catch (SQLException s) {
            s.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
