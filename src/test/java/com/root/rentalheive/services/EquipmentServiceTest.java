package com.root.rentalheive.services;

import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.Type;
import com.root.rentalheive.repositories.EquipmentRepository;
import com.root.rentalheive.services.Impl.EquipmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class EquipmentServiceTest {

    @Mock
    private EquipmentRepository equipmentRepository;

    @InjectMocks
    private EquipmentServiceImpl equipmentServiceImpl;
    @Test
    void saveEquipment() {
        Type type = Type.builder()
                .id(1L)
                .name("test type")
                .build();
        Equipment equipment = Equipment.builder()
                .id(1L)
                .createdDate(Date.from(Instant.ofEpochSecond(System.currentTimeMillis())))
                .type(type)
                .name("test equipment")
                .build();
        Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);
        equipmentServiceImpl.saveEquipment(equipment);
        Mockito.verify(equipmentRepository).save(equipment);

    }

    @Test
    void updateEquipment() {
        Equipment equipment = new Equipment();
        equipment.setId(1L);
        equipment.setName("Updated Equipment");
        Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);
        equipmentServiceImpl.updateEquipment(equipment);
        Mockito.verify(equipmentRepository).save(equipment);
    }

    @Test
    void deleteEquipment() {
        Equipment equipment = new Equipment();
        equipment.setId(1L);
        Mockito.doNothing().when(equipmentRepository).delete(equipment);

        equipmentServiceImpl.deleteEquipment(equipment);

        Mockito.verify(equipmentRepository).delete(equipment);
    }

    @Test
    void getEquipments() {
        List<Equipment> equipments = new ArrayList<>();
        equipments.add(new Equipment());
        equipments.add(new Equipment());
        Mockito.when(equipmentRepository.findAll()).thenReturn(equipments);
        List<Equipment> retrievedEquipments = equipmentServiceImpl.getEquipments();
        assertEquals(equipments, retrievedEquipments);
    }
}