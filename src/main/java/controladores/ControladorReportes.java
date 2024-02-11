/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jdelg
 */
public class ControladorReportes {

    ControladorMesas objControladorMesas = new ControladorMesas();
    ControladorPedidos objControladorPedidos = new ControladorPedidos();

    public boolean generarReporteExcel(List<Modelo.Compra> data, String fileName, String filePath) {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("productos");

        // Crear formato para centrar el contenido
        CellStyle centeredStyle = book.createCellStyle();
        centeredStyle.setAlignment(HorizontalAlignment.CENTER);

        // Crear formato para el color de fondo de las celdas
        CellStyle coloredStyle = book.createCellStyle();
        coloredStyle.cloneStyleFrom(centeredStyle);
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
        dateStyle.cloneStyleFrom(centeredStyle);
        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss"));

        //titulos
        Row rowTitulo = sheet.createRow(1);

        String[] titulos = {"Fecha", "Id", "Comentario", "No mesa", "Costo total", "Empleado"};

        for (int i = 1; i <= titulos.length; i++) {
            Cell cell = rowTitulo.createCell(i);
            cell.setCellValue(titulos[i - 1]);
            cell.setCellStyle(centeredStyle);
            cell.setCellStyle(coloredStyle);
            cell.setCellStyle(textCellStyle);
        }

        int rowNum = 2;
        for (Modelo.Compra compra : data) {
            Modelo.Mesas objMesa = objControladorMesas.getMesa(compra.getMesas_id());
            Modelo.Users objUser = objControladorPedidos.getUsuario(compra.getUsuarios_id());

            Object[] valores = {compra.getFecha_hora(), compra.getIdCompra(), compra.getComentario(), objMesa.getNumero_mesa(), compra.getCosto_total(), objUser.getNombre() + " " + objUser.getApellido()};

            Row row = sheet.createRow(rowNum++);
            for (int i = 1; i <= 6; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(valores[i - 1].toString());
                cell.setCellStyle(centeredStyle);
                if(i == 1){
                    cell.setCellStyle(dateStyle);
                }
            }
        }

        for (int i = 1; i < 7; i++) {
            sheet.setColumnWidth(i, 6000);
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
