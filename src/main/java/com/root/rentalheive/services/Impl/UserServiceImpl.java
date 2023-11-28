package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.UserRepository;
import com.root.rentalheive.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

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
