package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepository;
import com.greenfoxacademy.reddit.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository,
                         UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void create(String title, String url, String username) {
    Post postToStore = new Post(title, url);
    postToStore.setUser(userRepository.findFirstByUsername(username));
    postRepository.save(postToStore);
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
