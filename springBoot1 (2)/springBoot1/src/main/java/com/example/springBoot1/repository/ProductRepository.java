package com.example.springBoot1.repository;

import com.example.springBoot1.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface  ProductRepository extends JpaRepository<ProductModel, UUID> {

}
