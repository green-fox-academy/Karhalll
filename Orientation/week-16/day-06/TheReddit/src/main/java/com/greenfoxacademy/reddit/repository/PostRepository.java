package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> getAllByOrderByScoreDesc(Pageable pageable);
}
