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
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Modelo.Conexion;
import Modelo.Productos;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author jdelg
 */
public class ControladorProductos {

    private File selectedFile;
    ControladorUtils ctrlu = new ControladorUtils();

    public void setNullFile() {
        selectedFile = null;
    }

    public Productos getProducto(int productoId) {

        String consulta = "select id, nombre, precio, descripcion, disponibilidad, imagen_1, categoria_id from productos where id = " + productoId;

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                double precio = rc.getDouble("precio");
                String descripcion = rc.getString("descripcion");
                int disponibilidad = rc.getInt("disponibilidad");
                String imagen1 = rc.getString("imagen_1");
                int categoriaId = rc.getInt("categoria_id");

                return new Productos(id, nombre, precio, descripcion, disponibilidad, imagen1, categoriaId);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return new Productos();
    }

    public List<Productos> getProductos() {
        List<Productos> lista = new ArrayList<>();

        String consulta = "select id, nombre, precio, descripcion, disponibilidad, imagen_1, categoria_id from productos";

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                double precio = rc.getDouble("precio");
                String descripcion = rc.getString("descripcion");
                int disponibilidad = rc.getInt("disponibilidad");
                String imagen1 = rc.getString("imagen_1");
                int categoriaId = rc.getInt("categoria_id");

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
                "Archivos de imagen", "jpg", "jpeg", "png", "gif", "webp", "avif");
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

    public String obtenerRutaImagen(String ruta) {
        String newRuta = ruta.replace("\\", "/");
        return newRuta;
    }

    public String[] copiarImagen() {
       if (selectedFile != null) {
        String server = "ftp.laromana.store";
        int port = 21;
        String username = "samuelito@laromana.store";
        String password = "Adso02.2560312";
        String remoteFolder = "/imagen-produto";
        
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(server, port);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            
            InputStream inputStream = new FileInputStream(selectedFile);
            boolean done = ftpClient.storeFile(remoteFolder + "/" + selectedFile.getName(), inputStream);
            inputStream.close();
            
            if (done) {
                System.out.println("Imagen guardada en el servidor FTP.");
                String[] data = {"true","storage"+ remoteFolder + "/" + selectedFile.getName()};
                return data;
            } else {
                System.out.println("No se pudo guardar la imagen en el servidor FTP.");
                String[] data = {"false"};
                return data;
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar la imagen en el servidor FTP: " + ex.getMessage());
            ex.printStackTrace();
            String[] data = {"false"};
            return data;
        }
    } else {
        System.out.println("No se ha seleccionado ningún archivo de imagen.");
        String[] data = {"false"};
        return data;
    }
    }

    public List<Categorias> getCategorias() {
        List<Categorias> lista = new ArrayList<>();

        String consulta = "select * from categorias";

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
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

    public void agregarProducto(String nombre, double precio, int disponibilidad, int categoria, String descripcion, String imagen) {
        
        Timestamp timestamp = ctrlu.crearTimestamp();
        String consulta = "INSERT INTO productos(nombre, precio, descripcion, disponibilidad,size,imagen_1, categoria_id,created_at,updated_at) "
                + "VALUES('" + nombre + "', " + precio + ",'" + descripcion + "', " + disponibilidad + ",'grande', '" + imagen + "', " + categoria + ",'"+timestamp+"','"+timestamp+"');";

        try ( Conexion objConexion = new Conexion()) {
            boolean res = objConexion.ejecutar(consulta);

            if (res) {
                System.out.println("producto agreagado");
            } else {
                System.out.println("producto fallido");
            }

        } catch (Exception e) {
        }

    }

    public void actualizarProducto(int id, String nombre, double precio, int disponibilidad, int categoria, String descripcion, String[] imagen) {

        String consulta;
        Timestamp timestamp = ctrlu.crearTimestamp();
        if (imagen[0].equalsIgnoreCase("true")) {

            String rutaImagen = obtenerRutaImagen(imagen[1]);

            consulta = "UPDATE productos set nombre = '" + nombre + "'"
                    + ", precio = '" + precio + "', disponibilidad = '" + disponibilidad + "', categoria_id = '" + categoria + "', descripcion = '" + descripcion + "'"
                    + ", imagen_1 = '" + rutaImagen + "',updated_at = '"+timestamp+"' WHERE id = " + id;
        } else {
            consulta = "UPDATE productos set nombre = '" + nombre + "'"
                    + ", precio = '" + precio + "', disponibilidad = '" + disponibilidad + "', categoria_id = '" + categoria + "', descripcion = '" + descripcion + "'"
                    + ",updated_at = '"+timestamp+"' WHERE id = " + id;
        }

        try (Conexion objConexion = new Conexion()) {
            boolean res = objConexion.ejecutar(consulta);

        if (res) {
            System.out.println("producto actualizado");
        } else {
            System.out.println("Error al actualizar producto.");
        }
            
        } catch (Exception e) {
        }
       

        

    }

    public void fillComboBox(List<Categorias> lista, JComboBox comboBoxCategorias, DefaultComboBoxModel<Categorias> modelComboBox) {
        lista.forEach(l -> modelComboBox.addElement(l));
        comboBoxCategorias.setModel(modelComboBox);
    }

    public boolean validarCampos(String nombre, String precio, JComboBox disponibilidad, JComboBox categoria, String descripcion) {

        Boolean validacionDisponibilidad = validarOpcionDisponibilidad(disponibilidad);
        Boolean validacionCategoria = validarOpcionCategorias(categoria);

        return !(nombre.equals("") || precio.equals("") || descripcion.equals("") || !validacionDisponibilidad || !validacionCategoria);
    }

    public boolean validarOpcionDisponibilidad(JComboBox item) {
        String opcion = (String) item.getSelectedItem();

        return opcion.equalsIgnoreCase("disponible") || opcion.equalsIgnoreCase("no disponible");
    }

    public boolean validarOpcionCategorias(JComboBox item) {
        Categorias itemSeleccionado = (Categorias) item.getSelectedItem();

        return itemSeleccionado.getIdCategoria() != 0;
    }

    public boolean validarSeleccionTabla(int rowSelected) {
        return rowSelected != -1;
    }

    public int getValorDisponibilidad(JComboBox disponibilidad) {
        String opcion = (String) disponibilidad.getSelectedItem();
        if (opcion.equalsIgnoreCase("disponible")) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public ImageIcon obtenerImagenRemota(String imageUrl){
        
        try {
            URL url = new URL("https://laromana.store/public/"+imageUrl);
            Image image = ImageIO.read(url);
            return new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    } 
    
}
