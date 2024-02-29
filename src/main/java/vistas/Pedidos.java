/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import Modelo.Users;
import controladores.ControladorUtils;
import controladores.ControladorFacturas;
import controladores.ControladorMesas;
import controladores.ControladorPedidos;
import controladores.ControladorProductos;
import controladores.CustomCellRenderer;
import controladores.CustomHeaderRenderer;
import java.awt.Color;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samue
 */
public class Pedidos extends javax.swing.JPanel {

    //hola
    String tercerColor = "#601d49";
    String cuartoColor = "#491738";

    /**
     * Creates new form Pedidos
     */
    public Pedidos() {
        initComponents();

        tableModel();
        fillRows();
        tablePedidos.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        tablePedidos.setDefaultRenderer(Object.class, new CustomCellRenderer());
        tablePediProducts.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        tablePediProducts.setDefaultRenderer(Object.class, new CustomCellRenderer());
        
        btnFactura.setBackground(Color.WHITE);
    }

    int rowSelected = -1;
    private ControladorPedidos objControladorPedidos = new ControladorPedidos();
    private ControladorProductos objControladorProductos = new ControladorProductos();
    private ControladorMesas objControladorMesas = new ControladorMesas();
    private ControladorFacturas objControladorFacturas = new ControladorFacturas();
    
    private ControladorUtils objControladorUtils = new ControladorUtils();

    //se utilizan para imprimir la factura
    Users usuarioEmpleadoPedido;
    List<Modelo.Factura> listaPedidosFacturas;

    private DefaultTableModel modelTableCompras;
    private DefaultTableModel modelTableProductos;
    private List<Modelo.Compra> listaPedidos;

    public void tableModel() {
        String[] titulosTablaProductos = {"Codigo", "Producto", "Cantidad"};
        modelTableProductos = objControladorUtils.addTableModel(modelTableProductos, tablePediProducts, titulosTablaProductos);
        
        String[] titulosTablaCompras = {"Pedido", "Mesa", "Estado", "Fecha"};
        modelTableCompras = objControladorUtils.addTableModel(modelTableCompras, tablePedidos, titulosTablaCompras);
    }

    public void fillRows() {
        modelTableCompras.setRowCount(0);
        listaPedidos = objControladorPedidos.getPedidos();

        listaPedidos.forEach(l -> {
            Modelo.Mesas objMesa = objControladorMesas.getMesa(l.getMesas_id());
            modelTableCompras.addRow(new Object[]{"¡Nuevo pedido!", objMesa, "en proceso...", l.getFecha_hora()});
        });
    }

    public void fillRowsPedidosProductos(int idCompra) {
        modelTableProductos.setRowCount(0);

        Modelo.Compra pedido = (Modelo.Compra) listaPedidos.get(rowSelected);
        labelValorTotal.setText("$" + String.valueOf(pedido.getCosto_total()));

        listaPedidosFacturas = objControladorFacturas.getFacturas(idCompra);

        listaPedidosFacturas.forEach(l -> {
            Modelo.Productos objProducto = objControladorProductos.getProducto(l.getProductos_id());

            modelTableProductos.addRow(new Object[]{l.getIdFactura(), objProducto.getNombre(), l.getCantidad_producto()});
        });
    }

    public void fillFields() {
        Modelo.Compra pedido = (Modelo.Compra) listaPedidos.get(rowSelected);
        Modelo.Mesas mesa = (Modelo.Mesas) tablePedidos.getValueAt(rowSelected, 1);

        usuarioEmpleadoPedido = objControladorPedidos.getUsuario(pedido.getUsuarios_id());

        fieldEmpleado.setText(usuarioEmpleadoPedido.getNombre().toUpperCase() + " " + usuarioEmpleadoPedido.getApellido().toUpperCase());

        fieldMesa.setText(String.valueOf(mesa.getNumero_mesa()));
        fieldComentario.setText(pedido.getComentario());

        fillRowsPedidosProductos(pedido.getIdCompra());
    }

    public void limpiarCampos() {
        fieldComentario.setText("");
        fieldMesa.setText("");
        fieldEmpleado.setText("");
        labelValorTotal.setText("$");

        modelTableProductos.setRowCount(0);
        rowSelected = -1;
    }

    public void validacionCampos() {
        if (rowSelected != -1) {
            Modelo.Compra pedido = (Modelo.Compra) listaPedidos.get(rowSelected);
            if (objControladorPedidos.actualizarPedido(pedido.getIdCompra())) {
                fillRows();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Pedido tomado con exito.");
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al tomar el pedido.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se necesita seleccionar un pedido de la tabla.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel4 = new javax.swing.JLabel();
        labelCliente1 = new javax.swing.JLabel();
        panelPedidos = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        labelTitlePedidos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labelMesaN = new javax.swing.JLabel();
        panelHeaderProducts = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldMesa = new javax.swing.JTextField();
        labelEmpleado = new javax.swing.JLabel();
        fieldEmpleado = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        fieldComentario = new javax.swing.JTextField();
        labelCliente2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePediProducts = new javax.swing.JTable();
        btnCancelarP = new javax.swing.JButton();
        btnCompletarP = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        labelPrecio = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Pedido hecho por:");

        labelCliente1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente1.setText("Nombre del cliente:");

        setBackground(new java.awt.Color(238, 238, 213));
        setLayout(new java.awt.GridBagLayout());

        panelPedidos.setBackground(new java.awt.Color(245, 245, 220));
        panelPedidos.setMinimumSize(new java.awt.Dimension(980, 580));
        panelPedidos.setPreferredSize(new java.awt.Dimension(980, 580));
        panelPedidos.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(245, 245, 220));
        panelHeader.setMinimumSize(new java.awt.Dimension(986, 81));
        panelHeader.setPreferredSize(new java.awt.Dimension(565, 100));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitlePedidos.setBackground(new java.awt.Color(255, 255, 255));
        labelTitlePedidos.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitlePedidos.setForeground(new java.awt.Color(96, 29, 73));
        labelTitlePedidos.setText("Gestionar Pedidos");
        panelHeader.add(labelTitlePedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, 56));

        jButton1.setBackground(new java.awt.Color(96, 29, 73));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelHeader.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(874, 35, 112, 34));

        jButton2.setBackground(new java.awt.Color(96, 29, 73));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Historial");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelHeader.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 35, 112, 34));

        panelPedidos.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelBody.setLayout(new java.awt.GridLayout(1, 4));

        jPanel3.setBackground(new java.awt.Color(245, 245, 220));
        jPanel3.setLayout(new java.awt.CardLayout(20, 20));

        jPanel1.setBackground(new java.awt.Color(245, 245, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMesaN.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelMesaN.setText("Mesa:");
        jPanel1.add(labelMesaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, -1, -1));

        panelHeaderProducts.setBackground(new java.awt.Color(96, 29, 73));
        panelHeaderProducts.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Completar pedido");

        javax.swing.GroupLayout panelHeaderProductsLayout = new javax.swing.GroupLayout(panelHeaderProducts);
        panelHeaderProducts.setLayout(panelHeaderProductsLayout);
        panelHeaderProductsLayout.setHorizontalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderProductsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(294, Short.MAX_VALUE))
        );
        panelHeaderProductsLayout.setVerticalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel1.add(panelHeaderProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));

        fieldMesa.setEditable(false);
        fieldMesa.setBackground(new java.awt.Color(255, 255, 255));
        fieldMesa.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMesaActionPerformed(evt);
            }
        });
        jPanel1.add(fieldMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 44, 76, 30));

        labelEmpleado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelEmpleado.setText("Empleado:");
        jPanel1.add(labelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 90, -1, -1));

        fieldEmpleado.setEditable(false);
        fieldEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        fieldEmpleado.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jPanel1.add(fieldEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 84, 330, -1));

        labelCliente.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente.setText("Comentario:");
        jPanel1.add(labelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 128, -1, -1));

        fieldComentario.setEditable(false);
        fieldComentario.setBackground(new java.awt.Color(255, 255, 255));
        fieldComentario.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldComentarioActionPerformed(evt);
            }
        });
        jPanel1.add(fieldComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 122, 330, -1));

        labelCliente2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente2.setText("Pedido:");
        jPanel1.add(labelCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 166, -1, -1));

        tablePediProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Cantidad"
            }
        ));
        tablePediProducts.setDoubleBuffered(true);
        tablePediProducts.setGridColor(new java.awt.Color(204, 204, 204));
        tablePediProducts.setSelectionBackground(new java.awt.Color(173, 0, 113));
        tablePediProducts.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablePediProducts.setShowHorizontalLines(true);
        tablePediProducts.setShowVerticalLines(true);
        tablePediProducts.getTableHeader().setResizingAllowed(false);
        tablePediProducts.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePediProducts);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 197, 420, 129));

        btnCancelarP.setBackground(new java.awt.Color(133, 33, 33));
        btnCancelarP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnCancelarP.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarP.setText("Cancelar");
        btnCancelarP.setBorderPainted(false);
        btnCancelarP.setFocusPainted(false);
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, 98, 35));

        btnCompletarP.setBackground(new java.awt.Color(96, 29, 73));
        btnCompletarP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnCompletarP.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletarP.setText("Completar");
        btnCompletarP.setBorderPainted(false);
        btnCompletarP.setFocusPainted(false);
        btnCompletarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarPActionPerformed(evt);
            }
        });
        jPanel1.add(btnCompletarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 390, -1, 35));

        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura.png"))); // NOI18N
        btnFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 80));

        labelPrecio.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelPrecio.setText("Total:");
        jPanel1.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 166, -1, -1));

        labelValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelValorTotal.setText("$");
        jPanel1.add(labelValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 160, 91, 27));

        jPanel3.add(jPanel1, "card2");

        panelBody.add(jPanel3);

        panelTable.setBackground(new java.awt.Color(245, 245, 220));
        panelTable.setLayout(new java.awt.CardLayout(20, 20));

        tablePedidos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"!Nuevo Pedido!", "Mesa 1", "en proceso,,,", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pedido", "Numero Mesa", "Estado", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePedidos.setGridColor(new java.awt.Color(204, 204, 204));
        tablePedidos.setSelectionBackground(new java.awt.Color(173, 0, 113));
        tablePedidos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablePedidos.setShowGrid(true);
        tablePedidos.getTableHeader().setResizingAllowed(false);
        tablePedidos.getTableHeader().setReorderingAllowed(false);
        tablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePedidos);
        if (tablePedidos.getColumnModel().getColumnCount() > 0) {
            tablePedidos.getColumnModel().getColumn(0).setResizable(false);
            tablePedidos.getColumnModel().getColumn(1).setResizable(false);
            tablePedidos.getColumnModel().getColumn(2).setResizable(false);
        }

        panelTable.add(jScrollPane1, "card2");

        panelBody.add(panelTable);

        panelPedidos.add(panelBody, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelPedidos, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldComentarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldComentarioActionPerformed

    private void fieldMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMesaActionPerformed

    private void btnCompletarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarPActionPerformed
        validacionCampos();
    }//GEN-LAST:event_btnCompletarPActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed

        if (rowSelected != -1) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {

                String folderPath = fileChooser.getSelectedFile().getAbsolutePath();

                Modelo.Mesas objMesa = (Modelo.Mesas) modelTableCompras.getValueAt(rowSelected, 1);
                Modelo.Compra objPedido = (Modelo.Compra) listaPedidos.get(rowSelected);

                boolean facturaGenerada = objControladorFacturas.generarFacturaPDF(objPedido, objMesa, usuarioEmpleadoPedido, listaPedidosFacturas, folderPath);

                if (facturaGenerada) {
                    JOptionPane.showMessageDialog(null, "Factura guardada con exito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Hubo un error al guardar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una compra primero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void tablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidosMouseClicked
        rowSelected = tablePedidos.getSelectedRow();
        fillFields();
    }//GEN-LAST:event_tablePedidosMouseClicked

    private void btnCancelarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPActionPerformed
        limpiarCampos();

        ListSelectionModel selectionModel = tablePedidos.getSelectionModel();
        selectionModel.clearSelection();
    }//GEN-LAST:event_btnCancelarPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillRows();
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            HistorialPedidos obj = new HistorialPedidos(frame, true);
            obj.runView();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarP;
    private javax.swing.JButton btnCompletarP;
    private javax.swing.JButton btnFactura;
    private javax.swing.JTextField fieldComentario;
    private javax.swing.JTextField fieldEmpleado;
    private javax.swing.JTextField fieldMesa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCliente1;
    private javax.swing.JLabel labelCliente2;
    private javax.swing.JLabel labelEmpleado;
    private javax.swing.JLabel labelMesaN;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTitlePedidos;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeaderProducts;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelTable;
    private javax.swing.JTable tablePediProducts;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables
}
