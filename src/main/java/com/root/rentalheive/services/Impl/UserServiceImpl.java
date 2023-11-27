package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    public User getUserById(Long id){
        return userRepository.findUserById(id);
    }

    public Optional<User> findUserById(Long id) {
       return userRepository.findById(id);
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }
}
