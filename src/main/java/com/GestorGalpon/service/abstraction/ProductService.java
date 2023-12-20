package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.product.dto.ResponseProduct;

import java.util.List;

public interface ProductService {

    ResponseProduct createProduct(RequestProduct product);

    List<ResponseProduct> findAllProductAvailable();

    List<ResponseProduct> findAllProductByName(String name);

    List<ResponseProduct> findAllProductByOrder(Long id);

    ResponseProduct updateName(String name, Long id);
}
