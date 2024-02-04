/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Modelo.Users;
import controladores.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

/**
 *
 * @author samue
 */
public class index extends javax.swing.JFrame {

    public String principalColor = "#852121", segundoColor = "#531415", tercerColor= "#601d49";
    /**
     * Creates new form index
     */
    public index() {
        initComponents();
        this.setLocationRelativeTo(null);

        Info in = new Info();
        showPanel(in);
        
        UIManager.put("nimbusBlueGrey", Color.decode(tercerColor));
        
        btnLogout.setContentAreaFilled(false);
        btnLogout.setOpaque(true);
        btnLogout.setBackground(new Color(133,33,33));

    }
    
    private String rol;
    
    /*public index(int rol){
        this.rol = rol;
    //Constructor para obtener el rol
    
    }*/
    public void setUserName(String name){
        this.userName.setText(name);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGesUsuarios3 = new javax.swing.JPanel();
        labelPerfil4 = new javax.swing.JLabel();
        btnGesUsuarios5 = new javax.swing.JPanel();
        labelPerfil6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        iconUsers1 = new javax.swing.JLabel();
        iconUsers2 = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        menuLateral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JPanel();
        labelInicio = new javax.swing.JLabel();
        iconInicio = new javax.swing.JLabel();
        textBiene = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPerfil = new javax.swing.JPanel();
        labelPerfil = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        btnProductos = new javax.swing.JPanel();
        labelProductos = new javax.swing.JLabel();
        iconProductos = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JPanel();
        labelUsuarios = new javax.swing.JLabel();
        iconUsers = new javax.swing.JLabel();
        btnPedidos = new javax.swing.JPanel();
        labelPerfil8 = new javax.swing.JLabel();
        iconPedidos = new javax.swing.JLabel();
        btnReservas = new javax.swing.JPanel();
        labelPerfil9 = new javax.swing.JLabel();
        iconReservas = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jpanelMain = new javax.swing.JPanel();
        papelTapiz = new javax.swing.JLabel();

        btnGesUsuarios3.setBackground(new java.awt.Color(133, 33, 33));
        btnGesUsuarios3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGesUsuarios3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGesUsuarios3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGesUsuarios3MouseExited(evt);
            }
        });

        labelPerfil4.setBackground(new java.awt.Color(255, 206, 172));
        labelPerfil4.setFont(new java.awt.Font("Boring Sans A Trial", 0, 18)); // NOI18N
        labelPerfil4.setForeground(new java.awt.Color(255, 206, 172));
        labelPerfil4.setText("Usuarios");

        javax.swing.GroupLayout btnGesUsuarios3Layout = new javax.swing.GroupLayout(btnGesUsuarios3);
        btnGesUsuarios3.setLayout(btnGesUsuarios3Layout);
        btnGesUsuarios3Layout.setHorizontalGroup(
            btnGesUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGesUsuarios3Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(labelPerfil4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnGesUsuarios3Layout.setVerticalGroup(
            btnGesUsuarios3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGesUsuarios3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(labelPerfil4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnGesUsuarios5.setBackground(new java.awt.Color(133, 33, 33));
        btnGesUsuarios5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGesUsuarios5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGesUsuarios5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGesUsuarios5MouseExited(evt);
            }
        });

        labelPerfil6.setBackground(new java.awt.Color(255, 206, 172));
        labelPerfil6.setFont(new java.awt.Font("Boring Sans A Trial", 0, 18)); // NOI18N
        labelPerfil6.setForeground(new java.awt.Color(255, 206, 172));
        labelPerfil6.setText("Usuarios");

        javax.swing.GroupLayout btnGesUsuarios5Layout = new javax.swing.GroupLayout(btnGesUsuarios5);
        btnGesUsuarios5.setLayout(btnGesUsuarios5Layout);
        btnGesUsuarios5Layout.setHorizontalGroup(
            btnGesUsuarios5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnGesUsuarios5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(labelPerfil6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnGesUsuarios5Layout.setVerticalGroup(
            btnGesUsuarios5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnGesUsuarios5Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(labelPerfil6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡Restaurante (Nombre del restaurante) le da la bienvenida!");
        setLocationByPlatform(true);
        setResizable(false);

        panelBody.setBackground(new java.awt.Color(245, 245, 205));
        panelBody.setMinimumSize(new java.awt.Dimension(1193, 762));

        menuLateral.setBackground(new java.awt.Color(133, 33, 33));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoCircle.png"))); // NOI18N

        btnInicio.setBackground(new java.awt.Color(133, 33, 33));
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
        });

        labelInicio.setBackground(new java.awt.Color(255, 206, 172));
        labelInicio.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelInicio.setForeground(new java.awt.Color(255, 206, 172));
        labelInicio.setText("Inicio");

        iconInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inicio.png"))); // NOI18N

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(iconInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(labelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(labelInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        textBiene.setFont(new java.awt.Font("Boring Sans A Trial", 0, 14)); // NOI18N
        textBiene.setForeground(new java.awt.Color(255, 255, 255));
        textBiene.setText("Bienvenido:");

        userName.setFont(new java.awt.Font("Boring Sans A Trial", 0, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("Usuario");

        jSeparator1.setBackground(new java.awt.Color(255, 206, 172));
        jSeparator1.setForeground(new java.awt.Color(255, 206, 172));

        btnPerfil.setBackground(new java.awt.Color(133, 33, 33));
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerfilMouseExited(evt);
            }
        });

        labelPerfil.setBackground(new java.awt.Color(255, 206, 172));
        labelPerfil.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelPerfil.setForeground(new java.awt.Color(255, 206, 172));
        labelPerfil.setText("Perfil");

        iconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        javax.swing.GroupLayout btnPerfilLayout = new javax.swing.GroupLayout(btnPerfil);
        btnPerfil.setLayout(btnPerfilLayout);
        btnPerfilLayout.setHorizontalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(labelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(129, 129, 129))
        );
        btnPerfilLayout.setVerticalGroup(
            btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPerfilLayout.createSequentialGroup()
                .addGroup(btnPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPerfilLayout.createSequentialGroup()
                        .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        btnProductos.setBackground(new java.awt.Color(133, 33, 33));
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductosMouseExited(evt);
            }
        });

        labelProductos.setBackground(new java.awt.Color(255, 206, 172));
        labelProductos.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelProductos.setForeground(new java.awt.Color(255, 206, 172));
        labelProductos.setText("Productos");

        iconProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/products.png"))); // NOI18N

        javax.swing.GroupLayout btnProductosLayout = new javax.swing.GroupLayout(btnProductos);
        btnProductos.setLayout(btnProductosLayout);
        btnProductosLayout.setHorizontalGroup(
            btnProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnProductosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(iconProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(labelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83))
        );
        btnProductosLayout.setVerticalGroup(
            btnProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(btnProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        btnUsuarios.setBackground(new java.awt.Color(133, 33, 33));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });

        labelUsuarios.setBackground(new java.awt.Color(255, 206, 172));
        labelUsuarios.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelUsuarios.setForeground(new java.awt.Color(255, 206, 172));
        labelUsuarios.setText("Usuarios");

        iconUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users.png"))); // NOI18N

        javax.swing.GroupLayout btnUsuariosLayout = new javax.swing.GroupLayout(btnUsuarios);
        btnUsuarios.setLayout(btnUsuariosLayout);
        btnUsuariosLayout.setHorizontalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUsuariosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(iconUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63)
                .addComponent(labelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(97, 97, 97))
        );
        btnUsuariosLayout.setVerticalGroup(
            btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUsuariosLayout.createSequentialGroup()
                .addGroup(btnUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnUsuariosLayout.createSequentialGroup()
                        .addComponent(iconUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        btnPedidos.setBackground(new java.awt.Color(133, 33, 33));
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPedidosMouseExited(evt);
            }
        });

        labelPerfil8.setBackground(new java.awt.Color(255, 206, 172));
        labelPerfil8.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelPerfil8.setForeground(new java.awt.Color(255, 206, 172));
        labelPerfil8.setText("Pedidos");

        iconPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedidos.png"))); // NOI18N

        javax.swing.GroupLayout btnPedidosLayout = new javax.swing.GroupLayout(btnPedidos);
        btnPedidos.setLayout(btnPedidosLayout);
        btnPedidosLayout.setHorizontalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPedidosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addComponent(labelPerfil8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );
        btnPedidosLayout.setVerticalGroup(
            btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPedidosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(btnPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPedidosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelPerfil8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnReservas.setBackground(new java.awt.Color(133, 33, 33));
        btnReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReservasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReservasMouseExited(evt);
            }
        });

        labelPerfil9.setBackground(new java.awt.Color(255, 206, 172));
        labelPerfil9.setFont(new java.awt.Font("Boring Sans A Trial", 0, 20)); // NOI18N
        labelPerfil9.setForeground(new java.awt.Color(255, 206, 172));
        labelPerfil9.setText("Mesas");

        iconReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mesa.png"))); // NOI18N

        javax.swing.GroupLayout btnReservasLayout = new javax.swing.GroupLayout(btnReservas);
        btnReservas.setLayout(btnReservasLayout);
        btnReservasLayout.setHorizontalGroup(
            btnReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReservasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconReservas)
                .addGap(60, 60, 60)
                .addComponent(labelPerfil9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(121, 121, 121))
        );
        btnReservasLayout.setVerticalGroup(
            btnReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReservasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnReservasLayout.createSequentialGroup()
                        .addComponent(labelPerfil9, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(iconReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnLogout.setBackground(new java.awt.Color(133, 33, 33));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        btnLogout.setBorder(null);
        btnLogout.setFocusPainted(false);
        btnLogout.setFocusable(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(textBiene)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menuLateralLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
            .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textBiene)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpanelMain.setBackground(new java.awt.Color(245, 245, 205));
        jpanelMain.setMaximumSize(new java.awt.Dimension(657, 657));
        jpanelMain.setPreferredSize(new java.awt.Dimension(921, 505));

        javax.swing.GroupLayout jpanelMainLayout = new javax.swing.GroupLayout(jpanelMain);
        jpanelMain.setLayout(jpanelMainLayout);
        jpanelMainLayout.setHorizontalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelMainLayout.setVerticalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        papelTapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/papelTapiza.jpg"))); // NOI18N

        javax.swing.GroupLayout panelBodyLayout = new javax.swing.GroupLayout(panelBody);
        panelBody.setLayout(panelBodyLayout);
        panelBodyLayout.setHorizontalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
                    .addComponent(papelTapiz, javax.swing.GroupLayout.PREFERRED_SIZE, 912, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelBodyLayout.setVerticalGroup(
            panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyLayout.createSequentialGroup()
                .addGroup(panelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuLateral, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBodyLayout.createSequentialGroup()
                        .addComponent(papelTapiz, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 664, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        btnPerfil.setBackground(Color.decode(segundoColor));

    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        btnPerfil.setBackground(Color.decode(principalColor));

    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseEntered
        // TODO add your handling code here:
        btnProductos.setBackground(Color.decode(segundoColor));
    }//GEN-LAST:event_btnProductosMouseEntered

    private void btnProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseExited
        // TODO add your handling code here:
        btnProductos.setBackground(Color.decode(principalColor));

    }//GEN-LAST:event_btnProductosMouseExited

    private void btnGesUsuarios3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGesUsuarios3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGesUsuarios3MouseEntered

    private void btnGesUsuarios3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGesUsuarios3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGesUsuarios3MouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        // TODO add your handling code 
        btnUsuarios.setBackground(Color.decode(segundoColor));
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        // TODO add your handling code here:
        btnUsuarios.setBackground(Color.decode(principalColor));
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnGesUsuarios5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGesUsuarios5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGesUsuarios5MouseEntered

    private void btnGesUsuarios5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGesUsuarios5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGesUsuarios5MouseExited

    private void btnPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseEntered
        // TODO add your handling code here:
        btnPedidos.setBackground(Color.decode(segundoColor));
    }//GEN-LAST:event_btnPedidosMouseEntered

    private void btnPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseExited
        // TODO add your handling code here:
        btnPedidos.setBackground(Color.decode(principalColor));
    }//GEN-LAST:event_btnPedidosMouseExited

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        // TODO add your handling code here:    String principalColor = "852121";

        btnInicio.setBackground(Color.decode(principalColor));

    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        // TODO add your handling code here:

        btnInicio.setBackground(Color.decode(segundoColor));
    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        // TODO add your handling code here:
        Info info = new Info();
        showPanel(info);
    }//GEN-LAST:event_btnInicioMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        // TODO add your handling code here:
        if("super_admin".equals(rol)){
            Usuarios us = new Usuarios();
            showPanel(us);
        }else{
            JOptionPane.showMessageDialog(this, "No tienes permisos suficientes para esta funcion.", "Permisos insuficientes", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        // TODO add your handling code here:
        if("super_admin".equals(rol)){
            Productos pr = new Productos();
            showPanel(pr);
        }else{
            JOptionPane.showMessageDialog(this, "No tienes permisos suficientes para esta funcion.", "Permisos insuficientes", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseClicked
        // TODO add your handling code here:
        Pedidos pd = new Pedidos();
        showPanel(pd);
    }//GEN-LAST:event_btnPedidosMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        // TODO add your handling code here:
                   
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.setVisible(false);

        Users modLogin = new Users();
        login visLogin = new login();

        Controlador ctrl = new Controlador(visLogin, modLogin);
        ctrl.iniciar();

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnReservasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservasMouseExited
        // TODO add your handling code here:
        btnReservas.setBackground(Color.decode(principalColor));
    }//GEN-LAST:event_btnReservasMouseExited

    private void btnReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservasMouseEntered
        // TODO add your handling code here:
        btnReservas.setBackground(Color.decode(segundoColor));
    }//GEN-LAST:event_btnReservasMouseEntered

    private void btnReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservasMouseClicked
        // TODO add your handling code here:
        Mesas rs = new Mesas();
        showPanel(rs);
    }//GEN-LAST:event_btnReservasMouseClicked

    
    public void runView(String rol) {
        this.rol = rol;
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnGesUsuarios3;
    private javax.swing.JPanel btnGesUsuarios5;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel btnPedidos;
    public javax.swing.JPanel btnPerfil;
    private javax.swing.JPanel btnProductos;
    private javax.swing.JPanel btnReservas;
    private javax.swing.JPanel btnUsuarios;
    private javax.swing.JLabel iconInicio;
    private javax.swing.JLabel iconPedidos;
    private javax.swing.JLabel iconProductos;
    private javax.swing.JLabel iconReservas;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel iconUsers;
    private javax.swing.JLabel iconUsers1;
    private javax.swing.JLabel iconUsers2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelMain;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JLabel labelPerfil4;
    private javax.swing.JLabel labelPerfil6;
    private javax.swing.JLabel labelPerfil8;
    private javax.swing.JLabel labelPerfil9;
    private javax.swing.JLabel labelProductos;
    private javax.swing.JLabel labelUsuarios;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel panelBody;
    private javax.swing.JLabel papelTapiz;
    private javax.swing.JLabel textBiene;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables

    protected void tableColor(JTableHeader t){
        t.setForeground(Color.WHITE);

        Font headerFont = new Font("Boring sans", Font.BOLD, 14);
        t.setFont(headerFont);
       
        t.repaint();
    }

    private void showPanel(JPanel p) {
        p.setSize(921, 505);
        p.setLocation(0, 0);

        jpanelMain.removeAll();
        jpanelMain.add(p, BorderLayout.CENTER);
        jpanelMain.revalidate();
        jpanelMain.repaint();
    }
}
