package controlador;

import modelo.Cliente;
import modelo.ClienteDaocot;
import javax.swing.JOptionPane;

public class Ctrl_ClienteCot {
    private ClienteDaocot clienteDAO;

    public Ctrl_ClienteCot() {
        this.clienteDAO = new ClienteDaocot();
    }

    public int guardarCliente(Cliente cliente) {
        // Validar datos
        if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() ||
            cliente.getIdentificacion().equals("Tipo de identificacion:") ||
            cliente.getNumero() <= 0 || cliente.getTelefono().isEmpty() ||
            cliente.getDireccion().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos del cliente", 
                                          "Error", JOptionPane.WARNING_MESSAGE);
            return -1;
        }

        return clienteDAO.guardarCliente(cliente);
    }
}