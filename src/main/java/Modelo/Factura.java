/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario Repaso 2
 */
public class Factura {
    private int idFactura;
    private int cantidad_producto;
    private double subtotal;
    private int compra_id;
    private double precio;
    //foraneas
    private int compra_usuarios_id;
    private int compra_usuarios_reservas_id;
    private int productos_id;
    private String producto_nombre;
    
    public Factura(int idFactura, int cantidad_producto, double subtotal, double precio, int compra_id, int producto_id, String producto_nombre){
        this.idFactura = idFactura;
        this.cantidad_producto = cantidad_producto;
        this.subtotal = subtotal;
        this.precio = precio;
        this.compra_id = compra_id;
        this.productos_id = producto_id;
        this.producto_nombre = producto_nombre;
    }
    public Factura(){
        
    }

    public String getProducto_nombre() {
        return producto_nombre;
    }

    public void setProducto_nombre(String producto_nombre) {
        this.producto_nombre = producto_nombre;
    }

    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(int compra_id) {
        this.compra_id = compra_id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCompra_usuarios_id() {
        return compra_usuarios_id;
    }

    public void setCompra_usuarios_id(int compra_usuarios_id) {
        this.compra_usuarios_id = compra_usuarios_id;
    }

    public int getCompra_usuarios_reservas_id() {
        return compra_usuarios_reservas_id;
    }

    public void setCompra_usuarios_reservas_id(int compra_usuarios_reservas_id) {
        this.compra_usuarios_reservas_id = compra_usuarios_reservas_id;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }
}
