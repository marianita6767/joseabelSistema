/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        jPanel4.setVisible(false);
        jPanel5.setVisible(false); 

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
    private void animacion (){
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dos = new rojeru_san.RSButton();
        uno = new rojeru_san.RSButton();
        tres = new rojeru_san.RSButton();
        cuatro = new rojeru_san.RSButton();
        cinco = new rojeru_san.RSButton();
        seis = new rojeru_san.RSButton();
        ocho = new rojeru_san.RSButton();
        siete1 = new rojeru_san.RSButton();
        jPanel4 = new javax.swing.JPanel();
        uno1 = new rojeru_san.RSButton();
        dos1 = new rojeru_san.RSButton();
        tres1 = new rojeru_san.RSButton();
        cuatro1 = new rojeru_san.RSButton();
        cinco1 = new rojeru_san.RSButton();
        seis1 = new rojeru_san.RSButton();
        siete2 = new rojeru_san.RSButton();
        ocho1 = new rojeru_san.RSButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new rojeru_san.RSButton();
        contenedor = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1270, 810));

        jPanel3.setBackground(new java.awt.Color(29, 30, 81));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dos.setBackground(new java.awt.Color(29, 30, 81));
        dos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja.png"))); // NOI18N
        dos.setText(" Inventario");
        dos.setColorHover(new java.awt.Color(169, 169, 169));
        dos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        dos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dos.setMaximumSize(new java.awt.Dimension(127, 24));
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });
        jPanel3.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 250, 50));

        uno.setBackground(new java.awt.Color(29, 30, 81));
        uno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        uno.setText("Escritorio");
        uno.setToolTipText("");
        uno.setColorHover(new java.awt.Color(200, 200, 200));
        uno.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        uno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        uno.setIconTextGap(10);
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        jPanel3.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 250, 50));

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
        jPanel3.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 50));

        cuatro.setBackground(new java.awt.Color(29, 30, 81));
        cuatro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/productivity.png"))); // NOI18N
        cuatro.setText(" Producción");
        cuatro.setColorHover(new java.awt.Color(200, 200, 200));
        cuatro.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cuatro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });
        jPanel3.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, 50));

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
        jPanel3.add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 250, 50));

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
        jPanel3.add(seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 250, 50));

        ocho.setBackground(new java.awt.Color(29, 30, 81));
        ocho.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        ocho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service_1.png"))); // NOI18N
        ocho.setText("Gestion de clientes");
        ocho.setColorHover(new java.awt.Color(128, 128, 128));
        ocho.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        ocho.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ocho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ochoActionPerformed(evt);
            }
        });
        jPanel3.add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 250, 50));

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
        jPanel3.add(siete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 250, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 810));

        jPanel4.setBackground(new java.awt.Color(29, 30, 81));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(uno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 80, 50));

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
        jPanel4.add(dos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 80, 50));

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
        jPanel4.add(tres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 80, 50));

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
        jPanel4.add(cuatro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 80, 50));

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
        jPanel4.add(cinco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 80, 50));

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
        jPanel4.add(seis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 80, 50));

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
        jPanel4.add(siete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 80, 50));

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
        jPanel4.add(ocho1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 80, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 800));

        jPanel2.setBackground(new java.awt.Color(29, 30, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(29, 30, 81));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida (1).png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1454, 20, 60, 50));

        jButton3.setBackground(new java.awt.Color(29, 30, 81));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario (2).png"))); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1384, 20, 60, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CARPINTERIA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JOSE ABEL");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        menu.setBackground(new java.awt.Color(29, 30, 81));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/burger-bar.png"))); // NOI18N
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        jPanel2.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 50, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 80));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1300, 730));
        contenedor.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1556, 822));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ochoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ochoActionPerformed
        if (!this.ocho.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(true);

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
        if (!this.seis.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.ocho.setSelected(false);

            caja box = new caja();
            box.setSize(1290, 730);
            box.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(box);
            contenedor.revalidate();
            contenedor.repaint();
        }
        animacion();

    }//GEN-LAST:event_seisActionPerformed

    private void cincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cincoActionPerformed
        if (!this.cinco.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);

        }
        animacion();
    }//GEN-LAST:event_cincoActionPerformed

    private void cuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatroActionPerformed
        if (!this.cuatro.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.cuatro.setSelected(true);
            Produccion pr = new Produccion();
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
        if (!this.tres.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(true);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
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
        if (!this.uno.isSelected()) {
            this.uno.setSelected(true);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            Escritorio1 es = new Escritorio1();
            es.setSize(890, 690);
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

            // Crear y mostrar el panel de inventario
            Inventario in = new Inventario();
            in.setSize(1290, 730);
            in.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(in);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();
    }//GEN-LAST:event_dosActionPerformed


    private void siete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siete1ActionPerformed

    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed
        if (!this.uno.isSelected()) {
            this.uno.setSelected(true);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            Escritorio1 es = new Escritorio1();
            es.setSize(890, 690);
            es.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(es);
            contenedor.revalidate();
            contenedor.repaint();
        }
        animacion();

    }//GEN-LAST:event_uno1ActionPerformed

    private void dos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos1ActionPerformed
        if (!this.dos.isSelected()) {
            this.uno.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.dos.setSelected(true);

            // Crear y mostrar el panel de inventario
            Inventario in = new Inventario();
            in.setSize(1290, 730);
            in.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(in);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();
    }//GEN-LAST:event_dos1ActionPerformed

    private void tres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres1ActionPerformed
        if (!this.tres.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(true);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            proveedores pr = new proveedores();
            pr.setSize(1290, 730);
            pr.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(pr);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();
        // TODO add your handling code here:
    }//GEN-LAST:event_tres1ActionPerformed

    private void cuatro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatro1ActionPerformed
        if (!this.cuatro.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);
            this.cuatro.setSelected(true);
            Produccion pr = new Produccion();
            pr.setSize(1290, 730);
            pr.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(pr);
            contenedor.revalidate();
            contenedor.repaint();

        }
        animacion();// TODO add your handling code here:
    }//GEN-LAST:event_cuatro1ActionPerformed

    private void cinco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinco1ActionPerformed
        if (!this.cinco.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(false);

        }
        animacion();
    }//GEN-LAST:event_cinco1ActionPerformed

    private void seis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seis1ActionPerformed
        if (!this.seis.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.ocho.setSelected(false);

            caja box = new caja();
            box.setSize(1290, 730);
            box.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(box);
            contenedor.revalidate();
            contenedor.repaint();
        }
        animacion();
    }//GEN-LAST:event_seis1ActionPerformed

    private void siete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete2ActionPerformed
        animacion();        // TODO add your handling code here:
    }//GEN-LAST:event_siete2ActionPerformed

    private void ocho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocho1ActionPerformed
        if (!this.ocho.isSelected()) {
            this.uno.setSelected(false);
            this.dos.setSelected(false);
            this.tres.setSelected(false);
            this.cuatro.setSelected(false);
            this.cinco.setSelected(false);
            this.seis.setSelected(false);
            this.ocho.setSelected(true);

            Cliente cliente = new Cliente();
            cliente.setSize(1290, 730);
            cliente.setLocation(0, 0);

            contenedor.removeAll();
            contenedor.add(cliente);
            contenedor.revalidate();
            contenedor.repaint();
        }
        animacion();

    }//GEN-LAST:event_ocho1ActionPerformed

    private void uno1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno1MouseEntered
        animacion();
    }//GEN-LAST:event_uno1MouseEntered

    private void cuatro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cuatro1MouseEntered
        animacion();
    }//GEN-LAST:event_cuatro1MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JOptionPane.showMessageDialog(null, "Hasta luego");
        Login1121 lo = new Login1121();
        lo.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_jButton2ActionPerformed

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
       animacion(); // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseEntered

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
    private javax.swing.JButton jButton1;
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
    private rojeru_san.RSButton ocho;
    private rojeru_san.RSButton ocho1;
    private rojeru_san.RSButton seis;
    private rojeru_san.RSButton seis1;
    private rojeru_san.RSButton siete1;
    private rojeru_san.RSButton siete2;
    private rojeru_san.RSButton tres;
    private rojeru_san.RSButton tres1;
    private rojeru_san.RSButton uno;
    private rojeru_san.RSButton uno1;
    // End of variables declaration//GEN-END:variables

    
 public void animacion23(){
     int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -258, 2, 2, jPanel3);
            jPanel4.setVisible(true); // Ocultar la tabla 1 inicialmente

        } else {
            Animacion.Animacion.mover_derecha(-258, 0, 2, 2, jPanel3);
            jPanel4.setVisible(false); // Ocultar la tabla 1 inicialmente

        }      
     
 }   
    
    
}
