package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.Trick;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrickRepo extends JpaRepository<Trick, Long> {
}
