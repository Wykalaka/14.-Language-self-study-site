package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;

import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(path = "/{id}")
    public String updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        userDTO.setU_id(id);
        userService.updateUser(userDTO);
        return "User updated!";
    }
}

