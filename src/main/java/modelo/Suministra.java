/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Brashan
 */
public class Suministra {
    
    private int idSuministra; 
    private int idInventario; // Clave foránea a la tabla inventario
    private int id_proveedor;

    public Suministra() {
    }

    public Suministra(int idSuministra, int id_Inventario, int id_proveedor) {
        this.idSuministra = idSuministra;
        this.idInventario = idInventario;
        this.id_proveedor = id_proveedor;
    }

    public int getIdSuministra() {
        return idSuministra;
    }

    public void setIdSuministra(int idSuministra) {
        this.idSuministra = idSuministra;
    }

    public int getId_Inventario() {
        return idInventario;
    }

    public void setId_Inventario(int id_Inventario) {
        this.idInventario = id_Inventario;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    
    
    
    
}
