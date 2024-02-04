/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario Repaso 2
 */
public class Mesas {
    private int idMesa;
    private int numero_mesa;
    private int cantidad_sillas;
    private int estado;

    public Mesas(int id, int numero_mesa, int estado){
        this.idMesa = id;
        this.numero_mesa = numero_mesa;
        this.estado = estado;
    }
    public Mesas(){
        
    }

    public Mesas(int id, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumero_mesa() {
        return numero_mesa;
    }

    public void setNumero_mesa(int numero_mesa) {
        this.numero_mesa = numero_mesa;
    }

    public int getCantidad_sillas() {
        return cantidad_sillas;
    }

    public void setCantidad_sillas(int cantidad_sillas) {
        this.cantidad_sillas = cantidad_sillas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(numero_mesa);
    }
}
