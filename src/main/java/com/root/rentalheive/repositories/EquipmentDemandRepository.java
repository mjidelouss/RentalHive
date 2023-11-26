package com.root.rentalheive.repositories;

import com.root.rentalheive.entities.EquipmentDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EquipmentDemandRepository extends JpaRepository<EquipmentDemand, Long> {
    @Query("SELECT ed FROM EquipmentDemand ed " +
            "WHERE ed.equipment.id = :equipmentId " +
            "AND ((ed.startDate <= :endDate AND ed.endDate >= :startDate) OR " +
            "(ed.startDate <= :startDate AND ed.endDate >= :endDate))")
    List<EquipmentDemand> findOverlappingDemands(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("equipmentId") Long equipmentId);
}
