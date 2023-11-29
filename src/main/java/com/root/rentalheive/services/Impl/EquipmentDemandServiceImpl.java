package com.root.rentalheive.services.Impl;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.repositories.EquipmentDemandRepository;
import com.root.rentalheive.services.EquipmentDemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentDemandServiceImpl implements EquipmentDemandService {
    private final EquipmentDemandRepository equipmentDemandRepository;

    public boolean isEquipmentAvailable(Date startDate, Date endDate, Long equipmentId) {
        List<EquipmentDemand> overlappingDemands = equipmentDemandRepository.findOverlappingDemands(startDate, endDate, equipmentId);
        return overlappingDemands.isEmpty();
    }

    public EquipmentDemand saveReservation(EquipmentDemand equipmentDemand) {
        return equipmentDemandRepository.save(equipmentDemand);
    }

    @Override
    public EquipmentDemand findEquipmentDemandByDemand(Demand demand) {
        return equipmentDemandRepository.findEquipmentDemandByDemand(demand);
    }
}
