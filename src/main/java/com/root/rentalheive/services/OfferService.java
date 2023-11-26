package com.root.rentalheive.services;

import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.repositories.DevisRepository;
import com.root.rentalheive.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    OfferRepository offerRepository;

    DevisRepository devisRepository;
    @Autowired
    public OfferService(OfferRepository offerRepository, DevisRepository devisRepository){
        this.offerRepository = offerRepository;
        this.devisRepository = devisRepository;
    }

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer saveOffer(Long devisId) {
        Devis devis = devisRepository.findById(devisId).orElse(null);
        if (devis == null) {
            throw new IllegalArgumentException("Devis not found for id: " + devisId);
        }

        if (!devis.isAccepted()) {
            throw new IllegalStateException("Cannot create offer for non-accepted Devis.");
        }

        Offer offer = new Offer();
        offer.setDevis(devis);
        return offerRepository.save(offer);
    }

    public void deleteOffer(Long id) {
        Offer offer = offerRepository.findById(id).orElse(null);

        if (offer == null) {
            throw new IllegalArgumentException("Offer not found for id: " + id);
        }
        offerRepository.delete(offer);
    }

}
