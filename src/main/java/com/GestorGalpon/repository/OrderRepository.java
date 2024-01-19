package com.GestorGalpon.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GestorGalpon.models.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

    @Query("SELECT o FROM Order o WHERE o.isPresent = true")
    List<Order> findAllOrderAvailable();

   @Modifying
    @Query("UPDATE order o SET o.isPresent = :isPresent WHERE o.id = :id")

    Optional<Order> updateIsPresent(@Param ("id") Long orderId, @Param("isPresent") Boolean isPresent);


}
