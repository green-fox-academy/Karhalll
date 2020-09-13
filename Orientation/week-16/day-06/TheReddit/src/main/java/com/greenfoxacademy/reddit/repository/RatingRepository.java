package com.greenfoxacademy.reddit.repository;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
  Rating findByPostAndUserUsername(Post post, String username);
}
