package com.hotels.hack.common;

public class RestPreconditions {
  public static <T> T checkFound(T resource) {
    if (resource == null) {
      throw new ExperimentCodeNotFoundException();
    }
    return resource;
  }
}
