/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Compra;
import Modelo.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jd
 */
public class ControladorPedidos {

    public boolean actualizarPedido(int compraId) {

        try ( Conexion objConexion = new Conexion()) {
            String consulta = "update compras set estado = 0 where id = " + compraId;

            boolean res = objConexion.ejecutar(consulta);

            return res;

        } catch (Exception e) {
        }
        return false;
    }

    public List<Compra> getPedidos() {
        List<Compra> lista = new ArrayList<>();

        String consulta = "SELECT c.id, c.user_id, c.fecha_hora, c.iva, c.costo_total, c.comentario, c.direccion, c.estado, c.mesa_id, m.numero_mesa, m.estado as 'mesa_estado' \n"
                + "from compras c\n"
                + "join mesas m \n"
                + "on c.mesa_id = m.id where c.estado = 1 AND mesa_id is NOT null;";

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                Date fechaHora = rc.getDate("fecha_hora");
                float iva = rc.getFloat("iva");
                double costoTotal = rc.getDouble("costo_total");
                String comentario = rc.getString("comentario");
                String direccion = rc.getString("direccion");

                int estado = rc.getInt("estado");
                int userId = rc.getInt("user_id");
                int mesaId = rc.getInt("mesa_id");
                String mesa_numero = rc.getString("numero_mesa");
                int mesa_estado = rc.getInt("mesa_estado");

                lista.add(new Compra(id, fechaHora, iva, costoTotal, comentario, direccion, estado, userId, mesaId, mesa_numero, mesa_estado));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }

    public List<Compra> getPedidosHistorial() {
        List<Compra> lista = new ArrayList<>();

        String consulta = "select c.id, c.user_id, c.fecha_hora, c.iva, c.costo_total, c.comentario, c.direccion, c.estado, c.mesa_id, m.numero_mesa, m.estado as 'mesa_estado' from compras c \n"
                + "join mesas m \n"
                + "on c.mesa_id = m.id where c.estado != 1;";

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                Date fechaHora = rc.getDate("fecha_hora");
                float iva = rc.getFloat("iva");
                double costoTotal = rc.getDouble("costo_total");
                String comentario = rc.getString("comentario");
                String direccion = rc.getString("direccion");

                int estado = rc.getInt("estado");
                int userId = rc.getInt("user_id");
                int mesaId = rc.getInt("mesa_id");
                String mesa_numero = rc.getString("numero_mesa");
                int mesa_estado = rc.getInt("mesa_estado");

                lista.add(new Compra(id, fechaHora, iva, costoTotal, comentario, direccion, estado, userId, mesaId, mesa_numero, mesa_estado));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;
    }

    public Users getUsuario(int usuarioId) {

        String consulta = "SELECT us.id AS 'user_id', us.nombre, us.apellido, us.email, us.fecha_nacimiento, us.password, us.celular, mrole.role_id, r.name AS 'role_name'\n"
                + "FROM users us\n"
                + "JOIN model_has_roles mrole ON us.id = mrole.model_id\n"
                + "JOIN roles r ON mrole.role_id = r.id \n"
                + "WHERE us.id= '" + usuarioId + "'";

        try ( Conexion objConexion = new Conexion()) {
            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("user_id");
                String nombre = rc.getString("nombre");
                String apellido = rc.getString("apellido");
                Date fechaNacimiento = rc.getDate("fecha_nacimiento");
                String email = rc.getString("email");
                String celular = rc.getString("celular");

                String role_name = rc.getString("role_name");
                int role_id = rc.getInt("role_id");

                return new Users(id, nombre, apellido, fechaNacimiento, email, celular, role_id, role_name);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return new Users();
    }
}
