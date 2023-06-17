package com.uep.wap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.repository.RoleRepository;
import com.uep.wap.model.Role;
import com.uep.wap.dto.RoleDTO;
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void addRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setR_name(roleDTO.getR_name());
        roleRepository.save(role);
        System.out.println("Role added!");
    }

    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRole(Integer id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));
        return role;
    }

    public void updateRole(RoleDTO roleDTO) {
        Role role = roleRepository.findById(roleDTO.getR_id()).orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + roleDTO.getR_id()));
        role.setR_name(roleDTO.getR_name());
        roleRepository.save(role);
        System.out.println("Role updated!");
    }

    public void deleteRole(Integer id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + id));
        roleRepository.delete(role);
        System.out.println("Role deleted!");
    }


}
