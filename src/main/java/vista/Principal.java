/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;


import vista.Produccionn.Produccion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import vista.Inventario.herramientas;
import vista.Inventario.materiales;

import vista.catalogo.catalogo;

/**
 *
 * @author Personal
 */
public class Principal extends javax.swing.JFrame {

    private JPanel submenuInventario;
    private boolean submenuVisible = false; // Para controlar si el submenú está visible

    public Principal() {

        initComponents();

        jPanel4.setVisible(false);
        jPanel5.setVisible(false);

//scrollpanel---------------------------
        // Definir un JScrollPane y envolver el contenedor
        JScrollPane scrollPane = new JScrollPane(contenedor);
        scrollPane.setBounds(260, 80, 1020, 550); // Tamaño del área visible

// Asegurar el desplazamiento horizontal y vertical
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Forzar barra horizontal

        scrollPane.setBorder(null); // Quitar el borde del JScrollPane
        contenedor.setBorder(null); // Quitar el borde del JPanel

// Ajustar el tamaño preferido del contenedor para que sea más grande que el JScrollPane
        contenedor.setPreferredSize(new Dimension(1290, 870)); // Asegura un tamaño mayor al viewport

// Agregar el JScrollPane al panel principal
        jPanel1.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 1020, 730));

        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 8));

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(153, 153, 153);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return new JButton() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(0, 0);
                    }
                };
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return new JButton() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(0, 0);
                    }
                };
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(thumbColor);
                g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
                g2.dispose();
            }
        });
//scrollpanel ---------------------

        // Inicializar el submenú
        submenuInventario = new JPanel();
        submenuInventario.setBackground(new Color(29, 30, 51)); // Mismo color que el menú
        submenuInventario.setLayout(new GridLayout(2, 1, 0, 0)); // 3 filas, 1 columna, espacio entre ítems
        submenuInventario.setPreferredSize(new Dimension(260, 80)); // Reducir altura total para reflejar menos espacio

        // Añadir ítems al submenú (como botones)
        JButton item1 = new JButton("Materiales");
        item1.setBackground(new Color(9, 10, 19));
        item1.setForeground(Color.WHITE);
        item1.setFont(new Font("Tahoma", Font.BOLD, 14));
        item1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 60, 0, 0)); // Margen izquierdo de 10 píxeles
        item1.setFocusPainted(false); // Quitar el borde de enfoque
        item1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        item1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Texto a la derecha del ícono
        item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tratar-con-cuidado.png"))); // Ícono a la izquierda
        item1.setIconTextGap(10); // Espacio entre ícono y texto
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                materiales m = new materiales(); // Cargar Inventario aquí si lo deseas
                m.setSize(1290, 730);
                m.setLocation(0, 0);
                contenedor.removeAll();
                contenedor.add(m);
                contenedor.revalidate();
                contenedor.repaint();
            }
        });

        JButton item2 = new JButton("Herramientas");
        item2.setBackground(new Color(9, 10, 19));
        item2.setForeground(Color.WHITE);
        item2.setFont(new Font("Tahoma", Font.BOLD, 14));
        item2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 60, 0, 0)); // Margen izquierdo de 10 píxeles
        item2.setFocusPainted(false); // Quitar el borde de enfoque
        item2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        item2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT); // Texto a la derecha del ícono
        item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/llave-inglesa.png"))); // Ícono a la izquierda
        item2.setIconTextGap(10); // Espacio entre ícono y texto
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                herramientas h = new herramientas(); // Cargar Inventario aquí si lo deseas
                h.setSize(1290, 730);
                h.setLocation(0, 0);
                contenedor.removeAll();
                contenedor.add(h);
                contenedor.revalidate();
                contenedor.repaint();
            }
        });

        submenuInventario.add(item1);
        submenuInventario.add(item2);

        // Seleccionar el botón "uno" por defecto y cargar el panel Escritorio1
        this.uno.setSelected(true);
        Escritorio1 es = new Escritorio1();
        es.setSize(1290, 730); // Ajustar tamaño dinámicamente
        es.setLocation(0, 0);

        contenedor.removeAll();
        contenedor.add(es, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();

    }

    private void animacion() {
        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -258, 2, 2, jPanel3);
            Animacion.Animacion.mover_izquierda(258, +111, 2, 2, contenedor);

            jPanel4.setVisible(true);
            jPanel5.setVisible(false);

        } else {
            Animacion.Animacion.mover_derecha(-258, 0, 2, 2, jPanel3);
            Animacion.Animacion.mover_derecha(-2, +258, 2, 2, contenedor);

            jPanel4.setVisible(false);
            jPanel5.setVisible(true);
            jPanel5.setOpaque(false);

        }
    }

    private void ocultarSubmenu() {
        if (submenuVisible) {
            jPanel3.removeAll();
            jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // Restaurar posiciones originales de los botones
            jPanel3.add(rSPanelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 41, 158, 153));
            jPanel3.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 260, 60));
            jPanel3.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 60));
            jPanel3.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 260, 60));
            jPanel3.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 260, 60));
            jPanel3.add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 260, 60));
            jPanel3.add(seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 260, 60));
            jPanel3.add(siete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 260, 60));
            jPanel3.add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 260, 60));
            jPanel3.add(nueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 260, 60));

            dos.setText(" Inventario           ▼"); // Indicar submenú cerrado
            submenuVisible = false;
            jPanel3.revalidate();
            jPanel3.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new rojeru_san.RSButton();
        jButton3 = new javax.swing.JButton();
        noti = new rojeru_san.RSButton();
        jPanel3 = new javax.swing.JPanel();
        dos = new rojeru_san.RSButton();
        tres = new rojeru_san.RSButton();
        cuatro = new rojeru_san.RSButton();
        cinco = new rojeru_san.RSButton();
        seis = new rojeru_san.RSButton();
        ocho = new rojeru_san.RSButton();
        siete1 = new rojeru_san.RSButton();
        nueve = new rojeru_san.RSButton();
        uno = new rojeru_san.RSButton();
        rSPanelImage3 = new rojerusan.RSPanelImage();
        jPanel4 = new javax.swing.JPanel();
        uno1 = new rojeru_san.RSButton();
        dos1 = new rojeru_san.RSButton();
        tres1 = new rojeru_san.RSButton();
        cuatro1 = new rojeru_san.RSButton();
        cinco1 = new rojeru_san.RSButton();
        seis1 = new rojeru_san.RSButton();
        siete2 = new rojeru_san.RSButton();
        ocho1 = new rojeru_san.RSButton();
        nueve1 = new rojeru_san.RSButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(1290, 730));
        jPanel5.setPreferredSize(new java.awt.Dimension(1290, 730));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setMinimumSize(new java.awt.Dimension(1290, 730));
        contenedor.setPreferredSize(new java.awt.Dimension(1290, 730));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(29, 30, 81));

        jButton2.setBackground(new java.awt.Color(29, 30, 81));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida (1).png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CARPINTERIA");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JOSE ABEL");

        menu.setBackground(new java.awt.Color(29, 30, 81));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burger-bar.png"))); // NOI18N
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(29, 30, 81));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario (2).png"))); // NOI18N
        jButton3.setText("Usuario");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        noti.setBackground(new java.awt.Color(29, 30, 81));
        noti.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notificacion (1).png"))); // NOI18N
        noti.setText("Notificaiones");
        noti.setToolTipText("");
        noti.setColorHover(new java.awt.Color(128, 128, 128));
        noti.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        noti.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        noti.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        noti.setIconTextGap(10);
        noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(666, 666, 666)
                .addComponent(noti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(noti, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(29, 30, 81));

        dos.setBackground(new java.awt.Color(29, 30, 81));
        dos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja.png"))); // NOI18N
        dos.setText("Inventario           ▼");
        dos.setColorHover(new java.awt.Color(128, 128, 128));
        dos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dos.setMaximumSize(new java.awt.Dimension(127, 24));
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });

        tres.setBackground(new java.awt.Color(29, 30, 81));
        tres.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor-de-servicio.png"))); // NOI18N
        tres.setText(" Proveedores");
        tres.setColorHover(new java.awt.Color(128, 128, 128));
        tres.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tres.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        cuatro.setBackground(new java.awt.Color(29, 30, 81));
        cuatro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productivity.png"))); // NOI18N
        cuatro.setText(" Producción");
        cuatro.setColorHover(new java.awt.Color(128, 128, 128));
        cuatro.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cuatro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });

        cinco.setBackground(new java.awt.Color(29, 30, 81));
        cinco.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etiqueta-de-precio.png"))); // NOI18N
        cinco.setText(" Ventas");
        cinco.setColorHover(new java.awt.Color(128, 128, 128));
        cinco.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cinco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });

        seis.setBackground(new java.awt.Color(29, 30, 81));
        seis.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        seis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja-registradora_1.png"))); // NOI18N
        seis.setText(" Caja");
        seis.setColorHover(new java.awt.Color(128, 128, 128));
        seis.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        seis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seisActionPerformed(evt);
            }
        });

        ocho.setBackground(new java.awt.Color(29, 30, 81));
        ocho.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        ocho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service_1.png"))); // NOI18N
        ocho.setText("Gestion de clientes");
        ocho.setToolTipText("");
        ocho.setColorHover(new java.awt.Color(128, 128, 128));
        ocho.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        ocho.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ocho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ochoActionPerformed(evt);
            }
        });

        siete1.setBackground(new java.awt.Color(29, 30, 81));
        siete1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        siete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion-de-usuarios.png"))); // NOI18N
        siete1.setText("Gestion de usuarios");
        siete1.setColorHover(new java.awt.Color(128, 128, 128));
        siete1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        siete1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        siete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siete1ActionPerformed(evt);
            }
        });

        nueve.setBackground(new java.awt.Color(29, 30, 81));
        nueve.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        nueve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service_1.png"))); // NOI18N
        nueve.setText("Catalogo");
        nueve.setToolTipText("");
        nueve.setColorHover(new java.awt.Color(128, 128, 128));
        nueve.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        nueve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueveActionPerformed(evt);
            }
        });

        uno.setBackground(new java.awt.Color(29, 30, 81));
        uno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        uno.setText("Escritorio");
        uno.setToolTipText("");
        uno.setColorHover(new java.awt.Color(128, 128, 128));
        uno.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        uno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        uno.setIconTextGap(10);
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        rSPanelImage3.setImagen(new javax.swing.ImageIcon(getClass().getResource("/logo blanco.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage3Layout = new javax.swing.GroupLayout(rSPanelImage3);
        rSPanelImage3.setLayout(rSPanelImage3Layout);
        rSPanelImage3Layout.setHorizontalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        rSPanelImage3Layout.setVerticalGroup(
            rSPanelImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 153, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(siete1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(nueve, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ocho, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(rSPanelImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(siete1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(nueve, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(seis, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cuatro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(cinco, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(ocho, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel4.setBackground(new java.awt.Color(29, 30, 81));

        uno1.setBackground(new java.awt.Color(29, 30, 81));
        uno1.setBorder(null);
        uno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        uno1.setColorHover(new java.awt.Color(200, 200, 200));
        uno1.setColorTextHover(new java.awt.Color(0, 0, 0));
        uno1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uno1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uno1MouseEntered(evt);
            }
        });
        uno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno1ActionPerformed(evt);
            }
        });

        dos1.setBackground(new java.awt.Color(29, 30, 81));
        dos1.setBorder(null);
        dos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja.png"))); // NOI18N
        dos1.setColorHover(new java.awt.Color(169, 169, 169));
        dos1.setColorTextHover(new java.awt.Color(0, 0, 0));
        dos1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dos1MouseEntered(evt);
            }
        });
        dos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos1ActionPerformed(evt);
            }
        });

        tres1.setBackground(new java.awt.Color(29, 30, 81));
        tres1.setBorder(null);
        tres1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedor-de-servicio.png"))); // NOI18N
        tres1.setColorHover(new java.awt.Color(128, 128, 128));
        tres1.setColorTextHover(new java.awt.Color(0, 0, 0));
        tres1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tres1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tres1MouseEntered(evt);
            }
        });
        tres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres1ActionPerformed(evt);
            }
        });

        cuatro1.setBackground(new java.awt.Color(29, 30, 81));
        cuatro1.setBorder(null);
        cuatro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productivity.png"))); // NOI18N
        cuatro1.setColorHover(new java.awt.Color(200, 200, 200));
        cuatro1.setColorTextHover(new java.awt.Color(0, 0, 0));
        cuatro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cuatro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cuatro1MouseEntered(evt);
            }
        });
        cuatro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatro1ActionPerformed(evt);
            }
        });

        cinco1.setBackground(new java.awt.Color(29, 30, 81));
        cinco1.setBorder(null);
        cinco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/etiqueta-de-precio.png"))); // NOI18N
        cinco1.setColorHover(new java.awt.Color(128, 128, 128));
        cinco1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cinco1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cinco1MouseEntered(evt);
            }
        });
        cinco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinco1ActionPerformed(evt);
            }
        });

        seis1.setBackground(new java.awt.Color(29, 30, 81));
        seis1.setBorder(null);
        seis1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja-registradora_1.png"))); // NOI18N
        seis1.setColorHover(new java.awt.Color(128, 128, 128));
        seis1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        seis1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seis1MouseEntered(evt);
            }
        });
        seis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seis1ActionPerformed(evt);
            }
        });

        siete2.setBackground(new java.awt.Color(29, 30, 81));
        siete2.setBorder(null);
        siete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion-de-usuarios.png"))); // NOI18N
        siete2.setColorHover(new java.awt.Color(128, 128, 128));
        siete2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        siete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                siete2MouseEntered(evt);
            }
        });
        siete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siete2ActionPerformed(evt);
            }
        });

        ocho1.setBackground(new java.awt.Color(29, 30, 81));
        ocho1.setBorder(null);
        ocho1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service_1.png"))); // NOI18N
        ocho1.setColorHover(new java.awt.Color(128, 128, 128));
        ocho1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ocho1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ocho1MouseEntered(evt);
            }
        });
        ocho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocho1ActionPerformed(evt);
            }
        });

        nueve1.setBackground(new java.awt.Color(29, 30, 81));
        nueve1.setBorder(null);
        nueve1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service_1.png"))); // NOI18N
        nueve1.setColorHover(new java.awt.Color(128, 128, 128));
        nueve1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nueve1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nueve1MouseEntered(evt);
            }
        });
        nueve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueve1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dos1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ocho1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(nueve1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(siete2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cinco1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(seis1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tres1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(cuatro1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dos1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(ocho1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(nueve1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(siete2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(cinco1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(seis1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tres1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cuatro1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 1310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contenedor.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ochoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ochoActionPerformed
        ocultarSubmenu(); // Ocultar submenú si ya está visible
        if (!this.ocho.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(true);
            this.nueve.setSelected(false);
            this.siete1.setSelected(false);

            Cliente cliente = new Cliente();
            cliente.setSize(1290, 730);
            cliente.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(cliente);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();

    }//GEN-LAST:event_ochoActionPerformed

    private void seisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seisActionPerformed
        ocultarSubmenu(); // Ocultar submenú si ya está visible
        if (!this.seis.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.ocho.setSelected(false);
            this.siete1.setSelected(false);

        }
        animacion();

    }//GEN-LAST:event_seisActionPerformed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        ocultarSubmenu();
        if (!this.cinco.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.siete1.setSelected(false);

        }
        animacion();

    }//GEN-LAST:event_cincoActionPerformed

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroActionPerformed
        ocultarSubmenu();
        if (!this.cuatro.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(true);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.nueve.setSelected(false);
            this.siete1.setSelected(false);

            Produccion pr = new Produccion(new javax.swing.JFrame(), true);
            pr.setSize(1290, 730);
            pr.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(pr);
            contenedor.revalidate();
            contenedor.repaint();

        }

        animacion();

    }//GEN-LAST:event_cuatroActionPerformed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        ocultarSubmenu();
        if (!this.tres.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(true);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.nueve.setSelected(false);
            this.siete1.setSelected(false);

            proveedores pr = new proveedores();
            pr.setSize(1290, 730);
            pr.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(pr);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();

    }//GEN-LAST:event_tresActionPerformed

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        ocultarSubmenu();
        if (!this.uno.isSelected()) {
            this.uno.setSelected(true);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.nueve.setSelected(false);
            this.siete1.setSelected(false);

            Escritorio1 es = new Escritorio1();
            es.setSize(1090, 690);
            es.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(es);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();
    }//GEN-LAST:event_unoActionPerformed

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
        if (!this.dos.isSelected()) {
            this.uno.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.dos.setSelected(true);
            this.nueve.setSelected(false);
            this.siete1.setSelected(false);

        }
        // Alternar visibilidad del submenú
        if (!submenuVisible) {
            ocultarSubmenu(); // Asegurarse de que el estado anterior esté limpio
            jPanel3.removeAll();
            jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            // Reubicar los botones con el submenú visible
            jPanel3.add(rSPanelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 41, 158, 153));
            jPanel3.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 260, 60));
            jPanel3.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 60));
            jPanel3.add(submenuInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 260, 80));
            jPanel3.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));
            jPanel3.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 260, 60));
            jPanel3.add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 260, 60));
            jPanel3.add(seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 260, 60));
            jPanel3.add(siete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 260, 60));
            jPanel3.add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 260, 60));
            jPanel3.add(nueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 260, 60));

            dos.setText(" Inventario           ▲"); // Submenú abierto

            submenuVisible = true;
            jPanel3.revalidate();
            jPanel3.repaint();
        } else {
            ocultarSubmenu(); // Ocultar submenú si ya está visible

        }

    }//GEN-LAST:event_dosActionPerformed


    private void siete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete1ActionPerformed
        // TODO add your handling code here:
        if (!this.siete1.isSelected()) {
            this.uno.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.dos.setSelected(false);
            this.siete1.setSelected(true);
            this.nueve.setSelected(false);
            // Crear y mostrar el panel de inventario
            Usuario usu = new Usuario();
            usu.setSize(1290, 730);
            usu.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(usu);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();

    }//GEN-LAST:event_siete1ActionPerformed

    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed

    }//GEN-LAST:event_uno1ActionPerformed

    private void dos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos1ActionPerformed

    }//GEN-LAST:event_dos1ActionPerformed

    private void tres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres1ActionPerformed

    }//GEN-LAST:event_tres1ActionPerformed

    private void cuatro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatro1ActionPerformed

    }//GEN-LAST:event_cuatro1ActionPerformed

    private void cinco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinco1ActionPerformed

    }//GEN-LAST:event_cinco1ActionPerformed

    private void seis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seis1ActionPerformed

    }//GEN-LAST:event_seis1ActionPerformed

    private void siete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete2ActionPerformed

    }//GEN-LAST:event_siete2ActionPerformed

    private void ocho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocho1ActionPerformed

    }//GEN-LAST:event_ocho1ActionPerformed

    private void uno1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno1MouseEntered
        animacion();
    }//GEN-LAST:event_uno1MouseEntered

    private void cuatro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatro1MouseEntered
        animacion();
    }//GEN-LAST:event_cuatro1MouseEntered

    private void dos1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dos1MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_dos1MouseEntered

    private void tres1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tres1MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_tres1MouseEntered

    private void cinco1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cinco1MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_cinco1MouseEntered

    private void seis1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seis1MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_seis1MouseEntered

    private void siete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siete2MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_siete2MouseEntered

    private void ocho1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ocho1MouseEntered
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_ocho1MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited

    }//GEN-LAST:event_jPanel5MouseExited

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        animacion();

    }//GEN-LAST:event_menuActionPerformed

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        animacion();
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JOptionPane.showMessageDialog(null, "Hasta luego");
        Login1121 lo = new Login1121();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueveActionPerformed
        if (!this.nueve.isSelected()) {
            this.uno.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.dos.setSelected(false);
            this.nueve.setSelected(true);
            this.siete1.setSelected(false);

            // Crear y mostrar el panel de inventario
            catalogo cat = new catalogo();
            cat.setSize(1290, 730);
            cat.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(cat);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();
    }//GEN-LAST:event_nueveActionPerformed

    private void nueve1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nueve1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nueve1MouseEntered

    private void nueve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueve1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nueve1ActionPerformed

    private void notiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notiActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton cinco;
    private rojeru_san.RSButton cinco1;
    private javax.swing.JPanel contenedor;
    private rojeru_san.RSButton cuatro;
    private rojeru_san.RSButton cuatro1;
    private rojeru_san.RSButton dos;
    private rojeru_san.RSButton dos1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private rojeru_san.RSButton menu;
    private rojeru_san.RSButton noti;
    private rojeru_san.RSButton nueve;
    private rojeru_san.RSButton nueve1;
    private rojeru_san.RSButton ocho;
    private rojeru_san.RSButton ocho1;
    private rojerusan.RSPanelImage rSPanelImage3;
    private rojeru_san.RSButton seis;
    private rojeru_san.RSButton seis1;
    private rojeru_san.RSButton siete1;
    private rojeru_san.RSButton siete2;
    private rojeru_san.RSButton tres;
    private rojeru_san.RSButton tres1;
    private rojeru_san.RSButton uno;
    private rojeru_san.RSButton uno1;
    // End of variables declaration//GEN-END:variables

}
