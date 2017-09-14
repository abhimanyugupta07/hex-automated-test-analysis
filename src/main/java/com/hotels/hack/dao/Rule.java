package com.hotels.hack.dao;

public class Rule {
  private String ruleName;
  private String status;

  public Rule(String ruleName, String status) {
    this.ruleName = ruleName;
    this.status = status;
  }

  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
