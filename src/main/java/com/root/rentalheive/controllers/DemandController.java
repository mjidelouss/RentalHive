package com.root.rentalheive.controllers;

import com.root.rentalheive.dto.DemandDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.UserService;
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
    public Demand save(@RequestBody DemandDto demand){
        return demandService.save(Demand.builder().
                user(userService.getUserById(demand.getUserId())).
                DemandedDate(demand.getDemandedDate()).
                endDate(demand.getEndDate()
                ).build());
    }
}
