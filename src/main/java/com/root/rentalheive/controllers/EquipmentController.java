package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.EquipmentDto;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.services.EquipmentService;
import com.root.rentalheive.services.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    TypeServices typeServices;

    EquipmentService equipmentServices;

    public EquipmentController(EquipmentService equipmentServices, TypeServices typeServices) {
        this.equipmentServices = equipmentServices;
        this.typeServices = typeServices;
    }

    @GetMapping("")
    public List<Equipment> getEquipments(){
        return equipmentServices.getEquipments();
    }
    @GetMapping("/{name}")
    public Equipment getEquipment(@PathVariable String name){
        return equipmentServices.getEquipmentByName(name);
    }

    @PostMapping("")
    public Equipment addEquipment(@RequestBody EquipmentDto equipmentDto){
        Equipment equipment=Equipment.builder()
                .name(equipmentDto.getName())
                .createdDate(Date.valueOf(LocalDate.now()))
                .type(typeServices.findById(equipmentDto.getTypeId()))
                .build();
        return equipmentServices.saveEquipment(equipment);
    }

    @PutMapping("")
    public Equipment updateEquipment(@RequestBody EquipmentDto equipmentdto){
        Equipment equipment=equipmentServices.getEquipmentById(equipmentdto.getId());
        equipment.setName(equipmentdto.getName());
        equipment.setType(typeServices.findById(equipmentdto.getTypeId()));
        return equipmentServices.updateEquipment(equipment);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id){
        equipmentServices.deleteEquipment(equipmentServices.getEquipmentById(id));
    }
}
