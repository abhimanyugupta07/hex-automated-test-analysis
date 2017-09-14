package com.hotels.hack.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotels.hack.dao.Experiment;
import com.hotels.hack.dao.Experiment.Recommendation;
import com.hotels.hack.dao.Summary;
import com.hotels.hack.repository.ExperimentRepository;

@Controller
@RequestMapping("/variants")
public class VariantNameController {
  @Autowired
  private ExperimentRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public Set<String> findAll() {
    Set<String> variantNames = new HashSet<>();
    for (Experiment experiment : repository.findAll()) {
      variantNames.add(experiment.getVariantCode());
    }
    return variantNames;
  }

  @RequestMapping("/summary")
  public @ResponseBody
  Object getSummary() throws InterruptedException {
    Map<String, List<Summary>> variantNames = new HashMap<>();
    List<Summary> list = new ArrayList<>();
    for (Experiment experiment : repository.findAll()) {
      if ((experiment.getRecommendation() == Experiment.Recommendation.CLOSE)
          || experiment.getRecommendation() == Experiment.Recommendation.PROMOTE) {
        Summary summary = new Summary(experiment.getVariantCode(), experiment.getRecommendation());
        list.add(summary);
      }
    }
    variantNames.put("variants", list);
    return variantNames;
  }

  @RequestMapping("/rules")
  public @ResponseBody
  Object rulesByExperimentCode(@RequestParam(value = "code", required = true) String code) {
    Map<String, Collection<Map<String, String>>> allRules = new HashMap<>();
    Experiment experiment = repository.findByVariantCode(code);
    Collection<Map<String, String>> rules = experiment.getRules();
    List<Map<String, String>> result = new ArrayList<>();
    for (Map<String, String> rule : rules) {
      Map<String, String> temp = new HashMap<>();
      for (Entry<String, String> entry : rule.entrySet()) {
        Recommendation status = Recommendation.FAIL;
        if (entry.getValue().equals("Long Running Test")) {
          LocalDate currentDate = new LocalDate();
          LocalDate startDate = LocalDate.parse(experiment.getStartDate());
          int days = Days.daysBetween(startDate, currentDate).getDays();
          if (days >= 90) {
            status = Recommendation.values()[(int) Math.random() * 5];
          }
          temp.put(entry.getKey(), "Long Running Test");
          temp.put("status", status.name());
        } else if (entry.getValue().equals("Conversion Rate Comparison")) {
          double visitors = Double.parseDouble(experiment.getVisitors());
          double purchaser = Double.parseDouble(experiment.getPurchaser());
          double cvr = purchaser * 100 / visitors;
          if (cvr < 2) {
            status = Recommendation.FAIL;
          } else if (cvr < 5) {
            status = Recommendation.SUCCESS;
          } else {
            status = Recommendation.values()[(int) Math.random() * 2 + 3];
          }
          temp.put(entry.getKey(), "Conversion Rate Comparison");
          temp.put("status", status.name());
        }
      }
      result.add(temp);
    }
    allRules.put("rules", result);
    return allRules;
  }
}