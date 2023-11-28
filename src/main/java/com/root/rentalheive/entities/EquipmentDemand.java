package com.root.rentalheive.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EquipmentDemand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private Date startDate;

    @Nullable
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    @NotBlank
    private Equipment equipment;
    @NotBlank
    private String matricule;

    @ManyToOne
    @JoinColumn(name = "demand_id")
    @NotBlank
    private Demand demand;

    public Map<String, Object> toMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("Name", this.getEquipment().getName());
        map.put("Type", this.getEquipment().getType().getName());

        return map;
    }
}
