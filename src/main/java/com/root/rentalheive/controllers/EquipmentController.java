package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.EquipmentDto;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.mappers.EquipmentMapper;
import com.root.rentalheive.services.EquipmentService;
import com.root.rentalheive.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/equipments")
public class EquipmentController {

    private final TypeService typeServices;

    private final EquipmentService equipmentServices;

    @GetMapping("")
    public ResponseEntity<List<Equipment>> getEquipments() {
        List<Equipment> equipmentList = equipmentServices.getEquipments();
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Equipment> getEquipment(@PathVariable String name) {
        Equipment equipment = equipmentServices.getEquipmentByName(name);
        return equipment != null
                ? new ResponseEntity<>(equipment, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<Equipment> addEquipment(@RequestBody EquipmentDto equipmentDto) {
        Type type = typeServices.findById(equipmentDto.getTypeId());
        Equipment equipment = EquipmentMapper.convertEquipmentDtoToEquipment(equipmentDto, type);

        Equipment savedEquipment = equipmentServices.saveEquipment(equipment);
        return new ResponseEntity<>(savedEquipment, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Equipment> updateEquipment(@RequestBody EquipmentDto equipmentDto) {
        Equipment equipment = equipmentServices.getEquipmentById(equipmentDto.getId());

        if (equipment != null) {
            equipment.setName(equipmentDto.getName());
            equipment.setType(typeServices.findById(equipmentDto.getTypeId()));

            Equipment updatedEquipment = equipmentServices.updateEquipment(equipment);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        Equipment equipment = equipmentServices.getEquipmentById(id);

        if (equipment != null) {
            equipmentServices.deleteEquipment(equipment);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
