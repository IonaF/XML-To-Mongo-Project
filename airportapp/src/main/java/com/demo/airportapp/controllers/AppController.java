package com.demo.airportapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.airportapp.model.Airport;
import com.demo.airportapp.repositories.AptRepository;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AppController {

    @Autowired
    AptRepository aptRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Airport> getAllAirports() {
    	return aptRepository.findAll();
    }
    private Pageable createPaginationPmtr(int pageNo, int pageSize) {
    	return new PageRequest(pageNo, pageSize);
    }
    
    @RequestMapping(value="/code/{code}/pageNo/{pageNo}/pageSize/{pageSize}", method = RequestMethod.GET)
    public Page<Airport> getAirportsByCode(@PathVariable("code") String code,
    		@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        return aptRepository.findByCodeLike(code, createPaginationPmtr(pageNo, pageSize));
    }
    
    @RequestMapping(value="/name/{name}/pageNo/{pageNo}/pageSize/{pageSize}", method = RequestMethod.GET)
    public Page<Airport> getAirportsByName(@PathVariable("name") String name,
    		@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        return aptRepository.findByNameLike(name, createPaginationPmtr(pageNo, pageSize));
    }
    
    @RequestMapping(value="/deprecated/{deprecated}/pageNo/{pageNo}/pageSize/{pageSize}", method = RequestMethod.GET)
    public Page<Airport> getAirportsByDeprecated(@PathVariable("deprecated") String deprecated,
    		@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        return aptRepository.findByDeprecated(deprecated, createPaginationPmtr(pageNo, pageSize));
    }
	
	
}