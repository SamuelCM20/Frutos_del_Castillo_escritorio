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
import vistas.index;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import org.mindrot.jbcrypt.BCrypt;

public class controladorUsers {

    ControladorUtils ctrlu = new ControladorUtils();


    public List<Users> getUsers(int idUser) {
        List<Users> lista = new ArrayList<>();


        try ( Conexion con = new Conexion()) {

            String consulta = "SELECT * FROM users JOIN model_has_roles ON users.id = model_has_roles.model_id "
                    + "JOIN roles ON model_has_roles.role_id = roles.id WHERE roles.name != 'usuario' AND users.id != " +idUser + ";";
           
            ResultSet rc = con.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                String nombre = rc.getString("nombre");
                String apellido = rc.getString("apellido");
                Date fecha_na = rc.getDate("fecha_nacimiento");
                String email = rc.getString("email");
                String celular = rc.getString("celular");
                
                int roleId = rc.getInt("role_id");
                String roleName = rc.getString("name");
                lista.add(new Users(id, nombre, apellido, fecha_na, email, celular, roleId, roleName));
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public void agregarUsuario(String nombre, String apellido, String celular, Date selectedDate, String correo, String contrasenia, int rol) {

        Timestamp timestamp = ctrlu.crearTimestamp();
        String ContraseniaEncrypt = encriptarContrasenia(contrasenia);
        java.sql.Date fechaNacimiento = new java.sql.Date(selectedDate.getTime());
        String consulta = "INSERT INTO users(nombre,apellido,fecha_nacimiento,email,password,celular,created_at,updated_at) "
                + "VALUES('" + nombre + "', '" + apellido + "', '" + fechaNacimiento + "','" + correo + "','" + ContraseniaEncrypt + "','" + celular + "','" + timestamp + "','" + timestamp + "');";
        try ( Conexion con = new Conexion()) {
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

    public void actualizarUsuario(int id, String nombre, String apellido, String celular, Date selectedDate, String correo, int rol) {

        try ( Conexion con = new Conexion()) {
            java.sql.Date fechaNacimiento = new java.sql.Date(selectedDate.getTime());

            String consulta = "UPDATE users SET nombre = '" + nombre + "', apellido = '" + apellido + "', fecha_nacimiento  = '" + fechaNacimiento + "', email = '" + correo + "', celular = '" + celular + "',updated_at = '" + ctrlu.crearTimestamp() + "' WHERE id = " + id;

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
                        + "VALUES(" + rol + ",'App\\\\Models\\\\User'," + id + ")";

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

    public void actualizarPerfil(String name, String lastname, Date date, String email,String emailAnt) {

        Modelo.Users user = new Users();
        try ( Conexion con = new Conexion()) {

            java.sql.Date fechaNacimiento = new java.sql.Date(date.getTime());

            String consulta = "UPDATE users SET nombre = '" + name + "', apellido = '" + lastname + "', fecha_nacimiento  = '" + fechaNacimiento + "',email = '"+email+"',updated_at = '" + ctrlu.crearTimestamp() + "' WHERE email = '" + emailAnt + "';";

            user.setNombre(name);
            user.setApellido(lastname);
            boolean res = con.ejecutar(consulta);

            if (res) {
                System.out.println("perfil actualizado");
            } else {
                System.out.println("Error al actualizar perfil.");
            }

        } catch (Exception e) {
        }

    }

    public int obtenerRol(JComboBox rol) {

        String opcion = (String) rol.getSelectedItem();
        if (opcion.equalsIgnoreCase("Administrador")) {
            return 2;
        } else if (opcion.equalsIgnoreCase("Empleado")) {
            return 3;
        } else {
            return 1;
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

    public boolean validarCampos(String nombre, String apellido, String celular, Date selectedDate, String correo, String contrasenia, JComboBox rol) {
        boolean validacionRol = validarOpcionRol(rol);

        return !(nombre.equals("") || apellido.equals("") || celular.equals("") || selectedDate == null || correo.equals("") || contrasenia.equals("") || !validacionRol);
    }

    public boolean validarOpcionRol(JComboBox item) {

        String opcion = (String) item.getSelectedItem();

        return opcion.equalsIgnoreCase("Administrador") || opcion.equalsIgnoreCase("Empleado") || opcion.equalsIgnoreCase("Usuario");

    }

    public boolean validarFecha(Date selectedDate) {

        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.setTime(selectedDate);
        Calendar maximum = Calendar.getInstance();
        maximum.add(Calendar.YEAR, -18);

        if (fechaNacimiento.after(maximum)) {
            return false;
        } else {
            return true;
        }
//            Date currentDate = new Date();
//            return selectedDate.before(currentDate);

    }

    public boolean validarCorreo(String email) {

        String patronCorreo = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}";

        String consulta = "SELECT COUNT(*) AS cantidad FROM users WHERE email = '" + email + "'";
        try ( Conexion con = new Conexion()) {

            Pattern patron = Pattern.compile(patronCorreo);
            Matcher matcher = patron.matcher(email);

            if (matcher.matches()) {

                try {
                    ResultSet rs = con.consulta(consulta);
                    if (rs.next()) {
                        int cantidad = rs.getInt("cantidad");

                        if (cantidad > 0) {
                            return false;
                        } else {
                            return true;
                        }
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
        String ContraseniaOld = BCrypt.hashpw(contrasenia, salt);
         String passwordNew = ContraseniaOld.substring(0, 2) + "y" + ContraseniaOld.substring(3, ContraseniaOld.length());

        return passwordNew;

    }

    public void actualizarContrasenia(int id, String newPass) {

        String newPassEncryp = encriptarContrasenia(newPass);

        String consulta = "UPDATE users SET password = '" + newPassEncryp + "', updated_at = '" + ctrlu.crearTimestamp() + "' WHERE id =  " + id;

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

    public boolean validarCamposPerfil(String nombre, String apellido, Date seleDate,String correo) {

        return !(nombre.equals("") || apellido.equals("") || seleDate == null || correo.equals(""));
    }

    public boolean validarSeleccionTabla(int rowSelected) {
        return rowSelected != -1;
    }

    public int obtenerIdUsuario(String email) {

        String consulta = "SELECT id FROM users WHERE email = '" + email + "';";

        try ( Conexion con = new Conexion()) {
            ResultSet rs = con.consulta(consulta);

            if (rs.next()) {

                int id = rs.getInt("id");

                return id;

            }
        } catch (SQLException e) {

            System.out.println("Error al obtener rol: " + e);
        }
        return 0;

    }
    
    public boolean obtenerNumeroRol(int id){
        String consulta = "SELECT role_id FROM model_has_roles WHERE model_id = " + id + ";";

        try ( Conexion con = new Conexion()) {
            ResultSet rs = con.consulta(consulta);

            if (rs.next()) {

                int rol = rs.getInt("role_id");

                return rol == 2;

            }
        } catch (SQLException e) {

            System.out.println("Error al obtener rol: " + e);
        }
        return false;
    }
   
}
