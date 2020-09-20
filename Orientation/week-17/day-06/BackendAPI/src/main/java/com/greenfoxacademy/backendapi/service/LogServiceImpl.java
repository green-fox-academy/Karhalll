package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.model.Log;
import com.greenfoxacademy.backendapi.repository.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

  private final LogRepo logRepo;

  @Autowired
  public LogServiceImpl(LogRepo logRepo) {
    this.logRepo = logRepo;
  }

  @Override
  public void logParamAction(String endpoint, String paramName, Object paramValue) {
    String data;
    if (paramValue == null) {
      data = "param not provided";
    } else {
      data = paramName + "=" + paramValue.toString();
    }

    logRepo.save(new Log(endpoint, data));
  }

  @Override
  public void log2ParamsAction(String endpoint, String paramNameOne, Object paramValueOne,
                               String paramNameTwo, String paramValueTwo) {
    String data;
    if (paramValueOne == null || paramValueTwo == null) {
      data = "incomplete data provided";
    } else {
      data = paramNameOne + "=" + paramValueOne.toString() + ";" + paramNameTwo + "=" + paramValueTwo;
    }

    logRepo.save(new Log(endpoint, data));

  }
}
