package vista.catalogo;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Catalogocategoria;
import modelo.producto;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;

public class catalogo extends javax.swing.JPanel {

    private List<Catalogocategoria> categorias = new ArrayList<>();
    private List<producto> productos = new ArrayList<>();
    private JScrollPane scrollPane;
    private javax.swing.JPanel panelPrincipal;

    public catalogo(JFrame jFrame, boolean par) {
        initComponents();
       // initCustomComponents();
    }
/*
    private void initCustomComponents() {
        panelPrincipal = new javax.swing.JPanel();
        panelPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 20));
        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));

        scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setViewportView(panelPrincipal);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1030, 590));
    }

    public void agregarCategoria(Catalogocategoria categoria) {
        categorias.add(categoria);
        actualizarPanelCategorias();
    }

    public void agregarProducto(producto producto) {
        if (producto != null) {
            productos.add(producto);
        }
    }

    void actualizarPanelCategorias() {
        panelPrincipal.removeAll();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBackground(new Color(242, 242, 242));

        Color colorTarjeta = new Color(242, 242, 242);
        int tarjetasPorFila = 4;
        JPanel filaActual = null;

        for (int i = 0; i < categorias.size(); i++) {
            Catalogocategoria cat = categorias.get(i);
            
            if (i % tarjetasPorFila == 0) {
                filaActual = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
                filaActual.setBackground(new Color(242, 242, 242));
                filaActual.setAlignmentX(Component.LEFT_ALIGNMENT);
                panelPrincipal.add(filaActual);
            }

            JPanel panelCategoria = crearPanelCategoria(cat);
            if (filaActual != null) {
                filaActual.add(panelCategoria);
            }
        }

        if (filaActual != null && filaActual.getComponentCount() > 0 && 
            filaActual.getComponentCount() < tarjetasPorFila) {
            int faltantes = tarjetasPorFila - filaActual.getComponentCount();
            for (int i = 0; i < faltantes; i++) {
                JPanel panelVacio = new JPanel();
                panelVacio.setPreferredSize(new Dimension(200, 240));
                panelVacio.setOpaque(false);
                filaActual.add(panelVacio);
            }
        }

        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        scrollPane.getVerticalScrollBar().setValue(0);
    }
/*
    private JPanel crearPanelCategoria(Catalogocategoria cat) {
        JPanel panelCategoria = new JPanel();
        panelCategoria.setLayout(new BorderLayout());
        panelCategoria.setPreferredSize(new Dimension(200, 240));
        panelCategoria.setBackground(new Color(242, 242, 242));
        panelCategoria.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(234, 234, 234)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Panel superior con botón editar
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setOpaque(false);

        JButton btnEditar = new JButton();
        btnEditar.setIcon(new ImageIcon(getClass().getResource("/catalogo/pencil1.png")));
        btnEditar.setContentAreaFilled(false);
        btnEditar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.BLACK, 2),
            BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));
        btnEditar.setBackground(new Color(46, 49, 82));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusPainted(false);
        btnEditar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setOpaque(false);
        buttonPanel.add(btnEditar);
        panelSuperior.add(buttonPanel, BorderLayout.EAST);

        panelCategoria.add(panelSuperior, BorderLayout.NORTH);

        // Panel de imagen con evento de clic
        JPanel imagenContainer = new JPanel(new BorderLayout());
        imagenContainer.setOpaque(false);
        imagenContainer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (cat.getImagen() != null) {
            ImageIcon icon = new ImageIcon(cat.getImagen().getScaledInstance(180, 140, Image.SCALE_SMOOTH));
            imagenLabel.setIcon(icon);
        }
        
        imagenContainer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarProductosDeCategoria(cat);
            }
        });
        
        imagenContainer.add(imagenLabel, BorderLayout.CENTER);
        panelCategoria.add(imagenContainer, BorderLayout.CENTER);

        // Nombre de la categoría
        JLabel nombreLabel = new JLabel(cat.getNombre(), SwingConstants.CENTER);
        nombreLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
        nombreLabel.setForeground(Color.BLACK);
        nombreLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nombreLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mostrarProductosDeCategoria(cat);
            }
        });
        panelCategoria.add(nombreLabel, BorderLayout.SOUTH);

        btnEditar.addActionListener(e -> abrirEditarCategoria(cat));

        return panelCategoria;
    }
/*
    private void mostrarProductosDeCategoria(Catalogocategoria categoria) {
    // Cambiar a la vista de productos
    removeAll();
    Producto productoPanel = new Producto((JFrame)SwingUtilities.getWindowAncestor(this), false, categoria);
    
    // Filtrar productos por categoría
    List<producto> productosCategoria = new ArrayList<>();
    for (producto p : productos) {
        if (p.getIdCategoria() == categoria.getId()) {
            productosCategoria.add(p);
        }
    }
    productoPanel.setProductos(productosCategoria);
    
    add(productoPanel);
    revalidate();
    repaint();
}

    private void abrirEditarCategoria(Catalogocategoria categoria) {
        categoriaeditar dialog = new categoriaeditar(
                (java.awt.Frame) SwingUtilities.getWindowAncestor(this),
                true,
                this,
                categoria
        );
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void actualizarCategoria(Catalogocategoria categoriaActualizada) {
        int index = categorias.indexOf(categoriaActualizada);
        if (index != -1) {
            categorias.set(index, categoriaActualizada);
            actualizarPanelCategorias();
        }
    }

  */



  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Añadir1 = new rojeru_san.RSButtonRiple();
        Eliminar = new rojeru_san.RSButtonRiple();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Añadir1.setBackground(new java.awt.Color(46, 49, 82));
        Añadir1.setText("categoria");
        Añadir1.setColorHover(new java.awt.Color(0, 153, 51));
        Añadir1.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        Añadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Añadir1ActionPerformed(evt);
            }
        });
        jPanel2.add(Añadir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 140, -1));

        Eliminar.setBackground(new java.awt.Color(46, 49, 82));
        Eliminar.setText("Eliminar");
        Eliminar.setColorHover(new java.awt.Color(0, 153, 51));
        Eliminar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1089, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Añadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir1ActionPerformed
  catalogocategoria dialog = new catalogocategoria(
                new javax.swing.JFrame(),
                true,
                this
        );
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
      
    }//GEN-LAST:event_Añadir1ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
    

    }//GEN-LAST:event_EliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple Añadir1;
    private rojeru_san.RSButtonRiple Eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
