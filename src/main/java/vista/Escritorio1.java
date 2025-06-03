/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

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
        // Forzar repintado
        proveedor.repaint();
        usuario.repaint();
        pedidos.repaint();
        cliente.repaint();
        stock.repaint();
        produccion.repaint();
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
        jPanel3 = new javax.swing.JPanel();
        usuario = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rSComboBoxMaterial1 = new RSMaterialComponent.RSComboBoxMaterial();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        proveedor = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pedidos = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cliente = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        stock = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        produccion = new RSMaterialComponent.RSButtonMaterialTwo();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1290, 730));
        setPreferredSize(new java.awt.Dimension(890, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.setBackground(new java.awt.Color(46, 49, 82));
        usuario.setText("Usuarios Totales");
        usuario.setBackgroundHover(new java.awt.Color(255, 204, 153));
        usuario.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        usuario.setForegroundHover(new java.awt.Color(0, 0, 0));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel3.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 180, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-usuario.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 40, 40));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 160, 130));

        rSComboBoxMaterial1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Notificaciones", " " }));
        rSComboBoxMaterial1.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel4.add(rSComboBoxMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 600, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 50));

        proveedor.setBackground(new java.awt.Color(46, 49, 82));
        proveedor.setText("Total de Proveedores");
        proveedor.setBackgroundHover(new java.awt.Color(255, 102, 102));
        proveedor.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        proveedor.setForegroundHover(new java.awt.Color(0, 0, 0));
        proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedorActionPerformed(evt);
            }
        });
        jPanel2.add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 190, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor-alternativo (1).png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 40, 50));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 170, 130));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedidos.setBackground(new java.awt.Color(46, 49, 82));
        pedidos.setText("Pedidos Actuales");
        pedidos.setBackgroundHover(new java.awt.Color(153, 255, 255));
        pedidos.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        pedidos.setForegroundHover(new java.awt.Color(0, 0, 0));
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        jPanel5.add(pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 190, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 60, 50));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/historial-de-pedidos.png"))); // NOI18N
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 40, 60));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 170, 130));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente.setBackground(new java.awt.Color(46, 49, 82));
        cliente.setText("Total de Clientes");
        cliente.setBackgroundHover(new java.awt.Color(153, 255, 153));
        cliente.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        cliente.setForegroundHover(new java.awt.Color(0, 0, 0));
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        jPanel6.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 190, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atencion-al-cliente.png"))); // NOI18N
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 50, 50));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 170, 130));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stock.setBackground(new java.awt.Color(46, 49, 82));
        stock.setText("Stock Actual");
        stock.setBackgroundHover(new java.awt.Color(204, 204, 204));
        stock.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        stock.setForegroundHover(new java.awt.Color(0, 0, 0));
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });
        jPanel7.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 180, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setText("10");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 50, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alt-de-inventario.png"))); // NOI18N
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 60, 50));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 160, 130));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        produccion.setBackground(new java.awt.Color(46, 49, 82));
        produccion.setText("Produccion");
        produccion.setBackgroundHover(new java.awt.Color(255, 102, 255));
        produccion.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        produccion.setForegroundHover(new java.awt.Color(0, 0, 0));
        produccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produccionActionPerformed(evt);
            }
        });
        jPanel8.add(produccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -3, 190, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paquete.png"))); // NOI18N
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 50, 50));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 170, 130));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximopedido();
    }//GEN-LAST:event_pedidosActionPerformed

    private void produccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produccionActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximoproduccion();
    }//GEN-LAST:event_produccionActionPerformed

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximousuario();
    }//GEN-LAST:event_usuarioActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximocliente();
    }//GEN-LAST:event_clienteActionPerformed

    private void proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedorActionPerformed
        // TODO add your handling code here:
        actualizarIdMaximoProveedor();
    }//GEN-LAST:event_proveedorActionPerformed

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialTwo cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private RSMaterialComponent.RSButtonMaterialTwo pedidos;
    private RSMaterialComponent.RSButtonMaterialTwo produccion;
    private RSMaterialComponent.RSButtonMaterialTwo proveedor;
    private RSMaterialComponent.RSComboBoxMaterial rSComboBoxMaterial1;
    private RSMaterialComponent.RSButtonMaterialTwo stock;
    private RSMaterialComponent.RSButtonMaterialTwo usuario;
    // End of variables declaration//GEN-END:variables

}
