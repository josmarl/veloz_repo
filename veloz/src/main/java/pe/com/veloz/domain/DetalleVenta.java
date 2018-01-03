/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author server-itecs
 */
@Entity
public class DetalleVenta implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Producto productoObj;
    private Long producto;
    private int cantidad;
    private double importe;
    private Venta ventaObj;
    private Long venta;

    public DetalleVenta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProductoObj() {
        return productoObj;
    }

    public void setProductoObj(Producto productoObj) {
        this.productoObj = productoObj;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Venta getVentaObj() {
        return ventaObj;
    }

    public void setVentaObj(Venta ventaObj) {
        this.ventaObj = ventaObj;
    }

    public Long getVenta() {
        return venta;
    }

    public void setVenta(Long venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", productoObj=" + productoObj + ", producto=" + producto + ", cantidad=" + cantidad + ", importe=" + importe + ", ventaObj=" + ventaObj + ", venta=" + venta + '}';
    }

}
