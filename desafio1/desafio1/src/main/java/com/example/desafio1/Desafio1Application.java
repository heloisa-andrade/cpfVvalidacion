package com.example.desafio1;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;

@SpringBootApplication
public class Desafio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
//		try{
//			//Conectando ao mongo :)
//			MongoClient client = MongoClients.create("mongodb://localhost:27017");
//			//Acessando a coleção ->
//			MongoCollection<Document> collection = client.getDatabase("PraticaGF").getCollection("Colecao");
//			//Filtro para buscar o documento
//			Bson filter = Filters.eq("cpf", cpf);
//			//usar o .find para buscar o documento
//			FindIterable<Document> result = collection.find(filter);
//			//Ver se existe o documento
//			boolean documentExists = result.iterator().hasNext();
//			if(documentExists){
//				return true;
//			}
//			else{
//				return false;
//			}
//		}catch(InputMismatchException imm){
//			imm.getMessage();
//			return false;
//		}
	}

}
