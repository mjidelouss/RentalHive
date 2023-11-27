package com.root.rentalheive.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @JsonProperty("DemandedDate")
    @NotNull
    @NotBlank
    @NotEmpty
    private Date DemandedDate;

    @Nullable
    @JsonProperty("endDate")
    private Date endDate;

    @OneToMany(mappedBy = "demand", cascade = CascadeType.ALL)
    @JsonIgnore
    @NotNull @NotBlank @NotEmpty
    private List<Devis> devis;

    @OneToMany(mappedBy = "demand", cascade = CascadeType.ALL)
    @JsonIgnore
    @NotNull @NotBlank @NotEmpty
    private List<EquipmentDemand> equipmentDemands;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull @NotBlank @NotEmpty
    private User user;



}
