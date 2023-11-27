package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.repositories.DemandeRepository;
import com.root.rentalheive.repositories.DevisRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DevisServiceImpl {

    private final DevisRepository devisRepository;
    private final DemandeRepository demandeRepository;

    public List<Devis> getDevis() {
        return this.devisRepository.findAll();
    }

    public Devis saveDevis(@NotNull Date date, @Positive float price, @NotNull Long demandId) {
        Demand demand = this.demandeRepository.findById(demandId).orElse(null);

        if (demand != null) {
            Devis devis = new Devis();
            devis.setDemand(demand);
            devis.setPrice(price);
            devis.setStartedDate(date);
            return this.devisRepository.save(devis);
        } else {
            throw new IllegalArgumentException("Demand not found for id: " + demandId);
        }
    }

    public boolean deleteDevis(@NotNull Long id) {
        Devis devis = devisRepository.findById(id).orElse(null);

        if (devis != null) {
            this.devisRepository.delete(devis);
            return true;
        } else {
            throw new IllegalArgumentException("Devis not found for id: " + id);
        }
    }

}
