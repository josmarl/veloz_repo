/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.mapper.UsuarioMapper;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<Usuario> findUsuarios() {
        return usuarioMapper.findUsuarios();
    }

    @Override
    public void removeUsuario(Long id) {
        usuarioMapper.removeUsuario(id);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        usuarioMapper.updateUsuario(usuario);
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return usuarioMapper.findUsuarioById(id);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioMapper.saveUsuario(usuario);
    }

    @Override
    public Usuario validateUsuario(String usuario, String password) {
        return usuarioMapper.validateUsuario(usuario, password);
    }

    @Override
    public Usuario findUsuarioByUsername(String usuario) {
        return usuarioMapper.findUsuarioByUsername(usuario);
    }

}
