/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Proveedor;

/**
 *
 * @author Personal
 */
public class Ctrl_Proveedor {
    public boolean guardar(Proveedor objeto) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "INSERT INTO Proveedor (nombre, apellido, identificacion, numero, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getCorreo_electronico());
            consulta.setString(3, objeto.getTelefono());
            consulta.setString(3, objeto.getDireccion());
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar proveedor: " + e.getMessage());
        }

        return respuesta;
    }

    public Proveedor obtenerClientePorid(int id_proveedor) {
        Proveedor proveedor = null;
        Connection con = Conexion.getConnection();

        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, id_proveedor);

            ResultSet rs = consulta.executeQuery();

            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setCorreo_electronico(rs.getString("correo_electronico"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setDireccion(rs.getString("direccion"));
            }

            rs.close();
            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener proveedor: " + e.getMessage());
        }

        return proveedor;
    }

    public boolean editar(Proveedor objeto, int id_proveedor) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, identificacion = ?, numero = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);

            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getCorreo_electronico());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, id_proveedor);

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

    public boolean eliminar(int id_proveedor) {
        boolean respuesta = false;
        Connection con = Conexion.getConnection();

        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement consulta = con.prepareStatement(sql);
            consulta.setInt(1, id_proveedor);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar proveedor: " + e.getMessage());
        }

        return respuesta;
    }
    
    
   
      public DefaultTableModel buscarClientesPorFiltro(String filtro) {
        Connection con = Conexion.getConnection();
        DefaultTableModel modelo = new DefaultTableModel();

       
        modelo.addColumn("codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo electronico");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Dirección");

        try {
            String sql = "SELECT * FROM ´proveedor WHERE "
                    + "nombre LIKE ? OR "
                    
                  
                  
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
                    rs.getString("correo_electronico"),
                  
                    rs.getString("telefono"),
                    rs.getString("direccion")
                });
            }

            rs.close();
            consulta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar proveedor: " + e.getMessage());
        }

        return modelo;
    }
}
