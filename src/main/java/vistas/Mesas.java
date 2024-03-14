/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.FlowLayout;
import controladores.ControladorMesas;
import controladores.ControladorUtils;
import controladores.CustomCellRenderer;
import controladores.CustomHeaderRenderer;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samue, Jd
 */
public class Mesas extends javax.swing.JPanel {

    /**
     * Creates new form Reservas
     */
    public Mesas() {
        initComponents();
        tableModel();
        fillRows();

        tableMesas.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
        tableMesas.setDefaultRenderer(Object.class, new CustomCellRenderer());
    }

    private DefaultTableModel modelTableMesas;
    private List<Modelo.Mesas> listaMesas;
    private ControladorMesas conObject = new ControladorMesas();
    private ControladorUtils objControladorUtils = new ControladorUtils();

    int rowSelected = -1;

    public void tableModel() {
        String[] titulosTablaMesas = {"Mesa", "Estado"};
        modelTableMesas = objControladorUtils.addTableModel(modelTableMesas, tableMesas, titulosTablaMesas);
    }

    public void fillRows() {

        modelTableMesas.setRowCount(0);
        listaMesas = conObject.getListaMesas();

        listaMesas.forEach(l -> {
            String estado = getNombreDisponibilidad(l.getEstado());
            modelTableMesas.addRow(new Object[]{l.getNumero_mesa(), estado});
        });
    }

    public void fillFields() {
        Modelo.Mesas mesas = (Modelo.Mesas) listaMesas.get(rowSelected);

        txtNumMesa.setText(String.valueOf(mesas.getNumero_mesa()));
        cmbState.setSelectedItem(getNombreDisponibilidad(mesas.getEstado()));

    }

    public String getNombreDisponibilidad(int state) {
        String nombre = "";
        if (state == 0) {
            nombre = "Ocupada";
        } else if (state == 1) {
            nombre = "Disponible";
        }
        return nombre;
    }

    public void limpiarCampos() {
        txtNumMesa.setText("");
        cmbState.setSelectedIndex(0);
        rowSelected = -1;
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

        labelTitlePedidos = new javax.swing.JLabel();
        panelReservas = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        labelTitleMesas = new javax.swing.JLabel();
        btnEditarMesa = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelHeaderProducts = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumMesa = new javax.swing.JTextField();
        cmbState = new javax.swing.JComboBox<>();
        btnAgregarMesa = new javax.swing.JButton();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMesas = new javax.swing.JTable();

        labelTitlePedidos.setBackground(new java.awt.Color(255, 255, 255));
        labelTitlePedidos.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitlePedidos.setForeground(new java.awt.Color(96, 29, 73));
        labelTitlePedidos.setText("Gestionar Pedidos");

        setBackground(new java.awt.Color(238, 238, 213));
        setPreferredSize(new java.awt.Dimension(967, 549));
        setLayout(new java.awt.GridBagLayout());

        panelReservas.setBackground(new java.awt.Color(245, 245, 220));
        panelReservas.setForeground(new java.awt.Color(96, 29, 73));
        panelReservas.setMaximumSize(new java.awt.Dimension(980, 580));
        panelReservas.setMinimumSize(new java.awt.Dimension(940, 480));
        panelReservas.setPreferredSize(new java.awt.Dimension(940, 480));
        panelReservas.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(245, 245, 220));
        panelHeader.setMinimumSize(new java.awt.Dimension(986, 80));
        panelHeader.setPreferredSize(new java.awt.Dimension(565, 80));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitleMesas.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleMesas.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleMesas.setForeground(new java.awt.Color(85, 21, 22));
        labelTitleMesas.setText("Gestion de mesas");
        panelHeader.add(labelTitleMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, 56));

        btnEditarMesa.setBackground(new java.awt.Color(96, 29, 73));
        btnEditarMesa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnEditarMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarMesa.setText("Editar");
        btnEditarMesa.setBorderPainted(false);
        btnEditarMesa.setFocusPainted(false);
        btnEditarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMesaActionPerformed(evt);
            }
        });
        panelHeader.add(btnEditarMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 112, 34));

        panelReservas.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelBody.setLayout(new java.awt.GridLayout(1, 4));

        jPanel3.setBackground(new java.awt.Color(245, 245, 220));
        jPanel3.setLayout(new java.awt.CardLayout(20, 20));

        jPanel1.setBackground(new java.awt.Color(238, 238, 213));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 29, 73)));
        jPanel1.setForeground(new java.awt.Color(150, 50, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHeaderProducts.setBackground(new java.awt.Color(150, 50, 50));
        panelHeaderProducts.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Añadir mesas");

        javax.swing.GroupLayout panelHeaderProductsLayout = new javax.swing.GroupLayout(panelHeaderProducts);
        panelHeaderProducts.setLayout(panelHeaderProductsLayout);
        panelHeaderProductsLayout.setHorizontalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderProductsLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel2)
                .addContainerGap(189, Short.MAX_VALUE))
        );
        panelHeaderProductsLayout.setVerticalGroup(
            panelHeaderProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel1.add(panelHeaderProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 460, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(85, 21, 22));
        jLabel1.setText("Mesa:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 21, 22));
        jLabel3.setText("Estado:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        txtNumMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumMesaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 170, 33));

        cmbState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Disponible", "Ocupada" }));
        cmbState.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbStateItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 170, 33));

        btnAgregarMesa.setBackground(new java.awt.Color(96, 29, 73));
        btnAgregarMesa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAgregarMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMesa.setText("Agregar");
        btnAgregarMesa.setBorderPainted(false);
        btnAgregarMesa.setFocusPainted(false);
        btnAgregarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMesaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 260, 34));

        jPanel3.add(jPanel1, "card2");

        panelBody.add(jPanel3);

        panelTable.setBackground(new java.awt.Color(245, 245, 220));
        panelTable.setLayout(new java.awt.CardLayout(20, 20));

        tableMesas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tableMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "mesa", "Estado"
            }
        ));
        tableMesas.setFocusable(false);
        tableMesas.setSelectionBackground(new java.awt.Color(165, 45, 126));
        tableMesas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableMesas.setShowHorizontalLines(true);
        tableMesas.setShowVerticalLines(true);
        tableMesas.getTableHeader().setResizingAllowed(false);
        tableMesas.getTableHeader().setReorderingAllowed(false);
        tableMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMesas);

        panelTable.add(jScrollPane1, "card2");

        panelBody.add(panelTable);

        panelReservas.add(panelBody, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(panelReservas, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMesaActionPerformed
        // TODO add your handling code here:}
        if (rowSelected != -1) {
            Modelo.Mesas infoMesa = (Modelo.Mesas) listaMesas.get(rowSelected);
            boolean validarCampos = conObject.validarCampos(txtNumMesa.getText(), cmbState);
            int idMesa = infoMesa.getIdMesa();

            if (validarCampos) {
                try {
                    int numeroMesa = Integer.parseInt(txtNumMesa.getText());
                    int numeroAnterior = infoMesa.getNumero_mesa();

                    if (numeroAnterior != numeroMesa) {
                        if (!conObject.validarNumMesa(numeroMesa)) {
                            JOptionPane.showMessageDialog(null, "El numero de mesa ya existe, por favor elige uno diferente", "Error al editar mesa", JOptionPane.ERROR_MESSAGE);

                        } else {
                            int estado = conObject.getValorDisponibilidad(cmbState);
                            conObject.EditarMesa(idMesa, numeroMesa, estado);
                            JOptionPane.showMessageDialog(null, "Mesa editada exitosamente");
                            limpiarCampos();
                            fillRows();
                        }
                    } else {
                        int estado = conObject.getValorDisponibilidad(cmbState);
                        conObject.EditarMesa(idMesa, numeroMesa, estado);
                        JOptionPane.showMessageDialog(null, "Mesa editada exitosamente");
                        limpiarCampos();
                        fillRows();
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo se aceptan numeros como parametros");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son necesarios");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes presionar la columna que quieres editar primero");
        }
    }//GEN-LAST:event_btnEditarMesaActionPerformed

    private void txtNumMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumMesaActionPerformed

    private void cmbStateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbStateItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStateItemStateChanged

    private void btnAgregarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMesaActionPerformed
        // TODO add your handling code here:

        boolean validarCampos = conObject.validarCampos(txtNumMesa.getText(), cmbState);

        if (validarCampos) {
            try {
                int numeroMesa = Integer.parseInt(txtNumMesa.getText());
                if (conObject.validarNumMesa(numeroMesa)) {
                    
                    if(numeroMesa > 0){
                        int estado = conObject.getValorDisponibilidad(cmbState);
                        conObject.agregarMesa(numeroMesa, estado);
                        JOptionPane.showMessageDialog(null, "Mesa agregada exitosamente");
                        limpiarCampos();
                        fillRows();
                    }else{
                        JOptionPane.showMessageDialog(null, "Numero de mesa ingresada no valido", "Error al ingresar mesa", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El numero de mesa ya existe, por favor elige uno diferente");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan numeros como parametros");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos son necesarios");

        }
    }//GEN-LAST:event_btnAgregarMesaActionPerformed

    private void tableMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMesasMouseClicked
        // TODO add your handling code here:
        rowSelected = tableMesas.getSelectedRow();
        fillFields();
    }//GEN-LAST:event_tableMesasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMesa;
    private javax.swing.JButton btnEditarMesa;
    private javax.swing.JComboBox<String> cmbState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitleMesas;
    private javax.swing.JLabel labelTitlePedidos;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeaderProducts;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JPanel panelTable;
    private javax.swing.JTable tableMesas;
    private javax.swing.JTextField txtNumMesa;
    // End of variables declaration//GEN-END:variables

}
