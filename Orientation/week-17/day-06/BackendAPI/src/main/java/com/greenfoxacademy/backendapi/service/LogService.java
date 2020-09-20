package com.greenfoxacademy.backendapi.service;

public interface LogService {

  void logParamAction(String endpoint, String paramName, Object paramValue);
  void log2ParamsAction(String endpoint, String paramNameOne, Object paramValueOne,
                               String paramNameTwo, String paramValueTwo);
}
