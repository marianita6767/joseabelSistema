/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author buitr
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre;
    private String correo_electronico;
    private String telefono;
    private String direccion;
    private int material;
    

    public Proveedor(int id_proveedor, String nombre, String telefono, String correo_electronico, String direccion, int material, String tipo) {
        this.id_proveedor = id_proveedor;
        this.nombre = nombre;
        this.correo_electronico =  correo_electronico;;
        this.telefono = telefono;
        this.direccion = direccion;
        this.material = material;
        
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public Proveedor() {
    }

    

  
}
