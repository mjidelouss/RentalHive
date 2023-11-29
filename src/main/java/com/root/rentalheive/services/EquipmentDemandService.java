package com.root.rentalheive.services;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.EquipmentDemand;

import java.util.Date;
public interface EquipmentDemandService {
    boolean isEquipmentAvailable(Date startDate, Date endDate, Long equipmentId);

    EquipmentDemand saveReservation(EquipmentDemand equipmentDemand);

    EquipmentDemand findEquipmentDemandByDemand(Demand demand);
}
