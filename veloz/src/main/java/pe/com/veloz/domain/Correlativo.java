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
public class Correlativo implements Serializable, Cloneable {

    private Long id;
    private int serie;
    private int correlativo;
    private Long empresa;
    private Empresa empresaObj;
    private String estado;

    public Correlativo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public Long getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Long empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresaObj() {
        return empresaObj;
    }

    public void setEmpresaObj(Empresa empresaObj) {
        this.empresaObj = empresaObj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Correlativo{" + "id=" + id + ", serie=" + serie + ", correlativo=" + correlativo + ", empresa=" + empresa + ", empresaObj=" + empresaObj + ", estado=" + estado + '}';
    }

}
