package com.demo.airportapp.xmltomongo.jobs;

import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.demo.airportapp.model.Airport;
import com.demo.airportapp.xmltomongo.converter.AptConverter;
import com.thoughtworks.xstream.converters.ConverterMatcher;

@Configuration
@EnableBatchProcessing
public class XmlTOMongo {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  @Autowired
  private StepBuilderFactory stepBuilderFactory;

 @Autowired
 private AptConverter aptConverter;
 
  @Autowired
  private MongoTemplate mongoTemplate;

  @Bean
  public Job reportJob() throws ClassNotFoundException {
	mongoTemplate.remove(new Query(), "airports");
    return jobBuilderFactory.get("reportJob").incrementer(new RunIdIncrementer()).flow(step1())
        .end().build();
  }

  @Bean
  public Step step1() throws ClassNotFoundException {
    return stepBuilderFactory.get("step1").<Airport, Airport>chunk(250).reader(reader())
        .writer(writer()).build();
  }

  @Bean
  public StaxEventItemReader<Airport> reader() throws ClassNotFoundException {
    StaxEventItemReader<Airport> reader = new StaxEventItemReader<>();
    reader.setResource(new ClassPathResource("AirportCodes.xml"));
    reader.setFragmentRootElementName("ReferenceDataItem");
    reader.setUnmarshaller(unmarshaller());
    return reader;
  }

  @Bean
  public XStreamMarshaller unmarshaller() throws ClassNotFoundException {
    XStreamMarshaller unmarshal = new XStreamMarshaller();

    Map<String, Class> aliases = new HashMap<String, Class>();
    aliases.put("ReferenceDataItem", Airport.class);
    unmarshal.setAliases(aliases);
    unmarshal.setConverters(aptConverter);
    return unmarshal;
  }

  @Bean
  public MongoItemWriter<Airport> writer() {
    MongoItemWriter<Airport> writer = new MongoItemWriter<>();
    writer.setTemplate(mongoTemplate);
    writer.setCollection("airports");
    return writer;
  }
}
