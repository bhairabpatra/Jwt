package com.jwt.auth.Jwt.srvice;

import com.jwt.auth.Jwt.User;

public interface UserService {

    User createuser(User user);

    String login(User user);
}
