package com.root.rentalheive.services;

import com.root.rentalheive.entities.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EquipmentService {
    List<Equipment> getEquipments();

    Equipment getEquipmentByName(String name);

    Equipment saveEquipment(Equipment equipment);

    Equipment getEquipmentById(Long id);

    Equipment updateEquipment(Equipment equipment);

    void deleteEquipment(Equipment equipment);
}
