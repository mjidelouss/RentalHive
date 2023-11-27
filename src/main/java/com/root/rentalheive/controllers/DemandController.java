package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.DemandDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.User;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.Impl.DemandServiceImpl;
import com.root.rentalheive.services.Impl.UserServiceImpl;
import com.root.rentalheive.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/demands")
public class DemandController {
    private final DemandService demandService;
    private final UserService userService;

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
