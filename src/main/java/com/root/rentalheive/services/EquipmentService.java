package com.root.rentalheive.services;

import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.repositories.EquipmentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;

    public Equipment saveEquipment(@Valid Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(@Valid Equipment equipment) {
        if (equipment.getId() == null || !equipmentRepository.existsById(equipment.getId())) {
            throw new IllegalArgumentException("Equipment to update must have a valid ID and exist in the database.");
        }
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(@Valid Equipment equipment) {
        if (equipment.getId() == null || !equipmentRepository.existsById(equipment.getId())) {
            throw new IllegalArgumentException("Equipment to delete must have a valid ID and exist in the database.");
        }
        equipmentRepository.delete(equipment);
    }

    public List<Equipment> getEquipments() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentByName(String name) {
        return equipmentRepository.findByName(name);
    }

    public Equipment getEquipmentById(Long id) {
        if (id == null || !equipmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid Equipment ID or Equipment not found.");
        }
        return equipmentRepository.findById(id).orElse(null);
    }
}
