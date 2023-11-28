package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.EquipmentDto;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.services.TypeService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Date;
import java.time.LocalDate;
public class EquipmentMapper {
    public static Equipment convertEquipmentDtoToEquipment(EquipmentDto equipmentDto, Type type) {
        return new Equipment().builder()
                .name(equipmentDto.getName())
                .createdDate(Date.valueOf(LocalDate.now()))
                .price(equipmentDto.getPrice())
                .quantity(equipmentDto.getQuantity())
                .type(type)
                .build();
    }
}
