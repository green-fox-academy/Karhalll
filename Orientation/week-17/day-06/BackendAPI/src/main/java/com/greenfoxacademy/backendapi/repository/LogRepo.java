package com.greenfoxacademy.backendapi.repository;

import com.greenfoxacademy.backendapi.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log, Integer> {
}
