package com.jwt.auth.Jwt.controller;


import com.jwt.auth.Jwt.User;
import com.jwt.auth.Jwt.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createuser(user);
                return new ResponseEntity<>(newUser , HttpStatus.CREATED);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        String newUser = userService.login(user);
        return newUser;
    }
}
