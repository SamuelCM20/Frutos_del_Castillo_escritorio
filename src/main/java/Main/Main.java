/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Modelo.Users;
import controladores.Controlador;
import vistas.login;
import Modelo.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import vistas.splashWindow;

/**
 *
 * @author samue
 */
public class Main {

    public static void main(String args[]) {

        Users modLogin = new Users();
        login visLogin = new login();
        Conexion con = new Conexion();

        if (con.isConnected) {
            Runnable mRun = () -> {
                splashWindow obj = new splashWindow();
                obj.setVisible(true);

                Controlador ctrl = new Controlador(visLogin, modLogin);
                try {
                    Thread.sleep(2051);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ctrl.iniciar();
                
                obj.dispose();
                
            };

            Thread miHiloSplash = new Thread(mRun);
            miHiloSplash.start();
        } else {
            JOptionPane.showMessageDialog(null, "Error al abrir la aplicacion, compruebe su conexión a internet", "Sin conexion", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

}
