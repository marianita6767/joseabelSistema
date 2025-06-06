/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.Caja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.accessibility.Accessible;
import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.ComboPopup;
import modelo.Conexion;
import vista.Inventario0.nuevoMateriales;
import vista.Produccionn.Error_guardar;

import vista.proveedor.proveedornuevo;

/**
 *
 * @author ADSO
 */
public class formuEgresos1 extends javax.swing.JDialog {

    private Ingresos ingresoPanel;
    private CheckedComboBox<CheckableItem> comboProductos;

    /**
     * Creates new form formuIngresos
     */
    public formuEgresos1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            cargarProveedores();

            comboProductos = new CheckedComboBox<>(makeProductModel("material"));
            comboProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            jPanel1.add(comboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 200, 30));
            ohtaniahea();
            setPreferredSize(new java.awt.Dimension(522, 460));
            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 480));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error al inicializar el formulario: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void ohtaniahea() {
        jLabel8.setVisible(false);
        comboProveedor.setVisible(false);
        btnClienteN1.setVisible(false);
        jLabel3.setVisible(false);
        comboProductos.setVisible(false);
        btnClienteN.setVisible(false);

        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private DefaultComboBoxModel<CheckableItem> makeProductModel(String tipo) {
        DefaultComboBoxModel<CheckableItem> model = new DefaultComboBoxModel<>();
        System.out.println("Iniciando creación de modelo para tipo: " + tipo); // Debug

        try (Connection con = new Conexion().getConnection()) {
            System.out.println("Conexión establecida correctamente"); // Debug

            String sql = "SELECT nombre FROM inventario WHERE tipo = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, tipo);
                System.out.println("Ejecutando consulta: " + ps.toString()); // Debug

                try (ResultSet rs = ps.executeQuery()) {
                    int count = 0;
                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        System.out.println("Encontrado: " + nombre); // Debug
                        model.addElement(new CheckableItem(nombre, false));
                        count++;
                    }
                    System.out.println("Total de elementos agregados: " + count); // Debug
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error en makeProductModel: " + ex.getMessage());
            ex.printStackTrace();
            // Mostrar mensaje de error al usuario
            Error_guardar errorDialog = new Error_guardar(
                    (Frame) this.getParent(),
                    true,
                    "Error",
                    "No se pudieron cargar los " + tipo + ": " + ex.getMessage()
            );
            errorDialog.setLocationRelativeTo(null);
            errorDialog.setVisible(true);
        }
        return model;
    }

    class CheckedComboBox<E extends CheckableItem> extends JComboBox<E> {

        protected boolean keepOpen;
        private final JPanel panel = new JPanel(new BorderLayout());

        protected CheckedComboBox(ComboBoxModel<E> model) {
            super(model);
            setBackground(new Color(255, 255, 255)); // Fondo blanco para coincidir con jPanel1
            setForeground(Color.DARK_GRAY); // Texto oscuro
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 40); // Aumentar altura para un look más moderno
        }

        @Override
        public void updateUI() {
            setRenderer(null);
            super.updateUI();

            Accessible a = getAccessibleContext().getAccessibleChild(0);
            if (a instanceof ComboPopup) {
                ((ComboPopup) a).getList().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JList<?> list = (JList<?>) e.getComponent();
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            keepOpen = true;
                            updateItem(list.locationToIndex(e.getPoint()));
                        }
                    }
                });
            }

            DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (index >= 0) {
                        c.setBackground(isSelected ? new Color(0, 120, 215, 50) : new Color(255, 255, 255));
                        c.setForeground(Color.DARK_GRAY);
                    } else {
                        c.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente para el texto seleccionado
                    }
                    return c;
                }
            };
            JCheckBox check = new JCheckBox();
            check.setOpaque(false);
            check.setForeground(new Color(0, 120, 215)); // Color de casilla moderna
            setRenderer((list, value, index, isSelected, cellHasFocus) -> {
                panel.removeAll();
                Component c = renderer.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);
                if (index < 0) {
                    String txt = getCheckedItemString(list.getModel());
                    JLabel l = (JLabel) c;
                    l.setText(txt.isEmpty() ? " " : txt);
                    l.setForeground(Color.DARK_GRAY);
                    l.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    panel.setOpaque(false); // Hacer el panel transparente
                    panel.setBackground(new Color(0, 0, 0, 0)); // Fondo transparente
                } else {
                    check.setSelected(value.isSelected());
                    panel.add(check, BorderLayout.WEST);
                    panel.setBackground(isSelected ? new Color(0, 120, 215, 50) : new Color(255, 255, 255));
                }
                panel.add(c, BorderLayout.CENTER);
                return panel;
            });
            initActionMap();
        }

        protected void initActionMap() {
            KeyStroke ks = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0);
            getInputMap(JComponent.WHEN_FOCUSED).put(ks, "checkbox-select");
            getActionMap().put("checkbox-select", new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    Accessible a = getAccessibleContext().getAccessibleChild(0);
                    if (a instanceof ComboPopup) {
                        updateItem(((ComboPopup) a).getList().getSelectedIndex());
                    }
                }
            });
        }

        protected void updateItem(int index) {
            if (isPopupVisible() && index >= 0) {
                E item = getItemAt(index);
                item.setSelected(!item.isSelected());
                setSelectedIndex(-1);
                setSelectedItem(item);
            }
        }

        @Override
        public void setPopupVisible(boolean v) {
            if (keepOpen) {
                keepOpen = false;
            } else {
                super.setPopupVisible(v);
            }
        }

        protected static <E extends CheckableItem> String getCheckedItemString(ListModel<E> model) {
            return IntStream.range(0, model.getSize())
                    .mapToObj(model::getElementAt)
                    .filter(CheckableItem::isSelected)
                    .map(Objects::toString)
                    .sorted()
                    .collect(Collectors.joining(", "));
        }
    }

    class CheckableItem {

        private final String text;
        private boolean selected;

        protected CheckableItem(String text, boolean selected) {
            this.text = text;
            this.selected = selected;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        @Override
        public String toString() {
            return text;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPago = new com.toedter.calendar.JDateChooser();
        txtCantidadnuevo = new RSMaterialComponent.RSTextFieldMaterial();
        jLabel2 = new javax.swing.JLabel();
        txtDetallenuevo = new RSMaterialComponent.RSTextFieldMaterial();
        comboCategoria = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel7 = new javax.swing.JLabel();
        comboProveedor = new RSMaterialComponent.RSComboBoxMaterial();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnClienteN1 = new RSMaterialComponent.RSButtonShape();
        btnClienteN = new RSMaterialComponent.RSButtonShape();
        btnGuardar = new rojeru_san.RSButtonRiple();
        btnCancelar1 = new rojeru_san.RSButtonRiple();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        jLabel11 = new javax.swing.JLabel();
        txtcantidad = new RSMaterialComponent.RSTextFieldMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(504, 526));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 49, 82));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century751 BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Produccion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel9.setText("Detalle de Ingreso:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setText("Fecha Pago:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txtPago.setBackground(new java.awt.Color(255, 255, 255));
        txtPago.setForeground(new java.awt.Color(255, 255, 255));
        txtPago.setDateFormatString("y-MM-d");
        txtPago.setMaxSelectableDate(new java.util.Date(253370786472000L));
        jPanel1.add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 30));

        txtCantidadnuevo.setPlaceholder("");
        jPanel1.add(txtCantidadnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 420, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Cantidad a Ingresar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        txtDetallenuevo.setForeground(new java.awt.Color(0, 0, 0));
        txtDetallenuevo.setPlaceholder("");
        txtDetallenuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDetallenuevoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDetallenuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 420, 30));

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione categoria:", "Servicios Publicos", "Compra de Productos e Insumos", "Arriendo", "Nómina", "Gastos Administrativos", "Mercadeo y Publicidad", "Transporte", "Domicilios y Logistica", "mantenimineto y Reparaciones", "Muebles", "Equipos o Maquinaria", "Otros" }));
        comboCategoria.setColorMaterial(new java.awt.Color(0, 0, 0));
        comboCategoria.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(comboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 420, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Categoria");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione proveedor:" }));
        comboProveedor.setColorMaterial(new java.awt.Color(0, 0, 0));
        comboProveedor.setFont(new java.awt.Font("Roboto Bold", 0, 14)); // NOI18N
        comboProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(comboProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 170, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Proveedor");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        btnClienteN1.setBackground(new java.awt.Color(46, 49, 82));
        btnClienteN1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnClienteN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnClienteN1.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnClienteN1.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnClienteN1.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnClienteN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClienteN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteN1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnClienteN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 20, 20));

        btnClienteN.setBackground(new java.awt.Color(46, 49, 82));
        btnClienteN.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnClienteN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus (2).png"))); // NOI18N
        btnClienteN.setBackgroundHover(new java.awt.Color(67, 150, 209));
        btnClienteN.setFont(new java.awt.Font("Roboto Bold", 1, 15)); // NOI18N
        btnClienteN.setForma(RSMaterialComponent.RSButtonShape.FORMA.ROUND);
        btnClienteN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClienteN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteNActionPerformed(evt);
            }
        });
        jPanel1.add(btnClienteN, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 20, 20));

        btnGuardar.setBackground(new java.awt.Color(46, 49, 82));
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 140, -1));

        btnCancelar1.setBackground(new java.awt.Color(46, 49, 82));
        btnCancelar1.setText("Volver");
        btnCancelar1.setFont(new java.awt.Font("Humnst777 BlkCn BT", 1, 14)); // NOI18N
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 140, -1));

        rSLabelHora1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 120, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setText("Cantidad:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        txtcantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtcantidad.setPlaceholder("");
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        String seleccion = comboCategoria.getSelectedItem().toString();

        if (seleccion.equals("Compra de Productos e Insumos")) {
            jLabel8.setVisible(true);
            comboProveedor.setVisible(true);
            btnClienteN1.setVisible(true);
            jLabel3.setVisible(true);
            comboProductos.setVisible(true);
            btnClienteN.setVisible(true);
        } else {
            jLabel8.setVisible(false);
            comboProveedor.setVisible(false);
            btnClienteN1.setVisible(false);
            jLabel3.setVisible(false);
            comboProductos.setVisible(false);
            btnClienteN.setVisible(false);
        }
        jPanel1.revalidate();
        jPanel1.repaint(); // Forzar actualización de la interfaz

    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void txtDetallenuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDetallenuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetallenuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
        // Validar campos obligatorios
        if (txtPago.getDate() == null) {
            mostrarError("La fecha de pago es requerida");
            return;
        }
        
        if (txtCantidadnuevo.getText().trim().isEmpty()) {
            mostrarError("El monto es requerido");
            return;
        }
        
        if (txtDetallenuevo.getText().trim().isEmpty()) {
            mostrarError("La descripción es requerida");
            return;
        }
        
        if (comboCategoria.getSelectedIndex() == 0) {
            mostrarError("Debe seleccionar una categoría");
            return;
        }

        // Obtener valores del formulario
        java.sql.Date fecha = new java.sql.Date(txtPago.getDate().getTime());
        double monto = Double.parseDouble(txtCantidadnuevo.getText().trim());
        String descripcion = txtDetallenuevo.getText();
        String categoria = comboCategoria.getSelectedItem().toString();

        // Insertar en la base de datos
        if (insertarEgreso(fecha, descripcion, monto, categoria, null, null)) {
            mostrarMensaje("Egreso registrado correctamente");
            this.dispose();
            
            
        } else {
            mostrarError("No se pudo registrar el egreso");
        }
    } catch (NumberFormatException e) {
        mostrarError("El monto debe ser un número válido");
    } catch (SQLException e) {
        mostrarError("Error de base de datos: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        mostrarError("Error inesperado: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnClienteN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteN1ActionPerformed
        proveedornuevo dialog = new proveedornuevo(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }//GEN-LAST:event_btnClienteN1ActionPerformed

    private void btnClienteNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteNActionPerformed
        nuevoMateriales dialog = new nuevoMateriales(new javax.swing.JFrame(), true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnClienteNActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void comboProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProveedorActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadActionPerformed
    private void cargarProveedores() {
        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT nombre FROM proveedor"); ResultSet rs = ps.executeQuery()) {

            // Limpiar ComboBox
            comboProveedor.removeAllItems();
            comboProveedor.addItem("Seleccione un Proveedor:");

            // Agregar proveedores
            while (rs.next()) {
                comboProveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            mostrarError("Error al cargar proveedores: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        formuEgresos1 dialog = new formuEgresos1(new javax.swing.JFrame(), true);
                        dialog.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al abrir el formulario: " + e.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnCancelar1;
    private RSMaterialComponent.RSButtonShape btnClienteN;
    private RSMaterialComponent.RSButtonShape btnClienteN1;
    private rojeru_san.RSButtonRiple btnGuardar;
    private RSMaterialComponent.RSComboBoxMaterial comboCategoria;
    private RSMaterialComponent.RSComboBoxMaterial comboProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private RSMaterialComponent.RSTextFieldMaterial txtCantidadnuevo;
    private RSMaterialComponent.RSTextFieldMaterial txtDetallenuevo;
    private com.toedter.calendar.JDateChooser txtPago;
    private RSMaterialComponent.RSTextFieldMaterial txtcantidad;
    // End of variables declaration//GEN-END:variables

    private boolean insertarEgreso(java.sql.Date fecha, String descripcion, Double monto, 
                             String categoria, String proveedor, List<String> productos) 
                             throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
        con = Conexion.getConnection();
        
        // Consulta SQL para insertar en la tabla caja
        String sql = "INSERT INTO caja (fecha, movimiento, monto, descripcion, categoria) " +
                    "VALUES (?, 'egreso', ?, ?, ?)";
        
        ps = con.prepareStatement(sql);
        ps.setDate(1, fecha);
        ps.setDouble(2, monto);
        ps.setString(3, descripcion);
        ps.setString(4, categoria);
        
        int resultado = ps.executeUpdate();
        
        return resultado > 0;
    } finally {
        // Cerrar recursos
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
}
    private int obtenerIdProveedor(Connection con, String nombreProveedor) throws SQLException {
        String sql = "SELECT id_proveedor FROM proveedor WHERE nombre = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_proveedor");
                }
            }
        }
        throw new SQLException("Proveedor no encontrado: " + nombreProveedor);
    }

    private int obtenerIdInventario(Connection con, String nombreProducto) throws SQLException {
        String sql = "SELECT id_inventario FROM inventario WHERE nombre = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_inventario");
                }
            }
        }
        throw new SQLException("Producto no encontrado: " + nombreProducto);
    }

    private boolean insertarEtapa(java.util.Date fecha, String descripcion, Double monto, String categoria) throws SQLException {
        String sql = "INSERT INTO caja (fecha, descripcion, monto, movimiento,categoria) VALUES (?, ?,?,'egreso',?)";

        try (Connection con = Conexion.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir java.util.Date a java.sql.Date
            ps.setDate(1, new java.sql.Date(fecha.getTime()));
            ps.setString(2, descripcion);

            // Usar setDouble para valores numéricos
            ps.setDouble(3, monto);
            ps.setString(4, categoria);

            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                mostrarMensaje("Registro guardado correctamente");
                return true;
            }
        } catch (SQLException e) {
            mostrarError("Error de base de datos: " + e.getMessage());
            throw e;  // Relanzar la excepción para manejo superior
        }
        return false;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);

    }

}
