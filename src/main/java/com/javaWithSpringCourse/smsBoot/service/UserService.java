package com.javaWithSpringCourse.smsBoot.service;

import com.javaWithSpringCourse.smsBoot.entity.User;
import com.javaWithSpringCourse.smsBoot.model.UserDto;
import com.javaWithSpringCourse.smsBoot.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by sailesh on 1/26/22.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void register(UserDto userDto)  throws Exception{
        if(!userDto.getRePassword().equals(userDto.getPassword())) {
            throw new Exception("Password Miss match! Try again");
        }

        try{
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            String encodedPswd = encoder.encode(user.getPassword());
            user.setPassword(encodedPswd);
            userRepository.save(user);
        } catch (Exception e) {
            throw new Exception("User already Exists. Please login or try forget password");
        }
    }
}
