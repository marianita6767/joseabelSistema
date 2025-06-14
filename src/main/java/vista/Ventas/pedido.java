/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.Ventas;

import RSMaterialComponent.RSButtonShape;
import controlador.Ctrl_Pedido;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import rojeru_san.RSButtonRiple;
import vista.Ventas.DetallesPedido; // Si decides mover DetallesPedido a vista.Ventas

/**
 *
 * @author ZenBook
 */
public class pedido extends javax.swing.JPanel {

    private JPanel contenedor; // Referencia al contenedor de Principal
    private Ctrl_Pedido controlador;
    private int idPedido;

    /**
     * Creates new form pedido
     */
    public pedido(JPanel contenedor) {
        this.contenedor = contenedor;
        this.controlador = new Ctrl_Pedido();
        initComponents();

        // Configurar la columna "Detalle"
        TableColumn detailColumn = tablaM.getColumnModel().getColumn(6);
        detailColumn.setCellRenderer(new ButtonRenderer());
        detailColumn.setPreferredWidth(35); // Ajustar el ancho de la columna
        tablaM.setRowHeight(30); // Ajusta este valor según necesites

        tablaM.setRowHeight(23); // Altura más delgada para las filas

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Codigo", "Nombre", "Estado", "Cliente", "Fecha inicio", "Fecha final", "Detalle"} // Usa tus nombres de columnas reales
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean no editables
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class; // Ajusta el tipo si usas tipos distintos (Double, Date, etc.)
            }
        };

        tablaM.setModel(modelo);

        tablaM.getColumnModel().getColumn(2).setCellRenderer(new EstadoTableCellRenderer());

        // Cargar datos desde la base de datos
        cargarDatosIniciales();
    }

    // Método para agregar una nueva fila a la tabla
    public void agregarFilaATabla(Object[] fila) {
        DefaultTableModel model = (DefaultTableModel) tablaM.getModel();
        model.addRow(fila);
    }

    // Cargar datos desde la base de datos
    public void cargarDatosIniciales() {
        DefaultTableModel model = (DefaultTableModel) tablaM.getModel();
        model.setRowCount(0);

        List<Ctrl_Pedido.MaterialConDetalles> pedidos = controlador.obtenerMateriales();
        for (Ctrl_Pedido.MaterialConDetalles pedido : pedidos) {
            model.addRow(new Object[]{
                pedido.getPedido().getId_pedido(),
                pedido.getPedido().getNombre(),
                pedido.getPedido().getEstado(),
                pedido.getNombreCliente(),
                new java.text.SimpleDateFormat("dd-MM-yyyy").format(pedido.getPedido().getFecha_inicio()),
                new java.text.SimpleDateFormat("dd-MM-yyyy").format(pedido.getPedido().getFecha_fin()),
                "Ver"
            });
        }
    }

// Renderizador para la columna "Ver"
    private class ButtonRenderer extends DefaultTableCellRenderer {

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
            tablaM.setRowHeight(23); // Altura más delgada para las filas
            return c;
        }
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
            tablaM.setRowHeight(23); // Altura más delgada para las filas
            return label;
        }
    }

    private void mostrarDetallesPedido(String id) {
        DetallesPedido detalles = new DetallesPedido(id, contenedor);
        detalles.setSize(1290, 730);
        detalles.setLocation(0, 0);
        contenedor.removeAll();
        contenedor.add(detalles);
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

        jPanel1 = new javax.swing.JPanel();
        cmbCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        txtBuscar = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnNuevo = new RSMaterialComponent.RSButtonShape();
        btnEliminar1 = new RSMaterialComponent.RSButtonShape();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaM = new RSMaterialComponent.RSTableMetroCustom();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1304, 742));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbCategoria.setForeground(new java.awt.Color(153, 153, 153));
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoria:" }));
        cmbCategoria.setColorMaterial(new java.awt.Color(153, 153, 153));
        cmbCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 280, 30));

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorIcon(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(153, 153, 153));
        txtBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        txtBuscar.setPhColor(new java.awt.Color(102, 102, 102));
        txtBuscar.setPlaceholder("Buscar...");
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 410, 30));

        btnNuevo.setBackground(new java.awt.Color(46, 49, 82));
        btnNuevo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnNuevo.setText(" Nuevo");
        btnNuevo.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnNuevo.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnNuevo.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 40, 110, 30));

        btnEliminar1.setBackground(new java.awt.Color(46, 49, 82));
        btnEliminar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete (1).png"))); // NOI18N
        btnEliminar1.setText(" Eliminar");
        btnEliminar1.setToolTipText("");
        btnEliminar1.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnEliminar1.setFont(new java.awt.Font("Roboto Bold", 1, 16)); // NOI18N
        btnEliminar1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnEliminar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, 110, 30));

        tablaM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Estado", "Cliente", "Fecha Inicio", "Fecha Final", "Detalle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaM.setBackgoundHead(new java.awt.Color(46, 49, 82));
        tablaM.setBackgoundHover(new java.awt.Color(109, 160, 221));
        tablaM.setBorderHead(null);
        tablaM.setBorderRows(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tablaM.setColorBorderHead(new java.awt.Color(46, 49, 82));
        tablaM.setColorBorderRows(new java.awt.Color(46, 49, 82));
        tablaM.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        tablaM.setColorSecondary(new java.awt.Color(255, 255, 255));
        tablaM.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        tablaM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaM.setFontHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaM.setFontRowHover(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaM.setFontRowSelect(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaM.setRowHeight(23);
        tablaM.setSelectionBackground(new java.awt.Color(109, 160, 221));
        tablaM.setShowGrid(false);
        tablaM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaM);
        tablaM.getColumnModel().getColumn(0).setPreferredWidth(10);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1210, 500));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1304, 742));
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
            pedidoNuevo dialog = new pedidoNuevo(new javax.swing.JFrame(), true, this);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        int[] selectedRows = tablaM.getSelectedRows();

        // Verificar si hay filas seleccionadas
        if (selectedRows.length == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione al menos un pedido para eliminar.", "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar " + selectedRows.length + " pedido(s)? Esto también eliminará sus detalles asociados.",
                "Confirmar eliminación",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        // Eliminar los pedidos seleccionados usando el controlador
        int deletedCount = 0;
        for (int row : selectedRows) {
            int idPedido = (int) tablaM.getValueAt(row, 0); // Obtener el id_pedido de la columna 0
            if (controlador.eliminarPedido(idPedido)) {
                deletedCount++;
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error al eliminar el pedido con ID " + idPedido + ".",
                        "Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }

        // Mostrar mensaje de éxito
        if (deletedCount > 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    deletedCount + " pedido(s) eliminado(s) exitosamente.",
                    "Éxito",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            // Recargar datos en la tabla
            cargarDatosIniciales();
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void tablaMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMMouseClicked
        int column = tablaM.columnAtPoint(evt.getPoint());
        int row = tablaM.rowAtPoint(evt.getPoint());

        if (column == 6) { // Columna "Ver"
            String id = tablaM.getValueAt(row, 0).toString();
            mostrarDetallesPedido(id);
        }
    }//GEN-LAST:event_tablaMMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonShape btnEliminar1;
    private RSMaterialComponent.RSButtonShape btnNuevo;
    private RSMaterialComponent.RSComboBoxMaterial cmbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private RSMaterialComponent.RSTableMetroCustom tablaM;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtBuscar;
    // End of variables declaration//GEN-END:variables
}
