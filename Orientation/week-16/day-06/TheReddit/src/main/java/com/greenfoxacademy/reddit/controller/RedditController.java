package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedditController {

  PostService postService;

  public RedditController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping({"", "/"})
  public String trendingPosts(Model model) {
    model.addAttribute("posts", postService.getAllSortedByScoreDesc());
    return "trending-posts";
  }

  @GetMapping("/submit")
  public String newPostPage() {
    return "new-post";
  }

  @PostMapping("/submit")
  public String submitNewPost(@RequestParam String title, @RequestParam String url) {
    postService.create(title, url);
    return "redirect:/";
  }

  @GetMapping("/vote/{id}/{vote}")
  public String voteForPost(@PathVariable Long id, @PathVariable Integer vote) {
    postService.addScore(id, vote);
    return "redirect:/";
  }
}
