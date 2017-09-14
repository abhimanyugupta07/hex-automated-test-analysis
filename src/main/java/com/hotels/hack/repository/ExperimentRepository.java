package com.hotels.hack.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotels.hack.dao.Experiment;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {
  public List<Experiment> findByExperimentCode(String experimentCode);

  public Experiment findByVariantCode(String variantCode);

  public Collection<Map<String, String>> rules(String experimentCode);
}