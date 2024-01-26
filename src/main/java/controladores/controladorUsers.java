/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author samue
 */
import Modelo.Conexion;
import Modelo.Users;
import vistas.Usuarios;
import controladores.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class controladorUsers {

    public List<Users> getUsers() {
        List<Users> lista = new ArrayList<>();

        try ( Conexion con = new Conexion()) {
            String consulta = "select * from users";

            ResultSet rc = con.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                String apellido = rc.getString("apellido");
                String fecha_na = rc.getString("fecha_nacimiento");
                String email = rc.getString("email");
                String celular = rc.getString("celular");
                int estado = rc.getInt("estado");
                lista.add(new Users(id, nombre, apellido, fecha_na, email, celular, estado));
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public void agregarUsuario(String nombre, String apellido, String celular, Date selectedDate, String correo, String contrasenia, int rol) {

        try ( Conexion con = new Conexion()) {
            String ContraseniaEncrypt = encriptarContrasenia(contrasenia);
            java.sql.Date fechaNacimiento = new java.sql.Date(selectedDate.getTime());

            String consulta = "INSERT INTO users(nombre,apellido,fecha_nacimiento,email,password,celular,estado) "
                    + "VALUES('" + nombre + "', '" + apellido + "', '" + fechaNacimiento + "','" + correo + "','" + ContraseniaEncrypt + "','" + celular + "'," + 1 + ");";

            boolean res = con.ejecutar(consulta);

            if (res) {

                agregarRol(correo, rol);
                System.out.println("usuario creado exitosamente");

            } else {

                System.out.println("error al agregar");
            }

        } catch (Exception e) {
        }

    }

    public void actualizarUsuario(int id, String nombre, String apellido, String celular, Date selectedDate, String correo, int rol, int estado) {

        try ( Conexion con = new Conexion()) {
            java.sql.Date fechaNacimiento = new java.sql.Date(selectedDate.getTime());

            String consulta = "UPDATE users SET nombre = '" + nombre + "', apellido = '" + apellido + "', fecha_nacimiento  = '" + fechaNacimiento + "', email = '" + correo + "', celular = '" + celular + "', estado =" + estado + " WHERE id = " + id;

            boolean res = con.ejecutar(consulta);

            if (res) {
                actualizarRol(id, rol);
                System.out.println("usuario actualizado");
            } else {
                System.out.println("Error al actualizar usuario.");
            }

        } catch (Exception e) {
        }

    }

    public void agregarRol(String correo, int rol) {

        String consulta = "SELECT id FROM users WHERE email = '" + correo + "'";

        try ( Conexion con = new Conexion()) {
            ResultSet rs = con.consulta(consulta);
            if (rs != null && rs.next()) {
                int id = rs.getInt("id");

                String agregarRol = "INSERT INTO model_has_roles(role_id,model_type,model_id) "
                        + "VALUES(" + rol + ",'App\\Models\\User'," + id + ")";

                boolean res = con.ejecutar(agregarRol);

                if (res) {
                    System.out.println("rol agregado con exito");
                } else {
                    System.out.println("error en agregar rol");
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void actualizarRol(int id, int rol) {

        try ( Conexion con = new Conexion()) {
            String consulta = "UPDATE model_has_roles "
                    + "SET role_id =" + rol + " WHERE model_id = " + id;

            boolean res = con.ejecutar(consulta);

            if (res) {
                System.out.println("rol actualizado con exito");
            } else {
                System.out.println("error en actualizar rol");
            }

        } catch (Exception e) {
        }

    }

    public int obtenerRol(JComboBox rol) {

        String opcion = (String) rol.getSelectedItem();
        if (opcion.equalsIgnoreCase("Administrador")) {
            return 2;
        } else {
            return 3;
        }

    }

    public int getRol(int id) {

        int rol;
        String consulta = "SELECT role_id FROM model_has_roles WHERE model_id =" + id;

        try ( Conexion con = new Conexion()) {
            ResultSet rs = con.consulta(consulta);

            if (rs.next()) {
                rol = rs.getInt("role_id");

                if (rol == 2) {
                    return 1;
                } else {
                    return 2;
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al obtener rol: " + e);
        }
        return 0;
    }

    public int obtenerEstado(JComboBox state) {

        String opcion = (String) state.getSelectedItem();
        if (opcion.equalsIgnoreCase("Activo")) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean validarCampos(String nombre, String apellido, String celular, Date selectedDate, String correo, String contrasenia, JComboBox rol) {
        boolean validacionRol = validarOpcionRol(rol);

        return !(nombre.equals("") || apellido.equals("") || celular.equals("") || selectedDate == null || correo.equals("") || contrasenia.equals("") || !validacionRol);
    }

    public boolean validarCampoEstado(JComboBox item) {
        String opcion = (String) item.getSelectedItem();

        return opcion.equalsIgnoreCase("Activo") || opcion.equalsIgnoreCase("Inactivo");
    }

    public boolean validarOpcionRol(JComboBox item) {

        String opcion = (String) item.getSelectedItem();

        return opcion.equalsIgnoreCase("Administrador") || opcion.equalsIgnoreCase("Empleado");

    }

    public boolean validarFecha(Date selectedDate) {

        Date currentDate = new Date();
        return selectedDate.before(currentDate);
    }

    public boolean validarCorreo(String email) {

        String patronCorreo = ".*@.*";

        String consulta = "SELECT COUNT(*) AS cantidad FROM users WHERE email = '" + email + "'";
        try ( Conexion con = new Conexion()) {
            ResultSet rs = con.consulta(consulta);

            Pattern patron = Pattern.compile(patronCorreo);
            Matcher matcher = patron.matcher(email);

            if (matcher.matches()) {

                try {
                    if (rs.next()) {
                        int cantidad = rs.getInt("cantidad");
                        return cantidad > 0;
                    }
                } catch (SQLException e) {
                }
            } else {
                return false;
            }

        } catch (Exception e) {
        }

        return false;
    }

    public boolean validarLargoContrasenia(String contrasenia) {

        return contrasenia.length() >= 6;
    }

    public String encriptarContrasenia(String contrasenia) {
        String salt = BCrypt.gensalt();
        String ContraseniaEncrypt = BCrypt.hashpw(contrasenia, salt);

        return ContraseniaEncrypt;

    }

    public void actualizarContrasenia(int id, String newPass) {

        String newPassEncryp = encriptarContrasenia(newPass);

        String consulta = "UPDATE users SET password = '" + newPassEncryp + "'WHERE id =  " + id;

        try ( Conexion con = new Conexion()) {
            boolean res = con.ejecutar(consulta);

            if (res) {
                System.out.println("Contrasenia actualizada con exito");
            } else {
                System.out.println("error en actualizar contrasenia");
            }

        } catch (Exception e) {
        }

    }

}
