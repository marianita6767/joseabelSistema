 package vista.catalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.producto;

public class Producto extends javax.swing.JPanel {
    private List<producto> productos = new ArrayList<>();
    private JScrollPane scrollPane;

    public Producto(JFrame jFrame, boolean par) {
        initComponents();
        initCustomComponents();
    }

    private void initCustomComponents() {
        this.setBackground(new Color(242, 242, 242));
        this.setLayout(new BorderLayout());

        PProductos.setBackground(new Color(242, 242, 242));
        PProductos.setLayout(new GridLayout(0, 4, 20, 20));

        // Panel de botones superior
        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.setBackground(new Color(242, 242, 242));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Botón Volver a la izquierda
        JPanel panelIzquierdo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIzquierdo.setOpaque(false);
        panelIzquierdo.add(volver);
        panelBotones.add(panelIzquierdo, BorderLayout.WEST);

        // Botón Añadir a la derecha
        JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDerecho.setOpaque(false);
        panelDerecho.add(Nueva);
        panelBotones.add(panelDerecho, BorderLayout.EAST);

        // Configuración del scroll pane
        scrollPane = new JScrollPane(PProductos);
        scrollPane.setBackground(new Color(242, 242, 242));
        scrollPane.getViewport().setBackground(new Color(242, 242, 242));
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(panelBotones, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        configurarBoton(Nueva);
        configurarBoton(volver);
    }

    private void configurarBoton(rojeru_san.RSButtonRiple boton) {
        boton.setBackground(new Color(46, 49, 82));
        boton.setForeground(Color.WHITE);
        boton.setColorHover(new Color(70, 73, 106));
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void agregarProducto(producto producto) {
        if (producto != null) {
            productos.add(producto);
            actualizarPanelProductos();
            
            SwingUtilities.invokeLater(() -> {
                JScrollBar vertical = scrollPane.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
            });
        }
    }

    private void actualizarPanelProductos() {
        PProductos.removeAll();

        if (productos.isEmpty()) {
            JLabel mensaje = new JLabel("No hay productos para mostrar", SwingConstants.CENTER);
            mensaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            mensaje.setForeground(Color.GRAY);
            PProductos.add(mensaje);
        } else {
            PProductos.setLayout(new GridLayout(0, 4, 20, 20));
            
            for (producto prod : productos) {
                JPanel panelProducto = crearPanelProducto(prod, Color.WHITE);
                if (panelProducto != null) {
                    PProductos.add(panelProducto);
                }
            }
        }

        PProductos.revalidate();
        PProductos.repaint();
    }

 private JPanel crearPanelProducto(producto prod, Color colorTarjeta) {
    try {
        JPanel panelProducto = new JPanel(new BorderLayout());
        panelProducto.setPreferredSize(new Dimension(250, 300));
        panelProducto.setBackground(colorTarjeta);
        panelProducto.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Panel de imagen con efecto hover y click
        JPanel panelImagen = new JPanel(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(230, 180));
        panelImagen.setBackground(Color.WHITE);

        JLabel imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (prod.getImagen() != null) {
            ImageIcon iconoNormal = new ImageIcon(prod.getImagen().getScaledInstance(230, 180, Image.SCALE_SMOOTH));
            ImageIcon iconoHover = new ImageIcon(prod.getImagen().getScaledInstance(250, 200, Image.SCALE_SMOOTH));
            
            imagenLabel.setIcon(iconoNormal);
            
            // Efecto hover
            panelImagen.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    imagenLabel.setIcon(iconoHover);
                    panelImagen.setPreferredSize(new Dimension(250, 200));
                    panelProducto.revalidate();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    imagenLabel.setIcon(iconoNormal);
                    panelImagen.setPreferredSize(new Dimension(230, 180));
                    panelProducto.revalidate();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    mostrarDetallesProducto(prod);
                }
            });
        } else {
            imagenLabel.setText("Sin imagen");
            imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imagenLabel.setForeground(Color.GRAY);
        }

        panelImagen.add(imagenLabel, BorderLayout.CENTER);
        panelProducto.add(panelImagen, BorderLayout.CENTER);

        // Panel inferior con nombre y botones
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setOpaque(false);
        panelInferior.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        // Nombre del producto
        JLabel nombreLabel = new JLabel(prod.getNombre());
        nombreLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        nombreLabel.setForeground(Color.BLACK);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelInferior.add(nombreLabel, BorderLayout.CENTER);

        // Panel de botones (siempre visibles)
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panelBotones.setOpaque(false);

        // Botón Editar
        JButton btnEditar = crearBotonAccion("/catalogo/pencil1.png", "Editar", e -> {
            productoEditar dialog = new productoEditar(
                (JFrame) SwingUtilities.getWindowAncestor(this),
                true,
                prod
            );
            dialog.setVisible(true);

            if (dialog.getProductoEditado() != null) {
                actualizarProducto(dialog.getProductoEditado());
            }
        });
        panelBotones.add(btnEditar);

        // Botón Eliminar
        JButton btnEliminar = crearBotonAccion("/catalogo/delete.png", "Eliminar", e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que quieres eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                productos.remove(prod);
                actualizarPanelProductos();
            }
        });
        panelBotones.add(btnEliminar);

        panelInferior.add(panelBotones, BorderLayout.SOUTH);
        panelProducto.add(panelInferior, BorderLayout.SOUTH);

        return panelProducto;
    } catch (Exception e) {
        System.err.println("Error al crear panel de producto");
        e.printStackTrace();
        return null;
    }
}



  private void mostrarDetallesProducto(producto prod) {
    detalles dialog = new detalles((JFrame)SwingUtilities.getWindowAncestor(this), true);
    dialog.setProducto(prod); // Usamos el nuevo método para configurar los datos
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}

    private JButton crearBotonAccion(String iconPath, String tooltip, ActionListener listener) {
        JButton boton = new JButton();
        boton.setPreferredSize(new Dimension(24, 24));
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setToolTipText(tooltip);
        
        try {
            boton.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        } catch (Exception e) {
            boton.setText(tooltip.substring(0, 1));
        }
        
        boton.addActionListener(listener);
        return boton;
    }

    public void actualizarProducto(producto productoActualizado) {
        int index = productos.indexOf(productoActualizado);
        if (index != -1) {
            productos.set(index, productoActualizado);
            actualizarPanelProductos();
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nueva = new rojeru_san.RSButtonRiple();
        volver = new rojeru_san.RSButtonRiple();
        PProductos = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nueva.setBackground(new java.awt.Color(46, 49, 82));
        Nueva.setText("Añadir");
        Nueva.setColorHover(new java.awt.Color(0, 153, 51));
        Nueva.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        Nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevaActionPerformed(evt);
            }
        });
        add(Nueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 140, -1));

        volver.setBackground(new java.awt.Color(46, 49, 82));
        volver.setText("volver");
        volver.setColorHover(new java.awt.Color(0, 153, 51));
        volver.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 140, -1));

        PProductos.setLayout(new java.awt.BorderLayout());
        add(PProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void NuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevaActionPerformed
    catalogoNuevo dialog = new catalogoNuevo((JFrame)this.getTopLevelAncestor(), true);
dialog.setVisible(true);

// Después de que se cierra el diálogo
producto nuevoProducto = dialog.getProductoCreado();
if (nuevoProducto != null) {
    // Asegúrate de que este método realmente añade el producto a la lista y actualiza la vista
    agregarProducto(nuevoProducto); 
}

    }//GEN-LAST:event_NuevaActionPerformed
                         

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed

        
    }//GEN-LAST:event_volverActionPerformed

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple Nueva;
    private javax.swing.JPanel PProductos;
    private rojeru_san.RSButtonRiple volver;
    // End of variables declaration//GEN-END:variables
}

