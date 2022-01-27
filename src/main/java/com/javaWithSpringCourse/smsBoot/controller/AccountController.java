package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.User;
import com.javaWithSpringCourse.smsBoot.model.UserDto;
import com.javaWithSpringCourse.smsBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by sailesh on 1/26/22.
 */
@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model)  {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto user, Model model, RedirectAttributes redirectAttributes)  {
        try{
            userService.register(user);
            String successMessage = "You have signed up successfully, " + user.getFirstName() + "! Please login to continue";
            redirectAttributes.addFlashAttribute("message", successMessage);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "register";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model)  {
        model.addAttribute("user", new UserDto());
        return "login";
    }
}
