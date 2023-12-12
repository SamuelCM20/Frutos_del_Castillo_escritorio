/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Modelo.Users;
import controladores.Controlador;
import vistas.login;

/**
 *
 * @author samue
 */
public class Main {
    
    public static void main(String args[]){
        
        Users modLogin = new Users();
        login visLogin = new login();
        
        Controlador ctrl = new Controlador(visLogin, modLogin);
        ctrl.iniciar();
    }
    
}
