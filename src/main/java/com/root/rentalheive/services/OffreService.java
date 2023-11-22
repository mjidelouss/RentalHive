package com.root.rentalheive.services;

import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.repositories.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreService {
    OfferRepository offerRepository;
    public OffreService(OfferRepository offerRepository ) {
        this.offerRepository = offerRepository;
    }
    public List<Offer> getOffres(){
        return offerRepository.findAll();
    }
}
