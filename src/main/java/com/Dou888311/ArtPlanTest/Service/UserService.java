package com.Dou888311.ArtPlanTest.Service;

import com.Dou888311.ArtPlanTest.DTO.NameValidation;
import com.Dou888311.ArtPlanTest.Entity.User;
import com.Dou888311.ArtPlanTest.Exceptions.UsernameAlreadyExists;
import com.Dou888311.ArtPlanTest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;

    public String registration(User user, HttpServletRequest request) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            setSession(user, request);
            return "Your user id is: " + user.getId();
        }
        throw new UsernameAlreadyExists("Current username is already taken");
    }

    public NameValidation nameValidation(NameValidation name) {
        boolean result = !userRepository.existsByUsername(name.getName());
        if (result) name.setAvailability("Available");
        else name.setAvailability("Not available");
        return name;
    }

    public void setSession(User user, HttpServletRequest request) {
        try {
            request.login(user.getUsername(), user.getPassword());
        } catch (ServletException e) {
            e.getStackTrace();
        }
    }
}
