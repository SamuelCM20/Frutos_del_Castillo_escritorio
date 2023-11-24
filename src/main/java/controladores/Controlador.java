/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import vistas.login;
import Modelo.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author samue
 */
public class Controlador implements ActionListener {

    Conexion conex = new Conexion();
    Connection con = conex.getConectarDB();
    private login vistaLogin;
    private Login modeloLogin;

    public Controlador(login vistaLogin, Login modeloLogin) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = modeloLogin;
        this.vistaLogin.btnEntrar.addActionListener(this);
    }

    public void iniciar() {
        vistaLogin.runLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (vistaLogin.txtIdentificacion.getText().equals("") || vistaLogin.contraseniaUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, llene todas las casilla.");
            return;

        }

        try {
            modeloLogin.setIdUsuario(Integer.parseInt(vistaLogin.txtIdentificacion.getText()));
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "El campo identificación solo acepta números.");
            return;
        }

        modeloLogin.setContrasenia(vistaLogin.contraseniaUser.getText());

        String consulta = "select * from users where id = " + modeloLogin.getIdUsuario();

        ResultSet rc = conex.consulta(consulta);
        try {

            if (rc != null && rc.next()) {
                String passwordOld = rc.getString("password");

                String passwordNew = passwordOld.substring(0, 2) + "a" + passwordOld.substring(3, passwordOld.length());

                if (BCrypt.checkpw(modeloLogin.getContrasenia(), passwordNew)) {
                    vistas.index x = new vistas.index();
                    this.vistaLogin.setVisible(false);
                    x.runView();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existe.");
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

}
