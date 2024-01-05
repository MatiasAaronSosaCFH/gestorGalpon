package com.GestorGalpon.models.image;

import com.GestorGalpon.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "internal_id")
    private String internalId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Image(String name,String url, String internalId, Product product){
        this.name = name;
        this.url = url;
        this.internalId = internalId;
        this.product = product;
    }

    public Boolean ifNotExist(){
        if (this.product != null) return  true;
        return false;
    }
}
