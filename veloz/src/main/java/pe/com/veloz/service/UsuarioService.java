/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import pe.com.veloz.domain.Usuario;

public interface UsuarioService {

    List<Usuario> findUsuarios();

    void saveUsuario(Usuario usuario);

    void removeUsuario(Long id);

    void updateUsuario(Usuario usuario);

    Usuario findUsuarioById(Long id);

    Usuario validateUsuario(String usuario, String password);

    Usuario findUsuarioByUsername(String usuario);

}
