package com.root.rentalheive.services;

import com.root.rentalheive.entities.Offer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {
    List<Offer> getOffers();

    Offer saveOffer(Long devisId);

    void deleteOffer(long id);
}
