/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

/**
 *
 * @author samue
 */
public class EditarUsuarios extends javax.swing.JDialog {

    /**
     * Creates new form EditarUsuarios
     */
    public EditarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    EditarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        fieldFechaNacimiento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEditEmailUsers = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEditRol = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxEditState = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        titleEditUsers = new javax.swing.JLabel();
        btnPasswordRestore = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditSave = new javax.swing.JButton();
        txtEditNameUsers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditLastnameUsers = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEditIdUsers = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelEditUsers.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 29, 73));
        jLabel3.setText("Fecha nacimiento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(97, 29, 73));
        jLabel6.setText("Correo");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(97, 29, 73));
        jLabel7.setText("Rol");

        cbxEditRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(97, 29, 73));
        jLabel8.setText("Estado");

        cbxEditState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No disponible" }));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));

        titleEditUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleEditUsers.setForeground(new java.awt.Color(97, 29, 73));
        titleEditUsers.setText("Editar usuario");

        btnPasswordRestore.setBackground(new java.awt.Color(150, 50, 50));
        btnPasswordRestore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPasswordRestore.setForeground(new java.awt.Color(255, 255, 255));
        btnPasswordRestore.setText("Restaurar contraseña");
        btnPasswordRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPasswordRestoreMouseClicked(evt);
            }
        });
        btnPasswordRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordRestoreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 29, 73));
        jLabel2.setText("Nombre");

        btnEditSave.setBackground(new java.awt.Color(97, 29, 73));
        btnEditSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditSave.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSave.setText("Guardar");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(97, 29, 73));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 29, 73));
        jLabel5.setText("Identificación");

        txtEditIdUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditIdUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditUsersLayout = new javax.swing.GroupLayout(panelEditUsers);
        panelEditUsers.setLayout(panelEditUsersLayout);
        panelEditUsersLayout.setHorizontalGroup(
            panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditUsersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(titleEditUsers)
                    .addComponent(jLabel8)
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditUsersLayout.createSequentialGroup()
                                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEditNameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(fieldFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addComponent(cbxEditState, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEditLastnameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(txtEditEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxEditRol, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(txtEditIdUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addComponent(btnPasswordRestore)
                                .addGap(22, 22, 22)
                                .addComponent(btnEditSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(24, 24, 24))
        );
        panelEditUsersLayout.setVerticalGroup(
            panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditUsersLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addComponent(titleEditUsers)
                        .addGap(25, 25, 25)
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(28, 28, 28))
                                    .addComponent(txtEditIdUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(jLabel7)
                                .addGap(5, 5, 5)
                                .addComponent(cbxEditRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)
                                .addComponent(txtEditNameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)
                                .addComponent(fieldFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(txtEditLastnameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(txtEditEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8))
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEditState, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPasswordRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnPasswordRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordRestoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPasswordRestoreActionPerformed

    private void txtEditIdUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditIdUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditIdUsersActionPerformed

    private void btnPasswordRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPasswordRestoreMouseClicked
        // TODO add your handling code here:
        index prn = new index();
        RecuperarContraseña rc = new RecuperarContraseña(prn,true);
        rc.setLocationRelativeTo(null);
        rc.setVisible(true);  
    }//GEN-LAST:event_btnPasswordRestoreMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnPasswordRestore;
    private javax.swing.JComboBox<String> cbxEditRol;
    private javax.swing.JComboBox<String> cbxEditState;
    private javax.swing.JTextField fieldFechaNacimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelEditUsers;
    private javax.swing.JLabel titleEditUsers;
    private javax.swing.JTextField txtEditEmailUsers;
    private javax.swing.JTextField txtEditIdUsers;
    private javax.swing.JTextField txtEditLastnameUsers;
    private javax.swing.JTextField txtEditNameUsers;
    // End of variables declaration//GEN-END:variables
}