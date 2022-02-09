package com.javaWithSpringCourse.smsBoot.repository;

import com.javaWithSpringCourse.smsBoot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sailesh on 2/4/22.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
