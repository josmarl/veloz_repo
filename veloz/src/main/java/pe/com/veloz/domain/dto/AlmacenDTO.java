/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import java.util.List;
import pe.com.veloz.domain.Cliente;

/**
 *
 * @author josmarl
 */
public class AlmacenDTO {

    private Cliente cliente;
    private String nroDoc;
    private List<ProductoAlmacenDTO> detalles;

    public AlmacenDTO() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
    }

    public List<ProductoAlmacenDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoAlmacenDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "AlmacenDTO{" + "cliente=" + cliente + ", nroDoc=" + nroDoc + ", detalles=" + detalles + '}';
    }

}
