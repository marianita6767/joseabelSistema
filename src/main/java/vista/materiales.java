/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import modelo.MaterialDatos;

/**
 *
 * @author ZenBook
 */
public class materiales extends javax.swing.JPanel {

    /**
     * Creates new form materiales
     */
    
    public materiales() {
        initComponents();
        principalPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Layout para las tarjetas
 

    }
    

        // Método para agregar una nueva tarjeta
    public void agregarMaterial(MaterialDatos material) {
    
        
    JPanel tarjeta = new JPanel(new BorderLayout());
    tarjeta.setPreferredSize(new Dimension(210, 300)); // Ancho: 200, Alto: 300
    tarjeta.setBorder(BorderFactory.createLineBorder(Color.GRAY));

   // JPanel para la imagen
        JPanel panelImagen = new JPanel(new GridBagLayout());
        panelImagen.setPreferredSize(new Dimension(210, 197));
        panelImagen.setBackground(Color.WHITE);
        
        JLabel lblImagen = new JLabel();
        if (material.getImagen() != null) {
            lblImagen.setIcon(material.getImagen());
        } else {
            lblImagen.setText("No imagen");
        }
        panelImagen.add(lblImagen);
        tarjeta.add(panelImagen, BorderLayout.NORTH);

    
        // JPanel para la información
    JPanel panelInfo = new JPanel(new GridLayout(3, 1));
    panelInfo.setBackground(new Color(46,49,82)); // Color de fondo azul oscuro
    Font fuenteInfo = new Font("Segoe UI", Font.PLAIN, 15); // Fuente Arial, negrita, tamaño 16


    JLabel lblCodigo = new JLabel("Código: " + material.getCodigo());
    lblCodigo.setForeground(Color.WHITE);
    lblCodigo.setFont(fuenteInfo); // Establece la fuente
    lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
    panelInfo.add(lblCodigo);
    
    JLabel lblNombre = new JLabel("Nombre: " + material.getNombre());
    lblNombre.setForeground(Color.WHITE);
    lblNombre.setFont(fuenteInfo); // Establece la fuente
    lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
    panelInfo.add(lblNombre);
    
    JLabel lblCategoria = new JLabel("Categoría: " + material.getCategoria());
    lblCategoria.setForeground(Color.WHITE);
    lblCategoria.setFont(fuenteInfo); // Establece la fuente
    lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
    panelInfo.add(lblCategoria);
    
    tarjeta.add(panelInfo, BorderLayout.CENTER);
    
    
    
        // Almacenar el objeto MaterialDatos en la tarjeta
    tarjeta.putClientProperty("material", material);
    
    
    
    
        // JPanel para los botones
    JPanel panelBotones = new JPanel(new FlowLayout());
    panelBotones.setBackground(new Color(46,49,82));
    
    JButton verBtn = new JButton(new ImageIcon(getClass().getResource("/view (1).png"))); // Reemplaza "ver.png" con la ruta de tu imagen
    verBtn.setPreferredSize(new Dimension(36, 28)); // Ancho: 30, Alto: 30
    verBtn.setBackground(new Color(188,225,193)); // Establece el fondo en rojo
    //accion del boton de ver
    verBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            materialInfo dialog = new materialInfo(new javax.swing.JFrame(), true);
            dialog.mostrarMaterial(material); // Muestra la información del material
            dialog.setLocationRelativeTo(null); // Centra el JDialog
            dialog.setVisible(true); // Muestra el JDialog
        }
    });
    
    JButton editarBtn = new JButton(new ImageIcon(getClass().getResource("/edit.png")));
    editarBtn.setPreferredSize(new Dimension(36, 28)); // Ancho: 30, Alto: 30
    editarBtn.setBackground(new Color(166,199,245));
    //accion del boton de editar
    editarBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
  // Obtener el material asociado a la tarjeta
                MaterialDatos material = (MaterialDatos) tarjeta.getClientProperty("material");

                // Abrir el JDialog para editar
                materialEditar dialog = new materialEditar(new javax.swing.JFrame(), true, material);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

                // Si se guardaron los cambios, actualizar la tarjeta
                if (dialog.isGuardado()) {
                    actualizarTarjeta(tarjeta, material);
                    // Aquí podrías actualizar la base de datos si es necesario
                    System.out.println("Material actualizado: " + material.getNombre());
                }
    }
});
        
        
    
    JButton eliminarBtn = new JButton(new ImageIcon(getClass().getResource("/delete (6).png")));
    eliminarBtn.setPreferredSize(new Dimension(36, 28)); // Ancho: 30, Alto: 30
    eliminarBtn.setBackground(new Color(242,174,188));
    eliminarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar ventana emergente de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(
                    null, // Parent component (null para centrar en la pantalla)
                    "¿Estás seguro de que deseas eliminar este material?\nCódigo: " + material.getCodigo() + "\nNombre: " + material.getNombre(),
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
                );

                // Si el usuario selecciona "Sí", eliminar la tarjeta
                if (confirmacion == JOptionPane.YES_OPTION) {
                    principalPanel.remove(tarjeta); // Eliminar la tarjeta del panel
                    principalPanel.revalidate(); // Actualizar el layout
                    principalPanel.repaint(); // Redibujar el panel
                    System.out.println("Material eliminado: " + material.getNombre());
                } else {
                    System.out.println("Eliminación cancelada.");
                }
            }
        });
    
    panelBotones.add(verBtn);
    panelBotones.add(editarBtn);
    panelBotones.add(eliminarBtn);
    tarjeta.add(panelBotones, BorderLayout.SOUTH);
    
    

    

    principalPanel.add(tarjeta);
    principalPanel.revalidate();
    principalPanel.repaint();
}
    
//metodo para actualizar tarjeta
    public void actualizarTarjeta(JPanel tarjeta, MaterialDatos material) {
        // Obtener el panel de información (panelInfo) de la tarjeta
        JPanel panelInfo = (JPanel) tarjeta.getComponent(1); // El segundo componente es panelInfo

        // Actualizar las etiquetas dentro de panelInfo
        JLabel lblCodigo = (JLabel) panelInfo.getComponent(0);
        lblCodigo.setText("Código: " + material.getCodigo());

        JLabel lblNombre = (JLabel) panelInfo.getComponent(1);
        lblNombre.setText("Nombre: " + material.getNombre());

        JLabel lblCategoria = (JLabel) panelInfo.getComponent(2);
        lblCategoria.setText("Categoría: " + material.getCategoria());

        // Actualizar la imagen si es necesario
        JPanel panelImagen = (JPanel) tarjeta.getComponent(0); // El primer componente es panelImagen
        JLabel lblImagen = (JLabel) panelImagen.getComponent(0);
        if (material.getImagen() != null) {
            lblImagen.setIcon(material.getImagen());
            lblImagen.setText("");
        } else {
            lblImagen.setIcon(null);
            lblImagen.setText("No imagen");
        }

        tarjeta.revalidate();
        tarjeta.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelprincipal = new javax.swing.JPanel();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnNuevo = new rojeru_san.RSButtonRiple();
        principalPanel = new javax.swing.JPanel();
        rSComboMetro1 = new rojerusan.RSComboMetro();

        setPreferredSize(new java.awt.Dimension(1240, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelprincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelprincipal.setPreferredSize(new java.awt.Dimension(1240, 580));
        panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorIcon(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(153, 153, 153));
        txtBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtBuscar.setPhColor(new java.awt.Color(102, 102, 102));
        txtBuscar.setPlaceholder("Buscar...");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        panelprincipal.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 30));

        btnNuevo.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelprincipal.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 130, 30));

        principalPanel.setBackground(new java.awt.Color(245, 246, 250));
        principalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelprincipal.add(principalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1180, 690));

        rSComboMetro1.setColorArrow(new java.awt.Color(0, 0, 0));
        rSComboMetro1.setColorBorde(new java.awt.Color(255, 255, 255));
        rSComboMetro1.setColorFondo(new java.awt.Color(255, 255, 255));
        rSComboMetro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro1ActionPerformed(evt);
            }
        });
        panelprincipal.add(rSComboMetro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 260, 30));

        add(panelprincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevoMateriales dialog = new nuevoMateriales(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        // After the dialog is closed, check if a material was saved
               if (dialog.materialGuardado) { // Asumiendo que tienes una variable booleana materialGuardado en el JDialog
            agregarMaterial(dialog.material); // Asumiendo que tienes una variable material en el JDialog
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void rSComboMetro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSComboMetro1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnNuevo;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JPanel principalPanel;
    private rojerusan.RSComboMetro rSComboMetro1;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
