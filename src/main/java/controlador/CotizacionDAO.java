package controlador;

import modelo.Cotizacion;
import modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CotizacionDAO {

    public static int guardarCotizacion(Cotizacion cotizacion, DefaultTableModel modelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int guardarCotizaciones(List<Cotizacion> cotizaciones) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int idGenerado = -1;

        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false);

            String sql = "INSERT INTO cotizacion (...) VALUES (...)";
            pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            // Configurar parámetros y ejecutar batch...
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }

            con.commit();
            return idGenerado;
        } catch (SQLException e) {
            // Manejo de errores...
            return -1;
        } finally {
            // Cerrar recursos...
        }
    }

    public List<Object[]> obtenerCotizaciones() {
        List<Object[]> cotizaciones = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConnection();
            String sql = "SELECT c.id_cotizacion, c.fecha, CONCAT(cl.nombre, ' ', cl.apellido) AS cliente "
                    + "FROM cotizacion c "
                    + "LEFT JOIN cliente cl ON c.cliente_codigo = cl.codigo";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                cotizaciones.add(new Object[]{
                    rs.getInt("id_cotizacion"),
                    "Cotización " + rs.getInt("id_cotizacion"),
                    rs.getString("cliente"),
                    new java.text.SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("fecha")),
                    "Detalles",
                    ""
                });
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener cotizaciones: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al cargar las cotizaciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }
        return cotizaciones;
    }
}
