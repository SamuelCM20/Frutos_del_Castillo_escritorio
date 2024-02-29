/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jdelg
 */
public class CustomCellRenderer extends DefaultTableCellRenderer{
    private static final int ROW_HEIGHT = 30;
    private int padding = 5;
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        ((JComponent) cellComponent).setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        table.setRowHeight(row, ROW_HEIGHT);

        return cellComponent;
    }

}
