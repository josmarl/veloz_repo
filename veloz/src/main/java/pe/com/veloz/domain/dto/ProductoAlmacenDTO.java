/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import pe.com.veloz.domain.Producto;

/**
 * @author josmarl
 */
public class ProductoAlmacenDTO {

    private Producto producto;
    private Long cantidad;
    private double importe;

    public ProductoAlmacenDTO() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "ProductoAlmacenDTO{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", importe=" + importe +
                '}';
    }
}
