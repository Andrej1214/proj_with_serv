package com.pavlov.first_rest.service;

import com.pavlov.first_rest.entry.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(int id);

    User saveUser(User user);

    void deleteUser(int id);
}
