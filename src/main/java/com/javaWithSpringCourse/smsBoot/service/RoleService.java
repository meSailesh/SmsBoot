package com.javaWithSpringCourse.smsBoot.service;

import com.javaWithSpringCourse.smsBoot.entity.Role;
import com.javaWithSpringCourse.smsBoot.entity.User;
import com.javaWithSpringCourse.smsBoot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sailesh on 2/4/22.
 */
@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role) {
        Role role1 = roleRepository.save(role);
        System.out.println("role1 = " + role1);
        return role1;
    }

    public Role getRole(Integer roleId) {
        return roleRepository.findById(roleId).get();
    }
}
