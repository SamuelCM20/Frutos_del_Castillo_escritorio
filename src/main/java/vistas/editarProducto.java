/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import Modelo.Categorias;
import Modelo.Productos;
import controladores.ControladorProductos;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author samue
 */
public class editarProducto extends javax.swing.JDialog {

    private Modelo.Productos producto;
    private vistas.Productos vistaProductos;
    
    public editarProducto(java.awt.Frame parent, boolean modal, Modelo.Productos producto, vistas.Productos vistaProductos) {
        
        super(parent, modal);
        this.producto = producto;
        this.vistaProductos = vistaProductos;
        initComponents();
        llenarComboBoxCategorias();
        llenarCampos();
        
        setColorBotones();

    }

    public void setColorBotones(){
        btnNewImage.setContentAreaFilled(false);
        btnNewImage.setOpaque(true);
        btnNewImage.setBackground(new Color(96,29,73));
    }
    private ControladorProductos objControlador = new ControladorProductos();
    private DefaultComboBoxModel<Categorias> modelComboBox = new DefaultComboBoxModel<>();

    public void llenarComboBoxCategorias() {
        List<Categorias> lista = objControlador.getCategorias();
        objControlador.fillComboBox(lista, comboBoxCategorias, modelComboBox);
    }

    public void llenarCampos() {

        fieldNombre.setText(producto.getNombre());
        fieldPrecio.setText(String.valueOf(producto.getPrecio()));
        fieldDescripcion.setText(producto.getDescripcion());

        getDisponibilidad();
        comboBoxCategorias.setSelectedIndex(producto.getCategorias_id());
        
        ImageIcon icono = new ImageIcon(producto.getImagen_1());
        Image imagen = icono.getImage();
        Image imagenEscalada = imagen.getScaledInstance(newIconProduct.getWidth(), newIconProduct.getHeight(), Image.SCALE_SMOOTH);
        icono = new ImageIcon(imagenEscalada);

        newIconProduct.setIcon(icono);

    }

    public void getDisponibilidad() {
        int disponibilidad = producto.getDisponibilidad();

        if (disponibilidad == 0) {
            comboBoxDisponibilidad.setSelectedIndex(2);
        } else if (disponibilidad == 1) {
            comboBoxDisponibilidad.setSelectedIndex(1);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        panelEditProduct = new javax.swing.JPanel();
        titleEditProduct = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        labelPrecio = new javax.swing.JLabel();
        fieldPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboBoxDisponibilidad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCategorias = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDescripcion = new javax.swing.JTextArea();
        newIconProduct = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNewImage = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEditProduct.setBackground(new java.awt.Color(255, 255, 255));

        titleEditProduct.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleEditProduct.setForeground(new java.awt.Color(97, 29, 73));
        titleEditProduct.setText("Editar Producto");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 29, 73));
        jLabel2.setText("Nombre");

        fieldNombre.setMargin(new java.awt.Insets(2, 7, 2, 7));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(97, 29, 73));
        labelPrecio.setText("Precio");

        fieldPrecio.setMargin(new java.awt.Insets(2, 7, 2, 7));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 29, 73));
        jLabel5.setText("Disponibilidad");

        comboBoxDisponibilidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Disponible", "No disponible" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(97, 29, 73));
        jLabel6.setText("Categoria");

        comboBoxCategorias.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige..." }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 29, 73));
        jLabel7.setText("Descripcion");

        fieldDescripcion.setColumns(20);
        fieldDescripcion.setRows(5);
        fieldDescripcion.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldDescripcion.setSelectionColor(new java.awt.Color(173, 0, 113));
        jScrollPane2.setViewportView(fieldDescripcion);

        newIconProduct.setBackground(new java.awt.Color(255, 255, 255));
        newIconProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));

        btnNewImage.setBackground(new java.awt.Color(97, 6, 63));
        btnNewImage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewImage.setForeground(new java.awt.Color(255, 255, 255));
        btnNewImage.setText("Ingresar Imagen");
        btnNewImage.setBorder(null);
        btnNewImage.setFocusPainted(false);
        btnNewImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewImageActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(97, 6, 63));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Guardar");
        btnActualizar.setBorder(null);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditProductLayout = new javax.swing.GroupLayout(panelEditProduct);
        panelEditProduct.setLayout(panelEditProductLayout);
        panelEditProductLayout.setHorizontalGroup(
            panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditProductLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditProductLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelEditProductLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditProductLayout.createSequentialGroup()
                        .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCategorias, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditProductLayout.createSequentialGroup()
                                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPrecio))
                                .addGap(45, 45, 45)
                                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(comboBoxDisponibilidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditProductLayout.createSequentialGroup()
                                .addComponent(titleEditProduct)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelEditProductLayout.createSequentialGroup()
                                .addComponent(newIconProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        panelEditProductLayout.setVerticalGroup(
            panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditProductLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleEditProduct)
                .addGap(18, 18, 18)
                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(panelEditProductLayout.createSequentialGroup()
                        .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEditProductLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEditProductLayout.createSequentialGroup()
                                .addComponent(labelPrecio)
                                .addGap(3, 3, 3)
                                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditProductLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(newIconProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditProductLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelEditProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewImageActionPerformed
        String[] data = objControlador.seleccionarImagen();

        if (data[0].equals("true")) {
            String ruta = data[1];

            ImageIcon icono = new ImageIcon(ruta);
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(newIconProduct.getWidth(), newIconProduct.getHeight(), Image.SCALE_SMOOTH);
            icono = new ImageIcon(imagenEscalada);

            newIconProduct.setIcon(icono);
        }
    }//GEN-LAST:event_btnNewImageActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        boolean validacionCampos = objControlador.validarCampos(fieldNombre.getText(), fieldPrecio.getText(), comboBoxDisponibilidad, comboBoxCategorias, fieldDescripcion.getText());

        if (validacionCampos) {

            try {
                double precio = Double.parseDouble(fieldPrecio.getText().trim());
                int disponibilidad = objControlador.getValorDisponibilidad(comboBoxDisponibilidad);

                Categorias categoria = (Categorias) comboBoxCategorias.getSelectedItem();
                int idCategoria = categoria.getIdCategoria();

                String[] dataImagen = objControlador.copiarImagen();

                objControlador.actualizarProducto(producto.getIdProductos(), fieldNombre.getText().trim(), precio, disponibilidad, idCategoria, fieldDescripcion.getText().trim(), dataImagen);
                
                vistaProductos.fillRows();
                vistaProductos.rowSelected = -1;
                
                JOptionPane.showMessageDialog(this, "Producto actualizado con exito.");
                this.setVisible(false);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan números en el campo precio.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son necesarios, menos la imagen.");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnNewImage;
    private javax.swing.JComboBox<String> comboBoxCategorias;
    private javax.swing.JComboBox<String> comboBoxDisponibilidad;
    private javax.swing.JTextArea fieldDescripcion;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldPrecio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel newIconProduct;
    private javax.swing.JPanel panelEditProduct;
    private javax.swing.JLabel titleEditProduct;
    // End of variables declaration//GEN-END:variables
}
