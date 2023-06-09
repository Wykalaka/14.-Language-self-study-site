package com.uep.wap.controller;

import com.uep.wap.dto.RoleDTO;
import com.uep.wap.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/role")
public class RoleController {


    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public String addRole(@RequestBody RoleDTO roleDTO) {
        roleService.addRole(roleDTO);
        return "Role added!";
    }

    @GetMapping
    public Iterable<com.uep.wap.model.Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping(path = "/{id}")
    public com.uep.wap.model.Role getRoleById(@PathVariable("id") Integer id) {
        return roleService.getRole(id);
    }

    @PutMapping(path = "/{id}")
    public String updateRole(@PathVariable("id") Integer id, @RequestBody RoleDTO roleDTO) {
        roleDTO.setR_id(id);
        roleService.updateRole(roleDTO);
        return "Role updated!";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteRole(id);
        return "Role deleted!";
    }
}
