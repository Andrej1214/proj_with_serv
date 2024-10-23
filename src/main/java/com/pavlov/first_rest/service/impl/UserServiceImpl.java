package com.pavlov.first_rest.service.impl;

import com.pavlov.first_rest.entry.User;
import com.pavlov.first_rest.exception.CustomException;
import com.pavlov.first_rest.repository.UserRepo;
import com.pavlov.first_rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll().stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();
    }

    @Override
    public User getUser(int id) {
        return userRepo.findById(id).orElseGet(()->{
            String msg = "User with id=" + id + " not found";
            log.error(msg);
            throw new CustomException(msg);
        });
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(int id, User user) {
        if (!userRepo.existsById(id)) {
            throw new CustomException("User not found");
        }
        User u = new User(id, user.getName(), user.getAge());
        return userRepo.save(u);
    }

    @Override
    public void deleteUser(int id) {
        if (!userRepo.existsById(id)) {
            throw new CustomException("User not found");
        }
        userRepo.deleteById(id);
    }
}
