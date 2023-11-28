package com.root.rentalheive.services.Impl;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.repositories.DemandeRepository;
import com.root.rentalheive.services.DemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemandServiceImpl implements DemandService {
    private final DemandeRepository demandeRepository;

    @Override
    public Demand save(Demand demand) {
        return demandeRepository.save(demand);
    }

    @Override
    public Demand getDemandById(Long demandId) {
        return demandeRepository.findDemandById(demandId);
    }
}
