package com.GestorGalpon.models.product;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.subcategory.SubCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "prive")
    private Double price;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "sub_category_id")
    private SubCategory subCategory;
    @Column(name = "is_present")
    private Boolean isPresent;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
}
