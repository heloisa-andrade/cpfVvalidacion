package com.example.springboot1.controllers;

import com.example.springboot1.dtos.productRecoDto;
import com.example.springboot1.models.ProductModel;
import com.example.springboot1.repositore.ProductRepository;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductContuller {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid productRecoDto productRecoDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecoDto,productModel); //resebe o que vai mudar e para que vai mudar exemplo String,Int
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
    //metotdo para reseper o recurso fazer uma validação inicial e salvar no banco


}
