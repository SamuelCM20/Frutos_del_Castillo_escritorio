/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import Modelo.Categorias;

import controladores.ControladorProductos;
import controladores.ControladorUtils;
import controladores.CustomCellRenderer;
import controladores.CustomHeaderRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author samue
 */
public class Productos extends javax.swing.JPanel {

    //hola
    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        tableModel();
        fillRows();
        llenarComboBoxCategorias();

        setColorBotones();
        tableProducts.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        tableProducts.setDefaultRenderer(Object.class, new CustomCellRenderer());

    }

    public void setColorBotones() {
        btnEditar.setContentAreaFilled(false);
        btnEditar.setOpaque(true);
        btnEditar.setBackground(new Color(96, 29, 73));

        btnImg1.setContentAreaFilled(false);
        btnImg1.setOpaque(true);
        btnImg1.setBackground(new Color(96, 29, 73));
    }
    private ControladorProductos objControlador = new ControladorProductos();
    private ControladorUtils objControladorUtils = new ControladorUtils();

    private DefaultComboBoxModel<Categorias> modelComboBox = new DefaultComboBoxModel<>();
    private DefaultTableModel modelTableProductos;
    private List<Modelo.Productos> listaProductos;

    int rowSelected = -1;

    public void limpiarCampos() {
        txtDescripcion.setText("");
        txtNameProduct.setText("");
        txtPrecioP.setText("");

        comboBoxCategoria.setSelectedIndex(0);
        comboBoxDispo.setSelectedIndex(0);
        iconProduct.setIcon(null);
        objControlador.setNullFile();

        rowSelected = -1;
    }

    public void tableModel() {
        String[] titulosTablaProductos = {"Codigo", "Nombre", "Precio", "Categoria", "Estado"};
        modelTableProductos = objControladorUtils.addTableModel(modelTableProductos, tableProducts, titulosTablaProductos);
    }

    public String getNombreCategoria(int id) {

        List<Categorias> listaCategorias = objControlador.getCategorias();

        String nombre = listaCategorias.stream()
                .filter(categoria -> categoria.getIdCategoria() == id)
                .map(Categorias::getNombre)
                .findFirst()
                .orElse(null);

        return nombre;
    }

    public String getNombreDisponibilidad(int identificador) {

        String nombre = "";
        if (identificador == 0) {
            nombre = "No disponible";
        } else if (identificador == 1) {
            nombre = "Disponible";
        }

        return nombre;

    }

    public void fillRows() {

        modelTableProductos.setRowCount(0);
        listaProductos = objControlador.getProductos();

        listaProductos.forEach(l -> {
            String cat = getNombreCategoria(l.getCategorias_id());
            String disponibilidad = getNombreDisponibilidad(l.getDisponibilidad());
            modelTableProductos.addRow(new Object[]{l.getIdProductos(), l.getNombre(), l.getPrecio(), cat, disponibilidad});
        });

    }

    public void llenarComboBoxCategorias() {
        List<Categorias> lista = objControlador.getCategorias();
        objControlador.fillComboBox(lista, comboBoxCategoria, modelComboBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelNameP1 = new javax.swing.JLabel();
        panelProducts = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        labelTitleProducts = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelHeaderProducts = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelNameP = new javax.swing.JLabel();
        labelCodigo = new javax.swing.JLabel();
        txtNameProduct = new javax.swing.JTextField();
        txtPrecioP = new javax.swing.JTextField();
        labelCategoria = new javax.swing.JLabel();
        comboBoxDispo = new javax.swing.JComboBox<>();
        labelDescripcionP = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        iconProduct = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        btnImg1 = new javax.swing.JButton();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        labelDispo = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();

        labelNameP1.setBackground(new java.awt.Color(255, 255, 255));
        labelNameP1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNameP1.setText("Nombre");

        setBackground(new java.awt.Color(238, 238, 213));
        setMaximumSize(new java.awt.Dimension(980, 580));
        setMinimumSize(new java.awt.Dimension(980, 580));
        setPreferredSize(new java.awt.Dimension(980, 580));
        setLayout(new java.awt.GridBagLayout());

        panelProducts.setBackground(new java.awt.Color(245, 245, 220));
        panelProducts.setMinimumSize(new java.awt.Dimension(940, 480));
        panelProducts.setPreferredSize(new java.awt.Dimension(940, 480));
        panelProducts.setVerifyInputWhenFocusTarget(false);
        panelProducts.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(245, 245, 220));
        panelHeader.setPreferredSize(new java.awt.Dimension(565, 80));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitleProducts.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleProducts.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleProducts.setForeground(new java.awt.Color(85, 21, 22));
        labelTitleProducts.setText("Gestionar Productos");
        panelHeader.add(labelTitleProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 470, 56));

        btnEditar.setBackground(new java.awt.Color(96, 29, 73));
        btnEditar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelHeader.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 35, 112, 34));

        btnActualizar.setBackground(new java.awt.Color(96, 29, 73));
        btnActualizar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorderPainted(false);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelHeader.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 35, 112, 34));

        panelProducts.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelBody.setMinimumSize(new java.awt.Dimension(1002, 480));
        panelBody.setName(""); // NOI18N
        panelBody.setPreferredSize(new java.awt.Dimension(1002, 480));
        panelBody.setLayout(new java.awt.GridLayout(1, 4));

        jPanel3.setBackground(new java.awt.Color(245, 245, 220));
        jPanel3.setLayout(new java.awt.CardLayout(20, 20));

        jPanel1.setBackground(new java.awt.Color(238, 238, 213));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 50, 50)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeaderProducts.setBackground(new java.awt.Color(150, 50, 50));
        panelHeaderProducts.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Añadir productos");

        javax.swing.GroupLayout panelHeaderProductsLayout = new javax.swing.GroupLayout(panelHeaderProducts);
        panelHeaderProducts.setLayout(panelHeaderProductsLayout);
        panelHeaderProductsLayout.setHorizontalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderProductsLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel2)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        panelHeaderProductsLayout.setVerticalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel1.add(panelHeaderProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 460, -1));

        labelNameP.setBackground(new java.awt.Color(255, 255, 255));
        labelNameP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNameP.setForeground(new java.awt.Color(85, 21, 22));
        labelNameP.setText("Nombre");
        jPanel1.add(labelNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 52, -1, -1));

        labelCodigo.setBackground(new java.awt.Color(255, 255, 255));
        labelCodigo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCodigo.setForeground(new java.awt.Color(85, 21, 22));
        labelCodigo.setText("Precio");
        jPanel1.add(labelCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 52, -1, -1));

        txtNameProduct.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtNameProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameProductActionPerformed(evt);
            }
        });
        jPanel1.add(txtNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 75, 120, 27));

        txtPrecioP.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtPrecioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecioP, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 75, 110, 27));

        labelCategoria.setBackground(new java.awt.Color(255, 255, 255));
        labelCategoria.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCategoria.setForeground(new java.awt.Color(85, 21, 22));
        labelCategoria.setText("Categoria");
        jPanel1.add(labelCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 118, -1, -1));

        comboBoxDispo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxDispo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Disponible", "No disponible" }));
        jPanel1.add(comboBoxDispo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 75, 130, 27));

        labelDescripcionP.setBackground(new java.awt.Color(255, 255, 255));
        labelDescripcionP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelDescripcionP.setForeground(new java.awt.Color(85, 21, 22));
        labelDescripcionP.setText("Descripción");
        jPanel1.add(labelDescripcionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 190, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtDescripcion.setSelectionColor(new java.awt.Color(173, 0, 113));
        jScrollPane2.setViewportView(txtDescripcion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 220, 405, 70));

        iconProduct.setBackground(new java.awt.Color(255, 255, 255));
        iconProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(iconProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 70, 55));

        btnEnter.setBackground(new java.awt.Color(96, 29, 73));
        btnEnter.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnEnter.setText("Añadir");
        btnEnter.setBorder(null);
        btnEnter.setFocusPainted(false);
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 325, 98, 35));

        btnImg1.setBackground(new java.awt.Color(96, 29, 73));
        btnImg1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnImg1.setForeground(new java.awt.Color(255, 255, 255));
        btnImg1.setText("Ingresar Imagen");
        btnImg1.setBorder(null);
        btnImg1.setFocusPainted(false);
        btnImg1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImg1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 325, 174, 35));

        comboBoxCategoria.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Comida rapida", "Bebidas", "Postres" }));
        jPanel1.add(comboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 143, 405, -1));

        labelDispo.setBackground(new java.awt.Color(255, 255, 255));
        labelDispo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelDispo.setForeground(new java.awt.Color(85, 21, 22));
        labelDispo.setText("Disponibilidad");
        jPanel1.add(labelDispo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 52, -1, -1));

        jPanel3.add(jPanel1, "card2");

        panelBody.add(jPanel3);

        panelTable.setBackground(new java.awt.Color(245, 245, 220));
        panelTable.setLayout(new java.awt.CardLayout(20, 20));

        tableProducts.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, "", "Disponible"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Categoria", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.setGridColor(new java.awt.Color(204, 204, 204));
        tableProducts.setSelectionBackground(new java.awt.Color(173, 0, 113));
        tableProducts.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableProducts.setShowHorizontalLines(true);
        tableProducts.setShowVerticalLines(true);
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setResizable(false);
            tableProducts.getColumnModel().getColumn(1).setResizable(false);
            tableProducts.getColumnModel().getColumn(2).setResizable(false);
            tableProducts.getColumnModel().getColumn(3).setResizable(false);
            tableProducts.getColumnModel().getColumn(4).setResizable(false);
        }

        panelTable.add(jScrollPane1, "card2");

        panelBody.add(panelTable);

        panelProducts.add(panelBody, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelProducts, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameProductActionPerformed


    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed

        boolean validacionCampos = objControlador.validarCampos(txtNameProduct.getText(), txtPrecioP.getText(), comboBoxDispo, comboBoxCategoria, txtDescripcion.getText());

        if (validacionCampos) {

            boolean nombre = ControladorUtils.evaluarExpresion("[a-zA-Z ]{1,50}", txtNameProduct.getText());
            if (nombre) {
                try {

                    double precio = Double.parseDouble(txtPrecioP.getText().trim());

                    String[] data = objControlador.copiarImagen();

                    if (data[0].equalsIgnoreCase("true")) {

                        String newRuta = objControlador.obtenerRutaImagen(data[1]);

                        int disponibilidad = objControlador.getValorDisponibilidad(comboBoxDispo);

                        Categorias categoria = (Categorias) comboBoxCategoria.getSelectedItem();
                        int idCategoria = categoria.getIdCategoria();

                        objControlador.agregarProducto(txtNameProduct.getText().trim(), precio, disponibilidad, idCategoria, txtDescripcion.getText().trim(), newRuta);

                        fillRows();

                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "La imagen también es requerida.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo se aceptan números en el campo precio.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Solo se aceptan letras en el campo nombre.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son necesarios.");
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnImg1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImg1ActionPerformed

        String[] data = objControlador.seleccionarImagen();

        if (data[0].equals("true")) {
            String ruta = data[1];

            ImageIcon icono = new ImageIcon(ruta);
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(iconProduct.getWidth(), iconProduct.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(imagenEscalada);

            iconProduct.setIcon(icono);
        }
    }//GEN-LAST:event_btnImg1ActionPerformed

    private void txtPrecioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioPActionPerformed

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        rowSelected = tableProducts.getSelectedRow();
    }//GEN-LAST:event_tableProductsMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (objControlador.validarSeleccionTabla(rowSelected)) {

            Modelo.Productos producto = (Modelo.Productos) listaProductos.get(rowSelected);

            index prn = new index();
            editarProducto obj = new editarProducto(prn, true, producto, this);
            obj.setLocationRelativeTo(null);
            obj.setResizable(false);
            obj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Se necesita seleccionar una fila de la tabla.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        fillRows();
        limpiarCampos();
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnImg1;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxDispo;
    private javax.swing.JLabel iconProduct;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDescripcionP;
    private javax.swing.JLabel labelDispo;
    private javax.swing.JLabel labelNameP;
    private javax.swing.JLabel labelNameP1;
    private javax.swing.JLabel labelTitleProducts;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeaderProducts;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JPanel panelTable;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtPrecioP;
    // End of variables declaration//GEN-END:variables
}
