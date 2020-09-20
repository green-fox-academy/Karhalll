package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.dto.Entries;

public interface LogService {

  void logParamAction(String endpoint, String paramName, Object paramValue);
  void log2ParamsAction(String endpoint, String paramNameOne, Object paramValueOne,
                               String paramNameTwo, String paramValueTwo);
  Entries entries();
}
