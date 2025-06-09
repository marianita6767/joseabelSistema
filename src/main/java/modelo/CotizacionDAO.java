package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CotizacionDAO {

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
                pstmt.setInt(7, cot.getUsuarioIdUsuario());
                if (cot.getClienteCodigo() != null) {
                    pstmt.setInt(8, cot.getClienteCodigo());
                } else {
                    pstmt.setNull(8, Types.INTEGER);
                }
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
                cot.setUsuarioIdUsuario(rs.getInt("usuario_id_usuario"));
                cot.setClienteCodigo(rs.getInt("cliente_codigo") != 0 ? rs.getInt("cliente_codigo") : null);
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
        }
        return cotizaciones;
    }
}
