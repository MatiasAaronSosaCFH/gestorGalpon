package com.GestorGalpon.service.implementation;

import com.GestorGalpon.models.subcategory.SubCategory;
import com.GestorGalpon.models.subcategory.dto.RequestSubCategory;
import com.GestorGalpon.models.subcategory.dto.ResponseSubCategory;
import com.GestorGalpon.repository.SubCategoryRepository;
import com.GestorGalpon.service.abstraction.SubCategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImp implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Override
    public List<ResponseSubCategory> findAllSubCategoriesAvailable() {
        return subCategoryRepository.findSubCategoriesAvailable().stream().map(ResponseSubCategory::new).toList();
    }

    @Override
    public ResponseSubCategory findSubCategoryById(Long id) {
        Optional<SubCategory> subCategory = subCategoryRepository.findSubCategoryById(id);

        ResponseSubCategory response;

        if (subCategory.isPresent()) return response = new ResponseSubCategory(subCategory.get());

        return null;
    }

    @Override
    public List<ResponseSubCategory> findSubCategoriesByName(String name) {
        List<SubCategory> subCategory = subCategoryRepository.findSubCategoriesByName(name);
        return subCategory.stream().map(ResponseSubCategory::new).toList();
    }

    @Override
    public List<ResponseSubCategory> findSubCategoriesByCreate(Date start, Date last) {
        List<SubCategory> subCategory = subCategoryRepository.findSubCategoriesByCreate(start, last);
        return subCategory.stream().map(ResponseSubCategory::new).toList();
    }

    @Override
    public ResponseSubCategory updateName(String name, Long id, Date update) {
        Optional<SubCategory> subCategory =  subCategoryRepository.updateName(name,id,update);

        ResponseSubCategory response = null;

        if (subCategory.isPresent()) return response = new ResponseSubCategory(subCategory.get());

        return  response;

    }

    @Override
     public ResponseSubCategory modifySubCategory(Long id, String name) {
        Optional<SubCategory> subCategory =  subCategoryRepository.modifySubCategory(name,id);

        ResponseSubCategory response = null;

        if (subCategory.isPresent()) return response = new ResponseSubCategory(subCategory.get());

        return  response;

    }

    @Override
    public ResponseSubCategory createSubCategory(RequestSubCategory subCategory) {
        return new ResponseSubCategory(subCategoryRepository.save(new SubCategory (subCategory)));
    }
}
