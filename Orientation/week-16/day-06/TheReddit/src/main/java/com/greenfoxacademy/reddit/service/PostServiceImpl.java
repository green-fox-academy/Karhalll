package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public void create(String title, String url) {
    postRepository.save(new Post(title, url));
  }

  @Override
  public int pagesOf10Count() {
    return ((int)postRepository.count()/10);
  }

  @Override
  public List<Post> getNPageOf10SortedByScoreDesc(Integer page) {
    return postRepository.getAllByOrderByScoreDesc(PageRequest.of(page,10));
  }

  @Override
  public void addScore(Long id, Integer scoreToAdd) {
    Post postToChange = postRepository.getOne(id);
    postToChange.setScore(postToChange.getScore() + scoreToAdd);
    postRepository.save(postToChange);
  }
}
