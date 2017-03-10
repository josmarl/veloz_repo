/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;

/**
 *
 * @author server-itecs
 */
public class Venta implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cliente;
    private Long usuario;
    private Usuario usuarioObj;

    public Venta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioObj() {
        return usuarioObj;
    }

    public void setUsuarioObj(Usuario usuarioObj) {
        this.usuarioObj = usuarioObj;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", cliente=" + cliente + ", usuario=" + usuario + ", usuarioObj=" + usuarioObj + '}';
    }

}
