package com.root.rentalheive.repositories;

import com.root.rentalheive.entities.Demand;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
//    @Query("SELECT r FROM EquipmentDemand r WHERE r.equipment.id = ?1 AND r.demand.devis.=true AND (r.startDate >= ?2 AND r.startDate <= ?3) OR (r.startDate <= ?2 AND r.endDate >= ?2)")
//    List<Devis> findAllCurrentRentalsByEquipment(Equipment equipment, Date startDate, Date endDate);
//    public List<Demand> findAvailableDemandesOnADante(Date startDate, Date endDate);
}
