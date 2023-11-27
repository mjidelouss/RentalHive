package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.EquipmentDto;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.services.TypeService;


import java.sql.Date;
import java.time.LocalDate;
public class EquipmentMapper {
    private static TypeService typeService;
    public static Equipment convertEquipmentDtoToEquipment(EquipmentDto equipmentDto) {
        return new Equipment().builder()
                .name(equipmentDto.getName())
                .createdDate(Date.valueOf(LocalDate.now()))
                .type(typeService.findById(equipmentDto.getTypeId()))
                .build();
    }
    public static EquipmentDto   convertEquipmentToEquipmentDto(Equipment equipment){
        return  new EquipmentDto(equipment.getName(),equipment.getType().getId());
    }
}
