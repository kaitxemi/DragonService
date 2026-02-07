package com.txe.dragonentrenoservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.txe.dragonentrenoservice.model.EntrenosModel;

@Repository
public interface EntrenosRepository extends MongoRepository<EntrenosModel, String> {

	
	List<EntrenosModel> findTop100ByDistanciaOrderByFechaHoraDesc(Integer distancia);
	
	List<EntrenosModel> findTop100ByDistanciaAndAliasOrderByFechaHoraDesc(Integer distancia, String alias);
	

}


