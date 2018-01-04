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
 * @author josmarl
 */
public class AlmacenConsolidado implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long producto;
    private Producto productoObj;
    private Long disponible;
    private Long vendido;

    public AlmacenConsolidado() {
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

    public Long getDisponible() {
        return disponible;
    }

    public void setDisponible(Long disponible) {
        this.disponible = disponible;
    }

    public Long getVendido() {
        return vendido;
    }

    public void setVendido(Long vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "AlmacenConsolidado{" + "id=" + id + ", producto=" + producto + ", productoObj=" + productoObj + ", disponible=" + disponible + ", vendido=" + vendido + '}';
    }

}
