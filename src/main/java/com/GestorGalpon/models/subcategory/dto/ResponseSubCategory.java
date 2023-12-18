package com.GestorGalpon.models.subcategory.dto;

import com.GestorGalpon.models.category.dto.ResponseCategory;
import com.GestorGalpon.models.subcategory.SubCategory;

import java.util.Date;

public record ResponseSubCategory(Long id,
                                  String name,
                                  ResponseCategory category,
                                  Date createAt,
                                  Date updateAt) {

    public ResponseSubCategory(SubCategory subCategory){
        this(subCategory.getId(),
                subCategory.getName(),
                new ResponseCategory(subCategory.getCategory()),
                subCategory.getCreateAt(),
                subCategory.getUpdateAt());
    }
}