package com.GestorGalpon.models.subcategory;

import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.models.subcategory.dto.RequestSubCategory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "sub_categories")
public class SubCategory {

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
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @OneToMany
    private List<Product> products;


    public SubCategory(RequestSubCategory requestSubCategory){

        this.name = requestSubCategory.name();
        this.createAt = new Date();
        this.updateAt = new Date();
        this.isPresent = true;
        this.category = null;
        
    }
}
