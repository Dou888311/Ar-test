package com.Dou888311.ArtPlanTest.Controller;

import com.Dou888311.ArtPlanTest.DTO.NameValidation;
import com.Dou888311.ArtPlanTest.Entity.User;
import com.Dou888311.ArtPlanTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/user/registration")
    public String registration(@RequestBody User user, HttpServletRequest request) {
        return userService.registration(user, request);
    }

    @PostMapping("/api/user/validation")
    public NameValidation nameValidation(@RequestBody NameValidation name, HttpServletRequest request) {
        return userService.nameValidation(name);
    }
}
