package com.root.rentalheive.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class EquipmentDto {

    @Nullable
    Long id;
    String name;
    Long typeId;
}
