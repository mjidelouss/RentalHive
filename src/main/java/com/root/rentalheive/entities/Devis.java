package com.root.rentalheive.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Devis {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id ;
        @NotNull
        @NotEmpty
        private float price;
        @NotNull  @NotEmpty
        private boolean isAccepted;
        @NotNull @NotEmpty
        private Date startedDate;
        @NotBlank
        private Date endDate;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "demand_id")
        @JsonIgnore
        @NotNull @NotBlank @NotEmpty
        private Demand demand;

        @OneToOne
        @JoinColumn(name = "offer_id")
        @JsonIgnore
        @NotNull @NotBlank @NotEmpty
        private Offer offer;

        public Map<String, Object> toMap() {


                List<Map<String, Object>> equipmentsList = this.demand.getEquipmentDemands().stream().map(x->x.toMap()).collect(Collectors.toList());

                Map<String, Object> map = new HashMap<>();
                map.put("Equipment(s)", equipmentsList);
                map.put("Total price", this.price);
                map.put("Demand date", this.demand.getDemandedDate());
                map.put("Created date", this.startedDate);

                return map;
        }
}
