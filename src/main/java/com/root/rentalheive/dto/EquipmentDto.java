package com.root.rentalheive.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto {

    @Nullable
    Long id;
    String name;
    Double price;
    Integer quantity;

    Long typeId;

    public EquipmentDto(String name, Long id, Double price, Integer quantity) {
        this.name = name;
        this.typeId = id;
        this.price = price;
        this.quantity = quantity;
    }
}
