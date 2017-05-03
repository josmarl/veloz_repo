/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;

/**
 *
 * @author josmarl
 */
public class AlmacenDetalle implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long producto;
    private Producto productoObj;
    private Long cantidad;
    private Long almacen;
    private Almacen almacenObj;

    public AlmacenDetalle() {
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

    public Producto getProductoObj() {
        return productoObj;
    }

    public void setProductoObj(Producto productoObj) {
        this.productoObj = productoObj;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Long almacen) {
        this.almacen = almacen;
    }

    public Almacen getAlmacenObj() {
        return almacenObj;
    }

    public void setAlmacenObj(Almacen almacenObj) {
        this.almacenObj = almacenObj;
    }

    @Override
    public String toString() {
        return "AlmacenDetalle{" + "id=" + id + ", producto=" + producto + ", productoObj=" + productoObj + ", cantidad=" + cantidad + ", almacen=" + almacen + ", almacenObj=" + almacenObj + '}';
    }

}
