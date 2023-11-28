package com.root.rentalheive.dto;

import com.root.rentalheive.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevisDto {
    Long demand_id;
    Double totalPrice;
    Status status;
}
