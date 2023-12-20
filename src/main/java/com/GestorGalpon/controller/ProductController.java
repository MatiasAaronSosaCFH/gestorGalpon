package com.GestorGalpon.controller;

import com.GestorGalpon.service.implementation.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImp productServiceImp;

}
