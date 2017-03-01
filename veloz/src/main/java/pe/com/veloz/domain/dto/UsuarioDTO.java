/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain.dto;

import java.util.List;
import pe.com.veloz.domain.Role;
import pe.com.veloz.domain.Usuario;

/**
 *
 * @author server-itecs
 */
public class UsuarioDTO {

    private Usuario usuario;
    private List<Role> roles;

    public UsuarioDTO() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "usuario=" + usuario + ", roles=" + roles + '}';
    }

}
