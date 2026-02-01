package com.txe.dragonsesionservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.txe.dragonsesionservice.model.SesionModel;

@Repository
public interface SesionRepository extends MongoRepository<SesionModel, String> {

    

}


