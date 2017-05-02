/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import java.util.List;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.domain.TipoComprobante;

/**
 *
 * @author josmarl
 */
public class VentaDTO {

    private double baseImponible;
    private double igv;
    private double total;
    private List<ProductoVentaDTO> detalles;
    private TipoComprobante tipoComprobante;
    private Cliente cliente;

    public VentaDTO() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public List<ProductoVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoVentaDTO> detalles) {
        this.detalles = detalles;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    @Override
    public String toString() {
        return "VentaDTO{" + "baseImponible=" + baseImponible + ", igv=" + igv + ", total=" + total + ", detalles=" + detalles + ", tipoComprobante=" + tipoComprobante + ", cliente=" + cliente + '}';
    }

}
