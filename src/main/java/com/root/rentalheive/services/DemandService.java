package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import org.springframework.stereotype.Service;

@Service
public interface DemandService {
    Demand save(Demand demand);
}
