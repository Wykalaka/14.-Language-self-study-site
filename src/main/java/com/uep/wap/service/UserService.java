package com.uep.wap.service;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setFirst_Name(userDTO.getFirst_Name());
        user.setLast_Name(userDTO.getLast_Name());
        user.setDate_of_birth(userDTO.getDate_of_birth());
        user.setE_mail(userDTO.getE_mail());
        // Set other user properties as needed

        userRepository.save(user);
        System.out.println("User added!");
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Additional methods for user operations
}

