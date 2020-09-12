package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedditController {

  private final PostService postService;

  @Autowired
  public RedditController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping({"", "/", "/{page}"})
  public String showTrendingPosts(@PathVariable(required = false) Integer page, Model model) {
    if (page == null) page = 0;

    model.addAttribute("posts", postService.getNPageOf10SortedByScoreDesc(page));
    model.addAttribute("page", page);
    model.addAttribute("pagesCount", postService.pagesOf10Count());
    return "trending-posts";
  }

  @GetMapping("/submit")
  public String showNewPostPage() {
    return "new-post";
  }

  @PostMapping("/submit")
  public String submitNewPost(String title, String url) {
    postService.create(title, url);
    return "redirect:/";
  }

  @PostMapping("/{page}/vote/{id}")
  public String voteForPost(@PathVariable Integer page, @PathVariable Long id, Integer vote) {
    postService.addScore(id, vote);
    return "redirect:/" + page;
  }
}
