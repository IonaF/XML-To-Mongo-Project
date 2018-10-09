/**
 * 
 */
package com.demo.airportapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.airportapp.model.Airport;
import com.demo.airportapp.repositories.AptRepository;
import com.demo.airportapp.services.dtos.RequestTO;

/**
 * @author Iona
 *
 */
@Service
public class AptServiceImpl implements AptService{

	@Autowired
    AptRepository aptRepository;
	
	private Pageable createPaginationPmtr(int pageNo, int pageSize) {
    	return new PageRequest(pageNo, pageSize);
    }
	
	public Page<Airport> getAllAirports(RequestTO requestObj) {
		return aptRepository.findAll(createPaginationPmtr(requestObj.getPageNumber(),requestObj.getPageSize()));
	}
	
	public Page<Airport> getAirportsByCode(RequestTO requestObj) {
		return aptRepository.findByIdLike(requestObj.getSearchString(), createPaginationPmtr(requestObj.getPageNumber(),requestObj.getPageSize()));	
	}
	
	public Page<Airport> getAirportsByName(RequestTO requestObj) {
		return aptRepository.findByNameLike(requestObj.getSearchString(), createPaginationPmtr(requestObj.getPageNumber(),requestObj.getPageSize()));	
	}
	
	public Page<Airport> getAirportsByDeprecated(RequestTO requestObj) {
		return aptRepository.findByDeprecated(requestObj.getSearchString(), createPaginationPmtr(requestObj.getPageNumber(),requestObj.getPageSize()));	
	}
}
