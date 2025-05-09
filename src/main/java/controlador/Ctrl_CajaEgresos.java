/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Caja;
import modelo.Conexion;

/**
 *
 * @author ADSO
 */
public class Ctrl_CajaEgresos {
        
    private final String movimiento = "egreso";

    public boolean insertar(Caja caja) {
        String sql = "INSERT INTO caja (fecha, descripcion, monto, movimiento, Categoria_idCategoria) VALUES (?,?,?,?,?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, caja.getFecha());
            stmt.setString(2, caja.getDescripcion());
            stmt.setDouble(3, caja.getMonto());
            stmt.setString(4, movimiento);  // 👈 'egreso'
            stmt.setString(5, caja.getCategoria_idCategoria());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; 
        }
    }

   public List<Caja> obtenerEgresos() {
    List<Caja> lista = new ArrayList<>();
    String sql = "SELECT id_codigo, fecha, descripcion, monto, categoria  FROM caja WHERE movimiento = ? ";
    
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
        JOptionPane.showMessageDialog(null, "Error al obtener egresos: " + e.getMessage(), 
                                    "Error", JOptionPane.ERROR_MESSAGE);
    }
    return lista;
}

// Mejora el método actualizar con mensajes más descriptivos
public boolean actualizar(Caja caja) {
    String sql = "UPDATE caja SET fecha = ?, descripcion = ?, monto = ?, Categoria_idCategoria = ? WHERE id_codigo = ? AND movimiento = ?";
    
    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, caja.getFecha());
        stmt.setString(2, caja.getDescripcion());
        stmt.setDouble(3, caja.getMonto());
        stmt.setString(4,caja.getCategoria_idCategoria());
        stmt.setInt(5, caja.getId_codigo());
        stmt.setString(6, movimiento);
        
        
        int result = stmt.executeUpdate();
        if (result == 0) {
            JOptionPane.showMessageDialog(null, "No se encontró el egreso o no es de tipo 'egreso'", 
                                        "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        return result > 0;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar egreso: " + e.getMessage(), 
                                    "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}


    public boolean eliminar(int id_codigo) {
        String sql = "DELETE FROM caja WHERE id_codigo = ? AND movimiento = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id_codigo);
            stmt.setString(2, movimiento);  // 👈 Solo si es 'egreso'
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
