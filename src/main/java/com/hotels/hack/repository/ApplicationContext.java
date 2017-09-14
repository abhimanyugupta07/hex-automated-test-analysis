package com.hotels.hack.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;

@org.springframework.context.annotation.Configuration
public class ApplicationContext {
  @Bean
  public MongoTemplate mongoTemplate(Mongo mongo) {
    return new MongoTemplate(mongo, "hcom_hack");
  }
}
