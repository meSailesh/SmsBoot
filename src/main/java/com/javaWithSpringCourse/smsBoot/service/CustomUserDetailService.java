package com.javaWithSpringCourse.smsBoot.service;

import com.javaWithSpringCourse.smsBoot.entity.User;
import com.javaWithSpringCourse.smsBoot.model.CustomUserDetails;
import com.javaWithSpringCourse.smsBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by sailesh on 1/26/22.
 */
public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException(("Username not found"));
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return customUserDetails;
    }
}
