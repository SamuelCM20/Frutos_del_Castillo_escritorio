/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Modelo.Conexion;
import Modelo.Factura;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jd
 */
public class ControladorFacturas {

    public void dibujarLinea(PdfContentByte cb, Document documento, float grosor, float altura) {
        // Establecer el grosor de la línea
        cb.setLineWidth(grosor); // Grosor de 1 punto

        // Establecer el color de la línea (opcional)
        cb.setRGBColorStroke(133, 33, 33);

        // Dibujar una línea en la parte superior del documento
        cb.moveTo(0f, documento.top() + altura); // cm a puntos(1 cm = 28.3465 puntos)
        cb.lineTo(documento.getPageSize().getWidth() + 2f, documento.top() + altura);
        cb.stroke();
    }

    public static void cargarImagen(String rutaImagen, Document documento) {
        // Cargar la imagen como un objeto Image de iText

        Image imagen;
        try {
            imagen = Image.getInstance(ControladorFacturas.class.getClassLoader().getResource(rutaImagen));
            imagen.scaleToFit(80, 80);

            // Calcular las coordenadas para la esquina superior derecha
            float x = documento.getPageSize().getWidth() - imagen.getScaledWidth() - 10;
            float y = documento.getPageSize().getHeight() - imagen.getScaledHeight() - 30;

            imagen.setAbsolutePosition(x, y);

            try {
                documento.add(imagen);
            } catch (DocumentException ex) {
                Logger.getLogger(ControladorFacturas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BadElementException ex) {
            Logger.getLogger(ControladorFacturas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean generarFacturaPDF(Modelo.Compra objCompra, Modelo.Mesas objMesa, Modelo.Users objUsuario, List<Modelo.Factura> listaPedidos, String folderPath) {

        ControladorProductos objControladorProductos = new ControladorProductos();

        String fecha = ControladorUtils.getFecha();

        try {

            Document documento = new Document();
            documento.setPageSize(PageSize.A4);

            String nombreArchivo = "FACTURA#" + objCompra.getIdCompra() + fecha + ".pdf";
            nombreArchivo = nombreArchivo.replaceAll("[^a-zA-Z0-9.-]", "_");

            String rutaArchivoPDF = folderPath + File.separator + nombreArchivo;
            FileOutputStream out = new FileOutputStream(rutaArchivoPDF);

            //Crear el archivo PDF
            PdfWriter writer = PdfWriter.getInstance(documento, out);
            documento.open();

            PdfContentByte cb = writer.getDirectContent();
            dibujarLinea(cb, documento, 25f, 32f);

            String rutaImagen = "img/laromanaRojo.png";
            cargarImagen(rutaImagen, documento);

            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA, 18, new BaseColor(133, 33, 33));
            Font fontPrecioTotal = FontFactory.getFont(FontFactory.HELVETICA, 23, new BaseColor(133, 33, 33));
            Font fontTableTitles = FontFactory.getFont(FontFactory.HELVETICA, 16, new BaseColor(133, 33, 33));

            Paragraph texto = new Paragraph("La Romana Pizza", fontTitle);

            String empleado = objUsuario.getNombre() + " " + objUsuario.getApellido();
            documento.add(texto);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Fecha factura: " + fecha));
            documento.add(new Paragraph("Empleado: " + empleado));
            documento.add(new Paragraph("No mesa: " + objMesa.getNumero_mesa()));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));

            // Crear una tabla sin bordes
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);

            String[][] titles = {
                {"CANTIDAD"},
                {"PRODUCTO"},
                {"PRECIO UNIDAD"}
            };

            for (String[] fila : titles) {
                for (String dato : fila) {
                    com.itextpdf.text.Paragraph txtCelda = new com.itextpdf.text.Paragraph(dato, fontTableTitles);
                    PdfPCell celda = new PdfPCell();
                    celda.addElement(txtCelda);
                    celda.setBorderWidth(0);
                    celda.setPadding(10);
                    tabla.addCell(celda);
                }
            }

            for (int i = 0; i < listaPedidos.size(); i++) {
                Modelo.Productos objProducto = objControladorProductos.getProducto(listaPedidos.get(i).getProductos_id());
                String[] valores = {String.valueOf(listaPedidos.get(i).getCantidad_producto()), objProducto.getNombre(), String.valueOf(objProducto.getPrecio())};

                for (String v : valores) {       
                    PdfPCell celda = new PdfPCell(new com.itextpdf.text.Paragraph(v));
                    celda.setBorderWidth(0);
                    celda.setPadding(10);
                    tabla.addCell(celda);
                }
            }

            PdfContentByte cb2 = writer.getDirectContent();
            dibujarLinea(cb2, documento, 1f, -120f);

            Paragraph txtPrecioTotal = new Paragraph("TOTAL FACTURA: $" + objCompra.getCosto_total(), fontPrecioTotal);
            documento.add(txtPrecioTotal);
            documento.add(new Paragraph(" "));

            documento.add(tabla);
            documento.close();

            System.out.println("Archivo PDF generado correctamente.");
            return true;
        } catch (Exception ex) {
            System.out.println("Error al generar el archivo PDF: " + ex.getMessage());
            return false;
        }
    }

    public List<Factura> getFacturas(int idCompra) {
        List<Factura> lista = new ArrayList<>();
         String consulta = "select * from factura where compra_id = ?";
        try ( Conexion objConexion = new Conexion();PreparedStatement ps = objConexion.prepareStatement(consulta)) {

           
            ps.setInt(1, idCompra);
            ResultSet rc = ps.executeQuery();
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
