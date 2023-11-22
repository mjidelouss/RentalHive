package com.root.rentalheive.services;

import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment saveEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Equipment equipment){
        equipmentRepository.delete(equipment);
    }
    public List<Equipment> getEquipments(){
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentByName(String name){
        return equipmentRepository.findByName(name);
    }

    public Equipment getEquipmentById(Long id){
        return equipmentRepository.findById(id).get();
    }
}
