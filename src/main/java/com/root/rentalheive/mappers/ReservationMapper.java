package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.ReservationDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.EquipmentDemand;
import java.util.UUID;

public class ReservationMapper {
    public static EquipmentDemand convertReservationDtoToEquipmentDemand(ReservationDto reservationDto, Equipment equipment, Demand demand) {
        return new EquipmentDemand().builder()
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .equipment(equipment)
                .demand(demand)
                .matricule(UUID.randomUUID().toString())
                .build();
    }
}
