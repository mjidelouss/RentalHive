package com.root.rentalheive.repositories;

import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {
}
