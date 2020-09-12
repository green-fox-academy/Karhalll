package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;

public interface PostService {
  void create(Post newPost);
  void create(String title, String url);
  List<Post> getAllSortedByScoreDesc();
  void addScore(Long id, Integer scoreToAdd);
}
