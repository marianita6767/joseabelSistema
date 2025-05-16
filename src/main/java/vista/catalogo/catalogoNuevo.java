
package vista.catalogo;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.producto;

/**
 *
 * @author buitr
 */
public class catalogoNuevo extends javax.swing.JDialog {

     private producto productoCreado;
    
public catalogoNuevo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }
public producto getProductoCreado() {
    return this.productoCreado; 
}

private Image obtenerImagenDelLabel() {
    try {
        if (lblImagen.getIcon() != null && lblImagen.getIcon() instanceof ImageIcon) {
            return ((ImageIcon) lblImagen.getIcon()).getImage();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al obtener la imagen: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    return null;
}
 



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelP = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSubirImagen = new rojeru_san.RSButton();
        txtNombre = new RSMaterialComponent.RSTextFieldMaterial();
        txtColor = new RSMaterialComponent.RSTextFieldMaterial();
        btnCancelar = new rojeru_san.RSButtonRiple();
        btnGuardar = new rojeru_san.RSButtonRiple();
        lblImagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAltura = new RSMaterialComponent.RSTextFieldMaterial();
        txtProfundidad = new RSMaterialComponent.RSTextFieldMaterial();
        txtMaterial = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtAncho = new RSMaterialComponent.RSTextFieldMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelP.setBackground(new java.awt.Color(255, 255, 255));
        panelP.setPreferredSize(new java.awt.Dimension(500, 500));
        panelP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 49, 82));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century751 BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agregar Producto");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        panelP.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Nombre:");
        panelP.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        btnSubirImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/up-arrow (1).png"))); // NOI18N
        btnSubirImagen.setText(" Subir imagen");
        btnSubirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImagenActionPerformed(evt);
            }
        });
        panelP.add(btnSubirImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 140, 30));

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
        panelP.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 30));

        txtColor.setForeground(new java.awt.Color(0, 0, 0));
        txtColor.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtColor.setPhColor(new java.awt.Color(0, 0, 0));
        txtColor.setPlaceholder("Ingrese el color");
        txtColor.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        panelP.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 200, 30));

        btnCancelar.setBackground(new java.awt.Color(46, 49, 82));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelP.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 140, -1));

        btnGuardar.setBackground(new java.awt.Color(46, 49, 82));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(0, 153, 51));
        btnGuardar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelP.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 140, -1));

        lblImagen.setBackground(new java.awt.Color(153, 204, 255));
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelP.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 180, 120));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("Color");
        panelP.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        txtAltura.setForeground(new java.awt.Color(0, 0, 0));
        txtAltura.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtAltura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAltura.setPhColor(new java.awt.Color(0, 0, 0));
        txtAltura.setPlaceholder("Ingrese el alto");
        txtAltura.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlturaActionPerformed(evt);
            }
        });
        panelP.add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 200, 30));

        txtProfundidad.setForeground(new java.awt.Color(0, 0, 0));
        txtProfundidad.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtProfundidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProfundidad.setPhColor(new java.awt.Color(0, 0, 0));
        txtProfundidad.setPlaceholder("Ingrese la profundidad");
        txtProfundidad.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtProfundidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfundidadActionPerformed(evt);
            }
        });
        panelP.add(txtProfundidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        txtMaterial.setForeground(new java.awt.Color(0, 0, 0));
        txtMaterial.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtMaterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaterial.setPhColor(new java.awt.Color(0, 0, 0));
        txtMaterial.setPlaceholder("Ingrese el material");
        txtMaterial.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaterialActionPerformed(evt);
            }
        });
        panelP.add(txtMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 200, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel13.setText("Profundidad");
        panelP.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel14.setText("Material");
        panelP.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel15.setText("Ancho x Altura");
        panelP.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jPanel3.setBackground(new java.awt.Color(46, 49, 82));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelP.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 2, 360));

        txtAncho.setForeground(new java.awt.Color(0, 0, 0));
        txtAncho.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtAncho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAncho.setPhColor(new java.awt.Color(0, 0, 0));
        txtAncho.setPlaceholder("Ingrese el ancho");
        txtAncho.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtAncho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnchoActionPerformed(evt);
            }
        });
        panelP.add(txtAncho, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 200, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImagenActionPerformed
       // Obtener dimensiones del lblImagen
          JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Seleccionar imagen del producto");
    
    // Filtro para archivos de imagen
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Imágenes", "jpg", "jpeg", "png", "gif");
    fileChooser.setFileFilter(filter);
    
    int resultado = fileChooser.showOpenDialog(this);
    
    if (resultado == JFileChooser.APPROVE_OPTION) {
        try {
            File archivo = fileChooser.getSelectedFile();
            ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());
            
            // Escalar la imagen para que se ajuste al label
            Image imagen = icono.getImage().getScaledInstance(
                lblImagen.getWidth(), 
                lblImagen.getHeight(), 
                Image.SCALE_SMOOTH);
            
            lblImagen.setIcon(new ImageIcon(imagen));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al cargar la imagen: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    }//GEN-LAST:event_btnSubirImagenActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      
        dispose(); // Cierra la ventana emergente
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
                                
    try {
        // Validación de campos obligatorios
        if(txtNombre.getText().isEmpty() || lblImagen.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Nombre e imagen son campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validación de campos numéricos
        double ancho, altura, profundidad;
        try {
            ancho = txtAncho.getText().isEmpty() ? 0 : Double.parseDouble(txtAncho.getText());
            altura = txtAltura.getText().isEmpty() ? 0 : Double.parseDouble(txtAltura.getText());
            profundidad = txtProfundidad.getText().isEmpty() ? 0 : Double.parseDouble(txtProfundidad.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos de medidas deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Obtener la imagen
        Image imagen = ((ImageIcon)lblImagen.getIcon()).getImage();
        if (imagen == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear el producto
        this.productoCreado = new producto(
            txtNombre.getText(),
            txtColor.getText(),
            txtMaterial.getText(),
            ancho,
            altura,
            profundidad,
            imagen,
            1 // idCategoria - deberías tener un campo para esto
        );
        
        this.dispose();
    } catch(Exception e) {
        JOptionPane.showMessageDialog(this, 
            "Error al crear el producto: " + e.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void txtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlturaActionPerformed

    private void txtProfundidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfundidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfundidadActionPerformed

    private void txtMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaterialActionPerformed

    private void txtAnchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnchoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnchoActionPerformed

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
            java.util.logging.Logger.getLogger(catalogoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(catalogoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(catalogoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(catalogoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                catalogoNuevo dialog = new catalogoNuevo(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButton btnSubirImagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JPanel panelP;
    private RSMaterialComponent.RSTextFieldMaterial txtAltura;
    private RSMaterialComponent.RSTextFieldMaterial txtAncho;
    private RSMaterialComponent.RSTextFieldMaterial txtColor;
    private RSMaterialComponent.RSTextFieldMaterial txtMaterial;
    private RSMaterialComponent.RSTextFieldMaterial txtNombre;
    private RSMaterialComponent.RSTextFieldMaterial txtProfundidad;
    // End of variables declaration//GEN-END:variables
}
