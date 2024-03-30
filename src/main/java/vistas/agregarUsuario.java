/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import controladores.ControladorUtils;
import controladores.controladorUsers;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class agregarUsuario extends javax.swing.JDialog {

    private Usuarios us;
    private controladorUsers ctrlu = new controladorUsers();

    public agregarUsuario(java.awt.Frame parent, boolean modal, vistas.Usuarios us) {
        super(parent, modal);
        this.us = us;
        initComponents();
        
        initDateChooser();

    }

    private void initDateChooser() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);

        dateChooser.setMaxSelectableDate(cal.getTime());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditUsers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNewEmailUsers = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxNewRol = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        titleNewUsers = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNewSave = new javax.swing.JButton();
        txtNewNameUsers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNewLastnameUsers = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNewCelUsers = new javax.swing.JTextField();
        newPassword = new javax.swing.JPasswordField();
        labelPass = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo usuario");
        setPreferredSize(new java.awt.Dimension(530, 423));
        setResizable(false);

        panelEditUsers.setBackground(new java.awt.Color(245, 245, 220));
        panelEditUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 21, 22));
        jLabel3.setText("Fecha nacimiento");
        panelEditUsers.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 176, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 21, 22));
        jLabel6.setText("Correo");
        panelEditUsers.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 176, -1, -1));

        txtNewEmailUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewEmailUsersActionPerformed(evt);
            }
        });
        panelEditUsers.add(txtNewEmailUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 201, 125, 33));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 21, 22));
        jLabel7.setText("Rol");
        panelEditUsers.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 259, -1, -1));

        cbxNewRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Administrador", "Empleado" }));
        panelEditUsers.add(cbxNewRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 292, 125, 33));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));
        panelEditUsers.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 366, 464, 13));

        titleNewUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleNewUsers.setForeground(new java.awt.Color(85, 21, 22));
        titleNewUsers.setText("Nuevo usuario");
        panelEditUsers.add(titleNewUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 21, 22));
        jLabel2.setText("Nombre");
        panelEditUsers.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 88, -1, -1));

        btnNewSave.setBackground(new java.awt.Color(97, 29, 73));
        btnNewSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewSave.setForeground(new java.awt.Color(255, 255, 255));
        btnNewSave.setText("Guardar");
        btnNewSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaveActionPerformed(evt);
            }
        });
        panelEditUsers.add(btnNewSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 309, 125, 40));
        panelEditUsers.add(txtNewNameUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 113, 125, 33));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 21, 22));
        jLabel4.setText("Apellido");
        panelEditUsers.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 88, -1, -1));
        panelEditUsers.add(txtNewLastnameUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 113, 125, 33));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 21, 22));
        jLabel5.setText("Celular");
        panelEditUsers.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 88, -1, -1));

        txtNewCelUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCelUsersActionPerformed(evt);
            }
        });
        panelEditUsers.add(txtNewCelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 111, 125, 33));
        panelEditUsers.add(newPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 201, 125, 33));

        labelPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPass.setForeground(new java.awt.Color(85, 21, 22));
        labelPass.setText("Contraseña");
        panelEditUsers.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 176, -1, -1));
        panelEditUsers.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 202, 125, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEditUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEditUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNewCelUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewCelUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewCelUsersActionPerformed

    private void txtNewEmailUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewEmailUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewEmailUsersActionPerformed

    private void btnNewSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSaveActionPerformed
        // TODO add your handling code here:
        boolean validacionCampos = ctrlu.validarCampos(txtNewNameUsers.getText(), txtNewLastnameUsers.getText(), txtNewCelUsers.getText(), dateChooser.getDate(), txtNewEmailUsers.getText(), newPassword.getText(), cbxNewRol);

        if (validacionCampos) {
            String expression = "[a-zA-Z]{1,30}";
            String name = txtNewNameUsers.getText();
            String lastName = txtNewLastnameUsers.getText();
            ControladorUtils objUtils = new ControladorUtils();
          if (objUtils.evaluarExpresion(expression, name) && objUtils.evaluarExpresion(expression, lastName)) {
            boolean celValidacion = ControladorUtils.evaluarExpresion("[0-9]{10}", txtNewCelUsers.getText().trim());
            
            if (celValidacion) {

                String cel = txtNewCelUsers.getText().trim();
                if (ctrlu.validarFecha(dateChooser.getDate())) {

                    if (!ctrlu.validarCorreo(txtNewEmailUsers.getText())) {
                        JOptionPane.showMessageDialog(this, "El correo no es valido o ya existe en el programa", "Error de validacion", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (ctrlu.validarLargoContrasenia(newPassword.getText())) {

                            int rol = ctrlu.obtenerRol(cbxNewRol);
                            ctrlu.agregarUsuario(txtNewNameUsers.getText().trim(), txtNewLastnameUsers.getText(), String.valueOf(cel), dateChooser.getDate(), txtNewEmailUsers.getText(), newPassword.getText(), rol);

                            us.fillRows();

                            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente");
                            this.setVisible(false);

                        } else {
                            JOptionPane.showMessageDialog(this, "La contraseña debe tener como minimo 6 o mas digitos", "Error al agregar usuario", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "La fecha seleccionada no es valida.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(null, "Porfavor, ingresa un numero de telefono valido.", "Error de validación", JOptionPane.ERROR_MESSAGE);
            }
            } else {
                JOptionPane.showMessageDialog(this, "Nombre y apellidos solo letras");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");

        }

    }//GEN-LAST:event_btnNewSaveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewSave;
    private javax.swing.JComboBox<String> cbxNewRol;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPass;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JPanel panelEditUsers;
    private javax.swing.JLabel titleNewUsers;
    private javax.swing.JTextField txtNewCelUsers;
    private javax.swing.JTextField txtNewEmailUsers;
    private javax.swing.JTextField txtNewLastnameUsers;
    private javax.swing.JTextField txtNewNameUsers;
    // End of variables declaration//GEN-END:variables
}
