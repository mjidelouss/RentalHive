package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.repositories.DemandeRepository;
import com.root.rentalheive.repositories.DevisRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DevisService {

    DevisRepository devisRepository;
    DemandeRepository demandeRepository;

    @Autowired
    public DevisService(DevisRepository devisRepository, DemandeRepository demandeRepository){
        this.devisRepository = devisRepository;
        this.demandeRepository = demandeRepository;
    }

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

    public void deleteDevis(@NotNull Long id) {
        Devis devis = devisRepository.findById(id).orElse(null);

        if (devis != null) {
            this.devisRepository.delete(devis);
        } else {
            throw new IllegalArgumentException("Devis not found for id: " + id);
        }
    }

}
