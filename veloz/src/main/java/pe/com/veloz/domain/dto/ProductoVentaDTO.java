/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import java.util.List;
import pe.com.veloz.domain.Producto;

/**
 *
 * @author josmarl
 */
public class ProductoVentaDTO {

    private Producto producto;
    private int cantidad;
    private double importe;

    public ProductoVentaDTO() {
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "ProductoVentaDTO{" + "producto=" + producto + ", cantidad=" + cantidad + ", importe=" + importe + '}';
    }

}
