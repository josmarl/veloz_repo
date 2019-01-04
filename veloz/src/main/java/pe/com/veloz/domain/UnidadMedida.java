package pe.com.veloz.domain;

import java.io.Serializable;

public class UnidadMedida implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private int cantidad;
    private String descripcion;
    private Long estado;

    public UnidadMedida() {
    }

    public UnidadMedida(Long id, String nombre, int cantidad, String descripcion, Long estado) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estado = estado;
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
}
