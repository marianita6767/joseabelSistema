package modelo;

public class Cotizacion {

    private int idCotizacion;
    private String detalle;
    private String unidad;
    private int cantidad;
    private double valorUnitario;
    private double subTotal;
    private double total;
    private int usuarioIdUsuario;
    private Integer clienteCodigo;

    public Cotizacion() {
    }

    public Cotizacion(String detalle, String unidad, int cantidad, double valorUnitario, double subTotal, double total, int usuarioIdUsuario, Integer clienteCodigo) {
        this.detalle = detalle;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.subTotal = subTotal;
        this.total = total;
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.clienteCodigo = clienteCodigo;
    }

    // Getters y Setters
    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public Integer getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Integer clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }
}
