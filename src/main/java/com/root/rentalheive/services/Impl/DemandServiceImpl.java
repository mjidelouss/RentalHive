package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.repositories.DemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class DemandServiceImpl {
    private final DemandeRepository demandeRepository;


}
