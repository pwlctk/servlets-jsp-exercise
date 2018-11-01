package com.example.mvc.service;

import com.example.mvc.model.User;
import com.example.mvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = UserRepository.getInstance();
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public Optional<User> getUserByLoginData(String login, String password) {
        return userRepository.getUserByLoginData(login, password);
    }
}
