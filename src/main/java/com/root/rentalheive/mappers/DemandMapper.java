package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.DemandDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;

public class DemandMapper {
    public static Demand convertDemandDtoToDemand(DemandDto demandDto, User user) {
        return new Demand().builder()
                .user(user)
                .DemandedDate(demandDto.getDemandedDate())
                .endDate(demandDto.getEndDate())
                .build();
    }
}
