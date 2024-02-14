/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jdelg
 */
public class ControladorReportes {

    ControladorMesas objControladorMesas = new ControladorMesas();
    ControladorPedidos objControladorPedidos = new ControladorPedidos();
    ControladorFacturas objControladorFacturas = new ControladorFacturas();
    ControladorProductos objControladorProductos = new ControladorProductos();

    public boolean generarReporteExcel(List<Modelo.Compra> data, String fileName, String filePath) {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("productos");

        // Crear formato para centrar el contenido
        CellStyle centeredWrapStyle = book.createCellStyle();
        centeredWrapStyle.setAlignment(HorizontalAlignment.CENTER);
        centeredWrapStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        centeredWrapStyle.setWrapText(true);

        // Crear formato para el color de fondo de las celdas
        CellStyle coloredStyle = book.createCellStyle();
        coloredStyle.cloneStyleFrom(centeredWrapStyle);
        coloredStyle.setFillForegroundColor(IndexedColors.PLUM.getIndex());
        coloredStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Crear formato para las celdas de texto
        CellStyle textCellStyle = book.createCellStyle();
        textCellStyle.cloneStyleFrom(coloredStyle); // Clonar estilo centrado
        Font textFont = book.createFont();
        textFont.setColor(IndexedColors.WHITE.getIndex());
        textCellStyle.setFont(textFont);

        // Crear formato para las fechas
        CreationHelper creationHelper = book.getCreationHelper();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.cloneStyleFrom(centeredWrapStyle);
        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss"));

        // Obtener la fecha actual
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);

        // Escribir la fecha en una celda específica
        Row dateRow = sheet.createRow(1);
        Cell dateCell = dateRow.createCell(1);
        dateCell.setCellValue("Fecha del reporte:");
        dateCell.setCellStyle(dateStyle);

        Cell valueCell = dateRow.createCell(2);
        valueCell.setCellValue(formattedDate);

        //titulos
        Row rowTitulo = sheet.createRow(3);

        String[] titulos = {"Fecha", "Id compra", "Comentario", "No mesa", "Empleado", "Costo total", "", "", "Id compra", "Id producto",
            "Nombre", "cantidad"};

        for (int i = 1; i <= titulos.length; i++) {
            if (!titulos[i - 1].equals("")) {
                Cell cell = rowTitulo.createCell(i);
                cell.setCellValue(titulos[i - 1]);
                cell.setCellStyle(centeredWrapStyle);
                cell.setCellStyle(coloredStyle);
                cell.setCellStyle(textCellStyle);
            }
        }

        int rowNum = 4;
        for (Modelo.Compra compra : data) {
            Modelo.Mesas objMesa = objControladorMesas.getMesa(compra.getMesas_id());
            Modelo.Users objUser = objControladorPedidos.getUsuario(compra.getUsuarios_id());

            Object[] valoresCompra = {compra.getFecha_hora(), compra.getIdCompra(), compra.getComentario(), objMesa.getNumero_mesa(),
                objUser.getNombre() + " " + objUser.getApellido(), compra.getCosto_total()};

            Row row = sheet.createRow(rowNum++);
            for (int i = 1; i <= 6; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(valoresCompra[i - 1].toString());
                cell.setCellStyle(centeredWrapStyle);
                if (i == 1) {
                    cell.setCellStyle(dateStyle);
                }
            }
        }

        rowNum = 4;
        for (Modelo.Compra compra : data) {
            List<Modelo.Factura> objFactura = objControladorFacturas.getFacturas(compra.getIdCompra());

            //recorremos los productos
            for (int nProductos = 0; nProductos < objFactura.size(); nProductos++) {
                int contadorCeldaProductos = 9;
                int productoId = objFactura.get(nProductos).getProductos_id();
                Modelo.Productos producto = objControladorProductos.getProducto(productoId);

                Object[] valoresProducto = {compra.getIdCompra(), productoId, producto.getNombre(), objFactura.get(nProductos).getCantidad_producto()};

                Row row;
                if (sheet.getRow(rowNum) == null) {
                    row = sheet.createRow(rowNum);
                } else {
                    row = sheet.getRow(rowNum);
                }

                //llenar celdas de fila x
                for (Object valoresProducto1 : valoresProducto) {
                    Cell cell = row.createCell(contadorCeldaProductos);
                    cell.setCellValue(valoresProducto1.toString());
                    cell.setCellStyle(centeredWrapStyle);
                    contadorCeldaProductos++;
                }
                rowNum++;
            }
        }

        for (int i = 1; i <= titulos.length; i++) {
            if (!titulos[i - 1].equals("")) {
                sheet.setColumnWidth(i, 6000);
            }
        }

        try {
            // Write the workbook in file system
            FileOutputStream out = new FileOutputStream(filePath + "\\" + fileName + ".xlsx");
            book.write(out);
            out.close();
            book.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

}
