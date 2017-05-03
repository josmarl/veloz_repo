/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import pe.com.veloz.domain.Producto;

/**
 *
 * @author josmarl
 */
public class ProductoAlmacenDTO {

    private Producto producto;
    private int cantidad;

    public ProductoAlmacenDTO() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoAlmacenDTO{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }

}
