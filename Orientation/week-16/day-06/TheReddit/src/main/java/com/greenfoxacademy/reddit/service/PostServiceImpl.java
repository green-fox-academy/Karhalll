package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  PostRepo postRepo;

  public PostServiceImpl(PostRepo postRepo) {
    this.postRepo = postRepo;
  }

  @Override
  public void create(Post newPost) {
    postRepo.save(newPost);
  }

  @Override
  public void create(String title, String url) {
    create(new Post(title, url));
  }

  @Override
  public List<Post> getAllSortedByScoreDesc() {
    return postRepo.getAllByOrderByScoreDesc();
  }

  @Override
  public void addScore(Long id, Integer scoreToAdd) {
    Post postToChange = postRepo.getOne(id);
    postToChange.setScore(postToChange.getScore() + scoreToAdd);
    postRepo.save(postToChange);
  }
}
