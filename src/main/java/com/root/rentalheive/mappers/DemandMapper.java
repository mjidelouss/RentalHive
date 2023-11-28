package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.DemandDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.enums.Status;

public class DemandMapper {
    public static Demand convertDemandDtoToDemand(DemandDto demandDto, User user) {
        return Demand.builder()
                .user(user)
                .status(Status.PENDING)
                .build();
    }
}
