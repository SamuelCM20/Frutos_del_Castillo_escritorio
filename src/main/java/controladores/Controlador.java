/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import vistas.login;
import vistas.Perfil;
import Modelo.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;
import sun.awt.www.content.audio.x_aiff;

/**
 *
 * @author samue
 */
public class Controlador implements ActionListener {

    Conexion conex = new Conexion();
    Connection con = conex.getConectarDB();
    private login vistaLogin;
    private Users modeloLogin;
    
    vistas.index x = new vistas.index();
    Perfil p = new Perfil(x,true);

    


    public Controlador(login vistaLogin, Users modeloLogin) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = modeloLogin;
        this.vistaLogin.btnEntrar.addActionListener(this);
        x.btnPerfil.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDatos();
                    p.setLocationRelativeTo(null);
                    p.setVisible(true);
                }
            });
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
            return ;
        }

        modeloLogin.setPassword(vistaLogin.contraseniaUser.getText());
        
        String consulta = "select * from users where email = '" + modeloLogin.getEmail()+"'";

        ResultSet rc = conex.consulta(consulta);
        try {

            if (rc != null && rc.next()) {
                String passwordOld = rc.getString("password");
                String UserName = rc.getString("nombre");
                String Lastname = rc.getString("apellido");
                String UserId = rc.getString("id");
                String Birthday = rc.getString("fecha_nacimiento");
                String Useremail = rc.getString("email");
                String phone = rc.getString("nombre");
                
                modeloLogin.setIdUsuario(Integer.parseInt(UserId));
                modeloLogin.setNombre(UserName);
                modeloLogin.setApellido(Lastname);
                modeloLogin.setFecha_nacimiento(Birthday);
                modeloLogin.setEmail(Useremail);
                modeloLogin.setCelular(phone);
                
                String passwordNew = passwordOld.substring(0, 2) + "a" + passwordOld.substring(3, passwordOld.length());

                if (BCrypt.checkpw(modeloLogin.getPassword(), passwordNew)) {
                    this.vistaLogin.setVisible(false);
                    x.setUserName(modeloLogin.getNombre());
                    x.runView();
                    obtenerRol();
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
    
    public void mostrarDatos(){
        
        p.txtNombre.setText(modeloLogin.getNombre());
        p.txtApellido.setText(modeloLogin.getApellido());
        p.txtCorreo.setText(modeloLogin.getEmail());
        p.txtNacimiento.setText(modeloLogin.getFecha_nacimiento());
        p.labelRol.setText(obtenerRol());
        
        p.txtNombre.setEditable(false);
        p.txtApellido.setEditable(false);
        p.txtCorreo.setEditable(false);
        p.txtNacimiento.setEditable(false);
    }
    
    public String obtenerRol(){
        
        String consulta = "SELECT roles.name AS role_name FROM users JOIN model_has_roles ON users.id = model_has_roles.model_id" + 
                " JOIN roles ON model_has_roles.role_id = roles.id WHERE users.id = "+modeloLogin.getIdUsuario()+";";
        
        ResultSet rc = conex.consulta(consulta);
        
        try {
             if (rc != null && rc.next()){
                 
                 String nombreRol = rc.getString("role_name");
                 
                 return nombreRol;
             }else{
                 System.out.println("error");
             }
        } catch (Exception e) {
            
            System.out.println(e);
        }
        return null;
    }
}
