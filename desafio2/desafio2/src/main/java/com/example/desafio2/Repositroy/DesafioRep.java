package com.example.desafio2.Repositroy;

import com.example.desafio2.Model.Desafio2Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesafioRep extends MongoRepository<Desafio2Model,String> {
}
