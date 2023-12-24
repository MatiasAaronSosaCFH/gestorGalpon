package com.GestorGalpon.controller;

import com.GestorGalpon.models.product.dto.RequestProduct;
import com.GestorGalpon.models.product.dto.ResponseProduct;
import com.GestorGalpon.service.implementation.ProductServiceImp;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImp productServiceImp;


    @GetMapping
    public ResponseEntity<?> findAllAvailable(){
        List<ResponseProduct> products = productServiceImp.findAllProductAvailable();
        if (products.isEmpty()) return  new ResponseEntity<>("No have products", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid RequestProduct prod){
        return new ResponseEntity<>(productServiceImp.createProduct(prod), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<?> updateNameAndPrice(@RequestParam @Valid RequestProduct prod,@RequestParam @NotBlank Long id){
        ResponseProduct product = productServiceImp.updateProduct(prod, id);
        if (product == null) return  new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PutMapping("/mod-cat")
    public ResponseEntity<?> updateCategory(@RequestParam @NotBlank Long category,
                                            @RequestParam @NotBlank Long subCategory,
                                            @RequestParam @NotBlank Long prod){
        ResponseProduct product = productServiceImp.updateProduct(category,subCategory,prod);
        if (product == null) return  new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findProductByName(@PathVariable @NotBlank String name){
        List<ResponseProduct> products = productServiceImp.findAllProductByName(name);
        if (products.isEmpty()) return new ResponseEntity<>("Name not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productServiceImp.findAll(), HttpStatus.OK);
    }

    @PutMapping("/mod-av")
    public ResponseEntity<?> changeAvailable(@RequestParam @NotBlank Long id, @RequestParam @NotBlank Boolean available){
        ResponseProduct product = productServiceImp.modifyAvailable(id, available);
        if (product == null) return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
