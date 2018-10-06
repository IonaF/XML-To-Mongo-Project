package com.demo.airportapp.model;

import lombok.Data;

@Data
public class Airport {
  
  private String code;
  
  private String name;
  
  private String deprecated;
  
  public String getCode() {
	return code;
  }
  public void setCode(String code) {
	this.code = code;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getDeprecated() {
	return deprecated;
  	}
  public void setDeprecated(String deprecated) {
	this.deprecated = deprecated;
  }
  
  
  
}
