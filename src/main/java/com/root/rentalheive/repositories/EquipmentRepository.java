package com.root.rentalheive.repositories;

import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Equipment findByName(String name);
}
