package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.repositories.DevisRepository;
import com.root.rentalheive.repositories.OfferRepository;
import com.root.rentalheive.services.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    private final DevisRepository devisRepository;

    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Offer saveOffer(Long devisId) {
        Devis devis = devisRepository.findById(devisId).orElse(null);
        if (devis == null) {
            throw new IllegalArgumentException("Devis not found for id: " + devisId);
        }

        if (devis.getStatus().name().equals("ACCEPTED")) {
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
