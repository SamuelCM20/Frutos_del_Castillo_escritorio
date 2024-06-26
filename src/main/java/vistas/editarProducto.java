/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import Modelo.Categorias;
import Modelo.Productos;
import controladores.ControladorProductos;
import controladores.ControladorUtils;
import java.awt.Image;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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

        ImageIcon icono = objControlador.obtenerImagenRemota(producto.getImagen_1());
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
        setTitle("Editar producto");
        setPreferredSize(new java.awt.Dimension(518, 485));

        panelEditProduct.setBackground(new java.awt.Color(245, 245, 220));
        panelEditProduct.setMinimumSize(new java.awt.Dimension(513, 480));
        panelEditProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleEditProduct.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleEditProduct.setForeground(new java.awt.Color(85, 21, 22));
        titleEditProduct.setText("Editar Producto");
        panelEditProduct.add(titleEditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 19, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 21, 22));
        jLabel2.setText("Nombre");
        panelEditProduct.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 86, -1, -1));

        fieldNombre.setMargin(new java.awt.Insets(2, 7, 2, 7));
        panelEditProduct.add(fieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 111, 125, 33));

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(85, 21, 22));
        labelPrecio.setText("Precio");
        panelEditProduct.add(labelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 85, -1, -1));

        fieldPrecio.setMargin(new java.awt.Insets(2, 7, 2, 7));
        panelEditProduct.add(fieldPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 108, 125, 33));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 21, 22));
        jLabel5.setText("Disponibilidad");
        panelEditProduct.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 85, -1, -1));

        comboBoxDisponibilidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Disponible", "No disponible" }));
        panelEditProduct.add(comboBoxDisponibilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 109, -1, 33));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 21, 22));
        jLabel6.setText("Categoria");
        panelEditProduct.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, -1, -1));

        comboBoxCategorias.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        comboBoxCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige..." }));
        panelEditProduct.add(comboBoxCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 462, 33));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 21, 22));
        jLabel7.setText("Descripcion");
        panelEditProduct.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 219, -1, -1));

        fieldDescripcion.setColumns(20);
        fieldDescripcion.setRows(3);
        fieldDescripcion.setMargin(new java.awt.Insets(2, 7, 2, 7));
        fieldDescripcion.setSelectionColor(new java.awt.Color(173, 0, 113));
        jScrollPane2.setViewportView(fieldDescripcion);

        panelEditProduct.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 249, 462, -1));

        newIconProduct.setBackground(new java.awt.Color(255, 255, 255));
        newIconProduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelEditProduct.add(newIconProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 345, 60, 60));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));
        panelEditProduct.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 433, 462, 13));

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
        panelEditProduct.add(btnNewImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 357, 133, 37));

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
        panelEditProduct.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 380, 89, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
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
            boolean nombre = ControladorUtils.evaluarExpresion("[a-zA-Z ]{1,50}", fieldNombre.getText());
            if (nombre) {
                boolean precioValidacion = ControladorUtils.evaluarExpresion("^\\d*\\.?\\d+$", fieldPrecio.getText().trim());

                if (precioValidacion) {
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
                } else {
                    JOptionPane.showMessageDialog(null, "Solo se aceptan números en el campo precio.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son necesarios, menos la imagen.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo se aceptan letras en el campo nombre.", "Error de validación", JOptionPane.ERROR_MESSAGE);
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
