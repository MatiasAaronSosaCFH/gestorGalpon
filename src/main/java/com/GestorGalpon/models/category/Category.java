package com.GestorGalpon.models.category;


import com.GestorGalpon.models.category.dto.RequestCategory;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.models.subcategory.SubCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "is_present")
    private Boolean isPresent;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;
    @OneToMany
    private List<Product> products;

    public Category(RequestCategory category){
        this.name = category.name();
        this.createAt = new Date();
        this.updateAt = new Date();
        this.isPresent = true;
        this.subCategories = new ArrayList<>();
    }
}
