/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.constants.AppStatics;
import pe.com.veloz.domain.Role;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.domain.dto.UsuarioDTO;
import pe.com.veloz.service.RoleService;
import pe.com.veloz.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Usuario> allUsuarios() {
        return usuarioService.findUsuarios();
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveUsuario(@RequestBody UsuarioDTO data) {
        data.getUsuario().setAccountNonExpired(true);
        data.getUsuario().setAccountNonLocked(true);
        data.getUsuario().setCredentialsNonExpired(true);
        data.getUsuario().setEnabled(true);

        usuarioService.saveUsuario(data.getUsuario());

        for (Role role : data.getRoles()) {
            if (role.isStatus() == true) {
                role.setUsuario(data.getUsuario().getId());
                role.setEstado(AppStatics.STATUS_ACTIVE);
                roleService.saveRole(role);
            }
        }

    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void editUsuario(@RequestBody UsuarioDTO data) {
        usuarioService.updateUsuario(data.getUsuario());

        List<Role> rolesByUser = roleService.findRoleByUser(data.getUsuario().getId());
        List<Role> allRoles = roleService.findRoleAll();
        List<Role> rolesForRemove = new ArrayList<>();
        List<Role> rolesForInsert = new ArrayList<>();

        if (rolesByUser.isEmpty()) {
            rolesByUser = allRoles;
        }

        for (Role roleByUser : rolesByUser) {
            for (Role role : data.getRoles()) {
                if (role.getName().equals(roleByUser.getName())) {
                    if (role.isStatus() == false) {
                        rolesForRemove.add(role);
                    }
                } else if (role.isStatus() == true) {
                    rolesForInsert.add(role);
                }
            }
        }

        if (!rolesForRemove.isEmpty()) {
            for (Role role : rolesForRemove) {
                role.setEstado(AppStatics.STATUS_ACTIVE);
                roleService.removeRole(role);
            }
        }
        if (!rolesForInsert.isEmpty()) {
            for (Role role : rolesForInsert) {
                role.setEstado(AppStatics.STATUS_ACTIVE);
                role.setUsuario(data.getUsuario().getId());
                roleService.saveRole(role);
            }
        }

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeUsuario(@PathVariable Long id) {
        usuarioService.removeUsuario(id);
    }

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET)
    public Usuario findUsuario(@PathVariable Long id) {
        return usuarioService.findUsuarioById(id);
    }

    @RequestMapping(value = "/role/all", method = RequestMethod.GET)
    public List<Role> findRoleAll() {
        return roleService.findRoleAll();
    }

    @RequestMapping(value = "/role/{idUsuario}", method = RequestMethod.GET)
    public List<Role> findRoleByUser(@PathVariable Long idUsuario) {

        List<Role> allRoles = roleService.findRoleAll();
        List<Role> rolesByUser = roleService.findRoleByUser(idUsuario);
        List<Role> rolesForUpdate = new ArrayList<>();

        if (!rolesByUser.isEmpty()) {
            for (Role role : allRoles) {
                for (Role roleByUser : rolesByUser) {
                    if (role.getName().equals(roleByUser.getName())) {
                        role.setStatus(true);
                        role.setUsuario(roleByUser.getUsuario());
                    }
                    rolesForUpdate.add(role);
                }
            }
        } else {
            rolesForUpdate = allRoles;
        }

        Set set = new HashSet(rolesForUpdate);
        rolesForUpdate = new ArrayList<>(set);

        return rolesForUpdate;
    }
}
