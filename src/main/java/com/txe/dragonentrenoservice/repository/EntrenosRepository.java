package com.txe.dragonentrenoservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.txe.dragonentrenoservice.model.EntrenosModel;

@Repository
public interface EntrenosRepository extends MongoRepository<EntrenosModel, String> {

	List<EntrenosModel> findByDistanciaAndAlias(Integer distancia, String alias);
	
	List<EntrenosModel> findByDistancia(Integer distancia);

}


