package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.User;
import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAllUsers();

    User getUser(Long id);

}
