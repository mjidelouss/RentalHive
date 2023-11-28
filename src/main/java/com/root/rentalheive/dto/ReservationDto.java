package com.root.rentalheive.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    DemandDto demandDto;
    Long equipmentId;
    Date startDate;
    Date endDate;
    Integer quantity;
    String matricule;
}
