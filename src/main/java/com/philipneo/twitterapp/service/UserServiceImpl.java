package com.philipneo.twitterapp.service;

import com.philipneo.twitterapp.data.model.User;
import com.philipneo.twitterapp.data.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        // business logic for creating a user
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        // business logic for finding a user by username
        return userRepository.findByUsername(username);
    }
}
