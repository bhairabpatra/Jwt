package com.jwt.auth.Jwt.srvice;

import com.jwt.auth.Jwt.User;
import com.jwt.auth.Jwt.repository.UserRepository;
import com.jwt.auth.Jwt.security.JwtTokenProvider;
import com.jwt.auth.Jwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager securityConfig;
    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String login(User user) {
//        Authentication authentication = securityConfig.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = jwtTokenProvider.generateToken('authentication');

        return null;
    }
}
