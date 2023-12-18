package com.GestorGalpon.repository;

import com.GestorGalpon.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.id = :id AND c.isPresent = true")
    Optional<Category> findCategoryById(@Param("id")Long id);

    @Query("SELECT c FROM Category c WHERE c.isPresent = true")
    List<Category> findAllCategoriesAvailable();

    @Query("SELECT c FROM Category c WHERE c.name = :name AND c.isPresent = true")
    List<Category> findCategoriesByName(@Param("name")String name);

    @Query("SELECT c FROM Category c WHERE c.createAt BETWEEN :start AND :final AND c.isPresent = true")
    List<Category> findCategoriesByCreate(@Param("start")Date start, @Param("final")Date last);

    @Query("UPDATE Category c SET c.name = :name, c.updateAt = :update WHERE c.id = :id")
    Optional<Category> updateName(@Param("name")String name, @Param("id")Long id, @Param("update")Date update);

}
