package com.pavlov.first_rest.controller;

import com.pavlov.first_rest.entry.User;
import com.pavlov.first_rest.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MainController {
    private final UserServiceImpl userServiceImp;

    @PostMapping()
    public void addUser(@RequestBody User user) {
        log.info("Add one new user: {}", userServiceImp.saveUser(user));
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userServiceImp.getUsers();
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable int id) {
        return userServiceImp.getUser(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable int id) {
        userServiceImp.deleteUser(id);
    }

    @PutMapping("{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User user) {
        return userServiceImp.updateUser(id, user);
    }
}
