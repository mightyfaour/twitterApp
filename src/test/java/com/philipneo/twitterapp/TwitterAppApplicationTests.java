package com.philipneo.twitterapp;

import com.philipneo.twitterapp.data.model.User;
import com.philipneo.twitterapp.data.repositories.UserRepository;
import com.philipneo.twitterapp.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreateUser() {
        // create a new user
        User newUser = new User(0011L, "johndoe@example.com", "password");

        // configure the UserRepository mock to return the new user when save() is called
        when(userRepository.save(any(User.class))).thenReturn(newUser);

        // call the createUser() method of the UserService implementation
        User savedUser = userService.createUser(newUser);

        // assert that the returned user matches the new user
        assertEquals(newUser, savedUser);

        // verify that the UserRepository save() method was called exactly once with the new user
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    public void testFindByUsername() {
        // create a new user with the username "johndoe"
        User newUser = new User( 0011L, "johndoe@example.com", "password");

        // configure the UserRepository mock to return the new user when findByUsername() is called with "johndoe"
        when(userRepository.findByUsername("johndoe")).thenReturn(newUser);

        // call the findByUsername() method of the UserService implementation with the username "johndoe"
        User foundUser = userService.findByUsername("johndoe");

        // assert that the returned user matches the new user
        assertEquals(newUser, foundUser);

        // verify that the UserRepository findByUsername() method was called exactly once with "johndoe"
        verify(userRepository, times(1)).findByUsername("johndoe");
    }
}
