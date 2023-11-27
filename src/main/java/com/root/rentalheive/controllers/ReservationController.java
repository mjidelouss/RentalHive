package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.ReservationDto;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.EquipmentDemandService;
import com.root.rentalheive.services.EquipmentService;
import com.root.rentalheive.services.Impl.DemandServiceImpl;
import com.root.rentalheive.services.Impl.EquipmentDemandServiceImpl;
import com.root.rentalheive.services.Impl.EquipmentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
    private final EquipmentService equipmentService;
    private final EquipmentDemandService equipmentDemandService;
    private final DemandService demandService;

    @PostMapping("")
    public ResponseEntity<EquipmentDemand> makeReservation(@RequestBody @Valid ReservationDto reservationRequest) {
        try {
            Equipment equipment = equipmentService.getEquipmentById(reservationRequest.getEquipmentId());

            // Check if the equipment is available for the requested dates
            if (equipmentDemandService.isEquipmentAvailable(reservationRequest.getStartDate(), reservationRequest.getEndDate(), reservationRequest.getEquipmentId())) {

                // Check if the Requested Date is valid
                if (reservationRequest.getStartDate().toInstant().isBefore(Instant.now()) ||
                        reservationRequest.getEndDate().toInstant().isBefore(Instant.now())) {
                    return ResponseEntity.badRequest().body(null);
                }

                // Create EquipmentDemand and save the reservation
                EquipmentDemand equipmentDemand = new EquipmentDemand();
                equipmentDemand.setStartDate(reservationRequest.getStartDate());
                equipmentDemand.setEndDate(reservationRequest.getEndDate());
                equipmentDemand.setEquipment(equipment);


                EquipmentDemand savedReservation = equipmentService.saveReservation(equipmentDemand);

                return ResponseEntity.ok(savedReservation);

            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
