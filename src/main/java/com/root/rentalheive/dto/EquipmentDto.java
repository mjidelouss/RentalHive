package com.root.rentalheive.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {

    @Nullable
    Long id;
    String name;
    Long typeId;

    public EquipmentDto(String name, Long id) {
        this.name = name;
        this.typeId = id;
    }
}
