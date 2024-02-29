/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author SENA
 */
public class CustomHeaderRenderer extends DefaultTableCellRenderer {

    private Border border = new LineBorder(Color.gray, 1);
    private Insets padding = new Insets(5, 10, 5, 10);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBackground(new Color(96, 29, 73));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(padding.top, padding.left, padding.bottom, padding.right)));

        
        return label;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}
