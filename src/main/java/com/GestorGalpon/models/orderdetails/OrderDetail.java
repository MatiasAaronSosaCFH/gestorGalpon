package com.GestorGalpon.models.orderdetails;

import java.util.Date;
import java.util.List;

import com.GestorGalpon.models.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "order_details")
@NoArgsConstructor
public class OrderDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Product> products;

    @Column(name = "sub_total")
    private Double subTotal;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "is_present")
    private Boolean isPresent;


}
