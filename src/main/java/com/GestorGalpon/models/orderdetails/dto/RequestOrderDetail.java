package com.GestorGalpon.models.orderdetails.dto;

import java.util.List;

import com.GestorGalpon.models.product.dto.RequestProduct;

import jakarta.validation.constraints.NotBlank;

public record RequestOrderDetail(@NotBlank List<RequestProduct> products,
                                @NotBlank Double subTotal) {
    
}
