package pe.com.veloz.domain.dto;

public class UnidadMedidaPrecioDTO {
    private Long id;
    private String nombre;
    private int cantidad;
    private String descripcion;
    private Long estado;
    private boolean estadoBoolean;
    private boolean estadoCheckbox;
    private Double precio;

    public UnidadMedidaPrecioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public boolean isEstadoBoolean() {
        return estadoBoolean;
    }

    public void setEstadoBoolean(boolean estadoBoolean) {
        this.estadoBoolean = estadoBoolean;
    }

    public boolean isEstadoCheckbox() {
        return estadoCheckbox;
    }

    public void setEstadoCheckbox(boolean estadoCheckbox) {
        this.estadoCheckbox = estadoCheckbox;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
