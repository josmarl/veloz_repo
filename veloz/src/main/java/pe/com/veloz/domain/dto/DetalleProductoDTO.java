/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import java.util.List;

/**
 *
 * @author josmarl
 */
public class DetalleProductoDTO {

    private List<ProductoVentaDTO> detalles;
    private double baseImponible;
    private double igv;
    private double total;

    public DetalleProductoDTO() {
    }

    public List<ProductoVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoVentaDTO> detalles) {
        this.detalles = detalles;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleProductoDTO{" + "detalles=" + detalles + ", baseImponible=" + baseImponible + ", igv=" + igv + ", total=" + total + '}';
    }

}
