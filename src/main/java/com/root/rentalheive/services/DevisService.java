package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;

import java.util.Date;
import java.util.List;

public interface DevisService {
    List<Devis> getDevis();
    Devis saveDevis(Devis devis);
    boolean deleteDevis(Long id);
}
