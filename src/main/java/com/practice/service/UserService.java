package com.practice.service;

import com.practice.exception.UserNotFoundException;
import com.practice.model.User;
import com.practice.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(int id , User user){
        User preUser = getUser(id);
        preUser.setName(user.getName());
        preUser.setEmail(user.getEmail());
        preUser.setMobileNumber(user.getMobileNumber());

        return userRepository.update(preUser);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
