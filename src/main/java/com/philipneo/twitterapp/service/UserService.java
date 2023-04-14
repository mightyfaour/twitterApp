package com.philipneo.twitterapp.service;

import com.philipneo.twitterapp.data.model.User;

public interface UserService {
    User createUser(User user);
    User findByUsername(String username);
}
