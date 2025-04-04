
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Conexion;

public class Ctrl_Cliente {

    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "INSERT INTO cliente (nombre, apellido, identificacion, numero, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getIdentificacion());
            consulta.setString(4, objeto.getNumero());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e.getMessage());
        }

        return respuesta;
    }

    public Cliente obtenerClientePorid(int id_cliente) {
        Cliente cliente = null;
        Connection con = Conexion.getConnection();

        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, id_cliente);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setIdentificacion(rs.getString("identificacion"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
            }

            rs.close();
            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente: " + e.getMessage());
        }

        return cliente;
    }

    public boolean editar(Cliente objeto, int id_cliente) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, identificacion = ?, numero = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getIdentificacion());
            consulta.setString(4, objeto.getNumero());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, id_cliente);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar cliente: " + e.getMessage());
        }

        return respuesta;
    }

    public boolean eliminar(int id_cliente) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, id_cliente);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
        }

        return respuesta;
    }
    
    
    
    




      public DefaultTableModel buscarClientesPorFiltro(String filtro) {
        Connection con = Conexion.getConnection();
        DefaultTableModel modelo = new DefaultTableModel();

       
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Identificación");
        modelo.addColumn("Número");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");

        try {
            String sql = "SELECT * FROM cliente WHERE "
                    + "nombre LIKE ? OR "
                    + "apellido LIKE ? OR "
                    + "identificacion LIKE ? OR "
                    + "numero LIKE ? OR "
                    + "telefono LIKE ? OR "
                    + "direccion LIKE ?";

            PreparedStatement consulta = con.prepareStatement(sql);
            for (int i = 1; i <= 6; i++) {
                consulta.setString(i, "%" + filtro + "%");
            }

            ResultSet rs = consulta.executeQuery();

            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("identificacion"),
                    rs.getString("numero"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                });
            }

            rs.close();
            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente: " + e.getMessage());
        }

        return modelo;
    }

}
