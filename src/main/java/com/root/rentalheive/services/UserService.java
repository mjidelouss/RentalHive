package com.root.rentalheive.services;

import com.root.rentalheive.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(Long userId);
}
