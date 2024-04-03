/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;//Analizar DATE

/**
 *
 * @author Usuario Repaso 2
 */
public class Compra {

    private int idCompra;
    private Date fecha_hora;//Analizar el tipo de dato DATE
    private float iva;
    private double costo_total;
    private String comentario;
    private String direccion;
    private int estado;

    //foraneas
    private int usuarios_id;
    private int usuarios_reservas_id;
    private int mesas_id;
    private String mesa_numero;
    private int mesa_estado;

    public Compra(int id, Date fecha_hora, float iva, double costo_total, String comentario, String direccion, int estado, int usuario_id, int mesa_id, String mesa_numero, int mesa_estado) {
        this.idCompra = id;
        this.fecha_hora = fecha_hora;
        this.iva = iva;
        this.costo_total = costo_total;
        this.comentario = comentario;
        this.direccion = direccion;
        this.estado = estado;
        this.usuarios_id = usuario_id;
        this.mesas_id = mesa_id;
        this.mesa_numero = mesa_numero;
        this.mesa_estado = mesa_estado;
    }

    public String getMesa_numero() {
        return mesa_numero;
    }

    public void setMesa_numero(String mesa_numero) {
        this.mesa_numero = mesa_numero;
    }

    public int getMesa_estado() {
        return mesa_estado;
    }

    public void setMesa_estado(int mesa_estado) {
        this.mesa_estado = mesa_estado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public int getUsuarios_reservas_id() {
        return usuarios_reservas_id;
    }

    public void setUsuarios_reservas_id(int usuarios_reservas_id) {
        this.usuarios_reservas_id = usuarios_reservas_id;
    }

    public int getMesas_id() {
        return mesas_id;
    }

    public void setMesas_id(int mesas_id) {
        this.mesas_id = mesas_id;
    }
}
