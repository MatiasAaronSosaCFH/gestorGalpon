package com.GestorGalpon.models.product;

import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.category.Category;
import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.subcategory.SubCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "prive")
    private Double price;
    
    @OneToMany()
    private List<OrderDetail> orderDetail;
    
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


    public Product(RequestProduct product){
        this.name = product.name();
        this.price = product.price();
        this.createAt = new Date();
        this.updateAt = new Date();
        this.isPresent = true;
        this.category = new Category(product.category());
        this.subCategory = new SubCategory(product.subCategory());
        this.orderDetail = null;
    }
}
