package com.hotels.hack.dao;

import com.hotels.hack.dao.Experiment.Recommendation;

public class Summary {
  private String variantCode;
  private Recommendation recommendation;

  public Summary(String variantCode, Recommendation recommendation) {
    this.variantCode = variantCode;
    this.recommendation = recommendation;
  }

  public String getVariantCode() {
    return variantCode;
  }

  public void setVariantCode(String variantCode) {
    this.variantCode = variantCode;
  }

  public Recommendation getRecommendation() {
    return recommendation;
  }

  public void setRecommendation(Recommendation recommendation) {
    this.recommendation = recommendation;
  }

}
