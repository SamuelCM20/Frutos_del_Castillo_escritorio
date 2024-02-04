/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Factura;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdelg
 */
public class ControladorFacturas {

    public List<Factura> getFacturas(int idCompra) {
        List<Factura> lista = new ArrayList<>();

        try ( Conexion objConexion = new Conexion();) {

            String consulta = "select * from factura where compra_id = " + idCompra;

            ResultSet rc = objConexion.consulta(consulta);
            while (rc != null && rc.next()) {

                int id = rc.getInt("id");
                int cantidadProducto = rc.getInt("cantidad_producto");
                double subtotal = rc.getDouble("subtotal");
                double precio = rc.getDouble("precio");

                int compraId = rc.getInt("compra_id");
                int productoId = rc.getInt("producto_id");

                lista.add(new Factura(id, cantidadProducto, subtotal, precio, compraId, productoId));
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return lista;

    }

}
