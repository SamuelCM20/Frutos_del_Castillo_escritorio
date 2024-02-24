/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SENA
 */
public class ControladorUtils {

    public static boolean evaluarExpresion(String expresion, String valor) {
        Pattern p = Pattern.compile(expresion);
        Matcher field = p.matcher(valor);

        return field.matches();
    }
    
    public DefaultTableModel addTableModel(DefaultTableModel model, JTable table, String[] titles){
        
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        
        for(String data: titles){
            model.addColumn(data);
        }

        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        return model;
    }

    public static String getFecha() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);
        return formattedDate;
    }
    
    public Timestamp crearTimestamp(){
        Date time = new Date();
        Timestamp timestamp = new Timestamp(time.getTime());
        
        return timestamp;
    }
}
