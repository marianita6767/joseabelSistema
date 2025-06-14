/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Cotizacion;

import controlador.GeneradorCotizacionPDF;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import RSMaterialComponent.RSTextFieldMaterial;
import controlador.Ctrl_Pedido;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.GeneradorCotizacionPDF;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.awt.Desktop;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.Conexion;
import modelo.Cotizacion;
import controlador.CotizacionDAO;
import vista.Caja.Caja;
import vista.Caja.formuEgresos1;
import vista.Crearcliente1;
import vista.Usuario;

/**
 *
 * @author ADSO
 */
//guarda?
public class cotizacion extends javax.swing.JPanel {

    private JPanel contenedor;
    private int idPedido;
    private String clienteActual = "";
    private boolean clienteIngresado = false;
    private Ctrl_Pedido controlador;
    private Integer clienteCodigo; // To store the selected client's code

    public cotizacion(JPanel contenedor) {
        
        this.contenedor = contenedor;
        this.controlador = new Ctrl_Pedido();
        initComponents();
        configurarTabla();
        CargarUnidadMed();
        txt_total.setEditable(false);
        txt_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_total.setText("$0.00");
    }

  

    private void configurarTabla() {
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Producto", "Unidad", "Cantidad", "Valor Unitario", "Subtotal", "Editar", "Eliminar"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5 || column == 6;
            }
        };
        Tabla1.setModel(modelo);
        Tabla1.getColumnModel().getColumn(0).setPreferredWidth(200);
        Tabla1.getColumnModel().getColumn(1).setPreferredWidth(80);
        Tabla1.getColumnModel().getColumn(2).setPreferredWidth(70);
        Tabla1.getColumnModel().getColumn(3).setPreferredWidth(100);
        Tabla1.getColumnModel().getColumn(4).setPreferredWidth(100);
        Tabla1.getColumnModel().getColumn(5).setPreferredWidth(60);
        Tabla1.getColumnModel().getColumn(6).setPreferredWidth(60);
    }

    private void guardarCotizacion() {
        if (Tabla1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay productos en la cotización", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombrePedido = txtNombre6.getText().trim();
        if (nombrePedido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del pedido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (clienteCodigo == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione o cree un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setDetalle(nombrePedido);
        cotizacion.setTotal(Double.parseDouble(txt_total.getText().replace("$", "").replace(",", "")));
        /*  cotizacion.setFechaInicio(new Date());
        cotizacion.setFechaFin(new Date());
         */
        int idCotizacion = CotizacionDAO.guardarCotizacion(cotizacion, modelo);
        JOptionPane.showMessageDialog(this, "Cotización guardada exitosamente con ID: " + idCotizacion, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        reiniciarCotizacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla1 = new RSMaterialComponent.RSTableMetroCustom();
        txtNombre6 = new RSMaterialComponent.RSTextFieldMaterial();
        combox_Unidad = new RSMaterialComponent.RSComboBoxMaterial();
        txtNombre4 = new RSMaterialComponent.RSTextFieldMaterial();
        txtNombre5 = new RSMaterialComponent.RSTextFieldMaterial();
        jButton_anadir_producto = new RSMaterialComponent.RSButtonShape();
        txt_total = new RSMaterialComponent.RSTextFieldMaterial();
        btnAñadir = new RSMaterialComponent.RSButtonShape();
        txt_NombreCliente = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        HistorialCoti = new RSMaterialComponent.RSButtonShape();
        jLabel9 = new javax.swing.JLabel();
        txt_ApellidoCliente = new RSMaterialComponent.RSTextFieldMaterial();
        identificaciontxt = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        numerotxt = new RSMaterialComponent.RSTextFieldMaterial();
        telefonotxt = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        direcciontxt = new RSMaterialComponent.RSTextFieldMaterial();
        identificaciontxt1 = new RSMaterialComponent.RSComboBoxMaterial();

        jToggleButton1.setText("jToggleButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Cotizacion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombres cliente:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 120, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Unidad", "Cantidad", "Valor Unitario", "Subtotal", "Editar", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla1.setBackgoundHead(new java.awt.Color(46, 49, 82));
        Tabla1.setBackgoundHover(new java.awt.Color(109, 160, 221));
        Tabla1.setBorderHead(null);
        Tabla1.setBorderRows(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        Tabla1.setColorBorderHead(new java.awt.Color(46, 49, 82));
        Tabla1.setColorBorderRows(new java.awt.Color(46, 49, 82));
        Tabla1.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        Tabla1.setColorSecondary(new java.awt.Color(255, 255, 255));
        Tabla1.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        Tabla1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabla1.setFontHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tabla1.setFontRowHover(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabla1.setFontRowSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tabla1.setRowHeight(23);
        Tabla1.setSelectionBackground(new java.awt.Color(109, 160, 221));
        Tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla1);
        Tabla1.getColumnModel().getColumn(0).setPreferredWidth(10);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1150, 370));

        txtNombre6.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre6.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtNombre6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre6.setPhColor(new java.awt.Color(0, 0, 0));
        txtNombre6.setPlaceholder("Ingrese nombre pedido...");
        txtNombre6.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtNombre6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre6ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 0, 30));

        combox_Unidad.setColorMaterial(new java.awt.Color(0, 0, 0));
        combox_Unidad.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        combox_Unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_UnidadActionPerformed(evt);
            }
        });
        jPanel1.add(combox_Unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 0, 30));

        txtNombre4.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre4.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtNombre4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre4.setPhColor(new java.awt.Color(0, 0, 0));
        txtNombre4.setPlaceholder("Ingrese cantidad..");
        txtNombre4.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtNombre4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre4ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 0, 30));

        txtNombre5.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre5.setColorMaterial(new java.awt.Color(0, 0, 0));
        txtNombre5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre5.setPhColor(new java.awt.Color(0, 0, 0));
        txtNombre5.setPlaceholder("Ingrese Valor Unitario..");
        txtNombre5.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtNombre5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombre5ActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 0, 30));

        jButton_anadir_producto.setBackground(new java.awt.Color(46, 49, 82));
        jButton_anadir_producto.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton_anadir_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        jButton_anadir_producto.setText("Añadir Producto");
        jButton_anadir_producto.setBackgroundHover(new java.awt.Color(0, 153, 0));
        jButton_anadir_producto.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        jButton_anadir_producto.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        jButton_anadir_producto.setHideActionText(true);
        jButton_anadir_producto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButton_anadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadir_productoActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_anadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 170, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 1220, 350));

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(255, 255, 255));
        txt_total.setForeground(new java.awt.Color(0, 0, 0));
        txt_total.setColorMaterial(new java.awt.Color(0, 0, 0));
        txt_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_total.setPhColor(new java.awt.Color(0, 0, 0));
        txt_total.setPlaceholder("Total...");
        txt_total.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        jPanel2.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 200, 30));

        btnAñadir.setBackground(new java.awt.Color(46, 49, 82));
        btnAñadir.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-pdf-solid-60 (2).png"))); // NOI18N
        btnAñadir.setText("Crear PDF");
        btnAñadir.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnAñadir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAñadir.setForegroundHover(new java.awt.Color(0, 0, 0));
        btnAñadir.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel2.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 550, 170, 70));

        txt_NombreCliente.setForeground(new java.awt.Color(0, 0, 0));
        txt_NombreCliente.setColorMaterial(new java.awt.Color(0, 0, 0));
        txt_NombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_NombreCliente.setPhColor(new java.awt.Color(0, 0, 0));
        txt_NombreCliente.setPlaceholder("Ingrese Nombre...");
        txt_NombreCliente.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_NombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreClienteActionPerformed(evt);
            }
        });
        jPanel2.add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 180, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Total:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 70, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Materia Prima:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, -1, -1));

        HistorialCoti.setBackground(new java.awt.Color(46, 49, 82));
        HistorialCoti.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        HistorialCoti.setText("  Historial de Cotizaciones");
        HistorialCoti.setBackgroundHover(new java.awt.Color(0, 153, 0));
        HistorialCoti.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        HistorialCoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialCotiActionPerformed(evt);
            }
        });
        jPanel2.add(HistorialCoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 550, 200, 70));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Apellidos cliente:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        txt_ApellidoCliente.setForeground(new java.awt.Color(0, 0, 0));
        txt_ApellidoCliente.setColorMaterial(new java.awt.Color(0, 0, 0));
        txt_ApellidoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ApellidoCliente.setPhColor(new java.awt.Color(0, 0, 0));
        txt_ApellidoCliente.setPlaceholder("Ingrese Apellidos...");
        txt_ApellidoCliente.setSelectionColor(new java.awt.Color(0, 0, 0));
        txt_ApellidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ApellidoClienteActionPerformed(evt);
            }
        });
        jPanel2.add(txt_ApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 180, 30));

        identificaciontxt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de identificacion:", "CC", "CE", "TI", "RC", "NIT", "PA", "PEP", "PPT", "DNI" }));
        identificaciontxt.setColorMaterial(new java.awt.Color(29, 30, 51));
        identificaciontxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(identificaciontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 200, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tipo de identificación:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 50, 180, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Numero de identificación:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, -1));

        numerotxt.setForeground(new java.awt.Color(0, 0, 0));
        numerotxt.setColorMaterial(new java.awt.Color(0, 0, 0));
        numerotxt.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        numerotxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        numerotxt.setPhColor(new java.awt.Color(29, 30, 51));
        numerotxt.setPlaceholder("Ingrese n° identificacion");
        jPanel2.add(numerotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 200, 30));

        telefonotxt.setForeground(new java.awt.Color(29, 30, 31));
        telefonotxt.setColorMaterial(new java.awt.Color(29, 30, 31));
        telefonotxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        telefonotxt.setPhColor(new java.awt.Color(29, 30, 51));
        telefonotxt.setPlaceholder("Ingrese telefono");
        jPanel2.add(telefonotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 180, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Telefono:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Dirección:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        direcciontxt.setForeground(new java.awt.Color(29, 30, 31));
        direcciontxt.setColorMaterial(new java.awt.Color(29, 30, 31));
        direcciontxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        direcciontxt.setPhColor(new java.awt.Color(29, 30, 51));
        direcciontxt.setPlaceholder("Ingrese direccion");
        direcciontxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direcciontxtActionPerformed(evt);
            }
        });
        jPanel2.add(direcciontxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 200, 30));

        identificaciontxt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de identificacion:", "CC", "CE", "TI", "RC", "NIT", "PA", "PEP", "PPT", "DNI" }));
        identificaciontxt1.setColorMaterial(new java.awt.Color(29, 30, 51));
        identificaciontxt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(identificaciontxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 200, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 680));
    }// </editor-fold>//GEN-END:initComponents

    private void combox_UnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_UnidadActionPerformed

    }//GEN-LAST:event_combox_UnidadActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed

    }//GEN-LAST:event_txt_totalActionPerformed

    private void txtNombre4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre4ActionPerformed

    private void txtNombre5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre5ActionPerformed

    }//GEN-LAST:event_txtNombre5ActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        System.out.println("Botón Generar PDF presionado");

        if (Tabla1.getRowCount() == 0) {
            System.out.println("Tabla vacía, mostrando advertencia");
            JOptionPane.showMessageDialog(this,
                    "No hay productos en la cotización",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cliente = txt_NombreCliente.getText().trim();
        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//nombre del PDF
        System.out.println("Creando instancia de GeneradorCotizacionPDF");
        GeneradorCotizacionPDF generador = new GeneradorCotizacionPDF();
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        String total = txt_total.getText().trim();
        String archivoSalida = "cotizacion_" + cliente.replaceAll("[^a-zA-Z0-9_-]", "_") + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".pdf";

        System.out.println("Cliente: " + cliente);
        System.out.println("Total: " + total);
        System.out.println("Archivo de salida: " + archivoSalida);
        System.out.println("Llamando a generarPDF...");

        try {
            generador.generarPDF(cliente, modelo, total, archivoSalida);
            System.out.println("PDF generado correctamente, intentando abrir en el navegador");

            // Abrir el archivo en el navegador predeterminado
            File pdfFile = new File(archivoSalida);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("Archivo PDF abierto en el navegador predeterminado");
                } else {
                    System.out.println("Desktop no soportado en este sistema");
                    JOptionPane.showMessageDialog(this, "No se puede abrir el PDF automáticamente. El archivo se encuentra en: " + archivoSalida, "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                System.out.println("El archivo PDF no se encontró en: " + archivoSalida);
                JOptionPane.showMessageDialog(this, "El archivo PDF no se encontró en: " + archivoSalida, "Error", JOptionPane.ERROR_MESSAGE);
            }

            System.out.println("Reiniciando cotización");
            reiniciarCotizacion();
        } catch (Exception e) {
            System.out.println("Error al generar o abrir PDF: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar o abrir PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnAñadirActionPerformed

    private void txtNombre6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombre6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre6ActionPerformed

    private void txt_NombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreClienteActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked
        if (evt.getClickCount() == 1) {
            int columna = Tabla1.columnAtPoint(evt.getPoint());
            int fila = Tabla1.rowAtPoint(evt.getPoint());

            if (fila >= 0) {
                if (columna == 6) { // Columna Eliminar (ahora índice 6)
                    eliminarFila(fila);
                } else if (columna == 5) { // Columna Editar (ahora índice 5)
                    editarFila(fila);
                }
            }
        }
    }

     private void HistorialCotActionPerformed(java.awt.event.ActionEvent evt) {
            try {
                HistorialCot h = new HistorialCot(contenedor);
                h.setSize(1290, h.setHeight(730));
                h.setLocation(0, 0);
                contenedor.removeAll();
                contenedor.add(h);
                contenedor.revalidate();
                contenedor.repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al mostrar el historial de cotizaciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    
     private void jButton_anadirProductoActionPerformed(java.awt.event.ActionEvent evt) {
        Integer filaEditando = (Integer) Tabla1.getClientProperty("filaEditando");
        if (filaEditando != null) {
            guardarEdicionamiento(filaEditando);
        } else {
            añadirProducto();
        }
    }

    private void btnGuardarCotActionPerformed(java.awt.event.ActionEvent evt) {
        guardarCotizacion();
    }

    private void añadirProducto() {
        if (!clienteIngresado) {
            clienteActual = txt_NombreCliente.getText().trim();
            if (clienteActual.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese el nombre completo del cliente primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            clienteIngresado = true;
            txt_NombreCliente.setEnabled(false);
        }
        String producto = txtNombre6.getText().trim();
        String unidad = combox_Unidad.getSelectedItem().toString();
        String cantidadTexto = txtNombre4.getText().trim();
        String valorUnitarioTexto = txtNombre5.getText().trim();

        if (producto.isEmpty() || unidad.equals("Seleccione unidad") || cantidadTexto.isEmpty() || valorUnitarioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos del producto", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            double valorUnitario = Double.parseDouble(valorUnitarioTexto);
            double subtotal = cantidad * valorUnitario;

            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
            modelo.addRow(new Object[] {
                producto,
                unidad,
                cantidad,
                String.format("$%.2f", valorUnitario),
                String.format("$%.2f", subtotal),
                "Editar",
                "Eliminar"
            });
            limpiarCampos();
            calcularTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos para la cantidad y el valor unitario", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void guardarEdicionamiento(int fila) {
        String producto = txtNombre6.getText().trim();
        String unidad = combox_Unidad.getSelectedItem().toString();
        String cantidadTexto = txtNombre4.getText().trim();
        String valorUnitarioTexto = txtNombre5.getText().trim();

        if (producto.isEmpty() || unidad.equals("Seleccione unidad") || cantidadTexto.isEmpty() || valorUnitarioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos del producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            double valorUnitario = Double.parseDouble(valorUnitarioTexto);
            double subtotal = cantidad * valorUnitario;

            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
            modelo.setValueAt(producto, fila, 0);
            modelo.setValueAt(unidad, fila, 1);
            modelo.setValueAt(cantidad, fila, 2);
            modelo.setValueAt(String.format("$%.2f", valorUnitario), fila, 3);
            modelo.setValueAt(String.format("$%.2f", subtotal), fila, 4);

            limpiarCampos();
            Tabla1.putClientProperty("filaEditando", null);
            jButton_anadir_producto.setText("  Añadir");
            calcularTotal();
            JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos para la cantidad y el valor unitario", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtNombre6.setText("");
        combox_Unidad.setSelectedIndex(0);
        txtNombre4.setText("");
        txtNombre5.setText("");
        txtNombre6.requestFocus();
    }

    
    private void eliminarFila(int fila) {
        // Obtener datos del producto a eliminar para mostrar en el mensaje
        String producto = Tabla1.getValueAt(fila, 0).toString(); // Producto ahora en índice 0
        String cantidad = Tabla1.getValueAt(fila, 2).toString(); // Cantidad ahora en índice 2

        // Resto del método permanece igual...
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "<html>¿Está seguro que desea eliminar el producto:<br><br>"
                + "<b>Producto:</b> " + producto + "<br>"
                + "<b>Cantidad:</b> " + cantidad + "<br><br>"
                + "Esta acción no se puede deshacer.</html>",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
            modelo.removeRow(fila);
            calcularTotal();

            JOptionPane.showMessageDialog(
                    this,
                    "Producto eliminado correctamente",
                    "Eliminación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void editarFila(int fila) {
        // Obtener los valores de la fila seleccionada con los nuevos índices
        String producto = Tabla1.getValueAt(fila, 0).toString(); // Índice 0 para Producto
        String unidad = Tabla1.getValueAt(fila, 1).toString();   // Índice 1 para Unidad
        String cantidad = Tabla1.getValueAt(fila, 2).toString(); // Índice 2 para Cantidad
        String valorUnitario = Tabla1.getValueAt(fila, 3).toString().replace("$", "").replace(",", ""); // Índice 3 para Valor Unitario

        // Resto del método permanece igual...
        txtNombre6.setText(producto);

        for (int i = 0; i < combox_Unidad.getItemCount(); i++) {
            if (combox_Unidad.getItemAt(i).equals(unidad)) {
                combox_Unidad.setSelectedIndex(i);
                break;
            }
        }

        txtNombre4.setText(cantidad);
        txtNombre5.setText(valorUnitario);

        Tabla1.putClientProperty("filaEditando", fila);
        jButton_anadir_producto.setText("  Guardar");
    }//GEN-LAST:event_Tabla1MouseClicked

    private void HistorialCotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialCotiActionPerformed
        HistorialCot h = new HistorialCot(contenedor);
        h.setSize(1290, 730);
        h.setLocation(0, 0);
        contenedor.removeAll();
        contenedor.add(h);
        contenedor.revalidate();
        contenedor.repaint();
    }//GEN-LAST:event_HistorialCotiActionPerformed

    private void jButton_anadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadir_productoActionPerformed
         InsertarCoti h = new InsertarCoti(new javax.swing.JFrame(), true);
        h.setLocationRelativeTo(null);
        h.setVisible(true);
        
    }


    private void añadirNuevoProducto() {
        // Validación del cliente permanece igual...
        if (!clienteIngresado) {
            clienteActual = txt_NombreCliente.getText().trim();
            if (clienteActual.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Por favor ingrese el nombre del cliente primero",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            clienteIngresado = true;
            txt_NombreCliente.setEnabled(false);
        }

        // Obtener datos queda igual
        String producto = txtNombre6.getText().trim();
        String unidad = combox_Unidad.getSelectedItem().toString();
        String cantidadStr = txtNombre4.getText().trim();
        String valorUnitarioStr = txtNombre5.getText().trim();

        if (producto.isEmpty() || unidad.equals("Seleccione unidad")
                || cantidadStr.isEmpty() || valorUnitarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos del producto",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            int valorUnitario = Integer.parseInt(valorUnitarioStr);
            int subtotal = cantidad * valorUnitario;

            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();

            // Añadir fila con los nuevos índices (sin cliente)
            modelo.addRow(new Object[]{
                producto, // Índice 0
                unidad, // Índice 1
                cantidad, // Índice 2
                String.format("$%d", valorUnitario), // Índice 3
                String.format("$%d", subtotal), // Índice 4
                "Editar", // Índice 5
                "Eliminar" // Índice 6
            });

            limpiarCamposProducto();
            calcularTotal();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese valores numéricos válidos en cantidad y valor unitario",
                    "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void guardarEdicion(int fila) {
        // Obtener datos de los campos de edición
        String producto = txtNombre6.getText().trim();
        String unidad = combox_Unidad.getSelectedItem().toString();
        String cantidadStr = txtNombre4.getText().trim();
        String valorUnitarioStr = txtNombre5.getText().trim();

        // Validación permanece igual...
        if (producto.isEmpty() || unidad.equals("Seleccione unidad")
                || cantidadStr.isEmpty() || valorUnitarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos del producto",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadStr);
            int valorUnitario = Integer.parseInt(valorUnitarioStr);
            int subtotal = cantidad * valorUnitario;

            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();

            // Actualizar con los nuevos índices
            modelo.setValueAt(producto, fila, 0);  // Producto
            modelo.setValueAt(unidad, fila, 1);    // Unidad
            modelo.setValueAt(cantidad, fila, 2);  // Cantidad
            modelo.setValueAt(String.format("$%d", valorUnitario), fila, 3); // Valor Unitario
            modelo.setValueAt(String.format("$%d", subtotal), fila, 4);      // Subtotal

            // Resto del método permanece igual...
            limpiarCamposProducto();
            Tabla1.putClientProperty("filaEditando", null);
            jButton_anadir_producto.setText("  Añadir");
            calcularTotal();

            JOptionPane.showMessageDialog(this,
                    "Producto actualizado correctamente",
                    "Edición exitosa",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese valores numéricos válidos en cantidad y valor unitario",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCamposProducto() {
        txtNombre6.setText("");
        combox_Unidad.setSelectedIndex(0);
        txtNombre4.setText("");
        txtNombre5.setText("");
        txtNombre6.requestFocus();

    }//GEN-LAST:event_jButton_anadir_productoActionPerformed

    private void txt_ApellidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ApellidoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ApellidoClienteActionPerformed

    private void direcciontxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direcciontxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_direcciontxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonShape HistorialCoti;
    private RSMaterialComponent.RSTableMetroCustom Tabla1;
    private RSMaterialComponent.RSButtonShape btnAñadir;
    private RSMaterialComponent.RSComboBoxMaterial combox_Unidad;
    private RSMaterialComponent.RSTextFieldMaterial direcciontxt;
    private RSMaterialComponent.RSComboBoxMaterial identificaciontxt;
    private RSMaterialComponent.RSComboBoxMaterial identificaciontxt1;
    private RSMaterialComponent.RSButtonShape jButton_anadir_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private RSMaterialComponent.RSTextFieldMaterial numerotxt;
    private RSMaterialComponent.RSTextFieldMaterial telefonotxt;
    private RSMaterialComponent.RSTextFieldMaterial txtNombre4;
    private RSMaterialComponent.RSTextFieldMaterial txtNombre5;
    private RSMaterialComponent.RSTextFieldMaterial txtNombre6;
    private RSMaterialComponent.RSTextFieldMaterial txt_ApellidoCliente;
    private RSMaterialComponent.RSTextFieldMaterial txt_NombreCliente;
    private RSMaterialComponent.RSTextFieldMaterial txt_total;
    // End of variables declaration//GEN-END:variables
/*
//metodo cargar clientes en el combox
    private void CargarComboClientes() {
        Connection cn = Conexion.getConnection();
        String sql = "SELECT nombre, apellido FROM cliente"; // Ajusta según tu estructura de tabla
        //combox_cliente.removeAllItems(); // Limpiar el ComboBox

        // Añadir el ítem por defecto
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                // Añadir cada cliente al ComboBox
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                combox_cliente.addItem(nombreCompleto);
                // Opcional: guardar el ID como propiedad del ítem
                //combox_cliente.setSelectedItem(rs.getString("nombre "+"apellido"));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de clientes", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     */
    private void CargarUnidadMed() {
        combox_Unidad.removeAllItems();
        combox_Unidad.addItem("Seleccione unidad");

        // Valores del ENUM definidos en la base de datos
        String[] unidades = {"Metro", "Centímetro", "Unidad"};

        for (String unidad : unidades) {
            combox_Unidad.addItem(unidad);
        }

    }

    /*joa nambre*/
    public void calcularTotal() {
    DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
    double total = 0;

    for (int i = 0; i < modelo.getRowCount(); i++) {
        try {
            String subtotalStr = modelo.getValueAt(i, 4).toString();
            subtotalStr = subtotalStr.replace("$", "").replace(",", "");
            double subtotal = Double.parseDouble(subtotalStr);
            total += subtotal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al calcular el subtotal en la fila " + (i + 1) + "\n"
                    + "Valor problemático: " + modelo.getValueAt(i, 4),
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    txt_total.setText(String.format("$%,.2f", total));
}

    
    
    public void reiniciarCotizacion() {
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        modelo.setRowCount(0);

        clienteActual = "";
        clienteIngresado = false;
        txt_NombreCliente.setEnabled(true);
        txt_NombreCliente.setText("");

        // Limpiar campos de producto y resetear modo edición
        limpiarCamposProducto();
        Tabla1.putClientProperty("filaEditando", null);
        jButton_anadir_producto.setText("  Añadir");

        // Resetear el total a cero
        txt_total.setText("$0.00");

        txt_NombreCliente.requestFocus();
    }

}
