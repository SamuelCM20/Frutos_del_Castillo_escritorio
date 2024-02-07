/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author SENA
 */
public class ControladorUtils {

    public boolean evaluarExpresion(String expresion, String valor) {

        Pattern p = Pattern.compile(expresion);
        Matcher field = p.matcher(valor);
        
        return field.matches();
    }
}
