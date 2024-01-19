package com.GestorGalpon.models.orderdetails;

import java.util.Date;

import com.GestorGalpon.models.orderdetails.dto.RequestOrderDetail;
import com.GestorGalpon.models.product.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")

    private Product product;

    @Column(name = "items_number")
    private Integer itemsNumber;

    @Column(name = "sub_total")
    private Double subTotal;
    
    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "is_present")
    private Boolean isPresent;


    public OrderDetail(RequestOrderDetail requestOrderDetail){

        this.product = new Product(requestOrderDetail.product());
        this.subTotal = requestOrderDetail.subTotal();
        this.createAt = new Date();
        this.updateAt = new Date();
        this.isPresent = true;
    }
    
    
}
