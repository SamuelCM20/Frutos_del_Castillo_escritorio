/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import java.awt.FlowLayout;

/**
 *
 * @author samue
 */
public class Reservas extends javax.swing.JPanel {

    /**
     * Creates new form Reservas
     */
    public Reservas() {
        initComponents();
        content.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitlePedidos = new javax.swing.JLabel();
        panelReservas = new javax.swing.JPanel();
        btnAddMesa = new javax.swing.JButton();
        contentScroll = new javax.swing.JScrollPane();
        labelTitleReserv = new javax.swing.JLabel();
        scrollReservas = new javax.swing.JScrollPane();
        content = new javax.swing.JPanel();

        labelTitlePedidos.setBackground(new java.awt.Color(255, 255, 255));
        labelTitlePedidos.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitlePedidos.setForeground(new java.awt.Color(96, 29, 73));
        labelTitlePedidos.setText("Gestionar Pedidos");

        panelReservas.setBackground(new java.awt.Color(245, 245, 220));
        panelReservas.setForeground(new java.awt.Color(96, 29, 73));

        btnAddMesa.setBackground(new java.awt.Color(96, 29, 73));
        btnAddMesa.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        btnAddMesa.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMesa.setText("+");
        btnAddMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMesaActionPerformed(evt);
            }
        });

        labelTitleReserv.setBackground(new java.awt.Color(255, 255, 255));
        labelTitleReserv.setFont(new java.awt.Font("Boring Sans A Trial", 1, 36)); // NOI18N
        labelTitleReserv.setForeground(new java.awt.Color(96, 29, 73));
        labelTitleReserv.setText("Gestionar reservas");

        scrollReservas.setBackground(new java.awt.Color(255, 255, 255));
        scrollReservas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollReservas.setPreferredSize(new java.awt.Dimension(851, 380));

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setMinimumSize(new java.awt.Dimension(100, 111));
        content.setPreferredSize(new java.awt.Dimension(851, 5000));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );

        scrollReservas.setViewportView(content);

        javax.swing.GroupLayout panelReservasLayout = new javax.swing.GroupLayout(panelReservas);
        panelReservas.setLayout(panelReservasLayout);
        panelReservasLayout.setHorizontalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReservasLayout.createSequentialGroup()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelReservasLayout.createSequentialGroup()
                                .addComponent(contentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65))
                            .addGroup(panelReservasLayout.createSequentialGroup()
                                .addComponent(labelTitleReserv, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                .addGap(336, 336, 336)))
                        .addComponent(btnAddMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        panelReservasLayout.setVerticalGroup(
            panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservasLayout.createSequentialGroup()
                .addGroup(panelReservasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnAddMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelReservasLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelTitleReserv, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(contentScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMesaActionPerformed
        agregarMesa();
            // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMesa;
    private javax.swing.JPanel content;
    private javax.swing.JScrollPane contentScroll;
    private javax.swing.JLabel labelTitlePedidos;
    private javax.swing.JLabel labelTitleReserv;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JScrollPane scrollReservas;
    // End of variables declaration//GEN-END:variables
    
    public void agregarMesa(){
        Modelo.Reservas rs = new Modelo.Reservas();
       
        content.add(rs); 
        content.revalidate();
    }
}

