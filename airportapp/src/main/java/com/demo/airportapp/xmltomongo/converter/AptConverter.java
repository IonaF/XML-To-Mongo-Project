package com.demo.airportapp.xmltomongo.converter;

import com.demo.airportapp.model.Airport;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.springframework.stereotype.Component;

@Component
public class AptConverter implements Converter {
	
  @Override
  public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

  }

  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    Airport airport = new Airport();
    airport.setCode(reader.getAttribute("Code"));
    airport.setName(reader.getAttribute("Name"));
    airport.setDeprecated(reader.getAttribute("Deprecated"));
    return airport;
  }

  @Override
  public boolean canConvert(Class type) {
    return type.equals(Airport.class);
  }
}
