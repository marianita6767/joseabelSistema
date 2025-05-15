/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Produccionn;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;

/**
 *
 * @author pc
 */
public final class ProduccionContEtapa extends javax.swing.JPanel {

    private final int idProduccion;

    
    
    /**
     * Creates new form ProduccionContDetalle
     *
     * @param idProduccion
     */
    public ProduccionContEtapa(int idProduccion) {
        System.out.println("ID recibido en constructor: " + idProduccion); 
        this.idProduccion = idProduccion;
        initComponents();
        cargarEtapasProduccion();

        Tabla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Nombre","Fecha inicio", "Fecha final", "Estado", "Materiales", "Asignado"}
        ));

        Tabla1.setCellSelectionEnabled(false);
        Tabla1.setRowSelectionAllowed(true);
        Tabla1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        

        Color colorSeleccion = new Color(109, 160, 221);
        Color colorTexto = Color.white;

        Tabla1.setSelectionBackground(colorSeleccion);
        Tabla1.setSelectionForeground(colorTexto);
        
        Tabla1.getColumnModel().getColumn(3).setCellRenderer(new EstadoTableCellRenderer());

        cargarTablaEtapa();    // Carga Tabla1
    }
    // Renderizador para la columna de estado

    private class EstadoTableCellRenderer extends DefaultTableCellRenderer {

        public EstadoTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            // Llamar al método padre primero
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                // Cuando está seleccionado, texto blanco y fondo de selección
                c.setForeground(Color.WHITE);
                c.setBackground(table.getSelectionBackground());
            } else {
                // Cuando no está seleccionado, mantener el color original del texto
                c.setForeground(new Color(46, 49, 82));

                // Aplicar colores de fondo según el estado
                String estado = (String) value;
                switch (estado) {
                    case "pendiente":
                        c.setBackground(new Color(255, 204, 204));
                        break;
                    case "en proceso":
                        c.setBackground(new Color(255, 255, 153));
                        break;
                    case "completado":
                        c.setBackground(new Color(204, 255, 204));
                        break;
                    default:
                        c.setBackground(table.getBackground());
                        break;
                }
            }

            return c;
        }

    }

    private void cargarEtapasProduccion() {
        try (Connection con = Conexion.getConnection()) {
            String sql = "SELECT ep.idetapa_produccion, ep.nombre_etapa, dp.cantidad, ep.fecha_inicio, "
                    + "ep.fecha_fin,  ep.estado, dp.produccion_codigo "
                    + "FROM etapa_produccion ep "
                    + "JOIN detalle_pedido dp ON ep.produccion_id_produccion = dp.iddetalle_pedido "
                    + "ORDER BY p.idestado_produccion ASC";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, this.idProduccion);
                try (ResultSet rs = ps.executeQuery()) {
                    DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
                    model.setRowCount(0);

                    while (rs.next()) {
                        model.addRow(new Object[]{
                            rs.getString("nombre_etapa"),
                            rs.getString("cantidad"),
                            rs.getString("fecha_inicio"),
                            rs.getString("fecha_fin"),
                            rs.getString("estado"),
                            rs.getString(""),
                            rs.getString("")
                        });
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar etapas de producción: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
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

        txtbuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new RSMaterialComponent.RSTableMetro();
        btnEditar = new RSMaterialComponent.RSButtonShape();
        btnNuevo = new RSMaterialComponent.RSButtonShape();
        btnElimi = new RSMaterialComponent.RSButtonShape();

        setBackground(new java.awt.Color(234, 234, 234));
        setMaximumSize(new java.awt.Dimension(1150, 510));
        setMinimumSize(new java.awt.Dimension(1150, 510));
        setPreferredSize(new java.awt.Dimension(1150, 510));

        txtbuscar.setBackground(new java.awt.Color(255, 255, 255));
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

        btnEditar.setBackground(new java.awt.Color(46, 49, 82));
        btnEditar.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pencil (1).png"))); // NOI18N
        btnEditar.setText("   Editar");
        btnEditar.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnEditar.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnEditar.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (1).png"))); // NOI18N
        btnNuevo.setText("  Nuevo");
        btnNuevo.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnNuevo.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnNuevo.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnElimi.setBackground(new java.awt.Color(46, 49, 82));
        btnElimi.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnElimi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete (1).png"))); // NOI18N
        btnElimi.setText(" Eliminar");
        btnElimi.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnElimi.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        btnElimi.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnElimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnElimi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        filtrarTabla();

    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        EditEtapaProduccion dialog = new EditEtapaProduccion(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaEtapa();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        formuProduccion dialog = new formuProduccion(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaEtapa();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnElimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiActionPerformed
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

        try (Connection con = Conexion.getConnection()) {
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
    }//GEN-LAST:event_btnElimiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTableMetro Tabla1;
    private RSMaterialComponent.RSButtonShape btnEditar;
    private RSMaterialComponent.RSButtonShape btnElimi;
    private RSMaterialComponent.RSButtonShape btnNuevo;
    private javax.swing.JScrollPane jScrollPane2;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtbuscar;
    // End of variables declaration//GEN-END:variables

    public void cargarTablaEtapa() {
    try (Connection con = Conexion.getConnection()) {
        String sql = "SELECT ep.idetapa_produccion, ep.nombre_etapa, " +
                     "ep.fecha_inicio, ep.fecha_fin, ep.estado " +
                     "FROM etapa_produccion ep " +
                     "WHERE ep.produccion_id_produccion = ? " +
                     "ORDER BY ep.idetapa_produccion ASC";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, this.idProduccion);
            try (ResultSet rs = ps.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
                model.setRowCount(0); // Limpiar tabla antes de cargar nuevos datos

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("nombre_etapa"),
                        sdf.format(rs.getDate("fecha_inicio")),
                        sdf.format(rs.getDate("fecha_fin")),
                        rs.getString("estado"),
                        "Materiales", // Placeholder - ajustar según necesidad
                        "Asignado"    // Placeholder - ajustar según necesidad
                    });
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error al cargar etapas de producción: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

    private void filtrarTabla() {
        String textoBusqueda = txtbuscar.getText().trim();
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        Tabla1.setRowSorter(tr);

        if (textoBusqueda.isEmpty()) {
            tr.setRowFilter(null);
            return;
        }

        // Expresión regular para detectar si son solo números (1-2 dígitos)
        if (textoBusqueda.matches("\\d{1}")) {
            // Buscar en ID (columna 0) y fechas (columnas 1 y 2)
            List<RowFilter<Object, Object>> filters = new ArrayList<>();
            filters.add(RowFilter.regexFilter("^" + textoBusqueda, 0));// ID (coincidencia exacta)
            tr.setRowFilter(RowFilter.orFilter(filters));

        } else if (textoBusqueda.matches("\\d{2}")) {
            List<RowFilter<Object, Object>> filters = new ArrayList<>();
            filters.add(RowFilter.regexFilter(textoBusqueda, 1)); // fecha_inicio
            filters.add(RowFilter.regexFilter(textoBusqueda, 2)); // fecha_fin
            tr.setRowFilter(RowFilter.orFilter(filters));
        } // Si contiene letras (aunque sea parcial)
        else if (textoBusqueda.matches(".*[a-zA-ZáéíóúÁÉÍÓÚ].*")) {
            // Buscar solo en estado (columna 3)
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda, 3));
        } // Para otros casos (números más largos, combinaciones, etc.)
        else {
            // Buscar en todos los campos
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
        }
    }

}
