package com.greenfoxacademy.reddit.service;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.model.Rating;
import com.greenfoxacademy.reddit.repository.RatingRepository;
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
  private final RatingRepository ratingRepository;

  @Autowired
  public PostServiceImpl(PostRepository postRepository,
                         UserRepository userRepository,
                         RatingRepository ratingRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
    this.ratingRepository = ratingRepository;
  }

  @Override
  public void create(String title, String url, String username) {
    Post postToStore = new Post(title, url);
    postToStore.setUser(userRepository.findFirstByUsername(username));
    postRepository.save(postToStore);
  }

  @Override
  public int pagesOf10Posts() {
    return ((int)postRepository.count()/10);
  }

  @Override
  public List<Post> getNPageOf10SortedByScoreDesc(Integer page) {
    return postRepository.getAllByOrderByScoreDesc(PageRequest.of(page,10));
  }

  @Override
  public void ratePostAsUser(Integer userRating, Long postId, String username) {
    Post post = postRepository.getOne(postId);
    Rating ratingToRate = changeOrCreateRating(userRating, post, username);

    post.setScore(post.getScore() + ratingToRate.getRating());

    ratingRepository.save(ratingToRate);
  }

  private Rating changeOrCreateRating(Integer userRating, Post post, String username) {
    Rating ratingToRate =  ratingRepository.findByPostAndUserUsername(post, username);

    if (ratingToRate == null) {
      ratingToRate = new Rating(userRating, post, userRepository.findFirstByUsername(username));
    } else {
      post.setScore(post.getScore() - ratingToRate.getRating());
      ratingToRate.setRating(userRating);
    }

    return ratingToRate;
  }
}
