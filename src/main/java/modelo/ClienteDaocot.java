package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDaocot {

    public int guardarCliente(Cliente cliente) {
        Connection cn = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int idGenerado = -1;

        String sql = "INSERT INTO cliente (identificacion, numero, nombre, apellido, telefono, direccion, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, 'temporal')";

        try {
            ps = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getIdentificacion());
            ps.setInt(2, cliente.getNumero());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getApellido());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getDireccion());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1); // Obtener el ID generado
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e.getMessage(), 
                                          "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idGenerado;
    }
}