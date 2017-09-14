package com.hotels.hack.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class Experiment {

  public enum Status {
    CLOSE,
    LIVE
  }

  public enum Recommendation {
    CLOSE,
    WAITING,
    PROMOTE,
    SUCCESS,
    FAIL
  }

  @Id
  private String id;
  private String experimentCode;
  private String experimentName;
  private String variantCode;
  private String variantName;
  private Status status;
  private String startDate;
  private String visitors;
  private String purchaser;
  private Recommendation recommendation;

  private Collection<Map<String, String>> rules;

  public Experiment() {
  }

  public Experiment(String experimentCode, Recommendation recommendation, Status status) {
    super();
    this.experimentCode = experimentCode;
    this.recommendation = recommendation;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getExperimentCode() {
    return experimentCode;
  }

  public void setExperimentCode(String experimentCode) {
    this.experimentCode = experimentCode;
  }

  public String getExperimentName() {
    return experimentName;
  }

  public void setExperimentName(String experimentName) {
    this.experimentName = experimentName;
  }

  public String getVariantCode() {
    return variantCode;
  }

  public void setVariantCode(String variantCode) {
    this.variantCode = variantCode;
  }

  public String getVariantName() {
    return variantName;
  }

  public void setVariantName(String variantName) {
    this.variantName = variantName;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getVisitors() {
    return visitors;
  }

  public void setVisitors(String visitors) {
    this.visitors = visitors;
  }

  public String getPurchaser() {
    return purchaser;
  }

  public void setPurchaser(String purchaser) {
    this.purchaser = purchaser;
  }

  public Recommendation getRecommendation() {
    return recommendation;
  }

  public void setRecommendation(Recommendation recommendation) {
    this.recommendation = recommendation;
  }

  public Collection<Map<String, String>> getRules() {
    return rules;
  }

  public void setRules(Collection<Map<String, String>> rules) {
    this.rules = rules;
  }

}
