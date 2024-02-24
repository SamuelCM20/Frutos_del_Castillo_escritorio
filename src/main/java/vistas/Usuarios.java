/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import controladores.ControladorUtils;
import controladores.CustomHeaderRenderer;
import controladores.controladorUsers;
import controladores.controladorIndex;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author samue
 */
public class Usuarios extends javax.swing.JPanel {

    index prn = new index();

    /**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();

        tableModel();
        fillRows();
        tableUsuarios.getTableHeader().setDefaultRenderer(new CustomHeaderRenderer());
    }

    private controladorUsers conObject = new controladorUsers();
    private controladorIndex ctrl = new controladorIndex();
    private DefaultTableModel modelTableUsuarios;
    private List<Modelo.Users> listaUsers;

    private ControladorUtils objControladorUtils = new ControladorUtils();

    int rowSelected = -1;

    public void tableModel() {
        String[] titulosTablaUsuarios = {"Identificación", "Nombre", "Apellido", "Rol", "Estado"};
        modelTableUsuarios = objControladorUtils.addTableModel(modelTableUsuarios, tableUsuarios, titulosTablaUsuarios);
    }

    public String getNombreDisponibilidad(int state) {

        String nombre = "";
        if (state == 0) {
            nombre = "Inactivo";
        } else if (state == 1) {
            nombre = "Activo";
        }

        return nombre;

    }

    public void fillRows() {

        modelTableUsuarios.setRowCount(0);
        listaUsers = conObject.getUsers();

        listaUsers.forEach(l -> {
            String estado = getNombreDisponibilidad(l.getEstado());
            String rol = ctrl.obtenerRol(l.getIdUsuario());

            modelTableUsuarios.addRow(new Object[]{l.getIdUsuario(), l.getNombre(), l.getApellido(), rol, estado});
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitleUsers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        addUsers = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(245, 245, 220));

        labelTitleUsers.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleUsers.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleUsers.setForeground(new java.awt.Color(96, 29, 73));
        labelTitleUsers.setText("Usuarios del sistema");

        tableUsuarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(96, 29, 73)));
        tableUsuarios.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"4313233", "hola", "pepe", "admin", null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificación", "Nombre", "Apellido", "Rol", "Disponibilidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableUsuarios.setGridColor(new java.awt.Color(204, 204, 204));
        tableUsuarios.setSelectionBackground(new java.awt.Color(173, 0, 113));
        tableUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableUsuarios.setShowHorizontalLines(true);
        tableUsuarios.setShowVerticalLines(true);
        tableUsuarios.getTableHeader().setResizingAllowed(false);
        tableUsuarios.getTableHeader().setReorderingAllowed(false);
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);
        if (tableUsuarios.getColumnModel().getColumnCount() > 0) {
            tableUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(3).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(4).setResizable(false);
        }

        addUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        addUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUsersMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTitleUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addUsers))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitleUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUsers))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        // TODO add your handling code here:

        rowSelected = tableUsuarios.getSelectedRow();
        Modelo.Users user = (Modelo.Users) listaUsers.get(rowSelected);

        EditarUsuarios eu;
        try {
            eu = new EditarUsuarios(prn, true, user, this);
            eu.setLocationRelativeTo(null);
            eu.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tableUsuariosMouseClicked

    private void addUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUsersMouseClicked
        // TODO add your handling code here:

        agregarUsuario as = new agregarUsuario(prn, true, this);
        as.setLocationRelativeTo(null);
        as.setVisible(true);
    }//GEN-LAST:event_addUsersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitleUsers;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
