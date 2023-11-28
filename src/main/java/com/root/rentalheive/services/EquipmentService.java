package com.root.rentalheive.services;

import com.root.rentalheive.entities.Equipment;
import java.util.List;

public interface EquipmentService {
    List<Equipment> getEquipments();

    Equipment getEquipmentByName(String name);

    Equipment saveEquipment(Equipment equipment);

    Equipment getEquipmentById(Long id);

    Equipment updateEquipment(Equipment equipment);

    void deleteEquipment(Equipment equipment);
}
