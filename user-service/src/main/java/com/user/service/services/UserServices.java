package com.user.service.services;

import com.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServices {

    // create user
    User createUser(User user);

    // get all user
    List<User> getAllUser();

    // get single user by id
    User getUserById(Long userId);

    // delete user
    void deleteUser(Long userId);

    // update user
    void updateUser(Long userId, User user);


}
