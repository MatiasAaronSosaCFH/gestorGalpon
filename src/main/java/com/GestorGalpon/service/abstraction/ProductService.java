package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.product.dto.ResponseProduct;

import java.util.List;

public interface ProductService {

    ResponseProduct modifyAvailable(Long id, Boolean available);
    List<ResponseProduct> findAll();
    ResponseProduct createProduct(RequestProduct product);

    List<ResponseProduct> findAllProductAvailable();

    List<ResponseProduct> findAllProductByName(String name);

    ResponseProduct updateProduct(RequestProduct product, Long id);
}
