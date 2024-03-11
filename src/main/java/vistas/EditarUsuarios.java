/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import controladores.controladorUsers;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import controladores.ControladorUtils;

/**
 *
 * @author samue
 */
public class EditarUsuarios extends javax.swing.JDialog {

    //hola
    /**
     * Creates new form EditarUsuarios
     */
    index prn = new index();

    private Modelo.Users user;
    private vistas.Usuarios usuarios;
    private JDateChooser dateChooser;
    controladorUsers ctrlu = new controladorUsers();

    public EditarUsuarios(java.awt.Frame parent, boolean modal, Modelo.Users user, vistas.Usuarios usuarios) throws ParseException {
        super(parent, modal);
        this.user = user;
        this.usuarios = usuarios;
        initComponents();
        initDateChooser();

        llenarCampos();
    }

    private void initDateChooser() {
        dateChooser = new JDateChooser();
        dateChooser.setBounds(30, 200, 125, 26);
        dateChooser.setBackground(java.awt.Color.RED);

        getContentPane().setLayout(null);
        getContentPane().add(dateChooser);
        dateChooser.repaint();

    }

    EditarUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void llenarCampos() throws ParseException {

        txtEditNameUsers.setText(user.getNombre());
        txtEditLastnameUsers.setText(user.getApellido());
        txtEditCelUsers.setText(user.getCelular());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date fecha = sdf.parse(user.getFecha_nacimiento());
            dateChooser.setDate(fecha);
        } catch (ParseException e) {
            System.out.println(e);
        }

        txtEditEmailUsers.setText(user.getEmail());

        int rol = ctrlu.getRol(user.getIdUsuario());
        cbxEditRol.setSelectedIndex(rol);

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar usuario");
        setIconImage(null);

        panelEditUsers.setBackground(new java.awt.Color(245, 245, 220));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 21, 22));
        jLabel3.setText("Fecha nacimiento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(85, 21, 22));
        jLabel6.setText("Correo");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 21, 22));
        jLabel7.setText("Rol");

        cbxEditRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige...", "Administrador", "Empleado", "Usuario" }));

        jSeparator1.setBackground(new java.awt.Color(97, 6, 63));
        jSeparator1.setForeground(new java.awt.Color(97, 6, 63));

        titleEditUsers.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleEditUsers.setForeground(new java.awt.Color(85, 21, 22));
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
        jLabel2.setForeground(new java.awt.Color(85, 21, 22));
        jLabel2.setText("Nombre");

        btnEditSave.setBackground(new java.awt.Color(97, 29, 73));
        btnEditSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditSave.setForeground(new java.awt.Color(255, 255, 255));
        btnEditSave.setText("Guardar");
        btnEditSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSaveActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(85, 21, 22));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(85, 21, 22));
        jLabel5.setText("celular");

        txtEditCelUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditCelUsersActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelEditUsersLayout = new javax.swing.GroupLayout(panelEditUsers);
        panelEditUsers.setLayout(panelEditUsersLayout);
        panelEditUsersLayout.setHorizontalGroup(
            panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditUsersLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(titleEditUsers)
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditUsersLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEditNameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(45, 45, 45))
                            .addGroup(panelEditUsersLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                    .addComponent(txtEditCelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(txtEditCelUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditUsersLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(txtEditLastnameUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(txtEditEmailUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(panelEditUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPasswordRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        vistas.RecuperarContraseña rc = new vistas.RecuperarContraseña(prn, user, true);
    }//GEN-LAST:event_btnPasswordRestoreActionPerformed

    private void txtEditCelUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditCelUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditCelUsersActionPerformed

    private void btnPasswordRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPasswordRestoreMouseClicked
        // TODO add your handling code here:
        RecuperarContraseña rc = new RecuperarContraseña(prn, user, true);
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
            
            if (objUtils.evaluarExpresion(expression, name) &&  objUtils.evaluarExpresion(expression, lastName)) {
                try {
                    int cel = Integer.parseInt(txtEditCelUsers.getText().trim());

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
                                        ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), String.valueOf(cel), dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                        usuarios.fillRows();
                                        JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                        this.setVisible(false);
                                    }
                                } else {
                                    ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), String.valueOf(cel), dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
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
                                    ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), String.valueOf(cel), dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                    usuarios.fillRows();
                                    JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                    this.setVisible(false);
                                }
                            } else {
                                ctrlu.actualizarUsuario(user.getIdUsuario(), txtEditNameUsers.getText(), txtEditLastnameUsers.getText(), String.valueOf(cel), dateChooser.getDate(), txtEditEmailUsers.getText(), rol);
                                usuarios.fillRows();
                                JOptionPane.showMessageDialog(this, "Usuario editado exitosamente");
                                this.setVisible(false);
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "La fecha seleccionada no puede ser anterior a la fecha actual.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Porfavor, ingresa un numero de telefono valido.");

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
    private javax.swing.JLabel jLabel1;
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
