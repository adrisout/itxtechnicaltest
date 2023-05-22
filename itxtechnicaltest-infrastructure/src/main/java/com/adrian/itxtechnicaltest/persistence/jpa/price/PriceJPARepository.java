package com.adrian.itxtechnicaltest.persistence.jpa.price;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceJPARepository extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT pe FROM PriceEntity pe " +
            "WHERE pe.productId = :productId " +
            "AND pe.brandId = :brandId " +
            "AND :date BETWEEN pe.startDate AND pe.endDate " +
            "AND pe.priority = (SELECT MAX(pe2.priority) FROM PriceEntity pe2 " +
            "                   WHERE pe2.productId = :productId " +
            "                   AND pe2.brandId = :brandId " +
            "                   AND :date BETWEEN pe2.startDate AND pe2.endDate)")
    PriceEntity findByProductId(
            @Param("productId") Integer productId, @Param("brandId") Integer brandId, @Param("date") LocalDateTime date);
}
