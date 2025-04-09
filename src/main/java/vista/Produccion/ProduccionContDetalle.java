/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Produccion;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class ProduccionContDetalle extends javax.swing.JPanel {

    /**
     * Creates new form ProduccionContDetalle
     */
    public ProduccionContDetalle() {
        initComponents();

        Tabla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Cantidad", "Dimensiones", "Materiales"}
        ));

        Tabla1.setCellSelectionEnabled(false);
        Tabla1.setRowSelectionAllowed(true);
        Tabla1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        Tabla1.setCellSelectionEnabled(false);
        Tabla1.setRowSelectionAllowed(true);
        Tabla1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        Color colorSeleccion = new Color(109, 160, 221);
        Color colorTexto = Color.white;

        Tabla1.setSelectionBackground(colorSeleccion);
        Tabla1.setSelectionForeground(colorTexto);
        cargarTablaDetalle();    // Carga Tabla1
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSTextFieldMaterialIcon1 = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnNuevoProduc = new rojeru_san.RSButtonRiple();
        btnEditar = new rojeru_san.RSButtonRiple();
        btnEliminar = new rojeru_san.RSButtonRiple();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new RSMaterialComponent.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1250, 630));
        setMinimumSize(new java.awt.Dimension(1250, 630));
        setPreferredSize(new java.awt.Dimension(1250, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSTextFieldMaterialIcon1.setBackground(new java.awt.Color(245, 245, 245));
        rSTextFieldMaterialIcon1.setForeground(new java.awt.Color(29, 30, 91));
        rSTextFieldMaterialIcon1.setColorIcon(new java.awt.Color(29, 30, 111));
        rSTextFieldMaterialIcon1.setColorMaterial(new java.awt.Color(29, 30, 111));
        rSTextFieldMaterialIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        rSTextFieldMaterialIcon1.setPlaceholder("Buscar");
        rSTextFieldMaterialIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSTextFieldMaterialIcon1ActionPerformed(evt);
            }
        });
        add(rSTextFieldMaterialIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 430, 40));

        btnNuevoProduc.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevoProduc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnNuevoProduc.setText(" Nuevo");
        btnNuevoProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProducActionPerformed(evt);
            }
        });
        add(btnNuevoProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 120, 40));

        btnEditar.setBackground(new java.awt.Color(46, 49, 82));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pencil (1).png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 120, 40));

        btnEliminar.setBackground(new java.awt.Color(46, 49, 82));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete (1).png"))); // NOI18N
        btnEliminar.setText(" Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 120, 40));

        Tabla1.setBackground(new java.awt.Color(255, 255, 255));
        Tabla1.setForeground(new java.awt.Color(255, 255, 255));
        Tabla1.setAlignmentX(0.1F);
        Tabla1.setAlignmentY(0.1F);
        Tabla1.setBackgoundHead(new java.awt.Color(46, 49, 82));
        Tabla1.setBackgoundHover(new java.awt.Color(46, 49, 82));
        Tabla1.setColorBorderRows(new java.awt.Color(153, 153, 153));
        Tabla1.setColorPrimaryText(new java.awt.Color(46, 49, 82));
        Tabla1.setColorSecondary(new java.awt.Color(255, 255, 255));
        Tabla1.setColorSecundaryText(new java.awt.Color(46, 49, 82));
        jScrollPane2.setViewportView(Tabla1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1210, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void rSTextFieldMaterialIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSTextFieldMaterialIcon1ActionPerformed

    }//GEN-LAST:event_rSTextFieldMaterialIcon1ActionPerformed

    private void btnNuevoProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProducActionPerformed
        DetalleProduccion dialog = new DetalleProduccion(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnNuevoProducActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        EditDetalleProduccion dialog = new EditDetalleProduccion(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int[] selectedRows = Tabla1.getSelectedRows(); // Obtener todas las filas seleccionadas

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

        try (Connection con = new ProduccionContDetalle.Conexion().getConnection()) {
            // Desactivar auto-commit para manejar transacciones
            con.setAutoCommit(false);

            String sql = "DELETE FROM detalle_produccion WHERE idetalle_produccion = ?";
            boolean error = false;

            // Eliminar en orden inverso para evitar problemas con los índices de la tabla
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int selectedRow = selectedRows[i];
                int idProduccion = (int) Tabla1.getValueAt(selectedRow, 0);

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, idProduccion);
                    ps.executeUpdate();

                    // Eliminar la fila de la tabla visual
                    DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
                    model.removeRow(selectedRow);
                } catch (SQLException e) {
                    error = true;
                    JOptionPane.showMessageDialog(
                            this,
                            "Error al eliminar el registro con ID " + idProduccion + ": " + e.getMessage(),
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
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTableMetro Tabla1;
    private rojeru_san.RSButtonRiple btnEditar;
    private rojeru_san.RSButtonRiple btnEliminar;
    private rojeru_san.RSButtonRiple btnNuevoProduc;
    private javax.swing.JScrollPane jScrollPane2;
    private RSMaterialComponent.RSTextFieldMaterialIcon rSTextFieldMaterialIcon1;
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

    public void cargarTablaDetalle() {
        try (Connection con = new Conexion().getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM detalle_produccion"); ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
            model.setRowCount(0);

            int rowNum = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("idetalle_produccion"),
                    rs.getInt("cantidad"),
                    rs.getString("dimensiones"),
                    rs.getString("materiales")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar detalles: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
