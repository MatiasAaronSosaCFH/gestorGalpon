package com.GestorGalpon.models.order.dto;


import java.sql.Date;
import java.util.List;

import com.GestorGalpon.models.order.Order;
import com.GestorGalpon.models.orderdetails.dto.ResponseOrderDetail;

public record ResponseOrder(Long id,
                            List<ResponseOrderDetail> orderDetails,
                            Double subTotal,
                            Date createAt,
                            Date updateAt) {

        public ResponseOrder(Order order){
            this(   order.getId(),
                    order.getOrderDetails().stream().map(ResponseOrderDetail :: new).toList(),
                    order.getSubTotal(),
                    order.getCreateAt(),
                    order.getUpdateAt());
        }
}
