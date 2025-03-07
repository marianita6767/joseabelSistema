/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Contrl_login;
//import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Usuario;


/**
 *
 * @author buitr
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("CARPINTERIA JOSE ABEL");
        this.setSize(new Dimension(700, 500));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        rSButtonMetroBeanInfo1 = new rojerusan.RSButtonMetroBeanInfo();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel2 = new javax.swing.JLabel();
        passtxt = new RSMaterialComponent.RSPasswordTwo();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(29, 30, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setText("Recuerdame");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 106, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel4.setText("¡INICIAR SESION!");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 270, 50));

        txt_usuario.setForeground(new java.awt.Color(29, 30, 51));
        txt_usuario.setCaretColor(new java.awt.Color(29, 30, 51));
        txt_usuario.setColorMaterial(new java.awt.Color(29, 30, 51));
        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_usuario.setPhColor(new java.awt.Color(29, 30, 51));
        txt_usuario.setPlaceholder("Ingrese el usuario");
        txt_usuario.setSelectionColor(new java.awt.Color(29, 30, 51));
        jPanel6.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 310, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Usuario");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(29, 30, 51));
        rSMaterialButtonRectangle1.setText("INGRESAR");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 190, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 30, 51));
        jLabel2.setText("¿Olvidaste contraseña?");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 180, 20));

        passtxt.setForeground(new java.awt.Color(204, 204, 204));
        passtxt.setText("********");
        passtxt.setToolTipText("");
        passtxt.setBorderColor(new java.awt.Color(204, 204, 204));
        passtxt.setPhColor(new java.awt.Color(204, 204, 204));
        passtxt.setPlaceholder("passtxtpasstxt");
        passtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passtxtFocusGained(evt);
            }
        });
        passtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passtxtMousePressed(evt);
            }
        });
        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });
        jPanel6.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 272, 310, 30));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 400, 540));

        jPanel8.setBackground(new java.awt.Color(29, 30, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CARPINTERIA");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JOSE ABEL");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        Login();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
    Contrasena contra= new Contrasena();
        contra.setVisible(true); 
        this.dispose();     
  
    }//GEN-LAST:event_jLabel2MousePressed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        
    }//GEN-LAST:event_passtxtActionPerformed

    private void passtxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passtxtMousePressed
     
    }//GEN-LAST:event_passtxtMousePressed

    private void passtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passtxtFocusGained
       passtxt.setText("");
    }//GEN-LAST:event_passtxtFocusGained

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private RSMaterialComponent.RSPasswordTwo passtxt;
    private rojerusan.RSButtonMetroBeanInfo rSButtonMetroBeanInfo1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private RSMaterialComponent.RSTextFieldMaterial txt_usuario;
    // End of variables declaration//GEN-END:variables


private void Login(){
 if(!txt_usuario.getText().isEmpty()&& !passtxt.getText().isEmpty()){
    Contrl_login controlUsuario= new Contrl_login();
     Usuario usuario = new Usuario();
    usuario.setUsuario(txt_usuario.getText().trim());
     usuario.setContrasena(passtxt.getText().trim());
     
     if(controlUsuario.loginUser(usuario)){
         JOptionPane.showMessageDialog(null, "Bienvenido");
         Principal pc = new Principal();
         pc.setVisible(true);
        this.dispose();
    }else{
         JOptionPane.showMessageDialog(null, "el usuario o las credenciales estan incorrectas, intente de nuevo");
     }
     
 }else{
      JOptionPane.showMessageDialog(null, "porfavor rellene todos los campos");
}
}

}
    
    
    

