/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ZenBook
 */
public class movimientoEditar extends javax.swing.JDialog {
    
    private String[] datos; // Almacena los datos ingresados
    private boolean guardado = false; // Indica si se presionó "Guardar"

    public movimientoEditar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void cargarDatos(String[] datos) {
    txtfechaHora.setText(datos[0]);
    cmbTipo.setSelectedItem(datos[1]);
    cmbCategoria.setSelectedItem(datos[2]);
    txtNombre.setText(datos[3]);
    txtCantidad.setText(datos[4]);
    txtResponsable.setText(datos[5]);
    txtMotivo.setText(datos[6]);
}
     public String[] getDatos() {
        return datos;
    }

    
    public boolean isGuardado() {
        return guardado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new rojeru_san.RSButtonRiple();
        btnGuardar = new rojeru_san.RSButtonRiple();
        jLabel9 = new javax.swing.JLabel();
        txtfechaHora = new RSMaterialComponent.RSTextFieldMaterial();
        cmbCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        txtCantidad = new RSMaterialComponent.RSTextFieldMaterial();
        txtResponsable = new RSMaterialComponent.RSTextFieldMaterial();
        txtMotivo = new RSMaterialComponent.RSTextFieldOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 49, 82));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century751 BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar movimiento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Tipo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Categoria:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Nombre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, 20));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entrada", "Salida" }));
        cmbTipo.setColorMaterial(new java.awt.Color(0, 0, 0));
        cmbTipo.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 200, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Cantidad:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setText("Responsable:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setPhColor(new java.awt.Color(0, 0, 0));
        txtNombre.setPlaceholder("Ingrese el nombre...");
        txtNombre.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 200, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Motivo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(46, 49, 82));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 140, -1));

        btnGuardar.setBackground(new java.awt.Color(46, 49, 82));
        btnGuardar.setText("Actualizar");
        btnGuardar.setColorHover(new java.awt.Color(0, 153, 51));
        btnGuardar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 140, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("Fecha y hora:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtfechaHora.setForeground(new java.awt.Color(0, 0, 0));
        txtfechaHora.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtfechaHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfechaHora.setPhColor(new java.awt.Color(0, 0, 0));
        txtfechaHora.setPlaceholder("Ingrese fecha y hora...");
        txtfechaHora.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtfechaHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaHoraActionPerformed(evt);
            }
        });
        jPanel1.add(txtfechaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Materiales", "Herramientas" }));
        cmbCategoria.setColorMaterial(new java.awt.Color(0, 0, 0));
        cmbCategoria.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, 30));

        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.setPhColor(new java.awt.Color(0, 0, 0));
        txtCantidad.setPlaceholder("Ingrese la cantidad...");
        txtCantidad.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 200, 30));

        txtResponsable.setForeground(new java.awt.Color(0, 0, 0));
        txtResponsable.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtResponsable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtResponsable.setPhColor(new java.awt.Color(0, 0, 0));
        txtResponsable.setPlaceholder("Ingrese la cantidad...");
        txtResponsable.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResponsableActionPerformed(evt);
            }
        });
        jPanel1.add(txtResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 200, 30));

        txtMotivo.setForeground(new java.awt.Color(0, 0, 0));
        txtMotivo.setBorderColor(new java.awt.Color(204, 204, 204));
        txtMotivo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtMotivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMotivo.setPhColor(new java.awt.Color(0, 0, 0));
        txtMotivo.setPlaceholder("Ingrese el motivo...");
        txtMotivo.setSelectionColor(new java.awt.Color(102, 102, 102));
        jPanel1.add(txtMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose(); // Cierra la ventana emergente
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          datos = new String[]{
        txtfechaHora.getText(),
        (String) cmbTipo.getSelectedItem(),
        (String) cmbCategoria.getSelectedItem(),
        txtNombre.getText(),
        txtCantidad.getText(),
        txtResponsable.getText(),
        txtMotivo.getText()
    };

    // Validar que los campos no estén vacíos
    for (String dato : datos) {
        if (dato.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     }

    guardado = true;
    setVisible(false); // Cierra el diálogo
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtfechaHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaHoraActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResponsableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResponsableActionPerformed

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
            java.util.logging.Logger.getLogger(movimientoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(movimientoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(movimientoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(movimientoEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                movimientoEditar dialog = new movimientoEditar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple btnCancelar;
    private rojeru_san.RSButtonRiple btnGuardar;
    private RSMaterialComponent.RSComboBoxMaterial cmbCategoria;
    private RSMaterialComponent.RSComboBoxMaterial cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSTextFieldMaterial txtCantidad;
    private RSMaterialComponent.RSTextFieldOne txtMotivo;
    private RSMaterialComponent.RSTextFieldMaterial txtNombre;
    private RSMaterialComponent.RSTextFieldMaterial txtResponsable;
    private RSMaterialComponent.RSTextFieldMaterial txtfechaHora;
    // End of variables declaration//GEN-END:variables
}
