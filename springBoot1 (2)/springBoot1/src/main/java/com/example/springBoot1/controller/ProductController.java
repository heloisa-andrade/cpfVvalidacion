package com.example.springBoot1.controller;

import com.example.springBoot1.dto.ProductrecordDto;
import com.example.springBoot1.model.ProductModel;
import com.example.springBoot1.repository.ProductRepository;
import jakarta.validation.Valid;

import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    @GetMapping("/products") // mostra todos os registos
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        List<ProductModel> productsList = productRepository.findAll();
        if(!productsList.isEmpty() ){
            for (ProductModel product : productsList){
                UUID id = product.getIdProducts();
                product.add(linkTo(methodOn(ProductController.class).getOneProducts(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProducts(@PathVariable(value = "id")UUID id){
        Optional<ProductModel> product0 =  productRepository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> upadateProduct(@PathVariable(value = "id") UUID id,@RequestBody @Valid ProductrecordDto productrecordDto ){
        Optional<ProductModel> prduct0 = productRepository.findById(id);
        if (prduct0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = prduct0.get();
        BeanUtils.copyProperties(productrecordDto,productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("product Delete  sucessfully");
    }


}
