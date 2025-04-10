/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author buitr
 */
public class proveedores extends javax.swing.JPanel {
private DefaultTableModel modeloTabla;
    /**
     * Creates new form proveedores
     */
    public proveedores() {
        initComponents();
        
      TablaP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TablaP.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Codigo", "Nombre", "Telefono", "Direccion", "Tipo", "Producto"}
        ));

        TablaP.setCellSelectionEnabled(false);
        TablaP.setRowSelectionAllowed(true);
        TablaP.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Color colorSeleccion = new Color(109, 160, 221);
        Color colorTexto = Color.white;

        TablaP.setSelectionBackground(colorSeleccion);
        TablaP.setSelectionForeground(colorTexto);

        txtbuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
        
        cargarTablaProveedor();// Carga Tabla1
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        editarBtn = new RSMaterialComponent.RSButtonMaterialTwo();
        Añadir1 = new RSMaterialComponent.RSButtonMaterialTwo();
        eliminarBtn = new RSMaterialComponent.RSButtonMaterialTwo();
        txtbuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaP = new RSMaterialComponent.RSTableMetro();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1290, 730));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editarBtn.setBackground(new java.awt.Color(29, 30, 51));
        editarBtn.setText("Editar");
        editarBtn.setBackgroundHover(new java.awt.Color(29, 30, 31));
        editarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editarBtnMouseClicked(evt);
            }
        });
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });
        jPanel4.add(editarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 86, 37));

        Añadir1.setBackground(new java.awt.Color(29, 30, 51));
        Añadir1.setText("Añadir+");
        Añadir1.setBackgroundHover(new java.awt.Color(29, 30, 31));
        Añadir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Añadir1ActionPerformed(evt);
            }
        });
        jPanel4.add(Añadir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 40, 86, 37));

        eliminarBtn.setBackground(new java.awt.Color(29, 30, 51));
        eliminarBtn.setText("Eliminar -");
        eliminarBtn.setBackgroundHover(new java.awt.Color(29, 30, 31));
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });
        jPanel4.add(eliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 86, 37));

        txtbuscar.setForeground(new java.awt.Color(29, 30, 91));
        txtbuscar.setColorIcon(new java.awt.Color(29, 30, 111));
        txtbuscar.setColorMaterial(new java.awt.Color(29, 30, 111));
        txtbuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtbuscar.setPlaceholder("Buscar");
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        jPanel4.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 28));

        TablaP.setForeground(new java.awt.Color(255, 255, 255));
        TablaP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaP.setAlignmentX(0.1F);
        TablaP.setAlignmentY(0.1F);
        TablaP.setBackgoundHead(new java.awt.Color(46, 49, 82));
        TablaP.setBackgoundHover(new java.awt.Color(46, 49, 82));
        TablaP.setColorBorderRows(new java.awt.Color(153, 153, 153));
        TablaP.setColorPrimaryText(new java.awt.Color(46, 49, 82));
        TablaP.setColorSecondary(new java.awt.Color(255, 255, 255));
        TablaP.setColorSecundaryText(new java.awt.Color(46, 49, 82));
        jScrollPane2.setViewportView(TablaP);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1190, 490));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1293, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1293, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1293, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed

 proveedorEditar dialog = new proveedorEditar(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaProveedor();
         
    }//GEN-LAST:event_editarBtnActionPerformed

    private void Añadir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Añadir1ActionPerformed
        // TODO add your handling code here:
        proveedornuevo dialog = new proveedornuevo(new javax.swing.JFrame(), true);
       dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaProveedor();

    }//GEN-LAST:event_Añadir1ActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
         int[] selectedRows = TablaP.getSelectedRows(); // Obtener todas las filas seleccionadas

        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor seleccione al menos una fila para eliminar",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Confirmar eliminación
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar los " + selectedRows.length + " registros seleccionados?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // Si el usuario cancela, no hacer nada
        }

        try (Connection con = new proveedores.Conexion().getConnection()) {
            // Desactivar auto-commit para manejar transacciones
            con.setAutoCommit(false);

            String sql = "DELETE FROM proveedor WHERE codigo_proveedor = ?";
            boolean error = false;

            // Eliminar en orden inverso para evitar problemas con los índices de la tabla
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int selectedRow = selectedRows[i];
                int codigo_proveedor = (int) TablaP.getValueAt(selectedRow, 0);

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, codigo_proveedor);
                    ps.executeUpdate();

                    // Eliminar la fila de la tabla visual
                    DefaultTableModel model = (DefaultTableModel) TablaP.getModel();
                    model.removeRow(selectedRow);
                } catch (SQLException e) {
                    error = true;
                    JOptionPane.showMessageDialog(
                            this,
                            "Error al eliminar el registro con ID " + codigo_proveedor + ": " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    break; // Detener si hay un error
                }
            }

            if (error) {
                con.rollback(); // Si hay error, deshacer cambios
            } else {
                con.commit(); // Si todo va bien, confirmar cambios
                JOptionPane.showMessageDialog(
                        this,
                        "Se eliminaron " + selectedRows.length + " registros correctamente",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error en la conexión: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void editarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarBtnMouseClicked
        // TODO add your handling code here:
   

    }//GEN-LAST:event_editarBtnMouseClicked

    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialTwo Añadir1;
    private RSMaterialComponent.RSTableMetro TablaP;
    private RSMaterialComponent.RSButtonMaterialTwo editarBtn;
    private RSMaterialComponent.RSButtonMaterialTwo eliminarBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtbuscar;
    // End of variables declaration//GEN-END:variables

public class Conexion {

        public Connection getConnection() {
            Connection con = null;
            try {
                String myBD = "jdbc:mysql://localhost:3306/carpinteriasistema?serverTimezone=UTC";
                con = DriverManager.getConnection(myBD, "root", "");
                System.out.println("Conexión exitosa.");
            } catch (SQLException e) {
                System.out.println("Error al conectar: " + e.getMessage());
            }
            return con;
        }
    }

public void cargarTablaProveedor() {
        try (Connection con = new proveedores.Conexion().getConnection(); PreparedStatement ps = con.prepareStatement("SELECT codigo_proveedor, nombre, telefono, direccion, tipo,producto  FROM proveedor"); ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) TablaP.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("codigo_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("tipo"),
                    rs.getString("producto"),});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar datos: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }



private void filtrarTabla(){
    String textobusqueda = txtbuscar.getText().trim();
    DefaultTableModel modelo = (DefaultTableModel)TablaP.getModel();
    
    TableRowSorter<DefaultTableModel>tr= new TableRowSorter<>(modelo);
    TablaP.setRowSorter(tr);
    
    if (textobusqueda.isEmpty()){
        tr.setRowFilter(null);
        
        return;
        
    }
    
    List<RowFilter<Object, Object>>filters = new ArrayList<>();
    
    if(textobusqueda.matches("\\d+")){
        filters.add(RowFilter.regexFilter("^"+textobusqueda, 0));
    }
    
    filters.add(RowFilter.regexFilter("(?i)"+ textobusqueda ,  1));
    
    filters.add(RowFilter.regexFilter("(?i)"+ textobusqueda ,  4));
    
    filters.add(RowFilter.regexFilter("(?i)"+ textobusqueda ,  5));
    
    tr.setRowFilter(RowFilter.orFilter(filters));
    
}







}


