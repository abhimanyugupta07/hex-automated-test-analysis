package com.hotels.hack.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotels.hack.dao.Experiment;
import com.hotels.hack.repository.ExperimentRepository;

@Controller
@RequestMapping("/experiments")
public class ExperimentNameController {

  @Autowired
  private ExperimentRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public Set<String> findAll() {
    Set<String> experimentNames = new HashSet<>();

    for (Experiment experiment : repository.findAll()) {
      experimentNames.add(experiment.getExperimentCode());
    }
    return experimentNames;
  }

}
