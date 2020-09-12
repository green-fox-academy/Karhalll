package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication implements CommandLineRunner {

  private final PostRepository postRepository;

  @Autowired
  public RedditApplication(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
//    postRepository.save(new Post("The Old Ugly Reddit", "https://www.reddit.com/"));
//    postRepository.save(new Post("Green Fox Academy Iceage Git Repo", "https://github.com/green-fox-academy/prg-iceage-syllabus"));
//    postRepository.save(new Post("Roumenuv roaming memes", "https://www.rouming.cz/"));
//    postRepository.save(new Post("Java Spring Cheatsheet", "https://files.jrebel.com/pdf/zt_java8_streams_cheat_sheet.pdf"));
//    postRepository.save(new Post("Oh Shit, Git!?!", "https://ohshitgit.com/"));
//    postRepository.save(new Post("MySql Cheatsheet", "https://gist.github.com/bradtraversy/c831baaad44343cc945e76c2e30927b3"));
  }
}
