/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author samue, nicol
 */
import java.util.Date;

public class Users {
    
    
    
    private int idUsuario;
    private String nombre;
    private String apellido; 
    //pendiente fecha
    private Date fecha_nacimiento;
    private String email;
    private String password;
    private String celular;
    private String nombre_rol;
    
    

   

    public Users(int id,String nombre,String apellido,Date fecha_nacimiento,String email,String celular){
        this.idUsuario = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;

        this.celular = celular;

    }

    public Users() {
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
    @Override
    public String toString(){
        return this.nombre + this.apellido;
    }
 
}
