package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.history.HistoryAction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryActionRepo extends JpaRepository<HistoryAction, Long> {
  List<HistoryAction> findTop5ByFoxNameOrderByDateDesc(String name);
}
