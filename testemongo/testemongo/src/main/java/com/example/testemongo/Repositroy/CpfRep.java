package com.example.testemongo.Repositroy;

import com.example.testemongo.model.Cpfmodel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CpfRep extends MongoRepository<Cpfmodel,Integer> {
}
