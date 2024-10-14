package com.example.desafio1.Repositorie;

import com.example.desafio1.model.CpfModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
//Certo
@Repository
public interface CPFRepository extends MongoRepository<CpfModel,UUID > {
}

