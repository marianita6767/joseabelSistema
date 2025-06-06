/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.Ctrl_Pedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Pedido;
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

        
        Tabla1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Configura el modelo de tabla correctamente
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Codigo", "Nombre", "Fecha inicio", "Fecha Final", "Estado", "Detalle", "Editar", "Cantidad", "Dimensiones"}
        ) {
            
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Tabla1.setModel(model);

        // Oculta las columnas adicionales después de establecer el modelo
        Tabla1.removeColumn(Tabla1.getColumnModel().getColumn(7)); // Oculta Dimensiones
        Tabla1.removeColumn(Tabla1.getColumnModel().getColumn(7)); // Oculta Cantidad

        // Configura el renderizador especial para la columna de estado (sobrescribe el general)
        Tabla1.getColumnModel().getColumn(4).setCellRenderer(new Escritorio1.EstadoTableCellRenderer());

        // Carga los datos
        obtenerMateriales();
    }
    

    
    
     private class EstadoTableCellRenderer extends DefaultTableCellRenderer {

        private final Color textColor = new Color(46, 49, 82);
        private final Font fontNormal = new Font("Tahoma", Font.PLAIN, 14);
        private final Font fontBold = new Font("Tahoma", Font.BOLD, 14);

        public EstadoTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            // Llamar al método padre primero
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            label.setHorizontalAlignment(CENTER);
            label.setText(value != null ? value.toString() : "");

            if (isSelected) {
                // Cuando está seleccionado, texto blanco y fondo de selección
                label.setForeground(Color.WHITE);
                label.setBackground(table.getSelectionBackground());
                label.setFont(fontBold);
            } else {
                // Cuando no está seleccionado, mantener el color original del texto
                label.setForeground(textColor);
                label.setFont(fontNormal);

                // Aplicar colores de fondo según el estado
                String estado = value != null ? value.toString() : "";
                switch (estado.toLowerCase()) {
                    case "pendiente":
                        label.setBackground(new Color(255, 204, 204)); // Rojo claro
                        break;
                    case "proceso":
                        label.setBackground(new Color(255, 255, 153)); // Amarillo claro
                        break;
                    case "finalizado":
                        label.setBackground(new Color(204, 255, 204)); // Verde claro
                        break;
                    default:
                        label.setBackground(Color.WHITE);
                        break;
                }
            }

            // Borde igual al resto de la tabla
            label.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
            Tabla1.setRowHeight(23); // Altura más delgada para las filas
            return label;
        }
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
        rSComboBoxMaterial1 = new RSMaterialComponent.RSComboBoxMaterial();
        btnproveedores = new RSMaterialComponent.RSButtonShape();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnproveedores1 = new RSMaterialComponent.RSButtonShape();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCliente = new RSMaterialComponent.RSButtonShape();
        btnCliente1 = new RSMaterialComponent.RSButtonShape();
        btnUsuario = new RSMaterialComponent.RSButtonShape();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnUsuario1 = new RSMaterialComponent.RSButtonShape();
        btnproduccion = new RSMaterialComponent.RSButtonShape();
        jLabel4 = new javax.swing.JLabel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jLabel5 = new javax.swing.JLabel();
        rSPanelImage2 = new rojerusan.RSPanelImage();
        btnproduccion1 = new RSMaterialComponent.RSButtonShape();
        btnprodu = new RSMaterialComponent.RSButtonShape();
        btnprodu1 = new RSMaterialComponent.RSButtonShape();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new rojerusan.RSTableMetro1();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1290, 730));
        setPreferredSize(new java.awt.Dimension(1290, 730));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1290, 730));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSComboBoxMaterial1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Notificaciones", " " }));
        rSComboBoxMaterial1.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        jPanel4.add(rSComboBoxMaterial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 430, 60));

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
        jPanel4.add(btnproveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor (6).png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 60, 60));

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
        jPanel4.add(btnproveedores1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 120));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente (1).png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 60, 60));

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
        jPanel4.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 210, 40));

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
        jPanel4.add(btnCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 210, 120));

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
        jPanel4.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usu (1).png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 60, 60));

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
        jPanel4.add(btnUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, 120));

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
        jPanel4.add(btnproduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 60, 60));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/carrito-removebg-preview.png"))); // NOI18N
        jPanel4.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 100, 90));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 60, 60));

        rSPanelImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/proceso (1).png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage2Layout = new javax.swing.GroupLayout(rSPanelImage2);
        rSPanelImage2.setLayout(rSPanelImage2Layout);
        rSPanelImage2Layout.setHorizontalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        rSPanelImage2Layout.setVerticalGroup(
            rSPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(rSPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 90, -1, 60));

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
        jPanel4.add(btnproduccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, 120));

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
        jPanel4.add(btnprodu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, 40));

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
        jPanel4.add(btnprodu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, -1, 120));

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Fecha Inicio", "Fecha Final", "Estado", "Detalle"
            }
        ));
        jScrollPane1.setViewportView(Tabla1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 660, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1491, 840));
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
    private rojerusan.RSTableMetro1 Tabla1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private RSMaterialComponent.RSComboBoxMaterial rSComboBoxMaterial1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSPanelImage rSPanelImage2;
    // End of variables declaration//GEN-END:variables

 public List<Ctrl_Pedido.MaterialConDetalles> obtenerMateriales() {
        List<Ctrl_Pedido.MaterialConDetalles> lista = new ArrayList<>();
        String sql = "SELECT p.*, CONCAT(c.nombre, ' ', c.apellido) AS nombre_cliente_completo "
                + "FROM pedido p "
                + "LEFT JOIN cliente c ON p.cliente_codigo = c.codigo";

        try (Connection con = Conexion.getConnection(); PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id_pedido"),
                        rs.getString("nombre"),
                        rs.getString("estado"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getInt("cliente_codigo")
                );

                String nombreClienteCompleto = rs.getString("nombre_cliente_completo");
                if (rs.wasNull()) {
                    nombreClienteCompleto = "Sin cliente";
                }

                lista.add(new Ctrl_Pedido.MaterialConDetalles(pedido, nombreClienteCompleto));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener materiales: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return lista;
    }
}
