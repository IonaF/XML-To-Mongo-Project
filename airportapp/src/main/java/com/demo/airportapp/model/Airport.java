package com.demo.airportapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "airports")
public class Airport{
  

	private String id;
  
	private String name;
  
	private String deprecated;
  
}
