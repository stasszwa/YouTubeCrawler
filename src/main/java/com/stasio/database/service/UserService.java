package com.stasio.database.service;

import com.stasio.database.model.User;
import com.stasio.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public User getUserById(Long id) {
        System.err.println(userRepository.getUserById(id).toString());
        return userRepository.getUserById(id);
    }

    @Transactional
    public User getUserByName(String name) {
        System.err.println(userRepository.getUserByName(name).toString());
        return userRepository.getUserByName(name);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }


}
