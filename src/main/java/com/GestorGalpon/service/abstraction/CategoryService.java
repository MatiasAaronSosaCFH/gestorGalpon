package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.category.dto.ResponseCategory;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface CategoryService {

    List<ResponseCategory> finsAllCategoriesAvailable();

    ResponseCategory findCategoryById(Long id);

    List<ResponseCategory> findCategoriesByName(String name);

    List<ResponseCategory> findCategoriesByCreate(Date start, Date last);

    ResponseCategory updateName(String name, Long id, Date update);

    ResponseCategory createCategory(Category category);
}
