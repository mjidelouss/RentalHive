package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.DemandDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demands")
public class DemandController {
    DemandService demandService;
    UserService userService;
    public DemandController(DemandService demandService, UserService userService){
        this.demandService = demandService;
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<Demand> save(@RequestBody DemandDto demandDto) {
        User user = userService.getUserById(demandDto.getUserId());

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Demand demand = Demand.builder()
                .user(user)
                .DemandedDate(demandDto.getDemandedDate())
                .endDate(demandDto.getEndDate())
                .build();

        Demand savedDemand = demandService.save(demand);

        return new ResponseEntity<>(savedDemand, HttpStatus.CREATED);
    }
}
