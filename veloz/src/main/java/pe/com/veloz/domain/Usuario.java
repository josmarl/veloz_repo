/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

/**
 *
 * @author server-itecs
 */
public class Usuario implements Serializable, Cloneable, UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    private Long persona;
    private Persona personaObj;
    private String estado;
    private Long empresa;
    private Empresa empresaObj;
    private Long authoritie;


    /* Spring Security fields*/
    private List<Role> authorities;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;

    public Usuario(Long id, String username, String password, Long persona, Persona personaObj, String estado, Long empresa, Empresa empresaObj, Long authoritie, List<Role> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.persona = persona;
        this.personaObj = personaObj;
        this.estado = estado;
        this.empresa = empresa;
        this.empresaObj = empresaObj;
        this.authoritie = authoritie;
        this.authorities = authorities;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getAuthoritie() {
        return authoritie;
    }

    public void setAuthoritie(Long authoritie) {
        this.authoritie = authoritie;
    }

    public Long getPersona() {
        return persona;
    }

    public void setPersona(Long persona) {
        this.persona = persona;
    }

    public Persona getPersonaObj() {
        return personaObj;
    }

    public void setPersonaObj(Persona personaObj) {
        this.personaObj = personaObj;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", password=" + password + ", persona=" + persona + ", personaObj=" + personaObj + ", estado=" + estado + ", empresa=" + empresa + ", empresaObj=" + empresaObj + ", authoritie=" + authoritie + ", authorities=" + authorities + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled + '}';
    }

}
