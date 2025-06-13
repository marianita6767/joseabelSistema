package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Cotizacion;

public class CotizacionDAO {

    public static int guardarCotizacion(Cotizacion cotizacion, DefaultTableModel modelo) {
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int idCotizacion = -1;

        try {
            // Insertar la cotización
            String sql = "INSERT INTO cotizacion (detalle, total, usuario_id_usuario, cliente_codigo) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, cotizacion.getDetalle());
            pstmt.setDouble(2, cotizacion.getTotal());
           
 
            pstmt.executeUpdate();

            // Obtener el ID generado
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idCotizacion = rs.getInt(1);
            }

            // Insertar los productos en detalle_cotizacion
            sql = "INSERT INTO detalle_cotizacion (cotizacion_id, producto, unidad, cantidad, valor_unitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < modelo.getRowCount(); i++) {
                pstmt.setInt(1, idCotizacion);
                pstmt.setString(2, modelo.getValueAt(i, 0).toString()); // producto
                pstmt.setString(3, modelo.getValueAt(i, 1).toString()); // unidad
                pstmt.setInt(4, Integer.parseInt(modelo.getValueAt(i, 2).toString())); // cantidad
                pstmt.setDouble(5, Double.parseDouble(modelo.getValueAt(i, 3).toString().replace("$", "").replace(",", ""))); // valor_unitario
                pstmt.setDouble(6, Double.parseDouble(modelo.getValueAt(i, 4).toString().replace("$", "").replace(",", ""))); // subtotal
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            System.out.println("Error al guardar cotización: " + e.getMessage());
            return -1;
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar ResultSet: " + e.getMessage());
            }
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Connection: " + e.getMessage());
            }
        }
        return idCotizacion;
    }

    public void guardarCotizaciones(List<Cotizacion> cotizaciones) {
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO cotizacion (detalle, unidad, cantidad, valor_unitario, sub_total, total, usuario_id_usuario, cliente_codigo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            for (Cotizacion cot : cotizaciones) {
                pstmt.setString(1, cot.getDetalle());
                pstmt.setString(2, cot.getUnidad());
                pstmt.setInt(3, cot.getCantidad());
                pstmt.setDouble(4, cot.getValorUnitario());
                pstmt.setDouble(5, cot.getSubTotal());
                pstmt.setDouble(6, cot.getTotal());
                
                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            System.out.println("Error al guardar cotizaciones: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Connection: " + e.getMessage());
            }
        }
    }

    public Integer buscarClienteCodigo(String nombreCliente) {
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT codigo FROM cliente WHERE CONCAT(nombre, ' ', apellido) = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreCliente);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("codigo");
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar ResultSet: " + e.getMessage());
            }
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Connection: " + e.getMessage());
            }
        }
        return null;
    }

    public static List<Cotizacion> obtenerCotizaciones() {
        List<Cotizacion> cotizaciones = new ArrayList<>();
        Connection conn = Conexion.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT c.id_cotizacion, c.detalle, c.unidad, c.cantidad, c.valor_unitario, c.sub_total, c.total, "
                    + "c.usuario_id_usuario, c.cliente_codigo, CONCAT(cl.nombre, ' ', cl.apellido) AS cliente_nombre, c.fecha_creacion "
                    + "FROM cotizacion c LEFT JOIN cliente cl ON c.cliente_codigo = cl.codigo";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cotizacion cot = new Cotizacion();
                cot.setIdCotizacion(rs.getInt("id_cotizacion"));
                cot.setDetalle(rs.getString("detalle"));
                cot.setUnidad(rs.getString("unidad"));
                cot.setCantidad(rs.getInt("cantidad"));
                cot.setValorUnitario((int) rs.getDouble("valor_unitario"));
                cot.setSubTotal(rs.getDouble("sub_total"));
                cot.setTotal(rs.getDouble("total"));
                cotizaciones.add(cot);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cotizaciones: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar ResultSet: " + e.getMessage());
            }
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar Connection: " + e.getMessage());
            }
        }
        return cotizaciones;
    }
}