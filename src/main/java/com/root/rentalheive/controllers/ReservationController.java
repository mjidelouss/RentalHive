package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.ReservationDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Equipment;
import com.root.rentalheive.entities.EquipmentDemand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.mappers.DemandMapper;
import com.root.rentalheive.mappers.ReservationMapper;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.EquipmentDemandService;
import com.root.rentalheive.services.EquipmentService;
import com.root.rentalheive.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<EquipmentDemand> makeReservation(@RequestBody @Valid ReservationDto reservationRequest) {
        try {
            Equipment equipment = equipmentService.getEquipmentById(reservationRequest.getEquipmentId());
            User user = userService.getUserById(reservationRequest.getDemandDto().getUserId());
            // Check if the equipment is available for the requested dates
            if (equipmentDemandService.isEquipmentAvailable(reservationRequest.getStartDate(), reservationRequest.getEndDate(), reservationRequest.getEquipmentId())) {
                // Check if the Requested Date is valid
                if (reservationRequest.getStartDate().toInstant().isBefore(Instant.now()) ||
                        reservationRequest.getEndDate().toInstant().isBefore(Instant.now())) {
                    return ResponseEntity.badRequest().body(null);
                }
                // Check The Quantity is Available
                if (!checkQuantity(reservationRequest.getQuantity(), equipment)) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                Demand demand = DemandMapper.convertDemandDtoToDemand(reservationRequest.getDemandDto(), user);
                Demand savedDemand = demandService.save(demand);
                EquipmentDemand equipmentDemand = ReservationMapper.convertReservationDtoToEquipmentDemand(reservationRequest, equipment, savedDemand);
                EquipmentDemand savedReservation = equipmentDemandService.saveReservation(equipmentDemand);
                return ResponseEntity.ok(savedReservation);

            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    public boolean checkQuantity(Integer quantity, Equipment equipment) {
        if (equipment.getQuantity() >= quantity) {
            return true;
        } else {
            return false;
        }
    }


}
