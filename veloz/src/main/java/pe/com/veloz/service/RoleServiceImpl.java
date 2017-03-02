package pe.com.veloz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.constants.Roles;
import pe.com.veloz.domain.Role;
import pe.com.veloz.mapper.RoleMapper;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByUser(Long idUser) {
        return roleMapper.findRoleByUser(idUser);
    }

    @Override
    public List<Role> findRoleAll() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(0L, Roles.ADMIN.getRole()));
        roles.add(new Role(0L, Roles.USER.getRole()));
        return roles;
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.saveRole(role);
    }

    @Override
    public void removeRole(Role role) {
        roleMapper.removeRole(role);
    }

}
