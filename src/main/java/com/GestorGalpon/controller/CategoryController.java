package com.GestorGalpon.controller;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.category.dto.RequestCategory;
import com.GestorGalpon.models.category.dto.ResponseCategory;
import com.GestorGalpon.service.implementation.CategoryServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImp categoryServiceImp;

    @GetMapping
    public ResponseEntity<?> findAllCategoriesAvailable(){
        List<ResponseCategory> response = categoryServiceImp.finsAllCategoriesAvailable();
        if (response.isEmpty()) return new ResponseEntity<>("THE LIST IS EMPTY", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody RequestCategory category){
        ResponseCategory response = categoryServiceImp.createCategory(new Category(category));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}
