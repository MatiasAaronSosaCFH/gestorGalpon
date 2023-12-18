package com.GestorGalpon.models.category.dto;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.subcategory.dto.ResponseSubCategory;
import java.util.Date;
import java.util.List;

public record ResponseCategory(Long id,
                               String name,
                               List<ResponseSubCategory> subCategories,
                               Date createAt,
                               Date updateAt) {

    public ResponseCategory(Category category){
        this(category.getId(),
                category.getName(),
                category.getSubCategories().stream().map(ResponseSubCategory::new).toList(),
                category.getCreateAt(),
                category.getUpdateAt());
    }
}
