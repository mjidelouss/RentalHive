package com.root.rentalheive.mappers;

import com.root.rentalheive.dto.DevisDto;
import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;

public class DevisMapper {
    public static Devis convertDevisDtoToDevis(DevisDto devisDto, Demand demand) {
        return Devis.builder()
                .totalPrice(devisDto.getTotalPrice())
                .status(devisDto.getStatus())
                .demand(demand)
                .build();
    }
}
