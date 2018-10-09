package com.demo.airportapp.services;

import java.util.List;
import org.springframework.data.domain.Page;

import com.demo.airportapp.model.Airport;
import com.demo.airportapp.services.dtos.RequestTO;

public interface AptService {

	Page<Airport> getAllAirports(RequestTO requestObj);
	
	Page<Airport> getAirportsByCode(RequestTO requestObj);
	
	Page<Airport> getAirportsByName(RequestTO requestObj);
	
	Page<Airport> getAirportsByDeprecated(RequestTO requestObj);
	
}
