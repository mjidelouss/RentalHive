package com.root.rentalheive.userServiceTest;

import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.UserRepository;
import com.root.rentalheive.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindUserTest {
    static UserService userService;
    static UserRepository userRepository;
    @BeforeAll
    public static void init() throws Exception{
//        userService = new UserService();
//        userRepository = mock(UserRepository.class);
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void findUserById1() {
        User user = User.builder()
                .id(1L)
                .name("test user")
                .build();
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        assertNotNull(userService.findUserById(1L).get());
    }
    @Test
    void findUserByIdIfNotExist() {

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        assertNull(userService.findUserById(1L).get());
    }

}
