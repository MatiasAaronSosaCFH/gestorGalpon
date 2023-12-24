package com.GestorGalpon.service.implementation;
import com.GestorGalpon.models.order.Order;
import com.GestorGalpon.models.orderdetails.OrderDetail;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.product.dto.ResponseProduct;
import com.GestorGalpon.repository.OrderRepository;
import com.GestorGalpon.repository.ProductRepository;
import com.GestorGalpon.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseProduct modifyAvailable(Long id, Boolean available) {
        Optional<Product> prod = productRepository.updateAvailable(available,new Date(), id);
        if (!prod.isPresent()) return  null;
        return new ResponseProduct(prod.get());
    }

    @Override
    public List<ResponseProduct> findAll() {
        return productRepository.findAll().stream().map(ResponseProduct::new).toList();
    }

    @Override
    public ResponseProduct createProduct(RequestProduct product) {
        return new ResponseProduct(productRepository.save(new Product(product)));
    }

    @Override
    public List<ResponseProduct> findAllProductAvailable() {
        return productRepository.findAllProductAvailable().stream().map(ResponseProduct::new).toList();
    }

    @Override
    public List<ResponseProduct> findAllProductByName(String name) {
        return productRepository.findProductByName(name).stream().map(ResponseProduct::new).toList();
    }

    @Override
    public ResponseProduct updateProduct(RequestProduct product, Long id) {
        Optional<Product> prod = productRepository.updateProduct(id, product.price(), product.name(), new Date());
        if (!prod.isPresent()) return null;
        return new ResponseProduct(prod.get());
    }


    public  ResponseProduct updateProduct(Long category,Long subCategory, Long id){
        Optional<Product> prod = productRepository.updateCategory(category,subCategory,new Date(), id);
        if (!prod.isPresent()) return null;
        return new ResponseProduct(prod.get());
    }
}
