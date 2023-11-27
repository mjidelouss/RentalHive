package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.repositories.DemandeRepository;
import com.root.rentalheive.services.Impl.DemandServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DemandServiceTest {
    @Test
    public void nullFields() {
        DemandeRepository demandeRepository = mock(DemandeRepository.class);
        DemandServiceImpl demandServiceImpl = new DemandServiceImpl(demandeRepository);
        Demand demand = new Demand();
        demand.setUser(new User());
        assertEquals(demand, demandServiceImpl.save(demand));
    }
    @Test
    public void nullFields2() {
        DemandeRepository demandeRepository = mock(DemandeRepository.class);
        DemandServiceImpl demandServiceImpl = new DemandServiceImpl(demandeRepository);
        Demand demand = new Demand();
        demand.setDemandedDate(new Date());
        demand.setUser(new User());
        assertEquals(demand, demandServiceImpl.save(demand));

    }
}

