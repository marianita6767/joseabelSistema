package controlador;

import modelo.Cliente;
import modelo.Cotizacion;
import controlador.Ctrl_Cliente;
import vista.Cotizacion.cotizacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_Cotizacion {
    private cotizacion vista;
    private CotizacionDAO cotizacionDAO;
    private Ctrl_Cliente clienteDAO;
    private static final int USUARIO_ID = 1; // ID de usuario por defecto

    public Ctrl_Cotizacion(cotizacion vista) {
        this.vista = vista;
        this.cotizacionDAO = new CotizacionDAO();
        this.clienteDAO = new Ctrl_Cliente();
    }

    public void guardarCotizacion(Integer clienteCodigo, DefaultTableModel modeloTabla, double totalGeneral) {
        if (modeloTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(vista, "No hay productos en la cotización", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (clienteCodigo == null) {
            JOptionPane.showMessageDialog(vista, "Por favor, seleccione o cree un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Cotizacion> cotizaciones = new ArrayList<>();
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            Cotizacion cot = new Cotizacion();
            cot.setDetalle(modeloTabla.getValueAt(i, 0).toString());
            cot.setUnidad(modeloTabla.getValueAt(i, 1).toString());
            cot.setCantidad(Integer.parseInt(modeloTabla.getValueAt(i, 2).toString()));
            String valorUnitarioStr = modeloTabla.getValueAt(i, 3).toString().replace("$", "").replace(",", "");
            cot.setValorUnitario(Integer.parseInt(valorUnitarioStr)); // Ajustado a int según Cotizacion.java
            String subtotalStr = modeloTabla.getValueAt(i, 4).toString().replace("$", "").replace(",", "");
            cot.setSubTotal(Double.parseDouble(subtotalStr));
            cot.setTotal(totalGeneral);

            cotizaciones.add(cot);
        }

        try {
            cotizacionDAO.guardarCotizaciones(cotizaciones);
            JOptionPane.showMessageDialog(vista, "Cotización guardada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.reiniciarCotizacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al guardar cotización: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public Integer buscarClientePorIdentificacion(String identificacion, int numero) {
        List<Cliente> clientes = clienteDAO.obtenerClientes();
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(identificacion) && cliente.getNumero() == numero) {
                return cliente.getid_cliente();
            }
        }
        return null;
    }
}