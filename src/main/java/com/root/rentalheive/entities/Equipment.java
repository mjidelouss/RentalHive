package com.root.rentalheive.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String name;
    @NotNull
    private Date createdDate;
    @NotNull
    private Double price;
    @NotNull
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

   @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
   private List<EquipmentDemand> equipmentDemands;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id) && Objects.equals(name, equipment.name) && Objects.equals(createdDate, equipment.createdDate) && Objects.equals(type, equipment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdDate, type);
    }
}
