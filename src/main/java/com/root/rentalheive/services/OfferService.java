package com.root.rentalheive.services;

import com.root.rentalheive.entities.Offer;
import java.util.List;
public interface OfferService {
    List<Offer> getOffers();

    Offer saveOffer(Long devisId);

    void deleteOffer(Long id);
}
