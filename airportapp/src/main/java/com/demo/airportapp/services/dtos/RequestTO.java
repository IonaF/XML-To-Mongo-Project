package com.demo.airportapp.services.dtos;

import com.demo.airportapp.model.Airport;

import lombok.Data;

@Data
public class RequestTO {
	
	private String searchString;
	private Airport airportObj;
	private int pageNumber;
	private int pageSize;

}
