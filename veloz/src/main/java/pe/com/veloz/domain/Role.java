/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author server-itecs
 */
public class Role implements Serializable, Cloneable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Usuario usuarioObj;
    private Long usuario;
    private int estado;
    private boolean status;

    @Override
    public String getAuthority() {
        return this.name;
    }

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Usuario getUsuarioObj() {
        return usuarioObj;
    }

    public void setUsuarioObj(Usuario usuarioObj) {
        this.usuarioObj = usuarioObj;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name=" + name + ", usuarioObj=" + usuarioObj + ", usuario=" + usuario + ", estado=" + estado + ", status=" + status + '}';
    }

}
