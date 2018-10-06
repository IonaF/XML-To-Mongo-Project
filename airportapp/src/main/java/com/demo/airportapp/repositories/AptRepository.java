package com.demo.airportapp.repositories;

import com.demo.airportapp.model.Airport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptRepository extends MongoRepository<Airport, org.bson.types.ObjectId>{
	
	Page<Airport> findByCodeLike(String code, Pageable pageable);
	
	Page<Airport> findByNameLike(String name, Pageable pageable);
	
	Page<Airport> findByDeprecated(String deprecated, Pageable pageable);
}