package com.GestorGalpon.models.orderdetails.dto;


import com.GestorGalpon.models.product.dto.RequestProduct;

import jakarta.validation.constraints.NotBlank;

public record RequestOrderDetail(@NotBlank RequestProduct product,
                                @NotBlank Integer itemsNumber,
                                @NotBlank Double subTotal,
                                @NotBlank Boolean isPresent) {
    
}
