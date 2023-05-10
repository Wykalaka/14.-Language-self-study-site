package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;

import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/")
    public String addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return "User added!";
    }
}

