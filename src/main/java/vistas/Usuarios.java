/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import controladores.ControladorUtils;
import controladores.CustomHeaderRenderer;
import controladores.CustomCellRenderer;
import controladores.controladorUsers;
import controladores.controladorIndex;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        tableUsuarios.setDefaultRenderer(Object.class, new CustomCellRenderer());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private controladorUsers conObject = new controladorUsers();
    private controladorIndex ctrl = new controladorIndex();
    private ControladorUtils objControladorUtils = new ControladorUtils();
    
    private DefaultTableModel modelTableUsuarios;
    private List<Modelo.Users> listaUsers;
  
    int rowSelected = -1;
    
    public void tableModel() {
        String[] titulosTablaUsuarios = {"Identificación", "Nombre", "Apellido", "Rol"};
        modelTableUsuarios = objControladorUtils.addTableModel(modelTableUsuarios, tableUsuarios, titulosTablaUsuarios);  
    }
    
    public void fillRows() {

        modelTableUsuarios.setRowCount(0);
        listaUsers = conObject.getUsers();
        
        listaUsers.forEach(l -> {
            String rol = ctrl.obtenerRol(l.getIdUsuario());

            modelTableUsuarios.addRow(new Object[]{l.getIdUsuario(), l.getNombre(), l.getApellido(), rol});
        });

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        addUsers = new javax.swing.JLabel();
        labelTitleUsers = new javax.swing.JLabel();
        btnEditarUser = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setBackground(new java.awt.Color(238, 238, 213));
        setPreferredSize(new java.awt.Dimension(967, 549));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(245, 245, 220));
        jPanel1.setMaximumSize(new java.awt.Dimension(980, 580));
        jPanel1.setMinimumSize(new java.awt.Dimension(940, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(940, 480));
        jPanel1.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(245, 245, 220));
        panelHeader.setMinimumSize(new java.awt.Dimension(979, 80));
        panelHeader.setPreferredSize(new java.awt.Dimension(565, 80));
        panelHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mas.png"))); // NOI18N
        addUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUsersMouseClicked(evt);
            }
        });
        panelHeader.add(addUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, -1, -1));

        labelTitleUsers.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleUsers.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleUsers.setForeground(new java.awt.Color(85, 21, 22));
        labelTitleUsers.setText("Usuarios del sistema");
        labelTitleUsers.setPreferredSize(new java.awt.Dimension(352, 47));
        panelHeader.add(labelTitleUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, 470, 56));

        btnEditarUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditarUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarUserMouseClicked(evt);
            }
        });
        panelHeader.add(btnEditarUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 60, 60));

        jPanel1.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelBody.setBackground(new java.awt.Color(245, 245, 220));
        panelBody.setLayout(new java.awt.CardLayout(20, 20));

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
        tableUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableUsuarios.setFocusable(false);
        tableUsuarios.setGridColor(new java.awt.Color(204, 204, 204));
        tableUsuarios.setSelectionBackground(new java.awt.Color(165, 45, 126));
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

        panelBody.add(jScrollPane1, "card2");

        jPanel1.add(panelBody, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUsuariosMouseClicked
        // TODO add your handling code here:       
    }//GEN-LAST:event_tableUsuariosMouseClicked

    private void addUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUsersMouseClicked
        // TODO add your handling code here:

        agregarUsuario as = new agregarUsuario(prn, true,this);
        as.setLocationRelativeTo(null);
        as.setVisible(true);
    }//GEN-LAST:event_addUsersMouseClicked

    private void btnEditarUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarUserMouseClicked
        // TODO add your handling code here:
        
        
        rowSelected = tableUsuarios.getSelectedRow();
        if (conObject.validarSeleccionTabla(rowSelected)) {
        Modelo.Users user = (Modelo.Users) listaUsers.get(rowSelected);
        
        EditarUsuarios eu;
        try {
            eu = new EditarUsuarios(prn, true,user,this);
            eu.setLocationRelativeTo(null);
            eu.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            JOptionPane.showMessageDialog(this, "Se necesita seleccionar una fila de la tabla.");
            
        }
    }//GEN-LAST:event_btnEditarUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addUsers;
    private javax.swing.JLabel btnEditarUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitleUsers;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
