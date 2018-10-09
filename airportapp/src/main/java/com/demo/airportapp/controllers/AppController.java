package com.demo.airportapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.airportapp.repositories.AptRepository;
import com.demo.airportapp.services.AptService;
import com.demo.airportapp.services.dtos.RequestTO;

@RestController
@RequestMapping("/api/airports")
public class AppController {

    @Autowired
    AptService aptService;
    
    @Autowired
    AptRepository aptRepository;
    
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAirports(
    		@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
    		@RequestParam(value = "pageSize", required = false) Integer pageSize) {
    	RequestTO requestObj = new RequestTO();
    	requestObj.setPageNumber((pageNumber == null)? 0 :pageNumber.intValue());
    	requestObj.setPageSize((pageSize == null)? 10 : pageSize.intValue());
		return new ResponseEntity<>(aptService.getAllAirports(requestObj), HttpStatus.OK);
    }
    
    @RequestMapping(value="/fetchby/code", method = RequestMethod.GET)
    public ResponseEntity<?> getAirportsByCode(
    		@RequestParam(value = "searchString", required = true) String searchString,
    		@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
    		@RequestParam(value = "pageSize", required = false) Integer pageSize) {
    	RequestTO requestObj = new RequestTO();
    	requestObj.setSearchString(searchString);
    	requestObj.setPageNumber((pageNumber == null)? 0 : pageNumber.intValue());
    	requestObj.setPageSize((pageSize == null)? 10 : pageSize.intValue());
		return new ResponseEntity<>(aptService.getAirportsByCode(requestObj), HttpStatus.OK);
    }
    
    @RequestMapping(value="/fetchby/name", method = RequestMethod.GET)
    public ResponseEntity<?> getAirportsByName(
    		@RequestParam(value = "searchString", required = true) String searchString,
    		@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
    		@RequestParam(value = "pageSize", required = false) Integer pageSize) {
    	RequestTO requestObj = new RequestTO();
    	requestObj.setSearchString(searchString);
    	requestObj.setPageNumber((pageNumber == null)? 0 : pageNumber.intValue());
    	requestObj.setPageSize((pageSize == null)? 10 : pageSize.intValue());
		return new ResponseEntity<>(aptService.getAirportsByName(requestObj), HttpStatus.OK);
    }
	
    @RequestMapping(value="/fetchby/deprecated", method = RequestMethod.GET)
    public ResponseEntity<?> getAirportsByDeprecated(
    		@RequestParam(value = "searchString", required = true) String searchString,
    		@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
    		@RequestParam(value = "pageSize", required = false) Integer pageSize) {
    	RequestTO requestObj = new RequestTO();
    	requestObj.setSearchString(searchString);
    	requestObj.setPageNumber((pageNumber == null)? 0 : pageNumber.intValue());
    	requestObj.setPageSize((pageSize == null)? 10 : pageSize.intValue());
		return new ResponseEntity<>(aptService.getAirportsByDeprecated(requestObj), HttpStatus.OK);
    }
    
    
}