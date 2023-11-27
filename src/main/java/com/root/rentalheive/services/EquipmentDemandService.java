package com.root.rentalheive.services;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface EquipmentDemandService {
    boolean isEquipmentAvailable(Date startDate, Date endDate, Long equipmentId);
}
