package com.GestorGalpon.service.implementation;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.product.dto.ResponseProduct;
import com.GestorGalpon.repository.ProductRepository;
import com.GestorGalpon.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
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
    public List<ResponseProduct> findAllProductByOrder(Long id) {
        return null;
    }

    @Override
    public ResponseProduct updateName(String name, Long id) {
        Product prod = productRepository.updateName(id,name).orElse(null);
        if (prod == null) return null;
        return new ResponseProduct(prod);
    }
}
