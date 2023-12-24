package com.GestorGalpon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.GestorGalpon.models.orderdetails.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{


}
