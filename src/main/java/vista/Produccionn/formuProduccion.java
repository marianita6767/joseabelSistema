/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.Produccionn;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Conexion;

/**
 *
 * @author pc
 */
public class formuProduccion extends javax.swing.JDialog {

    /**
     * Creates new form formuProducacion
     */
    public formuProduccion(java.awt.Frame parent, boolean modal, Produccion produccionPanel) {
        super(parent, modal);
        setLocationRelativeTo(parent);
        initComponents();
        cargarNombresPedidos();

        txtcantidad.setEnabled(false);
        txtdimen.setEnabled(false);
    }

    public formuProduccion(java.awt.Frame parent, boolean modal) {
        this(parent, modal, null);  // Llama al nuevo constructor con null
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new rojeru_san.RSButtonRiple();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new rojeru_san.RSButtonRiple();
        Boxestado = new RSMaterialComponent.RSComboBoxMaterial();
        txtinicio = new com.toedter.calendar.JDateChooser();
        txtfinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtdimen = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel4 = new javax.swing.JLabel();
        BoxNombreP = new RSMaterialComponent.RSComboBoxMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 49, 82));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century751 BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produccion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("fecha final:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(46, 49, 82));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 18)); // NOI18N
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 140, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Estado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("fecha inicial:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(46, 49, 82));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida (1).png"))); // NOI18N
        btnCancelar.setText("Volver");
        btnCancelar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 18)); // NOI18N
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 140, -1));

        Boxestado.setForeground(new java.awt.Color(102, 102, 102));
        Boxestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "pendiente", "proceso", "finalizado" }));
        Boxestado.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        Boxestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxestadoActionPerformed(evt);
            }
        });
        jPanel1.add(Boxestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        txtinicio.setBackground(new java.awt.Color(255, 255, 255));
        txtinicio.setForeground(new java.awt.Color(255, 255, 255));
        txtinicio.setDateFormatString("y-MM-d");
        txtinicio.setMaxSelectableDate(new java.util.Date(253370786472000L));
        jPanel1.add(txtinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 200, 30));

        txtfinal.setBackground(new java.awt.Color(255, 255, 255));
        txtfinal.setForeground(new java.awt.Color(255, 255, 255));
        txtfinal.setDateFormatString("y-MM-d");
        jPanel1.add(txtfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 200, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtdimen.setForeground(new java.awt.Color(0, 0, 0));
        txtdimen.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtdimen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtdimen.setPhColor(new java.awt.Color(0, 0, 0));
        txtdimen.setPlaceholder("");
        txtdimen.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtdimen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdimenActionPerformed(evt);
            }
        });
        jPanel1.add(txtdimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dimensiones:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txtcantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtcantidad.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcantidad.setPhColor(new java.awt.Color(0, 0, 0));
        txtcantidad.setPlaceholder("");
        txtcantidad.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 200, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        BoxNombreP.setForeground(new java.awt.Color(102, 102, 102));
        BoxNombreP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        BoxNombreP.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        BoxNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxNombrePActionPerformed(evt);
            }
        });
        jPanel1.add(BoxNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//  Mostrar diálogo de confirmación
        alertaa confirmDialog = new alertaa(
                (Frame) this.getParent(),
                true,
                "Confirmar",
                "¿Desea guardar los datos?"
        );
        confirmDialog.setVisible(true);

        //  Si el usuario no confirma, salir
        if (!confirmDialog.opcionConfirmada) {
            return;
        }
// Validar campos obligatorios
        if (BoxNombreP.getSelectedIndex() == 0
                || txtinicio.getDate() == null
                || txtfinal.getDate() == null
                || Boxestado.getSelectedIndex() == 0) {
            new espacio_alerta((Frame) this.getParent(), true, "Error", "Todos los campos son obligatorios").setVisible(true);
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Conexion.getConnection();

            //  Obtener el iddetalle_pedido basado en el nombre seleccionado
            int idDetallePedido = obtenerIdDetallePedido(con, BoxNombreP.getSelectedItem().toString());
            if (idDetallePedido == -1) {
                new Error_id_((Frame) this.getParent(), true, "Error", "La fecha final no puede ser anterior a la inicial").setVisible(true);
                return;
            }

            //  Insertar en la tabla produccion
            String sql = "INSERT INTO produccion (fecha_inicio, fecha_fin, estado, detalle_pedido_iddetalle_pedido) "
                    + "VALUES (?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
            ps.setDate(1, new Date(txtinicio.getDate().getTime()));
            ps.setDate(2, new Date(txtfinal.getDate().getTime()));
            ps.setString(3, Boxestado.getSelectedItem().toString());
            ps.setInt(4, idDetallePedido);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                new Datos_guardados(
                        (Frame) this.getParent(),
                        true,
                        "exito",
                        "Datos guardados"
                ).setVisible(true);
                this.dispose();
            } else {
                new DatosActualizados(
                        (Frame) this.getParent(),
                        true,
                        "exito",
                        "Datos guardados"
                ).setVisible(true);
            }
        } catch (SQLException e) {
            new Error_guardar(
                    (Frame) this.getParent(),
                    true,
                    "exito",
                    "Datos guardados" + e.getMessage()
            ).setVisible(true);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void BoxestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxestadoActionPerformed

    private void txtdimenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdimenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdimenActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void BoxNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxNombrePActionPerformed
        if (BoxNombreP.getSelectedIndex() <= 0) {
            txtcantidad.setEnabled(false);
            txtdimen.setEnabled(false);
            return;
        }

        txtcantidad.setEnabled(true);
        txtdimen.setEnabled(true);

        Item selectedItem = (Item) BoxNombreP.getSelectedItem();
        int idDetallePedido = selectedItem.getId();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT cantidad, dimension FROM detalle_pedido WHERE iddetalle_pedido = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDetallePedido);
            rs = ps.executeQuery();

            if (rs.next()) {
                txtcantidad.setText(String.valueOf(rs.getInt("cantidad")));
                txtdimen.setText(rs.getString("dimension"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar detalles: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_BoxNombrePActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formuProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formuProduccion dialog = new formuProduccion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSComboBoxMaterial BoxNombreP;
    private RSMaterialComponent.RSComboBoxMaterial Boxestado;
    private rojeru_san.RSButtonRiple btnCancelar;
    private rojeru_san.RSButtonRiple btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSTextFieldMaterial txtcantidad;
    private RSMaterialComponent.RSTextFieldMaterial txtdimen;
    private com.toedter.calendar.JDateChooser txtfinal;
    private com.toedter.calendar.JDateChooser txtinicio;
    // End of variables declaration//GEN-END:variables
private int obtenerIdDetallePedido(Connection con, String nombrePedido) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT iddetalle_pedido FROM detalle_pedido WHERE descripcion = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, nombrePedido);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("iddetalle_pedido");
            }
            return -1; // Si no encuentra el pedido
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }

    private void cargarNombresPedidos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT iddetalle_pedido, descripcion FROM detalle_pedido ORDER BY descripcion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            BoxNombreP.removeAllItems();
            BoxNombreP.addItem("Seleccionar");

            while (rs.next()) {
                // Almacenamos el ID como el "valor" del item y la descripción como texto visible
                BoxNombreP.addItem(new Item(rs.getInt("iddetalle_pedido"), rs.getString("descripcion")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar pedidos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class Item {

        private int id;
        private String descripcion;

        public Item(int id, String descripcion) {
            this.id = id;
            this.descripcion = descripcion;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            cargarNombresPedidos();
        }
        super.setVisible(visible);
    }
}
