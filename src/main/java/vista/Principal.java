/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import rojeru_san.RSButton;

/**
 *
 * @author Personal
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();


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
        jPanel2 = new javax.swing.JPanel();
        menu = new rojeru_san.RSButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
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

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(29, 30, 81));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(29, 30, 81));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gears-set.png"))); // NOI18N
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        jPanel2.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 15, 50, 50));

        jButton2.setBackground(new java.awt.Color(29, 30, 81));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida (1).png"))); // NOI18N
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 20, -1, -1));

        jButton3.setBackground(new java.awt.Color(29, 30, 81));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario (2).png"))); // NOI18N
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CARPINTERIA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JOSE ABEL");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 80));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 1290, 730));
        contenedor.getAccessibleContext().setAccessibleName("");

        jPanel3.setBackground(new java.awt.Color(29, 30, 81));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dos.setBackground(new java.awt.Color(29, 30, 81));
        dos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/box.png"))); // NOI18N
        dos.setText("   Inventario");
        dos.setColorHover(new java.awt.Color(169, 169, 169));
        dos.setColorTextHover(new java.awt.Color(0, 0, 0));
        dos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });
        jPanel3.add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 260, 60));

        uno.setBackground(new java.awt.Color(29, 30, 81));
        uno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transfer.png"))); // NOI18N
        uno.setText("   Escritorio");
        uno.setColorHover(new java.awt.Color(200, 200, 200));
        uno.setColorTextHover(new java.awt.Color(0, 0, 0));
        uno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        jPanel3.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 260, 60));

        tres.setBackground(new java.awt.Color(29, 30, 81));
        tres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion-de-la-cadena-de-suministro (1).png"))); // NOI18N
        tres.setText("Proveedores");
        tres.setColorHover(new java.awt.Color(128, 128, 128));
        tres.setColorTextHover(new java.awt.Color(0, 0, 0));
        tres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });
        jPanel3.add(tres, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 260, 50));

        cuatro.setBackground(new java.awt.Color(29, 30, 81));
        cuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajuste.png"))); // NOI18N
        cuatro.setText("Producción");
        cuatro.setColorHover(new java.awt.Color(200, 200, 200));
        cuatro.setColorTextHover(new java.awt.Color(0, 0, 0));
        cuatro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatroActionPerformed(evt);
            }
        });
        jPanel3.add(cuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 260, 60));

        cinco.setBackground(new java.awt.Color(29, 30, 81));
        cinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        cinco.setText("  Ventas");
        cinco.setColorHover(new java.awt.Color(128, 128, 128));
        cinco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cincoActionPerformed(evt);
            }
        });
        jPanel3.add(cinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 260, 50));

        seis.setBackground(new java.awt.Color(29, 30, 81));
        seis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja-registradora.png"))); // NOI18N
        seis.setText("     Caja");
        seis.setColorHover(new java.awt.Color(128, 128, 128));
        seis.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        seis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seisActionPerformed(evt);
            }
        });
        jPanel3.add(seis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 260, 60));

        ocho.setBackground(new java.awt.Color(29, 30, 81));
        ocho.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ocho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service.png"))); // NOI18N
        ocho.setText("Gestion de clientes");
        ocho.setColorHover(new java.awt.Color(128, 128, 128));
        ocho.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ocho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ochoActionPerformed(evt);
            }
        });
        jPanel3.add(ocho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 260, 50));

        siete1.setBackground(new java.awt.Color(29, 30, 81));
        siete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        siete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/personal.png"))); // NOI18N
        siete1.setText("  Gestion de usuarios");
        siete1.setColorHover(new java.awt.Color(128, 128, 128));
        siete1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        siete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siete1ActionPerformed(evt);
            }
        });
        jPanel3.add(siete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 260, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        jPanel4.setBackground(new java.awt.Color(29, 30, 81));

        uno1.setBackground(new java.awt.Color(29, 30, 81));
        uno1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transfer.png"))); // NOI18N
        uno1.setColorHover(new java.awt.Color(200, 200, 200));
        uno1.setColorTextHover(new java.awt.Color(0, 0, 0));
        uno1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        uno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno1ActionPerformed(evt);
            }
        });

        dos1.setBackground(new java.awt.Color(29, 30, 81));
        dos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/box.png"))); // NOI18N
        dos1.setColorHover(new java.awt.Color(169, 169, 169));
        dos1.setColorTextHover(new java.awt.Color(0, 0, 0));
        dos1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dos1ActionPerformed(evt);
            }
        });

        tres1.setBackground(new java.awt.Color(29, 30, 81));
        tres1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tres1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion-de-la-cadena-de-suministro (1).png"))); // NOI18N
        tres1.setColorHover(new java.awt.Color(128, 128, 128));
        tres1.setColorTextHover(new java.awt.Color(0, 0, 0));
        tres1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tres1ActionPerformed(evt);
            }
        });

        cuatro1.setBackground(new java.awt.Color(29, 30, 81));
        cuatro1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cuatro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajuste.png"))); // NOI18N
        cuatro1.setColorHover(new java.awt.Color(200, 200, 200));
        cuatro1.setColorTextHover(new java.awt.Color(0, 0, 0));
        cuatro1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cuatro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuatro1ActionPerformed(evt);
            }
        });

        cinco1.setBackground(new java.awt.Color(29, 30, 81));
        cinco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cinco1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        cinco1.setColorHover(new java.awt.Color(128, 128, 128));
        cinco1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cinco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cinco1ActionPerformed(evt);
            }
        });

        seis1.setBackground(new java.awt.Color(29, 30, 81));
        seis1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seis1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/caja-registradora.png"))); // NOI18N
        seis1.setColorHover(new java.awt.Color(128, 128, 128));
        seis1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        seis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seis1ActionPerformed(evt);
            }
        });

        siete2.setBackground(new java.awt.Color(29, 30, 81));
        siete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        siete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/personal.png"))); // NOI18N
        siete2.setColorHover(new java.awt.Color(128, 128, 128));
        siete2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        siete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siete2ActionPerformed(evt);
            }
        });

        ocho1.setBackground(new java.awt.Color(29, 30, 81));
        ocho1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ocho1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public-service.png"))); // NOI18N
        ocho1.setColorHover(new java.awt.Color(128, 128, 128));
        ocho1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ocho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocho1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dos1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(tres1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(cuatro1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cinco1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(seis1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(siete2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ocho1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dos1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tres1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cuatro1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cinco1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seis1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(siete2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ocho1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 800));

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
    }//GEN-LAST:event_dosActionPerformed


    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed

        int posicion = jPanel3.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -258, 2, 2, jPanel3);

        } else {
            Animacion.Animacion.mover_derecha(-258, 0, 2, 2, jPanel3);

        }
    }//GEN-LAST:event_menuActionPerformed

    private void siete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siete1ActionPerformed

    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uno1ActionPerformed

    private void dos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dos1ActionPerformed

    private void tres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tres1ActionPerformed

    private void cuatro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuatro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuatro1ActionPerformed

    private void cinco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cinco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cinco1ActionPerformed

    private void seis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seis1ActionPerformed

    private void siete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siete2ActionPerformed

    private void ocho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ocho1ActionPerformed

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

}
