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

    public DetalleProductoDTO() {
    }

    public List<ProductoVentaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoVentaDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "DetalleProductoDTO{" + "detalles=" + detalles + '}';
    }

}
