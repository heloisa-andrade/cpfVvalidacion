package com.example.testemongo.Repositroy;

import com.example.testemongo.model.Cpfmodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CpfRep extends MongoRepository<Cpfmodel,String> {
}
