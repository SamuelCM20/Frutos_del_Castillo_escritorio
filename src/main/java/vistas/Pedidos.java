/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import Modelo.Users;
import controladores.ControladorFacturas;
import controladores.ControladorMesas;
import controladores.ControladorPedidos;
import controladores.ControladorProductos;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author samue
 */
public class Pedidos extends javax.swing.JPanel {

    String tercerColor = "#601d49";
    String cuartoColor = "#491738";

    /**
     * Creates new form Pedidos
     */
    public Pedidos() {
        initComponents();
        /*JTableHeader header = tablePedidos.getTableHeader();
        JTableHeader headerP = tablePediProducts.getTableHeader();
        
        index i = new index();
        i.tableColor(header);
        i.tableColor(headerP);
         */

        tableModel();
        fillRows();
    }

    int rowSelected = -1;
    private ControladorPedidos objControlador = new ControladorPedidos();
    private ControladorProductos objControladorProductos = new ControladorProductos();
    private ControladorMesas objControladorMesas = new ControladorMesas();
    private ControladorFacturas objControladorFacturas = new ControladorFacturas();

    private DefaultTableModel modelTable2;
    private DefaultTableModel modelTable1;
    private List<Modelo.Compra> listaPedidos;

    public void tableModel() {
        modelTable1 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelTable1.addColumn("Codigo");
        modelTable1.addColumn("Producto");
        modelTable1.addColumn("Cantidad");

        tablePediProducts.setModel(modelTable1);
        tablePediProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        modelTable2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        modelTable2.addColumn("Pedido");
        modelTable2.addColumn("Mesa");
        modelTable2.addColumn("Disponibilidad");
        modelTable2.addColumn("Fecha");

        tablePedidos.setModel(modelTable2);
        tablePedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void fillRows() {
        modelTable2.setRowCount(0);
        listaPedidos = objControlador.getPedidos();

        listaPedidos.forEach(l -> {
            Modelo.Mesas objMesa = objControladorMesas.getMesa(l.getMesas_id());
            modelTable2.addRow(new Object[]{"¡Nuevo pedido!", objMesa, "en proceso...", l.getFecha_hora()});
        });
    }

    public void fillRowsPedidosProductos(int idCompra) {
        modelTable1.setRowCount(0);
        List<Modelo.Factura> listaPedidos = objControladorFacturas.getFacturas(idCompra);

        listaPedidos.forEach(l -> {
            Modelo.Productos objProducto = objControladorProductos.getProducto(l.getProductos_id());

            modelTable1.addRow(new Object[]{l.getIdFactura(), objProducto.getNombre(), l.getCantidad_producto()});
        });
    }

    public void fillFields() {
        Modelo.Compra pedido = (Modelo.Compra) listaPedidos.get(rowSelected);
        Modelo.Mesas mesa = (Modelo.Mesas) tablePedidos.getValueAt(rowSelected, 1);

        Users usuario = objControlador.getUsuario(pedido.getUsuarios_id());

        fieldEmpleado.setText(usuario.getNombre().toUpperCase());

        fieldMesa.setText(String.valueOf(mesa.getNumero_mesa()));
        fieldComentario.setText(pedido.getComentario());

        fillRowsPedidosProductos(pedido.getIdCompra());
    }

    public void limpiarCampos() {
        fieldComentario.setText("");
        fieldMesa.setText("");
        fieldEmpleado.setText("");

        modelTable1.setRowCount(0);
        rowSelected = -1;
    }

    public void validacionCampos() {
        if (rowSelected != -1) {
            Modelo.Compra pedido = (Modelo.Compra) listaPedidos.get(rowSelected);
            if (objControlador.actualizarPedido(pedido.getIdCompra())) {
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

        jLabel4 = new javax.swing.JLabel();
        labelCliente1 = new javax.swing.JLabel();
        panelPedidos = new javax.swing.JPanel();
        labelTitlePedidos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Pedido hecho por:");

        labelCliente1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente1.setText("Nombre del cliente:");

        panelPedidos.setBackground(new java.awt.Color(245, 245, 220));

        labelTitlePedidos.setBackground(new java.awt.Color(255, 255, 255));
        labelTitlePedidos.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitlePedidos.setForeground(new java.awt.Color(96, 29, 73));
        labelTitlePedidos.setText("Gestionar Pedidos");

        tablePedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 29, 73)));
        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"!Nuevo Pedido!", "Mesa 1", "en proceso,,,", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pedido", "Numero Mesa", "Disponibilidad", "Fecha"
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelMesaN.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelMesaN.setText("Mesa:");

        panelHeaderProducts.setBackground(new java.awt.Color(96, 29, 73));
        panelHeaderProducts.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Añadir productos");

        javax.swing.GroupLayout panelHeaderProductsLayout = new javax.swing.GroupLayout(panelHeaderProducts);
        panelHeaderProducts.setLayout(panelHeaderProductsLayout);
        panelHeaderProductsLayout.setHorizontalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderProductsLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(73, 73, 73))
        );
        panelHeaderProductsLayout.setVerticalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        fieldMesa.setEditable(false);
        fieldMesa.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMesaActionPerformed(evt);
            }
        });

        labelEmpleado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelEmpleado.setText("Empleado:");

        fieldEmpleado.setEditable(false);
        fieldEmpleado.setMargin(new java.awt.Insets(2, 7, 2, 7));

        labelCliente.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente.setText("Comentario:");

        fieldComentario.setEditable(false);
        fieldComentario.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldComentarioActionPerformed(evt);
            }
        });

        labelCliente2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCliente2.setText("Pedido:");

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

        btnCancelarP.setBackground(new java.awt.Color(133, 33, 33));
        btnCancelarP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnCancelarP.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarP.setText("Cancelar");
        btnCancelarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPActionPerformed(evt);
            }
        });

        btnCompletarP.setBackground(new java.awt.Color(96, 29, 73));
        btnCompletarP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnCompletarP.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletarP.setText("Completar");
        btnCompletarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletarPActionPerformed(evt);
            }
        });

        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factura.png"))); // NOI18N
        btnFactura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        labelPrecio.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelPrecio.setText("Total:");

        labelValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelValorTotal.setText("$0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeaderProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnCompletarP)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelCliente2)
                                    .addGap(74, 74, 74)
                                    .addComponent(labelPrecio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelEmpleado)
                                        .addComponent(labelMesaN))
                                    .addGap(23, 23, 23)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fieldEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(fieldMesa)))
                                .addComponent(labelCliente)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(fieldComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelHeaderProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMesaN))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldEmpleado)
                    .addComponent(labelEmpleado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente2)
                    .addComponent(labelPrecio)
                    .addComponent(labelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelarP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompletarP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Historial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addComponent(labelTitlePedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(labelTitlePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
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
        // TODO add your handling code here:
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
        if(frame != null){
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
    private javax.swing.JPanel panelHeaderProducts;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JTable tablePediProducts;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables
}
