/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Produccionn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.Conexion;

/**
 *
 * @author pc
 */
public final class Produccion extends javax.swing.JPanel {

    private int idProduccion;

    /**
     * Creates new form produccionContenido
     */
    public Produccion(JFrame jFrame) {
        initComponents();

        Tabla1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Configura el modelo de tabla correctamente
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Codigo", "Nombre", "Fecha inicio", "Fecha Final", "Estado", "Detalle", "Cantidad", "Dimensiones"}
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };

        Tabla1.setModel(model);

        // Oculta las columnas adicionales después de establecer el modelo
        Tabla1.removeColumn(Tabla1.getColumnModel().getColumn(6)); // Oculta Dimensiones
        Tabla1.removeColumn(Tabla1.getColumnModel().getColumn(6)); // Oculta Cantidad

        // Configura el renderizador especial para la columna de estado (sobrescribe el general)
        Tabla1.getColumnModel().getColumn(4).setCellRenderer(new EstadoTableCellRenderer());

        // Configura el renderizador especial para la columna "Ver" (sobrescribe el general)
        Tabla1.getColumnModel().getColumn(5).setCellRenderer(new VerTableCellRenderer());

        // Configura el buscador
        txtbuscar.getDocument().addDocumentListener(new BuscadorDocumentListener());

        // Carga los datos
        cargarTablaProduccion();

    }

// Renderizador para la columna de estado
    private class EstadoTableCellRenderer extends DefaultTableCellRenderer {

        private final Color textColor = new Color(46, 49, 82);
        private final Font fontNormal = new Font("Tahoma", Font.PLAIN, 14);
        private final Font fontBold = new Font("Tahoma", Font.BOLD, 14);

        public EstadoTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            // Llamar al método padre primero
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);

            label.setHorizontalAlignment(CENTER);
            label.setText(value != null ? value.toString() : "");

            if (isSelected) {
                // Cuando está seleccionado, texto blanco y fondo de selección
                label.setForeground(Color.WHITE);
                label.setBackground(table.getSelectionBackground());
                label.setFont(fontBold);
            } else {
                // Cuando no está seleccionado, mantener el color original del texto
                label.setForeground(textColor);
                label.setFont(fontNormal);

                // Aplicar colores de fondo según el estado
                String estado = value != null ? value.toString() : "";
                switch (estado.toLowerCase()) {
                    case "pendiente":
                        label.setBackground(new Color(255, 204, 204)); // Rojo claro
                        break;
                    case "proceso":
                        label.setBackground(new Color(255, 255, 153)); // Amarillo claro
                        break;
                    case "finalizado":
                        label.setBackground(new Color(204, 255, 204)); // Verde claro
                        break;
                    default:
                        label.setBackground(Color.WHITE);
                        break;
                }
            }

            // Borde igual al resto de la tabla
            label.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
            Tabla1.setRowHeight(23); // Altura más delgada para las filas
            return label;
        }
    }

// Renderizador para la columna "Ver"
    private class VerTableCellRenderer extends DefaultTableCellRenderer {

        private final Color textColor = new Color(46, 49, 82); // Color de texto normal
        private final Font fontNormal = new Font("Tahoma", Font.PLAIN, 14);
        private final Font fontBold = new Font("Tahoma", Font.BOLD, 14);

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            c.setForeground(isSelected ? Color.WHITE : Color.BLACK);
            c.setBackground(isSelected ? table.getSelectionBackground() : Color.WHITE);
            c.setFont(isSelected ? fontBold : fontNormal);

            setHorizontalAlignment(CENTER);
            setText("Ver");

            // Bordes iguales al resto
            setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153), 1));
            Tabla1.setRowHeight(23); // Altura más delgada para las filas
            return c;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtbuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnEditar = new RSMaterialComponent.RSButtonShape();
        btnNuevo = new RSMaterialComponent.RSButtonShape();
        btnElimi = new RSMaterialComponent.RSButtonShape();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla1 = new RSMaterialComponent.RSTableMetroCustom();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1250, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbuscar.setBackground(new java.awt.Color(245, 245, 245));
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
        jPanel1.add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 430, 40));

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
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 120, 40));

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
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 120, 40));

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
        jPanel1.add(btnElimi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 120, 40));

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Fecha inicio", "Fecha final", "Estado", "Detalle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
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
        jScrollPane4.setViewportView(Tabla1);
        Tabla1.getColumnModel().getColumn(0).setPreferredWidth(10);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1210, 500));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        filtrarTabla();
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        EditProduccion dialog = new EditProduccion(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaProduccion();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FormuEtapaProduccion dialog = new FormuEtapaProduccion(new javax.swing.JFrame(), true, this.idProduccion);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        cargarTablaProduccion();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnElimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimiActionPerformed
// 1. Obtener filas seleccionadas
        int[] selectedRows = Tabla1.getSelectedRows();

        // 2. Validar si hay filas seleccionadas
        if (selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Por favor seleccione al menos una fila para eliminar",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. Mostrar confirmación
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar los " + selectedRows.length + " registros seleccionados?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        // 4. Si el usuario no confirma, salir
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // 5. Eliminar registros
        try (Connection con = new Conexion().getConnection()) {
            String sql = "DELETE FROM produccion WHERE id_produccion = ?";
            DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();

            // Eliminar en orden inverso para evitar problemas con los índices
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int row = selectedRows[i];
                int id = (int) model.getValueAt(row, 0); // ID está en la columna 0

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    model.removeRow(row); // Eliminar de la tabla visual
                }
            }

            JOptionPane.showMessageDialog(this,
                    "Registros eliminados correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al eliminar: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnElimiActionPerformed

    private void Tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla1MouseClicked
        // 1. Obtener posición del clic
        int column = Tabla1.columnAtPoint(evt.getPoint());
        int viewRow = Tabla1.rowAtPoint(evt.getPoint());

        // 2. Validar clic
        if (viewRow < 0 || column < 0) {
            System.out.println("Clic fuera de las filas/columnas");
            return;
        }

        // 3. Solo procesar clic en columna "Ver" (índice 5)
        if (column == 5) {
            // 4. Convertir índice de vista a modelo (importante si hay filtros aplicados)
            int modelRow = Tabla1.convertRowIndexToModel(viewRow);
            DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();

            // 5. Debug: Mostrar todos los valores de la fila
            System.out.println("\n--- DATOS DE LA FILA SELECCIONADA ---");
            for (int i = 0; i < model.getColumnCount(); i++) {
                System.out.printf("Columna %d (%s): %s %n",
                        i,
                        model.getColumnName(i),
                        model.getValueAt(modelRow, i));
            }

            // 6. Obtener y validar el ID
            Object idObj = model.getValueAt(modelRow, 0);
            int idProduccion = 0;

            try {
                idProduccion = Integer.parseInt(idObj.toString());
                System.out.println("ID obtenido: " + idProduccion);

                if (idProduccion <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Error: ID de producción no válido (" + idProduccion + ")",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Error: El ID no es un número válido (" + idObj + ")",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 7. Obtener el resto de datos con validación de nulos
            String nombre = model.getValueAt(modelRow, 1) != null
                    ? model.getValueAt(modelRow, 1).toString() : "";

            String fechaInicio = model.getValueAt(modelRow, 2) != null
                    ? model.getValueAt(modelRow, 2).toString() : "";

            String fechaFin = model.getValueAt(modelRow, 3) != null
                    ? model.getValueAt(modelRow, 3).toString() : "En proceso";

            String estado = model.getValueAt(modelRow, 4) != null
                    ? model.getValueAt(modelRow, 4).toString() : "";

            // 8. Obtener datos de columnas ocultas (cantidad y dimensiones)
            int cantidad = 0;
            try {
                Object cantObj = model.getValueAt(modelRow, 6);
                cantidad = cantObj != null ? Integer.parseInt(cantObj.toString()) : 0;
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir cantidad: " + e.getMessage());
            }

            String dimensiones = "";
            try {
                Object dimObj = model.getValueAt(modelRow, 7);
                dimensiones = dimObj != null ? dimObj.toString() : "";
            } catch (Exception e) {
                System.out.println("Error al obtener dimensiones: " + e.getMessage());
            }

            // 9. Debug: Mostrar datos que se enviarán
            System.out.println("\n--- DATOS A ENVIAR AL PANEL ---");
            System.out.println("ID: " + idProduccion);
            System.out.println("Nombre: " + nombre);
            System.out.println("Fecha inicio: " + fechaInicio);
            System.out.println("Fecha fin: " + fechaFin);
            System.out.println("Estado: " + estado);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Dimensiones: " + dimensiones);

            // 10. Crear y configurar el panel de detalle
            
            DetalleProduProducto detallePanel = new DetalleProduProducto(
                    idProduccion,
                    nombre,
                    fechaInicio,
                    fechaFin,
                    estado,
                    String.valueOf(cantidad),
                    dimensiones
            );

            // 11. Mostrar el panel de detalle
            removeAll();
            setLayout(new BorderLayout());
            add(detallePanel, BorderLayout.CENTER);
            revalidate();
            repaint();

            System.out.println("Panel de detalle mostrado con ID: " + idProduccion);
        }


    }//GEN-LAST:event_Tabla1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTableMetroCustom Tabla1;
    private RSMaterialComponent.RSButtonShape btnEditar;
    private RSMaterialComponent.RSButtonShape btnElimi;
    private RSMaterialComponent.RSButtonShape btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtbuscar;
    // End of variables declaration//GEN-END:variables

    private void filtrarTabla() {
        String textoBusqueda = txtbuscar.getText().trim().toLowerCase();
        DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
        Tabla1.setRowSorter(tr);

        if (textoBusqueda.isEmpty()) {
            tr.setRowFilter(null);
            return;
        }

        // Filtro para buscar en todas las columnas
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda));
    }

    public void cargarTablaProduccion() {
        DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
        model.setRowCount(0); // Limpiar tabla

        try (Connection con = new Conexion().getConnection()) {
            String sql = "SELECT p.id_produccion, dp.descripcion, p.fecha_inicio, "
                    + "p.fecha_fin, p.estado, dp.cantidad, dp.dimension "
                    + "FROM produccion p "
                    + "JOIN detalle_pedido dp ON p.detalle_pedido_iddetalle_pedido = dp.iddetalle_pedido "
                    + "ORDER BY p.id_produccion ASC";

            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getInt("id_produccion"),
                        rs.getString("descripcion"),
                        sdf.format(rs.getDate("fecha_inicio")),
                        rs.getDate("fecha_fin") != null ? sdf.format(rs.getDate("fecha_fin")) : "En proceso",
                        rs.getString("estado"),
                        "Ver",
                        rs.getInt("cantidad"),
                        rs.getString("dimension")
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private class BuscadorDocumentListener implements DocumentListener {

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

        private void filtrarTabla() {
            String texto = txtbuscar.getText().trim().toLowerCase();
            DefaultTableModel modelo = (DefaultTableModel) Tabla1.getModel();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(modelo);
            Tabla1.setRowSorter(tr);

            if (texto.isEmpty()) {
                tr.setRowFilter(null);
            } else {
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
            }
        }
    }

}
