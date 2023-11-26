package com.root.rentalheive.services;

import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.repositories.EquipmentDemandRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EquipmentDemandService {
    EquipmentDemandRepository equipmentDemandRepository;

    public boolean isEquipmentAvailable(Date startDate, Date endDate, Long equipmentId) {
        List<EquipmentDemand> overlappingDemands = equipmentDemandRepository.findOverlappingDemands(startDate, endDate, equipmentId);
        return overlappingDemands.isEmpty();
    }
}
