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
public class ProductoVentaDTO {

    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private double importe;
    private Long unidadMedidadId;
    private String unidadMedidaNombre;
    private int cantidadStock;

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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Long getUnidadMedidadId() {
        return unidadMedidadId;
    }

    public void setUnidadMedidadId(Long unidadMedidadId) {
        this.unidadMedidadId = unidadMedidadId;
    }

    public String getUnidadMedidaNombre() {
        return unidadMedidaNombre;
    }

    public void setUnidadMedidaNombre(String unidadMedidaNombre) {
        this.unidadMedidaNombre = unidadMedidaNombre;
    }

    @Override
    public String toString() {
        return "ProductoVentaDTO{" +
                "producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", importe=" + importe +
                ", unidadMedidadId=" + unidadMedidadId +
                ", cantidadStock=" + cantidadStock +
                '}';
    }
}
