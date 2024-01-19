package com.GestorGalpon.models.order;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.GestorGalpon.models.order.dto.RequestOrder;
import com.GestorGalpon.models.orderdetails.OrderDetail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "order_entity")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    
    @OneToMany
    private List<OrderDetail> orderDetails;

    @Column(name = "sub_total")
    private Double subTotal;
    
    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "is_present")
    private Boolean isPresent;

    public Order(RequestOrder order){

        this.orderDetails = new ArrayList<>();
        this.subTotal = order.subTotal();
        this.createAt = new Date();
        this.updateAt = new Date();
        this.isPresent = true;

    }
    
    
}
