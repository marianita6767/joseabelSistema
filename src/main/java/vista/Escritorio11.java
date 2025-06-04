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
public class Escritorio11 extends javax.swing.JPanel {

    public Escritorio11() {
        initComponents();


    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelImage1 = new rojeru_san.rspanel.RSPanelImage();
        rSPanelImage2 = new rojeru_san.rspanel.RSPanelImage();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1290, 730));
        setPreferredSize(new java.awt.Dimension(1290, 730));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/catalogo/th.jpg"))); // NOI18N
        add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 760, 390));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/logo blanco.png"))); // NOI18N
        add(rSPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 410, 300));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rspanel.RSPanelImage rSPanelImage1;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage2;
    // End of variables declaration//GEN-END:variables

}
