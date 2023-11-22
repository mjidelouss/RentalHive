package com.root.rentalheive.controllers;

import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.services.OffreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreController {
    OffreService offreService;
    public OffreController(OffreService offreService ) {
        this.offreService = offreService;
    }
    @GetMapping("")
    public List<Offer> getOffres(){
        return offreService.getOffres();
    }
}
