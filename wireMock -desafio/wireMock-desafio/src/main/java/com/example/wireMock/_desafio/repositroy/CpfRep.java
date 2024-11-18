package com.example.wireMock._desafio.repositroy;

import com.example.wireMock._desafio.model.CpfModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpfRep extends MongoRepository<CpfModel,String> {
}
