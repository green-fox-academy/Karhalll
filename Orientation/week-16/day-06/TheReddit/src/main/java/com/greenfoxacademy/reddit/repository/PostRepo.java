package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
  List<Post> getAllByOrderByScoreDesc();
}
