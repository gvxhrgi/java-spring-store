package com.example.demo.controller;

import com.example.demo.models.user.UserRequest;
import com.example.demo.models.user.UserResponse;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponse view(@PathVariable("userId") Long userId) {
        return userService.view(userId);
    }

    @PostMapping
    public UserResponse create(@RequestBody @Valid UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
