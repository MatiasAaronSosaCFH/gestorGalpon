package com.GestorGalpon.models.order.dto;

import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;

import jakarta.validation.constraints.NotBlank;

public record RequestOrder(RequestOrderDetail orderDetail,
                           @NotBlank Double subTotal,
                           @NotBlank Boolean isPresent) {
    
}
