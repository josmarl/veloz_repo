package pe.com.veloz.service;

import java.util.List;
import pe.com.veloz.domain.Role;

public interface RoleService {

    List<Role> findRoleByUser(Long idUser);

    List<Role> findRoleAll();

    void saveRole(Role role);

    void removeRole(Role role);

}
