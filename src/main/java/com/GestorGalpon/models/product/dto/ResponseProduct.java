package com.GestorGalpon.models.product.dto;

import com.GestorGalpon.models.category.dto.ResponseCategory;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.models.subcategory.dto.ResponseSubCategory;

import java.util.Date;

public record ResponseProduct(Long id,
                              String name,
                              Double price,
                              ResponseCategory category,
                              ResponseSubCategory subCategory,
                              Date createAt,
                              Date updateAt) {

    public ResponseProduct(Product product){
        this(product.getId(),
                product.getName(),
                product.getPrice(),
                new ResponseCategory(product.getCategory()),
                new ResponseSubCategory(product.getSubCategory()),
                product.getCreateAt(),
                product.getUpdateAt());
    }
}
