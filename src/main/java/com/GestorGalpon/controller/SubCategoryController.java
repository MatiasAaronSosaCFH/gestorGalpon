package com.GestorGalpon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestorGalpon.models.subcategory.dto.RequestSubCategory;
import com.GestorGalpon.models.subcategory.dto.ResponseSubCategory;
import com.GestorGalpon.service.implementation.SubCategoryServiceImp;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/sub-category")
@RequiredArgsConstructor
public class SubCategoryController {

    private final SubCategoryServiceImp subCategoryServiceImp;


    @GetMapping
    public ResponseEntity<?> findAllCategories() {

        List<ResponseSubCategory> subCategories = subCategoryServiceImp.findAllSubCategoriesAvailable();
        return new ResponseEntity<> (subCategories , HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createSubCategory(@RequestBody @Valid RequestSubCategory subCategory) {
        
        if(subCategory.name().equals(null)) return new ResponseEntity<> ("Fields not Suported", HttpStatus.BAD_REQUEST); 
        return new ResponseEntity<> (subCategoryServiceImp.createSubCategory(subCategory), HttpStatus.CREATED);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable @NotBlank String name) {
        return new ResponseEntity<>(subCategoryServiceImp.findSubCategoriesByName(name), HttpStatus.OK);
    }
    
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<?> getById(@PathVariable @NotBlank Long id) {
        return new ResponseEntity<>(subCategoryServiceImp.findSubCategoryById(id), HttpStatus.OK);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifySubCategory(@PathVariable Long id, @RequestBody String name) {
        return new ResponseEntity<>(subCategoryServiceImp.modifySubCategory(id, name),HttpStatus.OK);
    }
    
    
}
