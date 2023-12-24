package com.GestorGalpon.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GestorGalpon.models.subcategory.SubCategory;
import com.GestorGalpon.models.category.Category;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long>{


    @Query("SELECT sc FROM SubCategory sc WHERE sc.id = :id AND sc.isPresent = true")
    Optional<SubCategory> findSubCategoryById(@Param("id") Long id);

    @Query("SELECT sc FROM SubCategory sc WHERE sc.isPresent = true")
    List<SubCategory> findSubCategoriesAvailable();

    @Query("SELECT sc FROM SubCategory sc WHERE sc.name = :name and sc.isPresent = true")
    List<SubCategory> findSubCategoriesByName(@Param("name") String name);

    @Query("SELECT sc FROM SubCategory sc WHERE sc.createAt BETWEEN :start AND :final AND sc.isPresent = true")
    List<SubCategory> findSubCategoriesByCreate(@Param("start")Date start ,@Param("final")Date last);

    @Query("UPDATE SubCategory sc SET sc.name = :name, sc.updateAt = :update WHERE sc.id = :id")
    Optional<SubCategory> updateName(@Param("name") String name, @Param("id") Long id, @Param("update") Date update);

    @Query("UPDATE SubCategory sc SET sc.name = :name WHERE sc.id = :id")
    Optional<SubCategory> modifySubCategory(@Param("name") String name, @Param("id") Long id);

    @Query("SELECT sc FROM SubCategory sc WHERE sc.category = :category")
    List<SubCategory> findByCategory(@Param("category")Category category);
}
