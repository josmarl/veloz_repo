package pe.com.veloz.domain;

import java.io.Serializable;

public class ProductoUnidadMedida implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Long producto;
    private Long unidadMedida;
    private Double precio;
    private Producto productoObj;
    private UnidadMedida unidadMedidaObj;

    public ProductoUnidadMedida() {
    }

    public ProductoUnidadMedida(Long producto, Long unidadMedida, Double precio, Producto productoObj, UnidadMedida unidadMedidaObj) {
        this.producto = producto;
        this.unidadMedida = unidadMedida;
        this.precio = precio;
        this.productoObj = productoObj;
        this.unidadMedidaObj = unidadMedidaObj;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public Long getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(Long unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Producto getProductoObj() {
        return productoObj;
    }

    public void setProductoObj(Producto productoObj) {
        this.productoObj = productoObj;
    }

    public UnidadMedida getUnidadMedidaObj() {
        return unidadMedidaObj;
    }

    public void setUnidadMedidaObj(UnidadMedida unidadMedidaObj) {
        this.unidadMedidaObj = unidadMedidaObj;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ProductoUnidadMedida{" +
                "producto=" + producto +
                ", unidadMedida=" + unidadMedida +
                ", precio=" + precio +
                ", productoObj=" + productoObj +
                ", unidadMedidaObj=" + unidadMedidaObj +
                '}';
    }
}
