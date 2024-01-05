package com.GestorGalpon.service.implementation;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.category.dto.ResponseCategory;
import com.GestorGalpon.repository.CategoryRepository;
import com.GestorGalpon.service.abstraction.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<ResponseCategory> finsAllCategoriesAvailable() {
        return categoryRepository.findAllCategoriesAvailable().stream().map(ResponseCategory::new).toList();
    }

    @Override
    public ResponseCategory findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findCategoryById(id);

        ResponseCategory response;

        if (category.isPresent()) return response = new ResponseCategory(category.get());

        return null;
    }

    /**
     * Este metodo retorna una lista de categorias que matcheen con un nombra
     *
     *
     * */
    @Override
    public List<ResponseCategory> findCategoriesByName(String name) {
        List<Category> categories = categoryRepository.findCategoriesByName(name);
        return categories.stream().map(ResponseCategory::new).toList();
    }

    @Override
    public List<ResponseCategory> findCategoriesByCreate(Date start, Date last) {
        List<Category> categories = categoryRepository.findCategoriesByCreate(start, last);
        return categories.stream().map(ResponseCategory::new).toList();
    }

    @Override
    public ResponseCategory updateName(String name, Long id, Date update) {
        Optional<Category> category =  categoryRepository.updateName(name,id,update);

        ResponseCategory response;

        if (category.isPresent()) return response = new ResponseCategory(category.get());

        return null;
    }

    @Override
    public ResponseCategory createCategory(Category category) {
        return new ResponseCategory(categoryRepository.save(category));
    }
}
