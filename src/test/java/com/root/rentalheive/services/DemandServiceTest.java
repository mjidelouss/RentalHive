package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.DemandeRepository;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DemandServiceTest {
    @Test
    public void nullFields() {
        DemandeRepository demandeRepository = mock(DemandeRepository.class);
        DemandService demandService = new DemandService(demandeRepository);
        Demand demand = new Demand();
        demand.setUser(new User());
        assertEquals(demand, demandService.save(demand));
    }
    @Test
    public void nullFields2() {
        DemandeRepository demandeRepository = mock(DemandeRepository.class);
        DemandService demandService = new DemandService(demandeRepository);
        Demand demand = new Demand();
        demand.setDemandedDate(new Date());
        demand.setUser(new User());
        assertEquals(demand, demandService.save(demand));

    }
}

