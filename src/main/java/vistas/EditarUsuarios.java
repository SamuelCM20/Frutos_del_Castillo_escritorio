/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import java.text.ParseException;
import controladores.controladorUsers;
import javax.swing.JOptionPane;
import controladores.ControladorUtils;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author samue
 */
public class EditarUsuarios extends javax.swing.JDialog {

    //hola
    /**
     * Creates new form EditarUsuarios
     */
    JFrame parentFrame;
    //index prn = new index();
    private Modelo.Users user;
    private vistas.Usuarios usuarios;
    controladorUsers ctrlu = new controladorUsers();

    public EditarUsuarios(java.awt.Frame parent, boolean modal, Modelo.Users user, vistas.Usuarios usuarios) throws ParseException {
        super(parent, modal);
        this.parentFrame = (JFrame) parent;
        this.user = user;
        this.usuarios = usuarios;
        initComponents();
        initDateChooser();

        llenarCampos();
    }

    private void initDateChooser() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);

        dateChooser.setMaxSelectableDate(cal.getTime());

    }

    EditarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void llenarCampos() throws ParseException {

        txtEditNameUsers.setText(user.getNombre());
        txtEditLastnameUsers.setText(user.getApellido());
        txtEditCelUsers.setText(user.getCelular());

        dateChooser.setDate(user.getFecha_nacimiento());

        txtEditEmailUsers.setText(user.getEmail());

        int rol = user.getId_rol();
        cbxEditRol.setSelectedIndex(rol - 1);

    }

    public boolean correoModificado(String correoActual, String correoNuevo) {

        return correoActual.equals(correoNuevo);
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
        txtEditEmailUsers = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxEditRol = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        titleEditUsers = new javax.swing.JLabel();
        btnPasswordRestore = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditSave = new javax.swing.JButton();
        txtEditNameUsers = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditLastnameUsers = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEditCelUsers = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar usuario");
        setIconImage(null);
        setPreferredSize(new java.awt.Dimension(525, 427));
        setResizable(false);

        panelEditUsers.setBackground(new java.awt.Color(245, 245, 220));
        panelEditUsers.setMinimumSize(new java.awt.Dimension(525, 430));
        panelEditUsers.setPreferredSize(new java.awt.Dimension(525, 430));
        panelEditUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 21, 22));
        jLabel3.setText("Fecha nacimiento");
        panelEditUsers.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 176, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 21, 22));
        jLabel6.setText("Correo");
        panelEditUsers.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 176, -1, -1));
        panelEditUsers.add(txtEditEmailUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 201, 295, 33));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 21, 22));
        jLabel7.setText("Rol");
        panelEditUsers.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 260, -1, -1));

        cbxEditRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Administrador", "Empleado", "Usuario" }));
        panelEditUsers.add(cbxEditRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 285, 125, 33));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));
        panelEditUsers.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 374, 465, 13));

        titleEditUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleEditUsers.setForeground(new java.awt.Color(85, 21, 22));
        titleEditUsers.setText("Editar usuario");
        panelEditUsers.add(titleEditUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 15, -1, -1));

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
        panelEditUsers.add(btnPasswordRestore, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 320, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 21, 22));
        jLabel2.setText("Nombre");
        panelEditUsers.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 88, -1, -1));

        btnEditSave.setBackground(new java.awt.Color(97, 29, 73));
        btnEditSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditSave.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSave.setText("Guardar");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });
        panelEditUsers.add(btnEditSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 320, 102, 40));
        panelEditUsers.add(txtEditNameUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 113, 125, 33));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 21, 22));
        jLabel4.setText("Apellido");
        panelEditUsers.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 88, -1, -1));
        panelEditUsers.add(txtEditLastnameUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 113, 125, 33));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 21, 22));
        jLabel5.setText("celular");
        panelEditUsers.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 90, -1, -1));

        txtEditCelUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditCelUsersActionPerformed(evt);
            }
        });
        panelEditUsers.add(txtEditCelUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 113, 125, 33));
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

    private void btnPasswordRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordRestoreActionPerformed
        // TODO add your handling code here:
        vistas.RecuperarContraseña rc = new vistas.RecuperarContraseña(parentFrame, user, true);
    }//GEN-LAST:event_btnPasswordRestoreActionPerformed

    private void txtEditCelUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditCelUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditCelUsersActionPerformed

    private void btnPasswordRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPasswordRestoreMouseClicked
        
        RecuperarContraseña rc = new RecuperarContraseña(parentFrame, user, true);
        rc.setLocationRelativeTo(null);
        this.setVisible(false);
        rc.setVisible(true);
    }//GEN-LAST:event_btnPasswordRestoreMouseClicked

    private void btnEditSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSaveActionPerformed
        // TODO add your handling code here:

        boolean validacionCampos = ctrlu.validarCampos(txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), txtEditCelUsers.getText(), dateChooser.getDate(), txtEditEmailUsers.getText(), txtEditNameUsers.getText(), cbxEditRol);
        if (validacionCampos) {

            String expression = "[a-zA-Z]{1,30}";
            String name = txtEditNameUsers.getText();
            String lastName = txtEditLastnameUsers.getText();
            ControladorUtils objUtils = new ControladorUtils();

            if (objUtils.evaluarExpresion(expression, name) && objUtils.evaluarExpresion(expression, lastName)) {

                boolean celValidacion = ControladorUtils.evaluarExpresion("[0-9]{10}", txtEditCelUsers.getText().trim());
                if (celValidacion) {
                    String cel = txtEditCelUsers.getText().trim();

                    if (ctrlu.validarFecha(dateChooser.getDate())) {

                        int rol = ctrlu.obtenerRol(cbxEditRol);

                        // Validar si rol es igual a 1
                        if (rol == 1) {
                            // Mostrar JOptionPane de confirmación
                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Quieres cambiar el rol de usuario?, no se mostrara en la tabla de usuarios", "Confirmar cambio", JOptionPane.YES_NO_OPTION);

                            // Verificar la respuesta del usuario
                            if (confirmacion == JOptionPane.YES_OPTION) {
                                // Continuar con el resto del código

                                if (!correoModificado(user.getEmail(), txtEditEmailUsers.getText())) {
                                    if (!ctrlu.validarCorreo(txtEditEmailUsers.getText())) {
                                        JOptionPane.showMessageDialog(this, "El correo no es valido o ya existe en el programa", "Error de validacion", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), cel, dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                        usuarios.fillRows();
                                        JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                        this.setVisible(false);
                                    }
                                } else {
                                    ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), cel, dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                    usuarios.fillRows();
                                    JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                    this.setVisible(false);
                                }
                            }
                        } else {
                            // Continuar con el resto del código sin mostrar el JOptionPane

                            if (!correoModificado(user.getEmail(), txtEditEmailUsers.getText())) {
                                if (!ctrlu.validarCorreo(txtEditEmailUsers.getText())) {
                                    JOptionPane.showMessageDialog(this, "El correo no es valido o ya existe en el programa", "Error de validacion", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), cel, dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                    usuarios.fillRows();
                                    JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                    this.setVisible(false);
                                }
                            } else {
                                ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), cel, dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                usuarios.fillRows();
                                JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                this.setVisible(false);
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
    }//GEN-LAST:event_btnEditSaveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditSave;
    private javax.swing.JButton btnPasswordRestore;
    private javax.swing.JComboBox<String> cbxEditRol;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelEditUsers;
    private javax.swing.JLabel titleEditUsers;
    private javax.swing.JTextField txtEditCelUsers;
    private javax.swing.JTextField txtEditEmailUsers;
    private javax.swing.JTextField txtEditLastnameUsers;
    private javax.swing.JTextField txtEditNameUsers;
    // End of variables declaration//GEN-END:variables
}
