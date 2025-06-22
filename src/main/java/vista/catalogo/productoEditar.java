package vista.catalogo;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import modelo.producto;

public class productoEditar extends javax.swing.JDialog {
    private producto producto;
    private boolean guardado = false;
    private Image imagenTemporal;

    public productoEditar(java.awt.Frame parent, boolean modal, producto producto) {
        super(parent, modal);
        this.producto = producto;
        initComponents();
        cargarDatosProducto();
        setLocationRelativeTo(parent);
    }

    private void cargarDatosProducto() {
        if (producto != null) {
            txtNombre.setText(producto.getNombre());
            txtColor.setText(producto.getColor());
            txtMaterial.setText(producto.getMaterial());
            txtProfundidad.setText(String.valueOf(producto.getProfundidad()));
            txtAncho.setText(String.valueOf(producto.getAncho()));
            txtAltura.setText(String.valueOf(producto.getAltura()));
            
            if (producto.getImagen() != null) {
                imagenTemporal = producto.getImagen();
                ImageIcon icon = new ImageIcon(imagenTemporal);
                lblImagen.setIcon(icon);
            }
        }
    }

    public producto getProductoEditado() {
        return guardado ? producto : null;
    }
    
     private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            Double.parseDouble(txtProfundidad.getText());
            Double.parseDouble(txtAncho.getText());
            Double.parseDouble(txtAltura.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Las dimensiones deben ser valores numéricos válidos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
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
        txtColor.setPlaceholder("Ingrese el id");
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
        txtAltura.setPlaceholder("Ingrese el id");
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
        txtProfundidad.setPlaceholder("Ingrese el id");
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
        txtMaterial.setPlaceholder("Ingrese el id");
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
        txtAncho.setPlaceholder("Ingrese el id");
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
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                BufferedImage bufferedImage = ImageIO.read(file);
                
                // Escalar la imagen para mostrarla en el label
                Image imagenEscalada = bufferedImage.getScaledInstance(
                    lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                
                ImageIcon icon = new ImageIcon(imagenEscalada);
                lblImagen.setIcon(icon);
                
                // Guardar la imagen original para cuando se guarde
                imagenTemporal = bufferedImage;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error al cargar la imagen: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirImagenActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose(); // Cierra la ventana emergente
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

     if (validarCampos()) {
            try {
                producto.setNombre(txtNombre.getText());
                producto.setColor(txtColor.getText());
                producto.setMaterial(txtMaterial.getText());
                producto.setProfundidad(Double.parseDouble(txtProfundidad.getText()));
                producto.setAncho(Double.parseDouble(txtAncho.getText()));
                producto.setAltura(Double.parseDouble(txtAltura.getText()));
                
                if (imagenTemporal != null) {
                    producto.setImagen(imagenTemporal);
                }
                
                guardado = true;
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                    "Por favor ingrese valores numéricos válidos para las dimensiones", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
