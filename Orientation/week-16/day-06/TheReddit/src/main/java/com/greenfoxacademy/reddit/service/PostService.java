package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;

public interface PostService {
  void create(String title, String url);
  int postsPages();
  List<Post> getFirst10SortedByScoreDesc();
  List<Post> getNPageOf10SortedByScoreDesc(Integer page);
  void addScore(Long id, Integer scoreToAdd);
}
