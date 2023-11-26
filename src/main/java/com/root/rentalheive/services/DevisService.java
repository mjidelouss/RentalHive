package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.repositories.DemandeRepository;
import com.root.rentalheive.repositories.DevisRepository;
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

    public List<Devis> getDevis(){return this.devisRepository.findAll();}

    public Devis saveDevis(Date date, float price, Long demand_id){
        Demand demand = this.demandeRepository.findById(demand_id).get();
        Devis devis = new Devis();
        devis.setDemand(demand);
        devis.setPrice(price);
        devis.setStartedDate(date);
        return this.devisRepository.save(devis);
    }

    public  void deleteDevis(Long id){
        Devis devis = this.devisRepository.findById(id).get();
        this.devisRepository.delete(devis);
    }


}
