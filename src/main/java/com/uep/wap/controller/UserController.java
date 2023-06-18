package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;

import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public String updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO) {
        userDTO.setU_id(id);
        userService.updateUser(userDTO);
        return "User updated!";
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "User deleted!";
    }

    @PostMapping("/users/{userId}/courses/{courseId}")
    public ResponseEntity<String> addCourseToUser(@PathVariable Integer userId, @PathVariable Integer courseId) {
        userService.addCourseToUser(userId, courseId);
        return ResponseEntity.ok("Course added to user");
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User loginUser) {
        User foundUser = userService.findByEmail(loginUser.getEmail());

        if (foundUser != null && loginUser.getPassword().equals(foundUser.getPassword())) {
            return ResponseEntity.ok(foundUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}

