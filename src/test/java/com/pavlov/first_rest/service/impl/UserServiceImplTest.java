package com.pavlov.first_rest.service.impl;

import com.pavlov.first_rest.exception.CustomException;
import com.pavlov.first_rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    int id = 20;

    @Test
    void getUser() {
        var exception = assertThrows(CustomException.class,()->userService.getUser(id));
        assertEquals(exception.getMessage(),"User with id=" + id + " not found");
    }
}