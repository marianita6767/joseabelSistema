// Crear un nuevo DAO para pedido (PedidoDAO.java)
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;

public class PedidoDAO {
    public int guardarPedido(int clienteCodigo, int usuarioIdUsuario) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int idPedido = -1;

        try {
            con = Conexion.getConnection();
            con.setAutoCommit(false);

            String sql = "INSERT INTO pedido (cliente_codigo, usuario_id_usuario, fecha_pedido) VALUES (?, ?, NOW())";
            pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, clienteCodigo);
            pstmt.setInt(2, usuarioIdUsuario);
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }

            con.commit();
            return idPedido;

        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return -1;
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}