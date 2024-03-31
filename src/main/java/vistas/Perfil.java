/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import controladores.ControladorUtils;
import controladores.controladorUsers;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class Perfil extends javax.swing.JDialog {

    private index objVistaIndex = new index();
    controladorUsers ctrlu = new controladorUsers();
    private String correoAnterior = "";

    public Perfil(java.awt.Frame parent, boolean modal, index objVistaIndex) {

        super(parent, modal);
        this.objVistaIndex = objVistaIndex;
        initComponents();
        initDateChooser();

        modificarFocus(false);
    }

    private void modificarFocus(boolean valor) {
        txtNombre.setFocusable(valor);
        txtApellido.setFocusable(valor);
        txtCorreo.setFocusable(valor);
        dateChooser.setEnabled(valor);
    }

    private void initDateChooser() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);

        dateChooser.setMaxSelectableDate(cal.getTime());
    }

    public boolean correoModificado(String correoActual, String correoNuevo) {

        return correoActual.equals(correoNuevo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNacimiento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelRol1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        labelRol = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        labelImagen = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();

        labelNacimiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mi perfil");
        setMinimumSize(new java.awt.Dimension(477, 420));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 220));
        jPanel1.setMinimumSize(new java.awt.Dimension(410, 389));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(85, 21, 22));
        labelNombre.setText("Nombre:");
        jPanel1.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 134, 65, -1));

        labelApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelApellido.setForeground(new java.awt.Color(85, 21, 22));
        labelApellido.setText("Apellido:");
        jPanel1.add(labelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 134, 65, -1));

        labelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCorreo.setForeground(new java.awt.Color(97, 29, 73));
        labelCorreo.setText("Correo:");
        jPanel1.add(labelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 186, 60, -1));

        labelRol1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelRol1.setForeground(new java.awt.Color(85, 21, 22));
        labelRol1.setText("Rol:");
        jPanel1.add(labelRol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 237, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 440, 13));

        btnVolver.setBackground(new java.awt.Color(150, 50, 50));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 96, 39));

        btnEditar.setBackground(new java.awt.Color(97, 29, 73));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 103, 39));

        labelRol.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRol.setForeground(new java.awt.Color(40, 40, 90));
        labelRol.setText("Empleado");
        jPanel1.add(labelRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 237, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(85, 21, 22));
        jLabel11.setText("Nacimiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 237, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 130, 120, 33));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 130, 128, 33));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 181, 342, 33));

        labelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/free-user-icon-3296-thumb.png"))); // NOI18N
        jPanel1.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        dateChooser.setFocusable(false);
        jPanel1.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 235, 140, 28));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        btnEditar.setText("Editar");
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        modificarFocus(true);

        String accion = btnEditar.getText();
        String expression = "[a-zA-Z]{1,30}";
        String name = txtNombre.getText();
        String lastName = txtApellido.getText();
        ControladorUtils objUtils = new ControladorUtils();

        if (accion.equals("Editar")) {
            correoAnterior = txtCorreo.getText();
            habilitarPerfil(correoAnterior);
            btnEditar.setText("Guardar");

        } else {

            if (ctrlu.validarCamposPerfil(txtNombre.getText(), txtApellido.getText(), dateChooser.getDate(), txtCorreo.getText())) {
                if (objUtils.evaluarExpresion(expression, name) && objUtils.evaluarExpresion(expression, lastName)) {
                    if (ctrlu.validarFecha(dateChooser.getDate())) {
                        if (!correoModificado(correoAnterior, txtCorreo.getText())) {
                            if (!ctrlu.validarCorreo(txtCorreo.getText())) {
                                JOptionPane.showMessageDialog(this, "El correo no es valido o ya existe en el programa", "Error de validacion", JOptionPane.ERROR_MESSAGE);
                            } else {
                                ctrlu.actualizarPerfil(txtNombre.getText(), txtApellido.getText(), dateChooser.getDate(), txtCorreo.getText(), correoAnterior);
                                objVistaIndex.setUserName(txtNombre.getText());
                                JOptionPane.showMessageDialog(this, "Perfil actualizado exitosamente, es necesario volver a iniciar sesion");
                                btnEditar.setText("Editar");
                                this.setVisible(false);
                                objVistaIndex.cerrarSesion();
                            }
                        } else {
                            ctrlu.actualizarPerfil(txtNombre.getText(), txtApellido.getText(), dateChooser.getDate(), txtCorreo.getText(), correoAnterior);
                            objVistaIndex.setUserName(txtNombre.getText());
                            JOptionPane.showMessageDialog(this, "Perfil actualizado exitosamente");
                            btnEditar.setText("Editar");
                            this.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "La fecha seleccionada no es valida.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    /**
     * @param args the command line arguments
     */
    private void habilitarPerfil(String email) {
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        dateChooser.setEnabled(true);
        int idUsuario = ctrlu.obtenerIdUsuario(email);

        if (ctrlu.obtenerNumeroRol(idUsuario)) {
            txtCorreo.setEditable(true);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVolver;
    public com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelImagen;
    public javax.swing.JLabel labelNacimiento;
    private javax.swing.JLabel labelNombre;
    public javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelRol1;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
