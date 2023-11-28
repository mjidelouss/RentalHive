package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
public interface DemandService {
    Demand save(Demand demand);

    Demand getDemandById(Long demandId);
}
