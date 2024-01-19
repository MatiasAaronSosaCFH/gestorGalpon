package com.GestorGalpon.repository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GestorGalpon.models.order.Order;
import com.GestorGalpon.models.orderdetails.OrderDetail;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

    @Query("SELECT o FROM Order o WHERE o.isPresent = true")
    List<Order> findAllOrderAvailable();

   @Modifying
    @Query("UPDATE order o SET o.isPresent = :isPresent WHERE o.id = :id")

    Optional<Order> updateIsPresent(@Param ("id") Long orderId, @Param("isPresent") Boolean isPresent);

@Modifying
   @Query("UPDATE order o SET o.orderDetail =:orderDetailId, o.Product = :productId, o.itemsNumber = :itemsNumber, o.updateAt = :upDate WHERE od.id = :id and od.isPresent = true")
    Optional<Order>  updateOrder(@Param("id") Long orderId ,@Param("orderDetailId") Long orderDetailId, @Param("productId") Long productId,@Param("itemsNumber") Integer itemsNumber,@Param("upDate") Date updateAt);

}
