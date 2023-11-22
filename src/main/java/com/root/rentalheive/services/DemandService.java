package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.repositories.DemandeRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandService {
    DemandeRepository demandeRepository;
    DemandService(DemandeRepository demandeRepository){
        this.demandeRepository = demandeRepository;
    }
    public Demand save(Demand demand){
        return demandeRepository.save(demand);
    }
}
