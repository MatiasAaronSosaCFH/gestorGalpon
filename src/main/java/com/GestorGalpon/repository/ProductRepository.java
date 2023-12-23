package com.GestorGalpon.repository;

import com.GestorGalpon.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

    @Query("UPDATE Product p SET p.name = :name WHERE p.id = :id")
    Optional<Product> updateName(@Param("id")Long id, @Param("name")String name);
}
