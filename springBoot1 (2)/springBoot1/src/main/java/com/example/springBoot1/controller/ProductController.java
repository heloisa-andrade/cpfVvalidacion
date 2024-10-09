package com.example.springBoot1.controller;

import com.example.springBoot1.dto.ProductrecordDto;
import com.example.springBoot1.model.ProductModel;
import com.example.springBoot1.repository.ProductRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct (@RequestBody @Valid ProductrecordDto productrecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productrecordDto, productModel );
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

}
