package pe.com.veloz.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Role;
import pe.com.veloz.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Role> findRoleAll() {
        return roleService.findRoleAll();
    }

}
