/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ZenBook
 */
public class Inventario extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    public Inventario() {

        initComponents();
        
        
        this.btnMateriales.setSelected(true);
        
        materiales es = new materiales();
        es.setSize(1000, 490);
        es.setLocation(0,0);
        
        panelprincipal.removeAll();
        panelprincipal.add(es, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
      
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHerramientas = new rojeru_san.RSButtonRiple();
        btnMovimientos = new rojeru_san.RSButtonRiple();
        panelprincipal = new javax.swing.JPanel();
        btnMateriales = new rojeru_san.RSButtonRiple();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(32767, 32));
        setPreferredSize(new java.awt.Dimension(1290, 730));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHerramientas.setBackground(new java.awt.Color(0, 0, 0));
        btnHerramientas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wrench.png"))); // NOI18N
        btnHerramientas.setText("Herramientas");
        btnHerramientas.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHerramientasActionPerformed(evt);
            }
        });
        add(btnHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 180, 40));

        btnMovimientos.setBackground(new java.awt.Color(0, 0, 0));
        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transfer.png"))); // NOI18N
        btnMovimientos.setText("  Movimientos");
        btnMovimientos.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });
        add(btnMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 190, -1));

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelprincipal.setPreferredSize(new java.awt.Dimension(960, 570));
        add(panelprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1240, 580));

        btnMateriales.setBackground(new java.awt.Color(0, 0, 0));
        btnMateriales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/box.png"))); // NOI18N
        btnMateriales.setText("  Materiales");
        btnMateriales.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialesActionPerformed(evt);
            }
        });
        add(btnMateriales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void btnHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHerramientasActionPerformed
        // TODO add your handling code here:
         if(!this.btnHerramientas.isSelected()) {
    this.btnMateriales.setSelected(false);  
    this.btnHerramientas.setSelected(true);  
      this.btnMovimientos.setSelected(false);
        
        herramientas h = new herramientas();
        h.setSize(960, 570);
        h.setLocation(0,0);
        
        panelprincipal.removeAll();
        panelprincipal.add(h);
        panelprincipal.revalidate();
        panelprincipal.repaint();

         }
    }//GEN-LAST:event_btnHerramientasActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
            if(!this.btnMovimientos.isSelected()) {
    this.btnMateriales.setSelected(false);  
    this.btnHerramientas.setSelected(false);  
      this.btnMovimientos.setSelected(true);
      
        movimientos es = new movimientos();
        es.setSize(960, 570);
        es.setLocation(0,0);
        
        panelprincipal.removeAll();
        panelprincipal.add(es);
        panelprincipal.revalidate();
        panelprincipal.repaint();
            }
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialesActionPerformed
      if(!this.btnMateriales.isSelected()) {
    this.btnMateriales.setSelected(true);  
    this.btnHerramientas.setSelected(false);  
      this.btnMovimientos.setSelected(false);
        
        materiales es = new materiales();
        es.setSize(960, 570);
        es.setLocation(0,0);
        
        panelprincipal.removeAll();
        panelprincipal.add(es);
        panelprincipal.revalidate();
        panelprincipal.repaint();

         }
    }//GEN-LAST:event_btnMaterialesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnHerramientas;
    private rojeru_san.RSButtonRiple btnMateriales;
    private rojeru_san.RSButtonRiple btnMovimientos;
    private javax.swing.JPanel panelprincipal;
    // End of variables declaration//GEN-END:variables


}

