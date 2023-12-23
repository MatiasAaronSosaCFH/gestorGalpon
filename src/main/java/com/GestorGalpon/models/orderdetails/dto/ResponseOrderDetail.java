package com.GestorGalpon.models.orderdetails.dto;

import java.util.Date;
import java.util.List;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.product.dto.ResponseProduct;

public record ResponseOrderDetail(  Long id,
                                    List<ResponseProduct> products,
                                    Double subTotal,
                                    Date createAt,
                                    Date updateAt) {
    
    public ResponseOrderDetail(OrderDetail orderDetail){
            this(orderDetail.getId(),
            orderDetail.getProducts().stream().map(ResponseProduct::new).toList(),
                orderDetail.getSubTotal(),
                orderDetail.getCreateAt(),
                orderDetail.getUpdateAt());
    }
}
