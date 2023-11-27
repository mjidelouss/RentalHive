package com.root.rentalheive.services;

import com.root.rentalheive.entities.Devis;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface DevisService {
    List<Devis> getDevis();

    Devis saveDevis(Date date, float price, Long demandId);

    boolean deleteDevis(long id);
}
