package com.root.rentalheive.repositories;

import com.root.rentalheive.entities.Type;
import com.root.rentalheive.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findByName(String name);
}
