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
public class TipoComprobante implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String codigo;
    private Long estado;

    public TipoComprobante(Long id, String nombre, String codigo, Long estado) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
    }

    public TipoComprobante() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoComprobante{" + "id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", estado=" + estado + '}';
    }

}
