package com.GestorGalpon.models.orderdetails.dto;

import java.util.Date;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.product.dto.ResponseProduct;

public record ResponseOrderDetail(  Long id,
                                    ResponseProduct product,
                                    Integer itemsNumber,
                                    Double subTotal,
                                    Date createAt,
                                    Date updateAt) {
    
    public ResponseOrderDetail(OrderDetail orderDetail){
            this(orderDetail.getId(),
                new ResponseProduct(orderDetail.getProduct()),
                orderDetail.getItemsNumber(),
                orderDetail.getSubTotal(),
                orderDetail.getCreateAt(),
                orderDetail.getUpdateAt());
    }
}
