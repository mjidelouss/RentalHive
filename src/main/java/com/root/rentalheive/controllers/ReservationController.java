package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.EquipmentDto;
import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.EquipmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    EquipmentService equipmentServices;
    DemandService demandService;

    public ReservationController(EquipmentService equipmentService, DemandService demandService) {
        this.equipmentServices = equipmentService;
        this.demandService = demandService;
    }

    @PostMapping("")
    public EquipmentDemand makeReservation(){

    }
}
