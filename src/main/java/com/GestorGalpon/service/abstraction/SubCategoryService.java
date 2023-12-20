package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.subcategory.dto.RequestSubCategory;
import com.GestorGalpon.models.subcategory.dto.ResponseSubCategory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface SubCategoryService {

    List<ResponseSubCategory> findAllSubCategoriesAvailable();

    ResponseSubCategory findSubCategoryById(Long id);

    List<ResponseSubCategory> findSubCategoriesByName(String name);

    List<ResponseSubCategory> findSubCategoriesByCreate(Date start, Date last);

    ResponseSubCategory updateName(String name, Long id, Date update);

    ResponseSubCategory createSubCategory(RequestSubCategory subCategory);

    ResponseSubCategory modifySubCategory(Long id, String name);
}
