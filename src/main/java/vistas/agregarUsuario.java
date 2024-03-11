/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import vistas.Usuarios;
import controladores.controladorUsers;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author samue
 */
public class agregarUsuario extends javax.swing.JDialog {
    //hola
    /**
     * Creates new form agregarUsuario
     */
    private JDateChooser dateChooser;

    private Usuarios us;

    public agregarUsuario(java.awt.Frame parent, boolean modal, vistas.Usuarios us) {
        super(parent, modal);
        this.us = us;
        initComponents();
        initDateChooser();

    }

    private controladorUsers ctrlu = new controladorUsers();

    private void initDateChooser() {
        dateChooser = new JDateChooser();
        dateChooser.setBounds(30, 200, 125, 26);
        dateChooser.setBackground(java.awt.Color.RED);

        getContentPane().setLayout(null);
        getContentPane().add(dateChooser);
        dateChooser.repaint();

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo usuario");

        panelEditUsers.setBackground(new java.awt.Color(245, 245, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 21, 22));
        jLabel3.setText("Fecha nacimiento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 21, 22));
        jLabel6.setText("Correo");

        txtNewEmailUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewEmailUsersActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 21, 22));
        jLabel7.setText("Rol");

        cbxNewRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Administrador", "Empleado" }));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));

        titleNewUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleNewUsers.setForeground(new java.awt.Color(85, 21, 22));
        titleNewUsers.setText("Nuevo usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 21, 22));
        jLabel2.setText("Nombre");

        btnNewSave.setBackground(new java.awt.Color(97, 29, 73));
        btnNewSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewSave.setForeground(new java.awt.Color(255, 255, 255));
        btnNewSave.setText("Guardar");
        btnNewSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSaveActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 21, 22));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 21, 22));
        jLabel5.setText("Celular");

        txtNewCelUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewCelUsersActionPerformed(evt);
            }
        });

        labelPass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPass.setForeground(new java.awt.Color(85, 21, 22));
        labelPass.setText("Contraseña");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelEditUsersLayout = new javax.swing.GroupLayout(panelEditUsers);
        panelEditUsers.setLayout(panelEditUsersLayout);
        panelEditUsersLayout.setHorizontalGroup(
            panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditUsersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addComponent(titleNewUsers)
                        .addGroup(panelEditUsersLayout.createSequentialGroup()
                            .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNewNameUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(cbxNewRol, 0, 125, Short.MAX_VALUE)
                                .addGroup(panelEditUsersLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                            .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelEditUsersLayout.createSequentialGroup()
                                    .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNewLastnameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addComponent(txtNewEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(45, 45, 45)
                                    .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5)
                                        .addComponent(txtNewCelUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(newPassword)
                                        .addComponent(labelPass)))
                                .addGroup(panelEditUsersLayout.createSequentialGroup()
                                    .addGap(193, 193, 193)
                                    .addComponent(btnNewSave, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))))
                .addGap(24, 24, 24))
        );
        panelEditUsersLayout.setVerticalGroup(
            panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditUsersLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addComponent(titleNewUsers)
                        .addGap(25, 25, 25)
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelEditUsersLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(28, 28, 28))
                                .addComponent(txtNewCelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(txtNewNameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(txtNewLastnameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelPass))
                        .addGap(5, 5, 5)
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNewEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNewRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

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
            try {
                int cel = Integer.parseInt(txtNewCelUsers.getText().trim());
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
                    JOptionPane.showMessageDialog(this, "La fecha seleccionada no puede ser anterior a la fecha actual.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Porfavor, ingresa un numero de telefono valido.");

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
    private javax.swing.JLabel jLabel1;
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
