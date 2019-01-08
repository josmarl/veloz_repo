package pe.com.veloz.domain;

import java.io.Serializable;

public class ProductoUnidadMedida implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long producto;
    private Long unidadMedida;
    private Producto productoObj;
    private UnidadMedida unidadMedidaObj;

    public ProductoUnidadMedida() {
    }

    public ProductoUnidadMedida(Long id, Long producto, Long unidadMedida, Producto productoObj, UnidadMedida unidadMedidaObj) {
        this.id = id;
        this.producto = producto;
        this.unidadMedida = unidadMedida;
        this.productoObj = productoObj;
        this.unidadMedidaObj = unidadMedidaObj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ProductoUnidadMedida{" +
                "id=" + id +
                ", producto=" + producto +
                ", unidadMedida=" + unidadMedida +
                ", productoObj=" + productoObj +
                ", unidadMedidaObj=" + unidadMedidaObj +
                '}';
    }
}
