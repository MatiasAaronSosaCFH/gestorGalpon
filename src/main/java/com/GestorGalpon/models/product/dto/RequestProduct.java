package com.GestorGalpon.models.product.dto;

import com.GestorGalpon.models.category.dto.RequestCategory;
import com.GestorGalpon.models.subcategory.dto.RequestSubCategory;
import jakarta.validation.constraints.NotBlank;

public record RequestProduct(@NotBlank String name,
                             @NotBlank Double price,
                             RequestCategory category,
                             RequestSubCategory subCategory) {
}
