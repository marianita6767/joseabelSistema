package vista.catalogo;

import java.awt.Image;
import javax.swing.ImageIcon;
import modelo.producto;

public class detalles extends javax.swing.JDialog {
    
   

    public detalles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

   

 public void setProducto(producto prod) {
        if (prod.getImagen() != null) {
            ImageIcon icon = new ImageIcon(prod.getImagen().getScaledInstance(
                ImgPrincipal.getWidth(), 
                ImgPrincipal.getHeight(), 
                Image.SCALE_SMOOTH));
            ImgPrincipal.setIcon(icon);
        }
          Nombre.setText(prod.getNombre());
        material.setText("Material: " + (prod.getMaterial() != null ? prod.getMaterial() : "N/A"));
        alto.setText("Alto: " + prod.getAltura());
        ancho.setText("Ancho: " + prod.getAncho());
        profundidad.setText("Profundidad: " + prod.getProfundidad());
        color.setText("Color: " + (prod.getColor() != null ? prod.getColor() : "N/A"));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        material = new javax.swing.JLabel();
        alto = new javax.swing.JLabel();
        ancho = new javax.swing.JLabel();
        profundidad = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        ImgPrincipal = new javax.swing.JLabel();
        cerrar = new rojeru_san.RSButtonRiple();
        Nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        material.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        material.setText("Material:");
        jPanel1.add(material, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 230, -1));

        alto.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        alto.setText("Alto:");
        jPanel1.add(alto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 250, -1));

        ancho.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ancho.setText("Ancho:");
        jPanel1.add(ancho, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 230, -1));

        profundidad.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        profundidad.setText("Profundidad:");
        jPanel1.add(profundidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 250, -1));

        color.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        color.setText("Color:");
        jPanel1.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 290, -1));

        ImgPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ImgPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 255, 220));

        cerrar.setBackground(new java.awt.Color(46, 49, 82));
        cerrar.setText("Cerrar");
        cerrar.setColorHover(new java.awt.Color(0, 153, 51));
        cerrar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 140, -1));

        Nombre.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        Nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Nombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 450, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
dispose();
    }//GEN-LAST:event_cerrarActionPerformed

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
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                detalles dialog = new detalles(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel ImgPrincipal;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel alto;
    private javax.swing.JLabel ancho;
    private rojeru_san.RSButtonRiple cerrar;
    private javax.swing.JLabel color;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel material;
    private javax.swing.JLabel profundidad;
    // End of variables declaration//GEN-END:variables
}
