/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author eddy
 */
public class Almacen implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nroDoc;
    private Long usuario;
    private Usuario usuarioObj;
    private Long cliente;
    private Cliente clienteObj;
    private Date fechaReg;

    public Almacen() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(String nroDoc) {
        this.nroDoc = nroDoc;
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

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteObj() {
        return clienteObj;
    }

    public void setClienteObj(Cliente clienteObj) {
        this.clienteObj = clienteObj;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "Almacen{" + "id=" + id + ", nroDoc=" + nroDoc + ", usuario=" + usuario + ", usuarioObj=" + usuarioObj + ", cliente=" + cliente + ", clienteObj=" + clienteObj + ", fechaReg=" + fechaReg + '}';
    }

}
