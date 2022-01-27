package com.javaWithSpringCourse.smsBoot.repository;

import com.javaWithSpringCourse.smsBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sailesh on 1/26/22.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
