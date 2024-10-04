package com.example.desafio1.Repositorie;

import com.example.desafio1.model.CpfModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
//Certo
public interface CPFRepository extends MongoRepository<CpfModel,UUID > {
}

