/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Random;

/**
 *
 * @author pc
 */
public class Produccion extends javax.swing.JPanel {

    /**
     * Creates new form Produccion
     */
    public Produccion() {
        initComponents();
        jScrollPane2.setVisible(false); // Ocultar la tabla 1 inicialmente
        jScrollPane3.setVisible(false); // Ocultar la tabla 1 inicialmente
        jScrollPane4.setVisible(false); // Ocultar la tabla 1 inicialmente
// Agregar DocumentListener a la barra de búsqueda
        rSTextFieldMaterialIcon1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTables();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTables();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTables();
            }
        });
    }
public void agregarFilaATabla2(String cantidad, String dimension, String material) {
    DefaultTableModel model = (DefaultTableModel) Tabla2.getModel();
    int newRowNum = model.getRowCount() + 1;  // Número secuencial
    
    model.addRow(new Object[]{
        newRowNum,      // Columna #
        generateRandomId(), // ID (si aplica)
        cantidad,    // Fecha inicio
        dimension,     // Fecha final
        material          // Estado
    });
    /*
    Tabla2.revalidate();
    Tabla2.repaint();
    */

    
    jScrollPane2.setVisible(false);
    jScrollPane3.setVisible(true);
    jScrollPane4.setVisible(false);
}
    public void agregarFilaATabla1(String fechaInicio, String fechaFinal, String estado) {
    DefaultTableModel model = (DefaultTableModel) Tabla1.getModel();
    int newRowNum = model.getRowCount() + 1;  // Número secuencial
    
    model.addRow(new Object[]{
        newRowNum,      // Columna #
        generateRandomId(), // ID (si aplica)
        fechaInicio,    // Fecha inicio
        fechaFinal,     // Fecha final
        estado          // Estado
    });
    Tabla1.revalidate();
    Tabla1.repaint();
    

    // Opcional: Mostrar Tabla1 automáticamente
    jScrollPane2.setVisible(true);
    jScrollPane3.setVisible(false);
    jScrollPane4.setVisible(false);
    
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        rSButtonFlat_new1 = new newscomponents.RSButtonFlat_new();
        rSButtonFlat_new2 = new newscomponents.RSButtonFlat_new();
        rSButtonFlat_new3 = new newscomponents.RSButtonFlat_new();
        rSButtonMaterialTwo3 = new RSMaterialComponent.RSButtonMaterialTwo();
        rSTextFieldMaterialIcon1 = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla1 = new RSMaterialComponent.RSTableMetroCustom();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla2 = new RSMaterialComponent.RSTableMetroCustom();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla3 = new RSMaterialComponent.RSTableMetroCustom();
        rSButtonMaterialTwo4 = new RSMaterialComponent.RSButtonMaterialTwo();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1290, 730));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 111, -1, -1));

        rSButtonFlat_new1.setBackground(new java.awt.Color(109, 160, 221));
        rSButtonFlat_new1.setText("Detalle produccion");
        rSButtonFlat_new1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonFlat_new1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonFlat_new1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 130, -1));

        rSButtonFlat_new2.setBackground(new java.awt.Color(109, 160, 221));
        rSButtonFlat_new2.setText("Etapa produccion");
        rSButtonFlat_new2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonFlat_new2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonFlat_new2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 126, -1));

        rSButtonFlat_new3.setBackground(new java.awt.Color(109, 160, 221));
        rSButtonFlat_new3.setText("Produccion");
        rSButtonFlat_new3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonFlat_new3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonFlat_new3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 91, -1));

        rSButtonMaterialTwo3.setBackground(new java.awt.Color(29, 30, 51));
        rSButtonMaterialTwo3.setBorder(null);
        rSButtonMaterialTwo3.setText("Nuevo+");
        rSButtonMaterialTwo3.setBackgroundHover(new java.awt.Color(29, 30, 31));
        rSButtonMaterialTwo3.setBorderPainted(false);
        rSButtonMaterialTwo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSButtonMaterialTwo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialTwo3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialTwo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 86, 37));

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
        jPanel1.add(rSTextFieldMaterialIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 28));

        Tabla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "43", "34/54/3", "45/85/6", "final"},
                {"2", "75", "78/45/23", "21/32/5", "proceso"},
                {"3", "45", "54/7/34", "36/98/7", "xd"},
                {"4", "73", "23/34/54", "23/43/23", "ya"},
                {"5", "67", "45/6/45", "34/58/3", "ok"}
            },
            new String [] {
                "#", "ID", "Fecha_inicio", "Fecha_final", "estado"
            }
        ));
        Tabla1.setBackgoundHead(new java.awt.Color(29, 30, 51));
        Tabla1.setBackgoundHover(new java.awt.Color(29, 30, 51));
        Tabla1.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        Tabla1.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        Tabla1.setSelectionBackground(new java.awt.Color(29, 30, 91));
        jScrollPane2.setViewportView(Tabla1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1220, 520));

        Tabla2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "43", "silla", "4"},
                {"2", "75", "mesa", "2"},
                {"3", "45", "mueble ", "3"},
                {"4", "73", "armario", "1"},
                {"5", "67", "cama", "1"}
            },
            new String [] {
                "#", "Cantidad", "Dimensiones ", "Materiales_usados"
            }
        ));
        Tabla2.setBackgoundHead(new java.awt.Color(29, 30, 51));
        Tabla2.setBackgoundHover(new java.awt.Color(29, 30, 51));
        Tabla2.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        Tabla2.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        Tabla2.setSelectionBackground(new java.awt.Color(29, 30, 91));
        jScrollPane3.setViewportView(Tabla2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1220, 520));

        Tabla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "43532", "silla", "Inicio", "43/65/24 ", "12/43/58"},
                {"2", "67864", "mesa", "Proceso", "54/23/65", "74/34/23"},
                {"3", "45683", "mueble ", "finalizando", "12/43/23", "96/23/28"},
                {"4", "73867", "armario", "Proceso", "95/34/50", "34/54/84"},
                {"5", "67594", "cama", "Terminado", "34/45/34", "84/34/39"}
            },
            new String [] {
                "#", "ID", "Nombre_etapa", "Estado", "Fecha_inicio", "Fecha_final"
            }
        ));
        Tabla3.setBackgoundHead(new java.awt.Color(29, 30, 51));
        Tabla3.setBackgoundHover(new java.awt.Color(29, 30, 51));
        Tabla3.setColorPrimaryText(new java.awt.Color(0, 0, 0));
        Tabla3.setColorSecundaryText(new java.awt.Color(0, 0, 0));
        Tabla3.setSelectionBackground(new java.awt.Color(29, 30, 91));
        jScrollPane4.setViewportView(Tabla3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 1220, 520));

        rSButtonMaterialTwo4.setBackground(new java.awt.Color(29, 30, 51));
        rSButtonMaterialTwo4.setBorder(null);
        rSButtonMaterialTwo4.setText("Eliminar -");
        rSButtonMaterialTwo4.setBackgroundHover(new java.awt.Color(29, 30, 31));
        rSButtonMaterialTwo4.setBorderPainted(false);
        rSButtonMaterialTwo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rSButtonMaterialTwo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMaterialTwo4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButtonMaterialTwo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 86, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1501, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1501, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSTextFieldMaterialIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSTextFieldMaterialIcon1ActionPerformed
        filterTables();
    }//GEN-LAST:event_rSTextFieldMaterialIcon1ActionPerformed

    private void rSButtonFlat_new3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonFlat_new3ActionPerformed

        jScrollPane3.setVisible(false); 
        jScrollPane4.setVisible(false); 
        jScrollPane2.setVisible(true); 


    }//GEN-LAST:event_rSButtonFlat_new3ActionPerformed

    private void rSButtonFlat_new1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonFlat_new1ActionPerformed

        jScrollPane2.setVisible(false); 
        jScrollPane4.setVisible(false); 
        jScrollPane3.setVisible(true); 
    }//GEN-LAST:event_rSButtonFlat_new1ActionPerformed

    private void rSButtonFlat_new2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonFlat_new2ActionPerformed

        jScrollPane2.setVisible(false); 
        jScrollPane3.setVisible(false); 
        jScrollPane4.setVisible(true);
    }//GEN-LAST:event_rSButtonFlat_new2ActionPerformed

    private void rSButtonMaterialTwo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialTwo3ActionPerformed
             
    tresProduccion dialog = new tresProduccion(new javax.swing.JFrame(), true, this);
    dialog.setLocationRelativeTo(null);
    dialog.setVisible(true);

    }//GEN-LAST:event_rSButtonMaterialTwo3ActionPerformed

    private void rSButtonMaterialTwo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMaterialTwo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMaterialTwo4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSTableMetroCustom Tabla1;
    private RSMaterialComponent.RSTableMetroCustom Tabla2;
    private RSMaterialComponent.RSTableMetroCustom Tabla3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private newscomponents.RSButtonFlat_new rSButtonFlat_new1;
    private newscomponents.RSButtonFlat_new rSButtonFlat_new2;
    private newscomponents.RSButtonFlat_new rSButtonFlat_new3;
    private RSMaterialComponent.RSButtonMaterialTwo rSButtonMaterialTwo3;
    private RSMaterialComponent.RSButtonMaterialTwo rSButtonMaterialTwo4;
    private RSMaterialComponent.RSTextFieldMaterialIcon rSTextFieldMaterialIcon1;
    // End of variables declaration//GEN-END:variables

    private int generateRandomId() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // Genera un número entre 10000 y 99999
    }

    private void filterTables() {
        String searchText = rSTextFieldMaterialIcon1.getText().toLowerCase(); // Obtener el texto de búsqueda

        // Filtrar cada tabla
        if (searchText.length() == 1) {
            // Filtrar por la columna "#" (índice 0)
            filterTable(Tabla1, searchText, 0); // Cambia 0 por el índice de la columna "#" en Tabla1
            filterTable(Tabla2, searchText, 0); // Cambia 0 por el índice de la columna "#" en Tabla2
            filterTable(Tabla3, searchText, 0); // Cambia 0 por el índice de la columna "#" en Tabla3
        } else if (searchText.length() >= 2) {
            // Filtrar en todas las columnas
            filterTable(Tabla1, searchText, -1); // Mostrar todas las filas en Tabla1
            filterTable(Tabla2, searchText, -1); // Mostrar todas las filas en Tabla2
            filterTable(Tabla3, searchText, -1); // Mostrar todas las filas en Tabla3
        } else {
            // Si no hay texto, mostrar todas las filas
            filterTable(Tabla1, "", -1); // Mostrar todas las filas en Tabla1
            filterTable(Tabla2, "", -1); // Mostrar todas las filas en Tabla2
            filterTable(Tabla3, "", -1); // Mostrar todas las filas en Tabla3
        }
    }

    private void filterTable(JTable table, String searchText, int columnIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // Obtener el modelo de la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model); // Crear un sorter para la tabla
        table.setRowSorter(sorter); // Establecer el sorter en la tabla

        // Filtrar las filas
        if (searchText.trim().isEmpty()) {
            sorter.setRowFilter(null); // Si no hay texto, mostrar todas las filas
        } else {
            // Filtrar en la columna especificada o en todas las columnas si columnIndex es -1
            if (columnIndex == -1) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText))); // Filtrar en todas las columnas
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText), columnIndex)); // Filtrar en la columna especificada
            }
        }
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    

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
}

