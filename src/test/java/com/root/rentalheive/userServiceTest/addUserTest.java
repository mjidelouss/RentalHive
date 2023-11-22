package com.root.rentalheive.userServiceTest;

import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.UserRepository;
import com.root.rentalheive.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class addUserTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void addUser() {
        User user = mock(User.class);
        when(userRepository.save(user)).thenReturn(user);
        assertNotNull(userService.addUser(user));
    }


}
