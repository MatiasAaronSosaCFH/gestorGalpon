package com.GestorGalpon.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.GestorGalpon.models.orderdetails.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{

  
    @Modifying
    @Query("UPDATE OrderDetail od SET od.itemsNumber = :itemsNumber, od.updateAt = :upDate WHERE od.id = :id and od.isPresent = true")
    Optional<OrderDetail> updateOrderDetail(@Param("id") Long orderDetailId,@Param("itemsNumber") Integer itemsNumber,@Param("upDate") Date date);

   @Modifying
   @Query("UPDATE OrderDetail od SET od.isPresent = :isPresent WHERE od.id = :id")
   Optional<OrderDetail> updateIsPresent(@Param("id") Long id,@Param("isPresent") Boolean isPresent);

   @Modifying
   @Query("UPDATE OrderDetail od SET od.Product = :productId and od.itemsNumber = :itemsNumber and od.updateAt = :upDate WHERE od.id = :id and od.isPresent = true")
    Optional<OrderDetail>  updateOrderDetail(@Param("id") Long orderDetailId, @Param("productId") Long productId,@Param("itemsNumber") Integer itemsNumber,@Param("upDate") Date updateAt);
}

