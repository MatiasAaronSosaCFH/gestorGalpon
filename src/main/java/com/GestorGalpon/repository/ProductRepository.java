package com.GestorGalpon.repository;

import com.GestorGalpon.models.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.isPresent = true")
    List<Product> findAllProductAvailable();

    @Query("SELECT p FROM Product p WHERE p.name = :name AND p.isPresent = true")
    List<Product> findProductByName(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.id = :id AND p.isPresent = true")
    Optional<Product> findProductById(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.name = :name WHERE p.id = :id")
    Optional<Product> updateName(@Param("id")Long id, @Param("name")String name);

    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.price = :price, p.name = :name, p.updateAt = :date WHERE p.id = :id")
    Optional<Product> updateProduct(@Param("id")Long id,
                                    @Param("price")Double price,
                                    @Param("name")String name,
                                    @Param("date") Date date);


    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.category = :category, p.subCategory = :subCategory, p.updateAt = :date WHERE p.id = :id")
    Optional<Product> updateCategory(@Param("category")Long category,
                                     @Param("subCategory")Long subcategory,
                                     @Param("date")Date date,
                                     @Param("id")Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.isPresent = :present , p.updateAt = :date WHERE p.id = :id")
    Optional<Product> updateAvailable(@Param("present")Boolean present, @Param("date")Date date, @Param("id")Long id);
}
