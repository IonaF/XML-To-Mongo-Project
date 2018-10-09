package com.demo.airportapp.repositories;

import com.demo.airportapp.model.Airport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptRepository extends PagingAndSortingRepository<Airport, String>{
	
	Page<Airport> findAll(Pageable pageable);
	Page<Airport> findByIdLike(String id, Pageable pageable);
	Page<Airport> findByNameLike(String name, Pageable pageable);
	Page<Airport> findByDeprecated(String deprecated, Pageable pageable);
}