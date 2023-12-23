package com.GestorGalpon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.product.Product;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{

  
    
    
    @Modifying
    @Query("UPDATE OrderDetail od SET od.product = :product WHERE od.id = :orderDetailId")
    void insertProductIntoOrderDetailById(Long orderDetailId, Product product);
}
