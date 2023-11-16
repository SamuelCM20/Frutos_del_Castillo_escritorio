/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author samue
 */
public class Reservas extends JPanel{
    
    
      public static int numMesa = 1;

    
     public  Reservas() {
        // Configurar el tamaño del panel de la mesa
        setPreferredSize(new java.awt.Dimension(100, 110));
        
        // Agregar un icono de mesa al panel
        JLabel mesaLabel = new JLabel();
        mesaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/libre.png")));
        mesaLabel.setForeground(Color.white);
        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#601d49")), "Mesa " + numMesa);
        mesaLabel.setBorder(border);
        add(mesaLabel);
        
        numMesa++;
        mesaLabel.repaint();

    }
     
     
     
    
}
