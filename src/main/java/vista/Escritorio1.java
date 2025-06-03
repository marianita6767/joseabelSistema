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
import vista.Caja.Egresos;
import vista.Caja.Ingresos;
import vista.Caja.formuEgresos1;
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
        btnNuevo4 = new RSMaterialComponent.RSButtonShape();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevo5 = new RSMaterialComponent.RSButtonShape();
        btnNuevo6 = new RSMaterialComponent.RSButtonShape();
        jLabel4 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        btnNuevo7 = new RSMaterialComponent.RSButtonShape();
        btnNuevo8 = new RSMaterialComponent.RSButtonShape();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNuevo9 = new RSMaterialComponent.RSButtonShape();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1290, 730));
        setPreferredSize(new java.awt.Dimension(890, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSComboBoxMaterial1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Notificaciones", " " }));
        rSComboBoxMaterial1.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel4.add(rSComboBoxMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 600, 60));

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
        jPanel4.add(btnproveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 200, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor (6).png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 60, 50));

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
        jPanel4.add(btnproveedores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 200, 120));

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
        jPanel4.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 210, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente (1).png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 60, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 60, 50));

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
        jPanel4.add(btnCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 210, 120));

        btnNuevo4.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo4.setText("       Usuarios Totales");
        btnNuevo4.setBackgroundHover(new java.awt.Color(0, 204, 0));
        btnNuevo4.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnNuevo4.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo4ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 200, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usu (1).png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 60, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 60, 50));

        btnNuevo5.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo5.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnNuevo5.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnNuevo5.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo5ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 200, 120));

        btnNuevo6.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo6.setText("         Pedidos Actuales");
        btnNuevo6.setBackgroundHover(new java.awt.Color(255, 102, 255));
        btnNuevo6.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnNuevo6.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo6ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 200, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, 50, 50));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/carrito-removebg-preview.png"))); // NOI18N
        jPanel4.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 100, 90));

        btnNuevo7.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo7.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnNuevo7.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnNuevo7.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo7ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 200, 120));

        btnNuevo8.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo8.setText("            Produccion");
        btnNuevo8.setBackgroundHover(new java.awt.Color(153, 204, 255));
        btnNuevo8.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnNuevo8.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo8ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 200, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 60, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proceso (1).png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 70, 60));

        btnNuevo9.setBackground(new java.awt.Color(204, 204, 204));
        btnNuevo9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo9.setBackgroundHover(new java.awt.Color(204, 204, 204));
        btnNuevo9.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnNuevo9.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo9ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 200, 120));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 730));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void btnproveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedoresActionPerformed
      
            proveedores pr = new proveedores(new javax.swing.JFrame(), true);
            pr.setSize(1260, 730);
            pr.setLocation(0,0);
            
            jPanel4.removeAll();
            jPanel4.add(pr);
            jPanel4.revalidate();
            jPanel4.repaint();
      
    }//GEN-LAST:event_btnproveedoresActionPerformed

    private void btnproveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedores1ActionPerformed
        
            proveedores pr = new proveedores(new javax.swing.JFrame(), true);
            pr.setSize(1260, 730);
            pr.setLocation(0,0);
            
            jPanel4.removeAll();
            jPanel4.add(pr);
            jPanel4.revalidate();
            jPanel4.repaint();
        
    }//GEN-LAST:event_btnproveedores1ActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente(new javax.swing.JFrame(), true);
            cl.setSize(1260, 730);
            cl.setLocation(0,0);
            
            jPanel4.removeAll();
            jPanel4.add(cl);
            jPanel4.revalidate();
            jPanel4.repaint();
        
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCliente1ActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente(new javax.swing.JFrame(), true);
            cl.setSize(1260, 730);
            cl.setLocation(0,0);
            
            jPanel4.removeAll();
            jPanel4.add(cl);
            jPanel4.revalidate();
            jPanel4.repaint();
        
    }//GEN-LAST:event_btnCliente1ActionPerformed

    private void btnNuevo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo4ActionPerformed

    private void btnNuevo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo5ActionPerformed

    private void btnNuevo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo6ActionPerformed

    private void btnNuevo7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo7ActionPerformed

    private void btnNuevo8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo8ActionPerformed

    private void btnNuevo9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevo9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonShape btnCliente;
    private RSMaterialComponent.RSButtonShape btnCliente1;
    private RSMaterialComponent.RSButtonShape btnNuevo4;
    private RSMaterialComponent.RSButtonShape btnNuevo5;
    private RSMaterialComponent.RSButtonShape btnNuevo6;
    private RSMaterialComponent.RSButtonShape btnNuevo7;
    private RSMaterialComponent.RSButtonShape btnNuevo8;
    private RSMaterialComponent.RSButtonShape btnNuevo9;
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
    private RSMaterialComponent.RSComboBoxMaterial rSComboBoxMaterial1;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables

}
