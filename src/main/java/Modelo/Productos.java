/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author samue
 */
public class Productos {
   private int idProductos;
   private String nombre;
   private double precio;
   private String tamaño;
   private String descripcion;
   //verificar el tipo de dato
   private int disponibilidad;
   private String imagen_1;
   private int categorias_id;
   private String categoria_nombre;

   
   public Productos(int id, String nombre, double precio, String descripcion, int disponibilidad, String imagen1, int categoriaId, String categoria_nombre){
       this.idProductos = id;
       this.nombre = nombre;
       this.precio = precio;
       this.descripcion = descripcion;
       this.disponibilidad = disponibilidad;
       this.imagen_1 = imagen1;
       this.categorias_id = categoriaId;
       this.categoria_nombre = categoria_nombre;
   }

    public String getCategoria_nombre() {
        return categoria_nombre;
    }

    public void setCategoria_nombre(String categoria_nombre) {
        this.categoria_nombre = categoria_nombre;
    }
   public Productos(){
       
   }
   
    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getImagen_1() {
        return imagen_1;
    }

    public void setImagen_1(String imagen_1) {
        this.imagen_1 = imagen_1;
    }


    public int getCategorias_id() {
        return categorias_id;
    }

    public void setCategorias_id(int categorias_id) {
        this.categorias_id = categorias_id;
    }
   
   

   
}
