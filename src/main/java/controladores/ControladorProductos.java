/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Categorias;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
//import org.mindrot.jbcrypt.BCrypt;


import Modelo.Conexion;
import Modelo.Productos;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jdelg
 */
public class ControladorProductos {

    private File selectedFile;
    
    public void setNullFile(){
        selectedFile = null;
    }
    
    public List<Productos> getProductos(){
        List<Productos> lista = new ArrayList<>();
        
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from productos";
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            while (rc != null && rc.next()) {
                
                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                double precio = rc.getDouble("precio");
                String descripcion = rc.getString("descripcion");
                int disponibilidad = rc.getInt("disponibilidad");
                String imagen1 = rc.getString("imagen_1");
                int categoriaId = rc.getInt("categorias_id");
                
                lista.add(new Productos(id, nombre, precio, descripcion, disponibilidad, imagen1, categoriaId));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }

    public String[] seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // Filtro para aceptar solo archivos de imagen
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "Archivos de imagen", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();

                System.out.println("Ruta de imagen seleccionada: " + selectedFile);
                String[] data = {"true", selectedFile.toString()};

                return data;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al obtener la ruta de la imagen seleccionada.");
                String[] data = {"false"};
                return data;

            }
        } else {
            System.out.println("Selección de imagen cancelada");
            String[] data = {"false"};
            return data;

        }
    }

    public String[] copiarImagen() {
        if (selectedFile != null){
            String basePath = Paths.get("src", "main").toString();

            // Ruta relativa al src/main donde se guardarán las imágenes
            String relativePath = "resources/images/";

            // Crear el directorio de destino dentro de resources si no existe
            Path destinationDir = Paths.get(basePath, relativePath);
            
            try {
                Files.createDirectories(destinationDir);
                // Copiar el archivo seleccionado al directorio de destino

                Path destinationPath = destinationDir.resolve(selectedFile.getName());
                Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                
                System.out.println("Imagen guardada, ruta de destino: " + destinationPath.toString());
                
                String[] data = {"true", destinationPath.toString()};
                return data;
                
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error al guardar la imagen en el proyecto.");
                
                String[] data = {"false"};
                return data;
            }
        }else{
            
            String[] data = {"false"};
            return data;
        }
    }
    
    public List<Categorias> getCategorias(){
        List<Categorias> lista = new ArrayList<>();
        
        Conexion objConexion = new Conexion();
    
        String consulta = "select * from categorias";
        
        ResultSet rc = objConexion.consulta(consulta);
        try {
            lista.add(new Categorias(0, "Seleccionar", "None"));
            while (rc != null && rc.next()) {
                int id = rc.getInt("id");
                lista.add(new Categorias(id, rc.getString("nombre"), rc.getString("imagen")));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }
    
    public void agregarProducto(String nombre, double precio, int disponibilidad, int categoria, String descripcion, String imagen){
        
        Conexion objConexion = new Conexion();
    
        String consulta = "INSERT INTO productos(nombre, precio, descripcion, disponibilidad, imagen_1, imagen_2, categorias_id) "
                + "VALUES('"+ nombre + "', "+ precio + ", 'descripcion', "+ disponibilidad + ", '" + imagen + "', '" + imagen + "', " + categoria + ")";

        
        boolean res = objConexion.ejecutar(consulta);
        
        if(res){
            System.out.println("producto agreagado");
        }else{
            System.out.println("producto fallido");
        }
        
    }
    
    public void fillComboBox(List<Categorias> lista, JComboBox comboBoxCategorias, DefaultComboBoxModel<Categorias> modelComboBox){
        lista.forEach(l -> modelComboBox.addElement(l));
        comboBoxCategorias.setModel(modelComboBox);
    }
    
    public boolean validarCampos(String nombre, String precio, JComboBox disponibilidad, JComboBox categoria, String descripcion){
        
        Boolean validacionDisponibilidad = validarOpcionDisponibilidad(disponibilidad);
        Boolean validacionCategoria = validarOpcionCategorias(categoria);
                
        if(nombre.equals("") || precio.equals("") || descripcion.equals("") || !validacionDisponibilidad || !validacionCategoria){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean validarOpcionDisponibilidad(JComboBox item){
        String opcion = (String) item.getSelectedItem();
        
        if(opcion.equalsIgnoreCase("disponible") || opcion.equalsIgnoreCase("no disponible")){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean validarOpcionCategorias(JComboBox item){
        Categorias itemSeleccionado = (Categorias) item.getSelectedItem();
        
        if(itemSeleccionado.getIdCategoria() != 0){
            return true;
        }else{
            return false;
        }
    }
}
