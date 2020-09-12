package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.service.PostService;
import com.greenfoxacademy.reddit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{username}")
public class RedditController {

  private final PostService postService;
  private final UserService userService;

  @Autowired
  public RedditController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping({"/", "/{page}"})
  public String showTrendingPosts(@PathVariable String username, @PathVariable(required = false) Integer page, Model model) {
    if (page == null) page = 0;

    model.addAttribute("posts", postService.getNPageOf10SortedByScoreDesc(page));
    model.addAttribute("page", page);
    model.addAttribute("pagesCount", postService.pagesOf10Count());
    return checkUserAndLoadPage("trending-posts", username);
  }

  @GetMapping("/submit")
  public String showNewPostPage(@PathVariable String username) {
    return checkUserAndLoadPage("new-post", username);
  }

  @PostMapping("/submit")
  public String submitNewPost(@PathVariable String username, String title, String url) {
    postService.create(title, url, username);
    return checkUserAndLoadPage("redirect:/" + username + "/", username);
  }

  @PostMapping("/{page}/vote/{id}")
  public String voteForPost(@PathVariable String username, @PathVariable Integer page, @PathVariable Long id, Integer vote) {
    postService.addScore(id, vote);
    return checkUserAndLoadPage("redirect:/"+ username + "/" + page, username);
  }

  private String checkUserAndLoadPage(String pageToLoad, String username) {
    if (userService.isAlreadyUser(username)) {
      return pageToLoad;
    } else {
      return "redirect:/login";
    }
  }
}
