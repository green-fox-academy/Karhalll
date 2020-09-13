package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import java.util.List;

public interface PostService {
  void create(String title, String url, String username);
  int pagesOf10Count();
  List<Post> getNPageOf10SortedByScoreDesc(Integer page);
  void ratePostAsUser(Integer rating, Long postId, String username);
}
