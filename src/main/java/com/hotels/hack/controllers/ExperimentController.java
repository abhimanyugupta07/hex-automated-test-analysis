package com.hotels.hack.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotels.hack.common.RestPreconditions;
import com.hotels.hack.dao.Experiment;
import com.hotels.hack.repository.ExperimentRepository;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {

  @Autowired
  private ExperimentRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public List<Experiment> findAll() {
    return repository.findAll();
  }

  @RequestMapping("/find")
  public @ResponseBody
  Object byExperimentCode(@RequestParam(value = "code", required = true) String code) {
    List<Experiment> variants = RestPreconditions.checkFound(repository.findByExperimentCode(code));
    Map<String, List<Experiment>> variantsAsMap = new HashMap<>();

    variantsAsMap.put("variants", variants);
    return variantsAsMap;
  }

  @RequestMapping("/rules")
  public @ResponseBody
  Object rulesByExperimentCode(@RequestParam(value = "code", required = true) String code) {
    Map<String, Collection<Map<String, String>>> allRules = new HashMap<>();

    List<Experiment> experiment = repository.findByExperimentCode(code);
    allRules.put("rules", experiment.get(0).getRules());
    return allRules;
  }

  @RequestMapping("/execute")
  public @ResponseBody
  Object executeRecommendation(@RequestParam(value = "code", required = false) String code) throws InterruptedException {
    Thread.sleep(2000);

    Map<String, String> status = new HashMap<>();

    status.put("status", "Recommendations Applied Successfully");

    return status;
  }

  // @RequestMapping("/add")
  // public @ResponseBody Object addRulesForExperiment(
  // @RequestParam(value = "code", required = true) String code,
  // @RequestParam(value = "rules", required = true) List<String> newRules) {
  // Experiment experiment = repository.findByExperimentCode(code);
  //
  // Collection<Rule> oldRules = experiment.getRules();
  //
  // Set<String> allRules = new HashSet<>();
  // if (oldRules != null) {
  // allRules.addAll(oldRules);
  // }
  // allRules.addAll(newRules);
  // experiment.setRules(allRules);
  //
  // RestPreconditions.checkFound(repository.findByExperimentCode(code));
  // repository.save(experiment);
  //
  // return experiment;
  // }
  //
  // @RequestMapping("/remove")
  // public @ResponseBody Object removeRulesForExperiment(
  // @RequestParam(value = "code", required = true) String code,
  // @RequestParam(value = "rules", required = true) List<String> rulesToRemove) {
  // Experiment experiment = repository.findByExperimentCode(code);
  //
  // Collection<String> oldRules = experiment.getRules();
  //
  // Set<String> allRules = new HashSet<>();
  // if (oldRules != null) {
  // allRules.addAll(oldRules);
  // }
  // allRules.removeAll(rulesToRemove);
  // experiment.setRules(allRules);
  //
  // RestPreconditions.checkFound(repository.findByExperimentCode(code));
  // repository.save(experiment);
  //
  // return experiment;
  // }
}
