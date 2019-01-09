/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;

import pe.com.veloz.utils.AppUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author eddy
 */
public class Producto implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nombre;
    private String descripcion;
    private Long estado;
    private boolean estadoBoolean;
    private String marca;
    private String code;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEstadoBoolean() {
        return estadoBoolean;
    }

    public void setEstadoBoolean(boolean estadoBoolean) {
        this.estadoBoolean = estadoBoolean;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", estadoBoolean=" + estadoBoolean +
                ", marca='" + marca + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
