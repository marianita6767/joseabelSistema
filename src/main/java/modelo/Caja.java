/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author ADSO
 */
public class Caja {
    
    private int id_codigo;
    private String fecha;
    private String descripcion;
    private Double monto;
    private String Categoria_idCategoria;

    public Caja(String fecha, String descripcion, Double monto, String Categoria_idCategoria) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.Categoria_idCategoria = Categoria_idCategoria;
    }

    public Caja(int id_codigo, String fecha, String descripcion, Double monto, String Categoria_idCategoria) {
        this.id_codigo = id_codigo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.Categoria_idCategoria = Categoria_idCategoria;
    }

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getCategoria_idCategoria() {
        return Categoria_idCategoria;
    }

    public void setCategoria_idCategoria(String Categoria_idCategoria) {
        this.Categoria_idCategoria = Categoria_idCategoria;
    }

   
    
    

}
