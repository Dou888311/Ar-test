package com.Dou888311.ArtPlanTest.Config;

import com.Dou888311.ArtPlanTest.Entity.User;
import com.Dou888311.ArtPlanTest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional
                .ofNullable(userRepository.findUserByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return new UserDetailsImpl(user);
    }

}
