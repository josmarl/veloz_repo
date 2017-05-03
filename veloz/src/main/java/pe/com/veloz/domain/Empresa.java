/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;

/**
 *
 * @author josmarl
 */
public class Empresa implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String razonSocial;
    private Long ruc;
    private Long serie;
    private String correlativo;
    private String direccion;
    private String owner;
    private Long tipo;

    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Long getRuc() {
        return ruc;
    }

    public void setRuc(Long ruc) {
        this.ruc = ruc;
    }

    public Long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", razonSocial=" + razonSocial + ", ruc=" + ruc + ", serie=" + serie + ", correlativo=" + correlativo + ", direccion=" + direccion + ", owner=" + owner + ", tipo=" + tipo + '}';
    }

}