/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Conexion;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JPanel;
import vista.Caja.Egresos;
import vista.Caja.Ingresos;
import vista.Caja.formuEgresos1;
import vista.Produccionn.Produccion;
import vista.Ventas.pedido;
import vista.proveedor.proveedores;

/**
 *
 * @author Personal
 */
public class Escritorio1 extends javax.swing.JPanel {

    public Escritorio1() {
        initComponents();

        actualizarIdMaximoProveedor();
        actualizarIdMaximocliente();
        actualizarIdMaximousuario();
        actualizarIdMaximoproduccion();
        actualizarIdMaximopedido();

    }
    

    private void actualizarIdMaximoProveedor() {
        if (jLabel1 == null) {
            return;
        }
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM proveedor"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("total");
                jLabel1.setText(String.valueOf(maxId));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener el ID máximo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarIdMaximocliente() {
        if (jLabel2 == null) {
            return;
        }
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM cliente"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("total");
                jLabel2.setText(String.valueOf(maxId));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener el ID máximo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarIdMaximousuario() {
        if (jLabel3 == null) {
            return;
        }
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM usuario"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("total");
                jLabel3.setText(String.valueOf(maxId));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener el ID máximo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarIdMaximoproduccion() {
        if (jLabel5 == null) {
            return;
        }
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM produccion"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("total");
                jLabel5.setText(String.valueOf(maxId));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener el ID máximo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarIdMaximopedido() {
        if (jLabel4 == null) {
            return;
        }
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS total FROM pedido"); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int maxId = rs.getInt("total");
                jLabel4.setText(String.valueOf(maxId));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener el ID máximo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        rSComboBoxMaterial1 = new RSMaterialComponent.RSComboBoxMaterial();
        btnproveedores = new RSMaterialComponent.RSButtonShape();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnproveedores1 = new RSMaterialComponent.RSButtonShape();
        btnCliente = new RSMaterialComponent.RSButtonShape();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCliente1 = new RSMaterialComponent.RSButtonShape();
        btnUsuario = new RSMaterialComponent.RSButtonShape();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUsuario1 = new RSMaterialComponent.RSButtonShape();
        btnproduccion = new RSMaterialComponent.RSButtonShape();
        jLabel4 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        btnproduccion1 = new RSMaterialComponent.RSButtonShape();
        btnprodu = new RSMaterialComponent.RSButtonShape();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnprodu1 = new RSMaterialComponent.RSButtonShape();
        rSCalendar1 = new rojeru_san.rsdate.RSCalendar();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1290, 730));
        setPreferredSize(new java.awt.Dimension(1290, 730));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1290, 730));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        rSComboBoxMaterial1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Notificaciones", " " }));
        rSComboBoxMaterial1.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N

        btnproveedores.setBackground(new java.awt.Color(46, 49, 82));
        btnproveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        btnproveedores.setText("   Total de Proveedores");
        btnproveedores.setAutoscrolls(true);
        btnproveedores.setBackgroundHover(new java.awt.Color(255, 102, 102));
        btnproveedores.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnproveedores.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnproveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedoresActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor (6).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });

        btnproveedores1.setBackground(new java.awt.Color(204, 204, 204));
        btnproveedores1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnproveedores1.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnproveedores1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnproveedores1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnproveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedores1ActionPerformed(evt);
            }
        });

        btnCliente.setBackground(new java.awt.Color(46, 49, 82));
        btnCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCliente.setText("         Total de Clientes");
        btnCliente.setBackgroundHover(new java.awt.Color(153, 153, 255));
        btnCliente.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnCliente.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnCliente1.setBackground(new java.awt.Color(204, 204, 204));
        btnCliente1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCliente1.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnCliente1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnCliente1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCliente1ActionPerformed(evt);
            }
        });

        btnUsuario.setBackground(new java.awt.Color(46, 49, 82));
        btnUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUsuario.setText("       Usuarios Totales");
        btnUsuario.setBackgroundHover(new java.awt.Color(0, 204, 0));
        btnUsuario.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnUsuario.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usu (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnUsuario1.setBackground(new java.awt.Color(204, 204, 204));
        btnUsuario1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUsuario1.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnUsuario1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnUsuario1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuario1ActionPerformed(evt);
            }
        });

        btnproduccion.setBackground(new java.awt.Color(46, 49, 82));
        btnproduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnproduccion.setText("         Pedidos Actuales");
        btnproduccion.setBackgroundHover(new java.awt.Color(255, 102, 255));
        btnproduccion.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnproduccion.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproduccionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/carrito-removebg-preview.png"))); // NOI18N

        btnproduccion1.setBackground(new java.awt.Color(204, 204, 204));
        btnproduccion1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnproduccion1.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnproduccion1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnproduccion1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnproduccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproduccion1ActionPerformed(evt);
            }
        });

        btnprodu.setBackground(new java.awt.Color(46, 49, 82));
        btnprodu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprodu.setText("            Produccion");
        btnprodu.setBackgroundHover(new java.awt.Color(153, 204, 255));
        btnprodu.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnprodu.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnprodu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproduActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proceso (1).png"))); // NOI18N

        btnprodu1.setBackground(new java.awt.Color(204, 204, 204));
        btnprodu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnprodu1.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnprodu1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnprodu1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnprodu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnproveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel6))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnproveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel7))
                            .addComponent(btnCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8))
                            .addComponent(btnUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnproduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnproduccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnprodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnprodu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSComboBoxMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(rSCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnproveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnproveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnproduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(rSPanelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnproduccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprodu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnprodu1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11)))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSComboBoxMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rSCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1491, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void btnproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedoresActionPerformed

        if (!this.btnproveedores.isSelected()) { 
            this.btnproveedores.setSelected(true);

            proveedores pr = new proveedores(new javax.swing.JFrame(), true);
            pr.setSize(1290, 730);
            pr.setLocation(0, 0);


            jPanel4.removeAll();
            jPanel4.add(pr);
            jPanel4.revalidate();
            jPanel4.repaint();
        }
    }//GEN-LAST:event_btnproveedoresActionPerformed

    private void btnproveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedores1ActionPerformed

        proveedores pr = new proveedores(new javax.swing.JFrame(), true);
        pr.setSize(1260, 730);
        pr.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(pr);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_btnproveedores1ActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed

        // TODO add your handling code here:
        Cliente cl = new Cliente(new javax.swing.JFrame(), true);
        cl.setSize(1260, 730);
        cl.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(cl);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliente1ActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente(new javax.swing.JFrame(), true);
        cl.setSize(1260, 730);
        cl.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(cl);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_btnCliente1ActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed

        Usuario usu = new Usuario(new javax.swing.JFrame(), true);
        usu.setSize(1260, 730);
        usu.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(usu);
        jPanel4.revalidate();
        jPanel4.repaint();

    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuario1ActionPerformed

        Usuario usu = new Usuario(new javax.swing.JFrame(), true);
        usu.setSize(1260, 730);
        usu.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(usu);
        jPanel4.revalidate();
        jPanel4.repaint();
     }//GEN-LAST:event_btnUsuario1ActionPerformed

    private void btnproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproduccionActionPerformed
        vista.Ventas.pedido pedidos = new vista.Ventas.pedido(jPanel4);
        pedidos.setSize(1290, 730);
        pedidos.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(pedidos);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_btnproduccionActionPerformed

    private void btnproduccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproduccion1ActionPerformed
        vista.Ventas.pedido pedidos = new vista.Ventas.pedido(jPanel4);
        pedidos.setSize(1290, 730);
        pedidos.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(pedidos);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_btnproduccion1ActionPerformed

    private void btnproduActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproduActionPerformed

        Produccion pro = new Produccion(new javax.swing.JFrame(), true);
        pro.setSize(1260, 730);
        pro.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(pro);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_btnproduActionPerformed

    private void btnprodu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodu1ActionPerformed

        Produccion pro = new Produccion(new javax.swing.JFrame(), true);
        pro.setSize(1260, 730);
        pro.setLocation(0, 0);

        jPanel4.removeAll();
        jPanel4.add(pro);
        jPanel4.revalidate();
        jPanel4.repaint();
    }//GEN-LAST:event_btnprodu1ActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximocliente();
    }//GEN-LAST:event_clienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonShape btnCliente;
    private RSMaterialComponent.RSButtonShape btnCliente1;
    private RSMaterialComponent.RSButtonShape btnUsuario;
    private RSMaterialComponent.RSButtonShape btnUsuario1;
    private RSMaterialComponent.RSButtonShape btnprodu;
    private RSMaterialComponent.RSButtonShape btnprodu1;
    private RSMaterialComponent.RSButtonShape btnproduccion;
    private RSMaterialComponent.RSButtonShape btnproduccion1;
    private RSMaterialComponent.RSButtonShape btnproveedores;
    private RSMaterialComponent.RSButtonShape btnproveedores1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private rojeru_san.rsdate.RSCalendar rSCalendar1;
    private RSMaterialComponent.RSComboBoxMaterial rSComboBoxMaterial1;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables

}
