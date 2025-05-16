/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Caja;
import modelo.Conexion;
import vista.Produccionn.Error_id_;

/**
 *
 * @author ADSO
 */
public class Ctrl_CajaIngresos {
       /*
    private final String movimiento = "ingreso";
    
    public String[] obtenerCategoriasIngreso() {
        return new String[]{
            "Ventas", "Servicios", "Donaciones", "Préstamos",
            "Inversiones", "Subsidios", "Reembolsos", "Intereses",
            "Venta Activos", "Alquileres", "Comisiones", "Otros Ingresos"
        };
    }
    
    public boolean insertar(Caja caja) {
        String sql = "INSERT INTO caja (fecha, descripcion, monto, movimiento, categoria) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, caja.getFecha());
            stmt.setString(2, caja.getDescripcion());
            stmt.setDouble(3, caja.getMonto());
            stmt.setString(4, movimiento);
            stmt.setString(5, caja.getCategoria()); // 👈 'ingreso'
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

   public List<Caja> obtenerCategorias() {
    List<Caja> lista = new ArrayList<>();
    String sql = "SELECT * FROM caja WHERE movimiento = ?";
    try (Connection con = Conexion.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, movimiento);  // 👈 Solo 'ingreso'
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Caja(
                    rs.getInt("id_codigo"),
                    rs.getString("fecha"),
                    rs.getString("descripcion"),
                    rs.getDouble("monto"),
                    rs.getString("categoria")
                ));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

    public boolean actualizar(Caja caja) {
    String sql = "UPDATE caja SET fecha = ?, descripcion = ?, monto = ?, categoria = ? WHERE id_codigo = ? AND movimiento = ?";
    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, caja.getFecha());
        stmt.setString(2, caja.getDescripcion());
        stmt.setDouble(3, caja.getMonto());
        stmt.setString(4, caja.getCategoria()); // 👈 Corregido
        stmt.setInt(5, caja.getId_codigo());    // 👈 Corregido
        stmt.setString(6, movimiento);
        return stmt.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean eliminar(int id_codigo) {
        String sql = "DELETE FROM caja WHERE id_codigo = ? AND movimiento = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_codigo);
            stmt.setString(2, movimiento);  // 👈 Solo si es 'ingreso'
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }*/
     private final String movimiento = "ingreso";
    
    // Categorías específicas para ingresos (coinciden con el ENUM de la BD)
    public String[] obtenerCategoriasIngreso() {
        return new String[]{
            "Ventas", "Servicios", "Donaciones", "Préstamos", 
            "Inversiones", "Subsidios", "Reembolsos", "Intereses",
            "Venta Activos", "Alquileres", "Comisiones", "Otros Ingresos"
        };
    }
    
    public boolean insertar(Caja caja) {
        // Validar que la categoría pertenezca a ingresos
        if(!esCategoriaValida(caja.getCategoria())) {
            JOptionPane.showMessageDialog(null, 
                "Categoría no válida para ingresos", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String sql = "INSERT INTO caja (fecha, descripcion, monto, movimiento, categoria) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, caja.getFecha());
            stmt.setString(2, caja.getDescripcion());
            stmt.setDouble(3, caja.getMonto());
            stmt.setString(4, movimiento);
            stmt.setString(5, caja.getCategoria());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error al registrar ingreso: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Caja> obtenerIngresos() {
        List<Caja> lista = new ArrayList<>();
        String sql = "SELECT * FROM caja WHERE movimiento = ? ORDER BY fecha DESC";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, movimiento);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Caja(
                        rs.getInt("id_codigo"),
                        rs.getString("fecha"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getString("categoria")
                    ));
                }
            }
        } catch (Exception e) {
            mostrarError("Error al obtener ingresos: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Caja caja) {
        // Validar categoría antes de actualizar
        if(!esCategoriaValida(caja.getCategoria())) {
            mostrarError("Categoría no válida para ingresos");
            return false;
        }
        
        String sql = "UPDATE caja SET fecha = ?, descripcion = ?, monto = ?, categoria = ? WHERE id_codigo = ? AND movimiento = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, caja.getFecha());
            stmt.setString(2, caja.getDescripcion());
            stmt.setDouble(3, caja.getMonto());
            stmt.setString(4, caja.getCategoria());
            stmt.setInt(5, caja.getId_codigo());
            stmt.setString(6, movimiento);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            mostrarError("Error al actualizar ingreso: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id_codigo) {
        String sql = "DELETE FROM caja WHERE id_codigo = ? AND movimiento = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_codigo);
            stmt.setString(2, movimiento);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            mostrarError("Error al eliminar ingreso: " + e.getMessage());
            return false;
        }
    }
    
    // Método auxiliar para validar categorías de ingreso
    private boolean esCategoriaValida(String categoria) {
        for (String cat : obtenerCategoriasIngreso()) {
            if (cat.equals(categoria)) {
                return true;
            }
        }
        return false;
    }
    
    
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
