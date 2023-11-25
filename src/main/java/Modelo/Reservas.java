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
import java.util.Date;//Analizar DATE

/**
 *
 * @author samue
 */
public class Reservas extends JPanel{
    
    //Inicio modelo
    private int idReserva;
    private Date fecha_hora;//Analizar el tipo de dato DATE
    private int cantidad_personas;
    private String comentario;
    //foraneas
    private int usuarios_id;
    private int mesas_id;
    private int tipo_reserva_id;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public int getMesas_id() {
        return mesas_id;
    }

    public void setMesas_id(int mesas_id) {
        this.mesas_id = mesas_id;
    }

    public int getTipo_reserva_id() {
        return tipo_reserva_id;
    }

    public void setTipo_reserva_id(int tipo_reserva_id) {
        this.tipo_reserva_id = tipo_reserva_id;
    }

    public static int getNumMesa() {
        return numMesa;
    }

    public static void setNumMesa(int numMesa) {
        Reservas.numMesa = numMesa;
    }
    //final modelo
    
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
