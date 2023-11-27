package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.repositories.EquipmentDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EquipmentDemandServiceImpl {
    private final EquipmentDemandRepository equipmentDemandRepository;

    public boolean isEquipmentAvailable(Date startDate, Date endDate, Long equipmentId) {
        List<EquipmentDemand> overlappingDemands = equipmentDemandRepository.findOverlappingDemands(startDate, endDate, equipmentId);
        return overlappingDemands.isEmpty();
    }
}
