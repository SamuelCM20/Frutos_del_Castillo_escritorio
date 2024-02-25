/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import Modelo.Categorias;

import controladores.ControladorProductos;
import controladores.ControladorUtils;
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

        //JTableHeader header = tableProducts.getTableHeader();
        //index i = new index();
        //i.tableColor(header);
        tableModel();
        fillRows();
        llenarComboBoxCategorias();

        setColorBotones();
        tableProducts.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());

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
        String[] titulosTablaProductos = {"Codigo", "Nombre", "Precio", "Categoria", "Disponibilidad"};
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

        labelNameP1 = new javax.swing.JLabel();
        panelProducts = new javax.swing.JPanel();
        labelTitleProducts = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        labelNameP1.setBackground(new java.awt.Color(255, 255, 255));
        labelNameP1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNameP1.setText("Nombre");

        panelProducts.setBackground(new java.awt.Color(245, 245, 220));

        labelTitleProducts.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleProducts.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleProducts.setForeground(new java.awt.Color(96, 29, 73));
        labelTitleProducts.setText("Gestionar Productos");

        jPanel1.setBackground(new java.awt.Color(245, 245, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 29, 73)));

        panelHeaderProducts.setBackground(new java.awt.Color(96, 29, 73));
        panelHeaderProducts.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Añadir productos");

        javax.swing.GroupLayout panelHeaderProductsLayout = new javax.swing.GroupLayout(panelHeaderProducts);
        panelHeaderProducts.setLayout(panelHeaderProductsLayout);
        panelHeaderProductsLayout.setHorizontalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderProductsLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderProductsLayout.setVerticalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        labelNameP.setBackground(new java.awt.Color(255, 255, 255));
        labelNameP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelNameP.setText("Nombre");

        labelCodigo.setBackground(new java.awt.Color(255, 255, 255));
        labelCodigo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCodigo.setText("Precio");

        txtNameProduct.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtNameProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameProductActionPerformed(evt);
            }
        });

        txtPrecioP.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtPrecioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioPActionPerformed(evt);
            }
        });

        labelCategoria.setBackground(new java.awt.Color(255, 255, 255));
        labelCategoria.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelCategoria.setText("Categoria");

        comboBoxDispo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxDispo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Disponible", "No disponible" }));

        labelDescripcionP.setBackground(new java.awt.Color(255, 255, 255));
        labelDescripcionP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelDescripcionP.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setMargin(new java.awt.Insets(2, 7, 2, 7));
        txtDescripcion.setSelectionColor(new java.awt.Color(173, 0, 113));
        jScrollPane2.setViewportView(txtDescripcion);

        iconProduct.setBackground(new java.awt.Color(255, 255, 255));
        iconProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        comboBoxCategoria.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Comida rapida", "Bebidas", "Postres" }));

        labelDispo.setBackground(new java.awt.Color(255, 255, 255));
        labelDispo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelDispo.setText("Disponibilidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeaderProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCategoria)
                            .addComponent(labelDescripcionP))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNameP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCodigo)
                                    .addComponent(txtPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxDispo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(labelDispo)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(17, 17, 17))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelHeaderProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNameP)
                    .addComponent(labelCodigo)
                    .addComponent(labelDispo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDispo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDescripcionP)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tableProducts.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", null, "", "Disponible"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Categoria", "Disponibilidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
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

        btnEditar.setBackground(new java.awt.Color(96, 29, 73));
        btnEditar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setFocusPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(96, 29, 73));
        btnActualizar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductsLayout.createSequentialGroup()
                        .addComponent(labelTitleProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductsLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitleProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameProductActionPerformed


    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed

        boolean validacionCampos = objControlador.validarCampos(txtNameProduct.getText(), txtPrecioP.getText(), comboBoxDispo, comboBoxCategoria, txtDescripcion.getText());

        if (validacionCampos) {
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
                JOptionPane.showMessageDialog(null, "Solo se aceptan números en el campo precio.");
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCategoria;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDescripcionP;
    private javax.swing.JLabel labelDispo;
    private javax.swing.JLabel labelNameP;
    private javax.swing.JLabel labelNameP1;
    private javax.swing.JLabel labelTitleProducts;
    private javax.swing.JPanel panelHeaderProducts;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtPrecioP;
    // End of variables declaration//GEN-END:variables
}
